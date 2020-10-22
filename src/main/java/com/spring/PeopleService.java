package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PeopleService {

    @Autowired
    private People people;

    public void savePeople(){
        System.out.println("保存people" + people);
    }
}
