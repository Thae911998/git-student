package student_registration.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_registration.models.Education;

public class EducationRepository {
	public static Connection con = null;
	static {
		con = MyConnection.getConnection();
	}
	//insert
		public int add(Education edu) {
			int result=0;
			String sql="INSERT INTO education(name) VALUES(?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, edu.getEname());
				
				
				result = ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("education insert err: " + e);
			}
			return result;
		}
		//getAll - selectAll
		public List<Education>getAll(){
			List<Education> education=new ArrayList<>();
			String sql="SELECT * FROM education";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				while(rs.next()) {
					Education edu = new Education();
					edu.setEid(rs.getInt("eid"));
					edu.setEname(rs.getString("ename"));
					education.add(edu);
					}
			}catch(SQLException e) {
				System.out.println("education select err: "+e);
			}
			return education;
			}
}
