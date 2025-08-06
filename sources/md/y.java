package md;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.o;

public final /* synthetic */ class y implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.s f58214a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58215b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58216c;

    public /* synthetic */ y(a.s sVar, String str, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58214a = sVar;
        this.f58215b = str;
        this.f58216c = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58214a.n(this.f58215b, this.f58216c, view);
    }
}
