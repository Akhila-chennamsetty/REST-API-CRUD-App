package com.crud.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.crud.entity.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Integer>
{
	public Book findByName(String name);
	//HQL query
	@Query(value="from Book where name=:bname or price=:bprice")
	public List<Book> findBooksByNameAndPrice(String bname,Double bprice);
	
	@Query(value="from Book where name IN :bnames")
	public List<Book> findBooksByNamesUsingPathParams(List<String> bnames);
	
	@Query(value="From Book where name IN :bnames")
	public List<Book> findBooksByNamesUsingQueryParams(List<String> bnames);
}
