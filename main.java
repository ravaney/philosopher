package philosopher;

public class main {
	
	public int[] Philosophers = new int[] {1,2,3,4,5};
	public boolean think = true;
	public int[] sticks = new int[] {1,1,1,1,1};
	private boolean eat = false;
	public boolean rightStick, leftStick = false;
	int left_stick, right_stick = 0;
	
	public void takeChopStick(int phil) { // pass in which philosopher, his position around the table
		
			switch (Philosophers[phil]){
			
					case 1:
						posOfPhil(phil);
						availableSticks();
						eat();
						
						
					case 2:
						posOfPhil(phil);
						availableSticks();
						eat();
						
					case 3:
						posOfPhil(phil);
						availableSticks();
						eat();
						
					case 4:
						posOfPhil(phil);
						availableSticks();
						eat();
						
					case 5:
						posOfPhil(phil);
						availableSticks();
						eat();
						
						
			}//case 1
		
	}
	
	public void availableSticks() {
		if(left_stick==1) {
			leftStick=true;
		}
		else if(left_stick==0){
			leftStick = false;
		}
		else if(right_stick==1) {
			rightStick = true;
		}
		else{
			rightStick = false;
		}
	}
	
	public void posOfPhil(int phil) {
		//this method finds the philosopher's position around the table
		
		if(phil==5) {
			right_stick = 0;
			left_stick = phil-1;
		}
		else if(phil==1) {
			left_stick = phil+3;
			right_stick = phil- 1;
		}
		else if(phil>5&&phil<0) {
			System.out.println("Philosopher does not extst, try again");
			posOfPhil(phil);
		}
		else {
			right_stick= phil +1;
			left_stick = phil - 1;
		}
	}
	
	public boolean think(boolean think) {
		this.think = think;
		return think;
	}
	
	public boolean eat () {
		if(rightStick==true&&leftStick==true) {
			eat = true;
			return eat;
		}
		else {
			return eat = false;
		}
		
	}
	
	public void returnSticks(int phil) {
		
	}
	
	

}
