

public class Bit {

    private boolean value;

    public Bit(boolean value){
        //Task 4.1
    	this.value= value;
    }

    public int toInt(){ 
        int ans = 0;
        //Task 4.2
        if(value) {
        	ans=1;
        }
        else {
        	ans=0;
        }
        return ans;

    }

    public String toString(){
        String ans = "";
        //Task 4.3
        if(value) {
        	ans= ans +1;
        }
        else {
        	ans= ans +0;
        }
        return ans;
    }
}

