package chapter09;

import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Iterator;

/*
 * nio2
 * resolveメソッド - パスの結合
 */
public class Sample09_06 {
	public static void main(String[]args){
		Path path1 = Paths.get("ren/../0909");
		Path path2 = FileSystems.getDefault().getPath("X");
		System.out.format("resolve: %s%n", path1.resolve(path2)); // - 「resolve: ren\..\0909\X」と出力。

		Path path3 = Paths.get("D:\\development\\JavaSE8Gold\\files\\09_01.txt");
		System.out.format("resolve-2: %s%n", path1.resolve(path3));
			// - 絶対パスのPathオブジェクトを引数に指定したので
			// - 「resolve-2: D:\development\JavaSE8Gold\files\09_01.txt」とそのままを出力

		// iteratorを使用してルート以下にある各要素を取得することも可能。
		Iterator<Path> iter = path3.iterator();
		while(iter.hasNext()){
			System.out.print(iter.next() + " "); // - 「development JavaSE8Gold files 09_01.txt 」と出力
		}
	}
}
