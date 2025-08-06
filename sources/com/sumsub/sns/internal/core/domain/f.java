package com.sumsub.sns.internal.core.domain;

import java.io.File;
import kotlin.coroutines.c;
import kotlin.jvm.internal.x;

public final class f extends com.sumsub.sns.internal.core.domain.base.a<File, a> {

    /* renamed from: a  reason: collision with root package name */
    public final com.sumsub.sns.internal.core.data.source.cache.a f33592a;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final String f33593a;

        public a(String str) {
            this.f33593a = str;
        }

        public final String a() {
            return this.f33593a;
        }

        public final String b() {
            return this.f33593a;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return (obj instanceof a) && x.b(this.f33593a, ((a) obj).f33593a);
        }

        public int hashCode() {
            return this.f33593a.hashCode();
        }

        public String toString() {
            return "Params(name=" + this.f33593a + ')';
        }

        public final a a(String str) {
            return new a(str);
        }

        public static /* synthetic */ a a(a aVar, String str, int i11, Object obj) {
            if ((i11 & 1) != 0) {
                str = aVar.f33593a;
            }
            return aVar.a(str);
        }
    }

    public f(com.sumsub.sns.internal.core.data.source.cache.a aVar) {
        this.f33592a = aVar;
    }

    public Object a(a aVar, c<? super File> cVar) {
        return this.f33592a.a(aVar.b(), cVar);
    }

    public f(com.sumsub.sns.internal.core.a aVar) {
        this(aVar.k());
    }
}
