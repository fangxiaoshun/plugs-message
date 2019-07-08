package com.shsc.plug.util;

import java.util.HashMap;
import java.util.Map;

/**
 * @author fangxs
 * @className ThreadLocalUtils
 * @date 2019/6/22 14:49
 * @description ThreadLocal工具类
 **/
public class ThreadLocalUtils {

    private static final ThreadLocal<Map<String, Object>> LOCAL_THREAD = ThreadLocal.withInitial(HashMap::new);

    public static <T> T put(String key, T value) {
        LOCAL_THREAD.get().put(key, value);
        return value;
    }

    public static void remove(String key) {
        LOCAL_THREAD.get().remove(key);
    }

    public static void clear() {
        LOCAL_THREAD.remove();
    }

    @SuppressWarnings("unchecked")
    public static <T> T get(String key) {
        return ((T) LOCAL_THREAD.get().get(key));
    }
}
