package bh;

import android.app.Application;
import com.huobi.app.HuobiApplicationUtil;

public final /* synthetic */ class k implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Application f12385b;

    public /* synthetic */ k(Application application) {
        this.f12385b = application;
    }

    public final void run() {
        HuobiApplicationUtil.k(this.f12385b);
    }
}
