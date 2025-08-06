package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.ChatFlowReactView;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.MessageContentHolder;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.MergeMessageBean;
import java.util.List;

public class MergeMessageHolder extends MessageContentHolder {
    private LinearLayout mForwardMsgLayout;
    private TextView msgForwardContent;
    private TextView msgForwardTitle;

    public MergeMessageHolder(View view) {
        super(view);
        this.mForwardMsgLayout = (LinearLayout) view.findViewById(R.id.forward_msg_layout);
        this.msgForwardTitle = (TextView) view.findViewById(R.id.msg_forward_title);
        this.msgForwardContent = (TextView) view.findViewById(R.id.msg_forward_content);
        this.mForwardMsgLayout.setClickable(true);
    }

    public int getVariableLayout() {
        return R.layout.forward_msg_holder;
    }

    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i11) {
        if (tUIMessageBean != null) {
            ChatFlowReactView chatFlowReactView = this.reactView;
            chatFlowReactView.setThemeColorId(TUIThemeManager.getAttrResId(chatFlowReactView.getContext(), com.tencent.qcloud.tuikit.timcommon.R.attr.chat_react_other_text_color));
            if (this.isForwardMode || this.isReplyDetailMode) {
                this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
                this.statusImage.setVisibility(8);
            } else if (tUIMessageBean.isSelf()) {
                if (this.properties.getRightBubble() == null || this.properties.getRightBubble().getConstantState() == null) {
                    this.msgArea.setBackgroundResource(R.drawable.chat_bubble_self_cavity_bg);
                } else {
                    this.msgArea.setBackground(this.properties.getRightBubble().getConstantState().newDrawable());
                }
            } else if (this.properties.getLeftBubble() == null || this.properties.getLeftBubble().getConstantState() == null) {
                this.msgArea.setBackgroundResource(R.drawable.chat_bubble_other_cavity_bg);
            } else {
                this.msgArea.setBackground(this.properties.getLeftBubble().getConstantState().newDrawable());
            }
            final MergeMessageBean mergeMessageBean = (MergeMessageBean) tUIMessageBean;
            String title = mergeMessageBean.getTitle();
            List<String> abstractList = mergeMessageBean.getAbstractList();
            this.msgForwardTitle.setText(title);
            String str = "";
            for (int i12 = 0; i12 < abstractList.size(); i12++) {
                if (i12 > 0) {
                    str = str + "\n";
                }
                str = str + abstractList.get(i12);
            }
            this.msgForwardContent.setText(FaceManager.emojiJudge(str));
            if (this.isMultiSelectMode) {
                this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        if (MergeMessageHolder.this.onItemClickListener != null) {
                            MergeMessageHolder.this.onItemClickListener.onMessageClick(view, i11, mergeMessageBean);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                return;
            }
            this.mForwardMsgLayout.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    if (MergeMessageHolder.this.onItemClickListener == null) {
                        return true;
                    }
                    MergeMessageHolder.this.onItemClickListener.onMessageLongClick(view, i11, tUIMessageBean);
                    return true;
                }
            });
            this.mForwardMsgLayout.setOnClickListener(new View.OnClickListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    if (MergeMessageHolder.this.onItemClickListener != null) {
                        MergeMessageHolder.this.onItemClickListener.onMessageClick(view, i11, tUIMessageBean);
                    }
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }
            });
            setMessageAreaPadding();
        }
    }
}
