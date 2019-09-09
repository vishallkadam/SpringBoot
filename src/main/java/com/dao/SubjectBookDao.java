package com.dao;

import java.util.ArrayList;
import java.util.List;

import com.springboot.Book;
import com.springboot.Subject;

public class SubjectBookDao {

	private static List<Subject> subjectList = new ArrayList<>();
	private static List<Book> bookList = new ArrayList();
	
	public  static List<Subject> getAllSubjects(){
		
		return subjectList;
	}
	
	public static void addSubject(List<Subject> list) {
		subjectList.addAll(list);
		for(Subject s : list) {
			System.out.println("Added Subjects:  "+s.toString());
		}
	}
	
	
	public static void addBook(List<Book> list) {
		bookList.addAll(list);
		
		for(Book book: list) {
			System.out.println("Added Books:   "+book.toString());
		}
	}
	
	public static List<Book> getAllBooks(){
		
		return bookList;
	}
}
