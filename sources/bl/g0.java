package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionLevelData;
import com.huobi.finance.viewhandler.AssetPositionLevelItemViewHandler;

public final /* synthetic */ class g0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12590b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12591c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionLevelData f12592d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12593e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12594f;

    public /* synthetic */ g0(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, Context context, String str) {
        this.f12590b = motionLayout;
        this.f12591c = i11;
        this.f12592d = assetPositionLevelData;
        this.f12593e = context;
        this.f12594f = str;
    }

    public final void onClick(View view) {
        AssetPositionLevelItemViewHandler.l(this.f12590b, this.f12591c, this.f12592d, this.f12593e, this.f12594f, view);
    }
}
