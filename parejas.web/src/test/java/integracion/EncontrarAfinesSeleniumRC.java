package integracion;

import com.thoughtworks.selenium.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.regex.Pattern;

public class EncontrarAfinesSeleniumRC {
	private Selenium selenium;

	@Before
	public void setUp() throws Exception {
		selenium = new DefaultSelenium("localhost", 4444, "*chrome", "http://localhost:8080/web");
		selenium.start();
	}

	@Test
	public void testEncontrarafines() throws Exception {
		selenium.open("/web/busquedas.jsp");
		selenium.type("name=nombre", "ana");
		selenium.type("name=edad", "25");
		selenium.type("name=altura", "1.76");
		selenium.type("name=sexo", "M");
		selenium.click("css=input[type=\"submit\"]");
		selenium.waitForPageToLoad("30000");
		assertEquals(".:Resultados de la busqueda:.", selenium.getTitle());
		assertTrue(selenium.isTextPresent(""));
	}

	@After
	public void tearDown() throws Exception {
		selenium.stop();
	}
}
