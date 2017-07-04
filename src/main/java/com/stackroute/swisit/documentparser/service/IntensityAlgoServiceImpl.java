package com.stackroute.swisit.documentparser.service;

import java.util.*;
import java.util.Map.Entry;

import org.springframework.stereotype.Service;

import com.stackroute.swisit.documentparser.domain.ContentSchema;


/**
 * Created by user on 30/6/17.
 */
@Service
public class IntensityAlgoServiceImpl implements IntensityAlgoService {
	
	float count;
	
	private ObjectMapperService objectMapperService;
	
	ArrayList<ContentSchema> contentSchemas = new ArrayList<>();
	
	public ArrayList<ContentSchema> calculateIntensity(HashMap<String,HashMap<String,Integer>> parsedDocumentMap){
		
		HashMap<String,String> map = (HashMap<String, String>) objectMapperService.objectMapping("./src/main/resources/common/intensitycopy.json");
		
		for(Entry<String, HashMap<String, Integer>> parsedDocumentMapRef : parsedDocumentMap.entrySet()){
			String wordKey = parsedDocumentMapRef.getKey();
			for(Entry<String, Integer> wordKeyValueRef : parsedDocumentMapRef.getValue().entrySet()){
				String tagKey = wordKeyValueRef.getKey();
				Integer tagFrequency = wordKeyValueRef.getValue();
				float intensity = Float.parseFloat(map.get(tagKey));
				count+=tagFrequency*intensity;
			}
			ContentSchema contentSchema= new ContentSchema(wordKey,count);
			contentSchemas.add(contentSchema);
		}
		return contentSchemas;
	}
}

