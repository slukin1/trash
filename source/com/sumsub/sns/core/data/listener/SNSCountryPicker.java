package com.sumsub.sns.core.data.listener;

import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.Keep;
import com.sumsub.sns.core.a;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@a
@Keep
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\bg\u0018\u00002\u00020\u0001:\u0002\u000e\u000fJ@\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\fH&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSCountryPicker;", "", "pickCountry", "", "context", "Landroid/content/Context;", "items", "", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "callback", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "requestKey", "", "resultKey", "CountryItem", "SNSCountryPickerCallBack", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
public interface SNSCountryPicker {

    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\b\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\t\u001a\u00020\u0003HÆ\u0003J\t\u0010\n\u001a\u00020\u0003HÆ\u0003J\u001d\u0010\u000b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003HÆ\u0001J\t\u0010\f\u001a\u00020\rHÖ\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011HÖ\u0003J\t\u0010\u0012\u001a\u00020\rHÖ\u0001J\t\u0010\u0013\u001a\u00020\u0003HÖ\u0001J\u0019\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\rHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\u0007¨\u0006\u001a"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "Landroid/os/Parcelable;", "code", "", "name", "(Ljava/lang/String;Ljava/lang/String;)V", "getCode", "()Ljava/lang/String;", "getName", "component1", "component2", "copy", "describeContents", "", "equals", "", "other", "", "hashCode", "toString", "writeToParcel", "", "parcel", "Landroid/os/Parcel;", "flags", "Companion", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public static final class CountryItem implements Parcelable {
        public static final Parcelable.Creator<CountryItem> CREATOR = new Creator();
        public static final Companion Companion = new Companion((r) null);
        private final String code;
        private final String name;

        @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b0\u0007¨\u0006\t"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem$Companion;", "", "()V", "fromMap", "", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "countriesMap", "", "", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
        public static final class Companion {
            public /* synthetic */ Companion(r rVar) {
                this();
            }

            public final List<CountryItem> fromMap(Map<String, String> map) {
                ArrayList arrayList = new ArrayList(map.size());
                for (Map.Entry next : map.entrySet()) {
                    arrayList.add(new CountryItem((String) next.getKey(), (String) next.getValue()));
                }
                return arrayList;
            }

            private Companion() {
            }
        }

        @Metadata(k = 3, mv = {1, 7, 1}, xi = 48)
        public static final class Creator implements Parcelable.Creator<CountryItem> {
            public final CountryItem createFromParcel(Parcel parcel) {
                return new CountryItem(parcel.readString(), parcel.readString());
            }

            public final CountryItem[] newArray(int i11) {
                return new CountryItem[i11];
            }
        }

        public CountryItem(String str, String str2) {
            this.code = str;
            this.name = str2;
        }

        public static /* synthetic */ CountryItem copy$default(CountryItem countryItem, String str, String str2, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = countryItem.code;
            }
            if ((i11 & 2) != 0) {
                str2 = countryItem.name;
            }
            return countryItem.copy(str, str2);
        }

        public final String component1() {
            return this.code;
        }

        public final String component2() {
            return this.name;
        }

        public final CountryItem copy(String str, String str2) {
            return new CountryItem(str, str2);
        }

        public int describeContents() {
            return 0;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof CountryItem)) {
                return false;
            }
            CountryItem countryItem = (CountryItem) obj;
            return x.b(this.code, countryItem.code) && x.b(this.name, countryItem.name);
        }

        public final String getCode() {
            return this.code;
        }

        public final String getName() {
            return this.name;
        }

        public int hashCode() {
            return (this.code.hashCode() * 31) + this.name.hashCode();
        }

        public String toString() {
            return "CountryItem(code=" + this.code + ", name=" + this.name + ')';
        }

        public void writeToParcel(Parcel parcel, int i11) {
            parcel.writeString(this.code);
            parcel.writeString(this.name);
        }
    }

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H&ø\u0001\u0000\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0007À\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$SNSCountryPickerCallBack;", "", "onDismiss", "", "onItemSelected", "item", "Lcom/sumsub/sns/core/data/listener/SNSCountryPicker$CountryItem;", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1}, xi = 48)
    public interface SNSCountryPickerCallBack {
        void onDismiss();

        void onItemSelected(CountryItem countryItem);
    }

    void pickCountry(Context context, List<CountryItem> list, SNSCountryPickerCallBack sNSCountryPickerCallBack, String str, String str2);
}
