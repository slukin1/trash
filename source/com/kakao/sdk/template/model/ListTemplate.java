package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0015\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BC\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\rJ\t\u0010\u001a\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0006HÆ\u0003J\u000f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\u0011\u0010\u001d\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0004HÆ\u0003JK\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001J\u0013\u0010\"\u001a\u00020#2\b\u0010$\u001a\u0004\u0018\u00010%HÖ\u0003J\t\u0010&\u001a\u00020!HÖ\u0001J\t\u0010'\u001a\u00020\u0004HÖ\u0001J\u0019\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u001a\u0010\u0016\u001a\u00020\u0004XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0019\u0010\u000f¨\u0006-"}, d2 = {"Lcom/kakao/sdk/template/model/ListTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "headerTitle", "", "headerLink", "Lcom/kakao/sdk/template/model/Link;", "contents", "", "Lcom/kakao/sdk/template/model/Content;", "buttons", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getContents", "getHeaderLink", "()Lcom/kakao/sdk/template/model/Link;", "getHeaderTitle", "objectType", "getObjectType$annotations", "()V", "getObjectType", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class ListTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<ListTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final List<Content> contents;
    private final Link headerLink;
    private final String headerTitle;
    private final String objectType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<ListTemplate> {
        /* renamed from: a */
        public final ListTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String readString = parcel.readString();
            Link createFromParcel = Link.CREATOR.createFromParcel(parcel);
            int readInt = parcel.readInt();
            ArrayList arrayList2 = new ArrayList(readInt);
            for (int i11 = 0; i11 != readInt; i11++) {
                arrayList2.add(Content.CREATOR.createFromParcel(parcel));
            }
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt2 = parcel.readInt();
                ArrayList arrayList3 = new ArrayList(readInt2);
                for (int i12 = 0; i12 != readInt2; i12++) {
                    arrayList3.add(Button.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList3;
            }
            return new ListTemplate(readString, createFromParcel, arrayList2, arrayList, parcel.readString());
        }

        /* renamed from: b */
        public final ListTemplate[] newArray(int i11) {
            return new ListTemplate[i11];
        }
    }

    public ListTemplate(String str, Link link, List<Content> list) {
        this(str, link, list, (List) null, (String) null, 24, (r) null);
    }

    public ListTemplate(String str, Link link, List<Content> list, List<Button> list2) {
        this(str, link, list, list2, (String) null, 16, (r) null);
    }

    public ListTemplate(String str, Link link, List<Content> list, List<Button> list2, String str2) {
        this.headerTitle = str;
        this.headerLink = link;
        this.contents = list;
        this.buttons = list2;
        this.buttonTitle = str2;
        this.objectType = "list";
    }

    public static /* synthetic */ ListTemplate copy$default(ListTemplate listTemplate, String str, Link link, List<Content> list, List<Button> list2, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = listTemplate.headerTitle;
        }
        if ((i11 & 2) != 0) {
            link = listTemplate.headerLink;
        }
        Link link2 = link;
        if ((i11 & 4) != 0) {
            list = listTemplate.contents;
        }
        List<Content> list3 = list;
        if ((i11 & 8) != 0) {
            list2 = listTemplate.buttons;
        }
        List<Button> list4 = list2;
        if ((i11 & 16) != 0) {
            str2 = listTemplate.buttonTitle;
        }
        return listTemplate.copy(str, link2, list3, list4, str2);
    }

    public static /* synthetic */ void getObjectType$annotations() {
    }

    public final String component1() {
        return this.headerTitle;
    }

    public final Link component2() {
        return this.headerLink;
    }

    public final List<Content> component3() {
        return this.contents;
    }

    public final List<Button> component4() {
        return this.buttons;
    }

    public final String component5() {
        return this.buttonTitle;
    }

    public final ListTemplate copy(String str, Link link, List<Content> list, List<Button> list2, String str2) {
        return new ListTemplate(str, link, list, list2, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof ListTemplate)) {
            return false;
        }
        ListTemplate listTemplate = (ListTemplate) obj;
        return x.b(this.headerTitle, listTemplate.headerTitle) && x.b(this.headerLink, listTemplate.headerLink) && x.b(this.contents, listTemplate.contents) && x.b(this.buttons, listTemplate.buttons) && x.b(this.buttonTitle, listTemplate.buttonTitle);
    }

    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    public final List<Button> getButtons() {
        return this.buttons;
    }

    public final List<Content> getContents() {
        return this.contents;
    }

    public final Link getHeaderLink() {
        return this.headerLink;
    }

    public final String getHeaderTitle() {
        return this.headerTitle;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public int hashCode() {
        int hashCode = ((((this.headerTitle.hashCode() * 31) + this.headerLink.hashCode()) * 31) + this.contents.hashCode()) * 31;
        List<Button> list = this.buttons;
        int i11 = 0;
        int hashCode2 = (hashCode + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.buttonTitle;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode2 + i11;
    }

    public String toString() {
        return "ListTemplate(headerTitle=" + this.headerTitle + ", headerLink=" + this.headerLink + ", contents=" + this.contents + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.headerTitle);
        this.headerLink.writeToParcel(parcel, i11);
        List<Content> list = this.contents;
        parcel.writeInt(list.size());
        for (Content writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
        List<Button> list2 = this.buttons;
        if (list2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list2.size());
            for (Button writeToParcel2 : list2) {
                writeToParcel2.writeToParcel(parcel, i11);
            }
        }
        parcel.writeString(this.buttonTitle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ListTemplate(String str, Link link, List list, List list2, String str2, int i11, r rVar) {
        this(str, link, list, (i11 & 8) != 0 ? null : list2, (i11 & 16) != 0 ? null : str2);
    }
}
