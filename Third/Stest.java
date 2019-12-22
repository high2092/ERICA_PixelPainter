import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
 
 
public class Stest {
     
     
    public static void main(String[] args) {
         
        String txt = "test" ;
         
        String fileName = "result" ;
        System.out.println(txt);
         
        try{
             
            File file = new File(fileName) ;
             
            FileWriter fw = new FileWriter(file, true) ;
             
            fw.write(txt);
            fw.flush();
 
            fw.close();
             
             
        }catch(Exception e){
            e.printStackTrace();
        }
         
 
    }
}