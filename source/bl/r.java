package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.viewhandler.AssetPositionContractItemViewHandler;

public final /* synthetic */ class r implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractItemViewHandler f12711b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12712c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12713d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractData f12714e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12715f;

    public /* synthetic */ r(AssetPositionContractItemViewHandler assetPositionContractItemViewHandler, MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context) {
        this.f12711b = assetPositionContractItemViewHandler;
        this.f12712c = motionLayout;
        this.f12713d = i11;
        this.f12714e = assetPositionContractData;
        this.f12715f = context;
    }

    public final void onClick(View view) {
        this.f12711b.j(this.f12712c, this.f12713d, this.f12714e, this.f12715f, view);
    }
}
