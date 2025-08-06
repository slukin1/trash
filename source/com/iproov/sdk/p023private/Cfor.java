package com.iproov.sdk.p023private;

import android.content.Context;
import com.google.protobuf.ByteString;
import com.google.protobuf.Value;
import com.iproov.sdk.bridge.OptionsBridge;
import com.iproov.sdk.network.model.proto.AckMessageOuterClass$AckMessage;
import com.iproov.sdk.network.model.proto.Cimport;
import com.iproov.sdk.network.model.proto.ClientAbortOuterClass$ClientAbort;
import com.iproov.sdk.network.model.proto.ClientLuxOuterClass$ClientLux;
import com.iproov.sdk.network.model.proto.ClientStartOuterClass$ClientStart;
import com.iproov.sdk.network.model.proto.ClientTelemetryOuterClass$ClientTelemetry;
import com.iproov.sdk.network.model.proto.ClientVideoOuterClass$ClientVideo;
import com.iproov.sdk.network.model.proto.Cwhile;
import com.iproov.sdk.network.model.proto.EdgeAbortOuterClass$EdgeAbort;
import com.iproov.sdk.network.model.proto.EdgeProgressUpdateOuterClass$EdgeProgressUpdate;
import com.iproov.sdk.network.model.proto.EdgeResultOuterClass$EdgeResult;
import com.iproov.sdk.network.model.proto.EnvelopeOuterClass$Envelope;
import com.iproov.sdk.p013finally.Cif;
import com.iproov.sdk.p017implements.Ccase;
import com.iproov.sdk.p022package.Cdo;
import com.iproov.sdk.p022package.Cfor;
import com.iproov.sdk.p022package.Cnew;
import com.iproov.sdk.p026return.Creturn;
import com.iproov.sdk.p026return.Cstatic;
import fv.g;
import java.util.Arrays;
import java.util.List;
import kotlin.jvm.internal.d0;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.private.for  reason: invalid class name and invalid package */
public final class Cfor implements Cif {

    /* renamed from: do  reason: not valid java name */
    private final int f1116do;

    /* renamed from: if  reason: not valid java name */
    private final Context f1117if;

    /* renamed from: com.iproov.sdk.private.for$do  reason: invalid class name */
    public /* synthetic */ class Cdo {

        /* renamed from: do  reason: not valid java name */
        public static final /* synthetic */ int[] f1118do;

        /* renamed from: if  reason: not valid java name */
        public static final /* synthetic */ int[] f1119if;

        static {
            int[] iArr = new int[Cwhile.values().length];
            iArr[Cwhile.ACK.ordinal()] = 1;
            iArr[Cwhile.EDGE_RESULT.ordinal()] = 2;
            iArr[Cwhile.EDGE_ABORT.ordinal()] = 3;
            iArr[Cwhile.EDGE_PROGRESS_UPDATE.ordinal()] = 4;
            f1118do = iArr;
            int[] iArr2 = new int[Value.KindCase.values().length];
            iArr2[Value.KindCase.STRUCT_VALUE.ordinal()] = 1;
            iArr2[Value.KindCase.BOOL_VALUE.ordinal()] = 2;
            iArr2[Value.KindCase.NUMBER_VALUE.ordinal()] = 3;
            iArr2[Value.KindCase.STRING_VALUE.ordinal()] = 4;
            f1119if = iArr2;
        }
    }

    public Cfor(int i11, Context context) {
        this.f1116do = i11;
        this.f1117if = context;
    }

    /* renamed from: do  reason: not valid java name */
    public com.iproov.sdk.p022package.Cfor m1273do(byte[] bArr) {
        com.iproov.sdk.p022package.Cfor forR;
        EnvelopeOuterClass$Envelope parseFrom = EnvelopeOuterClass$Envelope.parseFrom(bArr);
        Ccase.m977do(this);
        x.i("Received: ", parseFrom.getEventType().name());
        Cwhile eventType = parseFrom.getEventType();
        int i11 = eventType == null ? -1 : Cdo.f1118do[eventType.ordinal()];
        if (i11 == 1) {
            AckMessageOuterClass$AckMessage parseFrom2 = AckMessageOuterClass$AckMessage.parseFrom(parseFrom.getSerializedMessage());
            forR = new Cfor.Cdo(parseFrom.getSequenceNumber(), m1268do(parseFrom2), parseFrom2.getSequenceResponse());
        } else if (i11 == 2) {
            EdgeResultOuterClass$EdgeResult parseFrom3 = EdgeResultOuterClass$EdgeResult.parseFrom(parseFrom.getSerializedMessage());
            forR = new Cfor.Cnew(parseFrom.getSequenceNumber(), parseFrom3.getPassed(), parseFrom3.getUserFeedbackCode());
        } else if (i11 == 3) {
            return new Cfor.Cif(EdgeAbortOuterClass$EdgeAbort.parseFrom(parseFrom.getSerializedMessage()).getInternalCode());
        } else {
            if (i11 != 4) {
                return Cfor.Ctry.f1092do;
            }
            return new Cfor.Cfor(EdgeProgressUpdateOuterClass$EdgeProgressUpdate.parseFrom(parseFrom.getSerializedMessage()).getProgressPercent());
        }
        return forR;
    }

    /* renamed from: do  reason: not valid java name */
    public byte[] m1274do(Cnew newR, int i11) {
        if (newR instanceof Cnew.Cif) {
            return m1272do(m1265do((Cnew.Cif) newR).toByteString(), i11, Cwhile.CLIENT_START);
        }
        if (newR instanceof Cnew.Ccase) {
            return m1272do(m1267do((Cnew.Ccase) newR).toByteString(), i11, Cwhile.CLIENT_VIDEO);
        }
        if (newR instanceof Cnew.Cnew) {
            return m1272do(m1264do((Cnew.Cnew) newR).toByteString(), i11, Cwhile.CLIENT_LUX);
        }
        if (newR instanceof Cnew.Cfor) {
            return m1272do(m1262do((Cnew.Cfor) newR).toByteString(), i11, Cwhile.ACK);
        }
        if (newR instanceof Cnew.Cdo) {
            return m1272do(m1263do((Cnew.Cdo) newR).toByteString(), i11, Cwhile.CLIENT_ABORT);
        }
        if (newR instanceof Cnew.Ctry) {
            return m1272do(m1266do((Cnew.Ctry) newR).toByteString(), i11, Cwhile.CLIENT_TELEMETRY);
        }
        throw new Exception("Unsupported message type");
    }

    /* renamed from: do  reason: not valid java name */
    private final com.iproov.sdk.p022package.Cdo m1268do(AckMessageOuterClass$AckMessage ackMessageOuterClass$AckMessage) {
        com.iproov.sdk.p022package.Cdo doVar;
        Value.KindCase kindCase = ackMessageOuterClass$AckMessage.getPayload().getKindCase();
        int i11 = kindCase == null ? -1 : Cdo.f1119if[kindCase.ordinal()];
        if (i11 == 1) {
            doVar = new Cdo.Cif(Cif.f534do.m631do(ackMessageOuterClass$AckMessage.getPayload().getStructValue()));
        } else if (i11 == 2) {
            doVar = new Cdo.Cdo(ackMessageOuterClass$AckMessage.getPayload().getBoolValue());
        } else if (i11 == 3) {
            doVar = new Cdo.Cfor(ackMessageOuterClass$AckMessage.getPayload().getNumberValue());
        } else if (i11 != 4) {
            return Cdo.Ctry.f1084do;
        } else {
            doVar = new Cdo.Cnew(ackMessageOuterClass$AckMessage.getPayload().getStringValue());
        }
        return doVar;
    }

    /* renamed from: do  reason: not valid java name */
    private final byte[] m1272do(ByteString byteString, int i11, Cwhile whileR) {
        return ((EnvelopeOuterClass$Envelope) EnvelopeOuterClass$Envelope.newBuilder().m1171do(byteString).m1173do(whileR).m1172do(Cimport.NONE).m1174if(this.f1116do).m1170do(i11).build()).toByteArray();
    }

    /* renamed from: do  reason: not valid java name */
    private final ClientTelemetryOuterClass$ClientTelemetry m1266do(Cnew.Ctry tryR) {
        return (ClientTelemetryOuterClass$ClientTelemetry) ClientTelemetryOuterClass$ClientTelemetry.newBuilder().m1165do(Cif.f534do.m627do(tryR.m1260do().m561if())).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final ClientAbortOuterClass$ClientAbort m1263do(Cnew.Cdo doVar) {
        return (ClientAbortOuterClass$ClientAbort) ClientAbortOuterClass$ClientAbort.newBuilder().m1162do(doVar.m1254do()).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final AckMessageOuterClass$AckMessage m1262do(Cnew.Cfor forR) {
        return Cif.f534do.m628do(forR.m1256if(), forR.m1255do());
    }

    /* renamed from: do  reason: not valid java name */
    private final ClientLuxOuterClass$ClientLux m1264do(Cnew.Cnew newR) {
        ClientLuxOuterClass$ClientLux.Cdo newBuilder = ClientLuxOuterClass$ClientLux.newBuilder();
        Cif ifVar = Cif.f534do;
        return (ClientLuxOuterClass$ClientLux) newBuilder.m1163do(ifVar.m627do(ifVar.m632do(newR.m1259do()).toString())).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final void m1271do(JSONObject jSONObject, String str, Cstatic staticR, int i11) {
        Creturn returnR = staticR.m1694new().get(Integer.valueOf(i11));
        float[] fArr = returnR == null ? null : returnR.m1689for();
        if (fArr == null) {
            fArr = new float[]{0.0f, 0.0f, 0.0f};
        }
        com.iproov.sdk.utils.Cif.m2276do(jSONObject, str, (Object) com.iproov.sdk.utils.Cif.m2270do(fArr));
    }

    /* renamed from: do  reason: not valid java name */
    private final JSONObject m1270do(Cstatic staticR) {
        JSONObject jSONObject = new JSONObject();
        m1271do(jSONObject, "r", staticR, 4);
        m1271do(jSONObject, "a", staticR, 10);
        m1271do(jSONObject, "ag", staticR, 1);
        m1271do(jSONObject, g.f22793a, staticR, 9);
        m1271do(jSONObject, TtmlNode.TAG_P, staticR, 11);
        com.iproov.sdk.utils.Cif.m2276do(jSONObject, "t0", (Object) Long.valueOf(staticR.m1691do()));
        com.iproov.sdk.utils.Cif.m2276do(jSONObject, "t", (Object) Long.valueOf(staticR.m1692for()));
        return jSONObject;
    }

    /* renamed from: do  reason: not valid java name */
    private final JSONArray m1269do(List<Cstatic> list) {
        JSONArray jSONArray = new JSONArray();
        if (list != null) {
            for (Cstatic staticR : list) {
                jSONArray.put(m1270do(staticR));
            }
        }
        return jSONArray;
    }

    /* renamed from: do  reason: not valid java name */
    private final ClientVideoOuterClass$ClientVideo m1267do(Cnew.Ccase caseR) {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("token", caseR.m1243catch());
        jSONObject.put("version", caseR.m1244class());
        jSONObject.put(OptionsBridge.CAMERA_KEY, caseR.m1246do().m93do());
        d0 d0Var = d0.f56774a;
        jSONObject.put("orientation", String.format("%03d", Arrays.copyOf(new Object[]{Integer.valueOf(caseR.m1247else())}, 1)));
        jSONObject.put("type", x.i("video/", caseR.m1251new().f190do));
        jSONObject.put("part", caseR.m1253try());
        jSONObject.put("final", caseR.m1245const());
        jSONObject.put("loco", m1269do(caseR.m1249goto()));
        jSONObject.put("frt", caseR.m1242case().f326do);
        if (caseR.m1250if() != null) {
            jSONObject.put("cr", Cif.f534do.m629do(caseR.m1250if()));
        }
        if (caseR.m1241break() != null) {
            jSONObject.put("timestamp", caseR.m1241break().longValue());
        }
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("video", jSONObject);
        return (ClientVideoOuterClass$ClientVideo) ClientVideoOuterClass$ClientVideo.newBuilder().m1167do(ByteString.copyFrom(caseR.m1248for())).m1166do(caseR.m1253try()).m1169do(caseR.m1252this()).m1168do(Cif.f534do.m627do(jSONObject2.toString())).build();
    }

    /* renamed from: do  reason: not valid java name */
    private final ClientStartOuterClass$ClientStart m1265do(Cnew.Cif ifVar) {
        JSONArray jSONArray = new JSONArray();
        com.iproov.sdk.p003case.Cdo[] doVarArr = ifVar.m1257do().m2134case();
        int length = doVarArr.length;
        int i11 = 0;
        while (i11 < length) {
            com.iproov.sdk.p003case.Cdo doVar = doVarArr[i11];
            i11++;
            jSONArray.put(doVar.toString());
        }
        com.iproov.sdk.utils.Cif.m2276do(ifVar.m1258if(), "supported_assurance_types", (Object) jSONArray);
        com.iproov.sdk.utils.Cif.m2276do(ifVar.m1258if(), "avs", (Object) com.iproov.sdk.utils.Cif.m2271do(ifVar.m1257do().m2140try()));
        com.iproov.sdk.utils.Cif.m2276do(ifVar.m1258if(), "supported_codecs", (Object) com.iproov.sdk.utils.Cif.m2272do(ifVar.m1257do().m2137for()));
        com.iproov.sdk.utils.Cif.m2276do(ifVar.m1258if(), "dal", (Object) Integer.valueOf(ifVar.m1257do().m2136else()));
        com.iproov.sdk.utils.Cif.m2276do(ifVar.m1258if(), "opt", (Object) OptionsBridge.toJsonForAnalytics(this.f1117if, ifVar.m1257do().m2135do()));
        if (ifVar.m1257do().getPublicKey() != null) {
            com.iproov.sdk.utils.Cif.m2276do(ifVar.m1258if(), "pky", (Object) ifVar.m1257do().getPublicKey());
        }
        if (ifVar.m1257do().m2139new() != null) {
            com.iproov.sdk.utils.Cif.m2276do(ifVar.m1258if(), "tsg", (Object) ifVar.m1257do().m2139new());
        }
        return (ClientStartOuterClass$ClientStart) ClientStartOuterClass$ClientStart.newBuilder().m1164do(Cif.f534do.m627do(ifVar.m1258if().toString())).build();
    }
}
