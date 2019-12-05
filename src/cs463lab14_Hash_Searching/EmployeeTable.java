/**
 * EmployeeTable.java
 * a hash table EmployeeTable to implement the open-address hashing data structure, the keys are not identical to each other
 * @since 3 Dec 2019
 * @author Huiying Chen
 */
package cs463lab14_Hash_Searching;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class EmployeeTable {
	private int manyItems;
	private Object[ ] keys; //unique identifying value
	private Object[ ] data;
	private boolean[ ] used;
	
	/**
	 * constructor
	 * @param capacity - the initial table capacity
	 * @throws IllegalArgumentException - indicates the parameter capacity is negative
	 */
	public EmployeeTable(int capacity) {
		if (capacity <= 0) {
			throw new IllegalArgumentException("Capacity is negative.");
		}
		keys = new Object[capacity];
		data = new Object[capacity];
		used = new boolean[capacity];
	}
	
	/**
	 * return a valid index of the table’s array
	 * @param employeeNum - employee number, the key of the table 
	 * @return a valid index of the table’s array
	 */
	private int hash(Object key) {
		return Math.abs(key.hashCode( )) % data.length;
	}
	
	
	/**
	 * get the next index in the table
	 * @param i - the starting index
	 * @return the next index, will back to 0 if reached data.length 
	 */
	private int nextIndex(int i) {
		if (i+1 == data.length) {
			return 0;
		}else {
			return i+1;
		}
	}
	
	/**
	 * Add a new employee e into the hash table
	 * @param e - the new employee to be added
	 * @throws IllegalStateException - indicates the table is full
	 */
	public void put(Employee e) {
		int index = findIndex(e.no);
		//The key already exists in the table
		if (index != -1) {
			data[index] = e;
		}
		//the key not yet in the table
		else if(manyItems < data.length) {
			index = hash(e.no);
			while(keys[index]!=null) {
				index = nextIndex(index);
			}
			keys[index] = e.no;
			data[index] = e;
			used[index] = true;
			manyItems++;
		}
		//the table is full
		else {
			throw new IllegalStateException("Table is full.");
		}
	}
	
	
	/**
	 * Remove a given employee with employee id emp_no from the hash table
	 * @param emp_no - the number of the employee, which is the key of Employee object in the table
	 * @return false if an employee with emp_no does not exist in the hash table; Otherwise, remove it and return true.
	 */
	public boolean remove(int emp_no) {
		int index = findIndex(emp_no);
		//found the target employee number in the table
		if (index!=-1) {
			keys[index] = null;
			data[index] = null;
			manyItems--;
			return true;
		}
		//not found
		return false;
	}
	
	
	/**
	 * find specified key in the table
	 * @param key - the target key
	 * @return index of the key if found, otherwise return -1
	 */
	private int findIndex(Object key) {
		int count = 0;
		int i = hash(key);
		while ((count < data.length) && (used[i])) {
			if (key.equals(keys[i])) {
				return i;
			}
			count++;
			i = nextIndex(i);
		}
		return -1;
	}
	
	
	/**
	 * Find the index of the given employee id emp_no
	 * @param emp_no - the given employee id
	 * @return the index of the employee in the array if the employee with the given employee no exists in the hash table; otherwise, return -1
	 */
	public int search(int emp_no) {
		int answer = findIndex(emp_no);
		return answer;
	}
	       
	
	
	/**
	 * main
	 */
	public static void main(String[] args) {
		//initial a new employee table
		EmployeeTable empTab = new EmployeeTable(11);
		Employee e1 = new Employee("John Smith", 1, "NM", 88001, 20);
		Employee e2 = new Employee("Amy Brown", 13, "CA", 90224, 25);
		Employee e3 = new Employee("Noelle Johnson", 4, "DC", 20001, 28);
		Employee e4 = new Employee("Sandra Martin", 15, "NY", 10001, 34);
		Employee e5 = new Employee("Prater Jeremy", 13, "NM", 88033, 29);
		System.out.printf("The capacity of the table: " + empTab.data.length);
		
		//test put()
		empTab.put(e1);
		empTab.put(e2);
		empTab.put(e3);
		empTab.put(e4);
		System.out.printf("\nThe number of element in the table: " + empTab.manyItems);
		System.out.println();
		System.out.println(empTab.data[empTab.search(1)].toString());
		System.out.println(empTab.data[empTab.search(13)].toString());
		System.out.println(empTab.data[empTab.search(4)].toString());
		System.out.println(empTab.data[empTab.search(15)].toString());
		System.out.println("\ntest add the same key: ");
		empTab.put(e5);
		System.out.println(empTab.data[empTab.search(13)].toString());
		System.out.printf("The number of element in the table: " + empTab.manyItems);
		
		//test hash()
		System.out.println("\n\ntest hash(): ");
		System.out.printf("hash(e1)(1) = " + empTab.hash(e1.no));
		System.out.printf("\nhash(e4)(15) = " + empTab.hash(e4.no));
		
		//test search()
		System.out.println("\n\ntest search(): ");
		System.out.printf("The index of employee_no = 1 is: " + empTab.search(1));
		System.out.printf("\nThe index of employee_no = 4 is: " + empTab.search(4));
		//test same modulus 
		System.out.printf("\nThe index of employee_no = 15(same modulus) is: " + empTab.search(15));
		//search non-exist employee_no
		System.out.printf("\nThe index of employee_no = 3(non-exist) is: " + empTab.search(3));
	
		//test remove()
		System.out.println("\n\ntest remove(): ");
		boolean removed;
		removed = empTab.remove(1);
		System.out.printf("After remove 1: " + removed);
		System.out.printf("\nThe index of employee_no = 1: " + empTab.search(1));
		removed = empTab.remove(9);
		System.out.printf("\nRemove 9(non-exist): " + removed);
		System.out.println("\n");
		
		
		//HashMap implementation
		System.out.println("HashMap implementation: ");
		HashMap<Integer, Employee> hmap = new HashMap<Integer, Employee>();
		/*Adding elements to HashMap by using HashSet*/
		//String csvFile = "C:\\Users\\Lexa\\eclipse-workspace\\cs272program\\src\\cs463lab14_Hash_Searching\\core_dataset.csv";
		String csvFile = "core_dataset.csv";

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
                	Employee employee = new Employee();
                	employee.name = lineStr[0]+lineStr[1];
                	employee.no = Integer.parseInt(lineStr[2]);
                	employee.state = lineStr[3];
                	employee.zip = Integer.parseInt(lineStr[4]);
                	employee.age = Integer.parseInt(lineStr[6]);
                	hmap.put(employee.no, employee);
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
		
       	/*Show the size of the data structure that keeps the employees after the adding, removal,
and search operation*/
       	System.out.printf("the size of the HashMap: " + hmap.size());
       	
       	/* Remove values based on key*/
       	System.out.println("\n\nRemove employees with nos 1112030816, 1111030148, and 602000312");
        hmap.remove(1112030816);
        hmap.remove(1111030148);
        hmap.remove(602000312);
        System.out.printf("After removal, the size of the HashMap: " + hmap.size());
        
        /* Search values based on key*/
        System.out.println("\n\nSearch employees with employee no 1501072093 and 1111030148");	
        System.out.println("Search employee no = 1501072093: ");
        if (hmap.get(1501072093)!=null) {
        	System.out.println(hmap.get(1501072093).toString());
        }else {
        	System.out.println("The employee does not exist.");
        }
        System.out.println("Search employee no = 1111030148: ");
        if (hmap.get(1111030148)!=null) {
        	System.out.println(hmap.get(1111030148).toString());
        }else {
        	System.out.println("The employee does not exist.");
        }
        System.out.printf("After searching, the size of the HashMap: " + hmap.size());
        
        
	}
	
	
	
}
