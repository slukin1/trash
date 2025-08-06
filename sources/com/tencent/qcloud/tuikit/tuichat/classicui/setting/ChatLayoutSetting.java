package com.tencent.qcloud.tuikit.tuichat.classicui.setting;

import android.content.Context;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.FrameLayout;
import com.google.gson.Gson;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.TUIChatConstants;
import com.tencent.qcloud.tuikit.tuichat.bean.CustomHelloMessage;
import com.tencent.qcloud.tuikit.tuichat.bean.InputMoreActionUnit;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.ChatView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.InputView;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.MessageRecyclerView;
import com.tencent.qcloud.tuikit.tuichat.config.TUIChatConfigs;
import com.tencent.qcloud.tuikit.tuichat.util.ChatMessageBuilder;
import java.util.Objects;

public class ChatLayoutSetting {
    private static final String TAG = "ChatLayoutSetting";
    private String groupId;
    private Context mContext;

    public ChatLayoutSetting(Context context) {
        this.mContext = context;
    }

    public void customizeChatLayout(ChatView chatView) {
        ViewGroup customNoticeLayout = TUIChatConfigs.getConfigs().getNoticeLayoutConfig().getCustomNoticeLayout();
        FrameLayout customView = chatView.getCustomView();
        if (customNoticeLayout != null && customView.getVisibility() == 8) {
            ViewParent parent = customNoticeLayout.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeAllViews();
            }
            customView.addView(customNoticeLayout);
            customView.setVisibility(0);
        }
        chatView.getMessageLayout();
        InputView inputLayout = chatView.getInputLayout();
        if (TUIChatConfigs.getConfigs().getGeneralConfig().isEnableWelcomeCustomMessage()) {
            AnonymousClass1 r12 = new InputMoreActionUnit() {
            };
            r12.setIconResId(R.drawable.custom);
            r12.setName(this.mContext.getString(R.string.test_custom_action));
            r12.setActionId(3);
            r12.setPriority(10);
            r12.setOnClickListener(new InputMoreActionUnit.OnActionClickListener(r12, chatView) {
                public final /* synthetic */ ChatView val$layout;

                {
                    this.val$layout = r3;
                    Objects.requireNonNull(r2);
                }

                public void onClick() {
                    Gson gson = new Gson();
                    CustomHelloMessage customHelloMessage = new CustomHelloMessage();
                    customHelloMessage.version = TUIChatConstants.version;
                    String json = gson.toJson((Object) customHelloMessage);
                    String str = customHelloMessage.text;
                    this.val$layout.sendMessage(ChatMessageBuilder.buildCustomMessage(json, str, str.getBytes()), false);
                }
            });
            inputLayout.addAction(r12);
        }
    }

    public void customizeMessageLayout(MessageRecyclerView messageRecyclerView) {
    }

    public void setGroupId(String str) {
        this.groupId = str;
    }
}
