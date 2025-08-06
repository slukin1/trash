package fz;

import android.view.View;
import com.youth.banner.adapter.BannerAdapter;

public final /* synthetic */ class b implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BannerAdapter f54761b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Object f54762c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f54763d;

    public /* synthetic */ b(BannerAdapter bannerAdapter, Object obj, int i11) {
        this.f54761b = bannerAdapter;
        this.f54762c = obj;
        this.f54763d = i11;
    }

    public final void onClick(View view) {
        this.f54761b.lambda$onBindViewHolder$0(this.f54762c, this.f54763d, view);
    }
}
