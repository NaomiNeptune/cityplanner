/*make player make a apartment as first building, still get to choose position*/
import java.util.*;

class Main {
    /*get functions*/
	public static void getCity(String[][] c){
    	for(int row = 0; row<c.length; row++){
        	for(int col = 0; col<c.length; col++){
            	System.out.print(c[row][col] + "  ");
        	}
        	System.out.println();
    	}
	}
	
	public static int getNum(String[][] c, String l){
	    int num = 0;
	    for(int row = 0; row<c.length; row++){
        	for(int col = 0; col<c.length; col++){
            	if(c[row][col].equals(l.toUpperCase())){
            	    num++;
            	}
        	}
    	}
    	return num;
	}

	/*main function*/
	public static void main(String[] args) {
    	/*title*/
    	Scanner scan = new Scanner(System.in);
    	System.out.println("Mini City Planner Sim");
    	System.out.println("Made by Chloe S\n");
    	/*make city*/
    	String[][] city = new String[5][5];
    	for(int r = 0; r<city.length; r++){
        	for(int c = 0; c<city.length; c++){
            	city[r][c] = "F";
        	}
    	}
    	/*starting variables*/
    	String name = "";
    	int budget = 15000;
    	int round = 0;
    	
    	/*plot costs*/
    	int hPrice = 1000;
    	int sPrice = 900;
    	int bPrice = 800;
    	int aPrice = 700;
    	int lPrice = 600;
    	int vPrice = 500;
    	int pPrice = 300;
    	
    	/*income, tax per person per year, collected at end of every 5 rounds*/
    	int taxPerson = 100;
    	
    	/*stats*/
    	int happy = 0;
    	int econ = 0;
    	int health = 0;
    	int edu = 0;
    	int pop = 0;
    	
    	/*investment arraylist*/
    	/*each amount of investment = 1000?*/
    	ArrayList<Investment> invest = new ArrayList<Investment>();
    	
    	/*name, happy, economy, health, education*/
    	/*net of 4*/
    	invest.add(new Investment("School", 0, 1, 0, 3));
    	invest.add(new Investment("Welfare", 3, -3, 3, 1));
    	invest.add(new Investment("Healthcare", 2, -2, 3, 1));
    	invest.add(new Investment("Transportation", 1, 1, 1, 1));
    	invest.add(new Investment("Art", 3, 0, 0, 1));
    	invest.add(new Investment("Climate", 2, -1, 2, 1));
    	invest.add(new Investment("Advertisement", -5, 7, 0, 0));
    	invest.add(new Investment("Events", 3, 1, 0, 0));
    	/*invest.add(new Investment("Agriculture", 1, 2, 1, 2));*/
    	
    	/*representation of numbers*/
    	int[][] rep = {{1, 2, 3, 4, 5},{1, 2, 3, 4, 5},{1, 2, 3, 4, 5},{1, 2, 3, 4, 5},{1, 2, 3, 4, 5}};
    	
    	/*introduction*/
    	System.out.println("You are a city planner. You have just been assigned your first job.");
    	System.out.println("You have been entrusted to transform a 5 by 5 plot of field.");
    	System.out.println("What is your city name?");
    	name = scan.nextLine();
    	name = name.substring(0,1).toUpperCase() + name.substring(1,name.length());
    	System.out.println("\nWelcome to " + name + " City!");
    	getCity(city);
    	System.out.println("\nHere is a handy guide to the lettering of the city model:");
    	System.out.println("F = Field (free)");
    	System.out.println("H = Hospital (" + hPrice + ")");
    	System.out.println("S = School (" + sPrice + ")");
    	System.out.println("B = Bank (" + bPrice + ")");
    	System.out.println("A = Apartment (" + aPrice + ")");
    	System.out.println("L = Library (" + lPrice + ")");
    	System.out.println("V = Vendor (" + vPrice + ")");
    	System.out.println("P = Park (" + pPrice + ")");
    	System.out.println("\nYour budget is: " + budget);
    	
    	/*mini guide*/
    	System.out.println("Here are the coordinates you will have to attach to your building of choice:");
    	for(int r = 0; r < rep.length; r++){
    	    System.out.print("Row "+ (r+1) + ": ");
    	    for(int c = 0; c<rep.length; c++){
    	        System.out.print(rep[r][c] + "  ");
    	    }
    	    System.out.println("");
    	}
    	System.out.println("If you wanted to access Row 1, Column 3 you would respond:");
    	System.out.println("Row: " + 1);
    	System.out.println("Column: " + 3);
    	System.out.println("\nLet's Start!\n");
    	
    	/*row & column set up*/
    	int row;
    	int col;
    	/*first apartment*/
    	System.out.println("Firstly, you need to build an apartment. Decide where you want to place this plot.");
    	/*while loop*/
    	while(budget>0&&round<26){
    	    /*set row*/
    	    System.out.println("Row:");
    	    row = scan.nextInt() -1;
    	    
    	    /*row check*/
    	    if(row>4){
    	        row = 4;
    	    }
    	    if(row<0){
    	        row = 0;
    	    }
    	    scan.nextLine();
    	    
    	    /*set column*/
    	    System.out.println("Column:");
    	    col = scan.nextInt() -1;
    	    
    	    /*column check*/
    	    if(col>4){
    	        col = 4;
    	    }
    	    if(col<0){
    	        col = 0;
    	    }
    	    scan.nextLine();
    	    
    	    /*set build type*/
    	    String ch;
    	    if(round!=0){
    	        System.out.println("Type your build:");
    	        ch = scan.nextLine().toUpperCase();
    	    }
    	    else{
    	        ch = "A";
    	    }
    	    
    	    /*if statements*/
    	    if((!(city[row][col].equals("F")))||(!(ch.equals("H")||ch.equals("S")||ch.equals("B")||ch.equals("A")||ch.equals("L")||ch.equals("V")||ch.equals("P")))){
    	        System.out.println("Invalid building or coordinates.");
    	    }
    	    else{
    	        /*set everything*/
    	        city[row][col] = ch;
    	        round++;
    	        /*building if statements*/
    	        /*Hospital*/
    	        if(ch.equals("H")){
    	            budget -= hPrice;
    	            health += 3;
    	        }
    	        
    	        /*School*/
                else if(ch.equals("S")){
    	            budget -= sPrice;
    	            edu += 3;
    	        }
    	        
    	        /*Bank*/
    	        else if(ch.equals("B")){
    	            budget -= bPrice;
    	            econ += 3;
    	        }
    	        
    	        /*Apartment*/
    	        else if(ch.equals("A")){
    	            budget -= aPrice;
    	            pop += 50;
    	            happy += 2;
    	        }
    	        
    	        /*Library*/
    	        else if(ch.equals("L")){
    	            budget -= lPrice;
    	            happy += 2;
    	            edu += 2;
    	        }
    	        
    	        /*Vendor*/
    	        else if(ch.equals("V")){
    	            budget -= vPrice;
    	            happy += 1;
    	            econ += 2;
    	        }
    	        
    	        /*Park*/
    	        else if(ch.equals("P")){
    	            budget -= pPrice;
    	            happy += 2;
    	            health += 1;
    	        }
    	        
    	        /*print city*/
    	        System.out.println();
    	        getCity(city);
    	        System.out.println();
    	        
    	        /*events*/
    	        boolean ovpop = false;
    	        boolean outbreak = false;
    	        boolean oneEcon = false;
    	        boolean twoEcon = false;
    	        boolean threeEcon = false;
    	        boolean fourEcon = false;
    	        boolean onePop = false;
    	        boolean twoPop = false;
    	        boolean threePop = false;
    	        boolean fourPop = false;
    	        
    	        /*large events*/
                if(pop>550 && ovpop==false){
                    System.out.println("Overpopulation! Consider building less apartments");
                    ovpop = true;
                    happy-=5;
    	        }
    	        
    	        if(round>=10 && (pop/getNum(city,"H")>150)&&outbreak==false){
    	            System.out.println("Disease Outbreak! There are not enough hospitals. Health has decreased.");
    	            outbreak = true;
    	            happy-=3;
    	            health-=5;
    	        }
    	        
    	        if(round>=10 && (pop/getNum(city,"H")<=150)&&outbreak==true){
    	            System.out.println("The disease has been contained due to an increase in hospitals.");
    	            outbreak = false;
    	            happy++;
    	            health+=2;
    	        }
    	        
    	        /*population increase or decrease events*/
    	        if(happy>=3 && econ>=3 && health>=3 && edu>=3 && onePop==false && round<6){
    	            System.out.println("The conditions of your city have attracted movers.");
    	            onePop = true;
    	            pop+=20;
    	        }
    	        if(happy>=6 && econ>=6 && health>=6 && edu>=6 && twoPop==false && round<11){
    	            System.out.println("The conditions of your city have attracted movers.");
    	            twoPop = true;
    	            pop+=20;
    	        }
    	        if(happy>=10 && econ>=10 && health>=10 && edu>=6 && threePop==false && round<16){
    	            System.out.println("The conditions of your city have attracted movers.");
    	            threePop = true;
    	            pop+=20;
    	        }
    	        if(happy>=15 && econ>=15 && health>=15 && edu>=15 && fourPop==false && round<21){
    	            System.out.println("The conditions of your city have attracted movers.");
    	            fourPop = true;
    	            pop+=20;
    	        }
    	        
    	        /*economy events*/
    	        if(econ>=5 && oneEcon==false && round<6){
    	            System.out.println("The economy is thriving! Budget increased.");
    	            budget += 10000;
    	            oneEcon = true;
    	        }
    	        if(econ>=10 && twoEcon==false && round<11){
    	            System.out.println("The economy is thriving! Budget increased.");
    	            budget += 10000;
    	            twoEcon = true;
    	        }
    	        if(econ>=15 && threeEcon==false && round<16){
    	            System.out.println("The economy is thriving! Budget increased.");
    	            budget += 10000;
    	            threeEcon = true;
    	        }
    	        if(econ>=20 && fourEcon==false && round<21){
    	            System.out.println("The economy is thriving! Budget increased");
    	            budget += 10000;
    	            fourEcon = true;
    	        }
    	       
    	       if(round!=0&&round%5==0){
    	           System.out.println("\nA year has passed!\n");
    	           /*tax income*/
    	           int taxIncome = pop*200;
    	           budget += taxIncome;
    	           System.out.println("You have collected " + taxIncome + " in yearly tax income.");
    	           
    	           /*investment if statements*/
    	           int amt = 1000;
    	           System.out.println("It's time to invest in departments of your choice:");
    	           for(int i = 0; i<invest.size(); i++){
    	               System.out.println(invest.get(i).getName());
    	           }
    	           if(round==5){
    	               System.out.println("\nYou will invest by scale. For example, a \"1\" Investment equals " + amt + " budget spent. Increasing the");
    	               System.out.println("scale increases that budget amount by your scale.");
    	           }
    	           System.out.println("Current Budget: " + budget);
    	           System.out.println("Indicate the scale you want to invest in order:");
    	           for(int i = 0; i<invest.size(); i++){
    	               Investment index = invest.get(i);
    	               
    	               /*set cost*/
    	               int scale = scan.nextInt();
    	               int cost = scale * amt;
    	               index.setCost(cost);
    	               budget -= cost;
    	               
    	               /*stats*/
    	               happy += index.getHappy()*scale;
    	               econ += index.getEcon()*scale;
    	               health += index.getHealth()*scale;
    	               edu += index.getEdu()*scale;
    	           }
    	       }
    	    }
    	}
    	
    	/*ending*/
    	System.out.println("You have completed the game.");
    	boolean isField = false;
    	for(int r = 0; r<city.length; r++){
        	for(int c = 0; c<city.length; c++){
            	if(!(city[r][c].equals("F"))){
            	    isField = true;
            	}
            	else{
            	    isField = false;
            	    break;
            	}
        	}
    	}
    	if(isField){
    	    System.out.println("Congratulations! You have filled in every field.");
    	}
    	System.out.println("Here are your statistics:");
    	System.out.println("Rounds: " + round);
    	System.out.println("Happiness: " + happy);
    	System.out.println("Economy: " + econ);
    	System.out.println("Health: " + health);
    	System.out.println("Education: " + edu);
    	System.out.println("Population: " + pop);
	}
}

class Investment{
    private String name = "";
    private int happy;
    private int econ;
    private int health;
    private int edu;
    private int cost = 0;
    public Investment(String name, int happy, int econ, int health, int edu){
        this.name = name;
        this.happy = happy;
        this.econ = econ;
        this.health = health;
        this.edu = edu;
    }
    public int getHappy(){
        return happy;
    }
    public int getEcon(){
        return econ;
    }
    public int getHealth(){
        return health;
    }
    public int getEdu(){
        return edu;
    }
    public String getName(){
        return name;
    }
    public int getCost(){
        return cost;
    }
    public void setCost(int cost){
        this.cost = cost;
    }
}
