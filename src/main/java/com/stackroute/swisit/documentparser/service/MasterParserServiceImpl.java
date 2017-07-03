package com.stackroute.swisit.documentparser.service;
/*------Importing Libraries-----*/
import com.stackroute.swisit.documentparser.domain.CrawlerResult;
import com.stackroute.swisit.documentparser.domain.DocumentParserResult;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * Created by user on 30/6/17.
 */
@Service
public class MasterParserServiceImpl implements MasterParserService {

    private KeywordScannerService keywordScannerService;

    @Autowired
    public void setKeywordScannerService(KeywordScannerService keywordScannerService){
        this.keywordScannerService=keywordScannerService;
    }

    public Iterable<DocumentParserResult> parseDocument(CrawlerResult[] crawlerResults){
        Document document=null;
        ArrayList<DocumentParserResult> documentParserResults = new ArrayList<DocumentParserResult>();
        for(CrawlerResult crawlerResult : crawlerResults) {
            document = Jsoup.parse(crawlerResult.getDocument());
        }
        keywordScannerService.scanDocument(document);
        return documentParserResults;
    }
}
