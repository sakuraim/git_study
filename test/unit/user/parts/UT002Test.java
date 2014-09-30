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
import org.junit.BeforeClass; 
import org.junit.Test; 

import user.bean.RegistrantInfo; 
import user.parts.*; 

 

public class UT002Test {
	
	private InitialContext initCon;
	private DataSource ds;
	private Connection con;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	@BeforeClass 
	public static void setUpBeforeClass() throws Exception { 


		System.setProperty(Context.INITIAL_CONTEXT_FACTORY, "org.apache.naming.java.javaURLContextFactory");
	     System.setProperty(Context.URL_PKG_PREFIXES, "org.apache.naming");
	  InitialContext ic = new InitialContext(); 
	  ic.createSubcontext("java:");
	  ic.createSubcontext("java:");
	  ic.createSubcontext("java:comp");
	  ic.createSubcontext("java:comp/env");

	    MysqlDataSource ds = new MysqlDataSource(); 
	    ds.setUser("root"); 
	    ds.setPassword("root"); 
	    ds.setURL("jdbc:mysql://localhost/Task"); 

	    ic.bind("java:comp/env/jdbc/Task", ds); 
	     
	} 

	
	
	
	
	
	
	
	@Test
	public void test002_001() {
		
		
		
		
		
		/* 試験ID出力 */
		System.out.println("UT002-001");

		/* RegInfCheckコンストラクタを生成 */
		RegInfDAO regdao = new RegInfDAO();
	
		regdao.insert("004","佐藤路未央","28");
		
		
	}
	
	
	

}
