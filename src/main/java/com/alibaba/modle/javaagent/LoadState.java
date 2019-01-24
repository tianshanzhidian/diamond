package com.alibaba.modle.javaagent;

import java.util.concurrent.atomic.AtomicBoolean;

public class LoadState {
    private static final boolean STATE_NONE = false;
    private static final boolean STATE_STARTED = true;

    private final AtomicBoolean state = new AtomicBoolean(STATE_NONE);

    public boolean start() {
        return state.compareAndSet(STATE_NONE, STATE_STARTED);
    }
}
