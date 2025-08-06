package md;

import android.app.Dialog;
import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;

public final /* synthetic */ class c implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f58152b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f58153c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58154d;

    public /* synthetic */ c(a aVar, Dialog dialog, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58152b = aVar;
        this.f58153c = dialog;
        this.f58154d = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58152b.L(this.f58153c, this.f58154d, view);
    }
}
