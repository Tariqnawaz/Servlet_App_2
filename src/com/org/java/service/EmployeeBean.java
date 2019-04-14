package com.org.java.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.java.database.DatabaseConnection;
import com.org.java.dto.Employee;

public class EmployeeBean {
	
	Connection conn = null;
	Statement stmt;
	ResultSet rs;
	DatabaseConnection db;
	PreparedStatement pstmt = null;
	
	
	 public void addNew(Employee e) {
	        
	        
	        try {
	        	
	        		 db = new DatabaseConnection();
	 	 			conn = db.setConnection();
	 	            pstmt = conn.prepareStatement("INSERT INTO employee(empId,empName,phone,email,salary,desig) VALUES(?,?,?,?,?,?)");
	 	            pstmt.setInt(1, e.getEmpId());
	 	            pstmt.setString(2, e.getEmpName());
	 	            pstmt.setString(3, e.getPhone());
	 	            pstmt.setString(4, e.getEmail());
	 	            pstmt.setFloat(5, e.getSalary());
	 	            pstmt.setString(6, e.getDesignation());
	 	            pstmt.execute();
	        	
	        } catch (Exception ex) {
	 
	        } finally {
	            try {
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	               // Logger.getLogger(EmployeeBean.class.getName()).log(Level.SEVERE, null, ex);
	            }
	        }
	    }
	 
	 
	    public void delete(int id) {
	        Connection conn = null;
	        Statement stmt = null;
	        try {
	        	db = new DatabaseConnection();
	 			conn = db.setConnection();
	           // Class.forName(JDBC_DRIVER);
	            //con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            stmt = conn.createStatement();
	            stmt.execute("DELETE FROM employee WHERE empId=" + String.valueOf(id));
	        } catch (Exception ex) {
	 
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                
	            }
	        }
	    }
	 
	    public void update(Employee e) {
	        
	        try {
	        	db = new DatabaseConnection();
	 			conn = db.setConnection();
	           // Class.forName(JDBC_DRIVER);
	           // con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            pstmt = conn.prepareStatement("UPDATE employee SET empName=?, phone=?, email=?, salary=?, desig=? WHERE empId=?");
	            pstmt.setString(1, e.getEmpName());
	            pstmt.setString(2, e.getPhone());
	            pstmt.setString(3, e.getEmail());
	            pstmt.setFloat(4, e.getSalary());
	            pstmt.setString(5, e.getDesignation());
	            pstmt.setInt(6, e.getEmpId());
	            pstmt.executeUpdate();
	        } catch (Exception ex) {
	 
	        } finally {
	            try {
	                if (pstmt != null) {
	                    pstmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                
	            }
	        }
	    }
	 
	    public Employee getEmployee(int id) {
	        Employee emp = null;
	        try {
	        	db = new DatabaseConnection();
	 			conn = db.setConnection();
	            //Class.forName(JDBC_DRIVER);
	            //con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE empId=" + id);
	            if (rs.next()) {
	                emp = new Employee();
	                emp.setEmpId(rs.getInt(1));
	                emp.setEmpName(rs.getString(2));
	                emp.setPhone(rs.getString(3));
	                emp.setEmail(rs.getString(4));
	                emp.setSalary(rs.getFloat(5));
	                emp.setDesignation(rs.getString(6));
	            }
	        } catch (Exception ex) {
	 
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	               
	            }
	        }
	        return emp;
	    }
	    
	    public List<Employee> getEmployees() {
	        List<Employee> list = new ArrayList<Employee>();
	        
	        try {
	        	db = new DatabaseConnection();
	 			conn = db.setConnection();
	            //Class.forName(JDBC_DRIVER);
	            //con = DriverManager.getConnection(DATABASE_URL, USERNAME, PASSWORD);
	            stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery("SELECT * FROM employee ORDER BY empId");
	            while (rs.next()) {
	                Employee emp = new Employee();
	                emp.setEmpId(rs.getInt(1));
	                emp.setEmpName(rs.getString(2));
	                emp.setPhone(rs.getString(3));
	                emp.setEmail(rs.getString(4));
	                emp.setSalary(rs.getFloat(5));
	                emp.setDesignation(rs.getString(6));
	                list.add(emp);
	            }
	        } catch (Exception ex) {
	 
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	                if (conn != null) {
	                    conn.close();
	                }
	            } catch (SQLException ex) {
	                
	            }
	        }
	        return list;
	    }
}











