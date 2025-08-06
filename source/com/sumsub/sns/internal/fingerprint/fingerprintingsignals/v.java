package com.sumsub.sns.internal.fingerprint.fingerprintingsignals;

import com.sumsub.sns.internal.fingerprint.signalproviders.StabilityLevel;
import java.util.Map;
import kotlin.jvm.internal.r;

public abstract class v<T> {

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final StabilityLevel f34427a;

        public a(StabilityLevel stabilityLevel) {
            this.f34427a = stabilityLevel;
        }

        public final StabilityLevel a() {
            return this.f34427a;
        }

        public final StabilityLevel b() {
            return this.f34427a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && this.f34427a == ((a) obj).f34427a;
        }

        public int hashCode() {
            return this.f34427a.hashCode();
        }

        public String toString() {
            return "Info(stabilityLevel=" + this.f34427a + ')';
        }

        public final a a(StabilityLevel stabilityLevel) {
            return new a(stabilityLevel);
        }

        public static /* synthetic */ a a(a aVar, StabilityLevel stabilityLevel, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                stabilityLevel = aVar.f34427a;
            }
            return aVar.a(stabilityLevel);
        }
    }

    public /* synthetic */ v(r rVar) {
        this();
    }

    public abstract String a();

    public abstract a b();

    public abstract T c();

    public abstract Map<String, String> d();

    public v() {
    }
}
