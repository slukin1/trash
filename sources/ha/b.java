package ha;

import com.hbg.lib.widgets.TopScrollData;
import com.hbg.lib.widgets.notice.TopScrollNoticeItemView2;

public final /* synthetic */ class b implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TopScrollNoticeItemView2 f54909b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TopScrollData f54910c;

    public /* synthetic */ b(TopScrollNoticeItemView2 topScrollNoticeItemView2, TopScrollData topScrollData) {
        this.f54909b = topScrollNoticeItemView2;
        this.f54910c = topScrollData;
    }

    public final void run() {
        this.f54909b.g(this.f54910c);
    }
}
