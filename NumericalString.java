

import java.math.BigInteger;

public class NumericalString {

	public static int toInt(char c) {
	return "0123456789".indexOf(c);
	}
    public static boolean legalNumericString(String s, int b) {
        boolean ans = false;
        //Task 3.1
        //We will throw an exception if the input is illegal
        if( b> 10| b<2 ) {
        	throw new UnsupportedOperationException("the input is illegal");
        }
        else if(s==null ||s.equals("")) {
        	ans=false;
        }  
        else {
        	ans=true;
        	if(s.equals("0")) {
        		ans=true;
        	}
        	else {
        		//We will go through all the characters in the string and check if there is an illegal character
        		for(int i=0;ans& i<=s.length()-1; i=i+1) {
        			int num=toInt(s.charAt(i));
        			if(num>=b|num <0|toInt(s.charAt(s.length()-1))==0) {
        				ans=false;
        			}
        		}
        	}
        }
        return ans;
    }

    public static String decimalIncrement(String s) {
        String ans = "";
        //Task 3.2
        if(legalNumericString(s, 10) ==true)
        	ans= decimalIncrementRec(s,0,ans);
        else {
        	//If the string is not a numeric string at the base 10 then we will throw an exception
        	throw new UnsupportedOperationException("the input is illegal");
        }
        return ans;
    }
    public static String decimalIncrementRec(String s, int index, String acc) {
    	int num = toInt(s.charAt(index));
    	if(num != 9 & index < s.length()) {
    		acc= (num+1)+ s.substring(index+1);
    	}
    	else if (num ==9 & index == s.length()-1 ) {
    		acc= acc+"01";
    	}
    	else {
    		acc= '0'+ decimalIncrementRec(s, index+1 , acc);

    	}
    	return acc;
    }

    public static String decimalDouble(String s) {
        String ans = "";
        //Task 3.3
        if(legalNumericString(s, 10) ==true)
        	ans= doubled(s,0,ans,false);
        else {
        	//If the string is not a numeric string at the base 10 then we will throw an exception
        	throw new UnsupportedOperationException("the input is illegal");
        }
        return ans;
    }
    public static String doubled(String s, int index, String acc, boolean big) {
    	int num = toInt(s.charAt(index));
    	if(num >=5 & big) {
    		num =((num*2)%10)+1;
    		acc="" +num;
    		if(index==s.length()-1) {
    			acc= acc+ 1;
    		}
    	}
    	else if(num>=5) {
    		num = (num*2)%10;
    		acc="" +num;
    		big=true;
    		if(index==s.length()-1) {
    			acc= acc+ 1;
    		}
    	}
    	else {
    		if(num< 5 & big) {
    			num=(num*2)+1;
    			acc=""+num;
    			big =false;
    		}
    		else if(num< 5) {
    			num=(num*2);
    			acc=""+num;
    		}
    	}
    	if(index< s.length()-1) {
    		acc= acc+doubled(s,index+1,acc,big);
    	}
    	return acc;
    }
    

    public static String binary2Decimal(String s) {
        String ans = "";
        //Task 3.4
        String acc ="2";
        if(legalNumericString(s, 2) ==true) {
        	if(s.length()==1 & s.equals("0")) {
        		ans ="0";
        	}
        	else if(s.length()==1 & s.equals("1")) {
        		ans ="1";
        	}
        	else{
        		ans= fromBase2To10(s.substring(0,s.length()-1),acc);
        	}
        }
        else {
        	//If the string is not a numeric string at the base 2 then we will throw an exception
        	throw new UnsupportedOperationException("the input is illegal");
        }
        return ans;
    }
    public static String fromBase2To10(String s, String acc) {
    	int index = s.length()-1;
    	int num = toInt(s.charAt(index));
    	if(num ==1 & s.length()==1) {
    		acc= decimalIncrement(acc);
    	}
    	else if(num == 0 & s.length()==1) {
    		acc=acc;
    	}
    	else {
    		if(num == 1) {
        		acc =decimalIncrement(acc);
        		acc=decimalDouble(acc);
    		}
    		else if(num ==0) {
    			acc= decimalDouble(acc);
    		}
    		s= s.substring(0,s.length()-1);
    		acc =fromBase2To10(s, acc);
    	}

    	return acc;
    }

    

    public static void main(String[] args) {
        System.out.println("Good Luck! :)");
    }
}
