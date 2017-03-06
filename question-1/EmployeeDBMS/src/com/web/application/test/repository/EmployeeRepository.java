package com.web.application.test.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.web.application.test.model.Employee;
import com.web.application.test.util.DbUtil;

public class EmployeeRepository {
	private Connection dbConnection;
	
	public EmployeeRepository() {
		dbConnection = DbUtil.getConnection();
	}
	
	public void save(String userName, String password, String firstName, String lastName, String email, Integer phoneno , String location) {
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("insert into employee(userName, password, firstName, lastName, emailAddress,phoneno,location) values (?, ?, ?, ?, ?, ?,?)");
			prepStatement.setString(1, userName);
			prepStatement.setString(2, password);
			prepStatement.setString(3, firstName);
			prepStatement.setString(4, lastName);
			prepStatement.setString(5, email);
			prepStatement.setInt(6, phoneno);
			prepStatement.setString(7, location);
			
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public boolean findByUserName(String userName) {
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("select count(*) from employee where userName = ?");
			prepStatement.setString(1, userName);	
						
			ResultSet result = prepStatement.executeQuery();
			if (result != null) {	
				while (result.next()) {
					if (result.getInt(1) == 1) {
						return true;
					}				
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean findByLogin(String userName, String password) {
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("select password from employee where userName = ?");
			prepStatement.setString(1, userName);			
			
			ResultSet result = prepStatement.executeQuery();
			if (result != null) {
				while (result.next()) {
					if (result.getString(1).equals(password)) {
						return true;
					}
				}				
			}			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}
	
	public List<Employee> getAll() {
		List<Employee> stList=null;
		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("select firstName,lastName,emailAddress,phoneno,location,userName from employee");	
			
			stList = new ArrayList<Employee>();
			ResultSet result = prepStatement.executeQuery();
			if (result != null) {	
				while (result.next()) {
					Employee st = new Employee();
					st.setFirstName(result.getString(1));
					st.setLastName(result.getString(2));
					st.setEmailAddress(result.getString(3));
					st.setPhoneNumber(result.getInt(4));
					st.setLocation(result.getString(5));
					st.setUserName(result.getString(6));
					stList.add(st);
					
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return stList;
	}
	
	
	public void updateEmployee(String firstName, String lastName, String emailAddress , Integer phoneNumber , String location,String userName){

		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("update employee set firstName="+"'"+firstName+"'"+",lastName="+"'"+lastName+"'"+",emailAddress="+"'"+emailAddress+"'"+",phoneno="+phoneNumber+",location="+"'"+location+"'"+" where username="+"'"+userName+"'");;	
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	public void deleteEmployee(String userName){

		try {
			PreparedStatement prepStatement = dbConnection.prepareStatement("delete from employee where username="+"'"+userName+"'");;	
			prepStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	
		
	}
	
	

}
