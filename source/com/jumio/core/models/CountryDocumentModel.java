package com.jumio.core.models;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import com.jumio.commons.PersistWith;
import com.jumio.core.R;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import com.jumio.core.data.document.CountryDocumentProviderInterface;
import com.jumio.core.data.document.DefaultCountryDocumentProvider;
import com.jumio.core.data.document.PhysicalDocumentType;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.List;
import java.util.Locale;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONArray;

@PersistWith("CountryDocumentModel")
public final class CountryDocumentModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final CountryDocumentProviderInterface f39257a;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final boolean checkForLocalization(Context context) {
            try {
                Configuration configuration = new Configuration(context.getResources().getConfiguration());
                Resources resources = context.getResources();
                int i11 = R.string.jumio_idtype_pp;
                String string = resources.getString(i11);
                configuration.setLocale(Locale.ENGLISH);
                return true ^ StringsKt__StringsJVMKt.w(context.createConfigurationContext(configuration).getResources().getString(i11), string, true);
            } catch (Exception unused) {
                return true;
            }
        }
    }

    public CountryDocumentModel() {
        this((CountryDocumentProviderInterface) null, 1, (r) null);
    }

    public CountryDocumentModel(CountryDocumentProviderInterface countryDocumentProviderInterface) {
        this.f39257a = countryDocumentProviderInterface;
    }

    public static /* synthetic */ CountryDocumentModel copy$default(CountryDocumentModel countryDocumentModel, CountryDocumentProviderInterface countryDocumentProviderInterface, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            countryDocumentProviderInterface = countryDocumentModel.f39257a;
        }
        return countryDocumentModel.copy(countryDocumentProviderInterface);
    }

    public final boolean contains(Country country) {
        return this.f39257a.contains(country);
    }

    public final CountryDocumentModel copy(CountryDocumentProviderInterface countryDocumentProviderInterface) {
        return new CountryDocumentModel(countryDocumentProviderInterface);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CountryDocumentModel) && x.b(this.f39257a, ((CountryDocumentModel) obj).f39257a);
    }

    public final List<Country> getCountries() {
        return this.f39257a.getCountries();
    }

    public final List<Country> getCountriesFor(List<? extends JumioDocumentType> list, JumioDocumentVariant jumioDocumentVariant) {
        return this.f39257a.getCountriesFor(list, jumioDocumentVariant);
    }

    public final Country getCountryForIso3(String str) {
        return this.f39257a.getCountryForIso3(str);
    }

    public final List<DigitalDocumentType> getDigitalDocumentTypesFor(Country country) {
        return this.f39257a.getDigitalDocumentTypes(country);
    }

    public final PhysicalDocumentType getPhysicalDocumentTypeFor(String str, JumioDocumentType jumioDocumentType) {
        Country countryForIso3 = getCountryForIso3(str);
        if (countryForIso3 == null) {
            return null;
        }
        for (PhysicalDocumentType next : this.f39257a.getPhysicalDocumentTypes(countryForIso3)) {
            if (jumioDocumentType == next.getIdType()) {
                return next;
            }
        }
        return null;
    }

    public final List<PhysicalDocumentType> getPhysicalDocumentTypesFor(Country country) {
        return this.f39257a.getPhysicalDocumentTypes(country);
    }

    public int hashCode() {
        return this.f39257a.hashCode();
    }

    public final boolean isEmpty() {
        return this.f39257a.getCountries().isEmpty();
    }

    public String toString() {
        CountryDocumentProviderInterface countryDocumentProviderInterface = this.f39257a;
        return "CountryDocumentModel(countryDocumentProvider=" + countryDocumentProviderInterface + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ CountryDocumentModel(CountryDocumentProviderInterface countryDocumentProviderInterface, int i11, r rVar) {
        this((i11 & 1) != 0 ? new DefaultCountryDocumentProvider((JSONArray) null, false, 3, (r) null) : countryDocumentProviderInterface);
    }
}
