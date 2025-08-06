package com.huobi.statistics.hbg.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;

public class AnalyticsExposureItem implements Serializable {
    private static final long serialVersionUID = 2492402388256556482L;
    @SerializedName("act_clazz")
    private String actClazz;
    @SerializedName("clazz")
    private String clazz;
    private long duration;
    @SerializedName("event_action")
    private String eventAction;
    @SerializedName("has_fragment")
    private boolean hasFragment;
    @SerializedName("is_child_fragment")
    private boolean isChildFragment;
    @SerializedName("is_dialog")
    private boolean isDialog;
    private boolean isFragmentCreate;
    @SerializedName("is_menu")
    private boolean isMenu;
    @SerializedName("is_multi_page_id")
    private boolean isMultiPageId;
    @SerializedName("is_page")
    private boolean isPage;
    @SerializedName("name")
    private String name;
    @SerializedName("page_id")
    private String pageId;
    private long pageStartTime;
    private long pageStopTime;
    @SerializedName("page_type")
    private int pageType;
    private String ref;

    public boolean canEqual(Object obj) {
        return obj instanceof AnalyticsExposureItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof AnalyticsExposureItem)) {
            return false;
        }
        AnalyticsExposureItem analyticsExposureItem = (AnalyticsExposureItem) obj;
        if (!analyticsExposureItem.canEqual(this)) {
            return false;
        }
        String pageId2 = getPageId();
        String pageId3 = analyticsExposureItem.getPageId();
        if (pageId2 != null ? !pageId2.equals(pageId3) : pageId3 != null) {
            return false;
        }
        String name2 = getName();
        String name3 = analyticsExposureItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        String clazz2 = getClazz();
        String clazz3 = analyticsExposureItem.getClazz();
        if (clazz2 != null ? !clazz2.equals(clazz3) : clazz3 != null) {
            return false;
        }
        if (isHasFragment() != analyticsExposureItem.isHasFragment() || isMenu() != analyticsExposureItem.isMenu() || isPage() != analyticsExposureItem.isPage() || isDialog() != analyticsExposureItem.isDialog()) {
            return false;
        }
        String actClazz2 = getActClazz();
        String actClazz3 = analyticsExposureItem.getActClazz();
        if (actClazz2 != null ? !actClazz2.equals(actClazz3) : actClazz3 != null) {
            return false;
        }
        if (isMultiPageId() != analyticsExposureItem.isMultiPageId() || getPageType() != analyticsExposureItem.getPageType() || getPageStartTime() != analyticsExposureItem.getPageStartTime() || getPageStopTime() != analyticsExposureItem.getPageStopTime() || isFragmentCreate() != analyticsExposureItem.isFragmentCreate()) {
            return false;
        }
        String ref2 = getRef();
        String ref3 = analyticsExposureItem.getRef();
        if (ref2 != null ? !ref2.equals(ref3) : ref3 != null) {
            return false;
        }
        if (getDuration() != analyticsExposureItem.getDuration()) {
            return false;
        }
        String eventAction2 = getEventAction();
        String eventAction3 = analyticsExposureItem.getEventAction();
        if (eventAction2 != null ? eventAction2.equals(eventAction3) : eventAction3 == null) {
            return isChildFragment() == analyticsExposureItem.isChildFragment();
        }
        return false;
    }

    public String getActClazz() {
        return this.actClazz;
    }

    public String getClazz() {
        return this.clazz;
    }

    public long getDuration() {
        return this.duration;
    }

    public String getEventAction() {
        return this.eventAction;
    }

    public String getName() {
        return this.name;
    }

    public String getPageId() {
        return this.pageId;
    }

    public long getPageStartTime() {
        return this.pageStartTime;
    }

    public long getPageStopTime() {
        return this.pageStopTime;
    }

    public int getPageType() {
        return this.pageType;
    }

    public String getRef() {
        return this.ref;
    }

    public int hashCode() {
        String pageId2 = getPageId();
        int i11 = 43;
        int hashCode = pageId2 == null ? 43 : pageId2.hashCode();
        String name2 = getName();
        int hashCode2 = ((hashCode + 59) * 59) + (name2 == null ? 43 : name2.hashCode());
        String clazz2 = getClazz();
        int i12 = 79;
        int hashCode3 = (((((((((hashCode2 * 59) + (clazz2 == null ? 43 : clazz2.hashCode())) * 59) + (isHasFragment() ? 79 : 97)) * 59) + (isMenu() ? 79 : 97)) * 59) + (isPage() ? 79 : 97)) * 59) + (isDialog() ? 79 : 97);
        String actClazz2 = getActClazz();
        int hashCode4 = ((hashCode3 * 59) + (actClazz2 == null ? 43 : actClazz2.hashCode())) * 59;
        int i13 = isMultiPageId() ? 79 : 97;
        long pageStartTime2 = getPageStartTime();
        int pageType2 = ((((hashCode4 + i13) * 59) + getPageType()) * 59) + ((int) (pageStartTime2 ^ (pageStartTime2 >>> 32)));
        long pageStopTime2 = getPageStopTime();
        int i14 = (((pageType2 * 59) + ((int) (pageStopTime2 ^ (pageStopTime2 >>> 32)))) * 59) + (isFragmentCreate() ? 79 : 97);
        String ref2 = getRef();
        int hashCode5 = (i14 * 59) + (ref2 == null ? 43 : ref2.hashCode());
        long duration2 = getDuration();
        String eventAction2 = getEventAction();
        int i15 = ((hashCode5 * 59) + ((int) (duration2 ^ (duration2 >>> 32)))) * 59;
        if (eventAction2 != null) {
            i11 = eventAction2.hashCode();
        }
        int i16 = (i15 + i11) * 59;
        if (!isChildFragment()) {
            i12 = 97;
        }
        return i16 + i12;
    }

    public boolean isChildFragment() {
        return this.isChildFragment;
    }

    public boolean isDialog() {
        return this.isDialog;
    }

    public boolean isFragmentCreate() {
        return this.isFragmentCreate;
    }

    public boolean isHasFragment() {
        return this.hasFragment;
    }

    public boolean isMenu() {
        return this.isMenu;
    }

    public boolean isMultiPageId() {
        return this.isMultiPageId;
    }

    public boolean isPage() {
        return this.isPage;
    }

    public void setActClazz(String str) {
        this.actClazz = str;
    }

    public void setChildFragment(boolean z11) {
        this.isChildFragment = z11;
    }

    public void setClazz(String str) {
        this.clazz = str;
    }

    public void setDialog(boolean z11) {
        this.isDialog = z11;
    }

    public void setDuration(long j11) {
        this.duration = j11;
    }

    public void setEventAction(String str) {
        this.eventAction = str;
    }

    public void setFragmentCreate(boolean z11) {
        this.isFragmentCreate = z11;
    }

    public void setHasFragment(boolean z11) {
        this.hasFragment = z11;
    }

    public void setMenu(boolean z11) {
        this.isMenu = z11;
    }

    public void setMultiPageId(boolean z11) {
        this.isMultiPageId = z11;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPage(boolean z11) {
        this.isPage = z11;
    }

    public void setPageId(String str) {
        this.pageId = str;
    }

    public void setPageStartTime(long j11) {
        this.pageStartTime = j11;
    }

    public void setPageStopTime(long j11) {
        this.pageStopTime = j11;
    }

    public void setPageType(int i11) {
        this.pageType = i11;
    }

    public void setRef(String str) {
        this.ref = str;
    }

    public String toString() {
        return "AnalyticsExposureItem(pageId=" + getPageId() + ", name=" + getName() + ", clazz=" + getClazz() + ", hasFragment=" + isHasFragment() + ", isMenu=" + isMenu() + ", isPage=" + isPage() + ", isDialog=" + isDialog() + ", actClazz=" + getActClazz() + ", isMultiPageId=" + isMultiPageId() + ", pageType=" + getPageType() + ", pageStartTime=" + getPageStartTime() + ", pageStopTime=" + getPageStopTime() + ", isFragmentCreate=" + isFragmentCreate() + ", ref=" + getRef() + ", duration=" + getDuration() + ", eventAction=" + getEventAction() + ", isChildFragment=" + isChildFragment() + ")";
    }
}
