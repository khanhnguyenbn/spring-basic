package vn.topica.itlab4;

import org.springframework.jdbc.core.JdbcTemplate;

public class StudentDAO {
	
	private JdbcTemplate jdbcTemplate;
	
	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public void insert(Student student) {
		
		String sql = "INSERT INTO student (ID, Name, DateOfBirth, Gender) VALUES (?, ?, ?, ?)";
		jdbcTemplate.update(sql, student.getId(), student.getName(), student.getDateOfBirth(), student.getGender());
		
		System.out.println("INSERTED: " + student.toString());
		
	}
	
	

}
