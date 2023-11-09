
public class BitVector {
    private Bit[] bits;
    public BitVector(String s) {
        //Task 4.4
    	//If the string is not a numeric string at the base 2 then we will throw an exception
    	if(NumericalString.legalNumericString(s, 2) !=true) {
    		throw new UnsupportedOperationException("the input is illegal");
    	}
    	else {
    		this.bits = new Bit[s.length()];
    		for(int i=0; i<s.length(); i=i+1) {
    			if(s.charAt(i)==('1')){
    				bits[i] = new Bit(true);
    			}
    			else {
    				bits[i] = new Bit(false);
    				}
    		}
    	}
    }

    public String toString() {
        String ans = "";
        //Task 4.5
        String s= "";
        //We will change bits to a string
        for(int i=0; i<bits.length; i=i+1) {
        	s= s+ bits[i].toString();   	
        }
        //We will use the function of task 3.4 to find the value of the string in base 10
        String answer= NumericalString.binary2Decimal(s);
        //We will change the string from base 10, to a regular number
    	for(int i = answer.length()-1;i>=0;i= i-1) {
    		ans = ans +answer.charAt(i);
    	}
        
        return ans;
    }

}
