package com.springboot;

import java.io.Serializable;
import java.util.Date;

public class Book implements Serializable {
		
		private long bookID;
		private String title;
		private double price;
		private int valume;
		private Date publishDate;
		
		Book(){
			
		}
		public Book(long bookID, String title, double price, int valume, Date publishDate) {
			super();
			this.bookID = bookID;
			this.title = title;
			this.price = price;
			this.valume = valume;
			this.publishDate = publishDate;
		}
		
		
		
		public long getBookID() {
			return bookID;
		}



		public void setBookID(long bookID) {
			this.bookID = bookID;
		}



		public String getTitle() {
			return title;
		}



		public void setTitle(String title) {
			this.title = title;
		}



		public double getPrice() {
			return price;
		}



		public void setPrice(double price) {
			this.price = price;
		}



		public int getValume() {
			return valume;
		}



		public void setValume(int valume) {
			this.valume = valume;
		}



		public Date getPublishDate() {
			return publishDate;
		}



		public void setPublishDate(Date publishDate) {
			this.publishDate = publishDate;
		}



		@Override
		public String toString() {
		        return "Book{" + "bookID=" + bookID + ", title=" + title + ", price=" + price + ", valume=" + valume + ", publishDate=" + publishDate +"}";
		}
		
	}

