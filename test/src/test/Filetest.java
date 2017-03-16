package test;


import java.io.File;
import java.io.FileWriter;
import java.io.BufferedWriter;
import java.io.IOException;

public class Filetest 
{
    public static void main( String[] args )
    { 
     try{
      String data = " This content will append to the end of the file";

      File file =new File("C:\\Users\\Administrator\\workspace\\test");

      //if file doesnt exists, then create it
      if(!file.exists()){
       file.createNewFile();
      }

      //true = append file
      FileWriter fileWritter = new FileWriter(file.getName(),true);
             BufferedWriter bufferWritter = new BufferedWriter(fileWritter);
             bufferWritter.write(data);
             bufferWritter.close();

         System.out.println("Done");
         System.out.println(file.getAbsolutePath());

     }catch(IOException e){
      e.printStackTrace();
     }
    }
}
