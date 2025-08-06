package bl;

import android.content.Context;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.huobi.finance.viewhandler.AssetPositionEarnItemViewHandler;
import vk.e;

public final /* synthetic */ class v implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Context f12759b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ MotionLayout f12760c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f12761d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ e f12762e;

    /* renamed from: f  reason: collision with root package name */
    public final /* synthetic */ String f12763f;

    public /* synthetic */ v(Context context, MotionLayout motionLayout, int i11, e eVar, String str) {
        this.f12759b = context;
        this.f12760c = motionLayout;
        this.f12761d = i11;
        this.f12762e = eVar;
        this.f12763f = str;
    }

    public final void onClick(View view) {
        AssetPositionEarnItemViewHandler.k(this.f12759b, this.f12760c, this.f12761d, this.f12762e, this.f12763f, view);
    }
}
