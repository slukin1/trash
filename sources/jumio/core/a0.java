package jumio.core;

import com.jumio.core.data.country.Country;
import com.jumio.core.data.digitaldocument.DigitalDocumentType;
import com.jumio.core.data.document.DocumentVariant;
import com.jumio.core.data.document.PhysicalDocumentType;
import com.jumio.core.models.CountryDocumentModel;
import com.jumio.core.models.DigitalSelectionModel;
import com.jumio.core.models.PhysicalSelectionModel;
import com.jumio.core.models.SelectionModel;
import com.jumio.sdk.document.JumioDigitalDocument;
import com.jumio.sdk.document.JumioDocument;
import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.document.JumioPhysicalDocument;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.jvm.internal.x;

public final class a0 implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final CountryDocumentModel f56113a;

    /* renamed from: b  reason: collision with root package name */
    public final String f56114b;

    /* renamed from: c  reason: collision with root package name */
    public final a2 f56115c;

    /* renamed from: d  reason: collision with root package name */
    public final List<Country> f56116d;

    /* renamed from: e  reason: collision with root package name */
    public Country f56117e;

    /* renamed from: f  reason: collision with root package name */
    public PhysicalDocumentType f56118f;

    /* renamed from: g  reason: collision with root package name */
    public DocumentVariant f56119g;

    /* renamed from: h  reason: collision with root package name */
    public DigitalDocumentType f56120h;

    public a0(CountryDocumentModel countryDocumentModel, String str, f0 f0Var) {
        this.f56113a = countryDocumentModel;
        this.f56114b = str;
        a2 a2Var = new a2(f0Var.e(), f0Var.f());
        this.f56115c = a2Var;
        List<Country> countriesFor = countryDocumentModel.getCountriesFor(a2Var.a(), a2Var.b());
        List<String> d11 = f0Var.d();
        boolean z11 = true;
        if ((d11 == null || !(d11.isEmpty() ^ true)) ? false : z11) {
            ArrayList arrayList = new ArrayList();
            for (T next : countriesFor) {
                if (f0Var.d().contains(((Country) next).getIsoCode())) {
                    arrayList.add(next);
                }
            }
            countriesFor = arrayList;
        }
        if (countriesFor.isEmpty()) {
            countriesFor = CollectionsKt___CollectionsKt.L0(this.f56113a.getCountries());
            this.f56115c.c();
        }
        this.f56116d = CollectionsKt___CollectionsKt.y0(countriesFor);
        Country b11 = b();
        if (b11 != null) {
            Pair<PhysicalDocumentType, DocumentVariant> b12 = b(b11);
            this.f56118f = b12.component1();
            this.f56119g = b12.component2();
        } else {
            b11 = null;
        }
        this.f56117e = b11;
        a(f0Var);
    }

    public final void a(f0 f0Var) {
        String str = f0Var.f56195k;
        JumioDocument jumioDocument = f0Var.f56196l;
        if (str != null) {
            if (jumioDocument instanceof JumioPhysicalDocument) {
                a(str, (JumioPhysicalDocument) jumioDocument);
            } else if (jumioDocument instanceof JumioDigitalDocument) {
                a(str, (JumioDigitalDocument) jumioDocument);
            }
        }
    }

    public final Country b() {
        List<Country> list = this.f56116d;
        boolean z11 = false;
        if (list.size() == 1) {
            if (a(((Country) CollectionsKt___CollectionsKt.a0(list)).getIsoCode()) != null) {
                z11 = true;
            }
        }
        if (!z11) {
            list = null;
        }
        if (list != null) {
            return a(((Country) CollectionsKt___CollectionsKt.a0(list)).getIsoCode());
        }
        return null;
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v10, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v2, resolved type: com.jumio.core.data.document.DocumentVariant} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final kotlin.Pair<com.jumio.core.data.document.PhysicalDocumentType, com.jumio.core.data.document.DocumentVariant> b(com.jumio.core.data.country.Country r6) {
        /*
            r5 = this;
            jumio.core.a2 r0 = r5.f56115c
            java.util.List r0 = r0.a()
            r1 = 1
            if (r0 == 0) goto L_0x0012
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x0010
            goto L_0x0012
        L_0x0010:
            r0 = 0
            goto L_0x0013
        L_0x0012:
            r0 = r1
        L_0x0013:
            r0 = r0 ^ r1
            java.util.List r2 = a((jumio.core.a0) r5, (com.jumio.core.data.country.Country) r6)
            com.jumio.core.models.CountryDocumentModel r3 = r5.f56113a
            java.util.List r6 = r3.getDigitalDocumentTypesFor(r6)
            r3 = r2
            java.util.ArrayList r3 = (java.util.ArrayList) r3
            int r3 = r3.size()
            r4 = 0
            if (r3 > r1) goto L_0x0066
            if (r0 != 0) goto L_0x0032
            boolean r6 = r6.isEmpty()
            r6 = r6 ^ r1
            if (r6 == 0) goto L_0x0032
            goto L_0x0066
        L_0x0032:
            java.lang.Object r6 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r2)
            com.jumio.core.data.document.PhysicalDocumentType r6 = (com.jumio.core.data.document.PhysicalDocumentType) r6
            jumio.core.a2 r0 = r5.f56115c
            com.jumio.sdk.document.JumioDocumentVariant r0 = r0.b()
            if (r0 == 0) goto L_0x004b
            boolean r2 = r6.hasVariant(r0)
            if (r2 == 0) goto L_0x004b
            com.jumio.core.data.document.DocumentVariant r4 = r6.getVariant(r0)
            goto L_0x0060
        L_0x004b:
            java.util.List r0 = r6.getVariants()
            int r0 = r0.size()
            if (r0 != r1) goto L_0x0060
            java.util.List r0 = r6.getVariants()
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.a0(r0)
            r4 = r0
            com.jumio.core.data.document.DocumentVariant r4 = (com.jumio.core.data.document.DocumentVariant) r4
        L_0x0060:
            kotlin.Pair r0 = new kotlin.Pair
            r0.<init>(r6, r4)
            return r0
        L_0x0066:
            kotlin.Pair r6 = new kotlin.Pair
            r6.<init>(r4, r4)
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.a0.b(com.jumio.core.data.country.Country):kotlin.Pair");
    }

    public final SelectionModel a() {
        DocumentVariant documentVariant;
        Country country = this.f56117e;
        if (!((country == null || ((this.f56118f == null || this.f56119g == null) && this.f56120h == null)) ? false : true) || country == null) {
            return null;
        }
        PhysicalDocumentType physicalDocumentType = this.f56118f;
        if (physicalDocumentType != null && (documentVariant = this.f56119g) != null) {
            return new PhysicalSelectionModel(country, physicalDocumentType, documentVariant);
        }
        DigitalDocumentType digitalDocumentType = this.f56120h;
        if (digitalDocumentType != null) {
            return new DigitalSelectionModel(country, digitalDocumentType);
        }
        return null;
    }

    public final boolean a(String str, JumioDocument jumioDocument) {
        Object obj;
        boolean z11;
        Country a11 = a(str);
        if (a11 == null) {
            return false;
        }
        if (jumioDocument instanceof JumioPhysicalDocument) {
            JumioPhysicalDocument jumioPhysicalDocument = (JumioPhysicalDocument) jumioDocument;
            Iterator it2 = ((ArrayList) a(this, a11)).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((PhysicalDocumentType) obj).getIdType() == jumioPhysicalDocument.getType()) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            PhysicalDocumentType physicalDocumentType = (PhysicalDocumentType) obj;
            if (physicalDocumentType == null) {
                return false;
            }
            return physicalDocumentType.hasVariant(jumioPhysicalDocument.getVariant());
        } else if (!(jumioDocument instanceof JumioDigitalDocument)) {
            return false;
        } else {
            JumioDigitalDocument jumioDigitalDocument = (JumioDigitalDocument) jumioDocument;
            List<DigitalDocumentType> digitalDocumentTypesFor = this.f56113a.getDigitalDocumentTypesFor(a11);
            if ((digitalDocumentTypesFor instanceof Collection) && digitalDocumentTypesFor.isEmpty()) {
                return false;
            }
            for (DigitalDocumentType type : digitalDocumentTypesFor) {
                if (x.b(type.getType(), jumioDigitalDocument.getType())) {
                    return true;
                }
            }
            return false;
        }
    }

    public final Country a(String str) {
        T t11 = null;
        if (str.length() == 0) {
            return null;
        }
        Iterator<T> it2 = this.f56116d.iterator();
        while (true) {
            if (!it2.hasNext()) {
                break;
            }
            T next = it2.next();
            if (x.b(((Country) next).getIsoCode(), str)) {
                t11 = next;
                break;
            }
        }
        return (Country) t11;
    }

    public final void a(String str, JumioDigitalDocument jumioDigitalDocument) throws IllegalArgumentException {
        T t11;
        Country a11 = a(str);
        if (a11 != null) {
            this.f56117e = a11;
            Iterator<T> it2 = this.f56113a.getDigitalDocumentTypesFor(a11).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    t11 = null;
                    break;
                }
                t11 = it2.next();
                if (x.b(((DigitalDocumentType) t11).getType(), jumioDigitalDocument.getType())) {
                    break;
                }
            }
            DigitalDocumentType digitalDocumentType = (DigitalDocumentType) t11;
            if (digitalDocumentType != null) {
                this.f56118f = null;
                this.f56119g = null;
                this.f56120h = digitalDocumentType;
                return;
            }
            throw new IllegalArgumentException("Unsupported digital document".toString());
        }
        throw new IllegalArgumentException("Unsupported country code".toString());
    }

    public final void a(String str, JumioPhysicalDocument jumioPhysicalDocument) throws IllegalArgumentException {
        Object obj;
        boolean z11;
        Country a11 = a(str);
        if (a11 != null) {
            this.f56117e = a11;
            Iterator it2 = ((ArrayList) a(this, a11)).iterator();
            while (true) {
                if (!it2.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it2.next();
                if (((PhysicalDocumentType) obj).getIdType() == jumioPhysicalDocument.getType()) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    break;
                }
            }
            PhysicalDocumentType physicalDocumentType = (PhysicalDocumentType) obj;
            if (physicalDocumentType == null) {
                throw new IllegalArgumentException("Unsupported document type".toString());
            } else if (physicalDocumentType.hasVariant(jumioPhysicalDocument.getVariant())) {
                this.f56120h = null;
                this.f56118f = physicalDocumentType;
                this.f56119g = physicalDocumentType.getVariant(jumioPhysicalDocument.getVariant());
            } else {
                throw new IllegalArgumentException("Unsupported document variant".toString());
            }
        } else {
            throw new IllegalArgumentException("Unsupported country code".toString());
        }
    }

    public final ArrayList a(Country country) {
        List a11 = a(this, country);
        ArrayList arrayList = new ArrayList();
        Iterator it2 = ((ArrayList) a11).iterator();
        while (it2.hasNext()) {
            PhysicalDocumentType physicalDocumentType = (PhysicalDocumentType) it2.next();
            List<DocumentVariant> variants = physicalDocumentType.getVariants();
            ArrayList arrayList2 = new ArrayList();
            for (T next : variants) {
                a2 a2Var = this.f56115c;
                JumioDocumentVariant variant = ((DocumentVariant) next).getVariant();
                a2Var.getClass();
                if (a2Var.b() == null || a2Var.f56125b == variant) {
                    arrayList2.add(next);
                }
            }
            ArrayList arrayList3 = new ArrayList(CollectionsKt__IterablesKt.u(arrayList2, 10));
            Iterator it3 = arrayList2.iterator();
            while (it3.hasNext()) {
                arrayList3.add(new JumioPhysicalDocument(physicalDocumentType.getIdType(), ((DocumentVariant) it3.next()).getVariant()));
            }
            boolean unused = CollectionsKt__MutableCollectionsKt.A(arrayList, arrayList3);
        }
        return arrayList;
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0015 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.List a(jumio.core.a0 r9, com.jumio.core.data.country.Country r10) {
        /*
            com.jumio.core.models.CountryDocumentModel r0 = r9.f56113a
            java.util.List r10 = r0.getPhysicalDocumentTypesFor(r10)
            jumio.core.a2 r0 = r9.f56115c
            com.jumio.sdk.document.JumioDocumentVariant r0 = r0.b()
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.Iterator r10 = r10.iterator()
        L_0x0015:
            boolean r2 = r10.hasNext()
            if (r2 == 0) goto L_0x0065
            java.lang.Object r2 = r10.next()
            r3 = r2
            com.jumio.core.data.document.PhysicalDocumentType r3 = (com.jumio.core.data.document.PhysicalDocumentType) r3
            jumio.core.a2 r4 = r9.f56115c
            com.jumio.sdk.document.JumioDocumentType r5 = r3.getIdType()
            r4.getClass()
            java.util.List r6 = r4.a()
            r7 = 0
            r8 = 1
            if (r6 == 0) goto L_0x003c
            boolean r6 = r6.isEmpty()
            if (r6 == 0) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            r6 = r7
            goto L_0x003d
        L_0x003c:
            r6 = r8
        L_0x003d:
            if (r6 != 0) goto L_0x0053
            java.util.List r4 = r4.a()
            if (r4 == 0) goto L_0x004d
            boolean r4 = r4.contains(r5)
            if (r4 != r8) goto L_0x004d
            r4 = r8
            goto L_0x004e
        L_0x004d:
            r4 = r7
        L_0x004e:
            if (r4 == 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            r4 = r7
            goto L_0x0054
        L_0x0053:
            r4 = r8
        L_0x0054:
            if (r4 == 0) goto L_0x005f
            if (r0 == 0) goto L_0x005e
            boolean r3 = r3.hasVariant(r0)
            if (r3 == 0) goto L_0x005f
        L_0x005e:
            r7 = r8
        L_0x005f:
            if (r7 == 0) goto L_0x0015
            r1.add(r2)
            goto L_0x0015
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: jumio.core.a0.a(jumio.core.a0, com.jumio.core.data.country.Country):java.util.List");
    }
}
