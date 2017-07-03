package com.stackroute.swisit.documentparser.service;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import org.springframework.stereotype.Service;

import com.stackroute.newintentparser.exude.ExudeData;
import com.stackroute.newintentparser.exude.exception.InvalidDataException;
import com.stackroute.swisit.documentparser.domain.CrawlerResult;
import com.stackroute.swisit.documentparser.domain.WordChecker;



/**
 * Created by user on 30/6/17.
 */
@Service
public class WordCheckerServiceImpl /*implements WordCheckerService*/{
	public static String getWordCheckerByWord(/*String output*/){
		CrawlerResult crawlerResult=new CrawlerResult();
		
		String inputData=crawlerResult.getDocument();
	//String inputData = "This handy tool helps you create dummy text for all your layout needs. We are gradually adding new functionality and we welcome your suggestions and feedback. Please feel free to send us any additional dummy texts.";

		String output3 ="";

		String output2 ="";
		try {

			output2 = ExudeData.getInstance().filterStoppings(inputData);
			output3 = ExudeData.getInstance().getSwearWords(inputData);
		}  catch (InvalidDataException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		System.out.println("output : "+output2);
		System.out.println("output : "+output3);


		String special = output2.replaceAll("[$_&+,:;=?@#|'<>.-^*()%!]", " ");

		for(String s1:special.split(" ")){
			System.out.println(s1);
			WordChecker cb=new WordChecker(s1);
			cb.setWord(s1);
			System.out.println(cb.getWord());}


		return "word search valid"; 

	}
	public static void main(String[] args) {
		System.out.println(getWordCheckerByWord());
	}
}
