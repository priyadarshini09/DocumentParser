package com.stackroute.swisit.documentparser.service;

/**
 * Created by user on 30/6/17.
 */
public interface WordCheckerService {
	public HashMap<String,List<String>> getWordCheckerByWord(HashMap<String,String> input);
}
