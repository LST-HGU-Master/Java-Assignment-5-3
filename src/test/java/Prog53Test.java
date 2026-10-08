import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import java.io.*;
/**
 * @version (20220501)
 * @version (20230417) suporting both println and print("\n") on Windows
 * @version (20261008) revised
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
    public void testMakeZeroArray() {
        int[] array = Prog53.makeZeroArray(4);

        assertNotNull(array, "makeZeroArray(4) の戻り値が null です。");
        assertArrayEquals(new int[]{0, 0, 0, 0}, array, 
            "makeZeroArray() で作成された配列の要素数または各要素の値（0）が正しくありません!"
        );
    }

    @Test
    public void testAddOne() {
        int[] array = {0, 4, 5};
        Prog53.addOne(array);

        assertArrayEquals(new int[]{1, 5, 6}, array, 
            "addOne() において、配列の各要素に +1 された結果が期待値と一致しません!"
        );
    }

    @Test
    public void testMain() {
        Prog53.main(new String[]{"18"});

        String[] prints = bos.toString().replace("\r\n", "\n").split("\n");

        assertTrue(prints.length >= 4, "実行結果が4行分ありません! プロンプト表示や配列要素の出力・改行漏れがないか確認してください。");
        assertTrue(prints[1].contains("0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0 0"),
            "mainメソッド内において、makeZeroArray() が返した配列要素の出力結果が期待したものと一致しません!"
        );
        assertTrue(prints[3].contains("1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1 1"),
            "mainメソッド内において、addOne() で処理された配列要素の出力結果が期待したものと一致しません!"
        );
    }
}
