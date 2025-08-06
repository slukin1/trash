package com.kakao.sdk.template.model;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u00012\u00020\u0002BE\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n\u0012\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\t\u0010\u001d\u001a\u00020\u0004HÆ\u0003J\u000b\u0010\u001e\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\u000b\u0010\u001f\u001a\u0004\u0018\u00010\bHÆ\u0003J\u0011\u0010 \u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nHÆ\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\rHÆ\u0003JI\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0010\b\u0002\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\t\u0010#\u001a\u00020$HÖ\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(HÖ\u0003J\t\u0010)\u001a\u00020$HÖ\u0001J\t\u0010*\u001a\u00020\rHÖ\u0001J\u0019\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020$HÖ\u0001R\u0013\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0019\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u001a\u0010\u0017\u001a\u00020\rXD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0018\u0010\u0019\u001a\u0004\b\u001a\u0010\u0010R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001c¨\u00060"}, d2 = {"Lcom/kakao/sdk/template/model/FeedTemplate;", "Lcom/kakao/sdk/template/model/DefaultTemplate;", "Landroid/os/Parcelable;", "content", "Lcom/kakao/sdk/template/model/Content;", "itemContent", "Lcom/kakao/sdk/template/model/ItemContent;", "social", "Lcom/kakao/sdk/template/model/Social;", "buttons", "", "Lcom/kakao/sdk/template/model/Button;", "buttonTitle", "", "(Lcom/kakao/sdk/template/model/Content;Lcom/kakao/sdk/template/model/ItemContent;Lcom/kakao/sdk/template/model/Social;Ljava/util/List;Ljava/lang/String;)V", "getButtonTitle", "()Ljava/lang/String;", "getButtons", "()Ljava/util/List;", "getContent", "()Lcom/kakao/sdk/template/model/Content;", "getItemContent", "()Lcom/kakao/sdk/template/model/ItemContent;", "objectType", "getObjectType$annotations", "()V", "getObjectType", "getSocial", "()Lcom/kakao/sdk/template/model/Social;", "component1", "component2", "component3", "component4", "component5", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "template_release"}, k = 1, mv = {1, 6, 0}, xi = 48)
public final class FeedTemplate implements DefaultTemplate, Parcelable {
    public static final Parcelable.Creator<FeedTemplate> CREATOR = new Creator();
    private final String buttonTitle;
    private final List<Button> buttons;
    private final Content content;
    private final ItemContent itemContent;
    private final String objectType;
    private final Social social;

    @Metadata(k = 3, mv = {1, 6, 0}, xi = 48)
    public static final class Creator implements Parcelable.Creator<FeedTemplate> {
        /* renamed from: a */
        public final FeedTemplate createFromParcel(Parcel parcel) {
            Content createFromParcel = Content.CREATOR.createFromParcel(parcel);
            ArrayList arrayList = null;
            ItemContent createFromParcel2 = parcel.readInt() == 0 ? null : ItemContent.CREATOR.createFromParcel(parcel);
            Social createFromParcel3 = parcel.readInt() == 0 ? null : Social.CREATOR.createFromParcel(parcel);
            if (parcel.readInt() != 0) {
                int readInt = parcel.readInt();
                arrayList = new ArrayList(readInt);
                for (int i11 = 0; i11 != readInt; i11++) {
                    arrayList.add(Button.CREATOR.createFromParcel(parcel));
                }
            }
            return new FeedTemplate(createFromParcel, createFromParcel2, createFromParcel3, arrayList, parcel.readString());
        }

        /* renamed from: b */
        public final FeedTemplate[] newArray(int i11) {
            return new FeedTemplate[i11];
        }
    }

    public FeedTemplate(Content content2) {
        this(content2, (ItemContent) null, (Social) null, (List) null, (String) null, 30, (r) null);
    }

    public FeedTemplate(Content content2, ItemContent itemContent2) {
        this(content2, itemContent2, (Social) null, (List) null, (String) null, 28, (r) null);
    }

    public FeedTemplate(Content content2, ItemContent itemContent2, Social social2) {
        this(content2, itemContent2, social2, (List) null, (String) null, 24, (r) null);
    }

    public FeedTemplate(Content content2, ItemContent itemContent2, Social social2, List<Button> list) {
        this(content2, itemContent2, social2, list, (String) null, 16, (r) null);
    }

    public FeedTemplate(Content content2, ItemContent itemContent2, Social social2, List<Button> list, String str) {
        this.content = content2;
        this.itemContent = itemContent2;
        this.social = social2;
        this.buttons = list;
        this.buttonTitle = str;
        this.objectType = "feed";
    }

    public static /* synthetic */ FeedTemplate copy$default(FeedTemplate feedTemplate, Content content2, ItemContent itemContent2, Social social2, List<Button> list, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            content2 = feedTemplate.content;
        }
        if ((i11 & 2) != 0) {
            itemContent2 = feedTemplate.itemContent;
        }
        ItemContent itemContent3 = itemContent2;
        if ((i11 & 4) != 0) {
            social2 = feedTemplate.social;
        }
        Social social3 = social2;
        if ((i11 & 8) != 0) {
            list = feedTemplate.buttons;
        }
        List<Button> list2 = list;
        if ((i11 & 16) != 0) {
            str = feedTemplate.buttonTitle;
        }
        return feedTemplate.copy(content2, itemContent3, social3, list2, str);
    }

    public static /* synthetic */ void getObjectType$annotations() {
    }

    public final Content component1() {
        return this.content;
    }

    public final ItemContent component2() {
        return this.itemContent;
    }

    public final Social component3() {
        return this.social;
    }

    public final List<Button> component4() {
        return this.buttons;
    }

    public final String component5() {
        return this.buttonTitle;
    }

    public final FeedTemplate copy(Content content2, ItemContent itemContent2, Social social2, List<Button> list, String str) {
        return new FeedTemplate(content2, itemContent2, social2, list, str);
    }

    public int describeContents() {
        return 0;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof FeedTemplate)) {
            return false;
        }
        FeedTemplate feedTemplate = (FeedTemplate) obj;
        return x.b(this.content, feedTemplate.content) && x.b(this.itemContent, feedTemplate.itemContent) && x.b(this.social, feedTemplate.social) && x.b(this.buttons, feedTemplate.buttons) && x.b(this.buttonTitle, feedTemplate.buttonTitle);
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

    public final ItemContent getItemContent() {
        return this.itemContent;
    }

    public final String getObjectType() {
        return this.objectType;
    }

    public final Social getSocial() {
        return this.social;
    }

    public int hashCode() {
        int hashCode = this.content.hashCode() * 31;
        ItemContent itemContent2 = this.itemContent;
        int i11 = 0;
        int hashCode2 = (hashCode + (itemContent2 == null ? 0 : itemContent2.hashCode())) * 31;
        Social social2 = this.social;
        int hashCode3 = (hashCode2 + (social2 == null ? 0 : social2.hashCode())) * 31;
        List<Button> list = this.buttons;
        int hashCode4 = (hashCode3 + (list == null ? 0 : list.hashCode())) * 31;
        String str = this.buttonTitle;
        if (str != null) {
            i11 = str.hashCode();
        }
        return hashCode4 + i11;
    }

    public String toString() {
        return "FeedTemplate(content=" + this.content + ", itemContent=" + this.itemContent + ", social=" + this.social + ", buttons=" + this.buttons + ", buttonTitle=" + this.buttonTitle + ')';
    }

    public void writeToParcel(Parcel parcel, int i11) {
        this.content.writeToParcel(parcel, i11);
        ItemContent itemContent2 = this.itemContent;
        if (itemContent2 == null) {
            parcel.writeInt(0);
        } else {
            parcel.writeInt(1);
            itemContent2.writeToParcel(parcel, i11);
        }
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
    public /* synthetic */ FeedTemplate(Content content2, ItemContent itemContent2, Social social2, List list, String str, int i11, r rVar) {
        this(content2, (i11 & 2) != 0 ? null : itemContent2, (i11 & 4) != 0 ? null : social2, (i11 & 8) != 0 ? null : list, (i11 & 16) != 0 ? null : str);
    }
}
