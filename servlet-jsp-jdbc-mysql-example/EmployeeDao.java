package net.javaguide.jsp.jdbc.database;

import java.sql.*;
import net.javaguide.jsp.jdbc.bean.Employee;

public class EmployeeDao {
	public int registerEmployee(Employee emp) throws ClassNotFoundException {
		String INSERT_USER_SQL="INSERT INTO employee"+"(id,first_name,last_name,username,password,address,contact) VALUES"+"(?,?,?,?,?,?,?);";
		int res=0;
		Class.forName("com.mysql.jdbc.Driver");
		try {
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/mysql_database","root","sHj@6378#jw");
			PreparedStatement ps=con.prepareStatement(INSERT_USER_SQL);
			ps.setInt(1,1);
			ps.setString(2,emp.getFirstName());
			ps.setString(3,emp.getLastName());
			ps.setString(4,emp.getUserName());
			ps.setString(5,emp.getPassword());
			ps.setString(6,emp.getAddress());
			ps.setString(7,emp.getContact());
			res=ps.executeUpdate();
			
		}catch (Exception e) {
            // process sql exception
            e.printStackTrace();
        }
		return res;
	}
	private void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }
}
