package md;

import android.app.Dialog;
import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageModel;

public final /* synthetic */ class f implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f58162b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f58163c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageModel f58164d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58165e;

    public /* synthetic */ f(a aVar, Dialog dialog, TUIBarrageModel tUIBarrageModel, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58162b = aVar;
        this.f58163c = dialog;
        this.f58164d = tUIBarrageModel;
        this.f58165e = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58162b.M(this.f58163c, this.f58164d, this.f58165e, view);
    }
}
