package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000bJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0004HÆ\u0003J;\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020\u001dHÖ\u0001J\t\u0010#\u001a\u00020\u0004HÖ\u0001J\u0019\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u001dHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0004XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u0015\u0010\rR\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\r¨\u0006)"}, d2 = {"Lcom/kakao/sdk/template/model/TextTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "text", "", "link", "Lcom/kakao/sdk/template/model/Link;", "buttons", "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Link;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getLink", "()Lcom/kakao/sdk/template/model/Link;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "getText", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class TextTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<TextTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Link link;
    private final String objectType;
    private final String text;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<TextTemplate> {
        /* renamed from: a */
        public final TextTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String readString = parcel.readString();
            Link createFromParcel = Link.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() == 0) {
                arrayList = null;
            } else {
                int readInt = parcel.readInt();
                ArrayList arrayList2 = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList2.add(Button.CREATOR.createFromParcel(parcel));
                }
                arrayList = arrayList2;
            }
            return new TextTemplate(readString, createFromParcel, arrayList, parcel.readString());
        }

        /* renamed from: b */
        public final TextTemplate[] newArray(int i11) {
            return new TextTemplate[i11];
        }
    }

    public TextTemplate(String str, Link link2) {
        this(str, link2, (List) null, (String) null, 12, (r) null);
    }

    public TextTemplate(String str, Link link2, List<Button> list) {
        this(str, link2, list, (String) null, 8, (r) null);
    }

    public TextTemplate(String str, Link link2, List<Button> list, String str2) {
        this.text = str;
        this.link = link2;
        this.buttons = list;
        this.buttonTitle = str2;
        this.objectType = "text";
    }

    public static /* synthetic */ TextTemplate copy$default(TextTemplate textTemplate, String str, Link link2, List<Button> list, String str2, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = textTemplate.text;
        }
        if ((i11 & 2) != 0) {
            link2 = textTemplate.link;
        }
        if ((i11 & 4) != 0) {
            list = textTemplate.buttons;
        }
        if ((i11 & 8) != 0) {
            str2 = textTemplate.buttonTitle;
        }
        return textTemplate.copy(str, link2, list, str2);
    }

    public static /* synthetic */ void getObjectType$annotations() {
    }

    public final String component1() {
        return this.text;
    }

    public final Link component2() {
        return this.link;
    }

    public final List<Button> component3() {
        return this.buttons;
    }

    public final String component4() {
        return this.buttonTitle;
    }

    public final TextTemplate copy(String str, Link link2, List<Button> list, String str2) {
        return new TextTemplate(str, link2, list, str2);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TextTemplate)) {
            return false;
        }
        TextTemplate textTemplate = (TextTemplate) obj;
        return x.b(this.text, textTemplate.text) && x.b(this.link, textTemplate.link) && x.b(this.buttons, textTemplate.buttons) && x.b(this.buttonTitle, textTemplate.buttonTitle);
    }

    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    public final List<Button> getButtons() {
        return this.buttons;
    }

    public final Link getLink() {
        return this.link;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final String getText() {
        return this.text;
    }

    public int hashCode() {
        int hashCode = ((this.text.hashCode() * 31) + this.link.hashCode()) * 31;
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
        return "TextTemplate(text=" + this.text + ", link=" + this.link + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.text);
        this.link.writeToParcel(parcel, i11);
        List<Button> list = this.buttons;
        if (list == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            parcel.writeInt(list.size());
            for (Button writeToParcel : list) {
                writeToParcel.writeToParcel(parcel, i11);
            }
        }
        parcel.writeString(this.buttonTitle);
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ TextTemplate(String str, Link link2, List list, String str2, int i11, r rVar) {
        this(str, link2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : str2);
    }
}
