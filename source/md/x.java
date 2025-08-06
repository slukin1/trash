package md;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.o;

public final /* synthetic */ class x implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.s f58211a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58212b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58213c;

    public /* synthetic */ x(a.s sVar, String str, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58211a = sVar;
        this.f58212b = str;
        this.f58213c = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58211a.l(this.f58212b, this.f58213c, view);
    }
}
