package com.amazonaws.logging;

import java.util.HashMap;
import java.util.Map;

public class LogFactory {

    /* renamed from: a  reason: collision with root package name */
    public static final String f14936a = "LogFactory";

    /* renamed from: b  reason: collision with root package name */
    public static final Map<String, Log> f14937b = new HashMap();

    /* renamed from: c  reason: collision with root package name */
    public static Level f14938c = null;

    public enum Level {
        ALL(Integer.MIN_VALUE),
        TRACE(0),
        DEBUG(1),
        INFO(2),
        WARN(3),
        ERROR(4),
        OFF(Integer.MAX_VALUE);
        
        private final int value;

        private Level(int i11) {
            this.value = i11;
        }

        public int getValue() {
            return this.value;
        }
    }

    public static Level a() {
        return f14938c;
    }

    public static synchronized Log b(Class<?> cls) {
        Log c11;
        synchronized (LogFactory.class) {
            c11 = c(d(cls.getSimpleName()));
        }
        return c11;
    }

    public static synchronized Log c(String str) {
        Log log;
        synchronized (LogFactory.class) {
            String d11 = d(str);
            Map<String, Log> map = f14937b;
            Log log2 = map.get(d11);
            if (log2 != null) {
                return log2;
            }
            if (Environment.a()) {
                log = new ConsoleLog(d11);
            } else {
                log = new AndroidLog(d11);
            }
            map.put(d11, log);
            return log;
        }
    }

    public static String d(String str) {
        if (str.length() <= 23) {
            return str;
        }
        c(f14936a).g("Truncating log tag length as it exceed 23, the limit imposed by Android on certain API Levels");
        return str.substring(0, 23);
    }
}
