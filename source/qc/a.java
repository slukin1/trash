package qc;

import android.content.Context;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.youth.banner.listener.OnBannerListener;

public final /* synthetic */ class a implements OnBannerListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ int f53326a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f53327b;

    public /* synthetic */ a(int i11, Context context) {
        this.f53326a = i11;
        this.f53327b = context;
    }

    public final void OnBannerClick(Object obj, int i11) {
        b.c(this.f53326a, this.f53327b, (LiveBannerData) obj, i11);
    }
}
