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
	/* FILE�폜			*/
	/********************/
	@Before
	public void test003_before(){
		/* FILE�폜 */
		File file = new File("C:/test/log/log.txt");
		
		/* FILE�����݂��Ă���ꍇ */
		if(file.exists()){
			boolean ret = file.delete();
			
			if(true == ret){
				/* �����Ȃ� */
			}
			else{
				System.out.println("FILE �폜���s");
			}
		}
		else{
			System.out.println("FILE�Ȃ�");
		}
	}
	
	/********************/
	/* �y����z����ID:001	*/
	/********************/
	@Test
	public void test003_001(){
		
		/* OutLog�R���X�g���N�^���� */
		OutLog outlog = new OutLog();
		
		/* outLogDmp�Ăяo�� */
		OutLog.outLogDmp("sample�F�T���v��");
		
		/* ��r������̍쐬 */
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String datastr = ":sample�F�T���v��";

		/* �t�@�C���̓ǂݍ��� */
		File file = new File("C:/test/log/log.txt");
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			br.close();
			
			/* �t�@�C���̒��g��\�� */
			System.out.println("UT003-001");
			System.out.println(str);
			
			/* ������ */
			sdf1.setLenient(false);
			
			/* ������̕��� */
			String date = (String)str.subSequence(0,18);
			String data = (String)str.substring(19);
			
			/* ���t�^�`�F�b�N */
			sdf1.parse(date);
			
			if( datastr == data ){
				/* ���� */
				assertTrue(true);
			}

		} catch (IOException | ParseException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
	}
	
	/********************/
	/* �y����z����ID:002	*/
	/********************/
	@Test
	public void test003_002(){
		
		/* OutLog�R���X�g���N�^���� */
		OutLog outlog = new OutLog();
		
		/* outLogDmp�Ăяo�� */
		OutLog.outLogDmp(12345);
		
		/* ��r������̍쐬 */
		SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		String datastr = ":12345";

		/* �t�@�C���̓ǂݍ��� */
		File file = new File("C:/test/log/log.txt");
		BufferedReader br;
		
		try {
			
			br = new BufferedReader(new FileReader(file));
			String str = br.readLine();
			br.close();
			
			/* �t�@�C���̒��g��\�� */
			System.out.println("UT003-002");
			System.out.println(str);
			
			/* ������ */
			sdf1.setLenient(false);
			
			/* ������̕��� */
			String date = (String)str.subSequence(0,18);
			String data = (String)str.substring(19);
			
			/* ���t�^�`�F�b�N */
			sdf1.parse(date);
			
			if( datastr == data ){
				/* ���� */
				assertTrue(true);
			}

		} catch (IOException | ParseException e) {
			// TODO �����������ꂽ catch �u���b�N
			e.printStackTrace();
		}
	}
}
