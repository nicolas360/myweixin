package com.zhuc.myweixin.controller;

import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.Map;

/**
 * Created by ZHUC on 2015/5/26.
 */
public class DataSource {

    private static final Map<String, String> bindMap = Maps.newConcurrentMap();

    public static void addToBindMap(String openId, String name){
        bindMap.put(openId, name);
    }

    public static boolean isExistsInBindMap(String openId){
        if(StringUtils.isBlank(openId)){
            return false;
        }
        return bindMap.containsKey(openId);
    }

    public static void removeFromBindMap(String openId){
        bindMap.remove(openId);
    }
}
