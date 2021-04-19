package com.banking.entities;

public class TestStatic {

	private static String VAR_1 = "Hello 1";
	public static String VAR_2 = "Hello 2";
	
	public static String getVAR_1() {
		return TestStatic.VAR_1;
	}

	public static void setVAR_1(String vAR_1) {
		VAR_1 = vAR_1;
	}

	public String getVAR_2() {
		return VAR_2;
	}

	public void setVAR_2(String vAR_2) {
		VAR_2 = vAR_2;
	}

	public TestStatic() {
		// TODO Auto-generated constructor stub
	}

}
