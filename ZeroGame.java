import java.util.Random;



public class ZeroGame {
	 private int numbers[];
	    private static Random generator = new Random();
	    
	    public ZeroGame(){
	      //Instantiate the array of 10 values and fill them with the numbers 0 through 9
         numbers = new int[]{0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
         
         //Then mix the numbers up so they are out of order
         for(int i = 0; i < 50; i++){
            int rnd1 = generator.nextInt(numbers.length);
            int rnd2 = generator.nextInt(numbers.length);
            swap(rnd1,rnd2);
         }
         
       }
	    
	    private void swap(int prince, int spider){
	        //Swap the two positions in the list
           int temp = numbers[spider];
           numbers[spider] = numbers [prince];
           numbers[prince] = temp;
           
	    }
	    
       public int getZeroPos(){
	         //Return the position of the zero in the list
            for(int i = 0; i < numbers.length; i++){
               if(numbers[i] == 0){
                  return i;
               }
            }
            return -1;
	    }
       
       public void moveRight(){
	        //If the zero is all the way to the right, don't do anything
           int zero = getZeroPos();
           if(zero != numbers.length-1){
               swap(zero, zero + 1);
           }
           //Othewise: Swap the zero with the number to the right
       }
	    
	    public void moveLeft(){
	        //If the zero is all the way to the left, don't do anything
           //Othewise: Swap the zero with the number to the left
           int zero = getZeroPos();
           if(zero != 0){
               swap(zero, zero - 1);
           }
           
	    }
	    
	    public void flip(){
            //If the zero is on an end, don't do anything
            //Otherwise, swap the two numbers on either side of the zero
            int zero = getZeroPos();
            if(zero != numbers.length-1 && zero != 0){
               swap(zero - 1, zero + 1);
            }
	    }
	        
	    public boolean inOrder(){
	    	 //Return true if the numbers are in order
          for(int i = 0; i < numbers.length; i++){
            if(numbers[i] != i){
               return false;
            }
          }
          
	    	return true;
	    }
	    

	    public String toString(){
	        //Return a String of all the numbers seporated with a space
           String str = "";
           for(int i: numbers){
               str += i + " ";
           }
           return str;
	    }
}

