package cs463lab1_fileOp;

import java.io.*;
import java.util.*;

class Employee{
	
	String EmployeeName;
	String State;
	String Sex;
	String Zip;
	int Age;
	String EmployeeNumber;

}


public class EmployeeFileOp {
	
		   private static Employee[] Employees = new Employee[301];
		   private static int linenum = 0;
		   private static String header = "";
		   
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
		                	String[] lineStr = line.split(",");
		                	Employees[no-1] = new Employee();
		                	Employees[no-1].EmployeeName = lineStr[0]+lineStr[1];
		                	Employees[no-1].EmployeeNumber = lineStr[2];
		                	Employees[no-1].State = lineStr[3];
		                	Employees[no-1].Zip = lineStr[4];
		                	Employees[no-1].Age = Integer.parseInt(lineStr[6]);
		                	Employees[no-1].Sex = lineStr[7];
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
		   }
		  
		 
		   
		   public static void write(String newcsvFile){
				try {
					File file = new File(newcsvFile);
					FileWriter fw = new FileWriter(file.getAbsoluteFile());
					BufferedWriter bw = new BufferedWriter(fw); 
					bw.write("Employee Name,"+"Employee Number,"+"State,"+"Zip,"+"Age,"+"Sex"+"\n");
					int j=0;
					for(int i=0;i<Employees.length;i++){
						//System.out.println("i="+i+":" + Employees[i].EmployeeName+"\t"+Employees[i].EmployeeNumber+"\t"+Employees[i].State+"\t"+Employees[i].Zip+"\t"+Employees[i].Age+"\t"+Employees[i].Sex+"\n");
						
						if(Employees[i].Age <= 30)
						{
							//System.out.println(i + "Age:" + Employees[i].Age);
							j++;
							bw.write(Employees[i].EmployeeName+","+Employees[i].EmployeeNumber+","+Employees[i].State+","+Employees[i].Zip+","+Employees[i].Age+","+Employees[i].Sex+"\n");
						
						}
						}
					System.out.println("Number of Employees under 30: "+j);
					bw.close();
					fw.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
				
				System.out.println("Finish writing young Employees to file ");
			}
			
		   
	public static void main(String[] args) {
		//String csvFile = "C:\\Users\\Lexa\\eclipse-workspace\\cs272program\\src\\core_dataset.csv";
		//String newcsvFile = "C:\\Users\\Lexa\\eclipse-workspace\\cs272program\\src\\young_Employee.csv";
		String csvFile = "core_dataset.csv";
		String newcsvFile = "young_Employee.csv";
		EmployeeFileOp.read(csvFile);
		EmployeeFileOp.write(newcsvFile); 
	}
	
}