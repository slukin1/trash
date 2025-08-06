package md;

import android.view.View;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import rd.o;

public final /* synthetic */ class w implements o {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a.s f58208a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ String f58209b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58210c;

    public /* synthetic */ w(a.s sVar, String str, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58208a = sVar;
        this.f58209b = str;
        this.f58210c = tUIBarrageMsgEntity;
    }

    public final void onClick(View view) {
        this.f58208a.m(this.f58209b, this.f58210c, view);
    }
}
