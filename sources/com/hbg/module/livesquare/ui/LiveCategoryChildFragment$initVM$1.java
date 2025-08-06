package com.hbg.module.livesquare.ui;

import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.v;
import com.hbg.lib.network.hbg.core.bean.LiveCategoryListData;
import com.hbg.lib.network.hbg.core.bean.LiveDetailBean;
import com.hbg.module.libkt.base.ext.VmState;
import com.hbg.module.libkt.base.ext.b;
import com.hbg.module.livesquare.adapter.CategoryListAdapter;
import d10.l;
import d10.p;
import java.util.ArrayList;
import java.util.List;
import kotlin.Unit;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.Lambda;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class LiveCategoryChildFragment$initVM$1 extends Lambda implements l<VmState<? extends LiveCategoryListData>, Unit> {
    public final /* synthetic */ LiveCategoryChildFragment this$0;

    @d(c = "com.hbg.module.livesquare.ui.LiveCategoryChildFragment$initVM$1$1", f = "LiveCategoryChildFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.hbg.module.livesquare.ui.LiveCategoryChildFragment$initVM$1$1  reason: invalid class name */
    public static final class AnonymousClass1 extends SuspendLambda implements p<h0, c<? super Unit>, Object> {
        public int label;

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new AnonymousClass1(liveCategoryListData, liveCategoryChildFragment, cVar);
        }

        public final Object invoke(h0 h0Var, c<? super Unit> cVar) {
            return ((AnonymousClass1) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.label == 0) {
                k.b(obj);
                LiveCategoryListData liveCategoryListData = liveCategoryListData;
                if (liveCategoryListData != null && !b.w(liveCategoryListData.getListData())) {
                    ArrayList arrayList = new ArrayList();
                    List<LiveDetailBean> listData = liveCategoryListData.getListData();
                    LiveCategoryChildFragment liveCategoryChildFragment = liveCategoryChildFragment;
                    LiveCategoryListData liveCategoryListData2 = liveCategoryListData;
                    for (LiveDetailBean liveDetailBean : listData) {
                        int Vh = liveCategoryChildFragment.f26564q;
                        int i11 = 8;
                        int i12 = 2;
                        if (Vh == 1) {
                            i12 = 4;
                        } else if (Vh != 2) {
                            i12 = 8;
                        }
                        liveDetailBean.setModuleType(i12);
                        if (liveCategoryChildFragment.f26564q != 3) {
                            i11 = liveCategoryListData2.getListData().size() > 1 ? 4 : 3;
                        }
                        liveDetailBean.setViewType(i11);
                        liveDetailBean.setEquId(liveDetailBean.f70249id.toString());
                        arrayList.add(liveDetailBean);
                    }
                    CategoryListAdapter Sh = liveCategoryChildFragment.f26567t;
                    if (Sh != null) {
                        Sh.a(liveCategoryChildFragment.f26566s == 1 ? 0 : 1, arrayList);
                    }
                    LiveCategoryChildFragment liveCategoryChildFragment2 = liveCategoryChildFragment;
                    liveCategoryChildFragment2.f26566s = liveCategoryChildFragment2.f26566s + 1;
                    LiveCategoryChildFragment.Th(liveCategoryChildFragment).B.g();
                } else if (liveCategoryChildFragment.f26566s == 1) {
                    LiveCategoryChildFragment.Th(liveCategoryChildFragment).B.i();
                } else {
                    LiveCategoryChildFragment.Th(liveCategoryChildFragment).C.e();
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public LiveCategoryChildFragment$initVM$1(LiveCategoryChildFragment liveCategoryChildFragment) {
        super(1);
        this.this$0 = liveCategoryChildFragment;
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((VmState<? extends LiveCategoryListData>) (VmState) obj);
        return Unit.f56620a;
    }

    public final void invoke(VmState<? extends LiveCategoryListData> vmState) {
        LiveCategoryChildFragment.Th(this.this$0).C.finishRefresh();
        LiveCategoryChildFragment.Th(this.this$0).C.w();
        this.this$0.sh();
        if (vmState != null && (vmState instanceof VmState.b)) {
            final LiveCategoryListData liveCategoryListData = (LiveCategoryListData) ((VmState.b) vmState).a();
            LifecycleCoroutineScope a11 = v.a(this.this$0);
            MainCoroutineDispatcher c11 = v0.c();
            final LiveCategoryChildFragment liveCategoryChildFragment = this.this$0;
            n1 unused = i.d(a11, c11, (CoroutineStart) null, new AnonymousClass1((c<? super AnonymousClass1>) null), 2, (Object) null);
        } else if (this.this$0.f26566s == 1) {
            LiveCategoryChildFragment.Th(this.this$0).B.k();
        }
    }
}
