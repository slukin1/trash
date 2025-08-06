package com.sumsub.sns.internal.ml.core;

import com.iproov.sdk.bridge.OptionsBridge;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public interface e<Input, Output> {

    public static abstract class a<Output> {

        /* renamed from: a  reason: collision with root package name */
        public static final C0410a f35019a = new C0410a((r) null);

        /* renamed from: b  reason: collision with root package name */
        public static final String f35020b = "skip";

        /* renamed from: com.sumsub.sns.internal.ml.core.e$a$a  reason: collision with other inner class name */
        public static final class C0410a {
            public /* synthetic */ C0410a(r rVar) {
                this();
            }

            public C0410a() {
            }
        }

        public static final class b<Output> extends a<Output> {

            /* renamed from: c  reason: collision with root package name */
            public final Throwable f35021c;

            public b(Throwable th2) {
                super((r) null);
                this.f35021c = th2;
            }

            public final b<Output> a(Throwable th2) {
                return new b<>(th2);
            }

            public String a() {
                return "error";
            }

            public final Throwable b() {
                return this.f35021c;
            }

            public final Throwable c() {
                return this.f35021c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof b) && x.b(this.f35021c, ((b) obj).f35021c);
            }

            public int hashCode() {
                return this.f35021c.hashCode();
            }

            public String toString() {
                return "Error(throwable=" + this.f35021c + ')';
            }

            public static /* synthetic */ b a(b bVar, Throwable th2, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    th2 = bVar.f35021c;
                }
                return bVar.a(th2);
            }
        }

        public static final class c<Output> extends a<Output> {
            public c() {
                super((r) null);
            }

            public String a() {
                return a.f35020b;
            }
        }

        public static final class d<Output> extends a<Output> {

            /* renamed from: c  reason: collision with root package name */
            public final Output f35022c;

            public d(Output output) {
                super((r) null);
                this.f35022c = output;
            }

            public final d<Output> a(Output output) {
                return new d<>(output);
            }

            public String a() {
                return "success";
            }

            public final Output b() {
                return this.f35022c;
            }

            public final Output c() {
                return this.f35022c;
            }

            public boolean equals(Object obj) {
                if (this == obj) {
                    return true;
                }
                return (obj instanceof d) && x.b(this.f35022c, ((d) obj).f35022c);
            }

            public int hashCode() {
                Output output = this.f35022c;
                if (output == null) {
                    return 0;
                }
                return output.hashCode();
            }

            public String toString() {
                return "Success(result=" + this.f35022c + ')';
            }

            public static /* synthetic */ d a(d dVar, Output output, int i11, Object obj) {
                if ((i11 & 1) != 0) {
                    output = dVar.f35022c;
                }
                return dVar.a(output);
            }
        }

        /* renamed from: com.sumsub.sns.internal.ml.core.e$a$e  reason: collision with other inner class name */
        public static final class C0411e<Output> extends a<Output> {
            public C0411e() {
                super((r) null);
            }

            public String a() {
                return OptionsBridge.TIMEOUT_KEY;
            }
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public abstract String a();

        public a() {
        }
    }

    Object a(Input input, c<? super a<Output>> cVar);

    Object a(c<? super Unit> cVar);
}
