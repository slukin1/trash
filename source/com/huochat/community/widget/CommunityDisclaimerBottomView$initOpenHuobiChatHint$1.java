package com.huochat.community.widget;

import android.text.TextPaint;
import android.text.style.ClickableSpan;
import android.view.View;
import com.huochat.community.CommunityModuleCallback;
import com.huochat.community.CommunityModuleConfig;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import kotlin.jvm.internal.Ref$IntRef;

public final class CommunityDisclaimerBottomView$initOpenHuobiChatHint$1 extends ClickableSpan {
    public final /* synthetic */ Ref$IntRef $hintTextColor;
    public final /* synthetic */ CommunityDisclaimerBottomView this$0;

    public CommunityDisclaimerBottomView$initOpenHuobiChatHint$1(CommunityDisclaimerBottomView communityDisclaimerBottomView, Ref$IntRef ref$IntRef) {
        this.this$0 = communityDisclaimerBottomView;
        this.$hintTextColor = ref$IntRef;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        if (this.this$0.mContext == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        CommunityModuleCallback moduleCallback = CommunityModuleConfig.Companion.getModuleCallback();
        if (moduleCallback != null) {
            moduleCallback.showDisclaimer(this.this$0.getContext());
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void updateDrawState(TextPaint textPaint) {
        super.updateDrawState(textPaint);
        int i11 = this.$hintTextColor.element;
        textPaint.linkColor = i11;
        textPaint.setColor(i11);
        textPaint.setUnderlineText(true);
    }
}
