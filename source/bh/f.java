package bh;

import com.huobi.app.AbstractCommonListActivity;
import java.util.List;

public final /* synthetic */ class f implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AbstractCommonListActivity f12381b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ List f12382c;

    public /* synthetic */ f(AbstractCommonListActivity abstractCommonListActivity, List list) {
        this.f12381b = abstractCommonListActivity;
        this.f12382c = list;
    }

    public final void run() {
        this.f12381b.wh(this.f12382c);
    }
}
