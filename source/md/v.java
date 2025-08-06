package md;

import android.graphics.Bitmap;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.n;

public final /* synthetic */ class v implements n {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.s f58205a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58206b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ int f58207c;

    public /* synthetic */ v(a.s sVar, TUIBarrageMsgEntity tUIBarrageMsgEntity, int i11) {
        this.f58205a = sVar;
        this.f58206b = tUIBarrageMsgEntity;
        this.f58207c = i11;
    }

    public final void a(Bitmap bitmap) {
        this.f58205a.k(this.f58206b, this.f58207c, bitmap);
    }
}
