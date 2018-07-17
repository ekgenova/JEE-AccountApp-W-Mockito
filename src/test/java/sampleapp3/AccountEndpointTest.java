package sampleapp3;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import com.qa.business.service.AccountService;
import com.qa.interoperability.AccountEndpoint;


@RunWith(MockitoJUnitRunner.class)
public class AccountEndpointTest {

	@InjectMocks
	private AccountEndpoint endpoint;
	
	@Mock
	private AccountService accService;
	
	@Before
	public void setUp() {
		endpoint.setService(accService);
	}
	
	@Test
	public void testAddAccount() {
		Mockito.when(accService.addAccount("account info")).thenReturn("account successfully added");
		assertEquals("account successfully added", endpoint.addAccount("account info"));
		Mockito.verify(accService).addAccount("account info");
		Mockito.verify(accService, Mockito.never()).deleteAccount(1L);
	}
	
	@Test
	public void testGetAllAccounts() {
		Mockito.when(accService.getAllAccounts()).thenReturn("accounts returned");
		assertEquals("accounts returned", endpoint.getAllAccounts());
		Mockito.verify(accService).getAllAccounts();
		Mockito.verify(accService,Mockito.never()).deleteAccount(1L);
	}
	
	@Test
	public void testUpdateAccount() {
		Mockito.when(accService.updateAccount(1L, "account info")).thenReturn("account successfully updated");
		assertEquals("account successfully updated", endpoint.updateAccount(1L, "account info"));
		Mockito.verify(accService).updateAccount(1L, "account info");
		Mockito.verify(accService, Mockito.never()).addAccount("account info");
	}

	@Test
	public void testDeleteAccount() {
		Mockito.when(accService.deleteAccount(1L)).thenReturn("account successfully deleted");
		assertEquals("account successfully deleted", endpoint.deleteAccount(1L));
		Mockito.verify(accService).deleteAccount(1L);
		Mockito.verify(accService, Mockito.never()).addAccount("1L");
	}
}
