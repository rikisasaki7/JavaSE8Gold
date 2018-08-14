package chapter12;

import java.util.Locale;
import java.util.ResourceBundle;

/**
 * @author Riki
 * chapter12-4
 * サンプルコード
 * プロパティを使用したリソースバンドル
 * ・プロパティファイル名は、基底名、言語コード、国コードの組み合わせにすること
 * ・拡張子は.propertiesとすること
 * ・リソースであるキーと値のペアはプロパティファイル内にk「キー=値」の形式で列記すること
 */
public class Sample12_04 {

	public static void main(String[]args) {
        // ここから参考書 - urlLoaderは参考書にはない。
        Locale japan = Locale.getDefault();
        Locale us = new Locale("en", "US");
        Locale[] locArray = {japan, us};
        for(Locale locale : locArray){
        	ResourceBundle obj1 = ResourceBundle.getBundle(
        			Sample12_MyProperties_Resources.SOURCE, 
        			locale, 
        			Sample12_MyProperties_Resources.getPropertiesClassLoader());
        	System.out.println(String.format("send: %s", obj1.getString("send")));
        	System.out.println(String.format("cancel: %s", obj1.getString("cancel")));
        }
	}
}
