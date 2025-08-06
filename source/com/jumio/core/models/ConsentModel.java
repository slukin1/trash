package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.consent.JumioConsentItem;
import com.jumio.sdk.enums.JumioConsentType;
import d10.l;
import java.io.Serializable;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import jumio.core.o1;
import jumio.core.x;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("ConsentModel")
public final class ConsentModel implements StaticModel, Serializable {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final LinkedHashMap f39253a;

    /* renamed from: b  reason: collision with root package name */
    public final LinkedHashMap f39254b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f39255c;

    public static final class Companion {

        public static final class a extends Lambda implements l<JSONObject, JumioConsentItem> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f39256a = new a();

            public a() {
                super(1);
            }

            public final Object invoke(Object obj) {
                JSONObject jSONObject = (JSONObject) obj;
                return new JumioConsentItem(jSONObject.getString("id"), jSONObject.getString("privacyPolicyUrl"), jSONObject.getString("text"), JumioConsentType.Companion.fromString(jSONObject.getString("displayType")));
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final ConsentModel fromJson(JSONArray jSONArray) {
            return new ConsentModel(o1.b(jSONArray, a.f39256a));
        }
    }

    public ConsentModel() {
        this((List) null, 1, (r) null);
    }

    public ConsentModel(List<JumioConsentItem> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (T next : list) {
            JumioConsentItem jumioConsentItem = (JumioConsentItem) next;
            linkedHashMap.put(next, Boolean.FALSE);
        }
        this.f39253a = linkedHashMap;
        this.f39254b = new LinkedHashMap();
    }

    public final boolean getAllConsented() {
        return !this.f39253a.containsValue(Boolean.FALSE);
    }

    public final List<JumioConsentItem> getNonConsentedItems() {
        LinkedHashMap linkedHashMap = this.f39253a;
        LinkedHashMap linkedHashMap2 = new LinkedHashMap();
        for (Map.Entry entry : linkedHashMap.entrySet()) {
            if (!((Boolean) entry.getValue()).booleanValue()) {
                linkedHashMap2.put(entry.getKey(), entry.getValue());
            }
        }
        return CollectionsKt___CollectionsKt.I0(linkedHashMap2.keySet());
    }

    public final boolean isConsentSent() {
        return this.f39253a.isEmpty() || this.f39255c;
    }

    public final Boolean isConsented(JumioConsentItem jumioConsentItem) {
        return (Boolean) this.f39253a.get(jumioConsentItem);
    }

    public final void saveResult(JumioConsentItem jumioConsentItem, boolean z11, long j11) {
        this.f39253a.put(jumioConsentItem, Boolean.valueOf(z11));
        this.f39254b.put(jumioConsentItem, Long.valueOf(j11));
    }

    public final void setConsentSent(boolean z11) {
        this.f39255c = z11;
    }

    public final JSONArray toJsonArray() {
        JSONArray jSONArray = new JSONArray();
        for (Map.Entry entry : this.f39254b.entrySet()) {
            jSONArray.put(new JSONObject(x.a((JumioConsentItem) entry.getKey(), Long.valueOf(((Number) entry.getValue()).longValue()))));
        }
        return jSONArray;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ ConsentModel(List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
