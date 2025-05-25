package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Book;
import com.crud.repository.BookRepository;

@Service
public class BookService 
{
	@Autowired
	BookRepository repo;
	
	//save book data in db
	public Book saveBook(Book book)
	{
		return repo.save(book);
	}
	//save all books in db
	public List<Book> saveAllBooks(List<Book> bookls)
	{
		return repo.saveAll(bookls);
	}
	//find book by Id
	public Book findByBookId(int id)
	{
		return repo.findById(id).get();
	}
	//find book by name
	public Book findByBookName(String name)
	{
		return repo.findByName(name);
	}
	//find all books
	public List<Book> findAllBooks()
	{
		return repo.findAll();
	}
	//update book info
	public Book updateBookInfo(int id,Book book)
	{
		Book bookdata = repo.findById(id).get();
		bookdata.setName(book.getName());
		bookdata.setPrice(book.getPrice());
		repo.save(bookdata);
		return bookdata;
	}
	//find book by name and price
	public List<Book> findBooksByNameAndPrice(String bname,Double bprice)
	{
		return repo.findBooksByNameAndPrice(bname,bprice);
	}
    //find books with names spring boot and spring rest using path params
	public List<Book> findBooksByNamesUsingPathParams(List<String> bnames)
	{
		return repo.findBooksByNamesUsingPathParams(bnames);
	}
	 //find books with names spring boot and spring rest using query params
	public List<Book> findBooksByNamesUsingQueryParams(List<String> bnames)
	{
		return repo.findBooksByNamesUsingQueryParams(bnames);
	}
	
}
