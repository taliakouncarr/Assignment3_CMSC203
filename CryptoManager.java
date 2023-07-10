
/**
 * This is a utility class that encrypts and decrypts a phrase using two
 * different approaches. The first approach is called the Caesar Cipher and is a
 * simple “substitution cipher” where characters in a message are replaced by a
 * substitute character. The second approach, due to Giovan Battista Bellaso,
 * uses a key word, where each character in the word specifies the offset for
 * the corresponding character in the message, with the key word wrapping around
 * as needed.
 * 
 * @author Farnaz Eivazi
 * @version 7/16/2022
 */
/*
 * Class: CMSC203 
 * Instructor: Grinberg
 * Description: This is the main class where we write the code for each method to encrpyt and decrypt messages
 * Due: 7/10/2023
 * Platform/compiler: eclipse
 * I pledge that I have completed the programming  assignment independently. 
*  I have not copied the code from a student or any source. 
*  I have not given my code to any student.
*  Print your Name here: Talia Kouncar
*/

public class CryptoManager {
	
	private static final char LOWER_RANGE = ' ';
	private static final char UPPER_RANGE = '_';
	private static final int RANGE = UPPER_RANGE - LOWER_RANGE + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_RANGE and UPPER_RANGE characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean isStringInBounds (String plainText) {
		
		boolean range1 = true; //set to true initially
		
		//will tell us if a string is within the allowable bounds of ASCII code
		for (int j=0; j<plainText.length(); j++) { 
		
		if (plainText.charAt(j) < LOWER_RANGE || plainText.charAt(j) > UPPER_RANGE) {
		range1 = false; //if it is lower than the lower range or higher thn the upper range return false
		}
	//	throw new RuntimeException ("method not implemented");
		}
		return range1;
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String caesarEncryption(String plainText, int key) {
		//throw new RuntimeException("method not implemented");
		
		
		String caeserEncTxt = ""; //will contain our return value later

		if (isStringInBounds(plainText)==true) { //only execute if the string is in bounds
		for (int j=0; j<plainText.length(); j++) { //will execute for each character for as long as the plain text entered is
			
		int caeserEncrypt = ((int)plainText.charAt(j))+key; //whatever the user enters is the key, and add that onto whatever character we are on
		
		while (caeserEncrypt > UPPER_RANGE) { //if they key is larger than the upper range we account for it here
			caeserEncrypt = caeserEncrypt - RANGE; 
		}
		caeserEncTxt += (char)(caeserEncrypt); //get our new character

		} 
	} else if (isStringInBounds(plainText)==false){
		String errorMessage = "The selected string is not in bounds, Try again."; //if not inbounds print this 
	return errorMessage;
	}
			
		return caeserEncTxt; 

	} 
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText // vigenere
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String bellasoEncryption (String plainText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
	
		int lengthOfBellasoStr = bellasoStr.length();
		int UPPER_RANGE2= (int)UPPER_RANGE;
		String bellasoEncTxt = "";


		if(isStringInBounds (plainText)) { //if the string is in bounds the rest will execute
		for (int j=0; j < plainText.length(); j++) // going through each character in our string
		{
		int	bellasoKey = ((int)bellasoStr.charAt(j%lengthOfBellasoStr)); //Gives us the ASCII value of the bellasoStr character at the index modulus the length of the string
			int vigenereEncrypt = (((int)plainText.charAt(j))+ bellasoKey); //Gives us the ASCII value of the plainText character at the index then add the bellasoKey
			
			while (vigenereEncrypt > UPPER_RANGE2 ) {
				vigenereEncrypt = vigenereEncrypt - RANGE;
			}
			
			bellasoEncTxt += ((char)vigenereEncrypt); //now we convert that to a character
		}
		}
		return bellasoEncTxt; //going to give us our new character

	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String caesarDecryption (String encryptedText, int key) {
		//throw new RuntimeException("method not implemented");
		String caeserDecTxt = ""; //our decrypted text 

		for (int j=0; j < encryptedText.length(); j++) { //running through each character of our encrypted text 
			int caeserDecrypt = ((int)encryptedText.charAt(j))-key; // now we are taking away the key 
			
			while (caeserDecrypt < LOWER_RANGE) { 
				caeserDecrypt = caeserDecrypt + RANGE;
			}
			
			caeserDecTxt += (char) caeserDecrypt; // our new output 
		}
		return caeserDecTxt;
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String bellasoDecryption(String encryptedText, String bellasoStr) {
		//throw new RuntimeException("method not implemented");
		
		int lengthOfBellasoStr = bellasoStr.length(); //length of the string we entered 
		int LOWER_RANGE2= (int)LOWER_RANGE; 
		String bellasoDecTxt = ""; //will hold our decrypted text 
		
		for (int j=0; j < encryptedText.length(); j++) { //run through each character of the string 
			
			int	bellasoKey = ((int)bellasoStr.charAt(j%lengthOfBellasoStr)); //Gives us the ASCII value of the bellasoStr character at the index modulus the length of the string
			int vigenereEncrypt = (((int)encryptedText.charAt(j))-bellasoKey); //we are now taking away the key 
			
			while (vigenereEncrypt < LOWER_RANGE2) {
				vigenereEncrypt = vigenereEncrypt+RANGE;
			}
			bellasoDecTxt += (char)vigenereEncrypt; //new output 
		}
		return bellasoDecTxt;
	}
}
