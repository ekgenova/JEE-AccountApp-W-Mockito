package com.qa.persistence.repository;

public interface IAccountRepository {

	String getAllAccounts();

	String createAccount(String accout);

	String updateAccount(Long id, String accountToUpdate);

	String deleteAccount(Long id);
}
