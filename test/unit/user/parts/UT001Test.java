package unit.user.parts;

import static org.junit.Assert.*;
import org.junit.Test;
import user.parts.RegInfCheck;

public class UT001Test {

	/********************/
	/* �y����z����ID:001	*/
	/********************/
	@Test
	public void test001_001() {

		/* ����ID�o�� */
		System.out.println("UT001-001");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName �����`�F�b�N*/
		infchk.checkName("0123456789");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y����z����ID:002	*/
	/********************/
	@Test
	public void test001_002() {

		/* ����ID�o�� */
		System.out.println("UT001-002");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName �����`�F�b�N */
		infchk.checkName("��������������������");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y�ُ�z����ID:003	*/
	/********************/
	@Test
	public void test001_003() {

		/* ����ID�o�� */
		System.out.println("UT001-003");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName �����`�F�b�N */
		infchk.checkName("01234567890");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W������ꍇ */
		if (errmsg.equals("���O��10���ȓ��œ��͂��Ă��������B<br />")) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y�ُ�z����ID:004	*/
	/********************/
	@Test
	public void test001_004() {

		/* ����ID�o�� */
		System.out.println("UT001-004");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkName �����`�F�b�N */
		infchk.checkName("����������������������");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W������ꍇ */
		if (errmsg.equals("���O��10���ȓ��œ��͂��Ă��������B<br />")) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* �y����z����ID:005	*/
	/********************/
	@Test
	public void test001_005() {

		/* ����ID�o�� */
		System.out.println("UT001-005");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge �l�͈̓`�F�b�N */
		infchk.checkAge("16");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* �y����z����ID:006	*/
	/********************/
	@Test
	public void test001_006() {

		/* ����ID�o�� */
		System.out.println("UT001-006");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge �l�͈̓`�F�b�N */
		infchk.checkAge("60");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (null == errmsg || 0 == errmsg.length() ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y�ُ�z����ID:007	*/
	/********************/
	@Test
	public void test001_007() {

		/* ����ID�o�� */
		System.out.println("UT001-007");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge �l�͈̓`�F�b�N */
		infchk.checkAge("15");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (errmsg.equals("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />") ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y�ُ�z����ID:008	*/
	/********************/
	@Test
	public void test001_008() {

		/* ����ID�o�� */
		System.out.println("UT001-008");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge �l�͈̓`�F�b�N */
		infchk.checkAge("61");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (errmsg.equals("�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />") ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y�ُ�z����ID:009	*/
	/********************/
	@Test
	public void test001_009() {

		/* ����ID�o�� */
		System.out.println("UT001-009");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge �l�͈̓`�F�b�N */
		infchk.checkAge("�P�U");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (errmsg.equals("�N��͐��l(���p)�œ��͂��Ă��������B<br />") ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y�ُ�z����ID:010	*/
	/********************/
	@Test
	public void test001_010() {

		/* ����ID�o�� */
		System.out.println("UT001-010");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge �l�͈̓`�F�b�N */
		infchk.checkAge("����������");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (errmsg.equals("�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />") ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y�ُ�z����ID:011	*/
	/********************/
	@Test
	public void test001_011() {

		/* ����ID�o�� */
		System.out.println("UT001-011");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkAge �l�͈̓`�F�b�N */
		infchk.checkAge("16����������");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if (errmsg.equals("�N��͐��l(���p)�œ��͂��Ă��������B<br />�N���(16-60)�͈̔͂œ��͂��Ă��������B<br />") ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}

	/********************/
	/* �y����z����ID:012	*/
	/********************/
	@Test
	public void test001_012() {

		/* ����ID�o�� */
		System.out.println("UT001-012");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkId �l�͈̓`�F�b�N */
		infchk.checkId("999");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if ( null == errmsg || 0 == errmsg.length() ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
	
	/********************/
	/* �y����z����ID:013	*/
	/********************/
	@Test
	public void test001_013() {

		/* ����ID�o�� */
		System.out.println("UT001-013");

		/* RegInfCheck�R���X�g���N�^�𐶐� */
		RegInfCheck infchk = new RegInfCheck();

		/* checkId �l�͈̓`�F�b�N */
		infchk.checkId("1000");

		/* �G���[���b�Z�[�W�擾 */
		String errmsg = infchk.getErrMsg();
		
		/* ���b�Z�[�W�o�� */
		System.out.println(errmsg);

		/* �G���[���b�Z�[�W���Ȃ��ꍇ */
		if ( errmsg.equals("�o�^�\��ID�i999�j�𒴂��Ă��܂��B�Ǘ��҂ɖ₢���킹�Ă��������B<br />") ) {
			/* ���� */
			assertTrue(true);
		}
		/* ����ȊO�̏ꍇ */
		else {
			/* �ُ� */
			fail("ERR!!!!");
		}
	}
}
