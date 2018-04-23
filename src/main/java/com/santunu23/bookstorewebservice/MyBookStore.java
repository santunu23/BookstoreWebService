package com.santunu23.bookstorewebservice;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class MyBookStore {
	
	private int  bookList;
	private String bookName;
	private int bookReadCount;
	private int bookFileSize;
	private int bookPrice;
	private String bookLanguage;
	private String bookWriter;
	public int getBookList() {
		return bookList;
	}
	public void setBookList(int bookList) {
		this.bookList = bookList;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookReadCount() {
		return bookReadCount;
	}
	public void setBookReadCount(int bookReadCount) {
		this.bookReadCount = bookReadCount;
	}
	public int getBookFileSize() {
		return bookFileSize;
	}
	public void setBookFileSize(int bookFileSize) {
		this.bookFileSize = bookFileSize;
	}
	public int getBookPrice() {
		return bookPrice;
	}
	public void setBookPrice(int bookPrice) {
		this.bookPrice = bookPrice;
	}
	public String getBookLanguage() {
		return bookLanguage;
	}
	public void setBookLanguage(String bookLanguage) {
		this.bookLanguage = bookLanguage;
	}
	public String getBookWriter() {
		return bookWriter;
	}
	public void setBookWriter(String bookWriter) {
		this.bookWriter = bookWriter;
	}
	
	
	
}
