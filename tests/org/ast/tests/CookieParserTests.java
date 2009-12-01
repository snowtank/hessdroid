package org.ast.tests;

import org.junit.Test;

import com.ast.util.CookieParser;
import com.ast.util.CookieParser.Cookie;

import static junit.framework.Assert.*;

public class CookieParserTests {

	@Test public void testWithCookieValueAndPath() throws Exception {
		
		Cookie c = CookieParser.parse("myhost", "Set-Cookie: cookie-value; path=path");
		
		
		assertEquals(c.host, "myhost");
		assertEquals(c.path, "path");
	}
	
	@Test public void testWithCompleteCookiePath() throws Exception {
		// Set-Cookie: cookie-value; expires=date; path=path; domain=domain-name; secure
		
		Cookie c = CookieParser.parse("myhost", "Set-Cookie: cookie-value; expires=date; path=path; domain=domain-name; secure");
		
		
		assertEquals(c.host, "myhost");
		assertEquals(c.path, "path");
		assertEquals(c.value, "cookie-value");
		assertEquals(c.expires, "date");
		assertEquals(c.domain, "domain");
		assertEquals(c.secure, true);
	}
	
}
