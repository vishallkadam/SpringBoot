package com.springboot;

import static org.junit.Assert.assertEquals;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.util.ResourceUtils;

@RunWith(MockitoJUnitRunner.class)

public class ApplicationTest 
{
   
    
    @InjectMocks
	  private Application application;
    @Before
    public void init() {
        MockitoAnnotations.initMocks(this);
    }
	
	
	
	  @Test
	  public void addDeleteSubjectBook() throws FileNotFoundException  {
	  
		  File file = ResourceUtils.getFile("Subject.txt");
		  List<Subject> subjectList = new ArrayList<Subject>();
		  Set<Book> bookRef = new HashSet<Book>();
		 
		  Subject subject1 = new Subject();
		  Book book1 = new Book();
		  book1.setBookID(100);
		  book1.setTitle("Book100");
		  book1.setPrice(100.50);
		  book1.setValume(1000);
		  book1.setPublishDate(new Date("11/01/1980"));
		  subject1.setSubjectID(111);
		  subject1.setSubtitle("Science");
		  subject1.setDuratioHours(11);
		  
		  bookRef.add(book1);
		  subject1.setReference(bookRef);
		  subjectList.add(subject1);
		  
		  
		 Subject subject2 = new Subject();
		 Book book2 = new Book();
		 book2.setBookID(200);
		 book2.setTitle("Book200");
		 book2.setPrice(200.50);
		 book2.setValume(2000);
		 book2.setPublishDate(new Date("10/02/1988"));
		 subject2.setSubjectID(222);
		 subject2.setSubtitle("Biology");
		 subject2.setDuratioHours(22);
		 bookRef = new HashSet<Book>();
		  bookRef.add(book2);
		  
		  subject2.setReference(bookRef);
		  subjectList.add(subject2);
		  
		  Application.addSubjectBook(subjectList, file);
		  
		  
		  file = ResourceUtils.getFile("Subject.txt");
		  int size = (Application.readSubjectBook(file)).size();
		  assertEquals(2, size);
		  
		  File file2 = ResourceUtils.getFile("Subject.txt");
			 List<Subject> subjects = Application.readSubjectBook(file2);
			 size= (Application.deleteSubjectBook(subjects,222)).size();
			
			 
			  
			  assertEquals(1, size);
	  
	  }
	 
	  
	
}
