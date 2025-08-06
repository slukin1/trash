package md;

import android.graphics.Bitmap;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;

public final /* synthetic */ class n implements rd.n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.q f58183a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58184b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58185c;

    public /* synthetic */ n(a.q qVar, TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11) {
        this.f58183a = qVar;
        this.f58184b = tUIBarrageMsgEntity;
        this.f58185c = i11;
    }

    public final void a(Bitmap bitmap) {
        this.f58183a.m(this.f58184b, this.f58185c, bitmap);
    }
}
