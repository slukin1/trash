package md;

import com.hbg.module.huobi.im.group.bean.HBTUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;

public final /* synthetic */ class k implements ChatPopMenuAction.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f58176a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58177b;

    /* renamed from: c  reason: collision with root package name */
    public final /* synthetic */ HBTUIBarrageMsgEntity f58178c;

    public /* synthetic */ k(a aVar, TUIBarrageMsgEntity tUIBarrageMsgEntity, HBTUIBarrageMsgEntity hBTUIBarrageMsgEntity) {
        this.f58176a = aVar;
        this.f58177b = tUIBarrageMsgEntity;
        this.f58178c = hBTUIBarrageMsgEntity;
    }

    public final void onClick() {
        this.f58176a.I(this.f58177b, this.f58178c);
    }
}
