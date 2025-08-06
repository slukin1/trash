package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BK\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJ\u0010\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003¢\u0006\u0002\u0010\u000fJT\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0001¢\u0006\u0002\u0010\u001dJ\t\u0010\u001e\u001a\u00020\tHÖ\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"HÖ\u0003J\t\u0010#\u001a\u00020\tHÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001J\u0019\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\tHÖ\u0001R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0015\u0010\n\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\rR\u0015\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\n\n\u0002\u0010\u0010\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\r¨\u0006*"}, d2 = {"Lcom/kakao/sdk/template/model/Content;", "Landroid/os/Parcelable;", "title", "", "imageUrl", "link", "Lcom/kakao/sdk/template/model/Link;", "description", "imageWidth", "", "imageHeight", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)V", "getDescription", "()Ljava/lang/String;", "getImageHeight", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getImageUrl", "getImageWidth", "getLink", "()Lcom/kakao/sdk/template/model/Link;", "getTitle", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "(Ljava/lang/String;Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;)Lcom/kakao/sdk/template/model/Content;", "describeContents", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Content implements Parcelable {
    public static final Parcelable.Creator<Content> CREATOR = new Creator();
    private final String description;
    private final Integer imageHeight;
    private final String imageUrl;
    private final Integer imageWidth;
    private final Link link;
    private final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Content> {
        /* renamed from: a */
        public final Content createFromParcel(Parcel parcel) {
            return new Content(parcel.readString(), parcel.readString(), Link.CREATOR.createFromParcel(parcel), parcel.readString(), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()), parcel.readInt() == 0 ? null : Integer.valueOf(parcel.readInt()));
        }

        /* renamed from: b */
        public final Content[] newArray(int i11) {
            return new Content[i11];
        }
    }

    public Content(Link link2) {
        this((String) null, (String) null, link2, (String) null, (Integer) null, (Integer) null, 59, (r) null);
    }

    public Content(String str, Link link2) {
        this(str, (String) null, link2, (String) null, (Integer) null, (Integer) null, 58, (r) null);
    }

    public Content(String str, String str2, Link link2) {
        this(str, str2, link2, (String) null, (Integer) null, (Integer) null, 56, (r) null);
    }

    public Content(String str, String str2, Link link2, String str3) {
        this(str, str2, link2, str3, (Integer) null, (Integer) null, 48, (r) null);
    }

    public Content(String str, String str2, Link link2, String str3, Integer num) {
        this(str, str2, link2, str3, num, (Integer) null, 32, (r) null);
    }

    public Content(String str, String str2, Link link2, String str3, Integer num, Integer num2) {
        this.title = str;
        this.imageUrl = str2;
        this.link = link2;
        this.description = str3;
        this.imageWidth = num;
        this.imageHeight = num2;
    }

    public static /* synthetic */ Content copy$default(Content content, String str, String str2, Link link2, String str3, Integer num, Integer num2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = content.title;
        }
        if ((i11 & 2) != 0) {
            str2 = content.imageUrl;
        }
        String str4 = str2;
        if ((i11 & 4) != 0) {
            link2 = content.link;
        }
        Link link3 = link2;
        if ((i11 & 8) != 0) {
            str3 = content.description;
        }
        String str5 = str3;
        if ((i11 & 16) != 0) {
            num = content.imageWidth;
        }
        Integer num3 = num;
        if ((i11 & 32) != 0) {
            num2 = content.imageHeight;
        }
        return content.copy(str, str4, link3, str5, num3, num2);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.imageUrl;
    }

    public final Link component3() {
        return this.link;
    }

    public final String component4() {
        return this.description;
    }

    public final Integer component5() {
        return this.imageWidth;
    }

    public final Integer component6() {
        return this.imageHeight;
    }

    public final Content copy(String str, String str2, Link link2, String str3, Integer num, Integer num2) {
        return new Content(str, str2, link2, str3, num, num2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Content)) {
            return false;
        }
        Content content = (Content) obj;
        return x.b(this.title, content.title) && x.b(this.imageUrl, content.imageUrl) && x.b(this.link, content.link) && x.b(this.description, content.description) && x.b(this.imageWidth, content.imageWidth) && x.b(this.imageHeight, content.imageHeight);
    }

    public final String getDescription() {
        return this.description;
    }

    public final Integer getImageHeight() {
        return this.imageHeight;
    }

    public final String getImageUrl() {
        return this.imageUrl;
    }

    public final Integer getImageWidth() {
        return this.imageWidth;
    }

    public final Link getLink() {
        return this.link;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.imageUrl;
        int hashCode2 = (((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.link.hashCode()) * 31;
        String str3 = this.description;
        int hashCode3 = (hashCode2 + (str3 == null ? 0 : str3.hashCode())) * 31;
        Integer num = this.imageWidth;
        int hashCode4 = (hashCode3 + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.imageHeight;
        if (num2 != null) {
            i11 = num2.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "Content(title=" + this.title + ", imageUrl=" + this.imageUrl + ", link=" + this.link + ", description=" + this.description + ", imageWidth=" + this.imageWidth + ", imageHeight=" + this.imageHeight + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.title);
        parcel.writeString(this.imageUrl);
        this.link.writeToParcel(parcel, i11);
        parcel.writeString(this.description);
        Integer num = this.imageWidth;
        if (num == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(num.intValue());
        }
        Integer num2 = this.imageHeight;
        if (num2 == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(num2.intValue());
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ Content(String str, String str2, Link link2, String str3, Integer num, Integer num2, int i11, r rVar) {
        this((i11 & 1) != 0 ? null : str, (i11 & 2) != 0 ? null : str2, link2, (i11 & 8) != 0 ? null : str3, (i11 & 16) != 0 ? null : num, (i11 & 32) != 0 ? null : num2);
    }
}
