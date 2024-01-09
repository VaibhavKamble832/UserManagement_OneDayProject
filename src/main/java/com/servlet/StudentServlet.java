package com.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.dao.StudentDao;
import com.pojo.Student;


@WebServlet("/StudentServlet")
public class StudentServlet extends HttpServlet {

	Student student = new Student();
	StudentDao studentDao = new StudentDao();

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();
		String action = request.getParameter("action");


		if(action!=null && action.equals("logout")) {
			session.invalidate();
			response.sendRedirect("index.jsp");
		}

		else if(action!=null && action.equals("delete")) {
			int id = Integer.parseInt(request.getParameter("id"));
			boolean b = studentDao.deleteStudent(id);
			if(b) {
				response.sendRedirect("StudentServlet"); 
			}
			else {
				response.sendRedirect("studentList.jsp"); 
			}
		}
		else if(action!=null && action.equals("edit")) {
			int id = Integer.parseInt(request.getParameter("id"));
			Student student = studentDao.getStudentById(id);
			session.setAttribute("student", student);
			response.sendRedirect("updateStudent.jsp");
		
		}
		
		
		else {
			List<Student> slist = studentDao.getAllStudents();
			session.setAttribute("slist", slist);
			response.sendRedirect("studentList.jsp");
		}

	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		String action = request.getParameter("action");
		String name = request.getParameter("name");
		String contact = request.getParameter("contact");
		String email = request.getParameter("email");
		String password = request.getParameter("password");

		student.setName(name);
		student.setContact(contact);
		student.setEmail(email);
		student.setPassword(password);


		if(action!=null && action.equals("registerStudent")) {
			boolean b = studentDao.registerStudent(student);
			if(b) {
				response.setContentType("text/html");
				out.println("<h3 style='color:green; position:absolute; right:100px; top:100px; font-size:24px'>Successfully Registered...</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
			else {
				response.setContentType("text/html");
				out.println("<h3 style='color:red; position:absolute; right:100px; top:100px; font-size:24px'>Failed to Registere...</h3>");
				RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
				rd.include(request, response);
			}
		}
		else if(action!=null && action.equals("loginStudent")) {
			Student student = studentDao.loginStudent(email, password);
			if(student!=null) {
				session.setAttribute("student", student);
				response.sendRedirect("index.jsp");
			}
			else {
				String loginMsg = "Invalid Email: '"+email+"', and '"+password+"' ";
				request.setAttribute("loginMsg", loginMsg);
				RequestDispatcher rd = request.getRequestDispatcher("login.jsp");
				rd.include(request, response);
			}
		}
		else if(action!=null && action.equals("updateStudent")) {
			int id = Integer.parseInt(request.getParameter("id"));
			student.setId(id);

			boolean b = studentDao.updateStudent(student);
			if(b) {
				response.sendRedirect("StudentServlet");
			}
			else {
				response.sendRedirect("studentList.jsp");
			}
		}
		else if(action!=null && action.equals("searchStudent")) {
			String searchName = request.getParameter("searchName");
			List<Student> studentlist = studentDao.searchStudents(searchName);
//			System.out.println("hwelloo");
//			System.out.println(studentlist);
			session.setAttribute("slist", studentlist);
			response.sendRedirect("studentList.jsp");
		}



	}

}
