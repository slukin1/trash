package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.viewhandler.AssetPositionContractItemViewHandler;

public final /* synthetic */ class q implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractItemViewHandler f12702b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12703c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12704d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractData f12705e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12706f;

    public /* synthetic */ q(AssetPositionContractItemViewHandler assetPositionContractItemViewHandler, MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context) {
        this.f12702b = assetPositionContractItemViewHandler;
        this.f12703c = motionLayout;
        this.f12704d = i11;
        this.f12705e = assetPositionContractData;
        this.f12706f = context;
    }

    public final void onClick(View view) {
        this.f12702b.k(this.f12703c, this.f12704d, this.f12705e, this.f12706f, view);
    }
}
