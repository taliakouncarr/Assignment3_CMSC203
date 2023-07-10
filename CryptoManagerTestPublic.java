
import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestPublic {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("JAVA"));
		assertTrue(CryptoManager.isStringInBounds("\"JAVA IS FUN\""));
		assertFalse(CryptoManager.isStringInBounds("java"));
		assertFalse(CryptoManager.isStringInBounds("{JAVA"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("bye", 3));
		assertEquals("DEF", CryptoManager.caesarEncryption("ABC", 3));
		assertEquals("!\"#", CryptoManager.caesarEncryption("ABC", 96));
		assertEquals("1.558", CryptoManager.caesarEncryption("HELLO", 105));
		assertEquals("UFTUJOH", CryptoManager.caesarEncryption("TESTING", 1));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", CryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("TESTING", CryptoManager.caesarDecryption("UFTUJOH", 1));
		assertEquals("OKAY THANKS", CryptoManager.caesarDecryption("GC9QXL@9FCK", 120));
		assertEquals("TESTING AGAIN", CryptoManager.caesarDecryption("@1?@5:3L-3-5:", 300));
		assertEquals("LAST TEST ", CryptoManager.caesarDecryption("ODVW#WHVW#", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("ON&W#!XVW-", CryptoManager.bellasoEncryption("LAST TEST ", "CMSC"));
		assertEquals("PF)X^9JN+\\M]I^", CryptoManager.bellasoEncryption("HAPPY BIRTHDAY", "HEY"));
		assertEquals("(L=;U+<A)Y43&", CryptoManager.bellasoEncryption("TALIA KOUNCAR", "TK12"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("LAST TEST ", CryptoManager.bellasoDecryption("ON&W#!XVW-", "CMSC"));
		assertEquals("TALIA KOUNCAR", CryptoManager.bellasoDecryption("(L=;U+<A)Y43&", "TK12"));
		assertEquals("HAPPY BIRTHDAY", CryptoManager.bellasoDecryption("PF)X^9JN+\\M]I^", "HEY"));
	}

}
