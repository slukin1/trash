package md;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.o;

public final /* synthetic */ class q implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.q f58192a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58193b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58194c;

    public /* synthetic */ q(a.q qVar, String str, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58192a = qVar;
        this.f58193b = str;
        this.f58194c = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58192a.o(this.f58193b, this.f58194c, view);
    }
}
