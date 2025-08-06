package org.joda.time.tz;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ZoneInfoCompiler {

    /* renamed from: d  reason: collision with root package name */
    public static ThreadLocal<Boolean> f25408d = new a();

    /* renamed from: a  reason: collision with root package name */
    public Map<String, Object> f25409a = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    public List<Object> f25410b = new ArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f25411c = new ArrayList();

    public static class a extends ThreadLocal<Boolean> {
        /* renamed from: a */
        public Boolean initialValue() {
            return Boolean.FALSE;
        }
    }

    public static boolean a() {
        return f25408d.get().booleanValue();
    }
}
