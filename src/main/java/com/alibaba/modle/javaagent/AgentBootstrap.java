package com.alibaba.modle.javaagent;

import java.lang.instrument.Instrumentation;

public class AgentBootstrap {

    private static final LoadState STATE = new LoadState();

    public static void premain(String agentOps, Instrumentation inst) {
        final boolean success = STATE.start();
        if (!success) {
            System.out.println("AgentBootstrap already start!");
            return;
        }

    }
}
