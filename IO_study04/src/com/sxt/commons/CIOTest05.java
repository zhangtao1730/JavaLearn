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
 * 拷贝
 * @author Administrator
 *
 */
public class CIOTest05 {
	public static void main(String[] args) throws IOException {
		//复制文件
//		FileUtils.copyFile(new File("IO.jpg"), new File("IO_copy.jpg"));
		//复制文件到目录
		FileUtils.copyFileToDirectory(new File("IO.jpg"),new File("lib"));
		
	}
}
