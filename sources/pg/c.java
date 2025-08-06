package pg;

import android.text.TextUtils;
import com.hbg.lib.network.hbg.core.bean.SubscribeAll;
import com.huobi.account.handler.SubscribeAllHandler;
import com.huobi.account.handler.SubscribeAllHeadHandler;
import s9.a;

public class c implements a {

    /* renamed from: b  reason: collision with root package name */
    public SubscribeAll.ListBean f47704b;

    /* renamed from: c  reason: collision with root package name */
    public long f47705c;

    /* renamed from: d  reason: collision with root package name */
    public String f47706d;

    /* renamed from: e  reason: collision with root package name */
    public String f47707e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f47708f;

    /* renamed from: g  reason: collision with root package name */
    public boolean f47709g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f47710h;

    public c(SubscribeAll.ListBean listBean) {
        this.f47704b = listBean;
    }

    public String a() {
        return this.f47704b.getAboutToBegin();
    }

    public String c() {
        if (!TextUtils.isEmpty(this.f47704b.getTitleMd())) {
            return this.f47704b.getTitleMd();
        }
        return this.f47704b.getTitle();
    }

    public long d() {
        return this.f47704b.getCountDown();
    }

    public long e() {
        return this.f47705c;
    }

    public String f() {
        return this.f47707e;
    }

    public String g() {
        return this.f47706d;
    }

    public String getViewHandlerName() {
        if (this.f47706d != null) {
            return SubscribeAllHeadHandler.class.getName();
        }
        return SubscribeAllHandler.class.getName();
    }

    public String h() {
        return this.f47704b.getName();
    }

    public String i() {
        return this.f47704b.getTitle();
    }

    public String j() {
        return this.f47704b.getUrl();
    }

    public boolean k() {
        return this.f47708f;
    }

    public boolean l() {
        return this.f47710h;
    }

    public boolean m() {
        return this.f47709g;
    }

    public void n(long j11) {
        this.f47705c = j11;
    }

    public void o(boolean z11) {
        this.f47708f = z11;
    }

    public void p(String str) {
        this.f47707e = str;
    }

    public void q(String str) {
        this.f47706d = str;
    }

    public void r(boolean z11) {
        this.f47710h = z11;
    }

    public void s(boolean z11) {
        this.f47709g = z11;
    }
}
