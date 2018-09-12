package cn.ck.androidframe.utils;

import java.util.List;

/**
 * List工具类
 *
 * Created by ck on 2018/9/13 0:45.
 */


public class ListUtils {

    /**
     * 判空
     * @param list
     * @return
     */
    public static boolean isEmpty(List<?> list){
        return list == null || list.isEmpty();
    }
}
