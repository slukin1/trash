package com.iproov.sdk.p013finally;

import android.content.Context;
import android.graphics.RectF;
import com.google.protobuf.ListValue;
import com.google.protobuf.NullValue;
import com.google.protobuf.Struct;
import com.google.protobuf.Value;
import com.iproov.sdk.core.Cfor;
import com.iproov.sdk.network.model.proto.AckMessageOuterClass$AckMessage;
import com.iproov.sdk.p003case.Cnew;
import com.iproov.sdk.p033throws.Cbreak;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.finally.if  reason: invalid class name and invalid package */
public final class Cif {

    /* renamed from: do  reason: not valid java name */
    public static final Cif f534do = new Cif();

    /* renamed from: com.iproov.sdk.finally.if$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f535do;

        static {
            int[] iArr = new int[Value.KindCase.values().length];
            iArr[Value.KindCase.STRUCT_VALUE.ordinal()] = 1;
            iArr[Value.KindCase.BOOL_VALUE.ordinal()] = 2;
            iArr[Value.KindCase.NUMBER_VALUE.ordinal()] = 3;
            iArr[Value.KindCase.STRING_VALUE.ordinal()] = 4;
            iArr[Value.KindCase.NULL_VALUE.ordinal()] = 5;
            iArr[Value.KindCase.LIST_VALUE.ordinal()] = 6;
            iArr[Value.KindCase.KIND_NOT_SET.ordinal()] = 7;
            f535do = iArr;
        }
    }

    private Cif() {
    }

    /* renamed from: if  reason: not valid java name */
    private final Value m626if(String str) {
        return (Value) Value.newBuilder().setStringValue(str).build();
    }

    /* renamed from: do  reason: not valid java name */
    public final JSONObject m632do(Cbreak breakR) {
        JSONObject jSONObject = new JSONObject();
        Cfor.m617do(jSONObject, breakR);
        return jSONObject;
    }

    /* renamed from: do  reason: not valid java name */
    public final AckMessageOuterClass$AckMessage m628do(long j11, int i11) {
        Value.Builder newBuilder = Value.newBuilder();
        return (AckMessageOuterClass$AckMessage) AckMessageOuterClass$AckMessage.newBuilder().m1160do(i11).m1161do((Value) newBuilder.setStructValue((Struct) Struct.newBuilder().putFields("received", (Value) Value.newBuilder().setNumberValue((double) j11).build()).build()).build()).build();
    }

    /* renamed from: do  reason: not valid java name */
    public final JSONObject m631do(Struct struct) {
        JSONObject jSONObject = new JSONObject();
        for (Map.Entry next : struct.getFieldsMap().entrySet()) {
            Value.KindCase kindCase = ((Value) next.getValue()).getKindCase();
            switch (kindCase == null ? -1 : Cdo.f535do[kindCase.ordinal()]) {
                case 1:
                    jSONObject.put((String) next.getKey(), f534do.m631do(((Value) next.getValue()).getStructValue()));
                    break;
                case 2:
                    jSONObject.put((String) next.getKey(), ((Value) next.getValue()).getBoolValue());
                    break;
                case 3:
                    jSONObject.put((String) next.getKey(), ((Value) next.getValue()).getNumberValue());
                    break;
                case 4:
                    jSONObject.put((String) next.getKey(), ((Value) next.getValue()).getStringValue());
                    break;
                case 5:
                    jSONObject.put((String) next.getKey(), JSONObject.NULL);
                    break;
                case 6:
                    jSONObject.put((String) next.getKey(), f534do.m625do(((Value) next.getValue()).getListValue()));
                    break;
                case 7:
                    jSONObject.put((String) next.getKey(), JSONObject.NULL);
                    break;
            }
        }
        return jSONObject;
    }

    /* renamed from: do  reason: not valid java name */
    public final JSONArray m629do(RectF rectF) throws JSONException {
        JSONArray jSONArray = new JSONArray();
        jSONArray.put((double) rectF.left);
        jSONArray.put((double) rectF.top);
        jSONArray.put((double) rectF.width());
        jSONArray.put((double) rectF.height());
        return jSONArray;
    }

    /* renamed from: do  reason: not valid java name */
    public final Struct m627do(String str) {
        Struct.Builder newBuilder = Struct.newBuilder();
        JSONObject jSONObject = new JSONObject(str);
        Iterator<String> keys = jSONObject.keys();
        while (keys.hasNext()) {
            String next = keys.next();
            Object obj = jSONObject.get(next);
            if (obj instanceof Number) {
                newBuilder.putFields(next, f534do.m621do((Number) obj));
            } else if (obj instanceof Boolean) {
                newBuilder.putFields(next, f534do.m624do(((Boolean) obj).booleanValue()));
            } else if (obj instanceof String) {
                newBuilder.putFields(next, f534do.m626if((String) obj));
            } else if (obj instanceof JSONObject) {
                newBuilder.putFields(next, f534do.m623do((JSONObject) obj));
            } else if (obj instanceof JSONArray) {
                newBuilder.putFields(next, f534do.m622do((JSONArray) obj));
            } else if (x.b(obj, JSONObject.NULL)) {
                newBuilder.putFields(next, f534do.m620do());
            }
        }
        return (Struct) newBuilder.build();
    }

    /* renamed from: do  reason: not valid java name */
    public final JSONObject m630do(Context context, String str, Cfor forR) {
        return new JSONObject(Cnew.f170do.m243do(context, str, forR));
    }

    /* renamed from: do  reason: not valid java name */
    private final Value m621do(Number number) {
        return (Value) Value.newBuilder().setNumberValue(number.doubleValue()).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final Value m624do(boolean z11) {
        return (Value) Value.newBuilder().setBoolValue(z11).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final Value m623do(JSONObject jSONObject) {
        return (Value) Value.newBuilder().setStructValue(m627do(jSONObject.toString())).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final Value m620do() {
        return (Value) Value.newBuilder().setNullValue(NullValue.NULL_VALUE).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final Value m622do(JSONArray jSONArray) {
        Value value;
        ArrayList arrayList = new ArrayList();
        int length = jSONArray.length();
        if (length > 0) {
            int i11 = 0;
            while (true) {
                int i12 = i11 + 1;
                Object obj = jSONArray.get(i11);
                if (obj instanceof Number) {
                    value = m621do((Number) obj);
                } else if (obj instanceof Boolean) {
                    value = m624do(((Boolean) obj).booleanValue());
                } else if (obj instanceof String) {
                    value = m626if((String) obj);
                } else if (obj instanceof JSONObject) {
                    value = m623do((JSONObject) obj);
                } else if (obj instanceof JSONArray) {
                    value = m622do((JSONArray) obj);
                } else {
                    value = x.b(obj, JSONObject.NULL) ? m620do() : null;
                }
                if (value != null) {
                    arrayList.add(value);
                }
                if (i12 >= length) {
                    break;
                }
                i11 = i12;
            }
        }
        return (Value) Value.newBuilder().setListValue(ListValue.newBuilder().addAllValues(arrayList)).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final JSONArray m625do(ListValue listValue) {
        int i11;
        JSONArray jSONArray = new JSONArray();
        Value.KindCase kindCase = listValue.getValuesList().get(0).getKindCase();
        if (listValue.getValuesList().isEmpty()) {
            return jSONArray;
        }
        for (Value value : listValue.getValuesList()) {
            if (kindCase == null) {
                i11 = -1;
            } else {
                i11 = Cdo.f535do[kindCase.ordinal()];
            }
            switch (i11) {
                case 1:
                    jSONArray.put(f534do.m631do(value.getStructValue()));
                    break;
                case 2:
                    jSONArray.put(value.getBoolValue());
                    break;
                case 3:
                    jSONArray.put(value.getNumberValue());
                    break;
                case 4:
                    jSONArray.put(value.getStringValue());
                    break;
                case 5:
                    jSONArray.put(JSONObject.NULL);
                    break;
                case 6:
                    jSONArray.put(f534do.m625do(value.getListValue()));
                    break;
                case 7:
                    jSONArray.put(JSONObject.NULL);
                    break;
            }
        }
        return jSONArray;
    }
}
