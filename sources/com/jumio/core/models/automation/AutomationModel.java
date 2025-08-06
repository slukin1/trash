package com.jumio.core.models.automation;

import com.jumio.commons.PersistWith;
import com.jumio.commons.log.Log;
import com.jumio.core.model.StaticModel;
import jumio.core.g1;
import jumio.core.i2;
import jumio.core.o;
import jumio.core.o1;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONException;
import org.json.JSONObject;

@PersistWith("AutomationModel")
public final class AutomationModel implements StaticModel {

    /* renamed from: e  reason: collision with root package name */
    public static final Companion f39405e = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final a f39406a;

    /* renamed from: b  reason: collision with root package name */
    public final i2 f39407b;

    /* renamed from: c  reason: collision with root package name */
    public final String f39408c;

    /* renamed from: d  reason: collision with root package name */
    public final g1 f39409d;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final AutomationModel fromString(String str) {
            if (str == null || str.length() == 0) {
                return new AutomationModel(0);
            }
            try {
                JSONObject jSONObject = new JSONObject(str);
                a aVar = (a) o1.a(jSONObject);
                JSONObject optJSONObject = jSONObject.optJSONObject("rejectReason");
                i2 i2Var = optJSONObject != null ? new i2(optJSONObject) : new i2(0);
                JSONObject optJSONObject2 = jSONObject.optJSONObject("extractedData");
                return new AutomationModel(aVar, i2Var, jSONObject.optString("additionalInformation", ""), optJSONObject2 != null ? new g1(optJSONObject2) : new g1(0));
            } catch (JSONException e11) {
                Log.w("AutomationModel", "json exception in parseResponse()", (Throwable) e11);
                return new AutomationModel(0);
            } catch (Exception e12) {
                Log.w("AutomationModel", "General exception", (Throwable) e12);
                return new AutomationModel(0);
            }
        }
    }

    public enum a {
        REJECT,
        NOT_AVAILABLE
    }

    public AutomationModel() {
        this(0);
    }

    public AutomationModel(a aVar, i2 i2Var, String str, g1 g1Var) {
        this.f39406a = aVar;
        this.f39407b = i2Var;
        this.f39408c = str;
        this.f39409d = g1Var;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof AutomationModel)) {
            return false;
        }
        AutomationModel automationModel = (AutomationModel) obj;
        return this.f39406a == automationModel.f39406a && x.b(this.f39407b, automationModel.f39407b) && x.b(this.f39408c, automationModel.f39408c) && x.b(this.f39409d, automationModel.f39409d);
    }

    public final int hashCode() {
        int hashCode = this.f39407b.hashCode();
        return this.f39409d.hashCode() + o.a(this.f39408c, (hashCode + (this.f39406a.hashCode() * 31)) * 31, 31);
    }

    public final String toString() {
        a aVar = this.f39406a;
        i2 i2Var = this.f39407b;
        String str = this.f39408c;
        g1 g1Var = this.f39409d;
        return "AutomationModel(decisionType=" + aVar + ", rejectReason=" + i2Var + ", additionalInformation=" + str + ", extractedData=" + g1Var + ")";
    }

    public /* synthetic */ AutomationModel(int i11) {
        this(a.NOT_AVAILABLE, new i2(0), "", new g1(0));
    }
}
