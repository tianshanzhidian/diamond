package com.alibaba.modle.javaagent.impl;

import com.alibaba.modle.javaagent.interfaces.TranformerRegistry;
import org.apache.commons.lang.StringUtils;

import java.lang.instrument.ClassFileTransformer;
import java.util.HashMap;
import java.util.Map;

/*
* Transformer 注册器
* **/
public class DefaultTranformerRegistry implements TranformerRegistry {

    private final Map<String,ClassFileTransformer>  registry = new HashMap<String, ClassFileTransformer>(512);

    @Override
    public ClassFileTransformer findTransformer(String className) {
        return registry.get(className);
    }

    @Override
    public void addTransformer(String className, ClassFileTransformer classFileTransformer) {
        if(!StringUtils.isEmpty(className) && classFileTransformer != null){
            registry.put(className,classFileTransformer);
        }
    }
}
