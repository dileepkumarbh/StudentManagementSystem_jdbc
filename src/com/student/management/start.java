package com.student.management;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class start {

	public static void main(String[] args)throws IOException {
		// TODO Auto-generated method stub
		System.out.println("hello world");
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		while(true) {
			System.out.println("press 1 to add student");
			System.out.println("press 2 to delete student");
			System.out.println("press 3 to display student");
			System.out.println("press 4 for exit");
			int c=Integer.parseInt(br.readLine());
			if(c==1) {
				//add student
				System.out.println("enter student name");
				String name=br.readLine();
				
				System.out.println("enter student phone");
				String phone=br.readLine();
				
				System.out.println("enter student city");
				String city=br.readLine();
				
				// creating student objects to store student
				student st=new student(name, phone, city);
				boolean answer= studetndao.insertStudentToDb(st);
				if(answer) {
					System.out.println("student are added sucessfully..");
				}else {
					System.out.println("something went wrong");
				}
				System.out.println(st);
			}
			else if(c==2) {
				//delete student
				System.out.println("enter student id to delete : ");
				int userId=Integer.parseInt(br.readLine());
				boolean f=studetndao.deleteStudent(userId); 
				if (f) {
					System.out.println("deleted...");
				}else {
					System.out.println("something went wrong");
				}
			}
			else if(c==3) {
				//display student
				studetndao.showallstudent();
			}
			else if(c==4) {
				//exit
				break;
				
			}
			else {
				
			}
	}
		//thank you message
	}
}
