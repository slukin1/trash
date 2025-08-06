package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u0019"}, d2 = {"Lcom/kakao/sdk/template/model/ItemInfo;", "Landroid/os/Parcelable;", "item", "", "itemOp", "(Ljava/lang/String;Ljava/lang/String;)V", "getItem", "()Ljava/lang/String;", "getItemOp", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemInfo implements Parcelable {
    public static final Parcelable.Creator<ItemInfo> CREATOR = new Creator();
    private final String item;
    private final String itemOp;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ItemInfo> {
        /* renamed from: a */
        public final ItemInfo createFromParcel(Parcel parcel) {
            return new ItemInfo(parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final ItemInfo[] newArray(int i11) {
            return new ItemInfo[i11];
        }
    }

    public ItemInfo(String str, String str2) {
        this.item = str;
        this.itemOp = str2;
    }

    public static /* synthetic */ ItemInfo copy$default(ItemInfo itemInfo, String str, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = itemInfo.item;
        }
        if ((i11 & 2) != 0) {
            str2 = itemInfo.itemOp;
        }
        return itemInfo.copy(str, str2);
    }

    public final String component1() {
        return this.item;
    }

    public final String component2() {
        return this.itemOp;
    }

    public final ItemInfo copy(String str, String str2) {
        return new ItemInfo(str, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemInfo)) {
            return false;
        }
        ItemInfo itemInfo = (ItemInfo) obj;
        return x.b(this.item, itemInfo.item) && x.b(this.itemOp, itemInfo.itemOp);
    }

    public final String getItem() {
        return this.item;
    }

    public final String getItemOp() {
        return this.itemOp;
    }

    public int hashCode() {
        return (this.item.hashCode() * 31) + this.itemOp.hashCode();
    }

    public String toString() {
        return "ItemInfo(item=" + this.item + ", itemOp=" + this.itemOp + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.item);
        parcel.writeString(this.itemOp);
    }
}
