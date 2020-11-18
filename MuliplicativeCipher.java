package session_1_homework;

public class MuliplicativeCipher 
{
	private int encryptionKey;
	
	private Utils utils;
	
	
	/**
	 * Constructor
	 * @param key
	 */
	public MuliplicativeCipher( int encryptionKey ) throws Exception 
	{
		this.encryptionKey = encryptionKey;
		
		utils = new Utils();
		
		if( utils.getGcd( encryptionKey , 26 ) != 1 )
		{
			throw new Exception( "Invalid Encryption Key - gcd( key , 26 ) <> 1" );
		}
	}
	

	/**
	 * Set the Encryption Key
	 * @return key - int
	 */
	public int getEncryptionKey() 
	{
		return encryptionKey;
	}
	
	/**
	 * Get the Encryption Key
	 * @param key
	 * @return void
	 */
	public void setEncryptionKey(int encryptionKey) 
	{
		this.encryptionKey = encryptionKey;
	}

	
	/**
	 * Encrypt a given text using the object's encryption key
	 * @param plainText
	 * @return Encrypted Text - String
	 */
	public String encrypt( String plainText )
	{
		StringBuilder encryptedText = new StringBuilder();
		
		for( char character : plainText.toLowerCase().toCharArray() )
		{
			/**
			 * if the character is a whitespace, leave it as is
			 * 
			 * if it was a letter : 
			 * 		1. encrypt it using the formula ( M * K ) % 26
			 * 		2. add 97 to the result
			 * 		3. convert the final result to a valid 'ASCII' character 
			 */
			char encryptedCharacter = ( character == ' ' ) ? character :
					(char)( 
							( ( utils.getAlphabet().get( character ) * encryptionKey ) % 26 ) + 97 
						  );
			
			encryptedText.append( encryptedCharacter );			
		}
		
		return encryptedText.toString();
	}
	
	
	/**
	 * Decrypt a given text using the object's encryption key
	 * @param encryptedText
	 * @return Decrypted Text - String
	 */
	public String decrypt( String encryptedText ) throws Exception
	{
		int decryptionKey = utils.getDecryptionKey( encryptionKey );
		
		if( decryptionKey == -1 )
		{
			throw new Exception( "No Valid Decryption Key..." );
		}
		
		StringBuilder decryptedText = new StringBuilder();
		
		for( char character : encryptedText.toLowerCase().toCharArray() )
		{
			/**
			 * if the character is a whitespace, leave it as is
			 * 
			 * if it was a letter : 
			 * 		1. decrypt it using the formula ( M * K^-1 ) % 26
			 * 		2. add 97 to the result
			 * 		3. convert the final result to a valid 'ASCII' character 
			 */
			char decryptedCharacter = ( character == ' ' ) ? character :
				(char)( 
						( ( utils.getAlphabet().get( character ) * decryptionKey ) % 26 ) + 97 
					  );
			
			decryptedText.append( decryptedCharacter );
		}
		
		return decryptedText.toString().toUpperCase();
	}
}