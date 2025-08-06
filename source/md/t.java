package md;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;

public final /* synthetic */ class t implements View.OnLongClickListener {

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ a.s f58200b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58201c;

    /* renamed from: d  reason: collision with root package name */
    public final /* synthetic */ int f58202d;

    public /* synthetic */ t(a.s sVar, TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11) {
        this.f58200b = sVar;
        this.f58201c = tUIBarrageMsgEntity;
        this.f58202d = i11;
    }

    public final boolean onLongClick(View view) {
        return this.f58200b.o(this.f58201c, this.f58202d, view);
    }
}
