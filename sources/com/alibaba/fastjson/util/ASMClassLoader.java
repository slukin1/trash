package com.alibaba.fastjson.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.JSONPath;
import com.alibaba.fastjson.JSONPathException;
import com.alibaba.fastjson.b;
import com.alibaba.fastjson.c;
import com.alibaba.fastjson.d;
import com.alibaba.fastjson.e;
import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.parser.JSONToken;
import com.alibaba.fastjson.parser.ParserConfig;
import com.alibaba.fastjson.serializer.AfterFilter;
import com.alibaba.fastjson.serializer.BeforeFilter;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.Labels;
import com.alibaba.fastjson.serializer.SerializeConfig;
import com.alibaba.fastjson.serializer.SerializeFilterable;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import f2.f;
import f2.g;
import h2.h;
import h2.i;
import h2.j;
import h2.k;
import h2.l;
import h2.m;
import h2.n;
import h2.o;
import h2.p;
import h2.q;
import java.security.AccessController;
import java.security.PrivilegedAction;
import java.security.ProtectionDomain;
import java.util.HashMap;
import java.util.Map;

public class ASMClassLoader extends ClassLoader {

    /* renamed from: a  reason: collision with root package name */
    public static ProtectionDomain f14380a = ((ProtectionDomain) AccessController.doPrivileged(new a()));

    /* renamed from: b  reason: collision with root package name */
    public static Map<String, Class<?>> f14381b = new HashMap();

    public static class a implements PrivilegedAction<Object> {
        public Object run() {
            return ASMClassLoader.class.getProtectionDomain();
        }
    }

    static {
        Class[] clsArr = {JSON.class, JSONObject.class, JSONArray.class, JSONPath.class, com.alibaba.fastjson.a.class, JSONException.class, JSONPathException.class, b.class, c.class, d.class, e.class, i2.a.class, TypeUtils.class, IOUtils.class, IdentityHashMap.class, i2.c.class, i2.b.class, k.class, h.class, SerializeFilterable.class, o.class, JSONSerializer.class, SerializeWriter.class, p.class, Labels.class, i.class, h2.e.class, AfterFilter.class, BeforeFilter.class, j.class, l.class, m.class, q.class, SerializerFeature.class, h2.d.class, n.class, SerializeConfig.class, g2.k.class, ParserConfig.class, f2.a.class, f2.b.class, f2.c.class, f.class, JSONToken.class, g.class, Feature.class, f2.e.class, f2.d.class, g2.c.class, g2.l.class, g2.g.class, g2.f.class, g2.h.class, h2.c.class, g2.i.class, g2.d.class};
        for (int i11 = 0; i11 < 56; i11++) {
            Class cls = clsArr[i11];
            f14381b.put(cls.getName(), cls);
        }
    }

    public ASMClassLoader() {
        super(b());
    }

    public static ClassLoader b() {
        Class<JSON> cls = JSON.class;
        ClassLoader contextClassLoader = Thread.currentThread().getContextClassLoader();
        if (contextClassLoader != null) {
            try {
                contextClassLoader.loadClass(cls.getName());
                return contextClassLoader;
            } catch (ClassNotFoundException unused) {
            }
        }
        return cls.getClassLoader();
    }

    public Class<?> a(String str, byte[] bArr, int i11, int i12) throws ClassFormatError {
        return defineClass(str, bArr, i11, i12, f14380a);
    }

    public boolean c(Class<?> cls) {
        ClassLoader classLoader = cls.getClassLoader();
        if (classLoader == null) {
            return false;
        }
        for (ClassLoader classLoader2 = this; classLoader2 != null; classLoader2 = classLoader2.getParent()) {
            if (classLoader2 == classLoader) {
                return false;
            }
        }
        return true;
    }

    public Class<?> loadClass(String str, boolean z11) throws ClassNotFoundException {
        Class<?> cls = f14381b.get(str);
        if (cls != null) {
            return cls;
        }
        try {
            return super.loadClass(str, z11);
        } catch (ClassNotFoundException e11) {
            throw e11;
        }
    }

    public ASMClassLoader(ClassLoader classLoader) {
        super(classLoader);
    }
}
