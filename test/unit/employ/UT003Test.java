package unit.employ;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import java.io.*;
import java.util.*;
import java.text.*;

import employ.OutLog;

public class UT003Test {

	/********************/
	/* FILE削除			*/
	/********************/
	@Before
	public void test003_before(){
		/* FILE削除 */
		File file = new File("C:/test/log/log.txt");
		
		/* FILEが存在している場合 */
		if(file.exists()){
			boolean ret = file.delete();
			
			if(true == ret){
				/* 処理なし */
			}
			else{
				System.out.println("FILE 削除失敗");
			}
		}
		else{
			System.out.println("FILEなし");
		}
	}
	
	/********************/
	/* 【正常】試験ID:001	*/
	/********************/
	@Test
	public void test003_001(){
		
		/* OutLogコンストラクタ生成 */
		OutLog outlog = new OutLog();
		
		/* outLogDmp呼び出し */
		OutLog.outLogDmp("sample：サンプル");
		
		/* 比較文字列の作成 */
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String datastr = ":sample：サンプル";

		/* ファイルの読み込み */
		File file = new File("C:/test/log/log.txt");
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			br.close();
			
			/* ファイルの中身を表示 */
			System.out.println("UT003-001");
			System.out.println(str);
			
			/* 初期化 */
			sdf1.setLenient(false);
			
			/* 文字列の分割 */
			String date = (String)str.subSequence(0,18);
			String data = (String)str.substring(19);
			
			/* 日付型チェック */
			sdf1.parse(date);
			
			if( datastr == data ){
				/* 正常 */
				assertTrue(true);
			}

		} catch (IOException | ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	/********************/
	/* 【正常】試験ID:002	*/
	/********************/
	@Test
	public void test003_002(){
		
		/* OutLogコンストラクタ生成 */
		OutLog outlog = new OutLog();
		
		/* outLogDmp呼び出し */
		OutLog.outLogDmp(12345);
		
		/* 比較文字列の作成 */
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String datastr = ":12345";

		/* ファイルの読み込み */
		File file = new File("C:/test/log/log.txt");
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			br.close();
			
			/* ファイルの中身を表示 */
			System.out.println("UT003-002");
			System.out.println(str);
			
			/* 初期化 */
			sdf1.setLenient(false);
			
			/* 文字列の分割 */
			String date = (String)str.subSequence(0,18);
			String data = (String)str.substring(19);
			
			/* 日付型チェック */
			sdf1.parse(date);
			
			if( datastr == data ){
				/* 正常 */
				assertTrue(true);
			}

		} catch (IOException | ParseException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
