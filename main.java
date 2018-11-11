package philosopher;

import java.util.Scanner;

public class main implements Runnable {
	
	public int[] Philosophers = new int[] {1,2,3,4,5};
	public boolean think = true;
	public int[] sticks = new int[] {1,1,1,1,1};
	private boolean eat ;
	public boolean rightStick, leftStick;
	int left_stick, right_stick = 0;
	int time = 999;
	Thread t;
	
	public void takeChopStick(int phil) { // pass in which philosopher, his position around the table
			//phil=phil-1;
			switch (Philosophers[phil-1]){
			
					case 1:
						System.out.println("case 1");
						posOfPhil(phil);
						availableSticks(phil);
						eat(phil);
						returnSticks(phil);	
						break;
					case 2:
						System.out.println("case 2");
						posOfPhil(phil);
						availableSticks(phil);
						eat(phil);
						returnSticks(phil);
						break;
					case 3:
						System.out.println("case 3");
						posOfPhil(phil);
						availableSticks(phil);
						eat(phil);
						returnSticks(phil);
						break;
					case 4:
						System.out.println("case 4");
						posOfPhil(phil);
						availableSticks(phil);
						eat(phil);
						returnSticks(phil);
						break;
					case 5:
						System.out.println("case 5");
						posOfPhil(phil);
						availableSticks(phil);
						eat(phil);
						returnSticks(phil);
						break;
			}//switch cse
		
	}
	
	public void availableSticks(int phil) {
		if(sticks[left_stick]==1) {			
			sticks[left_stick] = 0;
			System.out.println("Philosopher "+phil+" took the left chop stick");
			leftStick=true;
		}
		else if(sticks[left_stick]==0){
			leftStick = false;
		}
		
		 if(sticks[right_stick]==1) {
			sticks[right_stick] = 0;
			System.out.println("Philosopher "+phil+" took the right chop stick");

			rightStick = true;
		}
		 else if(sticks[left_stick]==0){
			rightStick = false;
		}
	}
	
	public void posOfPhil(int phil) {
		//this method finds the philosopher's position around the table
		
		if(phil==5) {  // this method gets the position of sticks in the array
			right_stick = 0;
			left_stick = phil-1;
			
		}
		else if(phil==1) {
			left_stick = phil;
			right_stick = phil+1;
		}
		else if(phil>5&&phil<0) {
			System.out.println("Philosopher does not extst, try again");
			posOfPhil(phil);
		}
		else if(phil==2||phil==3) {
			right_stick= phil +1;
			left_stick = phil - 1;
		}
	}
	
	public boolean think(boolean think,int phil) {
		
		this.think = think;
		System.out.println("Philosopher "+phil+" is thinking");
		return think;
	}
	
	public boolean eat (int phil) {
		if(rightStick==true&&leftStick==true) {
			eat = true;
			System.out.println("Philosopher "+phil+" is eating");
			
			Scanner scan = new Scanner(System.in);
			
			System.out.println("Enter d when youre done eating ");
			String ans = scan.nextLine();
			
			done(ans);
			
			return eat;
		}
		else {
			return eat = false;
		}
		
	}
	
	public void done(String ans) {
		if(ans.equalsIgnoreCase("d")) {
			
		}
		else {
			System.out.println("Incorrect answer try again, enter ' d ' only when youre done eating");
			done(ans);
		}
	}
	
	public void returnSticks(int phil) {
		switch (Philosophers[phil-1]){
		
		case 1:
			posOfPhil(phil);
			doneEat(phil);			
		case 2:
			posOfPhil(phil);
			doneEat(phil);
		case 3:
			posOfPhil(phil);
			doneEat(phil);
		case 4:
			posOfPhil(phil);
			doneEat(phil);
		case 5:
			posOfPhil(phil);
			doneEat(phil);
			
			}//switch case
	}
	
	public void doneEat(int phil) {
		// puts back the sticks in their original position and change the boolean
		if(sticks[left_stick] == 0) {
			
			leftStick=false;
			sticks[left_stick] = 1;
			
			System.out.println("Philosopher "+phil+" is putting down left chop stick");
		}
		else if(left_stick==0){
			leftStick = false;
		}
		 if(sticks[right_stick] == 0) {
			sticks[right_stick] = 1;
			rightStick = false;
			
			System.out.println("Philosopher "+phil+" is putting down right chop stick");

		}
		else if(right_stick==0){
			rightStick = false;
		}
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {			
			
			System.out.println("Select a Philosopher from 1-5");
			Scanner scan = new Scanner(System.in);
			int p = scan.nextInt();
			int phil = p;
			think(think,phil);
			takeChopStick(phil);
			//Thread.sleep(time);
		}catch(Exception e) {
			
		}
	}
	
	public void start () {
	      System.out.println("Starting " );
	      if (t == null) {
	         t = new Thread (this);
	         t.start ();
	      }
	   }

	
	public static void main (String args[] ){
		
		//System.out.println("test");
		main phil = new main();
		main phil2 = new main();
		//phil.run();
		phil.start();
		phil2.start();
}

}


