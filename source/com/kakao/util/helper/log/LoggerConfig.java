package com.kakao.util.helper.log;

import java.util.HashSet;
import java.util.Locale;
import java.util.Set;

public class LoggerConfig {

    /* renamed from: a  reason: collision with root package name */
    public int f25156a;

    /* renamed from: b  reason: collision with root package name */
    public Tag f25157b;

    /* renamed from: c  reason: collision with root package name */
    public String f25158c;

    /* renamed from: d  reason: collision with root package name */
    public Set<String> f25159d;

    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public int f25160a = 0;

        /* renamed from: b  reason: collision with root package name */
        public Tag f25161b = Tag.DEFAULT;

        /* renamed from: c  reason: collision with root package name */
        public String f25162c;

        /* renamed from: d  reason: collision with root package name */
        public Set<String> f25163d = new HashSet();

        public LoggerConfig a() {
            LoggerConfig loggerConfig = new LoggerConfig();
            Tag unused = loggerConfig.f25157b = this.f25161b;
            int unused2 = loggerConfig.f25156a = this.f25160a;
            String unused3 = loggerConfig.f25158c = this.f25162c;
            Set unused4 = loggerConfig.f25159d = this.f25163d;
            return loggerConfig;
        }

        public Builder b(Tag tag) {
            this.f25161b = tag;
            return this;
        }

        public Builder c(Set<String> set) {
            if (set == null) {
                return this;
            }
            this.f25163d = set;
            return this;
        }

        public Builder d(int i11) {
            this.f25160a = i11;
            return this;
        }

        public Builder e(String str) {
            this.f25162c = str;
            return this;
        }
    }

    public Tag e() {
        return this.f25157b;
    }

    public String f(boolean z11, String str) {
        return z11 ? g(str) : str;
    }

    public final String g(String str) {
        String h11 = h();
        Object[] objArr = new Object[2];
        if (h11 == null) {
            h11 = "";
        }
        objArr[0] = h11;
        objArr[1] = str;
        return String.format("%s %s", objArr);
    }

    public final String h() {
        return i(Thread.currentThread().getStackTrace());
    }

    public final String i(StackTraceElement[] stackTraceElementArr) {
        StackTraceElement stackTraceElement;
        String str;
        String canonicalName = getClass().getCanonicalName();
        int length = stackTraceElementArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                stackTraceElement = null;
                break;
            }
            stackTraceElement = stackTraceElementArr[i11];
            String className = stackTraceElement.getClassName();
            if (!this.f25159d.contains(className) && !className.startsWith(canonicalName) && ((str = this.f25158c) == null || className.startsWith(str))) {
                break;
            }
            i11++;
        }
        if (stackTraceElement == null) {
            return null;
        }
        return String.format(Locale.getDefault(), "[%s:%s():%d]", new Object[]{stackTraceElement.getFileName(), stackTraceElement.getMethodName(), Integer.valueOf(stackTraceElement.getLineNumber())});
    }

    public boolean j(int i11) {
        return i11 >= this.f25156a;
    }
}
