package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import kotlin.Metadata;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003HÆ\u0003J\t\u0010\f\u001a\u00020\u0005HÆ\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005HÆ\u0001J\t\u0010\u000e\u001a\u00020\u000fHÖ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013HÖ\u0003J\t\u0010\u0014\u001a\u00020\u000fHÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u000fHÖ\u0001R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n¨\u0006\u001b"}, d2 = {"Lcom/kakao/sdk/template/model/Button;", "Landroid/os/Parcelable;", "title", "", "link", "Lcom/kakao/sdk/template/model/Link;", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;)V", "getLink", "()Lcom/kakao/sdk/template/model/Link;", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class Button implements Parcelable {
    public static final Parcelable.Creator<Button> CREATOR = new Creator();
    private final Link link;
    private final String title;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<Button> {
        /* renamed from: a */
        public final Button createFromParcel(Parcel parcel) {
            return new Button(parcel.readString(), Link.CREATOR.createFromParcel(parcel));
        }

        /* renamed from: b */
        public final Button[] newArray(int i11) {
            return new Button[i11];
        }
    }

    public Button(String str, Link link2) {
        this.title = str;
        this.link = link2;
    }

    public static /* synthetic */ Button copy$default(Button button, String str, Link link2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = button.title;
        }
        if ((i11 & 2) != 0) {
            link2 = button.link;
        }
        return button.copy(str, link2);
    }

    public final String component1() {
        return this.title;
    }

    public final Link component2() {
        return this.link;
    }

    public final Button copy(String str, Link link2) {
        return new Button(str, link2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof Button)) {
            return false;
        }
        Button button = (Button) obj;
        return x.b(this.title, button.title) && x.b(this.link, button.link);
    }

    public final Link getLink() {
        return this.link;
    }

    public final String getTitle() {
        return this.title;
    }

    public int hashCode() {
        return (this.title.hashCode() * 31) + this.link.hashCode();
    }

    public String toString() {
        return "Button(title=" + this.title + ", link=" + this.link + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.title);
        this.link.writeToParcel(parcel, i11);
    }
}
