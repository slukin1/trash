package bl;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.hbg.lib.widgets.adapter.recyclerview.EasyAssetRecyclerView;
import com.huobi.finance.viewhandler.AssetPositionRecyclerItemViewHandler;
import vk.i;

public final /* synthetic */ class r0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionRecyclerItemViewHandler f12716b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ i f12717c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ EasyAssetRecyclerView f12718d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12719e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ TextView f12720f;

    /* renamed from: g  reason: collision with root package name */
    public final /* synthetic */ ImageView f12721g;

    public /* synthetic */ r0(AssetPositionRecyclerItemViewHandler assetPositionRecyclerItemViewHandler, i iVar, EasyAssetRecyclerView easyAssetRecyclerView, Context context, TextView textView, ImageView imageView) {
        this.f12716b = assetPositionRecyclerItemViewHandler;
        this.f12717c = iVar;
        this.f12718d = easyAssetRecyclerView;
        this.f12719e = context;
        this.f12720f = textView;
        this.f12721g = imageView;
    }

    public final void onClick(View view) {
        this.f12716b.h(this.f12717c, this.f12718d, this.f12719e, this.f12720f, this.f12721g, view);
    }
}
