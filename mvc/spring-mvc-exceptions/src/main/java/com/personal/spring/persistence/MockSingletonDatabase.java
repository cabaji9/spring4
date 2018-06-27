package com.personal.spring.persistence;

import com.personal.spring.exception.DuplicateException;

import java.util.HashMap;

/**
 * Created by Hyun Woo Son on 1/24/18
 **/
public class MockSingletonDatabase {

    private static MockSingletonDatabase mockSingletonDatabase;

    private MockSingletonDatabase(){
        data = new HashMap<>();
    }

    private HashMap<String,Object> data;

    public static MockSingletonDatabase getInstance(){

        if(mockSingletonDatabase == null){
            mockSingletonDatabase = new MockSingletonDatabase();
        }
        return mockSingletonDatabase;
    }


    public void put(String label,Object object){
        if(data.containsKey(label)){
            throw new DuplicateException();
        }
        data.put(label,object);
    }

    public Object get(String label){
        return data.get(label);
    }




}
