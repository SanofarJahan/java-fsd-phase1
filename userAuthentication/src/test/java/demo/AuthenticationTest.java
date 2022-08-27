package demo;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
class AuthenticationTest {

	private Authentication user;
	@BeforeEach
	public void BeforeEach() {
		user =new Authentication();
		System.out.println("UserAuthentication Initiated");
	}
	@AfterEach
	public void tearDown() {
		user=null;
		System.out.println("UserAuthentication stopped");
	}@Test
	public void Authenticate() {
		assertTrue(user.authentication("san@gmail.com","123"));
		assertFalse(user.authentication("rttfyg", "jhbkj"));
		assertNotEquals(user.authentication("san","san"), user.authentication("san@gmail.com", "123"));
		assertEquals(user.authentication("san@gmail.com","123"), user.authentication("san@gmail.com", "123"));
	}
	@Test
    public void Authenticate1() {
				assertFalse(user.authentication("",""));
		}
	}