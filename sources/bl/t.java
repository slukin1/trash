package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.viewhandler.AssetPositionContractItemViewHandler;

public final /* synthetic */ class t implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractItemViewHandler f12734b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12735c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12736d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractData f12737e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12738f;

    public /* synthetic */ t(AssetPositionContractItemViewHandler assetPositionContractItemViewHandler, MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context) {
        this.f12734b = assetPositionContractItemViewHandler;
        this.f12735c = motionLayout;
        this.f12736d = i11;
        this.f12737e = assetPositionContractData;
        this.f12738f = context;
    }

    public final void onClick(View view) {
        this.f12734b.l(this.f12735c, this.f12736d, this.f12737e, this.f12738f, view);
    }
}
