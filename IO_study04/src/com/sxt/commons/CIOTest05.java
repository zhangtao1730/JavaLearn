package com.sxt.commons;

import java.io.File;
import java.io.IOException;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * ����
 * @author Administrator
 *
 */
public class CIOTest05 {
	public static void main(String[] args) throws IOException {
		//�����ļ�
//		FileUtils.copyFile(new File("IO.jpg"), new File("IO_copy.jpg"));
		//�����ļ���Ŀ¼
		FileUtils.copyFileToDirectory(new File("IO.jpg"),new File("lib"));
		
	}
}
