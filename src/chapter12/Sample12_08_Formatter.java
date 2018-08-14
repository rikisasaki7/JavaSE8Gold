/**
 * 
 */
package chapter12;

import java.text.NumberFormat;
import java.util.Locale;

/**
 * @author Riki
 * フォーマット
 */
public class Sample12_08_Formatter {
	public static void main(String[]args){
		// 日本のフォーマット
		NumberFormat jpNum = NumberFormat.getInstance();
		NumberFormat jpCur = NumberFormat.getCurrencyInstance();
		System.out.println(String.format("日本の数値：%s", jpNum.format(50000)));
		System.out.println(String.format("日本の通貨：%s", jpCur.format(50000)));
		
		// 米国のフォーマット
		NumberFormat usNum = NumberFormat.getInstance(Locale.US);
		NumberFormat usCur = NumberFormat.getCurrencyInstance(Locale.US);
		System.out.println(String.format("米国の数値：%s", usNum.format(50000)));
		System.out.println(String.format("米国の通貨：%s", usCur.format(50000)));
	}

}
