package bolts;

import com.facebook.internal.AnalyticsEvents;
import com.huobi.finance.bean.LoanOrderItem;
import com.sumsub.sentry.a;

public enum AppLinkNavigation$NavigationResult {
    FAILED(LoanOrderItem.FAILED, false),
    WEB(AnalyticsEvents.PARAMETER_SHARE_DIALOG_SHOW_WEB, true),
    APP(a.f30241h, true);
    
    private String code;
    private boolean succeeded;

    private AppLinkNavigation$NavigationResult(String str, boolean z11) {
        this.code = str;
        this.succeeded = z11;
    }

    public String getCode() {
        return this.code;
    }

    public boolean isSucceeded() {
        return this.succeeded;
    }
}
