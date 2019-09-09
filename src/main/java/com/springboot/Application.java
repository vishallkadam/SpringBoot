package com.springboot;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;
import org.springframework.util.ResourceUtils;






@SpringBootApplication
@ImportResource("application_bean.xml")

public class Application {
    
    public static void main(String[] args) {
        ApplicationContext appContext = SpringApplication.run(Application.class, args);
        
        System.out.println("This is Springboot example:");
        
		/*
		 * String[] beanNames = appContext.getBeanDefinitionNames();
		 * Arrays.sort(beanNames); for (String beanName : beanNames) {
		 * System.out.println(beanName); }
		 */
        Book book1 = (Book) appContext.getBean("book1");
		Book book2 = (Book) appContext.getBean("book2");
		Book book3 = (Book) appContext.getBean("book3");

		Set<Book> bookSet1 = (Set<Book>) appContext.getBean("hashSet1");
		bookSet1.add(book1);
		Set<Book> bookSet2 = (Set<Book>) appContext.getBean("hashSet1");
		bookSet2.add(book2);
		Set<Book> bookSet3 = (Set<Book>) appContext.getBean("hashSet1");
		bookSet3.add(book3);
		

		List<Subject> subjectList = (List<Subject>) appContext.getBean("list1");
		Subject subject1 = (Subject) appContext.getBean("subject1");
		subjectList.add(subject1);
		Subject subject2 = (Subject) appContext.getBean("subject2");
		subjectList.add(subject2);
		Subject subject3 = (Subject) appContext.getBean("subject3");
		subjectList.add(subject3);

		try {
			File file = ResourceUtils.getFile("Subject.txt");

			System.out.println("Check Request - " + args[0]);
			int action = Integer.parseInt(args[0]);
			switch (action) {
			case 1:
				System.out.println("Add Subject/Book");
				addSubjectBook(subjectList, file);
				break;
			case 2:
				System.out.println("Delete Subject/Book");
				List<Subject> subjectsList = readSubjectBook(file);
				List<Subject> updatedSubjectsList = deleteSubjectBook(subjectsList, Long.parseLong(args[1]));
				addSubjectBook(updatedSubjectsList, file);
				break;
			case 3:
				System.out.println("Search Subject/Book");
				List<Subject> subjects = readSubjectBook(file);
				search(subjects, Long.parseLong(args[1]));
				break;
			default:
				System.out.println("no match");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
    }

    public static void addSubjectBook(List<Subject> subject, File file) {

		ObjectOutputStream outStream = null;
		try {
			outStream = new ObjectOutputStream(new FileOutputStream(file));
			for (Subject s : subject) {
				outStream.writeObject(s);
			}
			show(subject);
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		} catch (NoSuchElementException noSuchElementException) {
			System.err.println("Invalid input.");
		} finally {
			try {
				if (outStream != null)
					outStream.close();
			} catch (IOException ioException) {
				System.err.println("Error closing file.");
			}
		}

	}

	public static List<Subject> readSubjectBook(File file) {
		List<Subject> list = new ArrayList<Subject>();
		ObjectInputStream inputStream = null;
		try {
			inputStream = new ObjectInputStream(new FileInputStream(file));
			while (true) {
				Subject p = (Subject) inputStream.readObject();
				list.add(p);
			}
		} catch (EOFException eofException) {
			return list;
		} catch (ClassNotFoundException classNotFoundException) {
			System.err.println("Object creation failed.");
		} catch (IOException ioException) {
			System.err.println("Error opening file.");
		} finally {
			try {
				if (inputStream != null)
					inputStream.close();
			} catch (IOException ioException) {
				System.err.println("Error closing file.");
			}
		}
		return list;
	}
	
	public static List<Subject> deleteSubjectBook(List<Subject> subjectList, long subjectID) {
		List<Subject> removelist = new ArrayList<Subject>();
		try {
			for (Subject s : subjectList) {
				if(s.getSubjectID()==subjectID){
					removelist.add(s);
				}
			}
			subjectList.removeAll(removelist);
			
		} catch (Exception exception) {
			return subjectList;
		}  
		return subjectList;
	}
	
	public static void search(List<Subject> list, long subjectID) {
		for (Subject s : list) {
			if(s.getSubjectID()==subjectID)
				System.out.println("Search Details - "+s.toString());
		}
	}

	public static void show(List<Subject> list) {
		for (Subject s : list) {
			System.out.println("Show Latest Subject Details - " + s.toString());
		}
	}
}
