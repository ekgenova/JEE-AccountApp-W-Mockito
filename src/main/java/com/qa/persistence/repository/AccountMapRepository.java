package com.qa.persistence.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Inject;

import org.apache.log4j.Logger;

import com.qa.business.service.AccountService;
import com.qa.persistence.domain.Account;
import com.qa.persistence.domain.Transaction;
import com.qa.util.JSONUtil;

@ApplicationScoped
@Alternative
public class AccountMapRepository implements IAccountRepository {

	private final Long INITIAL_COUNT = 1L;
	private Map<Long, Account> accountMap;
	private Long ID;

	@Inject
	private JSONUtil util;
	
	private static final Logger LOGGER = Logger.getLogger(AccountService.class);


	public AccountMapRepository() {
		this.accountMap = new HashMap<Long, Account>();
		ID = INITIAL_COUNT;
		initAccountMap();
	}

	public String getAllAccounts() {
		LOGGER.info("In AccountMapRepository getAllAccounts ");
		return util.getJSONForObject(accountMap.values());
	}

	public String createAccount(String account) {
		LOGGER.info("In AccountMapRepository createAccount ");
		ID++;
		Account newAccount = util.getObjectForJSON(account, Account.class);
		accountMap.put(ID, newAccount);
		return account;
	}

	public String updateAccount(Long id, String accountToUpdate) {
		LOGGER.info("In AccountMapRepository updateAccount ");
		Account newAccount = util.getObjectForJSON(accountToUpdate, Account.class);
        newAccount.setId(id);
		accountMap.put(id, newAccount);
		return accountToUpdate;
	}

	public String deleteAccount(Long id) {
		LOGGER.info("In AccountMapRepository deleteAccount ");
		accountMap.remove(id);
		return "{\"message\": \"accout sucessfully removed\"}";
	}

	private void initAccountMap() {
		LOGGER.info("In AccountMapRepository initAccountMap ");
		Transaction transaction = new Transaction("sample");
		transaction.setId(1L);
		List<Transaction> transactions = new ArrayList<Transaction>();
		transactions.add(transaction);
		Account account = new Account("Joe", "Bloggs", "1234",transactions);
		accountMap.put(1L, account);
	}

}
