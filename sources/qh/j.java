package qh;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.huobi.asset.feature.summary.AssetSummaryFragment;
import rx.functions.Action1;

public final /* synthetic */ class j implements Action1 {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetSummaryFragment f53351b;

    public /* synthetic */ j(AssetSummaryFragment assetSummaryFragment) {
        this.f53351b = assetSummaryFragment;
    }

    public final void call(Object obj) {
        this.f53351b.Yh((APIStatusErrorException) obj);
    }
}
