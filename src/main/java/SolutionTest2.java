/**
 * Created by wutaotao
 * 2018/1/24 22:49
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import org.junit.runners.JUnit4;


public class SolutionTest2 {
    @Test
    public void testBasic() {
        assertEquals("'add' should return the two numbers added together!", 3, ArithmeticFunction.arithmetic(1, 2, "add"));
        assertEquals("'subtract' should return a mimus b!", 6, ArithmeticFunction.arithmetic(8, 2, "subtract"));
        assertEquals("'multiply' should return a multiplied by b!", 10, ArithmeticFunction.arithmetic(5, 2, "multiply"));
        assertEquals("'divide' should return a divided by b!", 4, ArithmeticFunction.arithmetic(8, 2, "divide"));
    }
}
class ArithmeticFunction {
    public static int arithmetic(int a, int b, String operator) {
        // your code here
        switch (operator){
            case "add": return a + b;
            case "subtract": return a - b;
            case "multiply": return a * b;
            case "divide": return a / b;
        }
        return 0;
    }
}
