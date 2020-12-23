package com.github.aqiu202.lock.base;

/**
 * <pre>{@link LockValueThreadStrategy}</pre>
 *
 * @author aqiu 2020/12/21 13:08
 **/
public class LockValueThreadStrategy extends AbstractLockValueThreadStrategy {

    private final ThreadLocal<String> threadLocal = new ThreadLocal<>();

    @Override
    public ThreadLocal<String> getThreadLocal() {
        return this.threadLocal;
    }
}