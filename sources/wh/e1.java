package wh;

import android.view.View;
import android.widget.ImageView;
import com.huobi.asset2.index.BaseAssetChildTabFragment;

public final /* synthetic */ class e1 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ BaseAssetChildTabFragment f61292b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ ImageView f61293c;

    public /* synthetic */ e1(BaseAssetChildTabFragment baseAssetChildTabFragment, ImageView imageView) {
        this.f61292b = baseAssetChildTabFragment;
        this.f61293c = imageView;
    }

    public final void onClick(View view) {
        this.f61292b.Mh(this.f61293c, view);
    }
}
