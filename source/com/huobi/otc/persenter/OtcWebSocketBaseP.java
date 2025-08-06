package com.huobi.otc.persenter;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import androidx.annotation.Keep;
import com.hbg.lib.network.otc.core.bean.BaseSettingBean;
import com.hbg.lib.network.otc.core.bean.OtcTokenUpdate;
import com.hbg.module.otc.OtcModuleConfig;
import i6.d;
import java.util.List;
import k20.h;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.ThreadMode;
import qp.v;
import up.x;

public abstract class OtcWebSocketBaseP {

    /* renamed from: a  reason: collision with root package name */
    public Handler f79156a;

    /* renamed from: b  reason: collision with root package name */
    public x.g f79157b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f79158c = true;

    /* renamed from: d  reason: collision with root package name */
    public boolean f79159d = true;

    /* renamed from: e  reason: collision with root package name */
    public boolean f79160e;

    /* renamed from: f  reason: collision with root package name */
    public boolean f79161f;

    public class a implements x.g {

        /* renamed from: a  reason: collision with root package name */
        public boolean f79162a = false;

        public a() {
        }

        public void a() {
            this.f79162a = false;
            OtcWebSocketBaseP.this.o(false);
        }

        public void b() {
            if (!this.f79162a) {
                this.f79162a = true;
                OtcWebSocketBaseP.this.n(5000);
            }
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ boolean f(Message message) {
        b().run();
        return false;
    }

    public abstract Runnable b();

    public abstract x.f c();

    public abstract List<String> d();

    public x.g e() {
        if (this.f79157b == null) {
            this.f79157b = new a();
        }
        return this.f79157b;
    }

    public void g() {
        if (!this.f79161f || !p()) {
            n(5000);
        }
    }

    public void h() {
        List<String> d11;
        if (EventBus.d().i(this)) {
            EventBus.d().r(this);
        }
        o(true);
        if (this.f79158c && (d11 = d()) != null && !d11.isEmpty()) {
            for (String r11 : d11) {
                x.j().r(r11, c());
            }
        }
    }

    public void i() {
        o(true);
        d.j("asdffsfsd", "PSocketKeeper onPause... ");
    }

    public void j() {
        if (!this.f79159d || OtcModuleConfig.a().a()) {
            n(0);
            d.j("asdffsfsd", "PSocketKeeper onResume... ");
        }
    }

    public void k() {
        if (!EventBus.d().i(this)) {
            EventBus.d().p(this);
        }
    }

    public void l() {
    }

    public void m(boolean z11) {
        this.f79158c = z11;
    }

    public void n(long j11) {
        o(true);
        if (!this.f79160e) {
            Handler handler = new Handler(Looper.getMainLooper(), new v(this));
            this.f79156a = handler;
            handler.sendEmptyMessageDelayed(0, j11);
        }
    }

    public void o(boolean z11) {
        List<String> d11;
        Handler handler = this.f79156a;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.f79156a = null;
        }
        if (z11 && this.f79158c && x.j().l() && (d11 = d()) != null && !d11.isEmpty()) {
            for (String r11 : d11) {
                x.j().r(r11, c());
            }
        }
    }

    @h(threadMode = ThreadMode.MAIN)
    @Keep
    public void onOtcTokenUpdate(OtcTokenUpdate otcTokenUpdate) {
        boolean a11 = OtcModuleConfig.a().a();
        boolean isEmpty = TextUtils.isEmpty(OtcModuleConfig.a().c());
        if (isEmpty || !a11) {
            l();
        }
        if (!this.f79159d) {
            o(true);
            n(5000);
        } else if (isEmpty) {
            o(true);
        } else if (a11) {
            n(5000);
        }
    }

    public boolean p() {
        BaseSettingBean g11;
        if (this.f79158c && (g11 = qu.d.i().g()) != null && "1".equals(g11.getChatWsSwitch())) {
            List<String> d11 = d();
            if (d11 != null && !d11.isEmpty()) {
                for (String p11 : d11) {
                    x.j().p(p11, c(), e());
                }
            }
            if (x.j().l()) {
                return true;
            }
        }
        return false;
    }
}
