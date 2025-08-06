package bl;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.viewhandler.AssetPositionEarnItemViewHandler;
import vk.e;

public final /* synthetic */ class x implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12780b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12781c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f12782d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f12783e;

    public /* synthetic */ x(MotionLayout motionLayout, int i11, e eVar, String str) {
        this.f12780b = motionLayout;
        this.f12781c = i11;
        this.f12782d = eVar;
        this.f12783e = str;
    }

    public final void onClick(View view) {
        AssetPositionEarnItemViewHandler.l(this.f12780b, this.f12781c, this.f12782d, this.f12783e, view);
    }
}
