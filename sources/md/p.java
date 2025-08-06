package md;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.o;

public final /* synthetic */ class p implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.q f58189a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58190b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58191c;

    public /* synthetic */ p(a.q qVar, String str, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58189a = qVar;
        this.f58190b = str;
        this.f58191c = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58189a.k(this.f58190b, this.f58191c, view);
    }
}
