package com.ccy.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * Created by ccy on 2018/2/9.
 */
public class JsonUtil {

    public static String toJson(Object object) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.setPrettyPrinting();
        Gson gson = gsonBuilder.create();
        return gson.toJson(object);
    }
}
