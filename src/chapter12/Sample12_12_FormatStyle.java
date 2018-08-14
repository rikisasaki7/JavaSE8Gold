/**
 * 
 */
package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * @author Riki
 * フォーマット
 * FormatStyleの使用
 */
public class Sample12_12_FormatStyle {
	public static void main(String[]args){
		LocalDate date = LocalDate.of(2016, Month.FEBRUARY, 20);
//		LocalDate outDate = LocalDate.of(2016, Month.FEBRUARY, 33); // 存在しない日数などを指定すると<code>java.time.DateTimeException</code>が発生
		LocalTime time = LocalTime.of(10, 30, 45);
//		LocalTime outTime = LocalTime.of(10, 30, 66); // 存在しない秒数などを指定すると<code>java.time.DateTimeException</code>が発生
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		System.out.println(String.format("date:[%s]", date));
		System.out.println(String.format("time:[%s]", time));
		System.out.println(String.format("dateTime:[%s]", dateTime));
		
		DateTimeFormatter fmt1 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM); //フォーマッタの取得
		System.out.println(String.format("MEDIUM_date:[%s]", fmt1.format(date)));
		// MEDIUMではtimeをサポートしていないので、<code>java.time.temporal.UnsupportedTemporalTypeException</code>が発生
//		System.out.println(String.format("MEDIUM_time:[%s]", fmt1.format(time))); 
		System.out.println(String.format("MEDIUM_dateTime:[%s]", fmt1.format(dateTime)));
		
		System.out.println("=====================様々なofLocalized=====================");
		
		/** ofLocalizedDate - MEDIUM */
		DateTimeFormatter fmt2 = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
		System.out.println(String.format("ofLocalizedDate - MEDIUM, date:[%s]", fmt2.format(date)));
//		System.out.println(String.format("ofLocalizedDate - MEDIUM, time:[%s]", fmt2.format(time))); // 例外発生。
		System.out.println(String.format("ofLocalizedDate - MEDIUM, dateTime:[%s]", fmt2.format(dateTime)));

		/** ofLocalizedDate - SHORT */
		DateTimeFormatter fmt3 = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT);
		System.out.println(String.format("ofLocalizedDate - SHORT, date:[%s]", fmt3.format(date)));
//		System.out.println(String.format("ofLocalizedDate - SHORT, time:[%s]", fmt3.format(time))); // 例外発生。
		System.out.println(String.format("ofLocalizedDate - SHORT, dateTime:[%s]", fmt3.format(dateTime)));

		/** ofLocalizedTime - MEDIUM */
		DateTimeFormatter fmt4 = DateTimeFormatter.ofLocalizedTime(FormatStyle.MEDIUM);
//		System.out.println(String.format("ofLocalizedTime - MEDIUM, date:[%s]", fmt4.format(date))); // 例外発生
		System.out.println(String.format("ofLocalizedTime - MEDIUM, time:[%s]", fmt4.format(time)));
		System.out.println(String.format("ofLocalizedTime - MEDIUM, dateTime:[%s]", fmt4.format(dateTime)));

		/** ofLocalizedTime - SHORT */
		DateTimeFormatter fmt5 = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT);
//		System.out.println(String.format("ofLocalizedTime - SHORT, date:[%s]", fmt5.format(date))); // 例外発生
		System.out.println(String.format("ofLocalizedTime - SHORT, time:[%s]", fmt5.format(time)));
		System.out.println(String.format("ofLocalizedTime - SHORT, dateTime:[%s]", fmt5.format(dateTime)));

		/** ofLocalizedDateTime - MEDIUM */
		DateTimeFormatter fmt6 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.MEDIUM);
//		System.out.println(String.format("ofLocalizedDateTime - MEDIUM, date:[%s]", fmt6.format(date))); // 例外発生
//		System.out.println(String.format("ofLocalizedDateTime - MEDIUM, time:[%s]", fmt6.format(time))); // 例外発生
		System.out.println(String.format("ofLocalizedDateTime - MEDIUM, dateTime:[%s]", fmt6.format(dateTime)));

		/** ofLocalizedTime - SHORT */
		DateTimeFormatter fmt7 = DateTimeFormatter.ofLocalizedDateTime(FormatStyle.SHORT);
//		System.out.println(String.format("ofLocalizedDateTime - SHORT, date:[%s]", fmt7.format(date))); // 例外発生
//		System.out.println(String.format("ofLocalizedDateTime - SHORT, time:[%s]", fmt7.format(time))); // 例外発生
		System.out.println(String.format("ofLocalizedDateTime - SHORT, dateTime:[%s]", fmt7.format(dateTime)));		
	}

}
