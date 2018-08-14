/**
 * 
 */
package chapter12;

import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;

/**
 * @author Riki
 * chapter12-6
 * サンプルコード
 * プロパティを使用したリソースバンドル
 */
public class Sample12_06 {

	public static void main(String[]args) {
        Locale us = new Locale("en", "US");
        // keysetの取得
        ResourceBundle bundle = ResourceBundle.getBundle(
    			Sample12_MyProperties_Resources.SOURCE, 
    			us, 
    			Sample12_MyProperties_Resources.getPropertiesClassLoader());
        // 以前から提供されているjava.util.Propertiesクラスを使用した例
        Properties props = new Properties();
        bundle.keySet().stream().forEach(k -> props.put(k, bundle.getString(k)));
        method(props);
	}
	
	static void method(Properties props){
		System.out.println(String.format("props.get(send):%s", props.get("send"))); // Hashtableクラスのgetを使用している
		System.out.println(String.format("props.getProperty(send):%s", props.getProperty("send"))); // PropertyクラスのgetProperyを使用している
		System.out.println(String.format("props.get(xxx):%s", props.get("xxx")));
		System.out.println(String.format("props.getProperty(xxx):%s", props.getProperty("xxx")));
		System.out.println(String.format("props.getProperty(xxx) default:%s", props.getProperty("xxx", "default"))); // こっちはdefaultを使用可能
	}
}
