package fi;

import android.view.View;
import android.widget.ImageView;
import com.huobi.asset2.index.tabfragment.spot.AssetCollateralTabChildFragment;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetCollateralTabChildFragment f54519b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f54520c;

    public /* synthetic */ g(AssetCollateralTabChildFragment assetCollateralTabChildFragment, ImageView imageView) {
        this.f54519b = assetCollateralTabChildFragment;
        this.f54520c = imageView;
    }

    public final void onClick(View view) {
        this.f54519b.ki(this.f54520c, view);
    }
}
