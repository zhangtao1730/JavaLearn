package com.sxt.io;

import java.io.File;

/**
 * ����Ŀ¼
 * 1.mkdir():ȷ���ϼ�Ŀ¼���ڣ������ڴ���ʧ��
 * 2.mkdirs():�ϼ�Ŀ¼���Բ����ڣ�������һͬ����
 * @author Administrator
 *
 */
public class DirDemo01 {
	public static void main(String[] args) {
		File dir=new File("F:/workspace/IO_study01/dir/test");
		//����Ŀ¼
		boolean flag=dir.mkdirs();
		System.out.println(flag);
		dir=new File("F:/workspace/IO_study01/dir/test2");
		flag=dir.mkdir();
		System.out.println(flag);
	}
}
