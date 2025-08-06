package com.huochat.community.activity;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.huochat.community.CommunityThemeHelper;
import com.huochat.community.R;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;

public final class CommunityDynamicDetailActivity$initDisclaimerHint$1 extends ClickableSpan {
    public final /* synthetic */ CommunityDynamicDetailActivity this$0;

    public CommunityDynamicDetailActivity$initDisclaimerHint$1(CommunityDynamicDetailActivity communityDynamicDetailActivity) {
        this.this$0 = communityDynamicDetailActivity;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            moduleCallback.showDisclaimer(this.this$0);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int color = CommunityThemeHelper.Companion.getColor(this.this$0, R.attr.communityDetailDisclaimerTextColor);
        textPaint.linkColor = color;
        textPaint.setColor(color);
        textPaint.setUnderlineText(true);
    }
}
