package com.daidai.tools;

import java.math.BigDecimal;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具方法
 * @author daidai
 */
public class RandomUtils {

    /**
     * 默认随机BigDecimal精度取舍为截断模式
     */
    private static final int DEFAULT_BIGDECIMAL_SCALA = BigDecimal.ROUND_DOWN;

    /**
     * 获取ThreadLocalRandom实例对象
     * @return the current thread's {@code ThreadLocalRandom}
     */
    private static ThreadLocalRandom getRandomCreator() {
        return ThreadLocalRandom.current();
    }

    /**
     * 获取[0,bound)的随机整数
     * @param bound 上限
     * @return
     */
    public static int getRandomInt(int bound) {
        return getRandomInt(0,bound);
    }

    /**
     * 获取[origin,bound)的随机整数
     * @param origin 下限
     * @param bound 上限(不包含)
     * @return
     */
    public static int getRandomInt(int origin, int bound) {
        return getRandomCreator().nextInt(origin, bound);
    }

    /**
     * 获取[0,bound)的随机长整型
     * @param bound 上限
     * @return
     */
    public static long getRandomLong(long bound) {
        return getRandomLong(0,bound);
    }

    /**
     * 获取[origin,bound)的随机长整型
     * @param origin 下限
     * @param bound 上限(不包含)
     * @return
     */
    public static long getRandomLong(long origin, long bound) {
        return getRandomCreator().nextLong(origin, bound);
    }

    /**
     * 获取[0,bound)的随机BigDecimal
     * @param bound 上限(不包含)
     * @param scala 精度
     * @return
     */
    public static BigDecimal getRandomBigDecimal(int bound, int scala) {
        return getRandomBigDecimal(new BigDecimal(bound), scala);
    }

    /**
     * 获取[0,bound)的随机BigDecimal
     * @param bound 上限(不包含)
     * @param scala 精度
     * @return
     */
    public static BigDecimal getRandomBigDecimal(String bound, int scala) {
        return getRandomBigDecimal(new BigDecimal(bound), scala);
    }

    /**
     * 获取[0,bound)的随机BigDecimal
     * @param bound 上限(不包含)
     * @param scala 精度
     * @return
     */
    public static BigDecimal getRandomBigDecimal(BigDecimal bound, int scala) {
        return getRandomBigDecimal(BigDecimal.ZERO, bound, scala);
    }

    /**
     * 获取[origin,bound)的随机BigDecimal
     * @param origin 下限
     * @param bound 上限(不包含)
     * @param scala 精度
     * @return
     */
    public static BigDecimal getRandomBigDecimal(String origin, String bound, int scala) {
        return getRandomBigDecimal(new BigDecimal(origin), new BigDecimal(bound), scala);
    }

    /**
     * 获取[origin,bound)的随机BigDecimal
     * @param origin 下限
     * @param bound 上限(不包含)
     * @param scala 精度
     * @return
     */
    public static BigDecimal getRandomBigDecimal(int origin, int bound, int scala) {
        return getRandomBigDecimal(new BigDecimal(origin), new BigDecimal(bound), scala);
    }

    /**
     * 获取[origin,bound)的随机BigDecimal
     * @param origin 下限
     * @param bound 上限(不包含)
     * @param scala 精度
     * @return
     */
    public static BigDecimal getRandomBigDecimal(BigDecimal origin, BigDecimal bound, int scala) {
        return new BigDecimal(getRandomCreator()
                .nextDouble(origin.doubleValue(), bound.doubleValue()))
                .setScale(scala, DEFAULT_BIGDECIMAL_SCALA);
    }

    /**
     * 随机取出列表中的一个值返回
     * @param origin 原始列表
     * @return
     */
    public static <T> T getRandomElementFromList(List<T> origin) {
        if(null == origin || origin.isEmpty()) {
            return null;
        }
        return origin.size() == 1 ? origin.get(0) : origin.get(getRandomInt(origin.size()));
    }

    /**
     * 随机取出Array中的一个值返回
     * @param origin 原始列表
     * @return
     */
    public static <T> T getRandomElementFromList(T[] origin) {
        if(null == origin || origin.length <= 0) {
            return null;
        }
        return origin.length == 1 ? origin[0] : origin[getRandomInt(origin.length)];
    }

    /**
     * 随机取出String中的一个值返回
     * @param origin 原始字符串
     * @return
     */
    public static String getRandomElementFromString(String origin) {
        if(null == origin) {
            return null;
        }
        return origin.length() == 1 ? origin : String.valueOf(origin.charAt(getRandomInt(origin.length())));
    }


}
