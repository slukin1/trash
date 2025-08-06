package zendesk.belvedere;

import android.util.Log;

public class h {

    /* renamed from: a  reason: collision with root package name */
    public static b f62332a = new a();

    public interface b {
        void a(boolean z11);

        void d(String str, String str2);

        void e(String str, String str2);

        void e(String str, String str2, Throwable th2);

        void w(String str, String str2);
    }

    public static void a(String str, String str2) {
        f62332a.d(str, str2);
    }

    public static void b(String str, String str2) {
        f62332a.e(str, str2);
    }

    public static void c(String str, String str2, Throwable th2) {
        f62332a.e(str, str2, th2);
    }

    public static void d(b bVar) {
        f62332a = bVar;
    }

    public static void e(String str, String str2) {
        f62332a.w(str, str2);
    }

    public static class a implements b {

        /* renamed from: a  reason: collision with root package name */
        public boolean f62333a = false;

        public void a(boolean z11) {
            this.f62333a = z11;
        }

        public void d(String str, String str2) {
            if (this.f62333a) {
                Log.d(str, str2);
            }
        }

        public void e(String str, String str2) {
            if (this.f62333a) {
                Log.e(str, str2);
            }
        }

        public void w(String str, String str2) {
            if (this.f62333a) {
                Log.w(str, str2);
            }
        }

        public void e(String str, String str2, Throwable th2) {
            if (this.f62333a) {
                Log.e(str, str2, th2);
            }
        }
    }
}
