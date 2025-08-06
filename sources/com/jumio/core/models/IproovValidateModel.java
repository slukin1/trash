package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

@PersistWith("IproovValidateModel")
public final class IproovValidateModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final boolean f39318a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39319b;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final IproovValidateModel fromString(String str) {
            JSONObject jSONObject = new JSONObject(str);
            return new IproovValidateModel(jSONObject.optBoolean("passed", false), jSONObject.optString("failureReason", ""));
        }
    }

    public IproovValidateModel() {
        this(false, (String) null, 3, (r) null);
    }

    public IproovValidateModel(boolean z11, String str) {
        this.f39318a = z11;
        this.f39319b = str;
    }

    public static /* synthetic */ IproovValidateModel copy$default(IproovValidateModel iproovValidateModel, boolean z11, String str, int i11, Object obj) {
        if ((i11 & 1) != 0) {
            z11 = iproovValidateModel.f39318a;
        }
        if ((i11 & 2) != 0) {
            str = iproovValidateModel.f39319b;
        }
        return iproovValidateModel.copy(z11, str);
    }

    public final boolean component1() {
        return this.f39318a;
    }

    public final String component2() {
        return this.f39319b;
    }

    public final IproovValidateModel copy(boolean z11, String str) {
        return new IproovValidateModel(z11, str);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof IproovValidateModel)) {
            return false;
        }
        IproovValidateModel iproovValidateModel = (IproovValidateModel) obj;
        return this.f39318a == iproovValidateModel.f39318a && x.b(this.f39319b, iproovValidateModel.f39319b);
    }

    public final String getFailureReason() {
        return this.f39319b;
    }

    public final boolean getPassed() {
        return this.f39318a;
    }

    public int hashCode() {
        boolean z11 = this.f39318a;
        if (z11) {
            z11 = true;
        }
        return this.f39319b.hashCode() + ((z11 ? 1 : 0) * true);
    }

    public String toString() {
        boolean z11 = this.f39318a;
        String str = this.f39319b;
        return "IproovValidateModel(passed=" + z11 + ", failureReason=" + str + ")";
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ IproovValidateModel(boolean z11, String str, int i11, r rVar) {
        this((i11 & 1) != 0 ? false : z11, (i11 & 2) != 0 ? "" : str);
    }
}
