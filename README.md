# 課題 5-3: 値渡しと参照渡し

### 課題の説明
次のメソッドを定義し、実行例にあるように mainメソッドから呼び出しを行うプログラムを作成しなさい。
ただし、配列の大きさは実行時引数で与えること。

| メソッド名         | 戻り値の型    | 引数リスト              | 処理内容                      |
|---------------|----------|--------------------|---------------------------|
| makeZeroArray | int[]    | int n      | 要素数 n, 各要素の値はすべて 0 の配列を返す | 
| addOne        | なし       | int[] array | 引数で受け取った配列の各要素に1を加算する     | 

### プログラムの雛形
```java
public class Prog53 {

	public static void main(String[] args) {
		int n = Integer.parseInt(args[0]);
		
	}
}
```

### 実行例（配列の大きさが10のとき）
```
要素が全て0の配列を作成します
0 0 0 0 0 0 0 0 0 0 
配列の各要素に1を加えます
1 1 1 1 1 1 1 1 1 1 
```