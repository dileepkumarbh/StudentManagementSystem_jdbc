package com.student.management;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class studetndao {
	public static boolean insertStudentToDb(student st) {
		//jdbc code
		boolean f=false;
		try {
			
			Connection con= cp.createC();
			String q="insert into students(sname, sphone, scity) values(?,?,?)";
			//prepared statement
			PreparedStatement pstmt=con.prepareStatement(q);
			//set the values of parameters
			pstmt.setString(1, st.getStudentName());
			pstmt.setString(2, st.getStudentPhone());
			pstmt.setString(3, st.getStudentCity());
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//for delete

	public static boolean deleteStudent(int userId) {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			
			Connection con= cp.createC();
			String q="delete from students where sid=?";
			//prepared statement
			PreparedStatement pstmt=con.prepareStatement(q);
			//set the values of parameters
			pstmt.setInt(1, userId);
			
			
			//execute
			pstmt.executeUpdate();
			f=true;
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}

	public static void showallstudent() {
		// TODO Auto-generated method stub
		boolean f=false;
		try {
			
			Connection con= cp.createC();
			String q="select * from students;";
			//normal statement i am going to use here
			Statement stmt=con.createStatement();
			ResultSet set=stmt.executeQuery(q);
			
			while(set.next()) {
				int id=set.getInt(1);
				String name= set.getString(2);
				String phone=set.getString(3);
				String city=set.getString("scity");
				
				System.out.println("ID : "+ id);
				System.out.println("NAME : "+ name);
				System.out.println("PHONE : "+ phone);
				System.out.println("CITY : "+ city);
				System.out.println("--------------------------------------------------------");
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
	}


		
	}
