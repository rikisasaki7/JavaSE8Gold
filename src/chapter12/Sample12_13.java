/**
 * 
 */
package chapter12;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

/**
 * @author Riki
 * フォーマット
 * ofPatternとparseメソッド
 */
public class Sample12_13 {
	public static void main(String[]args){
		LocalDate date = LocalDate.of(2016, 2, 20); // monthには数値を入れても大丈夫
		LocalTime time = LocalTime.of(15, 30, 45);
		LocalDateTime dateTime = LocalDateTime.of(date, time);
		
		/** ofPattern */
		System.out.println("===============ofPattern===============");
		DateTimeFormatter fmt1 = DateTimeFormatter.ofPattern("hh:mm");
//		System.out.println(fmt1.format(date)); // 例外発生 パターンが時刻だから
		System.out.println(fmt1.format(time));
		System.out.println(fmt1.format(dateTime)); // こいつは一応時刻情報を持っているから例外にはならない

		/** ofPatternとparseの組み合わせ */
		System.out.println("===============ofPatternとparseの組み合わせ===============");
		LocalTime time2 = LocalTime.parse("06:15"); // 6:15はNG<code>DateTimeParseException</code>が発生
		System.out.println(time2);
		
		DateTimeFormatter fmt2 = DateTimeFormatter.ofPattern("yyyy MM dd"); // opPatternを使えば独自のフォーマットが可能
		String target = "2016 03 31";
		LocalDate date2 = LocalDate.parse(target, fmt2);
		System.out.println(date2);

		/** いろいろなパターン文字 */
		System.out.println("===============いろいろなパターン文字===============");
//		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("G yyyyMMdd EEE HHmmssSS z hhmmssSS", Locale.US);
//		String target2 = "AD 20180814 Tue 17142299 PST 05142299";
		// z（タイムゾーン）はたぶんLocalDatetimeを使っているからかできなかったよ。
		DateTimeFormatter fmt3 = DateTimeFormatter.ofPattern("G yyyyMMdd EEE HHmmssSS - hhmmssSS");
		String target2 = "AD 20180814 Tue 17142299 - 05142299";
		LocalDateTime dateTime2 = LocalDateTime.parse(target2, fmt3);
		System.out.println(String.format("全部：[%s]", fmt3.format(dateTime2)));
	}
}
