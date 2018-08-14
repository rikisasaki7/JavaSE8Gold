/**
 * 
 */
package chapter12;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.Locale;

/**
 * @author Riki
 * フォーマット
 * parseメソッド
 */
public class Sample12_09 {
	public static void main(String[]args){
		try{
			NumberFormat usNum = NumberFormat.getInstance(Locale.US);
			Number value1 = usNum.parse("500.12");
			System.out.println(String.format("value1: %e", value1));
			
			NumberFormat usCur = NumberFormat.getCurrencyInstance(Locale.US);
			double value2 = (double)usCur.parse("$20,456.99"); // 異なるロケールを指定すると<code>ParseException</code>が発生
			System.out.println(String.format("value2: %e", value2));
		} catch(ParseException e){
			e.printStackTrace();
		}
	}
}
