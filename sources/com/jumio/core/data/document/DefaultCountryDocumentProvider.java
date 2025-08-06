package com.jumio.core.data.document;

import com.facebook.appevents.UserDataStore;
import com.jumio.core.data.country.Country;
import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import com.jumio.sdk.util.IsoCountryConverter;
import d10.l;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import jumio.core.o1;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONObject;

public final class DefaultCountryDocumentProvider implements CountryDocumentProviderInterface, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f39100a;

    public static final class a extends Lambda implements l<JSONObject, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ boolean f39101a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ DefaultCountryDocumentProvider f39102b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(boolean z11, DefaultCountryDocumentProvider defaultCountryDocumentProvider) {
            super(1);
            this.f39101a = z11;
            this.f39102b = defaultCountryDocumentProvider;
        }

        public final Object invoke(Object obj) {
            JSONObject jSONObject = (JSONObject) obj;
            String string = jSONObject.getString(UserDataStore.COUNTRY);
            Country country = new Country(string, this.f39101a);
            if (!StringsKt__StringsJVMKt.w(country.getName(), IsoCountryConverter.convertToAlpha2(string), true)) {
                ArrayList arrayList = new ArrayList();
                JSONArray optJSONArray = jSONObject.optJSONArray("idTypes");
                if (optJSONArray != null) {
                    arrayList.addAll(o1.b(optJSONArray, a.f39127a));
                } else {
                    arrayList.add(new PhysicalDocumentType(jSONObject.getJSONObject("idTypes")));
                }
                JSONArray optJSONArray2 = jSONObject.optJSONArray("digitalIdentityTypes");
                ArrayList b11 = optJSONArray2 != null ? o1.b(optJSONArray2, b.f39128a) : new ArrayList();
                if (!arrayList.isEmpty() || !b11.isEmpty()) {
                    CollectionsKt__MutableCollectionsJVMKt.y(arrayList);
                    CollectionsKt__MutableCollectionsJVMKt.y(b11);
                    this.f39102b.initDocuments(country, arrayList, b11);
                }
            }
            return Unit.f56620a;
        }
    }

    public DefaultCountryDocumentProvider() {
        this((JSONArray) null, false, 3, (r) null);
    }

    public DefaultCountryDocumentProvider(JSONArray jSONArray, boolean z11) {
        this.f39100a = new LinkedHashMap();
        o1.a(jSONArray, new a(z11, this));
    }

    public void clear() {
        this.f39100a.clear();
    }

    public boolean contains(Country country) {
        return this.f39100a.containsKey(getCountryForIso3(country.getIsoCode()));
    }

    public List<Country> getCountries() {
        return CollectionsKt___CollectionsKt.I0(this.f39100a.keySet());
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x000f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.jumio.core.data.country.Country> getCountriesFor(java.util.List<? extends com.jumio.sdk.document.JumioDocumentType> r9, com.jumio.sdk.document.JumioDocumentVariant r10) {
        /*
            r8 = this;
            java.util.LinkedHashMap r0 = r8.f39100a
            java.util.LinkedHashMap r1 = new java.util.LinkedHashMap
            r1.<init>()
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x006f
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            java.lang.Object r3 = r2.getValue()
            com.jumio.core.data.document.DocumentWrapper r3 = (com.jumio.core.data.document.DocumentWrapper) r3
            java.util.List r3 = r3.getPhysicalDocuments()
            boolean r4 = r3 instanceof java.util.Collection
            r5 = 1
            r6 = 0
            if (r4 == 0) goto L_0x0032
            boolean r4 = r3.isEmpty()
            if (r4 == 0) goto L_0x0032
            goto L_0x0060
        L_0x0032:
            java.util.Iterator r3 = r3.iterator()
        L_0x0036:
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L_0x0060
            java.lang.Object r4 = r3.next()
            com.jumio.core.data.document.PhysicalDocumentType r4 = (com.jumio.core.data.document.PhysicalDocumentType) r4
            if (r9 == 0) goto L_0x004e
            com.jumio.sdk.document.JumioDocumentType r7 = r4.getIdType()
            boolean r7 = r9.contains(r7)
            if (r7 != 0) goto L_0x0050
        L_0x004e:
            if (r9 != 0) goto L_0x005c
        L_0x0050:
            if (r10 == 0) goto L_0x0058
            boolean r4 = r4.hasVariant(r10)
            if (r4 != 0) goto L_0x005a
        L_0x0058:
            if (r10 != 0) goto L_0x005c
        L_0x005a:
            r4 = r5
            goto L_0x005d
        L_0x005c:
            r4 = r6
        L_0x005d:
            if (r4 == 0) goto L_0x0036
            goto L_0x0061
        L_0x0060:
            r5 = r6
        L_0x0061:
            if (r5 == 0) goto L_0x000f
            java.lang.Object r3 = r2.getKey()
            java.lang.Object r2 = r2.getValue()
            r1.put(r3, r2)
            goto L_0x000f
        L_0x006f:
            java.util.Set r9 = r1.keySet()
            java.util.List r9 = kotlin.collections.CollectionsKt___CollectionsKt.I0(r9)
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.data.document.DefaultCountryDocumentProvider.getCountriesFor(java.util.List, com.jumio.sdk.document.JumioDocumentVariant):java.util.List");
    }

    public Country getCountryForIso2(String str) {
        return getCountryForIso3(new Locale("", str).getISO3Country());
    }

    public Country getCountryForIso3(String str) {
        Object obj;
        Iterator it2 = this.f39100a.keySet().iterator();
        while (true) {
            if (!it2.hasNext()) {
                obj = null;
                break;
            }
            obj = it2.next();
            if (x.b(((Country) obj).getIsoCode(), str)) {
                break;
            }
        }
        return (Country) obj;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r2 = r2.getDigitalDocuments();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.jumio.core.data.digitaldocument.DigitalDocumentType> getDigitalDocumentTypes(com.jumio.core.data.country.Country r2) {
        /*
            r1 = this;
            java.lang.String r2 = r2.getIsoCode()
            com.jumio.core.data.country.Country r2 = r1.getCountryForIso3(r2)
            java.util.LinkedHashMap r0 = r1.f39100a
            java.lang.Object r2 = r0.get(r2)
            com.jumio.core.data.document.DocumentWrapper r2 = (com.jumio.core.data.document.DocumentWrapper) r2
            if (r2 == 0) goto L_0x0018
            java.util.List r2 = r2.getDigitalDocuments()
            if (r2 != 0) goto L_0x001c
        L_0x0018:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.data.document.DefaultCountryDocumentProvider.getDigitalDocumentTypes(com.jumio.core.data.country.Country):java.util.List");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0012, code lost:
        r2 = r2.getPhysicalDocuments();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.List<com.jumio.core.data.document.PhysicalDocumentType> getPhysicalDocumentTypes(com.jumio.core.data.country.Country r2) {
        /*
            r1 = this;
            java.lang.String r2 = r2.getIsoCode()
            com.jumio.core.data.country.Country r2 = r1.getCountryForIso3(r2)
            java.util.LinkedHashMap r0 = r1.f39100a
            java.lang.Object r2 = r0.get(r2)
            com.jumio.core.data.document.DocumentWrapper r2 = (com.jumio.core.data.document.DocumentWrapper) r2
            if (r2 == 0) goto L_0x0018
            java.util.List r2 = r2.getPhysicalDocuments()
            if (r2 != 0) goto L_0x001c
        L_0x0018:
            java.util.List r2 = kotlin.collections.CollectionsKt__CollectionsKt.k()
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.data.document.DefaultCountryDocumentProvider.getPhysicalDocumentTypes(com.jumio.core.data.country.Country):java.util.List");
    }

    public void initDocuments(Country country, List<PhysicalDocumentType> list, List<DigitalDocumentType> list2) {
        this.f39100a.put(country, new DocumentWrapper(CollectionsKt___CollectionsKt.I0(list), CollectionsKt___CollectionsKt.I0(list2)));
    }

    public boolean isEmpty() {
        return this.f39100a.isEmpty();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DefaultCountryDocumentProvider(JSONArray jSONArray, boolean z11, int i11, r rVar) {
        this((i11 & 1) != 0 ? new JSONArray() : jSONArray, (i11 & 2) != 0 ? false : z11);
    }
}
