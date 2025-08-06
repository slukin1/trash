package com.huobi.trade.helper;

import com.hbg.lib.core.network.rx.EasySubscriber;
import com.hbg.lib.core.util.RxJavaHelper;
import org.greenrobot.eventbus.EventBus;
import tg.r;
import u6.g;

public class m {

    /* renamed from: b  reason: collision with root package name */
    public static m f82061b = new m();

    /* renamed from: a  reason: collision with root package name */
    public boolean f82062a;

    public class a extends EasySubscriber<Boolean> {
        public a() {
        }

        /* renamed from: a */
        public void onNext(Boolean bool) {
            super.onNext(bool);
            if (m.this.f82062a != bool.booleanValue()) {
                boolean unused = m.this.f82062a = bool.booleanValue();
                EventBus.d().k(m.e());
            }
        }
    }

    public static m e() {
        return f82061b;
    }

    public boolean c() {
        return this.f82062a && r.x().F0();
    }

    public void d() {
        if (r.x().F0()) {
            x8.a.a().canUseIce().b().retry(3).compose(RxJavaHelper.t((g) null)).subscribe(new a());
        } else if (this.f82062a) {
            this.f82062a = false;
            EventBus.d().k(e());
        }
    }
}
