package com.dynatrace.demo.oceanfacts.controller;

import com.dynatrace.demo.oceanfacts.entities.Fact;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class FactsController {

    private static final Logger logger = LogManager.getLogger(FactsController.class);

    @RequestMapping("/")
    public String getRandomFact(){
        logger.info("Retrieving new fact");
        RestTemplate restTemplate = new RestTemplate();
        Fact fact = restTemplate.getForObject("https://oceanfacts.herokuapp.com/api/random/", Fact.class);
        return fact.value;
    }

    @RequestMapping("/{topic}")
    public String getFact(@PathVariable String topic){
        logger.info("Retrieving new fact for topic: {}", topic);
        RestTemplate restTemplate = new RestTemplate();
        Fact fact = restTemplate.getForObject("https://oceanfacts.herokuapp.com/api/search/query/"+topic, Fact.class);
        return fact.value;
    }
}
