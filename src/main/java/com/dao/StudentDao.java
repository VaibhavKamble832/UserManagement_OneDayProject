package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.dbConnect.DBConnection;
import com.pojo.Student;

public class StudentDao {

	Connection con = DBConnection.getConnection();

	public boolean registerStudent(Student s) {
		String sql = "insert into students(name, contact, email, password) values(?,?,?,?)";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getContact());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());

			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}



	public Student loginStudent(String email, String password) {
		String sql = "select * from students where email=? and password=?";
		Student s = null;

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setContact(rs.getString("contact"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));

			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}


	public List<Student> getAllStudents(){
		String sql = "select * from students";
		List<Student> slist = new ArrayList<Student>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setContact(rs.getString("contact"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));

				slist.add(s);
			}
			return slist;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 

	public boolean deleteStudent(int id) {
		String sql = "delete from students where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);

			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public Student getStudentById(int id) {
		String sql = "select * from students where id=?";

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, id);
			Student s = new Student();
			ResultSet rs = ps.executeQuery();
		
			while(rs.next()) {
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setContact(rs.getString("contact"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));
			}
			return s;
		}
		catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	public boolean updateStudent(Student s) {
		String sql = "update students set name=?, contact=?, email=?, password=? where id=?";
		
		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, s.getName());
			ps.setString(2, s.getContact());
			ps.setString(3, s.getEmail());
			ps.setString(4, s.getPassword());
			ps.setInt(5, s.getId());
			
			int i = ps.executeUpdate();
			if(i>0) {
				return true;
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}


	public List<Student> searchStudents(String name){
		String sql = "select * from students where name like '%"+name+"%'";
		List<Student> slist = new ArrayList<Student>();

		try {
			PreparedStatement ps = con.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();

			while(rs.next()) {
				Student s = new Student();
				s.setId(rs.getInt("id"));
				s.setName(rs.getString("name"));
				s.setContact(rs.getString("contact"));
				s.setEmail(rs.getString("email"));
				s.setPassword(rs.getString("password"));

				slist.add(s);
			}
			return slist;
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	} 
	
	
	
	
	
	
}
