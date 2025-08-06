package n2;

import android.content.Context;
import com.alibaba.sdk.android.beacon.Beacon;
import com.alibaba.sdk.android.httpdns.log.HttpDnsLog;
import java.util.HashMap;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class a {

    /* renamed from: n2.a$a  reason: collision with other inner class name */
    public static class C0093a implements Beacon.f {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ q2.a f16186a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ String f16187b;

        public C0093a(q2.a aVar, String str) {
            this.f16186a = aVar;
            this.f16187b = str;
        }

        public void a(List<Beacon.c> list) {
            if (list != null && list.size() > 0) {
                for (Beacon.c next : list) {
                    if (next.f14464a.equals("___httpdns_service___")) {
                        try {
                            JSONObject jSONObject = new JSONObject(next.f14465b);
                            if (jSONObject.optString("status", "normal").equals("disabled")) {
                                this.f16186a.n(true);
                                HttpDnsLog.i("beacon disabled");
                            } else {
                                this.f16186a.n(false);
                                HttpDnsLog.b("beacon normal");
                            }
                            if (jSONObject.optString("ut", "normal").equals("disabled")) {
                                s2.b.f(this.f16187b, false);
                            } else {
                                s2.b.f(this.f16187b, true);
                            }
                            if (jSONObject.optString("ip-ranking", "normal").equals("disabled")) {
                                this.f16186a.p(true);
                                HttpDnsLog.i("beacon probe disabled");
                            } else {
                                this.f16186a.p(false);
                                HttpDnsLog.b("beacon probe normal");
                            }
                        } catch (JSONException e11) {
                            e11.printStackTrace();
                        }
                    }
                }
            }
        }
    }

    public static class b implements Beacon.e {
        public void a(Beacon.d dVar) {
            HttpDnsLog.i("beacon err " + dVar.f14466a + " " + dVar.f14467b);
        }
    }

    public static void a(Context context, String str, q2.a aVar) {
        if (context == null || str == null || str.isEmpty() || aVar == null) {
            HttpDnsLog.i("params is empty");
            return;
        }
        HashMap hashMap = new HashMap();
        hashMap.put("sdkId", "httpdns");
        hashMap.put("sdkVer", "2.2.2");
        hashMap.put("accountId", str);
        Beacon a11 = new Beacon.Builder().b().d(false).c(hashMap).a();
        a11.l(new C0093a(aVar, str));
        a11.k(new b());
        a11.x(context);
    }
}
