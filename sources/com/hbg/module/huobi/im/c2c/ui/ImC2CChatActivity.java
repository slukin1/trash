package com.hbg.module.huobi.im.c2c.ui;

import android.os.Bundle;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.hbg.module.huobi.im.c2c.C2CChatManager;
import com.hbg.module.huobi.im.group.ui.chat.ImBaseChatActivity;
import com.tencent.qcloud.tuicore.TUIConstants;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;
import dd.b;

@Route(path = "/im/chat")
public class ImC2CChatActivity extends ImBaseChatActivity {

    /* renamed from: d  reason: collision with root package name */
    public static final String f19653d = "ImC2CChatActivity";

    /* renamed from: b  reason: collision with root package name */
    public ImC2CChatFragment f19654b;

    /* renamed from: c  reason: collision with root package name */
    public C2CChatManager f19655c;

    public void initChat(ChatInfo chatInfo) {
        Bundle bundle = new Bundle();
        if (getIntent() != null) {
            String stringExtra = getIntent().getStringExtra("chatId");
            String stringExtra2 = getIntent().getStringExtra(TUIConstants.TUIChat.CHAT_TYPE);
            String stringExtra3 = getIntent().getStringExtra("messageId");
            if ("2".equals(stringExtra2)) {
                b.f22740a.j(this, stringExtra, (String) null, stringExtra3);
                finish();
                return;
            }
            bundle.putString("chatId", stringExtra);
        }
        String str = f19653d;
        TUIChatLog.i(str, "inti chat " + chatInfo);
        if (!TUIChatUtils.isC2CChat(chatInfo.getType())) {
            TUIChatLog.e(str, "init C2C chat failed , chatInfo = " + chatInfo);
            ToastUtil.toastShortMessage("init c2c chat failed.");
        }
        this.f19654b = new ImC2CChatFragment();
        bundle.putSerializable(TUIChatConstants.CHAT_INFO, chatInfo);
        this.f19654b.setArguments(bundle);
        C2CChatManager c2CChatManager = new C2CChatManager();
        this.f19655c = c2CChatManager;
        c2CChatManager.initListener();
        this.f19654b.gi(this.f19655c);
        getSupportFragmentManager().q().t(R.id.empty_view, this.f19654b).k();
    }
}
