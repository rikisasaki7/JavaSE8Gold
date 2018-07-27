package chapter12;

import java.util.ListResourceBundle;

/*
 * ListResourceBundleを使用するサンプルコード
 * 定義のルールは以下の通り
 * ①ListResourceBundleを継承したpublicなクラスを用意する
 * ②getContentsメソッドをオーバーライドし、配列でリソースのリストを作成する
 * ③リソースは、キーと値を要素とする配列として作成する
 *
 * 異なる国のクラスを作成する際のルール
 * ・基底名を同一にする（MyResources）
 * ・基底名の後に「_」で言語コード、国コードを付ける
 * 例）
 * 　MyResources_en　＜－言語コードを指定したロケールの場合に読み込まれる
 * 　MyResources_en_US　＜－言語コードと国コードを指定したロケールの場合に読み込まれる
 *
 * ①の定義
 */
public class MyResources extends ListResourceBundle {

	/*
	 * (非 Javadoc)
	 * @see java.util.ListResourceBundle#getContents()
	 * ②の実装
	 */
	@Override
	protected Object[][] getContents(){
		// ③の実装
		Object[][] contents = {{"send", "送信"}, {"cancel", "取り消し"}};
		return contents;
	}

}
