package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.List;

@Keep
public class IndexFeature {
    public static final String ACCOUNT_FIXED_QUICK = "20220629";
    public static final int ACCOUNT_NEW_QUICK = 2949;
    public static final String ACCOUNT_NEW_QUICK_STR = "02949";
    public static final int ACCOUNT_QUICK = 11111;
    public static final int ACCOUNT_STEP_RATE = 5;
    public static final int INDEX_FIAT = 7;
    public static final int INDEX_GUIDE_NEW = 12;
    public static final int INDEX_QUICK = 8;
    public static final int PROMOTE_FEATURE = 6;
    public static final int TRADE_HOT = 4;
    private String androidMinVersion;
    private String androidVersion;

    /* renamed from: id  reason: collision with root package name */
    private int f73182id;
    @SerializedName("contentList")
    private List<IndexFeatureItem> indexFeatureItems;
    private String onlineName;

    public boolean canEqual(Object obj) {
        return obj instanceof IndexFeature;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof IndexFeature)) {
            return false;
        }
        IndexFeature indexFeature = (IndexFeature) obj;
        if (!indexFeature.canEqual(this) || getId() != indexFeature.getId()) {
            return false;
        }
        String onlineName2 = getOnlineName();
        String onlineName3 = indexFeature.getOnlineName();
        if (onlineName2 != null ? !onlineName2.equals(onlineName3) : onlineName3 != null) {
            return false;
        }
        String androidVersion2 = getAndroidVersion();
        String androidVersion3 = indexFeature.getAndroidVersion();
        if (androidVersion2 != null ? !androidVersion2.equals(androidVersion3) : androidVersion3 != null) {
            return false;
        }
        String androidMinVersion2 = getAndroidMinVersion();
        String androidMinVersion3 = indexFeature.getAndroidMinVersion();
        if (androidMinVersion2 != null ? !androidMinVersion2.equals(androidMinVersion3) : androidMinVersion3 != null) {
            return false;
        }
        List<IndexFeatureItem> indexFeatureItems2 = getIndexFeatureItems();
        List<IndexFeatureItem> indexFeatureItems3 = indexFeature.getIndexFeatureItems();
        return indexFeatureItems2 != null ? indexFeatureItems2.equals(indexFeatureItems3) : indexFeatureItems3 == null;
    }

    public String getAndroidMinVersion() {
        return this.androidMinVersion;
    }

    public String getAndroidVersion() {
        return this.androidVersion;
    }

    public int getId() {
        return this.f73182id;
    }

    public List<IndexFeatureItem> getIndexFeatureItems() {
        return this.indexFeatureItems;
    }

    public String getOnlineName() {
        return this.onlineName;
    }

    public int hashCode() {
        String onlineName2 = getOnlineName();
        int i11 = 43;
        int id2 = ((getId() + 59) * 59) + (onlineName2 == null ? 43 : onlineName2.hashCode());
        String androidVersion2 = getAndroidVersion();
        int hashCode = (id2 * 59) + (androidVersion2 == null ? 43 : androidVersion2.hashCode());
        String androidMinVersion2 = getAndroidMinVersion();
        int hashCode2 = (hashCode * 59) + (androidMinVersion2 == null ? 43 : androidMinVersion2.hashCode());
        List<IndexFeatureItem> indexFeatureItems2 = getIndexFeatureItems();
        int i12 = hashCode2 * 59;
        if (indexFeatureItems2 != null) {
            i11 = indexFeatureItems2.hashCode();
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
        this.f73182id = i11;
    }

    public void setIndexFeatureItems(List<IndexFeatureItem> list) {
        this.indexFeatureItems = list;
    }

    public void setOnlineName(String str) {
        this.onlineName = str;
    }

    public String toString() {
        return "IndexFeature(id=" + getId() + ", onlineName=" + getOnlineName() + ", androidVersion=" + getAndroidVersion() + ", androidMinVersion=" + getAndroidMinVersion() + ", indexFeatureItems=" + getIndexFeatureItems() + ")";
    }
}
