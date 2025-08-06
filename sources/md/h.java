package md;

import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;

public final /* synthetic */ class h implements ChatPopMenuAction.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f58170a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58171b;

    public /* synthetic */ h(a aVar, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58170a = aVar;
        this.f58171b = tUIBarrageMsgEntity;
    }

    public final void onClick() {
        this.f58170a.F(this.f58171b);
    }
}
