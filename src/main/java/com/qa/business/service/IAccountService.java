package com.qa.business.service;

public interface IAccountService {

	String getAllAccounts();

	String addAccount(String account);

	String updateAccount(Long id, String account);

	String deleteAccount(Long id);
}
