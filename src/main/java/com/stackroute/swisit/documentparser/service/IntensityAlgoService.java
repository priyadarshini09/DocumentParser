package com.stackroute.swisit.documentparser.service;

/**
 * Created by user on 30/6/17.
 */
public interface IntensityAlgoService {
	public ArrayList<ContentSchema> calculateIntensity(HashMap<String,HashMap<String,Integer>> parsedDocumentMap);
}
