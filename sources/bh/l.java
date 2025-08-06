package bh;

import android.app.Application;
import com.huobi.app.HuobiApplicationUtil;

public final /* synthetic */ class l implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Application f12386b;

    public /* synthetic */ l(Application application) {
        this.f12386b = application;
    }

    public final void run() {
        HuobiApplicationUtil.z(this.f12386b);
    }
}
