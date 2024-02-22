package org.apache.ibatis.util;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author ZhangHua
 * @date 2024/2/22 9:15
 */
public class LogUtil {

    private static AtomicInteger index = new AtomicInteger(1);

    public static void log(String log) {
        System.out.println(wrapper(String.valueOf(index)) + ">>>>>>>>" + log);
        index.incrementAndGet();
    }


    public static void log(Class clazz, String log) {
        log(wrapper(clazz.getSimpleName()) + log);
    }


    private static String wrapper(String content) {
        return "【" + content + "】";
    }
}
