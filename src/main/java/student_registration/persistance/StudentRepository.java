package student_registration.persistance;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import student_registration.models.Student;;

public class StudentRepository {
	public static Connection con=null;
	static {
		con=MyConnection.getConnection();
	}
	//crud(insert)
		public int add(Student student) {
			int result=0;
			String sql="INSERT INTO student(id,student_id,student_name,dob,gender,phone,education,course) VALUES(?,?,?,?,?,?,?,?)";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1,student.getId());
				ps.setString(2,student.getStudent_id());
				ps.setString(3,student.getStudent_name());
				ps.setString(4,student.getDob());
				ps.setString(5,student.getGender());
				ps.setString(6,student.getPhone());
				ps.setString(7,student.getEducation());
				ps.setString(8,student.getCourse());
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("student insert err: "+e);
			}
			return result;
		}
		//update
		public int edit(Student student) {
			int result=0;
			String sql="UPDATE student SET student_id=?,student_name=?,dob=?,gender=?,phone=?,education=?,course=? where id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1,student.getStudent_id());
				ps.setString(2,student.getStudent_name());
				ps.setString(3,student.getDob());
				ps.setString(4,student.getGender());
				ps.setString(5,student.getPhone());
				ps.setString(6,student.getEducation());
				ps.setString(7,student.getCourse());
				ps.setInt(8,student.getId());
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("student edit error: "+e);
			}
			return result;
		}
		//delete
		public int delete(Integer student_id) {
			int result=0;
			String sql="DELETE FROM student where student_id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setInt(1 , student_id);
				result=ps.executeUpdate();
				
			}catch(SQLException e) {
				result=0;
				System.out.println("student delete err: "+e);
			}
			return result;
		}
		//getAll
		public List<Student>getAll(){
			List<Student> students=new ArrayList<>();
			//AuthorRepository studentRepo=new AuthorRepository();
			String sql="SELECT * FROM student";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				Student student=new Student();
				student.setId(rs.getInt("id"));
				student.setStudent_id(rs.getString("student_id"));
				student.setStudent_name(rs.getString("student_name"));
				student.setDob(rs.getString("dob"));
				student.setGender(rs.getString("gender"));
				student.setPhone(rs.getString("phone"));
				student.setEducation(rs.getString("education"));
				student.setCourse(rs.getString("course"));
				
				students.add(student);
			}
			}catch(SQLException e) {
				System.out.println("student select err: "+e);
			}
			return students;
		}
		//getbycode
		public Student getById(Integer id) {
			Student student=null;//initially null
			
			String sql="SELECT * FROM student WHERE id=?";
			try {
				PreparedStatement ps=con.prepareStatement(sql);
			ps.setInt(1, id);
			ResultSet rs=ps.executeQuery();
			while(rs.next()) {
				student=new Student();
				
				student.setId(rs.getInt("id"));
				student.setStudent_id(rs.getString("student_id"));
				student.setStudent_name(rs.getString("student_name"));
				student.setDob(rs.getString("dob"));
				student.setGender(rs.getString("gender"));
				student.setPhone(rs.getString("phone"));
				student.setEducation(rs.getString("education"));
				student.setCourse(rs.getString("course"));
				
			}
			}catch(SQLException e) {
				System.out.println("student select err: "+e);
			}
			return student;
		}
}
