package com.hbg.module.libkt.base.ext;

import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public abstract class VmState<T> {

    public static final class Empty extends VmState {

        /* renamed from: a  reason: collision with root package name */
        public final int f24506a;

        public Empty() {
            this(0, 1, (r) null);
        }

        public Empty(int i11) {
            super((r) null);
            this.f24506a = i11;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof Empty) && this.f24506a == ((Empty) obj).f24506a;
        }

        public int hashCode() {
            return this.f24506a;
        }

        public String toString() {
            return "Empty(empty=" + this.f24506a + ')';
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Empty(int i11, int i12, r rVar) {
            this((i12 & 1) != 0 ? 0 : i11);
        }
    }

    public static final class a extends VmState {

        /* renamed from: a  reason: collision with root package name */
        public final APIStatusErrorException f24507a;

        /* renamed from: b  reason: collision with root package name */
        public final Throwable f24508b;

        public a(APIStatusErrorException aPIStatusErrorException, Throwable th2) {
            super((r) null);
            this.f24507a = aPIStatusErrorException;
            this.f24508b = th2;
        }

        public final APIStatusErrorException a() {
            return this.f24507a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof a)) {
                return false;
            }
            a aVar = (a) obj;
            return x.b(this.f24507a, aVar.f24507a) && x.b(this.f24508b, aVar.f24508b);
        }

        public int hashCode() {
            APIStatusErrorException aPIStatusErrorException = this.f24507a;
            int i11 = 0;
            int hashCode = (aPIStatusErrorException == null ? 0 : aPIStatusErrorException.hashCode()) * 31;
            Throwable th2 = this.f24508b;
            if (th2 != null) {
                i11 = th2.hashCode();
            }
            return hashCode + i11;
        }

        public String toString() {
            return "Error(error=" + this.f24507a + ", other=" + this.f24508b + ')';
        }
    }

    public static final class b<T> extends VmState<T> {

        /* renamed from: a  reason: collision with root package name */
        public final T f24509a;

        public b(T t11) {
            super((r) null);
            this.f24509a = t11;
        }

        public final T a() {
            return this.f24509a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof b) && x.b(this.f24509a, ((b) obj).f24509a);
        }

        public int hashCode() {
            T t11 = this.f24509a;
            if (t11 == null) {
                return 0;
            }
            return t11.hashCode();
        }

        public String toString() {
            return "Success(data=" + this.f24509a + ')';
        }
    }

    public VmState() {
    }

    public /* synthetic */ VmState(r rVar) {
        this();
    }
}
