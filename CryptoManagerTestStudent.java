import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: This is the test class where we test each method
 * Due: 7/10/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/
class CryptoManagerTestStudent {

	@Test
	public void testStringInBounds() {
		assertTrue(CryptoManager.isStringInBounds("CMSC"));
		assertTrue(CryptoManager.isStringInBounds("TALIA KOUNCAR"));
		assertFalse(CryptoManager.isStringInBounds("tk"));
		assertFalse(CryptoManager.isStringInBounds("{BASKETBALL"));
		assertFalse(CryptoManager.isStringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS NOT IN RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", CryptoManager.caesarEncryption("hi", 5));
		assertEquals("FGH", CryptoManager.caesarEncryption("CDE", 3));
		assertEquals("W^&/\\$RW/&^^S/R^$[S/P/&^^SRW$RZ/RW$RZ/XU/P/&^^SRW$RZ/R^$[S/RW$RZ", CryptoManager.caesarEncryption("HOW MUCH WOOD COULD A WOODCHUCK CHUCK IF A WOODCHUCK COULD CHUCK", 15));
		assertEquals("ROVVY", CryptoManager.caesarEncryption("HELLO", 10));
		assertEquals("UFTU", CryptoManager.caesarEncryption("TEST", 1));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("TEST", CryptoManager.caesarDecryption("UFTU", 1));
		assertEquals("HELLO", CryptoManager.caesarDecryption("ROVVY", 10));
		assertEquals("HELLO WORLD", CryptoManager.caesarDecryption("4188;LC;>80", 300));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WN#\\N &", CryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("UJ^^((HT^X[YYM\"", CryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
		assertEquals("WU\\VR9F#N!RF88U-'HED", CryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", CryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", CryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", CryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));

	}

}
