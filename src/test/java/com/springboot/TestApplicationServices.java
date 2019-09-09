package com.springboot;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dao.SubjectBookDao;

public class TestApplicationServices {

	@InjectMocks
    ApplicationServices services;
     
    @Mock
    SubjectBookDao dao;
 
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
    
    
    @Test
	public void  addGetAllBooks(){

		List<Book> bookList = new ArrayList<Book>();
		
		Book book1 = new Book();
		book1.setBookID(100);
		book1.setTitle("Book100");
		book1.setPrice(100.50);
		book1.setValume(1000);
		book1.setPublishDate(new Date("11/01/1980"));
		
		Book book2 = new Book();
		book2.setBookID(200);
		book2.setTitle("Book200");
		book2.setPrice(200.50);
		book2.setValume(2000);
		book2.setPublishDate(new Date("10/02/1988"));

		bookList.add(book1);
		bookList.add(book2);
		
		dao.addBook(bookList);
		
		List<Book> bookList1 = dao.getAllBooks();
		for(Book b : bookList1) {
			System.out.println("Returned Books:  "+b.toString());
		}
		
		
	}
    
    @Test
    public void addGetAllSubjects() {
    	List<Subject> subjectList = new ArrayList<Subject>();
		  Set<Book> bookRef = new HashSet<Book>();
		 
		  Subject subject1 = new Subject();
		  Book book1 = new Book();
		  book1.setBookID(300);
		  book1.setTitle("Book300");
		  book1.setPrice(300.50);
		  book1.setValume(1000);
		  book1.setPublishDate(new Date("11/01/1989"));
		  subject1.setSubjectID(333);
		  subject1.setSubtitle("Science");
		  subject1.setDuratioHours(33);
		  
		  bookRef.add(book1);
		  subject1.setReference(bookRef);
		  subjectList.add(subject1);
		  
		  
		 Subject subject2 = new Subject();
		 Book book2 = new Book();
		 book2.setBookID(400);
		 book2.setTitle("Book400");
		 book2.setPrice(400.50);
		 book2.setValume(4000);
		 book2.setPublishDate(new Date("15/02/1986"));
		 subject2.setSubjectID(444);
		 subject2.setSubtitle("Biology");
		 subject2.setDuratioHours(44);
		 bookRef = new HashSet<Book>();
		  bookRef.add(book2);
		  
		  subject2.setReference(bookRef);
		  subjectList.add(subject2);
		  
		  dao.addSubject(subjectList);
		  List<Subject> subjectList1 = dao.getAllSubjects();
			for(Subject s : subjectList1) {
				System.out.println("Returned Subjects:  "+s.toString());
			}
		  

    }
    
    
}
