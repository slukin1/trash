package xe;

import kotlin.jvm.internal.x;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    public String f26363a;

    public c(String str) {
        this.f26363a = str;
    }

    public final String a() {
        return this.f26363a;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof c) && x.b(this.f26363a, ((c) obj).f26363a);
    }

    public int hashCode() {
        return this.f26363a.hashCode();
    }

    public String toString() {
        return "DynamicDelEvent(dynamicId=" + this.f26363a + ')';
    }
}
