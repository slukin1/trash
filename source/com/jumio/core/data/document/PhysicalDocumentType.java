package com.jumio.core.data.document;

import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.document.JumioDocumentVariant;
import d10.l;
import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import jumio.core.o1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class PhysicalDocumentType implements DocumentType, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final JumioDocumentType f39124a;

    /* renamed from: b  reason: collision with root package name */
    public final List<DocumentVariant> f39125b;

    public static final class a extends Lambda implements l<JSONObject, DocumentVariant> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39126a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            return new DocumentVariant((JSONObject) obj);
        }
    }

    public PhysicalDocumentType(JSONObject jSONObject) {
        this.f39124a = JumioDocumentType.valueOf(jSONObject.getString("idType"));
        JSONArray optJSONArray = jSONObject.optJSONArray("variants");
        this.f39125b = optJSONArray != null ? o1.b(optJSONArray, a.f39126a) : CollectionsKt__CollectionsKt.k();
    }

    public boolean equals(Object obj) {
        return (obj instanceof PhysicalDocumentType ? compareTo((DocumentType) obj) : -1) == 0;
    }

    public final JumioDocumentType getIdType() {
        return this.f39124a;
    }

    public String getType() {
        return this.f39124a.toString();
    }

    public final DocumentVariant getVariant(JumioDocumentVariant jumioDocumentVariant) {
        T t11;
        boolean z11;
        Iterator<T> it2 = this.f39125b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (((DocumentVariant) t11).getVariant() == jumioDocumentVariant) {
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
        return (DocumentVariant) t11;
    }

    public final List<DocumentVariant> getVariants() {
        return this.f39125b;
    }

    public final boolean hasVariant(JumioDocumentVariant jumioDocumentVariant) {
        boolean z11;
        List<DocumentVariant> list = this.f39125b;
        if (!(list instanceof Collection) || !list.isEmpty()) {
            for (DocumentVariant variant : list) {
                if (variant.getVariant() == jumioDocumentVariant) {
                    z11 = true;
                    continue;
                } else {
                    z11 = false;
                    continue;
                }
                if (z11) {
                    return true;
                }
            }
        }
        return false;
    }

    public int hashCode() {
        return System.identityHashCode(this);
    }

    public int compareTo(DocumentType documentType) {
        JumioDocumentType jumioDocumentType;
        if (!(documentType instanceof PhysicalDocumentType)) {
            return -1;
        }
        JumioDocumentType jumioDocumentType2 = this.f39124a;
        JumioDocumentType jumioDocumentType3 = JumioDocumentType.PASSPORT;
        if (jumioDocumentType2 == jumioDocumentType3 && ((PhysicalDocumentType) documentType).f39124a != jumioDocumentType3) {
            return -1;
        }
        JumioDocumentType jumioDocumentType4 = JumioDocumentType.DRIVING_LICENSE;
        if (!(jumioDocumentType2 == jumioDocumentType4 && ((PhysicalDocumentType) documentType).f39124a == jumioDocumentType3)) {
            if (jumioDocumentType2 == jumioDocumentType4 && ((PhysicalDocumentType) documentType).f39124a != jumioDocumentType4) {
                return -1;
            }
            JumioDocumentType jumioDocumentType5 = JumioDocumentType.ID_CARD;
            if (!(jumioDocumentType2 == jumioDocumentType5 && ((PhysicalDocumentType) documentType).f39124a == jumioDocumentType3) && (!(jumioDocumentType2 == jumioDocumentType5 && ((PhysicalDocumentType) documentType).f39124a == jumioDocumentType4) && ((jumioDocumentType2 == jumioDocumentType5 && ((PhysicalDocumentType) documentType).f39124a == JumioDocumentType.VISA) || jumioDocumentType2 != (jumioDocumentType = JumioDocumentType.VISA) || ((PhysicalDocumentType) documentType).f39124a == jumioDocumentType))) {
                return -1;
            }
        }
        return 1;
    }
}
