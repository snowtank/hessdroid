/*
 * Copyright (C) 2009 hessdroid@gmail.com
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
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
