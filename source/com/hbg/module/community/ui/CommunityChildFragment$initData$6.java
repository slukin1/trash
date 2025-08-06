package com.hbg.module.community.ui;

import d10.l;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;
import xe.b;

public final class CommunityChildFragment$initData$6 extends Lambda implements l<b, Unit> {
    public final /* synthetic */ CommunityChildFragment this$0;

    @d(c = "com.hbg.module.community.ui.CommunityChildFragment$initData$6$1", f = "CommunityChildFragment.kt", l = {284}, m = "invokeSuspend")
    /* renamed from: com.hbg.module.community.ui.CommunityChildFragment$initData$6$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(communityChildFragment, bVar, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                CoroutineDispatcher b11 = v0.b();
                final CommunityChildFragment communityChildFragment = communityChildFragment;
                final b bVar = bVar;
                AnonymousClass1 r12 = new p<h0, c<? super Unit>, Object>((c<? super AnonymousClass1>) null) {
                    public int label;

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public CommunityChildFragment$initData$6(CommunityChildFragment communityChildFragment) {
                            super(1);
                            this.this$0 = communityChildFragment;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((b) obj);
                            return Unit.f56620a;
                        }

                        public final void invoke(final b bVar) {
                            h0 a11 = i0.a(v0.c());
                            final CommunityChildFragment communityChildFragment = this.this$0;
                            n1 unused = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
                        }
                    }
