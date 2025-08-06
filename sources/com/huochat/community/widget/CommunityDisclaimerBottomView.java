package com.huochat.community.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.interpolator.view.animation.FastOutLinearInInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import com.hbg.lib.widgets.dialog.HBDialogFragment;
import com.huochat.community.CommunityManager;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.huochat.community.base.CommunitySensorsEvent;
import com.huochat.community.util.CommunityDialogUtil;
import com.huochat.community.util.DisplayTool;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import java.util.HashMap;
import kotlin.Unit;
import kotlin.jvm.internal.Ref$IntRef;
import kotlin.jvm.internal.Ref$ObjectRef;
import oa.a;
import org.json.JSONObject;

public final class CommunityDisclaimerBottomView extends FrameLayout {
    /* access modifiers changed from: private */
    public Context mContext;
    /* access modifiers changed from: private */
    public boolean mIsAnimStarting;
    private boolean mIsNightModel;
    private String mSymbolId;
    private String pageId = "1005005";
    private RelativeLayout rlFromHuobichatContainer;
    private TextView tvFromHuobichatHint;
    private Button tvOpenHuobichat;

    public CommunityDisclaimerBottomView(Context context) {
        super(context);
        initView(context);
    }

    private final void initOpenHuobiChatHint() {
        this.mIsNightModel = CommunityManager.Companion.getInstance().isNightModel();
        Ref$IntRef ref$IntRef = new Ref$IntRef();
        if (this.mIsNightModel) {
            ref$IntRef.element = getResources().getColor(R.color.color_ffffff);
            this.rlFromHuobichatContainer.setBackgroundResource(R.drawable.bg_open_chat_panel_night);
            this.tvFromHuobichatHint.setTextColor(ref$IntRef.element);
        } else {
            ref$IntRef.element = getResources().getColor(R.color.color_14181F);
            this.rlFromHuobichatContainer.setBackgroundResource(R.drawable.bg_open_chat_panel_light);
            this.tvFromHuobichatHint.setTextColor(ref$IntRef.element);
        }
        String string = getResources().getString(R.string.community_content_from_huobichat_hint);
        String string2 = getResources().getString(R.string.community_disclaimer);
        SpannableString spannableString = new SpannableString(string + 10 + string2 + ' ');
        int length = spannableString.length();
        spannableString.setSpan(new CommunityDisclaimerBottomView$initOpenHuobiChatHint$1(this, ref$IntRef), (length - string2.length()) + -1, length + -1, 33);
        this.tvFromHuobichatHint.setText(spannableString);
        this.tvFromHuobichatHint.setMovementMethod(LinkMovementMethod.getInstance());
    }

    private final void initView(Context context) {
        LayoutInflater layoutInflater;
        this.mContext = context;
        if (context == null) {
            layoutInflater = LayoutInflater.from(context);
        } else {
            layoutInflater = LayoutInflater.from(context).cloneInContext(CommunityThemeHelper.Companion.getThemeContext(context));
        }
        View inflate = layoutInflater.inflate(R.layout.layout_community_disclaimer_bottom_view, this);
        this.rlFromHuobichatContainer = (RelativeLayout) inflate.findViewById(R.id.rl_from_huobichat_container);
        this.tvFromHuobichatHint = (TextView) inflate.findViewById(R.id.tv_from_huobichat_hint);
        Button button = (Button) inflate.findViewById(R.id.tv_open_huobichat);
        this.tvOpenHuobichat = button;
        button.setOnClickListener(new c(this, context));
        initOpenHuobiChatHint();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void initView$lambda$0(CommunityDisclaimerBottomView communityDisclaimerBottomView, Context context, View view) {
        communityDisclaimerBottomView.openHuobiChat(context);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* access modifiers changed from: private */
    public static final void openHuobiChat$lambda$3(CommunityDisclaimerBottomView communityDisclaimerBottomView, HBDialogFragment hBDialogFragment) {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            String openHuoxinAlert = CommunitySensorsEvent.Companion.getOpenHuoxinAlert();
            HashMap hashMap = new HashMap();
            hashMap.put("action_key", "no");
            hashMap.put("type", "kline");
            hashMap.put("Page_name", communityDisclaimerBottomView.pageId);
            hashMap.put("symbol", communityDisclaimerBottomView.mSymbolId);
            Unit unit = Unit.f56620a;
            moduleCallback.track(openHuoxinAlert, hashMap);
        }
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
    }

    /* access modifiers changed from: private */
    public static final void openHuobiChat$lambda$5(CommunityDisclaimerBottomView communityDisclaimerBottomView, Ref$ObjectRef ref$ObjectRef, HBDialogFragment hBDialogFragment) {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            String openHuoxinAlert = CommunitySensorsEvent.Companion.getOpenHuoxinAlert();
            HashMap hashMap = new HashMap();
            hashMap.put("action_key", "yes");
            hashMap.put("type", "kline");
            hashMap.put("Page_name", communityDisclaimerBottomView.pageId);
            hashMap.put("symbol", communityDisclaimerBottomView.mSymbolId);
            Unit unit = Unit.f56620a;
            moduleCallback.track(openHuoxinAlert, hashMap);
        }
        if (hBDialogFragment != null) {
            hBDialogFragment.dismiss();
        }
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("symbolId", communityDisclaimerBottomView.mSymbolId);
        CommunityManager.Companion.getInstance().openHuobiChat((Context) ref$ObjectRef.element, "communityList", jSONObject.toString());
    }

    private final void showAnim(View view, Animator.AnimatorListener animatorListener) {
        if (!this.mIsAnimStarting) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(270);
            animatorSet.setInterpolator(new FastOutSlowInInterpolator());
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{0.5f, 1.0f}), ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{(float) DisplayTool.dp2px(70.0f), 0.0f})});
            animatorSet.addListener(new CommunityDisclaimerBottomView$showAnim$1(this, animatorListener));
            animatorSet.start();
        }
    }

    public final void hideAnim(View view, Animator.AnimatorListener animatorListener) {
        if (!this.mIsAnimStarting) {
            AnimatorSet animatorSet = new AnimatorSet();
            animatorSet.setDuration(240);
            animatorSet.setInterpolator(new FastOutLinearInInterpolator());
            animatorSet.playTogether(new Animator[]{ObjectAnimator.ofFloat(view, View.ALPHA, new float[]{1.0f, 0.5f}), ObjectAnimator.ofFloat(view, View.TRANSLATION_Y, new float[]{0.0f, (float) DisplayTool.dp2px(70.0f)})});
            animatorSet.addListener(new CommunityDisclaimerBottomView$hideAnim$1(this, animatorListener));
            animatorSet.start();
        }
    }

    public final void openHuobiChat(Context context) {
        Ref$ObjectRef ref$ObjectRef = new Ref$ObjectRef();
        ref$ObjectRef.element = context;
        if (context != null) {
            CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
            if (moduleCallback != null) {
                String openHuoxinButton = CommunitySensorsEvent.Companion.getOpenHuoxinButton();
                HashMap hashMap = new HashMap();
                hashMap.put("symbol", this.mSymbolId);
                Unit unit = Unit.f56620a;
                moduleCallback.track(openHuoxinButton, hashMap);
            }
            boolean isNightModel = CommunityManager.Companion.getInstance().isNightModel();
            CommunityDialogUtil.INSTANCE.showDialog((FragmentActivity) a.g().b(), isNightModel ? 1 : 0, ((Context) ref$ObjectRef.element).getString(R.string.community_click_open_huobichat_app_hint), "", "", ((Context) ref$ObjectRef.element).getString(R.string.n_cancel), ((Context) ref$ObjectRef.element).getString(R.string.community_allow_open_huobichat_btn_hint), new d(this), new e(this, ref$ObjectRef));
        }
    }

    public final void resetThemeColor() {
        initOpenHuobiChatHint();
    }

    public final void setAnimVisibility(boolean z11) {
        setAnimVisibility(z11, (Animator.AnimatorListener) null);
    }

    public final void setSymbol(String str) {
        this.mSymbolId = str;
    }

    public final void setAnimVisibility(boolean z11, Animator.AnimatorListener animatorListener) {
        if (this.mIsNightModel != CommunityManager.Companion.getInstance().isNightModel()) {
            resetThemeColor();
        }
        if (z11) {
            if (getVisibility() != 0) {
                showAnim(this.rlFromHuobichatContainer, animatorListener);
            }
        } else if (getVisibility() == 0) {
            hideAnim(this.rlFromHuobichatContainer, animatorListener);
        }
    }

    public final void setSymbol(String str, String str2) {
        this.mSymbolId = str;
        this.pageId = str2;
    }

    public CommunityDisclaimerBottomView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        initView(context);
    }

    public CommunityDisclaimerBottomView(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        initView(context);
    }
}
