package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.data.document.Document;
import com.jumio.core.model.StaticModel;
import d10.l;
import java.util.Iterator;
import java.util.List;
import jumio.core.o1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONObject;

@PersistWith("DocumentModel")
public final class DocumentModel implements StaticModel {

    /* renamed from: b  reason: collision with root package name */
    public static final Companion f39304b = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<Document> f39305a;

    public static final class Companion {

        public static final class a extends Lambda implements l<JSONObject, Document> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f39306a = new a();

            public a() {
                super(1);
            }

            public final Object invoke(Object obj) {
                return new Document((JSONObject) obj);
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final DocumentModel fromJson(JSONArray jSONArray) {
            return new DocumentModel((List<Document>) o1.b(jSONArray, a.f39306a));
        }
    }

    public DocumentModel() {
        this(0);
    }

    public DocumentModel(List<Document> list) {
        this.f39305a = list;
    }

    public final synchronized Document a(String str) {
        T t11;
        Iterator<T> it2 = this.f39305a.iterator();
        while (true) {
            if (!it2.hasNext()) {
                t11 = null;
                break;
            }
            t11 = it2.next();
            if (x.b(((Document) t11).getCode(), str)) {
                break;
            }
        }
        return (Document) t11;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof DocumentModel) && x.b(this.f39305a, ((DocumentModel) obj).f39305a);
    }

    public final int hashCode() {
        return this.f39305a.hashCode();
    }

    public final String toString() {
        List<Document> list = this.f39305a;
        return "DocumentModel(documents=" + list + ")";
    }

    public /* synthetic */ DocumentModel(int i11) {
        this((List<Document>) CollectionsKt__CollectionsKt.k());
    }
}
