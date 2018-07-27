package chapter12;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/*
 * chapter12-1
 * サンプルコード
 */
public class Sample12_1 {

	public static void main(String args[]){

		/*
		 * Localeクラス
		 * 国や言語などでわけた「地域」を表すクラス
		 * プログラムを実行する地域によって表示を変えたい場合に使用する
		 */

		/* コンストラクタ */
		Locale l1 = new Locale("en"); // 言語コードからLocaleを作成
		Locale l2 = new Locale("en", "US"); // 言語コード、国コードからLocaleを作成

		/* staticメソッド */
		Locale l3 = Locale.getDefault(); // 実行中のJava実行環境デフォルトロケールを返す
		Locale.setDefault(l1); // 引数で指定したロケールをデフォルトロケールとして設定する
		Locale.setDefault(new Locale("ja", "JP"));

		/* メンバメソッド */
		String c2 = l3.getDisplayCountry(l1); // 引数で指定したロケールの表示名で国名を返す
		System.out.println(String.format("国名：%s", c2));

		String cc = Locale.getDefault().getCountry(); // ロケールオブジェクトが持つ国コードを返す
		System.out.println(String.format("国コード：%s", cc));

		String lan2 = l1.getDisplayLanguage(l3); // 引数で指定したロケールの表示で言語名を返す
		System.out.println(String.format("言語名：%s", lan2));

		String lan3 = l2.getLanguage(); // ロケールオブジェクトが持つ言語コードを返す
		System.out.println(String.format("言語コード：%s", lan3));

		/* メンバメソッド（final） */
		String c1 = l2.getDisplayCountry(); // ロケールオブジェクトが持つ国名を返す
		System.out.println(String.format("国名：%s", c1));

		String lan = l1.getDisplayLanguage(); // ロケールオブジェクトが持つ言語名を返す
		System.out.println(String.format("言語名：%s", lan));

		List<Locale> list = new ArrayList<Locale>();
		list.add(l1);
		list.add(l2);
		list.add(l3);

		/* 定数 */
		for(Locale l : list){
			if(Locale.US.equals(l)){
				System.out.println("US!");
			} else if(Locale.JAPAN.equals(l)){
				System.out.println("JAPAN");
			} else if(Locale.FRANCE.equals(l)){
				System.out.println("FRANCE");
			} else {
				System.out.println("OTHER");
			}
			System.out.println(l);
		}

		/* Builderを使用したコンストラクタ */
		Locale locale = new Locale.Builder()
				.setLanguage("ja") // 言語コード
				.setScript("Jpan") // ISO15924で定義されている４文字の文字体系
				.setRegion("JP") // 地域
				.build();
		System.out.println(locale.getLanguage() + locale.getScript() + locale.getCountry());

		/* サンプル */
		System.out.println("=====================参考書サンプル=====================");
		Locale japan = Locale.getDefault();
		System.out.println(japan.getDisplayCountry() + " : " + japan.getDisplayLanguage());

//		Locale us = Locale.US;
		Locale us = new Locale("en", "US");
		System.out.println(us.getDisplayCountry() + " : " + us.getDisplayLanguage());
		System.out.println(us.getDisplayCountry(us) + " : " + us.getDisplayLanguage(us));
		System.out.println(us.getCountry() + " : " + us.getLanguage());

		Locale lb = new Locale.Builder()
				.setLanguage("jp")
				.setScript("Jpan")
				.setRegion("JP")
				.build();
		System.out.println(lb.getCountry() + " : " + lb.getLanguage());


	}
}
