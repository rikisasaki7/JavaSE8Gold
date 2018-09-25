package chapter09;

import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * NIO2
 * Pathsクラス経由で情報を取得
 */
public class Sample09_03 {

	public static void main(String[]args){

		// Windowsの場合 - ファイルセパレータは「\\」
		Path path = Paths.get("D:\\development\\JavaSE8Gold\\files\\09_01.txt");

		// Linuxの場合 - ファイルセパレータは「/」
//		Path path = Paths.get("/development/JavaSE8Gold/files/09_01.txt");

		System.out.format("toString: %s%n", path.toString()); // パスの文字列表現を返す
		System.out.format("getFileName: %s%n", path.getFileName()); // パスの最後のシーケンスを返す。
		System.out.format("getName(0): %s%n", path.getName(0)); // ルートを除き、引数に指定したシーケンスを返す。
		System.out.format("getName(1): %s%n", path.getName(1)); // ルートを除き、引数に指定したシーケンスを返す。
		System.out.format("getName(2): %s%n", path.getName(2)); // ルートを除き、引数に指定したシーケンスを返す。
		System.out.format("getName(3): %s%n", path.getName(3)); // ルートを除き、引数に指定したシーケンスを返す。
//		System.out.format("getName(4): %s%n", path.getName(4)); // 存在しない場合は<code>IllegalArgumentException</code>
		System.out.format("getNameCount: %d%n", path.getNameCount()); // パス内の要素数を返す - ルートは除く
		System.out.format("getRoot: %s%n", path.getRoot()); // ルートを返す
		while((path = path.getParent()) != null){ // １個上の親階層までを含んだPathオブジェクトを返す
			System.out.format("getParent: %s%n", path);
		}

		Path p = Paths.get("files\\09_01.txt");
		System.out.format("getRoot: %s%n", p.getRoot()); // 相対パスでgetRootしたときはNullが返される
	}
}
