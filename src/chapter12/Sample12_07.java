/**
 * 
 */
package chapter12;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Riki
 * chapter12-7
 * サンプルコード
 * クラスとプロパティの検索順序の確認
 * めんどくさいから省略するけど以下の順序で取得する
 * １.言語コード、国コードが一致するクラスファイル
 * ２.言語コード、国コードが一致するプロパティファイル
 * ３.言語コードが一致するクラスファイル
 * ４.言語コードが一致するプロパティファイル
 * ５.デフォルトロケール用のクラスファイル
 * ６.デフォルトロケール用のプロパティファイル
 * なお、適切なリソースバンドルを読み込めない場合は<code>MissingResourceException</code>が発生する
 */
public class Sample12_07 {
	public static void main(String[]args){
		String SOURCE = "chapter12.MyResources3";
		ResourceBundle obj = ResourceBundle.getBundle(
				SOURCE
				, new Locale("en", "US"));
//				, Sample12_MyProperties_Resources.getPropertiesClassLoader());
		System.out.println(obj.getString("data"));
	}

}
