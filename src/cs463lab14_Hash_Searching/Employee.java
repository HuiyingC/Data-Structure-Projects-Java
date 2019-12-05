package cs463lab14_Hash_Searching;


public class Employee {

	//declare variables
	String name;
	int no;
	String state;
	int zip;
	int age;
	
//no-arguments constructor
	public Employee() {
		//sets null to Employee name, state, and zip codes, sets 0 to Employee number and
		//Employee age, and sets advisor array to be null.
	    name = null;
	    no = 0;
		state = null;
		zip = 0;
		age = 0;
	}//end no-arguments constructor
	
	//constructor
	public Employee(String n, int eno, String s, int z, int a) {
	    name = n;
	    no = eno;
		state = s;
		zip = z;
		age = a;
	}
	
// copy constructor
	public Employee(Object obj) {
		//obj should not be null and should be an instance of Employee
		if((obj != null) &&	(obj instanceof Employee)){	
			//Creates new instance of Employee object
			Employee Employee_copy = (Employee) obj;	
			this.no = Employee_copy.no;
			this.zip = Employee_copy.zip;
			this.age = Employee_copy.age;
			this.name =	new	String(Employee_copy.name);	
			this.state = new String(Employee_copy.state);	
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
	
	public int getEmoloyeeZip( ) {
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
	
	
//set methods of all the instance variables
	public void setEmoloyeeName ( String n ) {
		   name = n;
		   System.out.println("setName: " + name);
	} 
	
	public void setEmoloyeeNum ( int num ) {
		   no = num;
		   System.out.println("setNum: " + no);
	} 
	
	public void setEmoloyeeZip ( int z ) {
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
	
	
//generate a string representation of an Employee's info	
	public String toString() {
		return "Employee name: " + name + ", " + "number: " + no+ ", " + "state: " + state + ", " + "zip: " + zip 
				+ ", " + "age: " + age;
	}
	
//returns true if the given object’s Employee no is the same as the no of the given
//Employee instance which activates this method
	public boolean equals(Object obj) {
		//check obj should not be null and should be an instance of the Employee class
		if (obj instanceof Employee && obj != null) {
			Employee candidate = (Employee) obj;
			if (candidate.no == no) {
				//print meaningful info 
				System.out.print("The two Employees' number are equal");
				return true;
			}else{
				//print meaningful info 
				System.out.print("The two Employees' number are not equal");
				return false;
			}
		}//end if
			System.out.print("Error. obj should not be null and should be an instance of the Employee class");
			return false;
	}//end equals
	
}




	
	
