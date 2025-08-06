package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BM\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0004\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\u0004HÆ\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\tHÆ\u0003J\u0011\u0010!\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bHÆ\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u0004HÆ\u0003JS\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\u0010\b\u0002\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u0004HÆ\u0001J\t\u0010$\u001a\u00020%HÖ\u0001J\u0013\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)HÖ\u0003J\t\u0010*\u001a\u00020%HÖ\u0001J\t\u0010+\u001a\u00020\u0004HÖ\u0001J\u0019\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020/2\u0006\u00100\u001a\u00020%HÖ\u0001R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010R\u0013\u0010\r\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0010R\u0019\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\u0004XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00061"}, d2 = {"Lcom/kakao/sdk/template/model/LocationTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "address", "", "content", "Lcom/kakao/sdk/template/model/Content;", "addressTitle", "social", "Lcom/kakao/sdk/template/model/Social;", "buttons", "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/Content;Ljava/lang/String;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)V", "getAddress", "()Ljava/lang/String;", "getAddressTitle", "getButtonTitle", "getButtons", "()Ljava/util/List;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "getSocial", "()Lcom/kakao/sdk/template/model/Social;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class LocationTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<LocationTemplate> CREATOR = new Creator();
    private final String address;
    private final String addressTitle;
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Content content;
    private final String objectType;
    private final Social social;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<LocationTemplate> {
        /* renamed from: a */
        public final LocationTemplate createFromParcel(Parcel parcel) {
            String readString = parcel.readString();
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
            String readString2 = parcel.readString();
            ArrayList arrayList = null;
            Social createFromParcel2 = parcel.readInt() == 0 ? null : Social.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(Button.CREATOR.createFromParcel(parcel));
                }
            }
            return new LocationTemplate(readString, createFromParcel, readString2, createFromParcel2, arrayList, parcel.readString());
        }

        /* renamed from: b */
        public final LocationTemplate[] newArray(int i11) {
            return new LocationTemplate[i11];
        }
    }

    public LocationTemplate(String str, Content content2) {
        this(str, content2, (String) null, (Social) null, (List) null, (String) null, 60, (r) null);
    }

    public LocationTemplate(String str, Content content2, String str2) {
        this(str, content2, str2, (Social) null, (List) null, (String) null, 56, (r) null);
    }

    public LocationTemplate(String str, Content content2, String str2, Social social2) {
        this(str, content2, str2, social2, (List) null, (String) null, 48, (r) null);
    }

    public LocationTemplate(String str, Content content2, String str2, Social social2, List<Button> list) {
        this(str, content2, str2, social2, list, (String) null, 32, (r) null);
    }

    public LocationTemplate(String str, Content content2, String str2, Social social2, List<Button> list, String str3) {
        this.address = str;
        this.content = content2;
        this.addressTitle = str2;
        this.social = social2;
        this.buttons = list;
        this.buttonTitle = str3;
        this.objectType = "location";
    }

    public static /* synthetic */ LocationTemplate copy$default(LocationTemplate locationTemplate, String str, Content content2, String str2, Social social2, List<Button> list, String str3, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = locationTemplate.address;
        }
        if ((i11 & 2) != 0) {
            content2 = locationTemplate.content;
        }
        Content content3 = content2;
        if ((i11 & 4) != 0) {
            str2 = locationTemplate.addressTitle;
        }
        String str4 = str2;
        if ((i11 & 8) != 0) {
            social2 = locationTemplate.social;
        }
        Social social3 = social2;
        if ((i11 & 16) != 0) {
            list = locationTemplate.buttons;
        }
        List<Button> list2 = list;
        if ((i11 & 32) != 0) {
            str3 = locationTemplate.buttonTitle;
        }
        return locationTemplate.copy(str, content3, str4, social3, list2, str3);
    }

    public static /* synthetic */ void getObjectType$annotations() {
    }

    public final String component1() {
        return this.address;
    }

    public final Content component2() {
        return this.content;
    }

    public final String component3() {
        return this.addressTitle;
    }

    public final Social component4() {
        return this.social;
    }

    public final List<Button> component5() {
        return this.buttons;
    }

    public final String component6() {
        return this.buttonTitle;
    }

    public final LocationTemplate copy(String str, Content content2, String str2, Social social2, List<Button> list, String str3) {
        return new LocationTemplate(str, content2, str2, social2, list, str3);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof LocationTemplate)) {
            return false;
        }
        LocationTemplate locationTemplate = (LocationTemplate) obj;
        return x.b(this.address, locationTemplate.address) && x.b(this.content, locationTemplate.content) && x.b(this.addressTitle, locationTemplate.addressTitle) && x.b(this.social, locationTemplate.social) && x.b(this.buttons, locationTemplate.buttons) && x.b(this.buttonTitle, locationTemplate.buttonTitle);
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getAddressTitle() {
        return this.addressTitle;
    }

    public final String getButtonTitle() {
        return this.buttonTitle;
    }

    public final List<Button> getButtons() {
        return this.buttons;
    }

    public final Content getContent() {
        return this.content;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final Social getSocial() {
        return this.social;
    }

    public int hashCode() {
        int hashCode = ((this.address.hashCode() * 31) + this.content.hashCode()) * 31;
        String str = this.addressTitle;
        int i11 = 0;
        int hashCode2 = (hashCode + (str == null ? 0 : str.hashCode())) * 31;
        Social social2 = this.social;
        int hashCode3 = (hashCode2 + (social2 == null ? 0 : social2.hashCode())) * 31;
        List<Button> list = this.buttons;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str2 = this.buttonTitle;
        if (str2 != null) {
            i11 = str2.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "LocationTemplate(address=" + this.address + ", content=" + this.content + ", addressTitle=" + this.addressTitle + ", social=" + this.social + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.address);
        this.content.writeToParcel(parcel, i11);
        parcel.writeString(this.addressTitle);
        Social social2 = this.social;
        if (social2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            social2.writeToParcel(parcel, i11);
        }
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
    public /* synthetic */ LocationTemplate(String str, Content content2, String str2, Social social2, List list, String str3, int i11, r rVar) {
        this(str, content2, (i11 & 4) != 0 ? null : str2, (i11 & 8) != 0 ? null : social2, (i11 & 16) != 0 ? null : list, (i11 & 32) != 0 ? null : str3);
    }
}
