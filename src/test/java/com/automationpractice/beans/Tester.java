package com.automationpractice.beans;



import java.util.ArrayList;
import java.util.List;

import com.automationpractice.utilities.DatabaseUtils;


public class Tester {
public static void main(String[] args) {
	
DatabaseUtils.createConnection();
List<List<Object>> list = DatabaseUtils.getQueryResultList("select last_name, first_name from employees limit 10");

List<String>brothers = new ArrayList<String>();

System.out.println(list);
	//something is added
	System.out.println("Jenkins is triggered by GitHub push");
}
	
	
}
