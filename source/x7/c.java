package x7;

import com.hbg.lib.network.hbg.core.bean.EtpRebalInfo;
import rx.functions.Action1;

public final /* synthetic */ class c implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f61511b;

    public /* synthetic */ c(String str) {
        this.f61511b = str;
    }

    public final void call(Object obj) {
        d.f70552a.put(this.f61511b, (EtpRebalInfo) obj);
    }
}
