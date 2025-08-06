package iu;

import android.app.Application;
import android.content.Context;
import android.text.TextUtils;
import com.huobi.kalle.Kalle;
import com.huobi.kalle.connect.http.RedirectInterceptor;
import com.huobi.kalle.g;
import com.huobi.vulcan.core.ScreenStatusBroadcastReceiver;
import com.huobi.vulcan.core.WorkHandler;
import com.huobi.vulcan.net.CommonHeaderInterceptor;
import com.huobi.vulcan.net.UrlConfig;
import com.huobi.vulcan.utils.ExceptionLogUtil;
import com.huobi.vulcan.utils.FileUtils;
import com.huobi.vulcan.utils.LogUtils;
import im.e;
import im.f;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public Context f22821a;

    /* renamed from: b  reason: collision with root package name */
    public int f22822b;

    /* renamed from: c  reason: collision with root package name */
    public String f22823c;

    /* renamed from: iu.a$a  reason: collision with other inner class name */
    public class C0189a implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ int f22824b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Application f22825c;

        /* renamed from: iu.a$a$a  reason: collision with other inner class name */
        public class C0190a implements aq.a<String> {
            public C0190a() {
            }

            /* renamed from: b */
            public void a(String str) {
                if ("1".equals(str)) {
                    ScreenStatusBroadcastReceiver.a(a.this.f22821a);
                    lu.a.b(com.sumsub.sns.core.b.f30747a, "初始化设备指纹");
                    if (TextUtils.isEmpty(ku.b.e().h(a.this.f22821a))) {
                        ku.b.e().b(a.this.f22821a);
                    }
                    ju.a.o().r(C0189a.this.f22825c);
                    ku.c.q().A(0);
                    a.this.l();
                }
            }
        }

        public C0189a(int i11, Application application) {
            this.f22824b = i11;
            this.f22825c = application;
        }

        public void run() {
            mu.a.g(this.f22824b, new C0190a());
        }
    }

    public class b implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f22828b;

        /* renamed from: iu.a$b$a  reason: collision with other inner class name */
        public class C0191a implements aq.a<Boolean> {
            public C0191a() {
            }

            /* renamed from: b */
            public void a(Boolean bool) {
                if (!bool.booleanValue()) {
                    LogUtils.c(b.this.f22828b, ExceptionLogUtil.c());
                }
                FileUtils.d(ExceptionLogUtil.e());
                ku.b.e().a();
            }
        }

        public b(String str) {
            this.f22828b = str;
        }

        public void run() {
            mu.a.i(this.f22828b, new C0191a());
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public static final a f22831a = new a((C0189a) null);
    }

    public /* synthetic */ a(C0189a aVar) {
        this();
    }

    public static a f() {
        return c.f22831a;
    }

    public final g.b b(g.b bVar) {
        if (bVar == null) {
            bVar = g.q();
        }
        bVar.s(new mu.b(ku.a.b())).v(WorkHandler.d()).t(WorkHandler.d()).q(new RedirectInterceptor()).q(new CommonHeaderInterceptor()).q(new f(3)).q(new e("Vulcan_zp:::", false));
        if (ku.a.b() != null) {
            bVar.u(new hm.a(ku.a.b()));
        }
        return bVar;
    }

    public Context c() {
        return this.f22821a;
    }

    public Map<String, String> d(int i11) {
        if (k()) {
            try {
                return ku.c.q().s(i11);
            } catch (Exception e11) {
                lu.a.d(com.sumsub.sns.core.b.f30747a, e11.getMessage(), e11);
            }
        }
        return null;
    }

    public int e() {
        return this.f22822b;
    }

    public Map<String, String> g(int i11) {
        if (k()) {
            try {
                return ku.c.q().r(i11);
            } catch (Exception e11) {
                lu.a.d(com.sumsub.sns.core.b.f30747a, e11.getMessage(), e11);
            }
        }
        return null;
    }

    public String h() {
        return this.f22823c;
    }

    public void i(Application application, String str, int i11, String str2, boolean z11) {
        j(application, str, i11, str2, z11, (g.b) null);
    }

    public void j(Application application, String str, int i11, String str2, boolean z11, g.b bVar) {
        lu.a.g(z11);
        if (application == null) {
            lu.a.c(com.sumsub.sns.core.b.f30747a, "VulcanSDK initialize failed!!! app is null!");
        } else if (TextUtils.isEmpty(str)) {
            lu.a.c(com.sumsub.sns.core.b.f30747a, "VulcanSDK initialize failed!!! url is null!");
        } else {
            this.f22821a = application;
            UrlConfig.f(str);
            m(i11);
            n(str2);
            Kalle.d(b(bVar).r());
            WorkHandler.d().f(new C0189a(i11, application));
        }
    }

    public boolean k() {
        return this.f22821a != null;
    }

    public void l() {
        if (!ExceptionLogUtil.g()) {
            String h11 = ExceptionLogUtil.b() ? FileUtils.h(ExceptionLogUtil.e()) : "";
            if (!TextUtils.isEmpty(h11)) {
                FileUtils.d(ExceptionLogUtil.c());
                WorkHandler.d().f(new b(h11));
            }
        }
    }

    public final void m(int i11) {
        this.f22822b = i11;
    }

    public void n(String str) {
        this.f22823c = str;
    }

    public a() {
    }
}
