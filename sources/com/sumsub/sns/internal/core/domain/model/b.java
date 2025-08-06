package com.sumsub.sns.internal.core.domain.model;

import com.sumsub.sns.internal.core.domain.model.a;
import d10.l;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Lambda;

public final class b {

    public static final class a extends Lambda implements l<A, C> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ l<B, C> f33639a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ l<A, B> f33640b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(l<? super B, ? extends C> lVar, l<? super A, ? extends B> lVar2) {
            super(1);
            this.f33639a = lVar;
            this.f33640b = lVar2;
        }

        public final C invoke(A a11) {
            return this.f33639a.invoke(this.f33640b.invoke(a11));
        }
    }

    /* renamed from: com.sumsub.sns.internal.core.domain.model.b$b  reason: collision with other inner class name */
    public /* synthetic */ class C0373b extends FunctionReferenceImpl implements l<T, a.b<? extends T>> {
        public C0373b(Object obj) {
            super(1, obj, a.class, TtmlNode.RIGHT, "right(Ljava/lang/Object;)Lcom/sumsub/sns/internal/core/domain/model/Either$Right;", 0);
        }

        /* renamed from: a */
        public final a.b<T> invoke(T t11) {
            return ((a) this.receiver).b(t11);
        }
    }

    public static final <A, B, C> l<A, C> a(l<? super A, ? extends B> lVar, l<? super B, ? extends C> lVar2) {
        return new a(lVar2, lVar);
    }

    public static final <T, L, R> a<L, T> b(a<? extends L, ? extends R> aVar, l<? super R, ? extends T> lVar) {
        return a(aVar, a(lVar, new C0373b(aVar)));
    }

    public static final <T, L, R> a<L, T> a(a<? extends L, ? extends R> aVar, l<? super R, ? extends a<? extends L, ? extends T>> lVar) {
        if (aVar instanceof a.C0372a) {
            return new a.C0372a(((a.C0372a) aVar).d());
        }
        if (aVar instanceof a.b) {
            return (a) lVar.invoke(((a.b) aVar).d());
        }
        throw new NoWhenBranchMatchedException();
    }
}
