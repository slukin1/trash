package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002B1\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\u0002\u0010\fJ\t\u0010\u0019\u001a\u00020\u0004HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J\u0011\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J9\u0010\u001d\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u0013\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#HÖ\u0003J\t\u0010$\u001a\u00020\u001fHÖ\u0001J\t\u0010%\u001a\u00020\u0004HÖ\u0001J\u0019\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u001fHÖ\u0001R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\u0015\u001a\u00020\u0004XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0012¨\u0006+"}, d2 = {"Lcom/kakao/sdk/template/model/CalendarTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "id", "", "idType", "Lcom/kakao/sdk/template/model/IdType;", "content", "Lcom/kakao/sdk/template/model/Content;", "buttons", "", "Lcom/kakao/sdk/template/model/Button;", "(Ljava/lang/String;Lcom/kakao/sdk/template/model/IdType;Lcom/kakao/sdk/template/model/Content;Ljava/util/List;)V", "getButtons", "()Ljava/util/List;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "getId", "()Ljava/lang/String;", "getIdType", "()Lcom/kakao/sdk/template/model/IdType;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "component1", "component2", "component3", "component4", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class CalendarTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<CalendarTemplate> CREATOR = new Creator();
    private final List<Button> buttons;
    private final Content content;

    /* renamed from: id  reason: collision with root package name */
    private final String f25150id;
    private final IdType idType;
    private final String objectType;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<CalendarTemplate> {
        /* renamed from: a */
        public final CalendarTemplate createFromParcel(Parcel parcel) {
            ArrayList arrayList;
            String readString = parcel.readString();
            IdType valueOf = IdType.valueOf(parcel.readString());
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
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
            return new CalendarTemplate(readString, valueOf, createFromParcel, arrayList);
        }

        /* renamed from: b */
        public final CalendarTemplate[] newArray(int i11) {
            return new CalendarTemplate[i11];
        }
    }

    public CalendarTemplate(String str, IdType idType2, Content content2) {
        this(str, idType2, content2, (List) null, 8, (r) null);
    }

    public CalendarTemplate(String str, IdType idType2, Content content2, List<Button> list) {
        this.f25150id = str;
        this.idType = idType2;
        this.content = content2;
        this.buttons = list;
        this.objectType = "calendar";
    }

    public static /* synthetic */ CalendarTemplate copy$default(CalendarTemplate calendarTemplate, String str, IdType idType2, Content content2, List<Button> list, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = calendarTemplate.f25150id;
        }
        if ((i11 & 2) != 0) {
            idType2 = calendarTemplate.idType;
        }
        if ((i11 & 4) != 0) {
            content2 = calendarTemplate.content;
        }
        if ((i11 & 8) != 0) {
            list = calendarTemplate.buttons;
        }
        return calendarTemplate.copy(str, idType2, content2, list);
    }

    public static /* synthetic */ void getObjectType$annotations() {
    }

    public final String component1() {
        return this.f25150id;
    }

    public final IdType component2() {
        return this.idType;
    }

    public final Content component3() {
        return this.content;
    }

    public final List<Button> component4() {
        return this.buttons;
    }

    public final CalendarTemplate copy(String str, IdType idType2, Content content2, List<Button> list) {
        return new CalendarTemplate(str, idType2, content2, list);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof CalendarTemplate)) {
            return false;
        }
        CalendarTemplate calendarTemplate = (CalendarTemplate) obj;
        return x.b(this.f25150id, calendarTemplate.f25150id) && this.idType == calendarTemplate.idType && x.b(this.content, calendarTemplate.content) && x.b(this.buttons, calendarTemplate.buttons);
    }

    public final List<Button> getButtons() {
        return this.buttons;
    }

    public final Content getContent() {
        return this.content;
    }

    public final String getId() {
        return this.f25150id;
    }

    public final IdType getIdType() {
        return this.idType;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public int hashCode() {
        int hashCode = ((((this.f25150id.hashCode() * 31) + this.idType.hashCode()) * 31) + this.content.hashCode()) * 31;
        List<Button> list = this.buttons;
        return hashCode + (list == null ? 0 : list.hashCode());
    }

    public String toString() {
        return "CalendarTemplate(id=" + this.f25150id + ", idType=" + this.idType + ", content=" + this.content + ", buttons=" + this.buttons + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        parcel.writeString(this.f25150id);
        parcel.writeString(this.idType.name());
        this.content.writeToParcel(parcel, i11);
        List<Button> list = this.buttons;
        if (list == null) {
            parcel.writeInt(0);
            return;
        }
        parcel.writeInt(1);
        parcel.writeInt(list.size());
        for (Button writeToParcel : list) {
            writeToParcel.writeToParcel(parcel, i11);
        }
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CalendarTemplate(String str, IdType idType2, Content content2, List list, int i11, r rVar) {
        this(str, idType2, content2, (i11 & 8) != 0 ? null : list);
    }
}
