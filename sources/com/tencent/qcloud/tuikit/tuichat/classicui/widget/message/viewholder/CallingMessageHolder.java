package com.tencent.qcloud.tuikit.tuichat.classicui.widget.message.viewholder;

import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.tuichat.R;
import com.tencent.qcloud.tuikit.tuichat.bean.message.CallingMessageBean;

public class CallingMessageHolder extends TextMessageHolder {
    private LinearLayout mCallingLayout;
    private ImageView mLeftView;
    private ImageView mRightView;
    private TextView msgBodyText;

    public CallingMessageHolder(View view) {
        super(view);
        this.msgBodyText = (TextView) view.findViewById(R.id.msg_body_tv);
        this.mLeftView = (ImageView) view.findViewById(R.id.left_icon);
        this.mRightView = (ImageView) view.findViewById(R.id.right_icon);
        this.mCallingLayout = (LinearLayout) view.findViewById(R.id.calling_layout);
    }

    public int getVariableLayout() {
        return R.layout.message_adapter_content_calling;
    }

    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i11) {
        super.layoutVariableViews(tUIMessageBean, i11);
        if (tUIMessageBean instanceof CallingMessageBean) {
            CallingMessageBean callingMessageBean = (CallingMessageBean) tUIMessageBean;
            int i12 = 8;
            if (tUIMessageBean.isSelf()) {
                this.mLeftView.setVisibility(8);
                this.mRightView.setVisibility(0);
                if (callingMessageBean.getCallType() == 1) {
                    this.mRightView.setImageResource(R.drawable.ic_audio_call);
                } else if (callingMessageBean.getCallType() == 2) {
                    this.mRightView.setImageResource(R.drawable.ic_self_video_call);
                }
                this.unreadAudioText.setVisibility(8);
            } else {
                this.mRightView.setVisibility(8);
                this.mLeftView.setVisibility(0);
                if (callingMessageBean.getCallType() == 1) {
                    this.mLeftView.setImageResource(R.drawable.ic_audio_call);
                } else if (callingMessageBean.getCallType() == 2) {
                    this.mLeftView.setImageResource(R.drawable.ic_other_video_call);
                }
                TextView textView = this.unreadAudioText;
                if (callingMessageBean.isShowUnreadPoint()) {
                    i12 = 0;
                }
                textView.setVisibility(i12);
            }
            if (callingMessageBean.getCallType() == 1 || callingMessageBean.getCallType() == 2) {
                this.msgArea.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View view) {
                        if (CallingMessageHolder.this.selectableTextHelper == null) {
                            return true;
                        }
                        CallingMessageHolder.this.selectableTextHelper.selectAll();
                        return true;
                    }
                });
                this.msgArea.setOnClickListener(new View.OnClickListener() {
                    @SensorsDataInstrumented
                    public void onClick(View view) {
                        if (CallingMessageHolder.this.onItemClickListener != null) {
                            CallingMessageHolder.this.onItemClickListener.onRecallClick(view, i11, tUIMessageBean);
                        }
                        SensorsDataAutoTrackHelper.trackViewOnClick(view);
                    }
                });
                if (!this.isForwardMode && !this.isReplyDetailMode) {
                    setSelectableTextHelper(tUIMessageBean, this.msgBodyText, i11, false);
                }
            }
        }
    }
}
