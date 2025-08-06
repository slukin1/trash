package ef;

import android.view.View;
import androidx.lifecycle.LifecycleOwner;
import com.hbg.lib.network.hbg.core.bean.LiveBannerArr;
import com.hbg.lib.network.hbg.core.bean.LiveBannerData;
import com.hbg.lib.network.hbg.core.bean.LiveSquareBaseData;
import com.hbg.module.content.R$id;
import com.youth.banner.Banner;
import com.youth.banner.adapter.BannerImageAdapter;
import ef.b;

public final class a extends b {

    /* renamed from: b  reason: collision with root package name */
    public final View f28899b;

    /* renamed from: c  reason: collision with root package name */
    public final int f28900c;

    /* renamed from: d  reason: collision with root package name */
    public final LifecycleOwner f28901d;

    /* renamed from: e  reason: collision with root package name */
    public final Banner<LiveBannerData, BannerImageAdapter<LiveBannerData>> f28902e;

    public a(View view, int i11, LifecycleOwner lifecycleOwner) {
        super(view);
        this.f28899b = view;
        this.f28900c = i11;
        this.f28901d = lifecycleOwner;
        this.f28902e = (Banner) view.findViewById(R$id.banner);
    }

    public void b(LiveSquareBaseData liveSquareBaseData, int i11, b.a aVar) {
        super.b(liveSquareBaseData, i11, aVar);
        if (liveSquareBaseData instanceof LiveBannerArr) {
            LiveBannerArr liveBannerArr = (LiveBannerArr) liveSquareBaseData;
            if (!com.hbg.module.libkt.base.ext.b.w(liveBannerArr.getBanners())) {
                qc.b.b(this.f28902e, this.f28899b.getContext(), this.f28900c, this.f28901d, liveBannerArr.getBanners());
            }
        }
    }
}
