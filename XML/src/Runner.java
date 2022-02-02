import by.gsu.epamlab.Result;
import by.gsu.epamlab.ResultHandler;

import java.util.List;

import static by.gsu.epamlab.Constants.*;


public class Runner {
    public static void main(String[] args) {
        try {
            ResultHandler parser = new ResultHandler();
            List<Result> results = parser.load(PATH + FILE_NAME + EXT_XSM);
            for (Result result : results) {
                System.out.println(result);
            }
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}
