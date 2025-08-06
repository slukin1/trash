package md;

import android.graphics.Bitmap;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.n;

public final /* synthetic */ class o implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.q f58186a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58187b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58188c;

    public /* synthetic */ o(a.q qVar, TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11) {
        this.f58186a = qVar;
        this.f58187b = tUIBarrageMsgEntity;
        this.f58188c = i11;
    }

    public final void a(Bitmap bitmap) {
        this.f58186a.j(this.f58187b, this.f58188c, bitmap);
    }
}
