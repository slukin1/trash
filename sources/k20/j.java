package k20;

import com.sumsub.sns.internal.core.common.n0;
import java.lang.reflect.Method;
import org.greenrobot.eventbus.ThreadMode;

public class j {

    /* renamed from: a  reason: collision with root package name */
    public final Method f68235a;

    /* renamed from: b  reason: collision with root package name */
    public final ThreadMode f68236b;

    /* renamed from: c  reason: collision with root package name */
    public final Class<?> f68237c;

    /* renamed from: d  reason: collision with root package name */
    public final int f68238d;

    /* renamed from: e  reason: collision with root package name */
    public final boolean f68239e;

    /* renamed from: f  reason: collision with root package name */
    public String f68240f;

    public j(Method method, Class<?> cls, ThreadMode threadMode, int i11, boolean z11) {
        this.f68235a = method;
        this.f68236b = threadMode;
        this.f68237c = cls;
        this.f68238d = i11;
        this.f68239e = z11;
    }

    public final synchronized void a() {
        if (this.f68240f == null) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append(this.f68235a.getDeclaringClass().getName());
            sb2.append(n0.h.f32179b);
            sb2.append(this.f68235a.getName());
            sb2.append('(');
            sb2.append(this.f68237c.getName());
            this.f68240f = sb2.toString();
        }
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof j)) {
            return false;
        }
        a();
        j jVar = (j) obj;
        jVar.a();
        return this.f68240f.equals(jVar.f68240f);
    }

    public int hashCode() {
        return this.f68235a.hashCode();
    }
}
