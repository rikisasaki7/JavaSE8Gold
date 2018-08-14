/**
 * 
 */
package chapter12;

import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Set;

/**
 * @author Riki
 * chapter12-5
 * サンプルコード
 * プロパティを使用したリソースバンドル
 */
public class Sample12_05 {

	public static void main(String[]args) {
        Locale us = new Locale("en", "US");
        // keysetの取得
        ResourceBundle bundle = ResourceBundle.getBundle(
    			Sample12_MyProperties_Resources.SOURCE, 
    			us, 
    			Sample12_MyProperties_Resources.getPropertiesClassLoader());
        Set<String> keys = bundle.keySet();
        keys.stream().map(k -> bundle.getString(k)).forEach(System.out::println);
	}
}
