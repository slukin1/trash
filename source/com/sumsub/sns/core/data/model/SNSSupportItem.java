package com.sumsub.sns.core.data.model;

import android.graphics.drawable.Drawable;
import android.util.Patterns;
import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import d10.l;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@a
@Keep
@Metadata(bv = {}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0014\b\b\u0018\u00002\u00020\u0001:\u0001.B[\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0002\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\u0002\u0012\u0006\u0010\u0011\u001a\u00020\u0006\u0012\u0006\u0010\u0012\u001a\u00020\u0002\u0012\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0002\u0012\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\f¢\u0006\u0004\b,\u0010-J\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0005\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\t\u0010\u0007\u001a\u00020\u0006HÆ\u0003J\t\u0010\b\u001a\u00020\u0002HÆ\u0003J\u000b\u0010\n\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u0017\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0003Je\u0010\u0016\u001a\u00020\u00002\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00022\b\b\u0002\u0010\u0011\u001a\u00020\u00062\b\b\u0002\u0010\u0012\u001a\u00020\u00022\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u00022\u0016\b\u0002\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\fHÆ\u0001J\t\u0010\u0017\u001a\u00020\u0002HÖ\u0001J\t\u0010\u0019\u001a\u00020\u0018HÖ\u0001J\u0013\u0010\u001c\u001a\u00020\u001b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003R\u0019\u0010\u000f\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u000f\u0010\u001d\u001a\u0004\b\u001e\u0010\u001fR\u0019\u0010\u0010\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u001d\u001a\u0004\b \u0010\u001fR\u0017\u0010\u0011\u001a\u00020\u00068\u0006¢\u0006\f\n\u0004\b\u0011\u0010!\u001a\u0004\b\"\u0010#R\u0017\u0010\u0012\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0012\u0010\u001d\u001a\u0004\b$\u0010\u001fR\u0019\u0010\u0013\u001a\u0004\u0018\u00010\t8\u0006¢\u0006\f\n\u0004\b\u0013\u0010%\u001a\u0004\b&\u0010'R\u0019\u0010\u0014\u001a\u0004\u0018\u00010\u00028\u0006¢\u0006\f\n\u0004\b\u0014\u0010\u001d\u001a\u0004\b(\u0010\u001fR%\u0010\u0015\u001a\u0010\u0012\u0004\u0012\u00020\u0000\u0012\u0004\u0012\u00020\r\u0018\u00010\f8\u0006¢\u0006\f\n\u0004\b\u0015\u0010)\u001a\u0004\b*\u0010+¨\u0006/"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSupportItem;", "", "", "isValid", "component1", "component2", "Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "component3", "component4", "Landroid/graphics/drawable/Drawable;", "component5", "component6", "Lkotlin/Function1;", "", "component7", "title", "subtitle", "type", "value", "iconDrawable", "iconName", "onClick", "copy", "toString", "", "hashCode", "other", "", "equals", "Ljava/lang/String;", "getTitle", "()Ljava/lang/String;", "getSubtitle", "Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "getType", "()Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "getValue", "Landroid/graphics/drawable/Drawable;", "getIconDrawable", "()Landroid/graphics/drawable/Drawable;", "getIconName", "Ld10/l;", "getOnClick", "()Ld10/l;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;Ljava/lang/String;Landroid/graphics/drawable/Drawable;Ljava/lang/String;Ld10/l;)V", "Type", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class SNSSupportItem {
    private final Drawable iconDrawable;
    private final String iconName;
    private final l<SNSSupportItem, Unit> onClick;
    private final String subtitle;
    private final String title;
    private final Type type;
    private final String value;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/sumsub/sns/core/data/model/SNSSupportItem$Type;", "", "(Ljava/lang/String;I)V", "Url", "Email", "Custom", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public enum Type {
        Url,
        Email,
        Custom
    }

    @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[Type.values().length];
            iArr[Type.Url.ordinal()] = 1;
            iArr[Type.Email.ordinal()] = 2;
            iArr[Type.Custom.ordinal()] = 3;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public SNSSupportItem(String str, String str2, Type type2, String str3, Drawable drawable, String str4, l<? super SNSSupportItem, Unit> lVar) {
        this.title = str;
        this.subtitle = str2;
        this.type = type2;
        this.value = str3;
        this.iconDrawable = drawable;
        this.iconName = str4;
        this.onClick = lVar;
    }

    public static /* synthetic */ SNSSupportItem copy$default(SNSSupportItem sNSSupportItem, String str, String str2, Type type2, String str3, Drawable drawable, String str4, l<SNSSupportItem, Unit> lVar, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            str = sNSSupportItem.title;
        }
        if ((i11 & 2) != 0) {
            str2 = sNSSupportItem.subtitle;
        }
        String str5 = str2;
        if ((i11 & 4) != 0) {
            type2 = sNSSupportItem.type;
        }
        Type type3 = type2;
        if ((i11 & 8) != 0) {
            str3 = sNSSupportItem.value;
        }
        String str6 = str3;
        if ((i11 & 16) != 0) {
            drawable = sNSSupportItem.iconDrawable;
        }
        Drawable drawable2 = drawable;
        if ((i11 & 32) != 0) {
            str4 = sNSSupportItem.iconName;
        }
        String str7 = str4;
        if ((i11 & 64) != 0) {
            lVar = sNSSupportItem.onClick;
        }
        return sNSSupportItem.copy(str, str5, type3, str6, drawable2, str7, lVar);
    }

    public final String component1() {
        return this.title;
    }

    public final String component2() {
        return this.subtitle;
    }

    public final Type component3() {
        return this.type;
    }

    public final String component4() {
        return this.value;
    }

    public final Drawable component5() {
        return this.iconDrawable;
    }

    public final String component6() {
        return this.iconName;
    }

    public final l<SNSSupportItem, Unit> component7() {
        return this.onClick;
    }

    public final SNSSupportItem copy(String str, String str2, Type type2, String str3, Drawable drawable, String str4, l<? super SNSSupportItem, Unit> lVar) {
        return new SNSSupportItem(str, str2, type2, str3, drawable, str4, lVar);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SNSSupportItem)) {
            return false;
        }
        SNSSupportItem sNSSupportItem = (SNSSupportItem) obj;
        return x.b(this.title, sNSSupportItem.title) && x.b(this.subtitle, sNSSupportItem.subtitle) && this.type == sNSSupportItem.type && x.b(this.value, sNSSupportItem.value) && x.b(this.iconDrawable, sNSSupportItem.iconDrawable) && x.b(this.iconName, sNSSupportItem.iconName) && x.b(this.onClick, sNSSupportItem.onClick);
    }

    public final Drawable getIconDrawable() {
        return this.iconDrawable;
    }

    public final String getIconName() {
        return this.iconName;
    }

    public final l<SNSSupportItem, Unit> getOnClick() {
        return this.onClick;
    }

    public final String getSubtitle() {
        return this.subtitle;
    }

    public final String getTitle() {
        return this.title;
    }

    public final Type getType() {
        return this.type;
    }

    public final String getValue() {
        return this.value;
    }

    public int hashCode() {
        String str = this.title;
        int i11 = 0;
        int hashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.subtitle;
        int hashCode2 = (((((hashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + this.type.hashCode()) * 31) + this.value.hashCode()) * 31;
        Drawable drawable = this.iconDrawable;
        int hashCode3 = (hashCode2 + (drawable == null ? 0 : drawable.hashCode())) * 31;
        String str3 = this.iconName;
        int hashCode4 = (hashCode3 + (str3 == null ? 0 : str3.hashCode())) * 31;
        l<SNSSupportItem, Unit> lVar = this.onClick;
        if (lVar != null) {
            i11 = lVar.hashCode();
        }
        return hashCode4 + i11;
    }

    public final String isValid() {
        if ((this.value.length() == 0) || StringsKt__StringsJVMKt.z(this.value)) {
            return this + ". Value must not be empty or blank.";
        }
        int i11 = WhenMappings.$EnumSwitchMapping$0[this.type.ordinal()];
        if (i11 != 1) {
            if (i11 != 2) {
                if (i11 != 3) {
                    throw new NoWhenBranchMatchedException();
                } else if (this.onClick != null) {
                    return null;
                } else {
                    return this + ". You have to implement your own onClick callback if you want to use a Custom type.";
                }
            } else if (Patterns.EMAIL_ADDRESS.matcher(this.value).matches()) {
                return null;
            } else {
                return this + ". Invalid email format";
            }
        } else if (Patterns.WEB_URL.matcher(this.value).matches()) {
            return null;
        } else {
            return this + ". Invalid url format";
        }
    }

    public String toString() {
        return "SNSSupportItem(title=" + this.title + ", subtitle=" + this.subtitle + ", type=" + this.type + ", value=" + this.value + ", iconDrawable=" + this.iconDrawable + ", iconName=" + this.iconName + ", onClick=" + this.onClick + ')';
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ SNSSupportItem(String str, String str2, Type type2, String str3, Drawable drawable, String str4, l lVar, int i11, r rVar) {
        this(str, str2, type2, str3, (i11 & 16) != 0 ? null : drawable, (i11 & 32) != 0 ? null : str4, (i11 & 64) != 0 ? null : lVar);
    }
}
