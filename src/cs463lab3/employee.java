//This is a simple but beautiful program to manipulate employee class
//Author: Huiying Chen
//Last modified data: 5 Sep 2019

package cs463lab3;

import java.util.*;

public class employee implements Cloneable {

	//declare variables
	String name;
	String state;
	int no;
	String zip;
	int age;
	int advisors[] = new int[3];
	
//no-arguments constructor
	public employee() {
		//sets null to employee name, state, and zip codes, sets 0 to employee number and
		//employee age, and sets advisor array to be null.
	    name = null;
		state = null;
		no = 0;
		zip = null;
		age = 0;
		advisors[0] = 0;
		advisors[1] = 0;
		advisors[2] = 0;

	}//end no-arguments constructor
	
// copy constructor
	public employee(Object obj) {
		//obj should not be null and should be an instance of Employee
		if((obj != null) &&	(obj instanceof employee)){	
			//Creates new instance of employee object
			employee employee_copy = (employee) obj;	
			this.no = employee_copy.no;
			this.zip = new	String(employee_copy.zip);
			this.age = employee_copy.age;
			this.name =	new	String(employee_copy.name);	
			this.state = new String(employee_copy.state);	
			this.advisors = employee_copy.advisors.clone();
		}//End of IF
	}//End of Constructor(Copy)
			
//get methods of all the instance variables		
	public String getEmoloyeeName( ) {
		System.out.println("getName: " + name);
		return name;
	}
	
	public int getEmoloyeeNum( ) {
		System.out.println("getNumber: " + no);
		return no;
	}
	
	public String getEmoloyeeZip( ) {
		System.out.println("getZip: " + zip);
		return zip;
	}
	
	public int getEmoloyeeAge( ) {
		System.out.println("getAge: " + age);
		return age;
	}
	
	public String getEmoloyeeState( ) {
		System.out.println("getState: " + state);
		return state;
	}
	
	public int[] getEmployeeAdvisors() {
		System.out.println("getAdvisors: " + advisors[0] + "," + advisors[1] + "," + advisors[2] );
		return advisors;
	}
	
//set methods of all the instance variables
	public void setEmoloyeeName ( String n ) {
		   name = n;
		   System.out.println("setName: " + name);
	} 
	
	public void setEmoloyeeNum ( int num ) {
		   no = num;
		   System.out.println("setNum: " + no);
	} 
	
	public void setEmoloyeeZip ( String z ) {
		   zip = z;
		   System.out.println("setZip: " + zip);
	} 
	
	public void setEmoloyeeAge ( int a ) {
		   age = a;
		   System.out.println("setAge: " + age);
	} 
	
	public void setEmoloyeeState ( String s ) {
		   state = s;
		   System.out.println("setState: " + state);
	} 
	
	public void setEmoloyeeAdvisors ( int advisor[] ) { 
		   int i = 0;
		   System.out.println("setAdvisors: ");
		   for(i=0;i<=2;i++) {
			   advisors[i]=advisor[i];
			   System.out.print(advisors[i] + ",");
		   }//end for loop   
	} 
	
//generate a string representation of an employee's info	
	public String toString() {
		return "Employee name: " + name + ", " + " number: " + no + ", " + " zip: " + zip 
				+ ", " + " age: " + age + ", " + " state: " + state 
				+ ", " + " advisors: " + advisors[0] + ", " + advisors[1] + ", " + advisors[2];
	}
	
//returns true if the given object’s employee no is the same as the no of the given
//employee instance which activates this method
	public boolean equals(Object obj) {
		//check obj should not be null and should be an instance of the employee class
		if (obj instanceof employee && obj != null) {
			employee candidate = (employee) obj;
			if (candidate.no == no) {
				//print meaningful info 
				System.out.print("The two employees' number are equal");
				return true;
			}else{
				//print meaningful info 
				System.out.print("The two employees' number are not equal");
				return false;
			}
		}//end if
			System.out.print("Error. obj should not be null and should be an instance of the employee class");
			return false;
	}//end equals
	
	
//get all the DISTINCT advisors of two employees
	public static int[] getAllAdvisors(employee e1, employee e2) {
		//get two employees' advisors to separated arrays 
		int advisorsArr1[] = e1.getEmployeeAdvisors();
		int advisorsArr2[] = e2.getEmployeeAdvisors();
		//initialize final array of advisors without duplications
	    int[] nodupesarray = new int[6];
	    System.out.println("All distinct advisors of the two employees are: ");
		//check neither e1 nor e2 should be null
	    if(e1 != null && e2 != null) {
			//initialize a new array and set all advisors of two employees into it
		    int[] advisorsArr = new int[6];
		    System.arraycopy(advisorsArr1, 0, advisorsArr, 0, 3);
		    System.arraycopy(advisorsArr2, 0, advisorsArr, 3, 3);
		    Set<Integer> advisorsArr_nodupes = new HashSet<Integer>();
		    for(int i=0;i<6;i++){
		    	advisorsArr_nodupes.add(advisorsArr[i]);
		    }//end for loop
		    //get final advisors array after merging without duplications 
		    int i = 0;
		    Iterator<Integer> it = advisorsArr_nodupes.iterator();
		    while(it.hasNext()){
		        nodupesarray[i] = it.next();
		        System.out.print(nodupesarray[i] + ",");
		        i++;
		    }
		}//end if
	    return nodupesarray;
	}//end getAllAdvisors method
	
	

//    public int compareTo(employee e) {
//         return (this.getEmoloyeeNum() - e.getEmoloyeeNum());
//    }
	
	
	
//main method for testing all methods
	public static void main(String[] args) {
	
/*
		//test set methods
		employee e_setTest = new employee();
		System.out.println("test set methods: ");
		e_setTest.setEmoloyeeName("Joy");
		e_setTest.setEmoloyeeState("CA");
		e_setTest.setEmoloyeeNum(666);
		e_setTest.setEmoloyeeAge(22);
		e_setTest.setEmoloyeeZip(88001);
		//test setEmoloyeeAdvisors(set to 0 if the employee doesn't have 3 advisors.)
		int[] advisorsTest = {1432,47,111};
		e_setTest.setEmoloyeeAdvisors(advisorsTest);
		System.out.println("\n");
*/
		
		
		
/*		
		//test get methods
		System.out.println("test get methods: ");
		e_setTest.getEmoloyeeName();
		e_setTest.getEmoloyeeNum();
		e_setTest.getEmoloyeeZip();
		e_setTest.getEmoloyeeState();
		e_setTest.getEmoloyeeAge();
		e_setTest.getEmployeeAdvisors();     
		System.out.println("");
*/
		
/*		
		//test copy constructor
		System.out.println("test copy constructor: ");
		int[] testAdvisorsArr = {15,2,41};
		employee e1 = new employee();
		e1.setEmoloyeeName("e1");
		e1.setEmoloyeeAge(31);
		e1.setEmoloyeeNum(1000001);
		e1.setEmoloyeeState("NM");
		e1.setEmoloyeeZip(88002);
        e1.setEmoloyeeAdvisors(testAdvisorsArr);            
		employee e1Copy =  new employee(e1);
		System.out.println("\nCopy constructor to e1Copy: ");
		System.out.print("e1Cppy: " + e1Copy.toString());
		System.out.println("\nTest After change e1Copy's name: ");
		//change e1 name
		e1Copy.name = "e1Copy";
		//test whether e1 name will change
		System.out.println("e1Name: " + e1.name + ", e1CopyName: " + e1Copy.name);
*/

	
/*		
	//test equal method
		System.out.println("\ntest equal method: ");
		//two employees number are equal
		System.out.println("The two employees number are equal: ");
		employee e1_equalTest = new employee();
		employee e2_equalTest = new employee();
		e1_equalTest.setEmoloyeeName("e1_equalTest");
		e2_equalTest.setEmoloyeeName("e2_equalTest");
		e1_equalTest.setEmoloyeeNum(1004324);
		e2_equalTest.setEmoloyeeNum(1004324);
		e1_equalTest.equals(e2_equalTest);
		System.out.print("\n");

		

		//two employees number are not equal
		System.out.println("\ntest two employees number are not equal: ");
		employee e3_equalTest = new employee();
		employee e4_equalTest = new employee();
		e3_equalTest.setEmoloyeeName("e3_equalTest");
		e4_equalTest.setEmoloyeeName("e4_equalTest");
		e3_equalTest.setEmoloyeeNum(1004324);
		e4_equalTest.setEmoloyeeNum(10033);
		e3_equalTest.equals(e4_equalTest);
		System.out.print("\n");
*/	
		
/*		
        //test getAllAdvisors method
		System.out.println("\ntest getAllAdvisors method: ");
		int[] e1_advisorsArr = {1,2,3};
		int[] e2_advisorsArr = {3,5,6};
		employee e1_getAllAdvisors_test = new employee();
		employee e2_getAllAdvisors_test = new employee();
		e1_getAllAdvisors_test.advisors = e1_advisorsArr;
		e2_getAllAdvisors_test.advisors = e2_advisorsArr;
		employee.getAllAdvisors(e1_getAllAdvisors_test, e2_getAllAdvisors_test);
		System.out.println("\n\nEnd test. Beautiful!");
*/		
		
	}//end main method
	
}//end class	

//??how to do simpler test in main
