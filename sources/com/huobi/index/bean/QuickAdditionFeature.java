package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Keep
public class QuickAdditionFeature {
    public static final int ACCOUNT_STEP_RATE = 5;
    public static final int INDEX_FIAT = 7;
    public static final int INDEX_GUIDE_NEW = 12;
    public static final int INDEX_QUICK = 8;
    public static final int PROMOTE_FEATURE = 6;
    public static final int TRADE_HOT = 4;
    private String androidMinVersion;
    private String androidVersion;

    /* renamed from: id  reason: collision with root package name */
    private int f73206id;
    private String onlineName;
    @SerializedName("contentList")
    private List<QuickAdditionItem> quickAdditionItems;

    public boolean canEqual(Object obj) {
        return obj instanceof QuickAdditionFeature;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuickAdditionFeature)) {
            return false;
        }
        QuickAdditionFeature quickAdditionFeature = (QuickAdditionFeature) obj;
        if (!quickAdditionFeature.canEqual(this) || getId() != quickAdditionFeature.getId()) {
            return false;
        }
        String onlineName2 = getOnlineName();
        String onlineName3 = quickAdditionFeature.getOnlineName();
        if (onlineName2 != null ? !onlineName2.equals(onlineName3) : onlineName3 != null) {
            return false;
        }
        String androidVersion2 = getAndroidVersion();
        String androidVersion3 = quickAdditionFeature.getAndroidVersion();
        if (androidVersion2 != null ? !androidVersion2.equals(androidVersion3) : androidVersion3 != null) {
            return false;
        }
        String androidMinVersion2 = getAndroidMinVersion();
        String androidMinVersion3 = quickAdditionFeature.getAndroidMinVersion();
        if (androidMinVersion2 != null ? !androidMinVersion2.equals(androidMinVersion3) : androidMinVersion3 != null) {
            return false;
        }
        List<QuickAdditionItem> quickAdditionItems2 = getQuickAdditionItems();
        List<QuickAdditionItem> quickAdditionItems3 = quickAdditionFeature.getQuickAdditionItems();
        return quickAdditionItems2 != null ? quickAdditionItems2.equals(quickAdditionItems3) : quickAdditionItems3 == null;
    }

    public String getAndroidMinVersion() {
        return this.androidMinVersion;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public int getId() {
        return this.f73206id;
    }

    public String getOnlineName() {
        return this.onlineName;
    }

    public List<QuickAdditionItem> getQuickAdditionItems() {
        return this.quickAdditionItems;
    }

    public int hashCode() {
        String onlineName2 = getOnlineName();
        int i11 = 43;
        int id2 = ((getId() + 59) * 59) + (onlineName2 == null ? 43 : onlineName2.hashCode());
        String androidVersion2 = getAndroidVersion();
        int hashCode = (id2 * 59) + (androidVersion2 == null ? 43 : androidVersion2.hashCode());
        String androidMinVersion2 = getAndroidMinVersion();
        int hashCode2 = (hashCode * 59) + (androidMinVersion2 == null ? 43 : androidMinVersion2.hashCode());
        List<QuickAdditionItem> quickAdditionItems2 = getQuickAdditionItems();
        int i12 = hashCode2 * 59;
        if (quickAdditionItems2 != null) {
            i11 = quickAdditionItems2.hashCode();
        }
        return i12 + i11;
    }

    public void setAndroidMinVersion(String str) {
        this.androidMinVersion = str;
    }

    public void setAndroidVersion(String str) {
        this.androidVersion = str;
    }

    public void setId(int i11) {
        this.f73206id = i11;
    }

    public void setOnlineName(String str) {
        this.onlineName = str;
    }

    public void setQuickAdditionItems(List<QuickAdditionItem> list) {
        this.quickAdditionItems = list;
    }

    public String toString() {
        return "QuickAdditionFeature(id=" + getId() + ", onlineName=" + getOnlineName() + ", androidVersion=" + getAndroidVersion() + ", androidMinVersion=" + getAndroidMinVersion() + ", quickAdditionItems=" + getQuickAdditionItems() + ")";
    }
}
