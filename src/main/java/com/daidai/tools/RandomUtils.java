package com.daidai.tools;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具方法
 * @author daidai
 */
public class RandomUtils {

    /**
     * 获取ThreadLocalRandom实例对象
     * @return the current thread's {@code ThreadLocalRandom}
     */
    private static ThreadLocalRandom getRandomCreator() {
        return ThreadLocalRandom.current();
    }

    /**
     * 获取[0,bound]的随机整数
     * @param bound 上限
     * @return
     */
    public static int getRandomInt(int bound) {
        return getRandomInt(0,bound);
    }

    /**
     * 获取[origin,bound]的随机整数
     * @param origin 下限
     * @param bound 上限
     * @return
     */
    public static int getRandomInt(int origin, int bound) {
        return getRandomCreator().nextInt(origin, bound + 1);
    }


}
