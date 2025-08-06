package com.huobi.invite.bean;

import com.huobi.social.share.HBShareHelper;
import java.io.Serializable;

public class SharePlatformItem implements s9.a, Serializable, Comparable<SharePlatformItem> {
    private a callback;
    private int clickCount;
    private int count;
    private boolean main;
    private HBShareHelper.HbPlatform platform;
    private int resourceId;
    private String title;

    public interface a {
        void i0(HBShareHelper.HbPlatform hbPlatform);
    }

    public boolean canEqual(Object obj) {
        return obj instanceof SharePlatformItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof SharePlatformItem)) {
            return false;
        }
        SharePlatformItem sharePlatformItem = (SharePlatformItem) obj;
        if (!sharePlatformItem.canEqual(this) || getCount() != sharePlatformItem.getCount() || isMain() != sharePlatformItem.isMain()) {
            return false;
        }
        HBShareHelper.HbPlatform platform2 = getPlatform();
        HBShareHelper.HbPlatform platform3 = sharePlatformItem.getPlatform();
        if (platform2 != null ? !platform2.equals(platform3) : platform3 != null) {
            return false;
        }
        if (getResourceId() != sharePlatformItem.getResourceId()) {
            return false;
        }
        String title2 = getTitle();
        String title3 = sharePlatformItem.getTitle();
        if (title2 != null ? !title2.equals(title3) : title3 != null) {
            return false;
        }
        a callback2 = getCallback();
        a callback3 = sharePlatformItem.getCallback();
        if (callback2 != null ? callback2.equals(callback3) : callback3 == null) {
            return getClickCount() == sharePlatformItem.getClickCount();
        }
        return false;
    }

    public a getCallback() {
        return this.callback;
    }

    public int getClickCount() {
        return this.clickCount;
    }

    public int getCount() {
        return this.count;
    }

    public HBShareHelper.HbPlatform getPlatform() {
        return this.platform;
    }

    public int getResourceId() {
        return this.resourceId;
    }

    public String getTitle() {
        return this.title;
    }

    public String getViewHandlerName() {
        return SharePlatformHandler.class.getName();
    }

    public int hashCode() {
        int count2 = ((getCount() + 59) * 59) + (isMain() ? 79 : 97);
        HBShareHelper.HbPlatform platform2 = getPlatform();
        int i11 = 43;
        int hashCode = (((count2 * 59) + (platform2 == null ? 43 : platform2.hashCode())) * 59) + getResourceId();
        String title2 = getTitle();
        int hashCode2 = (hashCode * 59) + (title2 == null ? 43 : title2.hashCode());
        a callback2 = getCallback();
        int i12 = hashCode2 * 59;
        if (callback2 != null) {
            i11 = callback2.hashCode();
        }
        return ((i12 + i11) * 59) + getClickCount();
    }

    public boolean isMain() {
        return this.main;
    }

    public void setCallback(a aVar) {
        this.callback = aVar;
    }

    public void setClickCount(int i11) {
        this.clickCount = i11;
    }

    public void setCount(int i11) {
        this.count = i11;
    }

    public void setMain(boolean z11) {
        this.main = z11;
    }

    public void setPlatform(HBShareHelper.HbPlatform hbPlatform) {
        this.platform = hbPlatform;
    }

    public void setResourceId(int i11) {
        this.resourceId = i11;
    }

    public void setTitle(String str) {
        this.title = str;
    }

    public String toString() {
        return "SharePlatformItem(count=" + getCount() + ", main=" + isMain() + ", platform=" + getPlatform() + ", resourceId=" + getResourceId() + ", title=" + getTitle() + ", callback=" + getCallback() + ", clickCount=" + getClickCount() + ")";
    }

    public int compareTo(SharePlatformItem sharePlatformItem) {
        return sharePlatformItem.clickCount - this.clickCount;
    }
}
