package com.hbg.module.community.ui;

import androidx.lifecycle.MutableLiveData;
import com.hbg.lib.network.hbg.core.bean.ShareResultBean;
import com.hbg.lib.network.retrofit.exception.APIStatusErrorException;
import com.hbg.module.libkt.base.ext.RequestExtKt;
import d10.l;
import d10.p;
import d9.a;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import v7.b;

public final class DynamicDetailActivity$doShareAction$1$1 extends Lambda implements l<Integer, Unit> {
    public final /* synthetic */ DynamicDetailActivity this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DynamicDetailActivity$doShareAction$1$1(DynamicDetailActivity dynamicDetailActivity) {
        super(1);
        this.this$0 = dynamicDetailActivity;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke(((Number) obj).intValue());
        return Unit.f56620a;
    }

    public final void invoke(int i11) {
        a<ShareResultBean> V0 = b.a().V0(this.this$0.f17327i, "4", i11);
        final DynamicDetailActivity dynamicDetailActivity = this.this$0;
        AnonymousClass1 r42 = new l<ShareResultBean, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((ShareResultBean) obj);
                return Unit.f56620a;
            }

            /* JADX WARNING: Code restructure failed: missing block: B:3:0x000b, code lost:
                r1 = r4.getShared();
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public final void invoke(com.hbg.lib.network.hbg.core.bean.ShareResultBean r4) {
                /*
                    r3 = this;
                    com.hbg.module.community.ui.DynamicDetailActivity r0 = r10
                    com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r0 = r0.f17332n
                    if (r0 != 0) goto L_0x0009
                    goto L_0x001a
                L_0x0009:
                    if (r4 == 0) goto L_0x0016
                    java.lang.Integer r1 = r4.getShared()
                    if (r1 == 0) goto L_0x0016
                    int r1 = r1.intValue()
                    goto L_0x0017
                L_0x0016:
                    r1 = 0
                L_0x0017:
                    r0.setShared(r1)
                L_0x001a:
                    com.hbg.module.community.ui.DynamicDetailActivity r0 = r10
                    lc.c r0 = com.hbg.module.community.ui.DynamicDetailActivity.Mh(r0)
                    com.hbg.module.community.ui.DynamicDetailActivity r1 = r10
                    com.hbg.lib.network.hbg.core.bean.DynamicDetailInfo r1 = r1.f17332n
                    r0.M(r1)
                    com.hbg.module.community.ui.DynamicDetailActivity r0 = r10
                    java.lang.StringBuilder r1 = new java.lang.StringBuilder
                    r1.<init>()
                    java.lang.String r2 = "转发次数 Success : "
                    r1.append(r2)
                    if (r4 == 0) goto L_0x003c
                    java.lang.Integer r4 = r4.getShared()
                    goto L_0x003d
                L_0x003c:
                    r4 = 0
                L_0x003d:
                    r1.append(r4)
                    java.lang.String r4 = r1.toString()
                    r0.Ki(r4)
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.hbg.module.community.ui.DynamicDetailActivity$doShareAction$1$1.AnonymousClass1.invoke(com.hbg.lib.network.hbg.core.bean.ShareResultBean):void");
            }
        };
        final DynamicDetailActivity dynamicDetailActivity2 = this.this$0;
        RequestExtKt.d(V0, r42, new p<Throwable, APIStatusErrorException, Unit>() {
            public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
                invoke((Throwable) obj, (APIStatusErrorException) obj2);
                return Unit.f56620a;
            }

            public final void invoke(Throwable th2, APIStatusErrorException aPIStatusErrorException) {
                DynamicDetailActivity dynamicDetailActivity = dynamicDetailActivity2;
                dynamicDetailActivity.Ki("转发次数 Error : " + th2 + " 、" + aPIStatusErrorException);
            }
        }, (MutableLiveData) null, 4, (Object) null);
    }
}
