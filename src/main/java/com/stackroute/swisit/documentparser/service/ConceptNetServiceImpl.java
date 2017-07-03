package com.stackroute.swisit.documentparser.service;

import com.stackroute.swisit.documentparser.domain.Term;
import com.stackroute.swisit.documentparser.repository.Neo4jParserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

/**
 * Created by user on 30/6/17.
 */
@Service
public class ConceptNetServiceImpl implements ConceptNetService {

    @Autowired
    Neo4jParserService neo4jParserService;

    public HashMap<String,HashMap<String,Integer>> createDocumentModel(HashMap<String,String[]> input){
        List<Term> termsList = neo4jParserService.getTerms();
        for(int i=0;i<termsList.size();i++){

        }
        return null;
    }
}
