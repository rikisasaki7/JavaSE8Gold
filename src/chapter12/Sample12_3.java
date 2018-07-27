package chapter12;

import java.util.ResourceBundle;

/*
 * chapter12-2
 * サンプルコード
 * リソースバンドル
 */
public class Sample12_3 {

	public static void main(String[] args){

		ResourceBundle obj = ResourceBundle.getBundle("chapter12.MyResources2");
		// 異なる型を取得する際にはgetObjecyを使用
		// 更にgetObjectを使用した際には、適した型にキャストが必要
		Long data1 = (Long)obj.getObject("data1");
		Integer data2 = (Integer)obj.getObject("data2");
		int[] data3 = (int[])obj.getObject("data3");

		System.out.println(String.format("data1 : %d", data1));
		System.out.println(String.format("data2 : %d", data2));
		System.out.print("data3 : ");
		for(int i : data3){
			System.out.print(String.format("%d ", i));
		}
	}

}
