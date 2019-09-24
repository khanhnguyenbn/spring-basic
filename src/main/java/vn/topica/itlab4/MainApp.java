package vn.topica.itlab4;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext context = new ClassPathXmlApplicationContext(Constant.BEANS_PATH);
		StudentDAO studentDAO = (StudentDAO) context.getBean("studentDAO");
		
		// read file csv and save to database
		BufferedReader csvReader = null;
		try {
			csvReader = new BufferedReader(new FileReader(Constant.FILE_CSV_PATH));
			String row = null;
			boolean isFirstRow = true;
			
			while ((row = csvReader.readLine()) != null) {
				
				if(isFirstRow == true) {
					isFirstRow = false;
					continue;
				}
				
			    String[] data = row.split(",");
			    int id = Integer.parseInt(data[0]);
			    String name = data[1];
			    String dateOfBirth = data[2];
			    String gender = data[3];
			    
			    Student student = new Student(id, name, dateOfBirth, gender);
			    studentDAO.insert(student);  
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				csvReader.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		
		
	}
}
