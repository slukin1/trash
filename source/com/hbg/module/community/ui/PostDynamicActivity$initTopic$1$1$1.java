package com.hbg.module.community.ui;

import android.text.TextUtils;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.k;
import kotlinx.coroutines.h0;
import we.b;

@d(c = "com.hbg.module.community.ui.PostDynamicActivity$initTopic$1$1$1", f = "PostDynamicActivity.kt", l = {}, m = "invokeSuspend")
public final class PostDynamicActivity$initTopic$1$1$1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
    public int label;
    public final /* synthetic */ PostDynamicActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public PostDynamicActivity$initTopic$1$1$1(PostDynamicActivity postDynamicActivity, c<? super PostDynamicActivity$initTopic$1$1$1> cVar) {
        super(2, cVar);
        this.this$0 = postDynamicActivity;
    }

    public final c<Unit> create(Object obj, c<?> cVar) {
        return new PostDynamicActivity$initTopic$1$1$1(this.this$0, cVar);
    }

    public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
        return ((PostDynamicActivity$initTopic$1$1$1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
    }

    public final Object invokeSuspend(Object obj) {
        Object unused = IntrinsicsKt__IntrinsicsKt.d();
        if (this.label == 0) {
            k.b(obj);
            PostDynamicActivity postDynamicActivity = this.this$0;
            String a11 = rd.d.f23353a.a(postDynamicActivity.f17498p);
            if (a11 == null) {
                a11 = "";
            }
            postDynamicActivity.f17495m = a11;
            if (!TextUtils.isEmpty(this.this$0.f17495m)) {
                PostDynamicActivity postDynamicActivity2 = this.this$0;
                postDynamicActivity2.f17495m = '[' + this.this$0.f17495m + ']';
                b.m("topicSendData", (Class) null, 2, (Object) null).g(this.this$0.f17495m);
            }
            return Unit.f56620a;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
