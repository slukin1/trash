package vu;

import android.os.Handler;
import android.os.Message;
import com.huobi.woodpecker.database.bean.RequestInfo;
import com.huobi.woodpecker.model.Config;
import com.huobi.woodpecker.net.UrlConfig;
import com.huobi.woodpecker.utils.DHUtil;
import com.huobi.woodpecker.utils.UtilCollections;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import kv.e;
import wu.c;

public class d implements Handler.Callback {

    /* renamed from: b  reason: collision with root package name */
    public Config f23409b;

    /* renamed from: c  reason: collision with root package name */
    public volatile boolean f23410c;

    public class a implements com.huobi.woodpecker.kalle.a<Boolean> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ List f23411a;

        public a(List list) {
            this.f23411a = list;
        }

        /* renamed from: b */
        public void a(Boolean bool) {
            e.k("WPUpload", "uploadData isSucceed=" + bool);
            if (bool.booleanValue()) {
                c.e().c(this.f23411a);
                boolean unused = d.this.f23410c = false;
                return;
            }
            boolean unused2 = d.this.f23410c = false;
            if (UrlConfig.d()) {
                d.this.q(0);
            }
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public static final d f23413a = new d((a) null);
    }

    public /* synthetic */ d(a aVar) {
        this();
    }

    public static d k() {
        return b.f23413a;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void p(boolean z11, Config config) {
        long j11;
        if (config != null) {
            e.c("WPUpload", "doLoadConfig:" + config.toString());
            UrlConfig.i(config.getUrl());
            UrlConfig.g(config.getUrlfilters());
            UrlConfig.h(config.getResHeaders());
            this.f23409b = config;
            if (config.isEnabled()) {
                if (z11) {
                    j11 = 0;
                } else {
                    j11 = config.getInterval();
                }
                q(j11);
            }
        }
    }

    public void d() {
        g.d().k(10001);
    }

    public void e() {
        g.d().k(10002);
    }

    public void f() {
        if (j(System.currentTimeMillis()) && !g.d().e(10002)) {
            g.d().l(10002);
        }
        if (o() && !g.d().e(10001)) {
            q(l());
        }
    }

    public final void g(boolean z11) {
        hv.a.a(com.huobi.woodpecker.b.k(), new c(this, z11));
    }

    public final long h() {
        Config config = this.f23409b;
        if (config != null) {
            return Math.max(config.getConfintervalMillis(), com.huobi.woodpecker.b.g());
        }
        return -1;
    }

    public boolean handleMessage(Message message) {
        int i11 = message.what;
        if (i11 == 10001) {
            q(l());
            r();
            return true;
        } else if (i11 != 10002) {
            return false;
        } else {
            d();
            g(false);
            return true;
        }
    }

    public final long i() {
        Config config = this.f23409b;
        if (config != null) {
            return config.getTm();
        }
        return 0;
    }

    public final boolean j(long j11) {
        return this.f23409b != null && j11 - i() > h();
    }

    public final long l() {
        Config config = this.f23409b;
        if (config != null) {
            return Math.max(config.getIntervalMillis(), com.huobi.woodpecker.b.h());
        }
        return -1;
    }

    public double m() {
        Config config = this.f23409b;
        return config != null ? config.getWebViewOptCoefficient() : com.huobi.woodpecker.b.i();
    }

    public void n() {
        d();
        g(true);
    }

    public boolean o() {
        Config config = this.f23409b;
        return config != null && config.isEnabled();
    }

    public final void q(long j11) {
        int i11 = (j11 > 0 ? 1 : (j11 == 0 ? 0 : -1));
        if (i11 == 0) {
            d();
            g.d().l(10001);
        } else if (i11 > 0) {
            if (g.d().e(10001)) {
                d();
            }
            g.d().n(10001, j11);
        }
    }

    public final void r() {
        if (!this.f23410c) {
            List<RequestInfo> f11 = c.e().f();
            if (!UtilCollections.a(f11)) {
                this.f23410c = true;
                StringBuilder sb2 = new StringBuilder("[");
                ArrayList arrayList = new ArrayList();
                for (RequestInfo next : f11) {
                    sb2.append(next.getRequestInfo());
                    sb2.append(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    arrayList.add(Long.valueOf(next.getId()));
                }
                sb2.deleteCharAt(sb2.length() - 1);
                sb2.append("]");
                hv.a.b(DHUtil.c(DHUtil.a(sb2.toString())), new a(arrayList));
            }
        }
    }

    public d() {
        this.f23409b = null;
        this.f23410c = false;
        g.d().j(this);
    }
}
