package com.tencent.qcloud.tuikit.timcommon.classicui.widget.message;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.tencent.qcloud.tuicore.TUIConfig;
import com.tencent.qcloud.tuicore.TUIThemeManager;
import com.tencent.qcloud.tuikit.timcommon.R;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.component.MessageProperties;
import com.tencent.qcloud.tuikit.timcommon.interfaces.ICommonMessageAdapter;
import com.tencent.qcloud.tuikit.timcommon.interfaces.OnItemClickListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public abstract class MessageBaseHolder extends RecyclerView.ViewHolder {
    public static final int MSG_TYPE_HEADER_VIEW = -99;
    public TextView chatTimeText;
    public boolean floatMode = false;
    private ValueAnimator highLightAnimator;
    public boolean isShowStart = true;
    public ICommonMessageAdapter mAdapter;
    public View mContentLayout;
    public CheckBox mMutiSelectCheckBox;
    public LinearLayout msgArea;
    public LinearLayout msgAreaAndReply;
    public FrameLayout msgContentFrame;
    public OnItemClickListener onItemClickListener;
    public MessageProperties properties = MessageProperties.getInstance();
    public ChatFlowReactView reactView;
    public RelativeLayout rightGroupLayout;

    public MessageBaseHolder(View view) {
        super(view);
        this.msgContentFrame = (FrameLayout) view.findViewById(R.id.msg_content_fl);
        this.reactView = (ChatFlowReactView) view.findViewById(R.id.reacts_view);
        this.msgArea = (LinearLayout) view.findViewById(R.id.msg_area);
        this.msgAreaAndReply = (LinearLayout) view.findViewById(R.id.msg_area_and_reply);
        this.mMutiSelectCheckBox = (CheckBox) view.findViewById(R.id.select_checkbox);
        this.chatTimeText = (TextView) view.findViewById(R.id.message_top_time_tv);
        this.rightGroupLayout = (RelativeLayout) view.findViewById(R.id.right_group_layout);
        this.mContentLayout = view.findViewById(R.id.message_content_layout);
        initVariableLayout();
    }

    public static String getTimeFormatText(Date date) {
        Context appContext;
        Resources resources;
        if (date == null || (appContext = TUIConfig.getAppContext()) == null || (resources = appContext.getResources()) == null) {
            return "";
        }
        Locale locale = TUIThemeManager.getInstance().getLocale(appContext);
        Calendar instance = Calendar.getInstance();
        instance.set(11, 0);
        instance.set(12, 0);
        instance.set(13, 0);
        instance.set(14, 0);
        long timeInMillis = instance.getTimeInMillis();
        Calendar calendar = (Calendar) instance.clone();
        calendar.add(6, -1);
        long timeInMillis2 = calendar.getTimeInMillis();
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        long timeInMillis3 = instance2.getTimeInMillis();
        if (timeInMillis3 >= timeInMillis) {
            return resources.getString(R.string.n_im_time_today) + new SimpleDateFormat("HH:mm", locale).format(date);
        } else if (timeInMillis3 < timeInMillis2) {
            return new SimpleDateFormat("yyy/MM/dd HH:mm", locale).format(date);
        } else {
            return resources.getString(R.string.n_content_date_yesterday) + new SimpleDateFormat("HH:mm", locale).format(date);
        }
    }

    private void initVariableLayout() {
        if (getVariableLayout() != 0) {
            setVariableLayout(getVariableLayout());
        }
    }

    private void setVariableLayout(int i11) {
        if (this.msgContentFrame.getChildCount() == 0) {
            View.inflate(this.itemView.getContext(), i11, this.msgContentFrame);
        }
    }

    public void clearHighLightBackground() {
        Drawable background = this.msgArea.getBackground();
        if (background != null) {
            background.setColorFilter((ColorFilter) null);
        }
    }

    public OnItemClickListener getOnItemClickListener() {
        return this.onItemClickListener;
    }

    public abstract int getVariableLayout();

    public boolean isShowAvatar(TUIMessageBean tUIMessageBean) {
        return false;
    }

    public void layoutViews(TUIMessageBean tUIMessageBean, int i11) {
        if (this.properties.getChatTimeBubble() != null) {
            this.chatTimeText.setBackground(this.properties.getChatTimeBubble());
        }
        if (this.properties.getChatTimeFontColor() != 0) {
            this.chatTimeText.setTextColor(this.properties.getChatTimeFontColor());
        }
        if (this.properties.getChatTimeFontSize() != 0) {
            this.chatTimeText.setTextSize((float) this.properties.getChatTimeFontSize());
        }
        if (i11 <= 1) {
            this.chatTimeText.setVisibility(0);
            this.chatTimeText.setText(getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
        } else if (tUIMessageBean.isShowTime()) {
            this.chatTimeText.setVisibility(0);
            this.chatTimeText.setText(getTimeFormatText(new Date(tUIMessageBean.getMessageTime() * 1000)));
        } else {
            this.chatTimeText.setVisibility(8);
        }
    }

    public void setAdapter(ICommonMessageAdapter iCommonMessageAdapter) {
        this.mAdapter = iCommonMessageAdapter;
    }

    public void setFloatMode(boolean z11) {
        this.floatMode = z11;
    }

    public void setHighLightBackground(int i11) {
        Drawable background = this.msgArea.getBackground();
        if (background != null) {
            background.setColorFilter(i11, PorterDuff.Mode.SRC_IN);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener2) {
        this.onItemClickListener = onItemClickListener2;
    }

    public void startHighLight() {
        int color = this.itemView.getResources().getColor(R.color.chat_message_bubble_high_light_dark_color);
        int color2 = this.itemView.getResources().getColor(R.color.chat_message_bubble_high_light_light_color);
        if (this.highLightAnimator == null) {
            ArgbEvaluator argbEvaluator = new ArgbEvaluator();
            ValueAnimator valueAnimator = new ValueAnimator();
            this.highLightAnimator = valueAnimator;
            valueAnimator.setIntValues(new int[]{color, color2});
            this.highLightAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    MessageBaseHolder.this.setHighLightBackground(((Integer) valueAnimator.getAnimatedValue()).intValue());
                }
            });
            this.highLightAnimator.addListener(new Animator.AnimatorListener() {
                public void onAnimationCancel(Animator animator) {
                    MessageBaseHolder.this.clearHighLightBackground();
                }

                public void onAnimationEnd(Animator animator) {
                    MessageBaseHolder.this.clearHighLightBackground();
                }

                public void onAnimationRepeat(Animator animator) {
                }

                public void onAnimationStart(Animator animator) {
                }
            });
            this.highLightAnimator.setEvaluator(argbEvaluator);
            this.highLightAnimator.setRepeatCount(3);
            this.highLightAnimator.setDuration(250);
            this.highLightAnimator.setRepeatMode(2);
        }
        this.highLightAnimator.start();
    }

    public void stopHighLight() {
        ValueAnimator valueAnimator = this.highLightAnimator;
        if (valueAnimator != null) {
            valueAnimator.cancel();
        }
        clearHighLightBackground();
    }
}
