package com.tencent.qcloud.tuikit.tuichat.classicui.page;

import android.os.Bundle;
import com.tencent.qcloud.tuicore.util.ToastUtil;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.ChatInfo;
import com.tencent.qcloud.tuikit.tuichat.presenter.C2CChatPresenter;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatUtils;

public class TUIC2CChatActivity extends TUIBaseChatActivity {
    private static final String TAG = "TUIC2CChatActivity";
    private TUIC2CChatFragment chatFragment;
    private C2CChatPresenter presenter;

    public void initChat(ChatInfo chatInfo) {
        String str = TAG;
        TUIChatLog.i(str, "inti chat " + chatInfo);
        if (!TUIChatUtils.isC2CChat(chatInfo.getType())) {
            TUIChatLog.e(str, "init C2C chat failed , chatInfo = " + chatInfo);
            ToastUtil.toastShortMessage("init c2c chat failed.");
        }
        this.chatFragment = new TUIC2CChatFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(TUIChatConstants.CHAT_INFO, chatInfo);
        this.chatFragment.setArguments(bundle);
        C2CChatPresenter c2CChatPresenter = new C2CChatPresenter();
        this.presenter = c2CChatPresenter;
        c2CChatPresenter.initListener();
        this.chatFragment.setPresenter(this.presenter);
        getSupportFragmentManager().q().t(R.id.empty_view, this.chatFragment).k();
    }
}
