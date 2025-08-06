package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.viewhandler.AssetPositionEarnItemViewHandler;
import vk.e;

public final /* synthetic */ class z implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ AssetPositionEarnItemViewHandler f12801b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12802c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12803d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e f12804e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ Context f12805f;

    public /* synthetic */ z(AssetPositionEarnItemViewHandler assetPositionEarnItemViewHandler, MotionLayout motionLayout, int i11, e eVar, Context context) {
        this.f12801b = assetPositionEarnItemViewHandler;
        this.f12802c = motionLayout;
        this.f12803d = i11;
        this.f12804e = eVar;
        this.f12805f = context;
    }

    public final void onClick(View view) {
        this.f12801b.n(this.f12802c, this.f12803d, this.f12804e, this.f12805f, view);
    }
}
