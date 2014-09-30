package unit.user.parts;

import static org.junit.Assert.*;
import org.junit.Test;
import user.parts.RegInfCheck;

public class UT001Test {

	/********************/
	/* 【正常】試験ID:001	*/
	/********************/
	@Test
	public void test001_001() {

		/* 試験ID出力 */
		System.out.println("UT001-001");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName 桁数チェック*/
		infchk.checkName("0123456789");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【正常】試験ID:002	*/
	/********************/
	@Test
	public void test001_002() {

		/* 試験ID出力 */
		System.out.println("UT001-002");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName 桁数チェック */
		infchk.checkName("あいうえおかきくけこ");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【異常】試験ID:003	*/
	/********************/
	@Test
	public void test001_003() {

		/* 試験ID出力 */
		System.out.println("UT001-003");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName 桁数チェック */
		infchk.checkName("01234567890");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがある場合 */
		if (errmsg.equals("名前は10桁以内で入力してください。<br />")) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【異常】試験ID:004	*/
	/********************/
	@Test
	public void test001_004() {

		/* 試験ID出力 */
		System.out.println("UT001-004");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName 桁数チェック */
		infchk.checkName("あいうえおかきくけこさ");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがある場合 */
		if (errmsg.equals("名前は10桁以内で入力してください。<br />")) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* 【正常】試験ID:005	*/
	/********************/
	@Test
	public void test001_005() {

		/* 試験ID出力 */
		System.out.println("UT001-005");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge 値範囲チェック */
		infchk.checkAge("16");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* 【正常】試験ID:006	*/
	/********************/
	@Test
	public void test001_006() {

		/* 試験ID出力 */
		System.out.println("UT001-006");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge 値範囲チェック */
		infchk.checkAge("60");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【異常】試験ID:007	*/
	/********************/
	@Test
	public void test001_007() {

		/* 試験ID出力 */
		System.out.println("UT001-007");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge 値範囲チェック */
		infchk.checkAge("15");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (errmsg.equals("年齢は(16-60)の範囲で入力してください。<br />") ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【異常】試験ID:008	*/
	/********************/
	@Test
	public void test001_008() {

		/* 試験ID出力 */
		System.out.println("UT001-008");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge 値範囲チェック */
		infchk.checkAge("61");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (errmsg.equals("年齢は(16-60)の範囲で入力してください。<br />") ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【異常】試験ID:009	*/
	/********************/
	@Test
	public void test001_009() {

		/* 試験ID出力 */
		System.out.println("UT001-009");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge 値範囲チェック */
		infchk.checkAge("１６");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (errmsg.equals("年齢は数値(半角)で入力してください。<br />") ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【異常】試験ID:010	*/
	/********************/
	@Test
	public void test001_010() {

		/* 試験ID出力 */
		System.out.println("UT001-010");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge 値範囲チェック */
		infchk.checkAge("あいうえお");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (errmsg.equals("年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />") ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【異常】試験ID:011	*/
	/********************/
	@Test
	public void test001_011() {

		/* 試験ID出力 */
		System.out.println("UT001-011");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge 値範囲チェック */
		infchk.checkAge("16あいうえお");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if (errmsg.equals("年齢は数値(半角)で入力してください。<br />年齢は(16-60)の範囲で入力してください。<br />") ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* 【正常】試験ID:012	*/
	/********************/
	@Test
	public void test001_012() {

		/* 試験ID出力 */
		System.out.println("UT001-012");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkId 値範囲チェック */
		infchk.checkId("999");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if ( null == errmsg || 0 == errmsg.length() ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* 【正常】試験ID:013	*/
	/********************/
	@Test
	public void test001_013() {

		/* 試験ID出力 */
		System.out.println("UT001-013");

		/* RegInfCheckコンストラクタを生成 */
		RegInfCheck infchk = new RegInfCheck();

		/* checkId 値範囲チェック */
		infchk.checkId("1000");

		/* エラーメッセージ取得 */
		String errmsg = infchk.getErrMsg();
		
		/* メッセージ出力 */
		System.out.println(errmsg);

		/* エラーメッセージがない場合 */
		if ( errmsg.equals("登録可能なID（999）を超えています。管理者に問い合わせてください。<br />") ) {
			/* 正常 */
			assertTrue(true);
		}
		/* それ以外の場合 */
		else {
			/* 異常 */
			fail("ERR!!!!");
		}
	}
}
