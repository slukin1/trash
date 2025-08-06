package bb;

import android.view.View;
import com.hbg.lib.common.utils.ViewUtil;

public final /* synthetic */ class h implements Runnable {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ View f12331b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ boolean f12332c;

    public /* synthetic */ h(View view, boolean z11) {
        this.f12331b = view;
        this.f12332c = z11;
    }

    public final void run() {
        ViewUtil.m(this.f12331b, this.f12332c);
    }
}
