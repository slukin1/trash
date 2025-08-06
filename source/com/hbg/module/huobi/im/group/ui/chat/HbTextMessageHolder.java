package com.hbg.module.huobi.im.group.ui.chat;

import android.content.res.Resources;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.hbg.lib.core.webview.HBBaseWebActivity;
import com.hbg.module.huobi.im.R$color;
import com.hbg.module.huobi.im.R$drawable;
import com.hbg.module.huobi.im.R$id;
import com.hbg.module.huobi.im.R$layout;
import com.hbg.module.huobi.im.R$string;
import com.hbg.module.huobi.im.R$style;
import com.hbg.module.huobi.im.group.bean.HbTextMessageBean;
import com.hbg.module.huobi.im.utils.ClickableForegroundColorSpan;
import com.hbg.module.huobi.im.utils.HbGroupUserManager;
import com.hbg.module.huobi.im.utils.LinkMovementMethodInterceptor;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.tencent.qcloud.tuicore.ServiceInitializer;
import com.tencent.qcloud.tuikit.timcommon.bean.TUIMessageBean;
import com.tencent.qcloud.tuikit.timcommon.classicui.widget.message.SelectTextHelper;
import com.tencent.qcloud.tuikit.timcommon.component.face.FaceManager;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.tencent.qcloud.tuikit.tuichat.util.TUIChatLog;
import java.util.List;
import rd.p;
import rd.u;

public class HbTextMessageHolder extends HbMessageContentHolder {
    private LinkMovementMethodInterceptor linkMovementMethod = new LinkMovementMethodInterceptor();
    private SelectTextHelper mSelectableTextHelper;
    private final Runnable mShowSelectViewRunnable = new r(this);
    /* access modifiers changed from: private */
    public TextView msgBodyText;
    /* access modifiers changed from: private */
    public String selectedText;
    private TextView tvTranslate;
    private View vLine;

    public HbTextMessageHolder(View view) {
        super(view);
        this.msgBodyText = (TextView) view.findViewById(R$id.msg_body_tv);
        this.tvTranslate = (TextView) view.findViewById(R$id.msg_body_translate_tv);
        this.vLine = view.findViewById(R$id.v_line);
        this.properties.setAvatar(R$drawable.icon_community_user_header);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void lambda$new$0() {
        this.mSelectableTextHelper.reset();
    }

    public int getVariableLayout() {
        return R$layout.im_message_adapter_text;
    }

    public void layoutVariableViews(final TUIMessageBean tUIMessageBean, final int i11) {
        boolean z11;
        int i12;
        Resources resources;
        int i13;
        Resources resources2;
        int i14;
        Resources resources3;
        if (tUIMessageBean instanceof HbTextMessageBean) {
            final HbTextMessageBean hbTextMessageBean = (HbTextMessageBean) tUIMessageBean;
            if (!hbTextMessageBean.isSelf()) {
                int color = this.msgBodyText.getResources().getColor(R$color.baseColorPrimaryText);
                this.msgBodyText.setTextColor(color);
                this.tvTranslate.setTextColor(color);
            } else {
                int color2 = this.msgBodyText.getResources().getColor(R$color.white);
                this.msgBodyText.setTextColor(color2);
                this.tvTranslate.setTextColor(color2);
            }
            if (TextUtils.isEmpty(hbTextMessageBean.getTranslateText())) {
                this.vLine.setVisibility(8);
                this.tvTranslate.setVisibility(8);
            } else {
                this.vLine.setVisibility(0);
                this.tvTranslate.setVisibility(0);
                this.tvTranslate.setText(hbTextMessageBean.getTranslateText());
            }
            this.msgBodyText.setVisibility(0);
            if (hbTextMessageBean.getText() != null) {
                z11 = FaceManager.handlerEmojiText(this.msgBodyText, hbTextMessageBean.getText(), false);
            } else if (!TextUtils.isEmpty(hbTextMessageBean.getExtra())) {
                z11 = FaceManager.handlerEmojiText(this.msgBodyText, hbTextMessageBean.getExtra(), false);
            } else {
                z11 = FaceManager.handlerEmojiText(this.msgBodyText, ServiceInitializer.getAppContext().getString(R$string.no_support_msg), false);
            }
            if (this.properties.getChatContextFontSize() != 0) {
                this.msgBodyText.setTextSize((float) this.properties.getChatContextFontSize());
            }
            if (hbTextMessageBean.isSelf()) {
                TextView textView = this.msgBodyText;
                textView.setTextAppearance(textView.getContext(), R$style.self_message_style);
                this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(R$color.white));
            } else {
                TextView textView2 = this.msgBodyText;
                textView2.setTextAppearance(textView2.getContext(), R$style.message_style);
                this.msgBodyText.setTextColor(this.msgBodyText.getResources().getColor(R$color.baseColorPrimaryText));
            }
            SelectTextHelper.Builder builder = new SelectTextHelper.Builder(this.msgBodyText);
            Resources resources4 = this.msgBodyText.getContext().getResources();
            int i15 = R$color.color_12B298;
            this.mSelectableTextHelper = builder.setCursorHandleColor(resources4.getColor(i15)).setCursorHandleSizeInDp(22.0f).setSelectedColor(this.msgBodyText.getContext().getResources().getColor(R$color.color_1A12B298)).setSelectAll(true).setIsEmoji(z11).setScrollShow(false).setSelectedAllNoPop(true).setMagnifierShow(false).build();
            if (!tUIMessageBean.isGroup() || HbGroupUserManager.c().d(tUIMessageBean.getSender())) {
                this.linkMovementMethod.a(new p() {
                    public void onClickUrl(String str) {
                        TUIChatLog.i("TextMessageHolder", "onClickUrl: url:" + str);
                        HBBaseWebActivity.showWebView(HbTextMessageHolder.this.msgBodyText.getContext(), str, "", "", false);
                    }
                });
                String text = hbTextMessageBean.getText();
                if (TextUtils.isEmpty(text)) {
                    u a11 = u.a(this.msgBodyText.getContext());
                    TextView textView3 = this.msgBodyText;
                    if (hbTextMessageBean.isSelf()) {
                        resources = this.msgBodyText.getResources();
                        i12 = R$color.white;
                    } else {
                        resources = this.msgBodyText.getResources();
                        i12 = R$color.baseColorMajorTheme100;
                    }
                    a11.d(textView3, resources.getColor(i12));
                } else if (TextUtils.equals(TIMMentionEditText.TIM_MENTION_TAG, String.valueOf(text.charAt(0)))) {
                    int indexOf = text.indexOf(" ");
                    u a12 = u.a(this.msgBodyText.getContext());
                    TextView textView4 = this.msgBodyText;
                    if (hbTextMessageBean.isSelf()) {
                        resources3 = this.msgBodyText.getResources();
                        i14 = R$color.white;
                    } else {
                        resources3 = this.msgBodyText.getResources();
                        i14 = R$color.baseColorMajorTheme100;
                    }
                    a12.e(textView4, indexOf, resources3.getColor(i14));
                } else {
                    u a13 = u.a(this.msgBodyText.getContext());
                    TextView textView5 = this.msgBodyText;
                    if (hbTextMessageBean.isSelf()) {
                        resources2 = this.msgBodyText.getResources();
                        i13 = R$color.white;
                    } else {
                        resources2 = this.msgBodyText.getResources();
                        i13 = R$color.baseColorMajorTheme100;
                    }
                    a13.d(textView5, resources2.getColor(i13));
                }
                this.msgBodyText.setMovementMethod(this.linkMovementMethod);
            }
            List<String> groupAtUserList = hbTextMessageBean.getV2TIMMessage().getGroupAtUserList();
            if (groupAtUserList != null && groupAtUserList.size() > 0) {
                String text2 = hbTextMessageBean.getText();
                if (!TextUtils.isEmpty(text2) && TextUtils.equals(TIMMentionEditText.TIM_MENTION_TAG, String.valueOf(text2.charAt(0)))) {
                    int indexOf2 = text2.indexOf(" ");
                    CharSequence text3 = this.msgBodyText.getText();
                    if (indexOf2 < text3.length() && indexOf2 != -1) {
                        int color3 = ContextCompat.getColor(this.msgBodyText.getContext(), i15);
                        if (tUIMessageBean.isSelf()) {
                            color3 = ContextCompat.getColor(this.msgBodyText.getContext(), R$color.white);
                        }
                        ClickableForegroundColorSpan clickableForegroundColorSpan = new ClickableForegroundColorSpan(color3);
                        if (text3 instanceof SpannableStringBuilder) {
                            SpannableStringBuilder spannableStringBuilder = (SpannableStringBuilder) text3;
                            spannableStringBuilder.setSpan(clickableForegroundColorSpan, 0, indexOf2, 33);
                            this.msgBodyText.setText(spannableStringBuilder);
                        } else {
                            SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(text3);
                            spannableStringBuilder2.setSpan(clickableForegroundColorSpan, 0, indexOf2, 33);
                            this.msgBodyText.setText(spannableStringBuilder2);
                        }
                    }
                }
            }
            this.msgContentFrame.setOnLongClickListener(new View.OnLongClickListener() {
                public boolean onLongClick(View view) {
                    return true;
                }
            });
            this.mSelectableTextHelper.setSelectListener(new SelectTextHelper.OnSelectListener() {
                @SensorsDataInstrumented
                public void onClick(View view) {
                    SensorsDataAutoTrackHelper.trackViewOnClick(view);
                }

                public void onClickUrl(String str) {
                }

                public void onDismiss() {
                }

                public void onDismissCustomPop() {
                }

                public void onLongClick(View view) {
                }

                public void onReset() {
                }

                public void onScrolling() {
                }

                public void onSelectAllShowCustomPop() {
                }

                public void onTextSelected(CharSequence charSequence) {
                    String unused = HbTextMessageHolder.this.selectedText = charSequence.toString();
                    hbTextMessageBean.setSelectText(HbTextMessageHolder.this.selectedText);
                    TUIChatLog.d("TextMessageHolder", "onTextSelected selectedText = " + HbTextMessageHolder.this.selectedText);
                    if (HbTextMessageHolder.this.onItemClickListener != null) {
                        HbTextMessageHolder.this.onItemClickListener.onTextSelected(HbTextMessageHolder.this.msgContentFrame, i11, tUIMessageBean);
                    }
                }
            });
        }
    }

    public void resetSelectableText() {
        this.msgBodyText.postDelayed(this.mShowSelectViewRunnable, 120);
    }
}
