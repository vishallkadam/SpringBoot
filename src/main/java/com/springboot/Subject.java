package com.springboot;

import java.io.Serializable;
import java.util.Set;

@SuppressWarnings("serial")
	public class Subject implements Serializable {
		
		private long subjectID;
		private String subtitle;
		private int duratioHours;
		Set<Book> reference;
		
		public Subject() {
			// TODO Auto-generated constructor stub
		}
		
		public Subject(long subjectID, String subtitle, int duratioHours,Set<Book> reference) {
			super();
			this.subjectID = subjectID;
			this.subtitle = subtitle;
			this.duratioHours = duratioHours;
			this.reference = reference;
		}
		
		

		public long getSubjectID() {
			return subjectID;
		}



		public void setSubjectID(long subjectID) {
			this.subjectID = subjectID;
		}



		public String getSubtitle() {
			return subtitle;
		}



		public void setSubtitle(String subtitle) {
			this.subtitle = subtitle;
		}



		public int getDuratioHours() {
			return duratioHours;
		}



		public void setDuratioHours(int duratioHours) {
			this.duratioHours = duratioHours;
		}



		public Set<Book> getReference() {
			return reference;
		}



		public void setReference(Set<Book> reference) {
			this.reference = reference;
		}



		@Override
		public String toString() {
		        return "Subject{" + "subjectID=" + subjectID + ", subtitle=" + subtitle + ", duratioHours=" + duratioHours + ", reference=" + reference.toString() + "}";
		}
	}
