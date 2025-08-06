package com.tencent.ugc;

import android.content.Context;
import com.tencent.liteav.base.ContextUtils;
import com.tencent.liteav.base.util.r;
import com.tencent.liteav.sdk.common.LicenseChecker;
import com.tencent.ugc.datereport.UGCDataReport;
import com.tencent.ugc.datereport.UGCDataReportDef;

public class TXUGCBase {
    private static TXUGCBase sInstance;
    private static TXUGCBaseListener sListener;

    public static abstract class TXUGCBaseListener {
        public abstract void onLicenceLoaded(int i11, String str);
    }

    static {
        r.a();
    }

    private TXUGCBase() {
    }

    public static TXUGCBase getInstance() {
        if (sInstance == null) {
            synchronized (TXUGCBase.class) {
                if (sInstance == null) {
                    sInstance = new TXUGCBase();
                }
            }
        }
        return sInstance;
    }

    public static /* synthetic */ void lambda$setLicence$0(int i11, String str) {
        TXUGCBaseListener tXUGCBaseListener = sListener;
        if (tXUGCBaseListener != null) {
            tXUGCBaseListener.onLicenceLoaded(i11, str);
        }
    }

    public static void setListener(TXUGCBaseListener tXUGCBaseListener) {
        sListener = tXUGCBaseListener;
    }

    public String getLicenceInfo(Context context) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        return LicenseChecker.getInstance().getLicense(LicenseChecker.c.UGC);
    }

    public void setLicence(Context context, String str, String str2) {
        ContextUtils.initApplicationContext(context.getApplicationContext());
        ContextUtils.setDataDirectorySuffix("liteav");
        LicenseChecker.getInstance().setListener(b.a());
        LicenseChecker.getInstance().setLicense(LicenseChecker.c.UGC, str, str2);
        UGCDataReport.reportDAU(UGCDataReportDef.DR_DAU_EVENT_ID_UGCKIT);
    }
}
