package com.huobi.woodpecker.webview;

import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.Serializable;
import java.text.SimpleDateFormat;

public class NavigationTimingBean implements Serializable {

    /* renamed from: df  reason: collision with root package name */
    private static final SimpleDateFormat f21168df = new SimpleDateFormat("yyyy-mm-dd hh:mm:ss SSS");
    private long connectEnd;
    private long connectStart;
    private long domComplete;
    private long domContentLoadedEventEnd;
    private long domContentLoadedEventStart;
    private long domInteractive;
    private long domLoading;
    private long domainLookupEnd;
    private long domainLookupStart;
    private long fetchStart;
    private long loadEventEnd;
    private long loadEventStart;
    private long navigationStart;
    private long pageTime;
    private long redirectEnd;
    private long redirectStart;
    private long requestStart;
    private long responseEnd;
    private long responseStart;
    private long secureConnectionStart;
    private long unloadEventEnd;
    private long unloadEventStart;

    public boolean canEqual(Object obj) {
        return obj instanceof NavigationTimingBean;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof NavigationTimingBean)) {
            return false;
        }
        NavigationTimingBean navigationTimingBean = (NavigationTimingBean) obj;
        return navigationTimingBean.canEqual(this) && getNavigationStart() == navigationTimingBean.getNavigationStart() && getRedirectStart() == navigationTimingBean.getRedirectStart() && getRedirectEnd() == navigationTimingBean.getRedirectEnd() && getFetchStart() == navigationTimingBean.getFetchStart() && getDomainLookupStart() == navigationTimingBean.getDomainLookupStart() && getDomainLookupEnd() == navigationTimingBean.getDomainLookupEnd() && getConnectStart() == navigationTimingBean.getConnectStart() && getSecureConnectionStart() == navigationTimingBean.getSecureConnectionStart() && getConnectEnd() == navigationTimingBean.getConnectEnd() && getRequestStart() == navigationTimingBean.getRequestStart() && getResponseStart() == navigationTimingBean.getResponseStart() && getResponseEnd() == navigationTimingBean.getResponseEnd() && getUnloadEventStart() == navigationTimingBean.getUnloadEventStart() && getUnloadEventEnd() == navigationTimingBean.getUnloadEventEnd() && getDomLoading() == navigationTimingBean.getDomLoading() && getDomInteractive() == navigationTimingBean.getDomInteractive() && getDomContentLoadedEventStart() == navigationTimingBean.getDomContentLoadedEventStart() && getDomContentLoadedEventEnd() == navigationTimingBean.getDomContentLoadedEventEnd() && getDomComplete() == navigationTimingBean.getDomComplete() && getLoadEventStart() == navigationTimingBean.getLoadEventStart() && getLoadEventEnd() == navigationTimingBean.getLoadEventEnd() && getPageTime() == navigationTimingBean.getPageTime();
    }

    public long getConnectEnd() {
        return this.connectEnd;
    }

    public long getConnectStart() {
        return this.connectStart;
    }

    public long getDomComplete() {
        return this.domComplete;
    }

    public long getDomContentLoadedEventEnd() {
        return this.domContentLoadedEventEnd;
    }

    public long getDomContentLoadedEventStart() {
        return this.domContentLoadedEventStart;
    }

    public long getDomInteractive() {
        return this.domInteractive;
    }

    public long getDomLoading() {
        return this.domLoading;
    }

    public long getDomainLookupEnd() {
        return this.domainLookupEnd;
    }

    public long getDomainLookupStart() {
        return this.domainLookupStart;
    }

    public long getFetchStart() {
        return this.fetchStart;
    }

    public long getLoadEventEnd() {
        return this.loadEventEnd;
    }

    public long getLoadEventStart() {
        return this.loadEventStart;
    }

    public long getNavigationStart() {
        return this.navigationStart;
    }

    public long getPageTime() {
        return this.pageTime;
    }

    public long getRedirectEnd() {
        return this.redirectEnd;
    }

    public long getRedirectStart() {
        return this.redirectStart;
    }

    public long getRequestStart() {
        return this.requestStart;
    }

    public long getResponseEnd() {
        return this.responseEnd;
    }

    public long getResponseStart() {
        return this.responseStart;
    }

    public long getSecureConnectionStart() {
        return this.secureConnectionStart;
    }

    public long getUnloadEventEnd() {
        return this.unloadEventEnd;
    }

    public long getUnloadEventStart() {
        return this.unloadEventStart;
    }

    public int hashCode() {
        long navigationStart2 = getNavigationStart();
        long redirectStart2 = getRedirectStart();
        int i11 = ((((int) (navigationStart2 ^ (navigationStart2 >>> 32))) + 59) * 59) + ((int) (redirectStart2 ^ (redirectStart2 >>> 32)));
        long redirectEnd2 = getRedirectEnd();
        int i12 = (i11 * 59) + ((int) (redirectEnd2 ^ (redirectEnd2 >>> 32)));
        long fetchStart2 = getFetchStart();
        int i13 = (i12 * 59) + ((int) (fetchStart2 ^ (fetchStart2 >>> 32)));
        long domainLookupStart2 = getDomainLookupStart();
        int i14 = (i13 * 59) + ((int) (domainLookupStart2 ^ (domainLookupStart2 >>> 32)));
        long domainLookupEnd2 = getDomainLookupEnd();
        int i15 = (i14 * 59) + ((int) (domainLookupEnd2 ^ (domainLookupEnd2 >>> 32)));
        long connectStart2 = getConnectStart();
        int i16 = (i15 * 59) + ((int) (connectStart2 ^ (connectStart2 >>> 32)));
        long secureConnectionStart2 = getSecureConnectionStart();
        int i17 = (i16 * 59) + ((int) (secureConnectionStart2 ^ (secureConnectionStart2 >>> 32)));
        long connectEnd2 = getConnectEnd();
        int i18 = (i17 * 59) + ((int) (connectEnd2 ^ (connectEnd2 >>> 32)));
        long requestStart2 = getRequestStart();
        int i19 = (i18 * 59) + ((int) (requestStart2 ^ (requestStart2 >>> 32)));
        long responseStart2 = getResponseStart();
        int i21 = (i19 * 59) + ((int) (responseStart2 ^ (responseStart2 >>> 32)));
        long responseEnd2 = getResponseEnd();
        int i22 = (i21 * 59) + ((int) (responseEnd2 ^ (responseEnd2 >>> 32)));
        long unloadEventStart2 = getUnloadEventStart();
        int i23 = (i22 * 59) + ((int) (unloadEventStart2 ^ (unloadEventStart2 >>> 32)));
        long unloadEventEnd2 = getUnloadEventEnd();
        int i24 = (i23 * 59) + ((int) (unloadEventEnd2 ^ (unloadEventEnd2 >>> 32)));
        long domLoading2 = getDomLoading();
        int i25 = (i24 * 59) + ((int) (domLoading2 ^ (domLoading2 >>> 32)));
        long domInteractive2 = getDomInteractive();
        int i26 = (i25 * 59) + ((int) (domInteractive2 ^ (domInteractive2 >>> 32)));
        long domContentLoadedEventStart2 = getDomContentLoadedEventStart();
        int i27 = (i26 * 59) + ((int) (domContentLoadedEventStart2 ^ (domContentLoadedEventStart2 >>> 32)));
        long domContentLoadedEventEnd2 = getDomContentLoadedEventEnd();
        int i28 = (i27 * 59) + ((int) (domContentLoadedEventEnd2 ^ (domContentLoadedEventEnd2 >>> 32)));
        long domComplete2 = getDomComplete();
        int i29 = (i28 * 59) + ((int) (domComplete2 ^ (domComplete2 >>> 32)));
        long loadEventStart2 = getLoadEventStart();
        int i30 = (i29 * 59) + ((int) (loadEventStart2 ^ (loadEventStart2 >>> 32)));
        long loadEventEnd2 = getLoadEventEnd();
        int i31 = (i30 * 59) + ((int) (loadEventEnd2 ^ (loadEventEnd2 >>> 32)));
        long pageTime2 = getPageTime();
        return (i31 * 59) + ((int) ((pageTime2 >>> 32) ^ pageTime2));
    }

    public void setConnectEnd(long j11) {
        this.connectEnd = j11;
    }

    public void setConnectStart(long j11) {
        this.connectStart = j11;
    }

    public void setDomComplete(long j11) {
        this.domComplete = j11;
    }

    public void setDomContentLoadedEventEnd(long j11) {
        this.domContentLoadedEventEnd = j11;
    }

    public void setDomContentLoadedEventStart(long j11) {
        this.domContentLoadedEventStart = j11;
    }

    public void setDomInteractive(long j11) {
        this.domInteractive = j11;
    }

    public void setDomLoading(long j11) {
        this.domLoading = j11;
    }

    public void setDomainLookupEnd(long j11) {
        this.domainLookupEnd = j11;
    }

    public void setDomainLookupStart(long j11) {
        this.domainLookupStart = j11;
    }

    public void setFetchStart(long j11) {
        this.fetchStart = j11;
    }

    public void setLoadEventEnd(long j11) {
        this.loadEventEnd = j11;
    }

    public void setLoadEventStart(long j11) {
        this.loadEventStart = j11;
    }

    public void setNavigationStart(long j11) {
        this.navigationStart = j11;
    }

    public void setPageTime(long j11) {
        this.pageTime = j11;
    }

    public void setRedirectEnd(long j11) {
        this.redirectEnd = j11;
    }

    public void setRedirectStart(long j11) {
        this.redirectStart = j11;
    }

    public void setRequestStart(long j11) {
        this.requestStart = j11;
    }

    public void setResponseEnd(long j11) {
        this.responseEnd = j11;
    }

    public void setResponseStart(long j11) {
        this.responseStart = j11;
    }

    public void setSecureConnectionStart(long j11) {
        this.secureConnectionStart = j11;
    }

    public void setUnloadEventEnd(long j11) {
        this.unloadEventEnd = j11;
    }

    public void setUnloadEventStart(long j11) {
        this.unloadEventStart = j11;
    }

    public String toString() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("-------WebView原始数据-------\n{\n\"navigationStart\":");
        sb2.append(this.navigationStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        SimpleDateFormat simpleDateFormat = f21168df;
        sb2.append(simpleDateFormat.format(Long.valueOf(this.navigationStart)));
        sb2.append(",\n \"redirectStart\":");
        sb2.append(this.redirectStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.redirectStart)));
        sb2.append(",\n \"redirectEnd\":");
        sb2.append(this.redirectEnd);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.redirectEnd)));
        sb2.append(",\n \"fetchStart\":");
        sb2.append(this.fetchStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.fetchStart)));
        sb2.append(",\n \"domainLookupStart\":");
        sb2.append(this.domainLookupStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.domainLookupStart)));
        sb2.append(",\n \"domainLookupEnd\":");
        sb2.append(this.domainLookupEnd);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.domainLookupEnd)));
        sb2.append(",\n \"connectStart\":");
        sb2.append(this.connectStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.connectStart)));
        sb2.append(",\n \"secureConnectionStart\":");
        sb2.append(this.secureConnectionStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.secureConnectionStart)));
        sb2.append(",\n \"connectEnd\":");
        sb2.append(this.connectEnd);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.connectEnd)));
        sb2.append(",\n \"requestStart\":");
        sb2.append(this.requestStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.requestStart)));
        sb2.append(",\n \"responseStart\":");
        sb2.append(this.responseStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.responseStart)));
        sb2.append(",\n \"responseEnd\":");
        sb2.append(this.responseEnd);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.responseEnd)));
        sb2.append(",\n \"unloadEventStart\":");
        sb2.append(this.unloadEventStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.unloadEventStart)));
        sb2.append(",\n \"unloadEventEnd\":");
        sb2.append(this.unloadEventEnd);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.unloadEventEnd)));
        sb2.append(",\n \"domLoading\":");
        sb2.append(this.domLoading);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.domLoading)));
        sb2.append(",\n \"domInteractive\":");
        sb2.append(this.domInteractive);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.domInteractive)));
        sb2.append(",\n \"domContentLoadedEventStart\":");
        sb2.append(this.domContentLoadedEventStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.domContentLoadedEventStart)));
        sb2.append(",\n \"domContentLoadedEventEnd\":");
        sb2.append(this.domContentLoadedEventEnd);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.domContentLoadedEventEnd)));
        sb2.append(",\n \"domComplete\":");
        sb2.append(this.domComplete);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.domComplete)));
        sb2.append(",\n \"loadEventStart\":");
        sb2.append(this.loadEventStart);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.loadEventStart)));
        sb2.append(",\n \"loadEventEnd\":");
        sb2.append(this.loadEventEnd);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.loadEventEnd)));
        sb2.append(",\n \"pageTime\":");
        sb2.append(this.pageTime);
        sb2.append(HiAnalyticsConstant.REPORT_VAL_SEPARATOR);
        sb2.append(simpleDateFormat.format(Long.valueOf(this.pageTime)));
        sb2.append('}');
        sb2.append("\n-------------------------");
        return sb2.toString();
    }
}
