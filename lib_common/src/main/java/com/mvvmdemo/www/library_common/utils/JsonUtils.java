package com.mvvmdemo.www.library_common.utils;

import com.google.gson.Gson;

/**
 * author:  zhouchaoxiang
 * date:    2018/11/1
 * explain:
 */
public class JsonUtils {
    public static <B> B toBean(String json, Class<B> bean) {
        return new Gson().fromJson(json, bean);
    }
}
