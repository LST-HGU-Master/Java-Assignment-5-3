import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import java.io.*;

public class Prog53Test {

    @Test
    public void testMakeZeroArray()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        int[] array = Prog53.makeZeroArray(4);

        // assertion
        assertEquals(4, array.length);
        assertEquals(0, array[0]);
        assertEquals(0, array[1]);
        assertEquals(0, array[2]);
        assertEquals(0, array[3]);

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testAddOne()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        int[] array = {0,4,5};
        Prog53.addOne(array);

        // assertion
        assertEquals(3, array.length);
        assertEquals(1, array[0]);
        assertEquals(5, array[1]);
        assertEquals(6, array[2]);

        // undo the binding in System
        System.setOut(originalOut);
    }

    @Test
    public void testMain()
    {
        PrintStream originalOut = System.out;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));

        StandardInputStream in = new StandardInputStream();
        System.setIn(in);

        // action
        Prog53.main(new String[]{"18"});

        // assertion
        String[] prints = bos.toString().split("\n");
        assertTrue(prints[1].contains("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"));
        assertTrue(prints[3].contains("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"));

        // undo the binding in System
        System.setOut(originalOut);
    }
}
