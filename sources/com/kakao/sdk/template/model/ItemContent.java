package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001Bm\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\rJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\tHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0003HÆ\u0003Jo\u0010 \u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\t\u0010!\u001a\u00020\"HÖ\u0001J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010&HÖ\u0003J\t\u0010'\u001a\u00020\"HÖ\u0001J\t\u0010(\u001a\u00020\u0003HÖ\u0001J\u0019\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\"HÖ\u0001R\u0019\u0010\b\u001a\n\u0012\u0004\u0012\u00020\n\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0011¨\u0006."}, d2 = {"Lcom/kakao/sdk/template/model/ItemContent;", "Landroid/os/Parcelable;", "profileText", "", "profileImageUrl", "titleImageText", "titleImageUrl", "titleImageCategory", "items", "", "Lcom/kakao/sdk/template/model/ItemInfo;", "sum", "sumOp", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;)V", "getItems", "()Ljava/util/List;", "getProfileImageUrl", "()Ljava/lang/String;", "getProfileText", "getSum", "getSumOp", "getTitleImageCategory", "getTitleImageText", "getTitleImageUrl", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ItemContent implements Parcelable {
    public static final Parcelable.Creator<ItemContent> CREATOR = new Creator();
    private final List<ItemInfo> items;
    private final String profileImageUrl;
    private final String profileText;
    private final String sum;
    private final String sumOp;
    private final String titleImageCategory;
    private final String titleImageText;
    private final String titleImageUrl;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ItemContent> {
        /* renamed from: a */
        public final ItemContent createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            String readString3 = parcel.readString();
            String readString4 = parcel.readString();
            String readString5 = parcel.readString();
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(ItemInfo.CREATOR.createFromParcel(parcel));
                }
            }
            return new ItemContent(readString, readString2, readString3, readString4, readString5, arrayList, parcel.readString(), parcel.readString());
        }

        /* renamed from: b */
        public final ItemContent[] newArray(int i11) {
            return new ItemContent[i11];
        }
    }

    public ItemContent() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 255, (r) null);
    }

    public ItemContent(String str) {
        this(str, (String) null, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 254, (r) null);
    }

    public ItemContent(String str, String str2) {
        this(str, str2, (String) null, (String) null, (String) null, (List) null, (String) null, (String) null, 252, (r) null);
    }

    public ItemContent(String str, String str2, String str3) {
        this(str, str2, str3, (String) null, (String) null, (List) null, (String) null, (String) null, 248, (r) null);
    }

    public ItemContent(String str, String str2, String str3, String str4) {
        this(str, str2, str3, str4, (String) null, (List) null, (String) null, (String) null, 240, (r) null);
    }

    public ItemContent(String str, String str2, String str3, String str4, String str5) {
        this(str, str2, str3, str4, str5, (List) null, (String) null, (String) null, 224, (r) null);
    }

    public ItemContent(String str, String str2, String str3, String str4, String str5, List<ItemInfo> list) {
        this(str, str2, str3, str4, str5, list, (String) null, (String) null, 192, (r) null);
    }

    public ItemContent(String str, String str2, String str3, String str4, String str5, List<ItemInfo> list, String str6) {
        this(str, str2, str3, str4, str5, list, str6, (String) null, 128, (r) null);
    }

    public ItemContent(String str, String str2, String str3, String str4, String str5, List<ItemInfo> list, String str6, String str7) {
        this.profileText = str;
        this.profileImageUrl = str2;
        this.titleImageText = str3;
        this.titleImageUrl = str4;
        this.titleImageCategory = str5;
        this.items = list;
        this.sum = str6;
        this.sumOp = str7;
    }

    public static /* synthetic */ ItemContent copy$default(ItemContent itemContent, String str, String str2, String str3, String str4, String str5, List list, String str6, String str7, int i11, Object obj) {
        ItemContent itemContent2 = itemContent;
        int i12 = i11;
        return itemContent.copy((i12 & 1) != 0 ? itemContent2.profileText : str, (i12 & 2) != 0 ? itemContent2.profileImageUrl : str2, (i12 & 4) != 0 ? itemContent2.titleImageText : str3, (i12 & 8) != 0 ? itemContent2.titleImageUrl : str4, (i12 & 16) != 0 ? itemContent2.titleImageCategory : str5, (i12 & 32) != 0 ? itemContent2.items : list, (i12 & 64) != 0 ? itemContent2.sum : str6, (i12 & 128) != 0 ? itemContent2.sumOp : str7);
    }

    public final String component1() {
        return this.profileText;
    }

    public final String component2() {
        return this.profileImageUrl;
    }

    public final String component3() {
        return this.titleImageText;
    }

    public final String component4() {
        return this.titleImageUrl;
    }

    public final String component5() {
        return this.titleImageCategory;
    }

    public final List<ItemInfo> component6() {
        return this.items;
    }

    public final String component7() {
        return this.sum;
    }

    public final String component8() {
        return this.sumOp;
    }

    public final ItemContent copy(String str, String str2, String str3, String str4, String str5, List<ItemInfo> list, String str6, String str7) {
        return new ItemContent(str, str2, str3, str4, str5, list, str6, str7);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ItemContent)) {
            return false;
        }
        ItemContent itemContent = (ItemContent) obj;
        return x.b(this.profileText, itemContent.profileText) && x.b(this.profileImageUrl, itemContent.profileImageUrl) && x.b(this.titleImageText, itemContent.titleImageText) && x.b(this.titleImageUrl, itemContent.titleImageUrl) && x.b(this.titleImageCategory, itemContent.titleImageCategory) && x.b(this.items, itemContent.items) && x.b(this.sum, itemContent.sum) && x.b(this.sumOp, itemContent.sumOp);
    }

    public final List<ItemInfo> getItems() {
        return this.items;
    }

    public final String getProfileImageUrl() {
        return this.profileImageUrl;
    }

    public final String getProfileText() {
        return this.profileText;
    }

    public final String getSum() {
        return this.sum;
    }

    public final String getSumOp() {
        return this.sumOp;
    }

    public final String getTitleImageCategory() {
        return this.titleImageCategory;
    }

    public final String getTitleImageText() {
        return this.titleImageText;
    }

    public final String getTitleImageUrl() {
        return this.titleImageUrl;
    }

    public int hashCode() {
        String str = this.profileText;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.profileImageUrl;
        int hashCode2 = (hashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        String str3 = this.titleImageText;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        String str4 = this.titleImageUrl;
        int hashCode4 = (hashCode3 + (str4 == null ? 0 : str4.hashCode())) * 31;
        String str5 = this.titleImageCategory;
        int hashCode5 = (hashCode4 + (str5 == null ? 0 : str5.hashCode())) * 31;
        List<ItemInfo> list = this.items;
        int hashCode6 = (hashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        String str6 = this.sum;
        int hashCode7 = (hashCode6 + (str6 == null ? 0 : str6.hashCode())) * 31;
        String str7 = this.sumOp;
        if (str7 != null) {
            i11 = str7.hashCode();
        }
        return hashCode7 + i11;
    }

    public String toString() {
        return "ItemContent(profileText=" + this.profileText + ", profileImageUrl=" + this.profileImageUrl + ", titleImageText=" + this.titleImageText + ", titleImageUrl=" + this.titleImageUrl + ", titleImageCategory=" + this.titleImageCategory + ", items=" + this.items + ", sum=" + this.sum + ", sumOp=" + this.sumOp + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.profileText);
        parcel.writeString(this.profileImageUrl);
        parcel.writeString(this.titleImageText);
        parcel.writeString(this.titleImageUrl);
        parcel.writeString(this.titleImageCategory);
        List<ItemInfo> list = this.items;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (ItemInfo writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i11);
            }
        }
        parcel.writeString(this.sum);
        parcel.writeString(this.sumOp);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ ItemContent(java.lang.String r10, java.lang.String r11, java.lang.String r12, java.lang.String r13, java.lang.String r14, java.util.List r15, java.lang.String r16, java.lang.String r17, int r18, kotlin.jvm.internal.r r19) {
        /*
            r9 = this;
            r0 = r18
            r1 = r0 & 1
            r2 = 0
            if (r1 == 0) goto L_0x0009
            r1 = r2
            goto L_0x000a
        L_0x0009:
            r1 = r10
        L_0x000a:
            r3 = r0 & 2
            if (r3 == 0) goto L_0x0010
            r3 = r2
            goto L_0x0011
        L_0x0010:
            r3 = r11
        L_0x0011:
            r4 = r0 & 4
            if (r4 == 0) goto L_0x0017
            r4 = r2
            goto L_0x0018
        L_0x0017:
            r4 = r12
        L_0x0018:
            r5 = r0 & 8
            if (r5 == 0) goto L_0x001e
            r5 = r2
            goto L_0x001f
        L_0x001e:
            r5 = r13
        L_0x001f:
            r6 = r0 & 16
            if (r6 == 0) goto L_0x0025
            r6 = r2
            goto L_0x0026
        L_0x0025:
            r6 = r14
        L_0x0026:
            r7 = r0 & 32
            if (r7 == 0) goto L_0x002c
            r7 = r2
            goto L_0x002d
        L_0x002c:
            r7 = r15
        L_0x002d:
            r8 = r0 & 64
            if (r8 == 0) goto L_0x0033
            r8 = r2
            goto L_0x0035
        L_0x0033:
            r8 = r16
        L_0x0035:
            r0 = r0 & 128(0x80, float:1.794E-43)
            if (r0 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r2 = r17
        L_0x003c:
            r10 = r9
            r11 = r1
            r12 = r3
            r13 = r4
            r14 = r5
            r15 = r6
            r16 = r7
            r17 = r8
            r18 = r2
            r10.<init>(r11, r12, r13, r14, r15, r16, r17, r18)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.kakao.sdk.template.model.ItemContent.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.util.List, java.lang.String, java.lang.String, int, kotlin.jvm.internal.r):void");
    }
}
