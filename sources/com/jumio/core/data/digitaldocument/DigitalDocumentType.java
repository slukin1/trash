package com.jumio.core.data.digitaldocument;

import com.jumio.core.data.document.DocumentType;
import d10.l;
import java.io.Serializable;
import java.text.CollationKey;
import java.text.Collator;
import java.util.List;
import jumio.core.o1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class DigitalDocumentType implements DocumentType, Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final String f39096a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39097b;

    /* renamed from: c  reason: collision with root package name */
    public final List<DigitalDocumentPart> f39098c;

    public static final class a extends Lambda implements l<JSONObject, DigitalDocumentPart> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39099a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            return new DigitalDocumentPart((JSONObject) obj);
        }
    }

    public DigitalDocumentType(JSONObject jSONObject) {
        this.f39096a = jSONObject.getString("type");
        this.f39097b = jSONObject.optString("title", "");
        JSONArray optJSONArray = jSONObject.optJSONArray("parts");
        this.f39098c = optJSONArray != null ? o1.b(optJSONArray, a.f39099a) : CollectionsKt__CollectionsKt.k();
    }

    public final List<DigitalDocumentPart> getParts() {
        return this.f39098c;
    }

    public final String getTitle() {
        return this.f39097b;
    }

    public String getType() {
        return this.f39096a;
    }

    public int compareTo(DocumentType documentType) {
        if (!(documentType instanceof DigitalDocumentType)) {
            return -1;
        }
        CollationKey collationKey = Collator.getInstance().getCollationKey(getType());
        DigitalDocumentType digitalDocumentType = (DigitalDocumentType) documentType;
        digitalDocumentType.getClass();
        return collationKey.compareTo(Collator.getInstance().getCollationKey(digitalDocumentType.getType()));
    }
}
