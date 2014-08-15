package com.wrox.site.entities.test;

import static org.junit.Assert.*;

import org.junit.Test;

import com.wrox.site.entities.UserPrincipal;

public class UserPrincipalTest {

	@Test
	public void test() {
		UserPrincipal user = new UserPrincipal();
		assertTrue(user instanceof UserPrincipal);
	}

}
