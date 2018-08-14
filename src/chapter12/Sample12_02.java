package chapter12;

import java.util.Locale;
import java.util.ResourceBundle;

/*
 * chapter12-2
 * サンプルコード
 * リソースバンドル
 */
public class Sample12_02 {

	public static void main(String args[]){

		/*
		 * アプリケーション国際化のための機能
		 * ロケール毎に表示を切り替えたい場合に使用。以下２通りがある
		 * ・javaクラスで定義
		 * ・プロパティで定義
		 * @see <code>chapter12.MyResources</code>基底のリソースバンドルクラス
		 * @see <code>chapter12.MyResources_en_US</code>米国用のリソースバンドルクラス
		 *
		 * 上記で定義したリソースバンドルを読み込む
		 */
		Locale japan = Locale.getDefault(); // デフォルト（日本）
		Locale us = Locale.US; // アメリカ
		Locale[] locArray = {japan, us};

		String baseName = "chapter12.MyResources";
		for(Locale locale : locArray){
			// 引数でロケールを指定した場合、指定されたlocaleに対応するリソースバンドルを取得する
			ResourceBundle obj1 = ResourceBundle.getBundle(baseName, locale);
			System.out.println("send: " + obj1.getString("send"));
			System.out.println("cancel: " + obj1.getString("cancel"));

			// 他にもいろいろやってみる
			/* boolean containsKey(String key)
			 * 引数で指定されたキーが、リソースバンドルに含まれる場合はtrue
			 */
			System.out.println("containsKey() 含まれる場合: "+ obj1.containsKey("send"));
			System.out.println("containsKey() 含まれない場合: "+ obj1.containsKey("aaaaa"));

			/*
			 * final Object getObject(String key)
			 * 引数で指定されたキーに格納されたオブジェクトを返す
			 *
			 * 存在しないキーを指定した場合は例外が発生する（MissingResourceException）
			 * Exception in thread "main" java.util.MissingResourceException: Can't find resource for bundle chapter12.MyResources, key aaaaa
               		at java.util.ResourceBundle.getObject(ResourceBundle.java:450)
					at chapter12.Sample12_2.main(Sample12_2.java:48)

			 */
			System.out.println("getObject() 含まれる場合: "+ obj1.getObject("send"));
//			System.out.println("getObject() 含まれない場合: "+ obj1.getObject("aaaaa")); // 実行時例外が発生するのでコメントアウト


		}

		// localeの指定がない場合、デフォルトのロケールが使用される
		ResourceBundle obj2 = ResourceBundle.getBundle(baseName);
		System.out.println("検証用： " + obj2.getString("send"));

		/*
		 * final String[] getStringArray(String key)
		 * 引数で指定されたキーに格納された文字列の配列を返す
		 * どうやら一つのキーに対して複数の値を登録しなければだめみたいだ。つまりプロパティでしかできない
		 */
//		System.out.print("getStringArray() 含まれる場合: ");
//		for(int i=0; i<sa1.length; i++){
//			System.out.println(String.format("%s ", sa1[i]));
//		}
//		String[] sa2 = obj2.getStringArray("aaaa");
//		System.out.print("getStringArray() 含まれない場合: ");
//		for(int i=0; i<sa2.length; i++){
//			System.out.println(String.format("%s ", sa2[i]));
//		}

		/*
		 * Set<String> keySet()
		 * リソースバンドルに含まれる全てのキーをSetで返却する
		 */
		int i = 0;
		for(String s : obj2.keySet()){
			System.out.println(String.format("keySet %d : %s", ++i, s));
		}
	}
}
