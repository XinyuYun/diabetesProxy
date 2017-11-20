package com.nbicc.diabetes.utils;

import java.util.HashMap;

/**
 * Created by zhuolin on 2017/9/26.
 */
public class R extends HashMap<String, Object> {
    private static final long serialVersionUID = 1L;

    public R() {
        put("result_code", 0);
    }

    public static R error() {
        R r = new R();
        r.put("result_code", 1);
        return r;
    }

    public static R ok(Object data) {
        R r = new R();
        r.put("data",data);
        return r;
    }

    public static R ok() {
        return new R();
    }

    public R put(String key, Object value) {
        super.put(key, value);
        return this;
    }
}
