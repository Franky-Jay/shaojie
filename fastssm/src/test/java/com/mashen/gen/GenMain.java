package com.mashen.gen;

public class GenMain {
	public static void main(String[] args) {
		String configFile = "/generatorConfig.xml";
		try {

			 String[] tableNames = new String[] { "test_demo"};
			GenMybatisFiles.gen(configFile, tableNames);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
