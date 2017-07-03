package com.stackroute.swisit.documentparser.service;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

/**
 * Created by user on 2/7/17.
 */
@Service
public class ObjectMapperServiceImpl implements ObjectMapperService {

    @Override
    public List<LinkedHashMap<String, String>> objectMapping(String filePath) {

        ObjectMapper objectMapper=new ObjectMapper();
        File file= new File(filePath);
        List<LinkedHashMap<String,String>> list = null;

        try {
            list = (List<LinkedHashMap<String, String>>) objectMapper.readValue(file, ArrayList.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}
