package chapter09;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/*
 * nio2
 * pathインタフェース
 * パスの操作
 */
public class Sample09_05 {
	public static void main(String[]args){
		Path path1 = Paths.get("./ren/hou/..");
		System.out.format("normalize(): %s%n", path1.normalize()); // 冗長な名前要素を削除 - 「normalize(): ren」と出力される。
		System.out.format("toUri(): %s%n", path1.toUri()); // Uri形式になる。 -「toUri(): file:///D:/development/JavaSE8Gold/./ren/hou/..」と出力される。
		System.out.format("isAbsolute: %s%n", path1.isAbsolute()); // 絶対パスの場合true、相対パスの場合false
		System.out.format("toAbsolutePath: %s%n", path1.toAbsolutePath()); // 絶対パスに変換する - 「toAbsolutePath: D:\development\JavaSE8Gold\.\ren\hou\..」

		Path path2 = null;
		try{
			// Pathオブジェクトを基に実際のファイルパスを絶対パスで返す。
			// ファイルが存在していないとIOException
			path2 = FileSystems.getDefault().getPath("files/09_01.txt").toRealPath(); // - 「toRealPath(): D:\development\JavaSE8Gold\files\09_01.txt」と出力
			System.out.format("toRealPath(): %s%n", path2);
		}catch(IOException e){e.printStackTrace();}
	}

}
