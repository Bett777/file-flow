package com.jgc.common.utils;

import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * <Description> <br>
 *
 * @author wangzb<br>
 * @version 1.0<br>
 * @date 2020/04/19<br>
 */
public class ListCopyUtils extends BeanUtils {
    /**
     * 集合数据的拷贝
     * @param sources: 数据源类
     * @param target: 目标类::new(eg: UserVO::new)
     * @return
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target) {
        return copyListProperties(sources, target, null);
    }


    /**
     * 带回调函数的集合数据的拷贝（可自定义字段拷贝规则）
     * @param sources: 数据源类
     * @param target: 目标类::new(eg: UserVO::new)
     * @param callBack: 回调函数
     * @return <S,T> source and object
     */
    public static <S, T> List<T> copyListProperties(List<S> sources, Supplier<T> target, BeanCopyUtilCallBack<S, T> callBack) {
        List<T> list = new ArrayList<>(sources.size());
        for (S source : sources) {
            T t = target.get();
            copyProperties(source, t);
            list.add(t);
            if (callBack != null) {
                // 回调
                callBack.callBack(source, t);
            }
        }
        return list;
    }

    @FunctionalInterface
    public interface BeanCopyUtilCallBack<S, T> {
        /**
         * 定义默认回调方法
         * @param t object
         * @param s source
         */
        void callBack(S t, T s);
    }
}

