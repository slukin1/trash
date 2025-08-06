package com.jumio.core.data.document;

import com.jumio.sdk.document.JumioDocumentVariant;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.tencent.qcloud.tuicore.TUIConstants;
import d10.l;
import java.io.Serializable;
import java.util.Iterator;
import java.util.List;
import jumio.core.o1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class DocumentVariant implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final JumioDocumentVariant f39118a;

    /* renamed from: b  reason: collision with root package name */
    public final List<DocumentPart> f39119b;

    /* renamed from: c  reason: collision with root package name */
    public final DocumentFormat f39120c;

    public static final class a extends Lambda implements l<JSONObject, DocumentPart> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39121a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            return new DocumentPart((JSONObject) obj);
        }
    }

    public DocumentVariant(JSONObject jSONObject) {
        this.f39118a = JumioDocumentVariant.valueOf(jSONObject.getString("variant"));
        JSONArray optJSONArray = jSONObject.optJSONArray("parts");
        this.f39119b = optJSONArray != null ? o1.b(optJSONArray, a.f39121a) : CollectionsKt__CollectionsKt.k();
        this.f39120c = DocumentFormat.valueOf(jSONObject.optString(TUIConstants.TUIGroupNote.PLUGIN_GROUP_NOTE_FORMAT, "NONE"));
    }

    public final DocumentFormat getFormat() {
        return this.f39120c;
    }

    public final DocumentPart getPart(JumioCredentialPart jumioCredentialPart) {
        boolean z11;
        T t11;
        boolean z12;
        Iterator<T> it2 = this.f39119b.iterator();
        while (true) {
            z11 = true;
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (((DocumentPart) t11).getSide() == jumioCredentialPart) {
                z12 = true;
                continue;
            } else {
                z12 = false;
                continue;
            }
            if (z12) {
                break;
            }
        }
        DocumentPart documentPart = (DocumentPart) t11;
        if (documentPart == null) {
            z11 = false;
        }
        if (z11) {
            return documentPart;
        }
        throw new IllegalArgumentException(("Could not find " + jumioCredentialPart).toString());
    }

    public final List<DocumentPart> getParts() {
        return this.f39119b;
    }

    public final JumioDocumentVariant getVariant() {
        return this.f39118a;
    }

    public final boolean hasPart(JumioCredentialPart jumioCredentialPart) {
        T t11;
        boolean z11;
        Iterator<T> it2 = this.f39119b.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (((DocumentPart) t11).getSide() == jumioCredentialPart) {
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
        return t11 != null;
    }
}
