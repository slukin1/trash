package com.alibaba.fastjson.parser.deserializer;

import f2.a;
import g2.l;
import java.lang.reflect.Type;

public abstract class ContextObjectDeserializer implements l {
    public <T> T e(a aVar, Type type, Object obj) {
        return f(aVar, type, obj, (String) null, 0);
    }

    public abstract <T> T f(a aVar, Type type, Object obj, String str, int i11);
}
