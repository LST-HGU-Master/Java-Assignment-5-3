import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.*;
/**
 * @version (20220501)
 * @version (20230609)  supporting both println and print("\n") on Windows
 * 
 * (注意) Prog53クラス内に makeZeroArray()とaddOne()の２つのメソッド が適切に宣言されるまで、
 * 　　　　このテストクラスは「シンボルを見つけられません」というエラーが表示される
 **/

public class Prog53Test {
    InputStream originalIn;
    PrintStream originalOut;
    ByteArrayOutputStream bos;
    StandardInputStream in;
    
    @BeforeEach
    void before() {
        //back up binding
        originalIn  = System.in;
        originalOut = System.out;
       //modify binding
        bos = new ByteArrayOutputStream();
        System.setOut(new PrintStream(bos));
        
       in = new StandardInputStream();
       System.setIn(in);
    }
    
    @AfterEach
    void after() {
       System.setOut(originalOut);
       System.setIn(originalIn);
    }


    @Test
    public void testMakeZeroArray()
    {

        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        int[] array = Prog53.makeZeroArray(4);

        // assertion
        String msg = "makeZeroArray()において、作られた配列の";
        try {
            assertEquals(4, array.length, msg + "要素数が実行時引数で指定した値と一致しません!");
            assertEquals(0, array[0], msg + "要素番号0の中身が 0 でありません!");
            assertEquals(0, array[1], msg + "要素番号1の中身が 0 でありません!");
            assertEquals(0, array[2], msg + "要素番号2の中身が 0 でありません!");
            assertEquals(0, array[3], msg + "要素番号3の中身が 0 でありません!");
        } catch (AssertionError err) {
            after();
            throw err;     
        }
    }

    @Test
    public void testAddOne()
    {
        // action
        // in.inputln("2"); // 標準入力をテストする場合
        // Hello.main(new String[]{"1", "2", "3"}); // 実行時引数をテストする場合
        int[] array = {0,4,5};
        Prog53.addOne(array);

        // assertion
        String msg = "addOne()において、引数で与えられた配列の";
        try {
            assertEquals(3, array.length, msg + "サイズ（要素数）が変更されてしまいました!");
            assertEquals(1, array[0], msg + "要素番号0の中身が 元の値+1 になっていません!");
            assertEquals(5, array[1], msg + "要素番号1の中身が 元の値+1 になっていません!");
            assertEquals(6, array[2], msg + "要素番号2の中身が 元の値+1 になっていません!");
        } catch (AssertionError err) {
            after();
            throw err;     
        }
    }

    @Test
    public void testMain()
    {
        // action
        Prog53.main(new String[]{"18"});

        // assertion
        String[] prints = bos.toString().split("\r\n|\n");
        try {
            assertTrue(prints[1].contains("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
                       "mainメソッド内において、makeZeroArray()が返した配列要素のprint結果が期待したものと一致しません!"
            );
            assertTrue(prints[3].contains("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"),
                       "mainメソッド内において、addOne()で処理された配列要素のprint結果が期待したものと一致しません!"
            );
        } catch (AssertionError err) {
            after();
            throw err;     
        }


    }
}
