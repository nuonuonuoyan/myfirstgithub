package com.yunsi;

import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;

public class ScopeTest {

    public void testFastJson(){
        JSONObject.toJSONString(new ArrayList<String>());
    }
}
