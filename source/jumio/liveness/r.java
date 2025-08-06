package jumio.liveness;

import com.jumio.commons.log.Log;
import com.jumio.core.extraction.JumioRect;
import com.jumio.liveness.DaClient;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class r {

    /* renamed from: a  reason: collision with root package name */
    public long f56508a;

    /* renamed from: b  reason: collision with root package name */
    public JumioRect f56509b;

    /* renamed from: c  reason: collision with root package name */
    public Integer f56510c;

    /* renamed from: d  reason: collision with root package name */
    public Integer f56511d;

    /* renamed from: e  reason: collision with root package name */
    public Integer f56512e;

    /* renamed from: f  reason: collision with root package name */
    public Integer f56513f;

    /* renamed from: g  reason: collision with root package name */
    public Integer f56514g;

    public static final class a {
        public static r a(String str) {
            try {
                JSONArray jSONArray = new JSONArray(str);
                if (jSONArray.length() == 0) {
                    return null;
                }
                r rVar = new r(0);
                int length = jSONArray.length();
                for (int i11 = 0; i11 < length; i11++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i11);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("timestamp", "");
                        if (optString.length() > 0) {
                            rVar.a(Long.parseLong(optString));
                        }
                        String optString2 = optJSONObject.optString("name", "");
                        if (optString2 != null) {
                            switch (optString2.hashCode()) {
                                case -1862901377:
                                    if (optString2.equals(DaClient.ATTR_PSEUDO_PITCH)) {
                                        rVar.b(Integer.valueOf(Integer.parseInt(optJSONObject.getString("value"))));
                                        break;
                                    } else {
                                        break;
                                    }
                                case -805218727:
                                    if (optString2.equals(DaClient.ATTR_SEQUENCE_ID)) {
                                        rVar.d(Integer.valueOf(Integer.parseInt(optJSONObject.getString("value"))));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 104446:
                                    if (optString2.equals(DaClient.ATTR_IOD)) {
                                        rVar.a(Integer.valueOf(Integer.parseInt(optJSONObject.getString("value"))));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 109407362:
                                    if (optString2.equals(DaClient.ATTR_SHIFT)) {
                                        rVar.e(Integer.valueOf(Integer.parseInt(optJSONObject.getString("value"))));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 497043690:
                                    if (optString2.equals(DaClient.ATTR_FACE_ROI)) {
                                        List<String> L0 = StringsKt__StringsKt.L0(optJSONObject.getString("value"), new String[]{Constants.ACCEPT_TIME_SEPARATOR_SP}, false, 0, 6, (Object) null);
                                        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(L0, 10));
                                        for (String parseInt : L0) {
                                            arrayList.add(Integer.valueOf(Integer.parseInt(parseInt)));
                                        }
                                        rVar.a(s.a(arrayList));
                                        break;
                                    } else {
                                        break;
                                    }
                                case 1423766638:
                                    if (optString2.equals(DaClient.ATTR_PSEUDO_YAW)) {
                                        rVar.c(Integer.valueOf(Integer.parseInt(optJSONObject.getString("value"))));
                                        break;
                                    } else {
                                        break;
                                    }
                            }
                        }
                    }
                }
                return rVar;
            } catch (JSONException e11) {
                Log.e("Could not parse pose event: " + e11);
                return null;
            }
        }
    }

    public r() {
        this(0);
    }

    public r(long j11, JumioRect jumioRect, Integer num, Integer num2, Integer num3, Integer num4, Integer num5) {
        this.f56508a = j11;
        this.f56509b = jumioRect;
        this.f56510c = num;
        this.f56511d = num2;
        this.f56512e = num3;
        this.f56513f = num4;
        this.f56514g = num5;
    }

    public final void a(long j11) {
        this.f56508a = j11;
    }

    public final Integer b() {
        return this.f56513f;
    }

    public final Integer c() {
        return this.f56514g;
    }

    public final long d() {
        return this.f56508a;
    }

    public final void e(Integer num) {
        this.f56511d = num;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof r)) {
            return false;
        }
        r rVar = (r) obj;
        return this.f56508a == rVar.f56508a && x.b(this.f56509b, rVar.f56509b) && x.b(this.f56510c, rVar.f56510c) && x.b(this.f56511d, rVar.f56511d) && x.b(this.f56512e, rVar.f56512e) && x.b(this.f56513f, rVar.f56513f) && x.b(this.f56514g, rVar.f56514g);
    }

    public final int hashCode() {
        int hashCode = (this.f56509b.hashCode() + (com.fluttercandies.photo_manager.core.entity.a.a(this.f56508a) * 31)) * 31;
        Integer num = this.f56510c;
        int i11 = 0;
        int hashCode2 = (hashCode + (num == null ? 0 : num.hashCode())) * 31;
        Integer num2 = this.f56511d;
        int hashCode3 = (hashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
        Integer num3 = this.f56512e;
        int hashCode4 = (hashCode3 + (num3 == null ? 0 : num3.hashCode())) * 31;
        Integer num4 = this.f56513f;
        int hashCode5 = (hashCode4 + (num4 == null ? 0 : num4.hashCode())) * 31;
        Integer num5 = this.f56514g;
        if (num5 != null) {
            i11 = num5.hashCode();
        }
        return hashCode5 + i11;
    }

    public final String toString() {
        long j11 = this.f56508a;
        JumioRect jumioRect = this.f56509b;
        Integer num = this.f56510c;
        Integer num2 = this.f56511d;
        Integer num3 = this.f56512e;
        Integer num4 = this.f56513f;
        Integer num5 = this.f56514g;
        return "PoseEvent(timestamp=" + j11 + ", faceRoi=" + jumioRect + ", iod=" + num + ", shift=" + num2 + ", sequenceId=" + num3 + ", pseudoPitch=" + num4 + ", pseudoYaw=" + num5 + ")";
    }

    public final JumioRect a() {
        return this.f56509b;
    }

    public final void b(Integer num) {
        this.f56513f = num;
    }

    public final void c(Integer num) {
        this.f56514g = num;
    }

    public final void d(Integer num) {
        this.f56512e = num;
    }

    public final boolean e() {
        return !this.f56509b.isEmpty();
    }

    public final void a(JumioRect jumioRect) {
        this.f56509b = jumioRect;
    }

    public final void a(Integer num) {
        this.f56510c = num;
    }

    public /* synthetic */ r(int i11) {
        this(0, new JumioRect(0, 0, 0, 0, 15, (kotlin.jvm.internal.r) null), (Integer) null, (Integer) null, (Integer) null, (Integer) null, (Integer) null);
    }
}
