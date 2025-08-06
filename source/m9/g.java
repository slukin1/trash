package m9;

import com.hbg.lib.network.swap.core.bean.SwapAllowLevel;
import rx.functions.Action1;

public final /* synthetic */ class g implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ i f58126b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ String f58127c;

    public /* synthetic */ g(i iVar, String str) {
        this.f58126b = iVar;
        this.f58127c = str;
    }

    public final void call(Object obj) {
        this.f58126b.g(this.f58127c, (SwapAllowLevel) obj);
    }
}
