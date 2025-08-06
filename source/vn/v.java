package vn;

import com.huobi.login.v3.ui.UserLoginActivityV4;
import java.util.HashMap;

public final /* synthetic */ class v implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ UserLoginActivityV4.j f61118b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HashMap f61119c;

    public /* synthetic */ v(UserLoginActivityV4.j jVar, HashMap hashMap) {
        this.f61118b = jVar;
        this.f61119c = hashMap;
    }

    public final void run() {
        this.f61118b.c(this.f61119c);
    }
}
