package com.jumio.sdk.handler;

import com.huobi.finance.bean.FinanceRecordItem;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.views.JumioRejectView;
import jumio.core.h2;
import jumio.core.r;

public final class JumioRejectHandler extends r<h2> {
    public boolean isValidForScanStep$jumio_core_release(JumioScanStep jumioScanStep) {
        return jumioScanStep != null && jumioScanStep == JumioScanStep.REJECT_VIEW;
    }

    public final void renderPart(JumioCredentialPart jumioCredentialPart, JumioRejectView jumioRejectView) {
        super.renderPart(jumioCredentialPart, jumioRejectView);
    }

    public final void retake() {
        h2 h2Var = (h2) getCheckInterface();
        if (h2Var != null) {
            h2Var.reject();
        }
        Analytics.Companion.add(MobileEvents.userAction$default(FinanceRecordItem.STATE_REJECT, (JumioScanStep) null, (Object) null, 6, (Object) null));
    }
}
