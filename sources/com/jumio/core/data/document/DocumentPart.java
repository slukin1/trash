package com.jumio.core.data.document;

import com.jumio.core.data.ScanMode;
import com.jumio.sdk.enums.JumioCredentialPart;
import d10.l;
import java.io.Serializable;
import java.util.List;
import jumio.core.o1;
import kotlin.jvm.internal.Lambda;
import org.json.JSONArray;
import org.json.JSONObject;

public final class DocumentPart implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final JumioCredentialPart f39114a;

    /* renamed from: b  reason: collision with root package name */
    public final List<ScanMode> f39115b;

    /* renamed from: c  reason: collision with root package name */
    public final boolean f39116c;

    public static final class a extends Lambda implements l<String, ScanMode> {

        /* renamed from: a  reason: collision with root package name */
        public static final a f39117a = new a();

        public a() {
            super(1);
        }

        public final Object invoke(Object obj) {
            return ScanMode.valueOf((String) obj);
        }
    }

    public DocumentPart(JSONObject jSONObject) {
        this.f39114a = JumioCredentialPart.valueOf(jSONObject.getString("side"));
        JSONArray optJSONArray = jSONObject.optJSONArray("extraction");
        this.f39115b = optJSONArray != null ? o1.b(optJSONArray, a.f39117a) : CollectionsKt__CollectionsKt.k();
        this.f39116c = jSONObject.optBoolean("nfc", false);
    }

    public final List<ScanMode> getExtraction() {
        return this.f39115b;
    }

    public final boolean getNfc() {
        return this.f39116c;
    }

    public final JumioCredentialPart getSide() {
        return this.f39114a;
    }
}
