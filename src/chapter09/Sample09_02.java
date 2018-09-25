package chapter09;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

/*
 * NIO2
 * FileSystemsクラス
 */
public class Sample09_02 {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		FileSystem fs = FileSystems.getDefault(); // FileSystemsはFileSystemのファクトリクラス
		Path path1 = fs.getPath("files/09_01.txt");
		Path path2 = fs.getPath("D:\\development\\JavaSE8Gold\\files\\09_01.txt");
		Path path3 = fs.getPath("D:", "development", "JavaSE8Gold", "files", "09_01.txt");
		System.out.println(path1);
		System.out.println(path2);
		System.out.println(path3);

	}

}
