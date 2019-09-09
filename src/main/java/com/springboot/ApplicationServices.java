package com.springboot;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.SubjectBookDao;

@Service
public class ApplicationServices {

	@Autowired
	public SubjectBookDao dao;	
	
public List<Subject> getAllSubjects(){
		
		return dao.getAllSubjects();
	}
	
	public void addSubject(List<Subject> list) {
		dao.addSubject(list);
	}
	
	public void addBook(List<Book> list) {
		dao.addBook(list);
	}
	
	public List<Book> getAllBooks(){
		
		return dao.getAllBooks();
	}
	
}
