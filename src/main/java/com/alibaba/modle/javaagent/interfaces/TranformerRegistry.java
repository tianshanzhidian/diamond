package com.alibaba.modle.javaagent.interfaces;

import java.lang.instrument.ClassFileTransformer;

public interface TranformerRegistry {
    ClassFileTransformer findTransformer(String className);
    void addTransformer(String className,ClassFileTransformer classFileTransformer);
}
