package com.jumio.sdk.handler;

import com.huobi.finance.bean.FinanceRecordItem;
import com.jumio.analytics.Analytics;
import com.jumio.analytics.MobileEvents;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.views.JumioConfirmationView;
import jumio.core.r;
import jumio.core.w;

public final class JumioConfirmationHandler extends r<w> {
    public final void confirm() {
        w wVar = (w) getCheckInterface();
        if (wVar != null) {
            wVar.a();
        }
        Analytics.Companion.add(MobileEvents.userAction$default("confirm", (JumioScanStep) null, (Object) null, 6, (Object) null));
    }

    public boolean isValidForScanStep$jumio_core_release(JumioScanStep jumioScanStep) {
        return jumioScanStep != null && jumioScanStep == JumioScanStep.CONFIRMATION_VIEW;
    }

    public final void renderPart(JumioCredentialPart jumioCredentialPart, JumioConfirmationView jumioConfirmationView) {
        super.renderPart(jumioCredentialPart, jumioConfirmationView);
    }

    public final void retake() {
        w wVar = (w) getCheckInterface();
        if (wVar != null) {
            wVar.reject();
        }
        Analytics.Companion.add(MobileEvents.userAction$default(FinanceRecordItem.STATE_REJECT, (JumioScanStep) null, (Object) null, 6, (Object) null));
    }
}
