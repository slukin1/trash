package c9;

import java.util.ArrayList;
import java.util.List;
import okhttp3.Interceptor;

public class c {

    /* renamed from: c  reason: collision with root package name */
    public static c f70559c = new c();

    /* renamed from: a  reason: collision with root package name */
    public boolean f70560a;

    /* renamed from: b  reason: collision with root package name */
    public List<Interceptor> f70561b = new ArrayList();

    public static c b() {
        return f70559c;
    }

    public void a(Interceptor interceptor) {
        this.f70561b.add(interceptor);
    }
}
