package pf;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.hbg.module.market.widget.viewhandler.MarketSearchResultViewHandler;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MarketSearchResultViewHandler f53021b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f53022c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ RelativeLayout f53023d;

    public /* synthetic */ c(MarketSearchResultViewHandler marketSearchResultViewHandler, ImageView imageView, RelativeLayout relativeLayout) {
        this.f53021b = marketSearchResultViewHandler;
        this.f53022c = imageView;
        this.f53023d = relativeLayout;
    }

    public final void onClick(View view) {
        this.f53021b.e(this.f53022c, this.f53023d, view);
    }
}
