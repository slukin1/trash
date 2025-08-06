package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CustomLinkMessageBean;

public class CustomLinkMessageHolder extends MessageContentHolder {
    public static final String TAG = "CustomLinkMessageHolder";
    private TextView linkView;
    private TextView textView;

    public CustomLinkMessageHolder(View view) {
        super(view);
        this.textView = (TextView) view.findViewById(R.id.test_custom_message_tv);
        this.linkView = (TextView) view.findViewById(R.id.link_tv);
    }

    public int getVariableLayout() {
        return R.layout.test_custom_message_layout1;
    }

    public void layoutVariableViews(TUIMessageBean tUIMessageBean, int i11) {
        final String str;
        String str2 = "";
        if (tUIMessageBean instanceof CustomLinkMessageBean) {
            CustomLinkMessageBean customLinkMessageBean = (CustomLinkMessageBean) tUIMessageBean;
            str2 = customLinkMessageBean.getText();
            str = customLinkMessageBean.getLink();
        } else {
            str = str2;
        }
        if (!tUIMessageBean.isSelf()) {
            TextView textView2 = this.textView;
            textView2.setTextColor(textView2.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_other_custom_msg_text_color)));
            this.linkView.setTextColor(this.textView.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_other_custom_msg_link_color)));
        } else {
            TextView textView3 = this.textView;
            textView3.setTextColor(textView3.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_self_custom_msg_text_color)));
            this.linkView.setTextColor(this.textView.getResources().getColor(TUIThemeManager.getAttrResId(this.textView.getContext(), R.attr.chat_self_custom_msg_link_color)));
        }
        this.textView.setText(str2);
        this.msgContentFrame.setClickable(true);
        this.msgContentFrame.setOnClickListener(new View.OnClickListener() {
            @SensorsDataInstrumented
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction("android.intent.action.VIEW");
                intent.setData(Uri.parse(str));
                intent.addFlags(268435456);
                ServiceInitializer.getAppContext().startActivity(intent);
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
            }
        });
    }
}
