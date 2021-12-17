import by.gsu.epamlab.ResultHandler;
import by.gsu.epamlab.Student;

import java.util.List;

import static by.gsu.epamlab.Constants.*;


public class Runner {
    public static void main(String[] args) {
        try{
            ResultHandler parser = new ResultHandler(PATH + FILE_NAME + EXT_XSM);
            List<Student> students = parser.read();
            for(Student student : students){
                System.out.println(student);
            }
        }catch (IllegalStateException e){
            System.err.println(e.getMessage());
        }
    }
}
