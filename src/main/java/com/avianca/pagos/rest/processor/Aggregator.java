package com.avianca.pagos.rest.processor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.apache.camel.BeanInject;
import org.apache.camel.Exchange;
import org.apache.camel.processor.aggregate.AggregationStrategy;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonTypeInfo.Id;

public class Aggregator implements AggregationStrategy {
	@BeanInject("loggerRef")
	private Logger LOG = LoggerFactory.getLogger(Aggregator.class);
	@Override
	public Exchange aggregate(Exchange oldExchange, Exchange newExchange) {
		
		
		if (oldExchange == null) {
            return newExchange;
        }

        String newBody = (String) newExchange.getIn().getBody();        
        if(!newBody.isEmpty()){
            newBody = newBody.substring(1, newBody.length()-1); 
            String[] keyValuePairs = newBody.split(",");
            Map<String,String> map = new HashMap<>(); 
            for(String pair : keyValuePairs)                        
            {
                String[] entry = pair.split("=");                    
                map.put(entry[0].trim(), entry[1].trim());          
            }
            oldExchange.getIn().setHeader("contactId",map.get("id"));
            oldExchange.getIn().setHeader("lang",map.get("lang"));
        }

        return oldExchange;
    }
}


