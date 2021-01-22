package generic;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
public class ConnectDB {
	
	


		
	 	public boolean executesqlandverifytext()
		 {										
			
		
		try
		{
		    // STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    // STEP 3: Open a connection
		    System.out.println("Connecting to a selected database...");
		    DriverManager.setLoginTimeout(20);
		
		    String dbUrl = "jdbc:mysql://127.0.0.1/automation";
		    
		    
		  //Database Username		
			String username = "root";	
	        
			//Database Password		
			String password = "faridabad";				

			//Query to Execute		
			String query = "select *  from testcase;";	
		//	String query1 = " INSERT INTO employee (AGE,Name)VALUES (4341,'Praveen1')";	
	        

		    

		    
		    
		    Connection con = DriverManager.getConnection(dbUrl,username,password);
		  //Create Statement Object		
	    	   Statement stmt = con.createStatement();					
	   
	    	  // stmt.executeUpdate(query1);
	    	   
	    	   System.out.println(" SUCCESS!\n");
	    	   
	    	   
	   			// Execute the SQL Query. Store results in ResultSet		
	     		ResultSet rs= stmt.executeQuery(query);							
	     
	     		// While Loop to iterate through all data and print results		
				while (rs.next()){
					
					
			        		String TestCaseID = rs.getString(1);								        
	                        String TestCaseDesc = rs.getString(2);	
	                       
	                        System. out.println("Test Case Description of Test Case ID"+TestCaseID+" are :"+TestCaseDesc);
	          
	                    
				}

				 con.close();
					return true;
		}
		
		
		
		catch (SQLException | ClassNotFoundException e)
		{
			//keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
			e.printStackTrace();
			return false;
	    
		}// end finally try
	
		

	    }

		public boolean insertsql(String data)
		 {										
			
			String TempData1 = data.split("\\|")[0];
	
			
			
		try
		{
		    // STEP 2: Register JDBC driver
		    Class.forName("com.mysql.jdbc.Driver");

		    // STEP 3: Open a connection
		    System.out.println("Connecting to a selected database...");
		    DriverManager.setLoginTimeout(20);
		
		    String dbUrl = "jdbc:mysql://127.0.0.1/automation";
		    
		    
		  //Database Username		
			String username = "root";	
	        
			//Database Password		
			String password = "faridabad";				

			//Query to Execute		
			//String query = "select *  from employee;";	
			String query1 = " INSERT INTO testcase (TestCaseDesc)VALUES (?)";	
	        

		    

		    
		    
		    Connection con = DriverManager.getConnection(dbUrl,username,password);
		  //Create Statement Object		
	    	//   Statement stmt = con.createStatement();					
	   
	    	   
	    	   PreparedStatement preparedStmt = con.prepareStatement(query1);
	    	     
	    	   
	    	   preparedStmt.setString (1, TempData1);
	    	 
	    	      // execute the preparedstatement
	    	      preparedStmt.execute();
	    	      
	   
	    	 
	    	//   System.out.println(" SUCCESS!\n");
	    	   
	    	   // Statement stmt = con.createStatement();		
	 
	    	   
	    	      String query2 =   " SELECT TestCaseID FROM testcase WHERE TestCaseID = (SELECT MAX(TestCaseID) FROM testcase)";
	    	      
	    	      
	    	      
	    	      
	    	      
	    	 	   Statement stmt = con.createStatement();					
	    		   
	 
	 	    	   
	 	   			// Execute the SQL Query. Store results in ResultSet		
	 	     		ResultSet rs= stmt.executeQuery(query2);							
	 	     
	 	     		// While Loop to iterate through all data and print results		
	 				while (rs.next()){
	 					
	 					/*
	 			        		String TestCaseID = rs.getString(1);								        
	 	                        String TestCaseDesc = rs.getString(2);	
	 	                       
	 	                        System. out.println("Test Case Description of Test Case ID are :");
	 	                        System. out.println(TestCaseID+" : "+TestCaseDesc);	*/
	 	                        
	 	                     // closing DB Connection		
	 	              			//con.close();
	 	                	   System.out.println(" SUCCESS! TESTCASE DESC "+TempData1+"  and Test Case ID " +rs.getString(1)+" inserted successfully \n");
	 	                        
	 	                        
	 				}

	    	   
	
	    	  

				 con.close();
					return true;
		}
		
		
		
		catch (SQLException | ClassNotFoundException e)
		{
			//keyerrormsg=e.getMessage().split("\n")[0].split("<")[0];
			e.printStackTrace();
			return false;
	    
		}// end finally try
	
		

	    }

	   
	 
				}



