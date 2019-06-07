package edu.handong.analysis;

import java.util.ArrayList;

import edu.handong.analysis.datamodel.Course;
import edu.handong.analysis.datamodel.Student;

public class HGUCoursePatternAnalyzer {
	
	String[] lines = {	"1999-1, JC Nam, Java Programming",
						"1999-2, JC Nam, Programming Language Theory",
						"1999-1, JC Nam, Data Structures",
						"2001-1, JC Nam, Database Systems",
						"2018-1, SB Lim, Java Programming",
						"2018-2, SB Lim, Programming Language Theory",
						"2019-1, SB Lim, Data Structures",
						"2019-1, SB Lim, Algorithm Analysis",
						"2018-1, SJ Kim, Java Programming",
						"2018-2, SJ Kim, Programming Language Theory",
						"2019-1, SJ Kim, Logic Design",
						"2019-1, SJ Kim, Algorithm Analysis",
						};

	private int numOfStudents;
	private int numOfCourses;
	private ArrayList<Student> students;
	private ArrayList<Course> courses;

	
	/**
	 * This method runs our analysis logic to get the list of student and course names from lines.
	 * @param args
	 */
	public void run(String[] args) {
		
		numOfStudents = Integer.parseInt(args[0]);
		numOfCourses = Integer.parseInt(args[1]);
	
		students = initiateStudentArrayFromLines(lines);
		
		System.out.println("Number of All Students: " + numOfStudents);
		for(Student student: students) {
			System.out.println(student.getName());
		}
		
		courses = initiateCourseArrayFromLines(lines);
		System.out.println("Number of All Courses: " + numOfCourses);
		for(Course course: courses) {
			System.out.println(course.getCourseName());
		}
		
	}

	/**
	 * This method returns a Student array to initiate the field, students, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Student> initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int numOfLines = lines.length;
		int i = 0 , j = 0;
		
		// line�� ������ �����ش�.		
		String[] splitLine = new String[numOfLines];
		
		// �߶� �迭�� �־��ش�. trim����
		for(String line : lines) {
			splitLine[i++] = line.split(",")[1].trim();
		}
		// �̸��� �� ��ġ�°� �ִ��� Ȯ���ؾ��� �Ȱ�ġ�� �͸� realStudents�� �ְ� return
		ArrayList<Student> tempStudents = new ArrayList<Student>(numOfLines);
		ArrayList<Student> realStudents = new ArrayList<Student>(numOfStudents);
		// �ϴ� tempStudents�� line �� ��ŭ �� �ִ´�
		for(i=0;i<numOfLines;i++) {
			Student student = new Student(splitLine[i]);
			tempStudents.add(student);
		}
		// array �ε��� ������ �߻����� �������� -1 ���� ������ ++z �� (-1, 0, 1, 2)
		int z=-1;
		for(i=0;i<numOfLines;i++) {
			if(!studentExist(realStudents,tempStudents.get(i))) {
				Student student = new Student(tempStudents.get(i).getName());
				realStudents.add(student);
			}
		}
		return realStudents;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param realStudents
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(ArrayList<Student> realStudents, Student student) {
		
		// TODO: implement this method
		for(Student item : realStudents) {
			// item �� null �϶��� ���ϸ� �ȵǰ�, == �� ���ϸ� �ּҰ� ���ϴ°Ŷ� ���X , equals��
			if((item!=null) && item.getName().equals(student.getName())==true) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * This method returns a Course array to initiate the field, courses, from lines.
	 * @param lines
	 * @return
	 */
	private ArrayList<Course> initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int numOfLines = lines.length;
		int i = 0 ;
		
		String[] splitLine = new String[numOfLines];
		
		// �߶� �迭�� �־��ش�.
		for(String line : lines) {
			splitLine[i++] = line.split(",")[2].trim();
		}
		
		// line �� ��ŭ �� �־��� Course array
		ArrayList<Course> tempCourses = new ArrayList<Course>(numOfLines);
		// numOfCourses��ŭ�� �� Course array
		ArrayList<Course> realCourses = new ArrayList<Course>(numOfCourses);
		
		for(i=0;i<numOfLines;i++) {
			Course course = new Course(splitLine[i]);
			tempCourses.add(course);
		}
		for(i=0;i<numOfLines;i++) {
			if(!courseExist(realCourses,tempCourses.get(i))) {
				Course course = new Course(tempCourses.get(i).getCourseName());
				realCourses.add(course);
			}
		}
		return realCourses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param realCourses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(ArrayList<Course> realCourses, Course course) {
		
		// TODO: implement this method
		for(Course item : realCourses) {
			if((item!=null) && item.getCourseName().equals(course.getCourseName())==true) {
				return true;
			}
		}
		return false;
	}

}
