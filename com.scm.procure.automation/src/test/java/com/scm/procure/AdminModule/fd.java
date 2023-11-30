package com.scm.procure.AdminModule;

import com.scm.procure.GenericUtils.JavaUtils;

public class fd {
public static void main(String[] args) {
	JavaUtils javaUtils = new JavaUtils();
	String s = "string";
	System.out.println( s+javaUtils.systemDate());
	System.out.println(javaUtils.dateFormat());
}
}
