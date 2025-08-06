package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONObject;

@PersistWith("DeviceRiskModel")
public final class DeviceRiskModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public String f39267a;

    /* renamed from: b  reason: collision with root package name */
    public SdkType f39268b;

    public static final class Companion {
        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final DeviceRiskModel fromJson(JSONObject jSONObject) {
            return new DeviceRiskModel(jSONObject.optString("token"), SdkType.f39269a.fromString(jSONObject.getString("sdkType")));
        }
    }

    public enum SdkType {
        NONE;
        

        /* renamed from: a  reason: collision with root package name */
        public static final Companion f39269a = null;

        public static final class Companion {
            public Companion() {
            }

            public /* synthetic */ Companion(r rVar) {
                this();
            }

            public final SdkType fromString(String str) {
                SdkType sdkType;
                SdkType[] values = SdkType.values();
                int length = values.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        sdkType = null;
                        break;
                    }
                    sdkType = values[i11];
                    if (x.b(sdkType.name(), str)) {
                        break;
                    }
                    i11++;
                }
                return sdkType == null ? SdkType.NONE : sdkType;
            }
        }

        /* access modifiers changed from: public */
        static {
            f39269a = new Companion((r) null);
        }
    }

    public DeviceRiskModel(String str, SdkType sdkType) {
        this.f39267a = str;
        this.f39268b = sdkType;
    }

    public final SdkType getSdkType() {
        return this.f39268b;
    }

    public final String getToken() {
        return this.f39267a;
    }

    public final void setSdkType(SdkType sdkType) {
        this.f39268b = sdkType;
    }

    public final void setToken(String str) {
        this.f39267a = str;
    }

    public final JSONObject toJson() {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", this.f39267a);
        jSONObject.put("sdkType", this.f39268b);
        return jSONObject;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceRiskModel(String str, SdkType sdkType, int i11, r rVar) {
        this((i11 & 1) != 0 ? "" : str, sdkType);
    }
}
