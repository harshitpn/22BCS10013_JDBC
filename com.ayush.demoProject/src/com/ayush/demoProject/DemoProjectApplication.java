package com.ayush.demoProject;
import java.sql.*;
import java.util.Scanner;
public class DemoProjectApplication{

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		OperationClass object = new OperationClass();
		// TODO Auto-generated method stub
          System.out.println("Yooo Harshit");
          Scanner sc = new Scanner(System.in);
          System.out.println("Enter 1 for insert record");
          System.out.println("Enter 2 for delete record");
          System.out.println("Enter 3 for update record");
          System.out.println("Enter 4 for display one record");
          System.out.println("Enter 5 for display all record");
          int reply = sc.nextInt();
          switch(reply) {
          case 1:
        	  object.insert_record();
        	  break;
          case 2:
        	  object.delete();
        	  break;
          case 3:
        	  object.update();
        	  break;
          case 4:
        	  break;
          case 5:
        	  break;
          default:
        	  System.out.println("DOne!!!!");
          }
    }
}