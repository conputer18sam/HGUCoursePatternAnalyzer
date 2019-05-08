package edu.handong.analysis;

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

	int numOfStudents;
	int numOfCourses;
	Student[] students;
	Course[] courses;
	
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
	private Student[] initiateStudentArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int numOfLines = lines.length;
		int i = 0 , j = 0;
		
		// line의 개수를 세어준다.		
		String[] splitLine = new String[numOfLines];
		
		// 잘라서 배열에 넣어준다. trim까지
		for(String line : lines) {
			splitLine[i++] = line.split(",")[1].trim();
		}
		// 이름들 중 겹치는게 있는지 확인해야함 안겹치는 것만 realStudents에 넣고 return
		Student[] tempStudents = new Student[numOfLines];
		Student[] realStudents = new Student[numOfStudents];
		// 일단 tempStudents에 line 수 만큼 다 넣는다
		for(i=0;i<numOfLines;i++) {
			tempStudents[j++] = new Student(splitLine[i]);
		}
		// array 인덱스 에러가 발생하지 않으려면 -1 부터 시작해 ++z 로 (-1, 0, 1, 2)
		int z=-1;
		for(i=0;i<numOfLines;i++) {
			if(!studentExist(realStudents,tempStudents[i])) {
				realStudents[++z]= new Student(tempStudents[i].getName());
			}
		}
		return realStudents;
	}

	/**
	 * This method check if there is the same name of the second arugement in the array, students
	 * @param students
	 * @param student
	 * @return boolean
	 */
	private boolean studentExist(Student[] students, Student student) {
		
		// TODO: implement this method
		for(Student item : students) {
			// item 이 null 일때는 비교하면 안되고, == 를 비교하면 주소값 비교하는거라 사용X , equals로
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
	private Course[] initiateCourseArrayFromLines(String[] lines) {
		
		// TODO: implement this method
		int numOfLines = lines.length;
		int i = 0 , j = 0 ;
		
		String[] splitLine = new String[numOfLines];
		
		// 잘라서 배열에 넣어준다.
		for(String line : lines) {
			splitLine[i++] = line.split(",")[2].trim();
		}
		
		// line 수 만큼 다 넣어줄 Course array
		Course[] tempCourses = new Course[numOfLines];
		// numOfCourses만큼만 들어갈 Course array
		Course[] realCourses = new Course[numOfCourses];
		
		for(i=0;i<numOfLines;i++) {
			tempCourses[j++] = new Course(splitLine[i]);
		}
		int z=-1;
		for(i=0;i<numOfLines;i++) {
			if(!courseExist(realCourses,tempCourses[i])) {
				realCourses[++z]= new Course(tempCourses[i].getCourseName());
			}
		}
		return realCourses;
	}

	/**
	 * This method check if there is the same name of the second argument in the array, courses.
	 * @param courses
	 * @param course
	 * @return boolean
	 */
	private boolean courseExist(Course[] courses, Course course) {
		
		// TODO: implement this method
		for(Course item : courses) {
			if((item!=null) && item.getCourseName().equals(course.getCourseName())==true) {
				return true;
			}
		}
		return false;
	}

}
