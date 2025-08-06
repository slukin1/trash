package com.jumio.core.models;

import com.jumio.commons.PersistWith;
import com.jumio.core.model.StaticModel;
import d10.l;
import java.util.List;
import jumio.core.o1;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.r;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@PersistWith("DeviceRiskTokenDataModel")
public final class DeviceRiskTokenDataModel implements StaticModel {
    public static final Companion Companion = new Companion((r) null);

    /* renamed from: a  reason: collision with root package name */
    public final List<DeviceRiskModel> f39274a;

    public static final class Companion {

        public static final class a extends Lambda implements l<JSONObject, DeviceRiskModel> {

            /* renamed from: a  reason: collision with root package name */
            public static final a f39275a = new a();

            public a() {
                super(1);
            }

            public final Object invoke(Object obj) {
                return DeviceRiskModel.Companion.fromJson((JSONObject) obj);
            }
        }

        public Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }

        public final DeviceRiskTokenDataModel fromJson(JSONArray jSONArray) throws JSONException {
            return new DeviceRiskTokenDataModel(o1.b(jSONArray, a.f39275a));
        }
    }

    public DeviceRiskTokenDataModel() {
        this((List) null, 1, (r) null);
    }

    public DeviceRiskTokenDataModel(List<DeviceRiskModel> list) {
        this.f39274a = list;
    }

    public final List<DeviceRiskModel> getDeviceRiskModels() {
        return this.f39274a;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ DeviceRiskTokenDataModel(List list, int i11, r rVar) {
        this((i11 & 1) != 0 ? CollectionsKt__CollectionsKt.k() : list);
    }
}
