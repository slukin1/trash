package jumio.core;

import com.facebook.appevents.UserDataStore;
import d10.l;
import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import org.json.JSONObject;

public final class i0 extends Lambda implements l<JSONObject, c0> {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ p0 f56217a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public i0(p0 p0Var) {
        super(1);
        this.f56217a = p0Var;
    }

    public final Object invoke(Object obj) {
        Object obj2;
        JSONObject jSONObject = (JSONObject) obj;
        String optString = jSONObject.optString("id");
        ArrayList b11 = o1.b(jSONObject.getJSONArray("capabilities"), g0.f56205a);
        ArrayList b12 = o1.b(jSONObject.getJSONArray("requiredParts"), h0.f56214a);
        String string = jSONObject.getString("category");
        if (string != null) {
            int hashCode = string.hashCode();
            if (hashCode != -374349377) {
                if (hashCode != 2331) {
                    if (hashCode != 2090922) {
                        if (hashCode == 1644347675 && string.equals("DOCUMENT")) {
                            this.f56217a.getClass();
                            return new d0(optString, b11, p0.a(jSONObject, UserDataStore.COUNTRY, j0.f56226a), p0.a(jSONObject, "type", m0.f56273a), b12);
                        }
                    } else if (string.equals("DATA")) {
                        this.f56217a.getClass();
                        obj2 = new b0(optString, b11, b12, o1.b(jSONObject.getJSONArray("deviceRiskVendors"), l0.f56242a));
                    }
                } else if (string.equals("ID")) {
                    this.f56217a.getClass();
                    return new f0(optString, b11, p0.a(jSONObject, UserDataStore.COUNTRY, k0.f56232a), p0.a(jSONObject, "type", n0.f56281a), b12);
                }
            } else if (string.equals("FACEMAP")) {
                this.f56217a.getClass();
                obj2 = new e0(optString, b11, p0.a(jSONObject, "type", o0.f56289a), b12);
            }
            return obj2;
        }
        return null;
    }
}
