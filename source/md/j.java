package md;

import com.hbg.module.huobi.im.group.bean.TUIBarrageMsgEntity;
import com.hbg.module.huobi.im.group.ui.barrage.a;
import com.tencent.qcloud.tuikit.tuichat.classicui.interfaces.ChatPopMenuAction;

public final /* synthetic */ class j implements ChatPopMenuAction.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ a f58174a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ TUIBarrageMsgEntity f58175b;

    public /* synthetic */ j(a aVar, TUIBarrageMsgEntity tUIBarrageMsgEntity) {
        this.f58174a = aVar;
        this.f58175b = tUIBarrageMsgEntity;
    }

    public final void onClick() {
        this.f58174a.G(this.f58175b);
    }
}
