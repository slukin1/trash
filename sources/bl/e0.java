package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.bean.AssetPositionLevelData;
import com.huobi.finance.viewhandler.AssetPositionLevelItemViewHandler;

public final /* synthetic */ class e0 implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12569b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12570c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ AssetPositionLevelData f12571d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ Context f12572e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12573f;

    public /* synthetic */ e0(MotionLayout motionLayout, int i11, AssetPositionLevelData assetPositionLevelData, Context context, String str) {
        this.f12569b = motionLayout;
        this.f12570c = i11;
        this.f12571d = assetPositionLevelData;
        this.f12572e = context;
        this.f12573f = str;
    }

    public final void onClick(View view) {
        AssetPositionLevelItemViewHandler.j(this.f12569b, this.f12570c, this.f12571d, this.f12572e, this.f12573f, view);
    }
}
