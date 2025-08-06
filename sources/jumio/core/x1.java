package jumio.core;

import com.jumio.analytics.MetaInfo;
import java.io.Serializable;

public final class x1<T> implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public final T f56344a;

    /* renamed from: b  reason: collision with root package name */
    public final MetaInfo f56345b;

    public x1(T t11, MetaInfo metaInfo) {
        this.f56344a = t11;
        this.f56345b = metaInfo;
    }

    public final MetaInfo a() {
        return this.f56345b;
    }

    public final T b() {
        return this.f56344a;
    }
}
