package com.hbg.lib.core;

public class GlobalAppConfig {

    /* renamed from: a  reason: collision with root package name */
    public static AppConfigImpl f68403a;

    public static class AppConfigImpl {

        /* renamed from: a  reason: collision with root package name */
        public boolean f68404a;

        /* renamed from: b  reason: collision with root package name */
        public String f68405b;

        /* renamed from: c  reason: collision with root package name */
        public int f68406c;

        /* renamed from: d  reason: collision with root package name */
        public String f68407d;

        /* renamed from: e  reason: collision with root package name */
        public String f68408e;

        public AppConfigImpl e(String str) {
            this.f68408e = str;
            return this;
        }

        public AppConfigImpl f(boolean z11) {
            this.f68404a = z11;
            return this;
        }

        public AppConfigImpl g(String str) {
            this.f68405b = str;
            return this;
        }

        public AppConfigImpl h(int i11) {
            this.f68406c = i11;
            return this;
        }

        public AppConfigImpl i(String str) {
            this.f68407d = str;
            return this;
        }
    }

    public static String a() {
        return f68403a.f68408e;
    }

    public static String b() {
        return f68403a.f68405b;
    }

    public static int c() {
        return f68403a.f68406c;
    }

    public static void d(AppConfigImpl appConfigImpl) {
        if (appConfigImpl != null) {
            f68403a = appConfigImpl;
        }
    }

    public static boolean e() {
        return f68403a.f68404a;
    }
}
