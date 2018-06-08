package kata; /**
 * Created by wutaotao
 * 2018/1/26 22:00
 */
import org.junit.Test;
import static org.junit.Assert.assertEquals;


public class SongTests {
    @Test
    public void Test1() {
        assertEquals("ABC", new Dubstep().SongDecoder("WUBWUBABCWUB"));
    }
    @Test
    public void Test2()
    {
        assertEquals("R L", new Dubstep().SongDecoder("RWUBWUBWUBLWUB"));
    }
}
 class Dubstep {
    public static String SongDecoder (String song)
    {
        // Your code is here...
//        return song.replace("WUB", " ").trim().replaceAll("\\s+", " ");
        return song.replaceAll("(WUB)+", " ").trim();
    }
}
