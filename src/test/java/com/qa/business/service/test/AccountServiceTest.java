package com.qa.business.service.test;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.AccountService;
import com.qa.persistence.repository.IAccountRepository;

@RunWith(MockitoJUnitRunner.class)
public class AccountServiceTest {

	@InjectMocks
	private AccountService accService;
	
	@Mock
	private IAccountRepository repo;
	
	@Before
	public void setUp() {
		accService.setRepo(repo);
	}
	
	@Test
	public void testAddAccount() {
		Mockito.when(repo.createAccount("account info")).thenReturn("account successfully added");
		assertEquals("account successfully added", accService.addAccount("account info"));
		Mockito.verify(repo).createAccount("account info");
		Mockito.verify(repo, Mockito.never()).deleteAccount(1L);
	}
	
	@Test
	public void testGetAllAccounts() {
		Mockito.when(repo.getAllAccounts()).thenReturn("accounts returned");
		assertEquals("accounts returned", accService.getAllAccounts());
		Mockito.verify(repo).getAllAccounts();
		Mockito.verify(repo,Mockito.never()).deleteAccount(1L);
	}
	
	@Test
	public void testUpdateAccount() {
		Mockito.when(repo.updateAccount(1L, "account info")).thenReturn("account successfully updated");
		assertEquals("account successfully updated", accService.updateAccount(1L, "account info"));
		Mockito.verify(repo).updateAccount(1L, "account info");
		Mockito.verify(repo, Mockito.never()).createAccount("account info");
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(repo.deleteAccount(1L)).thenReturn("account successfully deleted");
		assertEquals("account successfully deleted", accService.deleteAccount(1L));
		Mockito.verify(repo).deleteAccount(1L);
		Mockito.verify(repo, Mockito.never()).createAccount("1L");
	}
}
