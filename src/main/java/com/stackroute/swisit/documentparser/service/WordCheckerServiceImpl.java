package com.stackroute.swisit.documentparser.service;

import com.uttesh.exude.ExudeData;
import com.uttesh.exude.exception.InvalidDataException;
import org.springframework.stereotype.Service;

import com.stackroute.swisit.documentparser.domain.CrawlerResult;
import com.stackroute.swisit.documentparser.domain.WordChecker;

import java.util.HashMap;
import java.util.Iterator;
import java.util.*;
import java.util.Map;


/**
 * Created by user on 30/6/17.
 */
@Service
public class WordCheckerServiceImpl /*implements WordCheckerService*/{
	public HashMap<String,List<String>> getWordCheckerByWord(HashMap<String,String> input){
		//CrawlerResult crawlerResult=new CrawlerResult();

		HashMap<String,List<String>> resultMap = new HashMap<>();

		//String inputData=crawlerResult.getDocument();
	String inputData = "This handy tool helps you create dummy text for all your layout needs. We are gradually adding new functionality and we welcome your suggestions and feedback. Please feel free to send us any additional dummy texts.";

		HashMap<String,String> map = new HashMap<>();
		Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
		while(entries.hasNext()) {
			Map.Entry<String, String> entry =  entries.next();
			String key = entry.getKey();
			 inputData = entry.getValue();

			String output2 = "";

			String output3 = "";
			try {

				output2 = ExudeData.getInstance().filterStoppings(inputData);
				output3 = ExudeData.getInstance().getSwearWords(inputData);
			} catch (InvalidDataException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			System.out.println("output : " + output2);
			System.out.println("output : " + output3);


			String special = output2.replaceAll("[$_&+,:;=?@#|'<>.-^*()%!]", " ");

			List<String> result = new ArrayList<>();
			for (String s1 : special.split(" ")) {
				//System.out.println(s1);
				result.add(s1);

				System.out.println(result);
			}
			resultMap.put(key,result);
		}
		return resultMap;

	}
//	public static void main(String[] args) {
//		System.out.println(getWordCheckerByWord());
//	}
}
