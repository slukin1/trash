package com.hbg.module.community.ui;

import com.hbg.module.community.data.TopicData;
import d10.l;
import d10.p;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.i0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class PostDynamicActivity$initObserve$2 extends Lambda implements l<String, Unit> {
    public final /* synthetic */ PostDynamicActivity this$0;

    @d(c = "com.hbg.module.community.ui.PostDynamicActivity$initObserve$2$1", f = "PostDynamicActivity.kt", l = {210}, m = "invokeSuspend")
    /* renamed from: com.hbg.module.community.ui.PostDynamicActivity$initObserve$2$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(str, postDynamicActivity, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.label;
            if (i11 == 0) {
                k.b(obj);
                List<TopicData> c11 = rd.d.f23353a.c(str, TopicData.class);
                postDynamicActivity.f17496n.clear();
                if (c11 == null || !(!c11.isEmpty())) {
                    StringBuilder unused = StringsKt__StringBuilderJVMKt.i(postDynamicActivity.f17497o);
                    postDynamicActivity.f17496n.clear();
                } else {
                    postDynamicActivity.f17496n.addAll(c11);
                    StringBuilder unused2 = StringsKt__StringBuilderJVMKt.i(postDynamicActivity.f17497o);
                    PostDynamicActivity postDynamicActivity = postDynamicActivity;
                    for (TopicData topicId : c11) {
                        StringBuilder Eh = postDynamicActivity.f17497o;
                        StringBuilder sb2 = new StringBuilder();
                        sb2.append(topicId.getTopicId());
                        sb2.append(',');
                        Eh.append(sb2.toString());
                    }
                    if (postDynamicActivity.f17497o.length() > 0) {
                        postDynamicActivity.f17497o.deleteCharAt(postDynamicActivity.f17497o.length() - 1);
                    }
                }
                MainCoroutineDispatcher c12 = v0.c();
                final PostDynamicActivity postDynamicActivity2 = postDynamicActivity;
                AnonymousClass2 r12 = new p<h0, c<? super Unit>, Object>((c<? super AnonymousClass2>) null) {
                    public int label;

                    public final c<Unit> create(Object obj, c<?> cVar) {
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        public PostDynamicActivity$initObserve$2(PostDynamicActivity postDynamicActivity) {
                            super(1);
                            this.this$0 = postDynamicActivity;
                        }

                        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                            invoke((String) obj);
                            return Unit.f56620a;
                        }

                        public final void invoke(final String str) {
                            this.this$0.f17495m = str;
                            h0 a11 = i0.a(v0.b());
                            final PostDynamicActivity postDynamicActivity = this.this$0;
                            n1 unused = i.d(a11, (CoroutineContext) null, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 3, (Object) null);
                        }
                    }
