package androidx.databinding;

import android.util.Log;
import android.view.View;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

public class MergedDataBinderMapper extends DataBinderMapper {

    /* renamed from: a  reason: collision with root package name */
    public Set<Class<? extends DataBinderMapper>> f8861a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    public List<DataBinderMapper> f8862b = new CopyOnWriteArrayList();

    /* renamed from: c  reason: collision with root package name */
    public List<String> f8863c = new CopyOnWriteArrayList();

    public f b(b bVar, View view, int i11) {
        for (DataBinderMapper b11 : this.f8862b) {
            f b12 = b11.b(bVar, view, i11);
            if (b12 != null) {
                return b12;
            }
        }
        if (e()) {
            return b(bVar, view, i11);
        }
        return null;
    }

    public f c(b bVar, View[] viewArr, int i11) {
        for (DataBinderMapper c11 : this.f8862b) {
            f c12 = c11.c(bVar, viewArr, i11);
            if (c12 != null) {
                return c12;
            }
        }
        if (e()) {
            return c(bVar, viewArr, i11);
        }
        return null;
    }

    public void d(DataBinderMapper dataBinderMapper) {
        if (this.f8861a.add(dataBinderMapper.getClass())) {
            this.f8862b.add(dataBinderMapper);
            for (DataBinderMapper d11 : dataBinderMapper.a()) {
                d(d11);
            }
        }
    }

    public final boolean e() {
        boolean z11 = false;
        for (String next : this.f8863c) {
            try {
                Class<?> cls = Class.forName(next);
                if (DataBinderMapper.class.isAssignableFrom(cls)) {
                    d((DataBinderMapper) cls.newInstance());
                    this.f8863c.remove(next);
                    z11 = true;
                }
            } catch (ClassNotFoundException unused) {
            } catch (IllegalAccessException e11) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + next, e11);
            } catch (InstantiationException e12) {
                Log.e("MergedDataBinderMapper", "unable to add feature mapper for " + next, e12);
            }
        }
        return z11;
    }
}
