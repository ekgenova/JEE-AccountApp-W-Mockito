package com.qa.persistence.domain;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.*;

import org.apache.log4j.Logger;

import com.qa.business.service.AccountService;

@Entity
public class Account {

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	private Long id;
	@NotNull
	@Size(min=2, max=50)
	private String firstName;
	@NotNull
	@Size(min=2, max=50)
	private String secondName;
	@NotNull
	@Size(min=6, max=6)
	private String accountNumber;
	@JoinColumn(name = "account_id")
	@OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Transaction> transaction;
	@Pattern(regexp = "^[A-Za-z]+[0-9]+$")
	public String something;

	private static final Logger LOGGER = Logger.getLogger(AccountService.class);
	
	public Account() {

	}

	public Account(String firstName, String secondName, String accountNumber, List<Transaction> transaction) {
		LOGGER.info("In Account constructor ");
		this.firstName = firstName;
		this.secondName = secondName;
		this.accountNumber = accountNumber;
		this.transaction = transaction;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getSecondName() {
		return secondName;
	}

	public void setSecondName(String secondName) {
		this.secondName = secondName;
	}

	public String getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Transaction> getTransaction() {
		return transaction;
	}

	public void setTransaction(List<Transaction> transaction) {
		this.transaction = transaction;
	}
	
	
	public String getSomething() {
		return something;
	}
	
	public void setSomething(String something) {
		this.something = something;
	}

}
