package md;

import android.app.Dialog;
import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;

public final /* synthetic */ class d implements View.OnClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a f58155b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ Dialog f58156c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58157d;

    public /* synthetic */ d(a aVar, Dialog dialog, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58155b = aVar;
        this.f58156c = dialog;
        this.f58157d = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58155b.J(this.f58156c, this.f58157d, view);
    }
}
