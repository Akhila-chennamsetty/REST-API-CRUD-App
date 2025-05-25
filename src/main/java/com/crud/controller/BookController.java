package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.crud.entity.Book;
import com.crud.service.BookService;

@RestController
public class BookController 
{
	@Autowired
	BookService service;
	@PostMapping("/saveBook")
	public ResponseEntity<Book> saveBookData(@RequestBody Book book)
	{
		return new ResponseEntity<>(service.saveBook(book),HttpStatus.CREATED);
	}
	@PostMapping("/saveAllBooks")
	public List<Book> saveAllBooks(@RequestBody List<Book> bookls)
	{
		return service.saveAllBooks(bookls);
	}
	@GetMapping("/getByBookId/{id}")
	public Book getByBookId(@PathVariable int id)
	{
		return service.findByBookId(id);
	}
	@GetMapping("/getByBookName/{name}")
	public Book getByBookName(@PathVariable String name)
	{
		return service.findByBookName(name);
	}
	@GetMapping("/getAllBooks")
	public List<Book> getAllBooks()
	{
		return service.findAllBooks();
	}
	@PutMapping("/updateBookInfo/{id}")
	public Book updateBookInfo(@PathVariable int id,@RequestBody Book book)
	{
		return service.updateBookInfo(id, book);
	}
	@GetMapping("/getBooksByNameAndPrice/{bname}/{bprice}")
	public List<Book> getBooksByNameAndPrice(@PathVariable String bname,@PathVariable Double bprice)
	{
		return service.findBooksByNameAndPrice(bname,bprice);
	}
	//using @PathVariable(path params)
	@GetMapping("/getBooksByNamesUsingPathParams/{bnames}")
	public List<Book> findBooksByNamesUsingPathParams(@PathVariable List<String> bnames)
	{
		return service.findBooksByNamesUsingPathParams(bnames);
	}
	
	@GetMapping("/getBooksByNamesUsingQueryParams")
	public List<Book> findBooksByNamesUsingQueryParams(@RequestParam List<String> bnames)
	{
		return service.findBooksByNamesUsingPathParams(bnames);
	}
	
	
	
	
	
	
	
	
	
}
