package com.qa.business.service;

import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.persistence.repository.IAccountRepository;

public class AccountService implements IAccountService {

	private static final Logger LOGGER = Logger.getLogger(AccountService.class);

	@Inject
	private IAccountRepository repo;

	public String getAllAccounts() {
		LOGGER.info("In AccountService getAllAccounts ");
		return repo.getAllAccounts();
	}

	public String addAccount(String account) {
		LOGGER.info("In AccountService addAccount ");
		return repo.createAccount(account);
	}

	public String updateAccount(Long id, String account) {
		LOGGER.info("In AccountService updateAccount ");
		return repo.updateAccount(id, account);
	}

	public String deleteAccount(Long id) {
		LOGGER.info("In AccountService deleteAccount ");
		return repo.deleteAccount(id);
	}

	public void setRepo(IAccountRepository repo) {
		LOGGER.info("In AccountService setRepo ");
		this.repo = repo;
	}
}
