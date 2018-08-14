package chapter12;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLClassLoader;

/**
 * @author Riki
 * propertiesを使用したリソースバンドルの基底クラス
 * 毎回取得処理書くの面倒だから定義
 */
class Sample12_MyProperties_Resources {
	// propertiesファイルの取得。
	// WEBプロジェクトでしなかったので、任意の場所にpropertiesファイルを配置
	// 参考
	// https://qiita.com/tool-taro/items/1e0894a667095cc09fe7

	//propertiesファイル配置ディレクトリ Todo mac用になっている
    private static String dir = "/Users/Riki/development/eclipse/JavaSE8Gold/conf";
    //propertiesファイル名(.propertiesは不要)
    protected static String SOURCE = "MyResources";
    //propertiesファイルの取得に必要なクラスローダー
    private static URLClassLoader URL_LOADER;
    static {
    	try{
        	URL_LOADER = new URLClassLoader(new URL[]{new File(dir).toURI().toURL()});
    	} catch (MalformedURLException e){
    		System.out.println(e.getStackTrace());
    		System.out.println(e.getMessage());
    	}
    }
    public static URLClassLoader getPropertiesClassLoader(){ return URL_LOADER;}
    private Sample12_MyProperties_Resources(){}
}
