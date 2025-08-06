package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B5\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\u0011\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bHÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u000bHÆ\u0003J;\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\u0010\b\u0002\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000bHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u000bHÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0013\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u000bXD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u000e¨\u0006+"}, d2 = {"Lcom/kakao/sdk/template/model/CommerceTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "content", "Lcom/kakao/sdk/template/model/Content;", "commerce", "Lcom/kakao/sdk/template/model/Commerce;", "buttons", "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/Commerce;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getCommerce", "()Lcom/kakao/sdk/template/model/Commerce;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CommerceTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<CommerceTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Commerce commerce;
    private final Content content;
    private final String objectType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CommerceTemplate> {
        /* renamed from: a */
        public final CommerceTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
            Commerce createFromParcel2 = Commerce.CREATOR.createFromParcel(parcel);
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
            return new CommerceTemplate(createFromParcel, createFromParcel2, arrayList, parcel.readString());
        }

        /* renamed from: b */
        public final CommerceTemplate[] newArray(int i11) {
            return new CommerceTemplate[i11];
        }
    }

    public CommerceTemplate(Content content2, Commerce commerce2) {
        this(content2, commerce2, (List) null, (String) null, 12, (r) null);
    }

    public CommerceTemplate(Content content2, Commerce commerce2, List<Button> list) {
        this(content2, commerce2, list, (String) null, 8, (r) null);
    }

    public CommerceTemplate(Content content2, Commerce commerce2, List<Button> list, String str) {
        this.content = content2;
        this.commerce = commerce2;
        this.buttons = list;
        this.buttonTitle = str;
        this.objectType = "commerce";
    }

    public static /* synthetic */ CommerceTemplate copy$default(CommerceTemplate commerceTemplate, Content content2, Commerce commerce2, List<Button> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            content2 = commerceTemplate.content;
        }
        if ((i11 & 2) != 0) {
            commerce2 = commerceTemplate.commerce;
        }
        if ((i11 & 4) != 0) {
            list = commerceTemplate.buttons;
        }
        if ((i11 & 8) != 0) {
            str = commerceTemplate.buttonTitle;
        }
        return commerceTemplate.copy(content2, commerce2, list, str);
    }

    public static /* synthetic */ void getObjectType$annotations() {
    }

    public final Content component1() {
        return this.content;
    }

    public final Commerce component2() {
        return this.commerce;
    }

    public final List<Button> component3() {
        return this.buttons;
    }

    public final String component4() {
        return this.buttonTitle;
    }

    public final CommerceTemplate copy(Content content2, Commerce commerce2, List<Button> list, String str) {
        return new CommerceTemplate(content2, commerce2, list, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CommerceTemplate)) {
            return false;
        }
        CommerceTemplate commerceTemplate = (CommerceTemplate) obj;
        return x.b(this.content, commerceTemplate.content) && x.b(this.commerce, commerceTemplate.commerce) && x.b(this.buttons, commerceTemplate.buttons) && x.b(this.buttonTitle, commerceTemplate.buttonTitle);
    }

    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    public final List<Button> getButtons() {
        return this.buttons;
    }

    public final Commerce getCommerce() {
        return this.commerce;
    }

    public final Content getContent() {
        return this.content;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public int hashCode() {
        int hashCode = ((this.content.hashCode() * 31) + this.commerce.hashCode()) * 31;
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
        return "CommerceTemplate(content=" + this.content + ", commerce=" + this.commerce + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        this.content.writeToParcel(parcel, i11);
        this.commerce.writeToParcel(parcel, i11);
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
    public /* synthetic */ CommerceTemplate(Content content2, Commerce commerce2, List list, String str, int i11, r rVar) {
        this(content2, commerce2, (i11 & 4) != 0 ? null : list, (i11 & 8) != 0 ? null : str);
    }
}
