package com.hbg.module.libkt.base.ext;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class g<T> {

    public static final class a extends g {

        /* renamed from: a  reason: collision with root package name */
        public final APIStatusErrorException f24521a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f24522b;

        public a(APIStatusErrorException aPIStatusErrorException, Throwable th2) {
            super((r) null);
            this.f24521a = aPIStatusErrorException;
            this.f24522b = th2;
        }

        public final APIStatusErrorException a() {
            return this.f24521a;
        }

        public final Throwable b() {
            return this.f24522b;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f24521a, aVar.f24521a) && x.b(this.f24522b, aVar.f24522b);
        }

        public int hashCode() {
            APIStatusErrorException aPIStatusErrorException = this.f24521a;
            int i11 = 0;
            int hashCode = (aPIStatusErrorException == null ? 0 : aPIStatusErrorException.hashCode()) * 31;
            Throwable th2 = this.f24522b;
            if (th2 != null) {
                i11 = th2.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "Error(error=" + this.f24521a + ", other=" + this.f24522b + ')';
        }
    }

    public static final class b<T> extends g<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f24523a;

        public b(T t11) {
            super((r) null);
            this.f24523a = t11;
        }

        public final T a() {
            return this.f24523a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && x.b(this.f24523a, ((b) obj).f24523a);
        }

        public int hashCode() {
            T t11 = this.f24523a;
            if (t11 == null) {
                return 0;
            }
            return t11.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f24523a + ')';
        }
    }

    public g() {
    }

    public /* synthetic */ g(r rVar) {
        this();
    }
}
