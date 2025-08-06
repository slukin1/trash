package com.jumio.core.data.document;

import com.jumio.core.data.country.Country;
import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import java.util.List;

public interface CountryDocumentProviderInterface {
    void clear();

    boolean contains(Country country);

    List<Country> getCountries();

    List<Country> getCountriesFor(List<? extends JumioDocumentType> list, JumioDocumentVariant jumioDocumentVariant);

    Country getCountryForIso2(String str);

    Country getCountryForIso3(String str);

    List<DigitalDocumentType> getDigitalDocumentTypes(Country country);

    List<PhysicalDocumentType> getPhysicalDocumentTypes(Country country);

    void initDocuments(Country country, List<PhysicalDocumentType> list, List<DigitalDocumentType> list2);

    boolean isEmpty();
}
