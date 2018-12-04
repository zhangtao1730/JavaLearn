package com.sxt.commons;

import java.io.File;
import java.util.Collection;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.filefilter.DirectoryFileFilter;
import org.apache.commons.io.filefilter.EmptyFileFilter;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.SuffixFileFilter;

/**
 * 列出子孙及
 * @author Administrator
 *
 */
public class CIOTest02 {
	public static void main(String[] args) {
		Collection<File>files=FileUtils.listFiles(new File("F:/workspace/IO_study04"), EmptyFileFilter.NOT_EMPTY, null);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("--------------------");
		files = FileUtils.listFiles(new File("F:/workspace/IO_study04"), EmptyFileFilter.NOT_EMPTY,
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("--------------------");
		files = FileUtils.listFiles(new File("F:/workspace/IO_study04"), new SuffixFileFilter("java"),
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
		System.out.println("--------------------");
		files = FileUtils.listFiles(new File("F:/workspace/IO_study04"),
				FileFilterUtils.or(new SuffixFileFilter("java"), new SuffixFileFilter("class")),
				DirectoryFileFilter.INSTANCE);
		for (File file : files) {
			System.out.println(file.getAbsolutePath());
		}
	}
}
