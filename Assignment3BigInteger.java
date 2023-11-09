
import java.math.BigInteger;
import java.util.Random;
import java.lang.Object;
import java.lang.Number;
import java.lang.Object;


class Assignment3BigInteger{
	
//Assume that the input is not null.
    public static BigInteger sumSmaller(BigInteger n){
        BigInteger sum =  new BigInteger("0");
        //Task 1.1
        BigInteger curNum =  new BigInteger("1");
        final BigInteger bigOne = BigInteger.ONE;
        
        while(curNum.compareTo(n)<0) {
        	sum = sum.add(curNum);	
        	curNum = curNum.add(bigOne);
        }
        return sum;
    }
//Assume that n is no negative
    public static void printRandoms(int n){
        //Task 1.2
    	Random rnd = new Random();
    	for(int i=1;i<= n; i++ ) {
    		System.out.println(rnd.nextInt());
    	}
    }
//Assume that n is not null and its value is not negative
    public static boolean isPrime(BigInteger n){
        boolean ans= true;
        //Task 1.3
        BigInteger zero =  new BigInteger("0");
        if(n.intValue() < 2) {
        	ans = false;
        }
        BigInteger one =  new BigInteger("1");
        for(BigInteger p = new BigInteger("2"); ((n.compareTo(p.multiply(p)) == 0) | (n.compareTo(p.multiply(p)) > 0 ))& ans;p = p.add(one)){ // increment
        	if ((n.remainder(p)).equals(zero)) {
        		ans = false;
        	}
        }
        return ans;
    }
//Assume that n is greater than 1
    public static BigInteger randomPrime(int n){
        BigInteger randBig = new BigInteger("0");
        //Task 1.4
        
        Random rnd = new Random();
        while(!isPrime(randBig)) {
        	randBig = new BigInteger(n, rnd);
        }
        return randBig;
    }

}