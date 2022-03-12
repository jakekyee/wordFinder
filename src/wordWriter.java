//Based off of
//https://www3.ntu.edu.sg/home/ehchua/programming/java/JDBC_Basic.html


package wordfinder;


import java.sql.*;  // Using 'Connection', 'Statement' and 'ResultSet' classes in java.sql package
import java.util.*;
 
public class wordWriter {  
   public static void main(String[] args) {
      try (         
//         Connection conn = DriverManager.getConnection(
//               "jdbc:mysql://99.000webhost.io:3306/id15647212_dictionarystudytool?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC",
//               "id15647212_admin", "C0rrectH0rseBatteryStaple!");   
              
              Connection conn = DriverManager.getConnection(
               "jdbc:mysql://localhost:3306/id15647212_dictionarystudytool?allowPublicKeyRetrieval=true&useSSL=false&serverTimezone=UTC", "id15647212_admin", "X3(ZEhv@-Zlzhn9]");   // For MySQL only
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "
               // The format is: "jdbc:mysql://hostname:port/databaseName", "username", "password"

         Statement stmt = conn.createStatement();
//         Statement stmt2 = conn.createStatement();
      ) {
         // Step 3: Execute a SQL SELECT query. The query result is returned in a 'ResultSet' object.
         int rowCount = 0;
         String strUpdate ="";
         String pegWord = "";
         String pegWordFixed ="";
         int tableSize = 176023;
         for (int i = 1; i < tableSize; i++) {
             //has to be equals
         String strSelect = "SELECT word FROM entries WHERE pk_column = '" + i + "';";
//         System.out.println("The SQL statement is: " + strSelect + "\n"); // Echo For debugging
          ResultSet rset = stmt.executeQuery(strSelect);
//         System.out.println("The records selected are:");
         rowCount++;
         int rupdate = 0;
          
         while(rset.next()) {   // Return results of query one by one
           String word = rset.getString("word");
           System.out.println(word);
           pegWord = Soundex.getGode(word);
           pegWordFixed = pegWord.substring(0, pegWord.length()-1);
//           System.out.println("Length" + pegWord.length());    
//           System.out.println("Pegword" + pegWord);
//           System.out.println("Fixed" + pegWordFixed);
           
       
        }
         if (pegWord.length() > 1) {
//            strUpdate = "UPDATE entries SET peg=" + pegWord + " WHERE pk_column=" + i + ";";

           strUpdate = "UPDATE entries SET peg = '" +   pegWordFixed +"' WHERE pk_column = " + i + ";"; //Write to table
//           System.out.println("The SQL update is: " + strUpdate + "\n");
           stmt.executeUpdate(strUpdate);
//           System.out.println("The SQL update is: " + strUpdate + "\n"); // Echo For debugging
           
           }
          else {
              strUpdate = "UPDATE entries SET peg = null WHERE pk_column=" + i + ";";//Write to table
//              System.out.println("The SQL update is: " + strUpdate + "\n"); // Echo For debugging
              stmt.executeUpdate(strUpdate);
//              System.out.println("The SQL update is: " + strUpdate + "\n"); // Echo For debugging
          }
         System.out.println(rowCount);
         }
      } catch(SQLException ex) {
         ex.printStackTrace();
      }  
   }
}
 
