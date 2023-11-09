
class Change{

//Assume that the given array is not null, it can contain only positive numbers that are different from each other and is sorted.
	//Assume that n is no negative
    public static boolean change(int [] coins, int n){
        boolean ans = false;
        //Task 2.1
        
        ans= canBeDivided(coins,n, coins.length-1);
        return ans;
    }
    public static boolean canBeDivided(int [] coins, int count, int index){
    	boolean ans= false;
    	if(index < 0 |count < 0) {
    		ans= false;
    	}
    	else if(count ==0 || coins[index]==count) {
    		ans= true;
    	}
    	else {
    		while(coins[index]>count & index> 0) {
    			index = index -1;
    		}
        	if(index < 0) {
        		ans= false;
        	}
        	else {
    			ans= (canBeDivided(coins,count-coins[index],index) || canBeDivided(coins,count,index-1));
    		
        	}
    	}
    	return ans;
    }
    
  //Assume that the given array is not null, it can contain only positive numbers that are different from each other and is sorted.
    //Assume that numOfCoinsToUse >= 0 and n >= 0
    public static boolean changeLimited(int[] coins, int n, int numOfCoinsToUse){
        boolean ans = false;
        //Task 2.2
        ans= Limited(coins,n, coins.length-1,numOfCoinsToUse);
        return ans;
    }
    public static boolean Limited(int [] coins, int count, int index,int numOfCoinsToUse){
    	boolean ans= false;
    	if(index < 0 |count < 0) {
    		ans= false;
    	}
    	else if(count ==0 || coins[index]==count) {
    		ans= true;
    	}
    	else {
    		while(coins[index]>count & index> 0) {
    			index = index -1;
    		}
    		if(index < 0) {
    			ans= false;
    		}
    		else {
    			numOfCoinsToUse =numOfCoinsToUse-1;
    			if(numOfCoinsToUse>=0) {
    				ans= (Limited(coins,count-coins[index],index,numOfCoinsToUse) || Limited(coins,count,index-1,numOfCoinsToUse+1));

    			}
    			else {
    				ans=false;
    			}
    		}

    	}	
    	return ans;
    }
    //Assume that the given array is not null, it can contain only positive numbers that are different from each other and is sorted.
    //Assume that numOfCoinsToUse >= 0 and n >= 0
    public static void printChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        //Task 2.3
    	boolean ans= false;
    	int i=0;
    	String acc = "";
    	ans= changeLimited(coins,n,numOfCoinsToUse);
    	if(ans) {
    		printing(coins,n,coins.length-1,numOfCoinsToUse, acc);
    	}
    	
    }
    public static boolean printing(int [] coins, int count, int index,int numOfCoinsToUse, String acc){
    	boolean ans= false;
    	if(index < 0 |count < 0) {
    		ans= false;
    	}
    	else if(count ==0 || coins[index]==count) {
    		ans= true;
    		if(coins[index]==count) {
    			acc=(coins[index])+","+ acc;
    		}
    		if(acc.length()>0) {
    			System.out.print(acc.substring(0,acc.length()-1));
    		}
    		else {
    			System.out.print(acc);
    		}
    	}
    	else {
    		while(coins[index]>count & index> 0) {
    			index = index -1;
    		}
    		if(index < 0) {
    			ans= false;
    		}
    		else {
    			numOfCoinsToUse =numOfCoinsToUse-1;
    			if(numOfCoinsToUse>=0) {
    				ans=printing(coins,count-coins[index],index,numOfCoinsToUse, (coins[index])+","+ acc) || printing(coins,count,index-1,numOfCoinsToUse+1, acc);
    			}
    			else {
    				ans=false;
    				System.out.print("");
    			}
    		}

    	}	
    	return ans;
    }
    
    //Assume that the given array is not null, it can contain only positive numbers that are different from each other and is sorted.
    //Assume that numOfCoinsToUse >= 0 and n >= 0
    public static int countChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        int ans = 0;
        //Task 2.4
        String acc = "";
        if(n>0)
        ans = numberOfOptions(coins,n,coins.length-1,numOfCoinsToUse, acc,0,n);
        return ans;
    }
    public static int numberOfOptions(int [] coins, int count, int index,int numOfCoinsToUse, String acc, int answer, int inicount){
    	boolean ans= false;
    	if(index < 0 |count < 0) {
    		ans= false;
    		answer = 0;
    	}
    	else if(count ==0 ) {
    		ans= true;
    		if(coins[index]==count) {
    			acc=(coins[index])+","+ acc;
    		}
    		if(acc.length()>0) {
    			answer =answer+1;
    		}
    		else {
    			answer =answer+1;
    		}
    	}
    	else {
    		while(coins[index]>count & index> 0) {
    			index = index -1;
    		}
    		if(index < 0) {
    			ans= false;
    		}
    		else {
    			numOfCoinsToUse =numOfCoinsToUse-1;
    			if(numOfCoinsToUse>=0) {
    				answer=numberOfOptions(coins,count-coins[index],index,numOfCoinsToUse, (coins[index])+","+ acc,answer, inicount) + numberOfOptions(coins,count,index-1,numOfCoinsToUse+1, acc,answer, inicount);
    			}
    			else {
    				ans=false;
    				System.out.print("");
    			}
    		}

    	}	
    	return answer;
    }
    //Assume that the given array is not null, it can contain only positive numbers that are different from each other and is sorted.
    //Assume that numOfCoinsToUse >= 0 and n >= 0
    public static void printAllChangeLimited(int[] coins, int n, int numOfCoinsToUse){
        //Task 2.5
    	boolean ans= false;
    	int i=0;
    	String acc = "";
    	printingAllChange(coins,n,coins.length-1,numOfCoinsToUse, acc,0,n);
    }
    public static void printingAllChange(int [] coins, int count, int index,int numOfCoinsToUse, String acc, int answer, int inicount){
    	boolean ans= false;
    	if(index < 0 |count < 0) {
    		ans= false;
    		answer = 0;
    	}
    	else if(count ==0 ) {
    		ans= true;
    		if(coins[index]==count) {
    			acc=(coins[index])+","+ acc;
    		}
    		if(acc.length()>0) {
    			System.out.println(acc.substring(0,acc.length()-1));
    			answer =answer+1;
    		}
    		else {
    			System.out.println(acc);
    			answer =answer+1;
    		}
    	}
    	else {
    		while(coins[index]>count & index> 0) {
    			index = index -1;
    		}
    		if(index < 0) {
    			ans= false;
    		}
    		else {
    			numOfCoinsToUse =numOfCoinsToUse-1;
    			if(numOfCoinsToUse>=0) {
    				printingAllChange(coins,count-coins[index],index,numOfCoinsToUse, (coins[index])+","+ acc,answer, inicount);
    				printingAllChange(coins,count,index-1,numOfCoinsToUse+1, acc,answer, inicount);
    			}
    			else {
    				ans=false;
    				System.out.print("");
    			}
    		}

    	}	
    	
    }

}
