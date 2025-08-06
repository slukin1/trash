package yy;

import com.tekartik.sqflite.operation.BaseOperation;
import io.flutter.plugin.common.MethodChannel;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a extends BaseOperation {

    /* renamed from: a  reason: collision with root package name */
    public final Map<String, Object> f40666a;

    /* renamed from: b  reason: collision with root package name */
    public final C0553a f40667b = new C0553a();

    /* renamed from: c  reason: collision with root package name */
    public final boolean f40668c;

    /* renamed from: yy.a$a  reason: collision with other inner class name */
    public class C0553a implements e {

        /* renamed from: a  reason: collision with root package name */
        public Object f40669a;

        /* renamed from: b  reason: collision with root package name */
        public String f40670b;

        /* renamed from: c  reason: collision with root package name */
        public String f40671c;

        /* renamed from: d  reason: collision with root package name */
        public Object f40672d;

        public C0553a() {
        }

        public void error(String str, String str2, Object obj) {
            this.f40670b = str;
            this.f40671c = str2;
            this.f40672d = obj;
        }

        public void success(Object obj) {
            this.f40669a = obj;
        }
    }

    public a(Map<String, Object> map, boolean z11) {
        this.f40666a = map;
        this.f40668c = z11;
    }

    public <T> T a(String str) {
        return this.f40666a.get(str);
    }

    public boolean d() {
        return this.f40668c;
    }

    public e i() {
        return this.f40667b;
    }

    public String j() {
        return (String) this.f40666a.get("method");
    }

    public Map<String, Object> k() {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        hashMap2.put("code", this.f40667b.f40670b);
        hashMap2.put("message", this.f40667b.f40671c);
        hashMap2.put("data", this.f40667b.f40672d);
        hashMap.put("error", hashMap2);
        return hashMap;
    }

    public Map<String, Object> l() {
        HashMap hashMap = new HashMap();
        hashMap.put("result", this.f40667b.f40669a);
        return hashMap;
    }

    public void m(MethodChannel.Result result) {
        C0553a aVar = this.f40667b;
        result.error(aVar.f40670b, aVar.f40671c, aVar.f40672d);
    }

    public void n(List<Map<String, Object>> list) {
        if (!d()) {
            list.add(k());
        }
    }

    public void o(List<Map<String, Object>> list) {
        if (!d()) {
            list.add(l());
        }
    }
}
