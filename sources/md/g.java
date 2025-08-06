package md;

import android.app.Dialog;
import android.view.View;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageModel;

public final /* synthetic */ class g implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f58166b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f58167c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ boolean f58168d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageModel f58169e;

    public /* synthetic */ g(a aVar, Dialog dialog, boolean z11, TUIBarrageModel tUIBarrageModel) {
        this.f58166b = aVar;
        this.f58167c = dialog;
        this.f58168d = z11;
        this.f58169e = tUIBarrageModel;
    }

    public final void onClick(View view) {
        this.f58166b.N(this.f58167c, this.f58168d, this.f58169e, view);
    }
}
