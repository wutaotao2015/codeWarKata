import org.junit.Assert;
import org.junit.Test;

public class IntegerDepth {

    @Test
    public void sampleTest1() {
        Assert.assertEquals(10, new MySolution().computeDepth(1));
    }

    @Test
    public void sampleTest2() {
        Assert.assertEquals(9, new MySolution().computeDepth(42));
    }

}
class MySolution {

    public int computeDepth(int n) {
        // TODO implementation
        String digits = "0123456789";
        int count = 1;
        while (digits.length() > 0){
            int result = n * count;
            for (char c : String.valueOf(result).toCharArray()) {
                if (digits.indexOf(c) != -1){
                    digits = digits.replace(c+"", "");
                }
            }
            if (digits.length() == 0) return count;
            count++;
        }
        return count;
    }
}