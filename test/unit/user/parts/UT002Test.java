package unit.user.parts;

import static org.junit.Assert.*; 

import com.mysql.jdbc.jdbc2.optional.MysqlDataSource; 

import java.sql.Connection; 
import java.sql.PreparedStatement; 
import java.sql.ResultSet; 
import java.sql.SQLException; 
import java.util.ArrayList; 

import javax.naming.Context; 
import javax.naming.InitialContext; 
import javax.naming.NamingException; 
import javax.sql.DataSource; 

import org.junit.After; 
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass; 
import org.junit.Test; 

import user.bean.RegistrantInfo; 
import user.parts.*; 

public class UT002Test {
	
	/* RegInfCheckコンストラクタを生成 */
	private RegInfDAO regdao = new RegInfDAO();
	private InitialContext ic;
	private DataSource ds;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private ArrayList<RegistrantInfo> arrayRegInfo;
	
	/* 値定義 */
	final int retOK = 0;
	final int retNG = 1;
	
	/* DB接続可能状態にする */
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception { 
		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
		System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");

		InitialContext ic = new InitialContext();
		ic.createSubcontext("java:");
		ic.createSubcontext("java:comp");
		ic.createSubcontext("java:comp/env");
		ic.createSubcontext("java:comp/env/jdbc");

		MysqlDataSource ds = new MysqlDataSource(); 
		ds.setUser("root"); 
		ds.setPassword("root"); 
		ds.setURL("jdbc:mysql://localhost/Task"); 

		ic.bind("java:comp/env/jdbc/Task", ds); 
		
		/* DB接続状態出力 */
		System.out.println("DB接続可能状態");
	} 

	/* テーブルデータ削除 */
	@Before
	public  void tabledelete(){
		try {
			/* DB接続 */
			this.ic = new InitialContext();
			this.ds = (DataSource)this.ic.lookup("java:comp/env/jdbc/Task"); 
			this.con = ds.getConnection();
			/* SQL実行 */
			this.stmt = con.prepareStatement("truncate registrants");
			this.stmt.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	/* 初期データの追加 */
	public void data_add(){
		try {
			/* DB接続 */
			this.ic = new InitialContext();
			this.ds = (DataSource)this.ic.lookup("java:comp/env/jdbc/Task"); 
			this.con = ds.getConnection();
			/* SQL実行 */
			this.stmt = con.prepareStatement("INSERT INTO `registrants` VALUES ('001','鈴木太郎','35'),('002','Tommy','25'),('003','山田花子','30')");
			this.stmt.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	/* DBデータ値の取得 */
	public void dataget(){
		
		RegistrantInfo regInfo;
		arrayRegInfo = new ArrayList<RegistrantInfo>();
		try {
			/* DB接続 */
			this.ic = new InitialContext();
			this.ds = (DataSource)this.ic.lookup("java:comp/env/jdbc/Task"); 
			this.con = ds.getConnection();
			/* SQL実行 */
			this.stmt = con.prepareStatement("select * from `registrants`");
			rs = this.stmt.executeQuery();
			
			/* DBデータの格納 */
			while(rs.next()){
				regInfo = new RegistrantInfo(rs.getString("registrant_id"),
											 rs.getString("registrant_name"),
											 rs.getString("registrant_age"));
				arrayRegInfo.add(regInfo);
			}
			
		} catch (NamingException | SQLException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
	
	/* データの比較 */
	public int datachk( ArrayList<RegistrantInfo> comparray ){
		
		int i=0;
		
		/* 配列サイズ分チェック */
		for( i =0; i < arrayRegInfo.size(); i++ ){
			/* ID,名前,年齢のいずれかが一致しなかった場合 */
			if( arrayRegInfo.get(i).getrId().equals(comparray.get(i).getrId())
					|| arrayRegInfo.get(i).getrName().equals(comparray.get(i).getrName())
					|| arrayRegInfo.get(i).getrAge().equals(comparray.get(i).getrAge())){
				
				//処理なし
			}
			else{
				/* NGを」返却 */
				return retNG;
			}
		}
		
		/* サイズ比較 */
		if( arrayRegInfo.size() == i ){
			/* 正常を返却 */
			return retOK;
		}
		/* NGを」返却 */
		return retNG;
	}
	
	/********************/
	/* 【正常】試験ID:001	*/
	/********************/
	@Test
	public void test002_001() {
		/* 試験ID出力 */
		System.out.println("UT002-001");
		
		/* 初期DATAの追加 */
		data_add();
		
		/* 追加 */
		regdao.insert("004","佐藤路未央","28");
		
		/* 値の取得 */
		dataget();
		
		/* 比較値の格納 */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("001","鈴木太郎","35");
		comparray.add(reg);
		
		reg = new RegistrantInfo("002","Tommy","25");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","山田花子","30");
		comparray.add(reg);
		
		reg = new RegistrantInfo("004","佐藤路未央","28");
		comparray.add(reg);
		
		/* 値のチェック */
		int ret = datachk( comparray );
		
		/* 戻り値判定 */
		if( retOK == ret ){
			/* 正常 */
			assertTrue(true);
		}
		else
		{
			/* 異常 */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* 【正常】試験ID:002	*/
	/********************/
	@Test
	public void test002_002() {
		/* 試験ID出力 */
		System.out.println("UT002-002");
		
		/* 初期DATAの追加 */
		data_add();
		
		/* 更新 */
		regdao.update("002","Michael","29");
		
		/* 値の取得 */
		dataget();
		
		/* 比較値の格納 */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("001","鈴木太郎","35");
		comparray.add(reg);
		
		reg = new RegistrantInfo("002","Michael","29");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","山田花子","30");
		comparray.add(reg);
		
		/* 値のチェック */
		int ret = datachk( comparray );
		
		/* 戻り値判定 */
		if( retOK == ret ){
			/* 正常 */
			assertTrue(true);
		}
		else
		{
			/* 異常 */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* 【正常】試験ID:003	*/
	/********************/
	@Test
	public void test002_003() {
		/* 試験ID出力 */
		System.out.println("UT002-003");
		
		/* 初期DATAの追加 */
		data_add();
		
		/* 削除 */
		regdao.delete("001");
		
		/* 値の取得 */
		dataget();
		
		/* 比較値の格納 */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("002","Tommy","25");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","山田花子","30");
		comparray.add(reg);
		
		/* 値のチェック */
		int ret = datachk( comparray );
		
		/* 戻り値判定 */
		if( retOK == ret ){
			/* 正常 */
			assertTrue(true);
		}
		else
		{
			/* 異常 */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* 【正常】試験ID:004	*/
	/********************/
	@Test
	public void test002_004() {
		/* 試験ID出力 */
		System.out.println("UT002-004");
		
		/* 初期DATAの追加 */
		data_add();
		
		/* 表示 */
		regdao.getReglist();
		
		/* 値の取得 */
		dataget();
		
		/* 比較値の格納 */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("001","鈴木太郎","35");
		comparray.add(reg);
		
		reg = new RegistrantInfo("002","Tommy","25");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","山田花子","30");
		comparray.add(reg);
		
		/* 値のチェック */
		int ret = datachk( comparray );
		
		/* 戻り値判定 */
		if( retOK == ret ){
			/* 正常 */
			assertTrue(true);
		}
		else
		{
			/* 異常 */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* 【正常】試験ID:005	*/
	/********************/
	@Test
	public void test002_005() {
		/* 試験ID出力 */
		System.out.println("UT002-005");
		
		/* NextId */
		String id = regdao.getNextId();
		
		System.out.println(id);
		
		if( "001" == id ){
			/* 正常 */
			assertTrue(true);
		}
		else{
			fail("ERR!!!!");
		}
	}
	
	/* DB接続切断 */
	@After
	public void tearDown(){
		regdao.close();
		/* DB接続状態出力 */
		System.out.println("DB切断");
	}
	
}
