package student_registration.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import student_registration.models.Course;

import java.util.ArrayList;
public class CourseRepository {
	public static Connection con=null;
		static {
			con=MyConnection.getConnection();
		}
public int InsertCourse(Course course) {
		
		int result = 0;
		
		
		if(!CourseById(course.getCourse_id())) {
			if (!checkName(course.getCourse_name()) ) {
				String sql="INSERT INTO course(course_id,course_name) value (?,?)";
				try {
					PreparedStatement ps = con.prepareStatement(sql);
					ps.setString(1, course.getCourse_id());
					ps.setString(2, course.getCourse_name());
					result = ps.executeUpdate();
							
					} catch (SQLException e) {
					System.out.println("course insert : " + e.getMessage());
				}
			}else {
				System.out.println("Name already exits!!");	
			}
		}else {
			System.out.println("CourseId already exits!!");	
		}
		
		return result;
		}

		//getbyId
		public boolean CourseById(String course_id) {
			boolean i=false;
			String sql="SELECT course_id FROM course WHERE course_id=?";
			
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,course_id);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					i=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("check CourseId :"+e.getMessage());
			}
			
			return i;
		}

		public boolean checkName(String course_name) {
			boolean status=false;
			
			String sql="SELECT course_name FROM course WHERE course_name=?";
			try {
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1,course_name);
				ResultSet rs=ps.executeQuery();
				while(rs.next()) {
					status=true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				System.out.println("check Name :"+e.getMessage());
			}
			
			return status;
		}
		
		public List<Course> getAllCourse(){
			List<Course> courseLst=new ArrayList<Course>();
			Course course=null;
			String sql="SELECT * FROM course WHERE course_id";
			try {
				PreparedStatement ps = con.prepareStatement(sql);

				ResultSet rs = ps.executeQuery();

				while (rs.next()) {
					course = new Course();
					
					course.setCourse_id(rs.getString("course_id"));
					course.setCourse_name(rs.getString("course_name"));
					courseLst.add(course);
				}

			} catch (SQLException e) {
				System.out.println("User Select : " + e.getMessage());
			}

			return courseLst;
		}

}


