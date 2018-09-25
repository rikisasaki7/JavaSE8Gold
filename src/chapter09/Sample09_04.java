package chapter09;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * Nio2
 * Pathオブジェクト subpath
 */
public class Sample09_04 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Path path = Paths.get("D:\\development\\JavaSE8Gold\\files\\09_01.txt");
		System.out.format("1-4 : %s%n", path.subpath(1, 4)); // とるルールはsubstringと一緒。start含んでend含まない
		System.out.format("0-2 : %s%n", path.subpath(0, 2));
//		System.out.format("0-5 : %s%n", path.subpath(0, 5)); // 実行エラー
//		System.out.format("2-2 : %s%n", path.subpath(2, 2)); // 実行エラー

	}

}
