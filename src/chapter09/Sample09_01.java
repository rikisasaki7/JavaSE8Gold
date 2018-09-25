package chapter09;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * NIO2
 * Pathsクラス
 */
public class Sample09_01 {

	public static void main(String[]args){
		// Pathオブジェクトを取得するだけなので、ファイルがあろうがなかろうが関係ない。
		Path path1 = Paths.get("files/09_01.txt"); // 相対パスを引数に指定可能
		Path path2 = Paths.get("D:\\development\\JavaSE8Gold\\files\\09_01.txt"); // 絶対パスも引数に指定可能。
		Path path3 = Paths.get("D:", "development", "JavaSE8Gold", "files", "09_01.txt"); // ディレクトリ構造を分割して指定可能。
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path3);
	}

}
