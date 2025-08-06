package bl;

import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.viewhandler.AssetPositionEarnItemViewHandler;
import vk.e;

public final /* synthetic */ class w implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12771b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f12772c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ e f12773d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ String f12774e;

    public /* synthetic */ w(MotionLayout motionLayout, int i11, e eVar, String str) {
        this.f12771b = motionLayout;
        this.f12772c = i11;
        this.f12773d = eVar;
        this.f12774e = str;
    }

    public final void onClick(View view) {
        AssetPositionEarnItemViewHandler.o(this.f12771b, this.f12772c, this.f12773d, this.f12774e, view);
    }
}
