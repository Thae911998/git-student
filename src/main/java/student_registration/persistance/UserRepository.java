package student_registration.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_registration.models.Login;
import student_registration.models.User;

public class UserRepository {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	//crud(insert)
		public int insertUser(User user) {
			int result=0;
			String sql="INSERT INTO user(user_id,user_name,password,confirm_password,email,role) VALUES(?,?,?,?,?,?)";
			if (!checkEmail(user.getEmail())) {
				try {
					PreparedStatement ps=con.prepareStatement(sql);
					ps.setInt(1,user.getUser_id());
					ps.setString(1,user.getUser_name());
					ps.setString(2,user.getPassword());
					ps.setString(3,user.getConfirm_password());
					ps.setString(4,user.getEmail());
					ps.setString(5,user.getRole());
					result=ps.executeUpdate();
					
				}catch(SQLException e) {
					result=0;
					System.out.println("user insert err: "+e);
				}
			}
				return result;
			}
			
			
		//update
		public int updateuser(User user) {
			int result=0;
			String sql="UPDATE user SET user_name=?,password=?,confirm_password=?,email=?,role=? where user_id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,user.getUser_name());
				ps.setString(2,user.getPassword());
				ps.setString(3,user.getConfirm_password());
				ps.setString(4,user.getEmail());
				ps.setInt(5,user.getUser_id());
				
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("user edit error: "+e);
			}
			return result;
		}
		//delete
		public int deleteUserById(Integer user_id) {
			int result=0;
			String sql="DELETE FROM user where user_id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1 , user_id);
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("user delete err: "+e);
			}
			return result;
		}
		//getAll
		public List<User>getAll(){
			List<User> users=new ArrayList<>();
			//AuthorRepository studentRepo=new AuthorRepository();
			String sql="SELECT * FROM user";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				User user=new User();
				
				
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setConfirm_password(rs.getString("confirm_password"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				users.add(user);
			}
			}catch(SQLException e) {
				System.out.println("user select err: "+e);
			}
			return users;
		}
		//getbyname,password with login
		public User loginUser(Login login) {
			
			User user=null;
			
			String sql="SELECT * FROM user WHERE email=? and password=?";
			
			
			try {
			PreparedStatement ps =con.prepareStatement(sql);
			ps.setString(1, login.getEmail());
			ps.setString(2, login.getPassword());
			ResultSet rs=ps.executeQuery();
			
			while(rs.next()) {
				user=new User();
				user.setEmail(rs.getString("email"));
				user.setPassword(rs.getString("password"));
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setConfirm_password(rs.getString("confirm_password"));
				user.setRole(rs.getString("role"));
				
			}
			
			
			}catch(SQLException e) {
				System.out.println("User Select:"+e.getMessage());
		}
		
			return user;
		}
		//getbyid
		public User getById(Integer user_id) {
			User user=null;//initially null
			
			String sql="SELECT * FROM user WHERE user_id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, user_id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				user=new User();
				user.setUser_id(rs.getInt("user_id"));
				user.setUser_name(rs.getString("user_name"));
				user.setPassword(rs.getString("password"));
				user.setConfirm_password(rs.getString("confirm_password"));
				user.setEmail(rs.getString("email"));
				user.setRole(rs.getString("role"));
				
			}
			}catch(SQLException e) {
				System.out.println("user select err: "+e);
			}
			return user;
		}
		public boolean checkEmail(String UserEmail) {
			boolean status=false;
			String sql="SELECT email FROM user WHERE email=?";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,UserEmail);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					status=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("check email :"+e.getMessage());
			}
			
			return status;
		}


		
}
