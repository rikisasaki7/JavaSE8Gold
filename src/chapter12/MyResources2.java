package chapter12;

import java.util.ListResourceBundle;

/*
 * ListResourceBundleを使用するサンプルコード
 */
public class MyResources2 extends ListResourceBundle {

	@Override
	protected Object[][] getContents(){
		Long data1 = 1000L;
		Integer data2 = 500;
		int[] data3 = {10, 20, 30};
		Object[][] contents = {{"data1", data1}, {"data2", data2}, {"data3", data3}};
		return contents;
	}
}
