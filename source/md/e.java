package md;

import android.app.Dialog;
import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import com.tencent.qcloud.tuikit.tuibarrage.model.TUIBarrageModel;

public final /* synthetic */ class e implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f58158b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f58159c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageModel f58160d;

    /* renamed from: e  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58161e;

    public /* synthetic */ e(a aVar, Dialog dialog, TUIBarrageModel tUIBarrageModel, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58158b = aVar;
        this.f58159c = dialog;
        this.f58160d = tUIBarrageModel;
        this.f58161e = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58158b.K(this.f58159c, this.f58160d, this.f58161e, view);
    }
}
