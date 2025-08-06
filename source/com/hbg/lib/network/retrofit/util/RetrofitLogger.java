package com.hbg.lib.network.retrofit.util;

import com.hbg.lib.network.retrofit.websocket.bean.SocketReportBean;

public class RetrofitLogger {

    /* renamed from: a  reason: collision with root package name */
    public static b f70667a;

    public static class a implements b {
        public void a(String str, String str2) {
        }

        public void b(String str, Throwable th2) {
        }

        public void c(SocketReportBean socketReportBean) {
        }

        public void d(String str) {
        }

        public void e(String str) {
        }

        public void f(String str) {
            d(str);
        }
    }

    public interface b {
        void a(String str, String str2);

        void b(String str, Throwable th2);

        void c(SocketReportBean socketReportBean);

        void d(String str);

        void e(String str);

        void f(String str);
    }

    public static void a(String str) {
        b d11 = d();
        d11.d("hbg_network-->" + str);
    }

    public static void b(String str) {
        b d11 = d();
        d11.e("hbg_network-->" + str);
    }

    public static void c(String str, Throwable th2) {
        b d11 = d();
        d11.b("hbg_network-->" + str, th2);
    }

    public static b d() {
        if (f70667a == null) {
            f70667a = new a();
        }
        return f70667a;
    }

    public static void e(SocketReportBean socketReportBean) {
        d().c(socketReportBean);
    }

    public static void f(b bVar) {
        f70667a = bVar;
    }

    public static void g(String str) {
        b d11 = d();
        d11.f("hbg_network-->" + str);
    }

    public static void h(String str, String str2) {
        d().a(str, str2);
    }
}
