package com.jumio.core.credentials;

import kotlin.jvm.internal.r;
import org.json.JSONException;
import org.json.JSONObject;

public enum JCredentialCapabilities {
    f39084b,
    STORAGE,
    EXTRACTION,
    AUTHENTICATION,
    SIMILARITY,
    FRAUD_LOOKUPS;
    

    /* renamed from: a  reason: collision with root package name */
    public static final Companion f39083a = null;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final JCredentialCapabilities fromJson(JSONObject jSONObject) throws JSONException {
            String string = jSONObject.getString("name");
            if (string != null) {
                switch (string.hashCode()) {
                    case -1750284680:
                        if (string.equals("AUTHENTICATION")) {
                            return JCredentialCapabilities.AUTHENTICATION;
                        }
                        break;
                    case -1166291365:
                        if (string.equals("STORAGE")) {
                            return JCredentialCapabilities.STORAGE;
                        }
                        break;
                    case -946804962:
                        if (string.equals("FRAUD_LOOKUPS")) {
                            return JCredentialCapabilities.FRAUD_LOOKUPS;
                        }
                        break;
                    case 1236650983:
                        if (string.equals("EXTRACTION")) {
                            return JCredentialCapabilities.EXTRACTION;
                        }
                        break;
                    case 1428120291:
                        if (string.equals("SIMILARITY")) {
                            return JCredentialCapabilities.SIMILARITY;
                        }
                        break;
                }
            }
            return JCredentialCapabilities.f39084b;
        }
    }

    /* access modifiers changed from: public */
    static {
        f39083a = new Companion((r) null);
    }
}
