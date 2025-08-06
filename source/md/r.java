package md;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.o;

public final /* synthetic */ class r implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.q f58195a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58196b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58197c;

    public /* synthetic */ r(a.q qVar, String str, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58195a = qVar;
        this.f58196b = str;
        this.f58197c = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58195a.n(this.f58196b, this.f58197c, view);
    }
}
