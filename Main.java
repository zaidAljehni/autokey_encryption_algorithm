package session_1_homework;

public class Main 
{
	public static void main( String args[] )
	{
		try
		{
			MuliplicativeCipher muliplicativeCipher = new MuliplicativeCipher( 3 );
			
			String plainText = "This is a plain text";
			
			String encryptedText = muliplicativeCipher.encrypt( plainText );
			
			String decryptedText = muliplicativeCipher.decrypt( encryptedText );
			
			System.out.println( "Encrypted Text : " +  encryptedText );
			
			System.out.println( "Decrypted Text : " + decryptedText );
		}
		catch( Exception e )
		{
			e.printStackTrace();
		}
	}
}
