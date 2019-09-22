
import java.io.*;
import java.util.*;

class employeee{
	
	String EmployeeName;
	String State;
	String Sex;
	String Zip;
	int Age;
	String EmployeeNumber;

}

/*
class young_employee{
	
	String EmployeeName;
	String State;
	String Sex;
	String EmployeeNumber;
	String Zip;
	int Age;

}
*/

public class EmployeeFileOp {
	
/*	  static int num;
	  public static void count(String csvFile) {
		     
	       int no = 0; 
	       String line = "";
			
		   try {
	            FileReader fr = new FileReader(csvFile);
	            BufferedReader br = new BufferedReader(fr);

	            while((line = br.readLine()) != null) {
               	no++;
	            }
	            br.close();
	            num = no-2;
		   }
	       catch(FileNotFoundException ex) {
	    	   	System.out.println("Unable to open file ");                
	       }catch(IOException ex) {
	    	   	System.out.println("Error reading file ");                  
	       }

		  System.out.println("Finish counting, linenum="+num);

	   }  */
	  
	 
	
		   private static employeee[] employees = new employeee[302];
		   //private static young_employee[] young_employees = null;
		   private static int linenum = 0;
		   private static String header = "";
		   public static final String delimiter = ",";
		   
		   public static void read(String csvFile) {
		     
		       int no = 0; 
		       String line = "";
				
			   try {
		            FileReader fr = new FileReader(csvFile);
		            BufferedReader br = new BufferedReader(fr);

		            while((line = br.readLine()) != null) {
		            	if(no==302)
		            	{
		            	break;
		            	}
		            	if(no==0){
		            		header = line; 
		            	}else{
		                	String[] lineStr = line.split(delimiter);
		                	//System.out.println("lineStr.length="+lineStr.length +",no="+no);
		                	
		                	employees[no-1] = new employeee();
		                	employees[no-1].EmployeeName = lineStr[0]+lineStr[1];
		                	employees[no-1].EmployeeNumber = lineStr[2];
		                	employees[no-1].State = lineStr[3];
		                	employees[no-1].Zip = lineStr[4];
		                	employees[no-1].Age = Integer.parseInt(lineStr[6]);
		                	employees[no-1].Sex = lineStr[7];
		                	//System.out.println("read, no"+(no) +": "+ employees[no-1].EmployeeName);
		                	//test
		                	//System.out.println(no + employees[no-1].Sex);
		            	}
	                	no++;
		            }
		            br.close();
		            linenum = no-1;
			   }
		       catch(FileNotFoundException ex) {
		    	   	System.out.println("Unable to open file ");                
		       }catch(IOException ex) {
		    	   	System.out.println("Error reading file ");                  
		       }

			  System.out.println("Finish reading from file, linenum="+linenum);
			   //System.out.println(employees[90].Age+"hahahha");

		   }
		  
		 
		   
		   public static void write(String newcsvFile){
				try {
					File file = new File(newcsvFile);
					
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw);
					
	                //young_employees = new young_employee[employees.length];
	                //System.out.println("employees.length="+employees.length);
					bw.write("Employee Name,"+"Employee Number,"+"State,"+"Zip,"+"Age,"+"Sex"+"\n");
					
					int j=0;
					for(int i=0;i<employees.length;i++){
						//System.out.println("i="+i+":" + employees[i].EmployeeName+"\t"+employees[i].EmployeeNumber+"\t"+employees[i].State+"\t"+employees[i].Zip+"\t"+employees[i].Age+"\t"+employees[i].Sex+"\n");
						
						if(employees[i].Age <= 30)
						{
							//System.out.println(i + "Age:" + employees[i].Age);
							j++;
							bw.write(employees[i].EmployeeName+","+employees[i].EmployeeNumber+","+employees[i].State+","+employees[i].Zip+","+employees[i].Age+","+employees[i].Sex+"\n");
						
						}
						}
					System.out.println("Number of employees under 30: "+j);
					
					/*  young_employees[i].EmployeeName = employees[i].EmployeeName;
						young_employees[i].EmployeeNumber = employees[i].EmployeeNumber;
						young_employees[i].State = employees[i].State;
						young_employees[i].Zip = employees[i].Zip;
						young_employees[i].Age = employees[i].Age;
						young_employees[i].Sex = employees[i].Sex;     */
						
					bw.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finish writing young employees to file ");
			}
			
		   
	public static void main(String[] args) {
		String csvFile = "C:\\Users\\Lexa\\eclipse-workspace\\cs272program\\src\\core_dataset.csv";
		String newcsvFile = "C:\\Users\\Lexa\\eclipse-workspace\\cs272program\\src\\young_employee.csv";
		//String csvFile = "core_dataset.csv";
		//String newcsvFile = "young_employee.csv";
		EmployeeFileOp.count(csvFile);
		EmployeeFileOp.read(csvFile);
		EmployeeFileOp.write(newcsvFile); 
	}
	
}