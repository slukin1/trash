package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionLevelData;
import com.huobi.finance.viewhandler.AssetPositionLevelItemViewHandler;

public final /* synthetic */ class f0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12578b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12579c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionLevelData f12580d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12581e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12582f;

    public /* synthetic */ f0(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, Context context, String str) {
        this.f12578b = motionLayout;
        this.f12579c = i11;
        this.f12580d = assetPositionLevelData;
        this.f12581e = context;
        this.f12582f = str;
    }

    public final void onClick(View view) {
        AssetPositionLevelItemViewHandler.k(this.f12578b, this.f12579c, this.f12580d, this.f12581e, this.f12582f, view);
    }
}
