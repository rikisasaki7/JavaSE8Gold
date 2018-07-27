package chapter12;

import java.util.ListResourceBundle;

/*
 * ListResourceBundleを使用するサンプルコード
 * 米国用のリストリソースバンドクラス
 */
public class MyResources_en_US extends ListResourceBundle {

	@Override
	protected Object[][] getContents(){
		Object[][] contents = {{"send", "sendd"}, {"cancel", "cancell"}, {"test", "testt"}};
		return contents;
	}

}
