package usermanagement.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import usermanagement.dto.UserRequestDTO;
import usermanagement.dto.UserResponseDTO;

public class UserDAO {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	
	public void insertUser(UserRequestDTO dto) {
		String sql="INSERT INTO user(user_id,user_name,user_email,user_country)"+
					"values(?,?,?,?)";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,dto.getUserId());
			ps.setString(2,dto.getUserName());
			ps.setString(3,dto.getUserEmail());
			ps.setString(4,dto.getUserCountry());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateUser(UserRequestDTO dto) {
		String sql="UPDATE user SET user_name=?,user_email=?,user_country=?"+"WHERE user_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,dto.getUserName());
			ps.setString(2,dto.getUserEmail());
			ps.setString(3,dto.getUserCountry());
			ps.setString(4,dto.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteUser(UserRequestDTO dto) {
		String sql="DELETE from user WHERE user_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1,dto.getUserId());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public UserResponseDTO selectOne(UserRequestDTO dto) {
		UserResponseDTO res=new UserResponseDTO();
		String sql="SELECT * FROM user WHERE user_id=?";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ps.setString(1, dto.getUserId());
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				res.setUserId(rs.getString("user_id"));
				res.setUserName(rs.getString("user_name"));
				res.setUserEmail(rs.getString("user_email"));
				res.setUserCountry(rs.getString("user_country"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return res;
	}
	
	public ArrayList<UserResponseDTO> selectAll(){
		ArrayList<UserResponseDTO> list=new ArrayList<>();
		String sql="SELECT * FROM user";
		try {
			PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while (rs.next()) {
				UserResponseDTO res=new UserResponseDTO();
				res.setUserId(rs.getString("user_id"));
				res.setUserName(rs.getString("user_name"));
				res.setUserEmail(rs.getString("user_email"));
				res.setUserCountry(rs.getString("user_country"));
				list.add(res);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
}
