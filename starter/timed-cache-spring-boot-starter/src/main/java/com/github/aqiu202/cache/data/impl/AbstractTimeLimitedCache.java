package com.github.aqiu202.cache.data.impl;

import com.github.aqiu202.cache.data.TimeLimitedCache;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nonnull;

public abstract class AbstractTimeLimitedCache<K, V> implements TimeLimitedCache<K, V> {

    protected long timeout = DEFAULT_EXPIRED;

    protected TimeUnit timeUnit = DEFAULT_TIME_UNIT;

    @Override
    public long getTimeout() {
        return timeout;
    }

    @Override
    public TimeUnit getTimeUnit() {
        return timeUnit;
    }

    @Override
    public void setTimeout(long timeout) {
        this.timeout = timeout;
    }

    @Override
    public void setTimeUnit(TimeUnit timeUnit) {
        this.timeUnit = timeUnit;
    }

    protected boolean inDefaultCache(long expired) {
        return expired <= 0;
    }

    protected long convertToSeconds(long expired, TimeUnit timeUnit) {
        return TimeUnit.SECONDS.convert(expired, timeUnit);
    }

    @Override
    public void set(@Nonnull K key, @Nonnull V value) {
        this.set(key, value, 0, DEFAULT_TIME_UNIT);
    }

    @Override
    public V get(@Nonnull K key) {
        return this.get(key, 0, DEFAULT_TIME_UNIT);
    }

    @Override
    public Boolean exists(@Nonnull K key) {
        return this.exists(key, 0, DEFAULT_TIME_UNIT);
    }

    @Override
    public Boolean delete(@Nonnull K key) {
        return this.delete(key, 0, DEFAULT_TIME_UNIT);
    }
}
