/**
 * 
 */
package chapter12;

import java.text.DecimalFormat;

/**
 * @author Riki
 * フォーマット
 * DecimalFormatメソッド
 * いろいろな書式
 * 
 * NumberFormat：
 * 　１.抽象クラス、newできない
 * 　２.Localeを与える事が可能。通貨に対するフォーマッターを提供している
 * DecimalFormat：
 * 　１.普通のクラス。newする
 * 　２.形式を指定可能。通貨記号を現すことも可能。しかし、内部的にLogele.getDefaultを使用しているため、デフォルトロケールのみとなる。
 */
public class Sample12_10 {
	public static void main(String[]args){
		customFormat("###,###.###", 123456.789);
		customFormat("###.##", 123456.789); // 足りないところは丸められる
		customFormat("000000.000", 123.78);
		customFormat("$###,###.###", 12345.67);
		customFormat("\u00A5###,###.###", 12345.67); // バックスラッシュじゃないとダメ
		customFormat("\u00A5###,###.###", 12345.67); // バックスラッシュじゃないとダメ
		customFormat("###.00%", 0.890);
	}
	static public void customFormat(String pattern, double value){
		DecimalFormat myFormatter = new DecimalFormat(pattern);
		String fData = myFormatter.format(value);
		System.out.println(String.format("pattern:[%s], value:[%e], formated:[%s]", pattern, value, fData));
	}
}
