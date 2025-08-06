package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionContractData;
import com.huobi.finance.viewhandler.AssetPositionContractItemViewHandler;

public final /* synthetic */ class s implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractItemViewHandler f12725b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12726c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12727d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ AssetPositionContractData f12728e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12729f;

    public /* synthetic */ s(AssetPositionContractItemViewHandler assetPositionContractItemViewHandler, MotionLayout motionLayout, int i11, AssetPositionContractData assetPositionContractData, Context context) {
        this.f12725b = assetPositionContractItemViewHandler;
        this.f12726c = motionLayout;
        this.f12727d = i11;
        this.f12728e = assetPositionContractData;
        this.f12729f = context;
    }

    public final void onClick(View view) {
        this.f12725b.m(this.f12726c, this.f12727d, this.f12728e, this.f12729f, view);
    }
}
