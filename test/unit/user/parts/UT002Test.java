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
	
	/* RegInfCheck�R���X�g���N�^�𐶐� */
	private RegInfDAO regdao = new RegInfDAO();
	private InitialContext ic;
	private DataSource ds;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	private ArrayList<RegistrantInfo> arrayRegInfo;
	
	/* �l��` */
	final int retOK = 0;
	final int retNG = 1;
	
	/* DB�ڑ��\��Ԃɂ��� */
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
		
		/* DB�ڑ���ԏo�� */
		System.out.println("DB�ڑ��\���");
	} 

	/* �e�[�u���f�[�^�폜 */
	@Before
	public  void tabledelete(){
		try {
			/* DB�ڑ� */
			this.ic = new InitialContext();
			this.ds = (DataSource)this.ic.lookup("java:comp/env/jdbc/Task"); 
			this.con = ds.getConnection();
			/* SQL���s */
			this.stmt = con.prepareStatement("truncate registrants");
			this.stmt.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
	}

	/* �����f�[�^�̒ǉ� */
	public void data_add(){
		try {
			/* DB�ڑ� */
			this.ic = new InitialContext();
			this.ds = (DataSource)this.ic.lookup("java:comp/env/jdbc/Task"); 
			this.con = ds.getConnection();
			/* SQL���s */
			this.stmt = con.prepareStatement("INSERT INTO `registrants` VALUES ('001','��ؑ��Y','35'),('002','Tommy','25'),('003','�R�c�Ԏq','30')");
			this.stmt.executeUpdate();
		} catch (NamingException | SQLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
	}
	
	/* DB�f�[�^�l�̎擾 */
	public void dataget(){
		
		RegistrantInfo regInfo;
		arrayRegInfo = new ArrayList<RegistrantInfo>();
		try {
			/* DB�ڑ� */
			this.ic = new InitialContext();
			this.ds = (DataSource)this.ic.lookup("java:comp/env/jdbc/Task"); 
			this.con = ds.getConnection();
			/* SQL���s */
			this.stmt = con.prepareStatement("select * from `registrants`");
			rs = this.stmt.executeQuery();
			
			/* DB�f�[�^�̊i�[ */
			while(rs.next()){
				regInfo = new RegistrantInfo(rs.getString("registrant_id"),
											 rs.getString("registrant_name"),
											 rs.getString("registrant_age"));
				arrayRegInfo.add(regInfo);
			}
			
		} catch (NamingException | SQLException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
	}
	
	/* �f�[�^�̔�r */
	public int datachk( ArrayList<RegistrantInfo> comparray ){
		
		int i=0;
		
		/* �z��T�C�Y���`�F�b�N */
		for( i =0; i < arrayRegInfo.size(); i++ ){
			/* ID,���O,�N��̂����ꂩ����v���Ȃ������ꍇ */
			if( arrayRegInfo.get(i).getrId().equals(comparray.get(i).getrId())
					|| arrayRegInfo.get(i).getrName().equals(comparray.get(i).getrName())
					|| arrayRegInfo.get(i).getrAge().equals(comparray.get(i).getrAge())){
				
				//�����Ȃ�
			}
			else{
				/* NG���v�ԋp */
				return retNG;
			}
		}
		
		/* �T�C�Y��r */
		if( arrayRegInfo.size() == i ){
			/* �����ԋp */
			return retOK;
		}
		/* NG���v�ԋp */
		return retNG;
	}
	
	/********************/
	/* �y����z����ID:001	*/
	/********************/
	@Test
	public void test002_001() {
		/* ����ID�o�� */
		System.out.println("UT002-001");
		
		/* ����DATA�̒ǉ� */
		data_add();
		
		/* �ǉ� */
		regdao.insert("004","�����H����","28");
		
		/* �l�̎擾 */
		dataget();
		
		/* ��r�l�̊i�[ */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("001","��ؑ��Y","35");
		comparray.add(reg);
		
		reg = new RegistrantInfo("002","Tommy","25");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","�R�c�Ԏq","30");
		comparray.add(reg);
		
		reg = new RegistrantInfo("004","�����H����","28");
		comparray.add(reg);
		
		/* �l�̃`�F�b�N */
		int ret = datachk( comparray );
		
		/* �߂�l���� */
		if( retOK == ret ){
			/* ���� */
			assertTrue(true);
		}
		else
		{
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* �y����z����ID:002	*/
	/********************/
	@Test
	public void test002_002() {
		/* ����ID�o�� */
		System.out.println("UT002-002");
		
		/* ����DATA�̒ǉ� */
		data_add();
		
		/* �X�V */
		regdao.update("002","Michael","29");
		
		/* �l�̎擾 */
		dataget();
		
		/* ��r�l�̊i�[ */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("001","��ؑ��Y","35");
		comparray.add(reg);
		
		reg = new RegistrantInfo("002","Michael","29");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","�R�c�Ԏq","30");
		comparray.add(reg);
		
		/* �l�̃`�F�b�N */
		int ret = datachk( comparray );
		
		/* �߂�l���� */
		if( retOK == ret ){
			/* ���� */
			assertTrue(true);
		}
		else
		{
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* �y����z����ID:003	*/
	/********************/
	@Test
	public void test002_003() {
		/* ����ID�o�� */
		System.out.println("UT002-003");
		
		/* ����DATA�̒ǉ� */
		data_add();
		
		/* �폜 */
		regdao.delete("001");
		
		/* �l�̎擾 */
		dataget();
		
		/* ��r�l�̊i�[ */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("002","Tommy","25");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","�R�c�Ԏq","30");
		comparray.add(reg);
		
		/* �l�̃`�F�b�N */
		int ret = datachk( comparray );
		
		/* �߂�l���� */
		if( retOK == ret ){
			/* ���� */
			assertTrue(true);
		}
		else
		{
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* �y����z����ID:004	*/
	/********************/
	@Test
	public void test002_004() {
		/* ����ID�o�� */
		System.out.println("UT002-004");
		
		/* ����DATA�̒ǉ� */
		data_add();
		
		/* �\�� */
		regdao.getReglist();
		
		/* �l�̎擾 */
		dataget();
		
		/* ��r�l�̊i�[ */
		ArrayList<RegistrantInfo> comparray = new ArrayList<RegistrantInfo>();
		RegistrantInfo reg = new RegistrantInfo("001","��ؑ��Y","35");
		comparray.add(reg);
		
		reg = new RegistrantInfo("002","Tommy","25");
		comparray.add(reg);
		
		reg = new RegistrantInfo("003","�R�c�Ԏq","30");
		comparray.add(reg);
		
		/* �l�̃`�F�b�N */
		int ret = datachk( comparray );
		
		/* �߂�l���� */
		if( retOK == ret ){
			/* ���� */
			assertTrue(true);
		}
		else
		{
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* �y����z����ID:005	*/
	/********************/
	@Test
	public void test002_005() {
		/* ����ID�o�� */
		System.out.println("UT002-005");
		
		/* NextId */
		String id = regdao.getNextId();
		
		System.out.println(id);
		
		if( "001" == id ){
			/* ���� */
			assertTrue(true);
		}
		else{
			fail("ERR!!!!");
		}
	}
	
	/* DB�ڑ��ؒf */
	@After
	public void tearDown(){
		regdao.close();
		/* DB�ڑ���ԏo�� */
		System.out.println("DB�ؒf");
	}
	
}
