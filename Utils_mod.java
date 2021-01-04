package session_1_homework;

import java.util.HashMap;
import java.util.Map;

public class Utils 
{
	private Map<Character , Integer> alphabet;
	
	
	public Utils()
	{
		alphabet = new HashMap< Character , Integer >();
		
		/**
		 * Fill the 'alphabet' map with small letter using 'ASCII Table'
		 * and their appropriate indices ranging 0..25
		 * 
		 * Assuming the alphabet consists of English letters only...
		 */
		for( int i = 0 ; i < 26 ; i++ )
		{
			char asciiCharacter = (char)( i + 97 );
			
			alphabet.put( asciiCharacter , i );
		}
	}
	
	
	/**
	 * Get Alphabet
	 * @return alphabet - Map< Character , Integer >
	 */
	public Map<Character, Integer> getAlphabet() 
	{
		return alphabet;
	}

	/**
	 * Set Alphabet
	 * @param alphabet
	 * @return void
	 */
	public void setAlphabet( Map<Character, Integer> alphabet ) 
	{
		this.alphabet = alphabet;
	}
	
	
	/**
	 * Get decryption key using the Expanded Eucludian Algorithm
	 * @param encryptionKey
	 * @return Decryption Key - int
	 */
	public int getDecryptionKey( int encryptionKey )
	{
		int decryptionKey = -1;
		
		int r1 = 26;
		int r2 = encryptionKey;
		
		int t1 = 0;
		int t2 = 1;
		
		while( r2 != 0 )
		{
			/**
			 * Phase 1 of the iteration
			 */
			int q = r1 / r2;
			
			int r = r1 % r2;
			
			int t = t1 - q*t2;
			
			/**
			 * Phase 2 of the iteration
			 */
			r1 = r2;
			r2 = r;
			
			t1 = t2;
			t2 = t;
		}
		
		if( r1 == 1 )
		{
			while( t1 < 0 )
			{
				t1 += 26;
			}
			
			decryptionKey = t1 % 26;
		}
		
		return decryptionKey;
	}


	/**
	 * Calculate the greatest common divider for two given numbers
	 * @param firstNumber
	 * @param secondNumber
	 * @return Greatest Common Divider - int
	 */
	public int getGcd( int firstNumber , int secondNumber )
	{
		int gcd = 1;
		
	    for ( int i = 1 ; i <= firstNumber && i <= secondNumber ; i++ ) 
	    {
	        if ( firstNumber % i == 0  &&  secondNumber % i == 0 ) 
	        {
	            gcd = i;
	        }
	    }
	    
	    return gcd;
	}
}
