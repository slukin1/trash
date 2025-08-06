package sj;

import java.util.List;
import sj.f;

public class b<T extends f> implements e {

    /* renamed from: a  reason: collision with root package name */
    public Class<T> f47818a;

    public b(Class<T> cls) {
        this.f47818a = cls;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void c(List list, c cVar) {
        try {
            cVar.callback(((f) this.f47818a.newInstance()).a(list));
        } catch (Exception e11) {
            e11.printStackTrace();
        }
    }

    public d a() throws IllegalAccessException, InstantiationException {
        return new a(this);
    }
}
