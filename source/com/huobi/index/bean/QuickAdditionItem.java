package com.huobi.index.bean;

import androidx.annotation.Keep;
import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;

@Keep
public class QuickAdditionItem {
    @SerializedName("list")
    private ArrayList<IndexFeatureItem> indexFeatureItems;
    private String name;

    public boolean canEqual(Object obj) {
        return obj instanceof QuickAdditionItem;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof QuickAdditionItem)) {
            return false;
        }
        QuickAdditionItem quickAdditionItem = (QuickAdditionItem) obj;
        if (!quickAdditionItem.canEqual(this)) {
            return false;
        }
        String name2 = getName();
        String name3 = quickAdditionItem.getName();
        if (name2 != null ? !name2.equals(name3) : name3 != null) {
            return false;
        }
        ArrayList<IndexFeatureItem> indexFeatureItems2 = getIndexFeatureItems();
        ArrayList<IndexFeatureItem> indexFeatureItems3 = quickAdditionItem.getIndexFeatureItems();
        return indexFeatureItems2 != null ? indexFeatureItems2.equals(indexFeatureItems3) : indexFeatureItems3 == null;
    }

    public ArrayList<IndexFeatureItem> getIndexFeatureItems() {
        return this.indexFeatureItems;
    }

    public String getName() {
        return this.name;
    }

    public int hashCode() {
        String name2 = getName();
        int i11 = 43;
        int hashCode = name2 == null ? 43 : name2.hashCode();
        ArrayList<IndexFeatureItem> indexFeatureItems2 = getIndexFeatureItems();
        int i12 = (hashCode + 59) * 59;
        if (indexFeatureItems2 != null) {
            i11 = indexFeatureItems2.hashCode();
        }
        return i12 + i11;
    }

    public void setIndexFeatureItems(ArrayList<IndexFeatureItem> arrayList) {
        this.indexFeatureItems = arrayList;
    }

    public void setName(String str) {
        this.name = str;
    }

    public String toString() {
        return "QuickAdditionItem(name=" + getName() + ", indexFeatureItems=" + getIndexFeatureItems() + ")";
    }
}
