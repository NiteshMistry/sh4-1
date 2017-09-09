package com.sunbeam.sh4.hib;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.QueryHint;
import javax.persistence.Table;
import javax.persistence.Transient;

@NamedNativeQueries({
	@NamedNativeQuery(name="qry_StoProcGetByAuthor",
		query="{CALL SP_GETBOOKS(:p_au)}",
		hints={@QueryHint(name="org.hibernate.callable", value="true")},
		resultClass=Book.class
		),
	// this is not needed in this example -- out param sto proc called using JDBC.
	@NamedNativeQuery(name="qry_StoProcGetBookPrice",
		query="{CALL SP_BOOKPRICE(?,?)}",
		hints={@QueryHint(name="org.hibernate.callable", value="true")}
		)
})
@Entity
@Table(name="BOOKS")
public class Book implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="AUTHOR")
	private String author;
	@Column//(name="SUBJECT")
	private String subject;
	//@Column(name="PRICE")
	private double price;
	@Transient
	private int temp;
	public Book() {
		this(0, "", "", "", 0.0);
	}
	public Book(int id, String name, String author, String subject, double price) {
		this.id = id;
		this.name = name;
		this.author = author;
		this.subject = subject;
		this.price = price;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Override
	public String toString() {
		return String.format("Book [id=%s, name=%s, author=%s, subject=%s, price=%s]", id, name, author, subject,
				price);
	}
}

/* MYSQL PROCEDURE:
DELIMITER //
CREATE PROCEDURE SP_GETBOOKS(p_author TEXT)
BEGIN
	SELECT ID,NAME,AUTHOR,SUBJECT,PRICE FROM BOOKS WHERE AUTHOR=p_author;
END;
//
DELIMITER ;
*/

/* MYSQL PROCEDURE:
DELIMITER //
CREATE PROCEDURE SP_BOOKPRICE(IN p_bookid int, OUT p_price double)
BEGIN
	SELECT PRICE INTO p_price FROM BOOKS WHERE ID=p_bookid;
END;
//
DELIMITER ;
*/



