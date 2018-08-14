/**
 * 
 */
package chapter12;

import java.time.LocalDate;
import java.time.Month;

/**
 * @author Riki
 * フォーマット
 * DateFormat
 * JavaSE7まで：
 * 　java.util.Date、java.util.Calendarを扱った上で、java.text.DateFormatやjava.text.SimpleDateFormatクラスを使用していた。
 * JavaSE8から：
 * 　日付/時刻APIの導入により、java.timeパッケージのクラスを使用可能となった。
 * 
 */
public class Sample12_11_DateFormat {
	public static void main(String[]args){
		LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 1);
		System.out.println(String.format("getYear:[%d]", date.getYear()));
		System.out.println(String.format("getMonth:[%s]", date.getMonth())); //return:<code>java.time.Month</code>enum列挙型
		System.out.println(String.format("getMonthValue:[%d]", date.getMonthValue()));
		System.out.println(String.format("getDayOfMonth:[%d]", date.getDayOfMonth()));
		System.out.println(String.format("getDayOfYear:[%d]", date.getDayOfYear())); // うるう年の場合は1-366を返す
		System.out.println(String.format("getDayOfWeek:[%s]", date.getDayOfWeek())); //return:<code>java.time.DayOfWeek</code>enum列挙型
	}

}
