package com.tencent.thumbplayer.tcmedia.api.report;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Map;

public interface ITPBusinessReportManager {
    public static final int EVENT_ID_302_REDIRECT = 1001;
    public static final int EVENT_ID_EARLY_ERROR = 1100;
    public static final int EVENT_ID_GET_CDN_URL = 1000;

    @Retention(RetentionPolicy.SOURCE)
    public @interface EventId {
    }

    @Deprecated
    void reportEvent(int i11, Map<String, Object> map);

    void setReportInfoGetter(TPDefaultReportInfo tPDefaultReportInfo);

    void setReportSamplingRate(double d11);
}
