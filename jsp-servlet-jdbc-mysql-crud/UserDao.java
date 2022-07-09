package net.javaguide.usermanagement.dao;

import java.sql.*;
import net.javaguides.usermanagement.model.User;
import java.util.ArrayList;
import java.util.List ;

public class UserDao {
	private static final String INSERT_USER="INSERT INTO users"+"(name,email,country)VALUES"+"(?,?,?);";
	private static final String SELECT_USER_BY_ID="select id,name,email,country from users where id=?";
	private static final String SELECT_USER="select * from users";
	private static final String DELETE_USER="delete from user where id=?";
	private static final String UPDATE_USERS_SQL = "update users set name = ?,email= ?, country =? where id = ?;";
	
	public UserDao() {}
	
	protected Connection getConnection() {
		Connection connection=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/demo","root","sHj@6378#jw");
		} catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
	}
	
	public void insertUser(User user) throws SQLException{
		try {
			Connection connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(INSERT_USER);
			ps.setString(1,user.getName());
			ps.setString(2, user.getEmail());
			ps.setString(3,user.getCountry());
			ps.executeUpdate();
		} catch (SQLException e) {
            e.printStackTrace();
        }
	}
	
	public User selectUser(int id) {
		User user=null;
		try {
			Connection connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(SELECT_USER_BY_ID);
			ps.setInt(1,id);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				String n=rs.getString("name");
				String e=rs.getString("email");
				String c=rs.getString("country");
				user=new User(id,n,e,c);
			}
		}catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public List<User> selectAllUser(){
		List<User> users=new ArrayList<>();
		try {
			Connection connection=getConnection();
			PreparedStatement ps=connection.prepareStatement(SELECT_USER);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				int i=rs.getInt("id");
				String n=rs.getString("name");
				String e=rs.getString("email");
				String c=rs.getString("country");
				users.add(new User(i,n,e,c));
			}
		}catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
	}
	
	public boolean deleteUser(int id) throws SQLException {
        boolean rowDeleted;
        
        	Connection connection = getConnection(); 
        	PreparedStatement statement = connection.prepareStatement(DELETE_USER);
        	statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        
        return rowDeleted;
    }
	
	 public boolean updateUser(User user) throws SQLException {
	        boolean rowUpdated;
	        try (Connection connection = getConnection(); PreparedStatement statement = connection.prepareStatement(UPDATE_USERS_SQL);) {
	            statement.setString(1, user.getName());
	            statement.setString(2, user.getEmail());
	            statement.setString(3, user.getCountry());
	            statement.setInt(4, user.getId());

	            rowUpdated = statement.executeUpdate() > 0;
	        }
	        return rowUpdated;
	    }
}
