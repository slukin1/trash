package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.Controller;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.credentials.JumioCredential;
import com.jumio.sdk.credentials.JumioCredentialInfo;
import com.jumio.sdk.credentials.JumioDataCredential;
import com.jumio.sdk.credentials.JumioDocumentCredential;
import com.jumio.sdk.credentials.JumioFaceCredential;
import com.jumio.sdk.credentials.JumioIDCredential;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import jumio.core.b0;
import jumio.core.c0;
import jumio.core.d0;
import jumio.core.e0;
import jumio.core.f0;
import jumio.core.i0;
import jumio.core.p0;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONArray;

@PersistWith("CredentialsModel")
public final class CredentialsModel implements StaticModel {

    /* renamed from: d  reason: collision with root package name */
    public static final Companion f39258d = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<c0> f39259a;

    /* renamed from: b  reason: collision with root package name */
    public int f39260b;

    /* renamed from: c  reason: collision with root package name */
    public String f39261c;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final CredentialsModel fromJson(JSONArray jSONArray) {
            Object invoke;
            i0 i0Var = new i0(new p0());
            ArrayList arrayList = new ArrayList();
            int length = jSONArray.length();
            for (int i11 = 0; i11 < length; i11++) {
                Object obj = jSONArray.get(i11);
                if (obj == null) {
                    obj = null;
                }
                if (!(obj == null || (invoke = i0Var.invoke(obj)) == null)) {
                    arrayList.add(invoke);
                }
            }
            return new CredentialsModel((List<? extends c0>) arrayList);
        }
    }

    public CredentialsModel() {
        this(0);
    }

    public CredentialsModel(List<? extends c0> list) {
        this.f39259a = list;
    }

    public final String a() {
        return this.f39261c;
    }

    public final List<c0> b() {
        return this.f39259a;
    }

    public final ArrayList c() {
        List<c0> list = this.f39259a;
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(list, 10));
        for (c0 c0Var : list) {
            arrayList.add(new JumioCredentialInfo(c0Var.f56144b, c0Var.f56143a));
        }
        return arrayList;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof CredentialsModel) && x.b(this.f39259a, ((CredentialsModel) obj).f39259a);
    }

    public final int hashCode() {
        return this.f39259a.hashCode();
    }

    public final String toString() {
        List<c0> list = this.f39259a;
        return "CredentialsModel(dataModels=" + list + ")";
    }

    public final JumioCredential a(Controller controller, String str) {
        JumioCredential jumioCredential;
        c0 data$jumio_core_release;
        Iterator<c0> it2 = this.f39259a.iterator();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i11 = -1;
                break;
            } else if (x.b(it2.next().a(), str)) {
                break;
            } else {
                i11++;
            }
        }
        if (i11 >= 0) {
            z11 = true;
        }
        if (z11) {
            this.f39260b = i11;
            c0 c0Var = this.f39259a.get(i11);
            String str2 = null;
            if (c0Var instanceof f0) {
                jumioCredential = new JumioIDCredential(controller, (f0) this.f39259a.get(this.f39260b));
            } else if (c0Var instanceof e0) {
                jumioCredential = new JumioFaceCredential(controller, (e0) this.f39259a.get(this.f39260b));
            } else if (c0Var instanceof d0) {
                jumioCredential = new JumioDocumentCredential(controller, (d0) this.f39259a.get(this.f39260b));
            } else {
                jumioCredential = c0Var instanceof b0 ? new JumioDataCredential(controller, (b0) this.f39259a.get(this.f39260b)) : null;
            }
            if (!(jumioCredential == null || (data$jumio_core_release = jumioCredential.getData$jumio_core_release()) == null)) {
                str2 = data$jumio_core_release.a();
            }
            this.f39261c = str2;
            return jumioCredential;
        }
        throw new IllegalArgumentException((str + " not found").toString());
    }

    public /* synthetic */ CredentialsModel(int i11) {
        this((List<? extends c0>) CollectionsKt__CollectionsKt.k());
    }
}
