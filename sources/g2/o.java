package g2;

import com.alibaba.fastjson.JSONException;
import f2.a;
import java.lang.reflect.Type;

public class o implements l {

    /* renamed from: a  reason: collision with root package name */
    public final Class<n> f15816a;

    public o(Class<n> cls) {
        this.f15816a = cls;
    }

    public int b() {
        return 12;
    }

    public <T> T e(a aVar, Type type, Object obj) {
        try {
            return aVar.A(this.f15816a.newInstance(), obj);
        } catch (Exception unused) {
            throw new JSONException("craete instance error");
        }
    }
}
