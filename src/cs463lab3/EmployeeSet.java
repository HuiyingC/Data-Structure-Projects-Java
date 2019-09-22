/**
 * EmployeeSet is used to to store and manipulate distinct employees information.
 * @author: Huiying Chen
 * @create date: 09 SEP 2019
 * @last modified date: 12 SEP 2019
*/

package cs463lab3;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class EmployeeSet implements Cloneable{
	//declare variables
	private int employees_count = 0; //count how many employee objects in EmployeeSet    
	private employee[] employees;  //declare employee objects array
	
	//A no-argument constructor, which initializes an EmployeeSet instance
	public EmployeeSet() {
		//creates an object array to store 10 employee objects
		employees = new employee[10];
	}
	
	//A copy constructor, which creates a new EmployeeSet instance and copies the content of the
	//given object to the new instance
	public EmployeeSet(Object obj) {
	//obj should NOT be null and should be an instance of EmployeeSet
		if ((obj != null) && (obj instanceof EmployeeSet)) {	
			//Creates new instance of EmployeeSet object
			EmployeeSet EmployeeSet_copy = (EmployeeSet) obj;	
			this.employees_count = EmployeeSet_copy.employees_count;
			this.employees = EmployeeSet_copy.employees.clone();
		}//End of IF
	}//End of Constructor(Copy)
	
	//returns the actual number of employee objects in this collection
	public int size() {
		return employees_count;
	}
	
	//returns the capacity of this collection instance
	public int capacity() {
		return employees.length;
	}
	
	//adds one given employee object(without duplication) to the first available space of the employee
	//array in this EmployeeSet instance
	//When the collection space is sufficient to hold the new employee,
	//this employee object can be directly added to the collection. Otherwise, you need to double the space
	//of the instance array by implementing a method ensureCapacity (defined below).
	public void add(employee a) {
		//check the employee object a should NOT be null
		if (a != null) {
			//guarantees the capacity of the collection
			//double the capacity and add 1; this works even if the employees array length is 0
			if (this.employees_count == this.employees.length) {
				ensureCapacity(this.employees_count * 2 + 1);
			}
			//check whether this collection already has the same employee object identified by employee's number 
			if (this.contains(a)) {
				System.out.println("This colletion already has the same employee object.");
			}else {		
				//add a to the first available space of the employee array in this EmployeeSet instance
				this.employees[this.employees_count] = a;
				//employee objects amount adds 1
				this.employees_count++;
			}//end if check duplicate and add
		}else
		//if a is null, return false
		System.out.println("The parameter employee object is null");
	}
	
	//check whether this collection contains the input parameter
	//• If a is a null object, directly return false.
	//• If a is not a null object,
	//– if this collection contains an employee object, which equals to a, then return true;
	//– Otherwise, return false.
	public boolean contains(employee a) {
		int index;
		//check the input parameter employee object a should NOT be null
		if (a != null) {
		//check whether this collection contains the employee object a
			for (index = 0;index < this.employees_count;index++) {
				//check whether elements in this collection equal to the target employee object a  
				if (this.employees[index] == a) {
					System.out.println("The collection contains the employee");
					return true;
				}//end if 
			}//end for
			//this collection does not contain a, return false
			if (index == this.employees_count) { 
				System.out.println("The collection does not contain the parameter employee object");
				return false;
			}//end if
		}//end if
		//if a is null, return false
		System.out.println("The parameter employee object is null");
		return false;
	}
	
	
	//remove from the collection the employee with the given employee no 
	//– if this collection contains one employee object a1 whose employee no equals to eno, then
	//remove a1 from this collection and return true;
	//– Otherwise, do nothing and return false.
	public boolean remove(int eno) {
		int index;
		for	(index = 0;(index < this.employees_count) && (eno != this.employees[index].no);index++) 						
			//The target eno was not found, so nothing is removed
			if (index == this.employees_count) {
				System.out.println("The collection does not contain the employee with this employee number");
				return false;
			}//end if 
			//The target eno was found at employees[index]
			if (eno == this.employees[index].no) {	
				//Reduce employees_count by 1 and copy the last	element onto employees[index]
				this.employees_count--;
				this.employees[index] = this.employees[this.employees_count];
				System.out.println("Remove successfully.");
				return true;
			}
			System.out.println("Error. Remove failed.");
			return false;
	}
	
	//guarantees the capacity of the collection
	//If this collection’s capacity is smaller than the input parameter, this method sets the capacity to
	//minimumCapacity and enlarges the array to hold minimumCapacity objects;
	//Otherwise, this collection is left unchanged.
	private void ensureCapacity(int minimumCapacity) {
		//declare a new array to hold minimumCapacity objects
		employee[] biggerArray;
		//check minimumCapacity should be positive
		if (minimumCapacity > 0) {
			if (this.employees.length < minimumCapacity) {
				//enlarges the array to hold minimumCapacity objects
				biggerArray = new employee[minimumCapacity];
				//copy data to the new bigger array
				System.arraycopy(this.employees, 0, biggerArray, 0, this.employees_count);
				//refer this collection t  o the new bigger array
				this.employees = biggerArray; 
				System.out.println("Capacity double enlarged.");
			}//end if
			else
			System.out.println("Capacity is enough.");
		}//end if check
		else
			//prints error information
			System.out.println("MinimumCapacity should be positive.");
	}
	
	// A method which adds one employee object to this EmployeeSet instance such that the objects
	//in the employee array are in ascending order of employee nos. When the collection space is sufficient
	//to hold the new employee, this employee object can be directly added to the collection. Otherwise,
	//you need to double the space of the instance array by calling the method ensureCapacity.
	//The preconditions are that
	//• the employee object a should NOT be null, and
	//• the objects in the collect ion’s employee array are already in ascending order of employee nos.
	public void addOrdered(employee a) {
	    //add a to the collection 
	    this.add(a);   
		//selection sort to ensure the objects in the collection’s employee array are in ascending order of employee nos
	    for (int i = 0; i < this.employees_count-1; i++) {
	        int min_eno = this.employees[i].no;
	    	int min_index = i;
	        for (int j = i+1; j < this.employees_count; j++) {
	            if (this.employees[j].no < min_eno) {
	            	min_eno = this.employees[j].no;
	                min_index = j;
		            // swapping
			        employee temp = new employee();
			        temp = this.employees[min_index];
			        this.employees[min_index] = this.employees[i];
			        this.employees[i] = temp;
	            }//end if
	        }//end for
	    }//end for

//		//prints sorted collection
//		int index = 0;
//		for (index = 0;index < this.employees_count;index++) {
//			System.out.println(this.employees[index].toString());
//		}
	}
	
	//read function to read and parse csv file data to collection with keeping it in ascending order of employee nos 
	public void readOrdered(String csvFile) {
       int no = 0; 
       String line = "";
       int linenum = 0;
       String header = "";
	       
       try {
            FileReader fr = new FileReader(csvFile);
            BufferedReader br = new BufferedReader(fr);
            while((line = br.readLine()) != null) {
            	if(no==302) {
            		break;
            	}//end if
            	if(no==0){
            		header = line; 
            	}else{
                	String[] lineStr = line.split(",");
                	employee Employee = new employee();
                	Employee.name = lineStr[0]+lineStr[1];
                	Employee.no = Integer.parseInt(lineStr[2]);
                	Employee.state = lineStr[3];
                	Employee.zip = lineStr[4];
                	Employee.age = Integer.parseInt(lineStr[6]);
                	this.addOrdered(Employee);
            	}//end if
            	no++;
            }//end while loop
            br.close();
            linenum = no-1;
		   	}catch(FileNotFoundException ex) {
	    	   	System.out.println("Unable to open file ");                
		   	}catch(IOException ex) {
	    	   	System.out.println("Error reading file ");                  
		   	}
       		System.out.println("Finish reading from file, linenum="+linenum);
	   }//end read
		

	//main 
	public static void main(String[] args) {
		//initialize a new collection
		EmployeeSet test_EmployeeSet = new EmployeeSet();
		
/*
//#1 test cases by using core_dataset.csv including addOrdered(employee a), add(employee a), ensureCapacity(int minimumCapacity) methods
		//String csvFile = "C:\\Users\\Lexa\\eclipse-workspace\\cs272program\\src\\cs463lab\\core_dataset.csv";
		String csvFile = "core_dataset.csv";
		test_EmployeeSet.readOrdered(csvFile);
		//prints results	
		for (int i=0;i<test_EmployeeSet.employees_count;i++) {
			System.out.println(test_EmployeeSet.employees[i].toString());
		}
*/
		
		
		
//#2 test cases including size(), capacity(), add(employee a), addOrdered(employee a), ensureCapacity(int minimumCapacity), contains(employee a), remove(int eno) methods
		employee a = new employee();
		employee b = new employee();
		employee c = new employee();
		employee d = new employee();
		employee e = new employee();
		employee f = new employee();
		e = null;
		a.setEmoloyeeName("add_test_a");
		a.setEmoloyeeNum(11);
		b.setEmoloyeeName("add_test_b");
		b.setEmoloyeeNum(22);
		c.setEmoloyeeName("add_test_c");
		c.setEmoloyeeNum(33);
		d.setEmoloyeeName("add_test_d");
		d.setEmoloyeeNum(15);
		f.setEmoloyeeName("add_test_f");
		f.setEmoloyeeNum(36);

		
		test_EmployeeSet.add(c);
		test_EmployeeSet.add(b);
		test_EmployeeSet.add(a);
		test_EmployeeSet.add(f);
		test_EmployeeSet.addOrdered(d);
		test_EmployeeSet.contains(d);
		//test add(null)
		test_EmployeeSet.add(e);
		//test add duplicate employee object
		test_EmployeeSet.add(c);
		//test contains(employee a), remove(int eno) methods
		test_EmployeeSet.remove(22);
		test_EmployeeSet.contains(b);
		
		//prints results	
		for (int i=0;i<test_EmployeeSet.employees_count;i++) {
			System.out.println(test_EmployeeSet.employees[i].toString());
		}
		//test size(), capacity() methods
		System.out.println(test_EmployeeSet.size());
		System.out.println(test_EmployeeSet.capacity());
		
//#3 test case for copy constructor
		System.out.println("Test copy constructor: ");
		EmployeeSet EmployeeSet_Copy =  new EmployeeSet(test_EmployeeSet);
		//prints results	
		for (int i=0;i<EmployeeSet_Copy.employees_count;i++) {
			System.out.println(EmployeeSet_Copy.employees[i].toString());
		}//end for
		
		
	}//end main
	
}//end class