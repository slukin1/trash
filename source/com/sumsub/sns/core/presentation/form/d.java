package com.sumsub.sns.core.presentation.form;

import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.activity.result.ActivityResultRegistry;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.sumsub.sns.R;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.presentation.form.FieldId;
import com.sumsub.sns.internal.core.presentation.form.b;
import com.sumsub.sns.internal.core.presentation.form.model.FormItem;
import com.sumsub.sns.internal.core.presentation.form.model.b;
import d10.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.MagicApiIntrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.reflect.l;
import kotlinx.coroutines.flow.j1;

@Metadata(bv = {}, d1 = {"\u0000¶\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0007\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\b*\u0002DR\u0018\u0000 e2\u00020\u0001:\u0001\u0007B\u0007¢\u0006\u0004\bc\u0010dJ\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0003\u001a\u00020\u00022\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\u001c\u0010\u0007\u001a\u00020\u00062\b\u0010\n\u001a\u0004\u0018\u00010\t2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0002J\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J\u0010\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u0018\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00130\r*\b\u0012\u0004\u0012\u00020\u00130\rH\u0002J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00130\r2\u0006\u0010\u0010\u001a\u00020\u000eH\u0002J\u0018\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J \u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\t2\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020\u0018\u0018\u00010\rH\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\t2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0018H\u0002J\u0012\u0010\u001b\u001a\u00020\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J&\u0010!\u001a\u0004\u0018\u00010 2\u0006\u0010\u001d\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001e2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\u001a\u0010#\u001a\u00020\u00062\u0006\u0010\"\u001a\u00020 2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004H\u0016J\b\u0010$\u001a\u00020\u0006H\u0016J\b\u0010%\u001a\u00020\u0006H\u0016J\u0010\u0010'\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0004H\u0016J\u0006\u0010(\u001a\u00020\u0015R\u0018\u0010\u0010\u001a\u0004\u0018\u00010\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0007\u0010)R\u001d\u0010.\u001a\u0004\u0018\u00010*8BX\u0002¢\u0006\f\n\u0004\b\u0011\u0010+\u001a\u0004\b,\u0010-R\u001d\u00101\u001a\u0004\u0018\u00010*8BX\u0002¢\u0006\f\n\u0004\b/\u0010+\u001a\u0004\b0\u0010-R\u001d\u00106\u001a\u0004\u0018\u0001028BX\u0002¢\u0006\f\n\u0004\b3\u0010+\u001a\u0004\b4\u00105R\u0018\u00109\u001a\u0004\u0018\u0001078\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b4\u00108R\u0018\u0010=\u001a\u0004\u0018\u00010:8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b;\u0010<R\u0018\u0010@\u001a\u0004\u0018\u00010>8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b0\u0010?R\u0014\u0010C\u001a\u00020A8\u0002X\u0004¢\u0006\u0006\n\u0004\b,\u0010BR\u0014\u0010F\u001a\u00020D8\u0002X\u0004¢\u0006\u0006\n\u0004\b\b\u0010ER\u0016\u0010H\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0012\u0010GR\u001c\u0010J\u001a\b\u0012\u0004\u0012\u00020\u00130\r8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b(\u0010IR\"\u0010O\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\t0K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bM\u0010NR\u0016\u0010Q\u001a\u00020\u00158\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010GR\u0014\u0010U\u001a\u00020R8\u0002X\u0004¢\u0006\u0006\n\u0004\bS\u0010TR\u001b\u0010Z\u001a\u00020V8BX\u0002¢\u0006\f\n\u0004\bW\u0010X\u001a\u0004\b3\u0010YR\u0014\u0010\\\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010[R\u0014\u0010]\u001a\u00020\t8BX\u0004¢\u0006\u0006\u001a\u0004\b;\u0010[R\u0016\u0010`\u001a\u0004\u0018\u00010^8BX\u0004¢\u0006\u0006\u001a\u0004\b/\u0010_R\u0016\u0010b\u001a\u0004\u0018\u00010\u001e8BX\u0004¢\u0006\u0006\u001a\u0004\b\u0011\u0010a¨\u0006f"}, d2 = {"Lcom/sumsub/sns/core/presentation/form/d;", "Landroidx/fragment/app/Fragment;", "Lcom/sumsub/sns/internal/core/presentation/form/b$a;", "state", "Landroid/os/Bundle;", "savedInstanceState", "", "a", "i", "", "mimeTypes", "", "currentPageNumber", "", "Lcom/sumsub/sns/internal/core/presentation/form/b$b;", "pages", "page", "b", "j", "Lcom/sumsub/sns/internal/core/presentation/form/model/FormItem;", "formItem", "", "valid", "requestId", "Landroid/net/Uri;", "uris", "uri", "onCreate", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "view", "onViewCreated", "onDestroyView", "onDestroy", "outState", "onSaveInstanceState", "k", "Lcom/sumsub/sns/internal/core/presentation/form/b$b;", "Landroid/widget/TextView;", "Lcom/sumsub/sns/internal/core/common/z;", "h", "()Landroid/widget/TextView;", "tvTitle", "c", "g", "tvSubtitle", "Landroidx/recyclerview/widget/RecyclerView;", "d", "e", "()Landroidx/recyclerview/widget/RecyclerView;", "list", "Landroidx/recyclerview/widget/LinearLayoutManager;", "Landroidx/recyclerview/widget/LinearLayoutManager;", "listLayoutManager", "Lcom/sumsub/sns/core/presentation/form/viewadapter/i;", "f", "Lcom/sumsub/sns/core/presentation/form/viewadapter/i;", "formItemAdapter", "Lcom/sumsub/sns/internal/core/android/a;", "Lcom/sumsub/sns/internal/core/android/a;", "observer", "Lcom/sumsub/sns/core/presentation/util/a;", "Lcom/sumsub/sns/core/presentation/util/a;", "uniqueIdHolder", "com/sumsub/sns/core/presentation/form/d$d", "Lcom/sumsub/sns/core/presentation/form/d$d;", "itemValueProvider", "Z", "scrollRestored", "Ljava/util/List;", "visibleItems", "", "Lcom/sumsub/sns/internal/core/presentation/form/FieldId;", "l", "Ljava/util/Map;", "itemErrorMap", "m", "disableSubmitModelUpdates", "com/sumsub/sns/core/presentation/form/d$b", "n", "Lcom/sumsub/sns/core/presentation/form/d$b;", "fieldViewCallback", "Lcom/sumsub/sns/internal/core/presentation/form/d;", "o", "Lkotlin/i;", "()Lcom/sumsub/sns/internal/core/presentation/form/d;", "itemValueCache", "()Ljava/lang/String;", "clientTag", "logTag", "Lcom/sumsub/sns/internal/core/presentation/form/b;", "()Lcom/sumsub/sns/internal/core/presentation/form/b;", "hostViewModel", "()Landroid/view/ViewGroup;", "content", "<init>", "()V", "p", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class d extends Fragment {

    /* renamed from: p  reason: collision with root package name */
    public static final a f30929p = new a((r) null);

    /* renamed from: q  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f30930q = {Reflection.j(new PropertyReference1Impl(d.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(d.class, "tvSubtitle", "getTvSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(d.class, "list", "getList()Landroidx/recyclerview/widget/RecyclerView;", 0))};

    /* renamed from: r  reason: collision with root package name */
    public static final String f30931r = "SCROLL_STATE";

    /* renamed from: s  reason: collision with root package name */
    public static final String f30932s = "OBSERVER_ITEM_ID";

    /* renamed from: t  reason: collision with root package name */
    public static final String f30933t = "client_tag";

    /* renamed from: u  reason: collision with root package name */
    public static final String f30934u = "FormFragment";

    /* renamed from: a  reason: collision with root package name */
    public b.C0375b f30935a;

    /* renamed from: b  reason: collision with root package name */
    public final z f30936b = a0.a(this, R.id.sns_title);

    /* renamed from: c  reason: collision with root package name */
    public final z f30937c = a0.a(this, R.id.sns_subtitle);

    /* renamed from: d  reason: collision with root package name */
    public final z f30938d = a0.a(this, R.id.sns_list);

    /* renamed from: e  reason: collision with root package name */
    public LinearLayoutManager f30939e;

    /* renamed from: f  reason: collision with root package name */
    public com.sumsub.sns.core.presentation.form.viewadapter.i f30940f;

    /* renamed from: g  reason: collision with root package name */
    public com.sumsub.sns.internal.core.android.a f30941g;

    /* renamed from: h  reason: collision with root package name */
    public final com.sumsub.sns.core.presentation.util.a f30942h = new com.sumsub.sns.core.presentation.util.a();

    /* renamed from: i  reason: collision with root package name */
    public final C0291d f30943i = new C0291d(this);

    /* renamed from: j  reason: collision with root package name */
    public boolean f30944j;

    /* renamed from: k  reason: collision with root package name */
    public List<? extends FormItem> f30945k = CollectionsKt__CollectionsKt.k();

    /* renamed from: l  reason: collision with root package name */
    public Map<FieldId, String> f30946l = MapsKt__MapsKt.h();

    /* renamed from: m  reason: collision with root package name */
    public boolean f30947m;

    /* renamed from: n  reason: collision with root package name */
    public final b f30948n = new b(this);

    /* renamed from: o  reason: collision with root package name */
    public final kotlin.i f30949o = LazyKt__LazyJVMKt.a(new c(this));

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final Fragment a(String str) {
            Bundle bundle = new Bundle();
            bundle.putString(d.f30933t, str);
            d dVar = new d();
            dVar.setArguments(bundle);
            return dVar;
        }

        public a() {
        }
    }

    public static final class c extends Lambda implements d10.a<com.sumsub.sns.internal.core.presentation.form.d> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30951a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(d dVar) {
            super(0);
            this.f30951a = dVar;
        }

        /* renamed from: a */
        public final com.sumsub.sns.internal.core.presentation.form.d invoke() {
            com.sumsub.sns.internal.core.presentation.form.b b11 = this.f30951a.c();
            if (b11 != null) {
                return b11.a();
            }
            return null;
        }
    }

    /* renamed from: com.sumsub.sns.core.presentation.form.d$d  reason: collision with other inner class name */
    public static final class C0291d implements e {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30952a;

        public C0291d(d dVar) {
            this.f30952a = dVar;
        }

        public String a(FormItem formItem) {
            com.sumsub.sns.internal.core.presentation.form.d d11 = this.f30952a.d();
            String e11 = formItem.e();
            String str = "";
            if (e11 == null) {
                e11 = str;
            }
            String p11 = formItem.d().p();
            if (p11 != null) {
                str = p11;
            }
            return d11.a(e11, str);
        }

        public List<String> b(FormItem formItem) {
            com.sumsub.sns.internal.core.presentation.form.d d11 = this.f30952a.d();
            String e11 = formItem.e();
            String str = "";
            if (e11 == null) {
                e11 = str;
            }
            String p11 = formItem.d().p();
            if (p11 != null) {
                str = p11;
            }
            return d11.b(e11, str);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.form.FormFragment$onViewCreated$2", f = "FormFragment.kt", l = {}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<b.a, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30953a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30954b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ d f30955c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f30956d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(d dVar, Bundle bundle, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f30955c = dVar;
            this.f30956d = bundle;
        }

        /* renamed from: a */
        public final Object invoke(b.a aVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(aVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f30955c, this.f30956d, cVar);
            eVar.f30954b = obj;
            return eVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30953a == 0) {
                k.b(obj);
                this.f30955c.a((b.a) this.f30954b, this.f30956d);
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static final class f extends Lambda implements p<String, Uri, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30957a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(d dVar) {
            super(2);
            this.f30957a = dVar;
        }

        public final void a(String str, Uri uri) {
            this.f30957a.a(str, uri);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (Uri) obj2);
            return Unit.f56620a;
        }
    }

    public static final class g extends Lambda implements p<String, List<? extends Uri>, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30958a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d dVar) {
            super(2);
            this.f30958a = dVar;
        }

        public final void a(String str, List<? extends Uri> list) {
            this.f30958a.a(str, list);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj, Object obj2) {
            a((String) obj, (List) obj2);
            return Unit.f56620a;
        }
    }

    public static final class h extends Lambda implements d10.l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30959a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d dVar) {
            super(1);
            this.f30959a = dVar;
        }

        public final void a(String str) {
            com.sumsub.sns.internal.core.common.r.a(this.f30959a, str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public static final class i extends Lambda implements d10.l<String, Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30960a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d dVar) {
            super(1);
            this.f30960a = dVar;
        }

        public final void a(String str) {
            com.sumsub.sns.internal.core.common.r.a(this.f30960a, str);
        }

        public /* bridge */ /* synthetic */ Object invoke(Object obj) {
            a((String) obj);
            return Unit.f56620a;
        }
    }

    public final TextView h() {
        return (TextView) this.f30936b.a(this, f30930q[0]);
    }

    public final void i() {
        com.sumsub.sns.internal.core.android.a aVar = this.f30941g;
        if (aVar != null) {
            getLifecycle().d(aVar);
            this.f30941g = null;
        }
    }

    public final void j() {
        j1<b.a> b11;
        b.a value;
        b.C0375b bVar;
        Object obj;
        com.sumsub.sns.internal.core.presentation.form.b c11 = c();
        if (c11 != null && (b11 = c11.b()) != null && (value = b11.getValue()) != null && (bVar = (b.C0375b) CollectionsKt___CollectionsKt.d0(value.h(), value.f())) != null) {
            List<FormItem> a11 = a((List<? extends FormItem>) a(bVar));
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(a11, 10));
            for (FormItem formItem : a11) {
                String str = this.f30946l.get(com.sumsub.sns.core.presentation.form.model.a.a(formItem));
                if (str != null) {
                    com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                    String f11 = f();
                    com.sumsub.log.logger.a.d(aVar, f11, "field with error " + formItem.k(), (Throwable) null, 4, (Object) null);
                    FormItem a12 = com.sumsub.sns.internal.core.presentation.form.model.e.a(formItem, str);
                    if (a12 != null) {
                        formItem = a12;
                    }
                }
                arrayList.add(formItem);
            }
            this.f30945k = arrayList;
            if (e0.f32018a.isDebug()) {
                Iterator it2 = arrayList.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        obj = null;
                        break;
                    }
                    obj = it2.next();
                    if (((FormItem) obj) instanceof FormItem.k) {
                        break;
                    }
                }
                FormItem formItem2 = (FormItem) obj;
                if (formItem2 != null) {
                    com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
                    String f12 = f();
                    com.sumsub.log.logger.a.d(aVar2, f12, "phone field error=" + formItem2.b(), (Throwable) null, 4, (Object) null);
                }
            }
            com.sumsub.sns.internal.log.a aVar3 = com.sumsub.sns.internal.log.a.f34862a;
            String f13 = f();
            com.sumsub.log.logger.a.d(aVar3, f13, "visible " + arrayList.size() + " items", (Throwable) null, 4, (Object) null);
            com.sumsub.sns.core.presentation.form.viewadapter.i iVar = this.f30940f;
            if (iVar != null) {
                iVar.a(arrayList);
            }
        }
    }

    public final boolean k() {
        j1<b.a> b11;
        b.a value;
        b.c i11;
        RecyclerView e11;
        if (b() == null) {
            return false;
        }
        FormItem formItem = null;
        com.sumsub.sns.internal.core.presentation.form.b c11 = c();
        if (c11 == null || (b11 = c11.b()) == null || (value = b11.getValue()) == null || (i11 = value.i()) == null) {
            return false;
        }
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (FormItem formItem2 : this.f30945k) {
            if (!com.sumsub.sns.core.presentation.form.model.a.a(formItem2, (e) this.f30943i)) {
                if (formItem == null) {
                    formItem = formItem2;
                }
                com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, f(), "failed check for " + formItem2.k(), (Throwable) null, 4, (Object) null);
                String a11 = com.sumsub.sns.core.presentation.form.model.a.a(formItem2, i11, this.f30943i);
                if (a11 != null) {
                    linkedHashMap.put(com.sumsub.sns.core.presentation.form.model.a.a(formItem2), a11);
                }
            }
        }
        this.f30946l = linkedHashMap;
        if (formItem == null) {
            return true;
        }
        j();
        Iterator<? extends FormItem> it2 = this.f30945k.iterator();
        int i12 = 0;
        while (true) {
            if (!it2.hasNext()) {
                i12 = -1;
                break;
            } else if (x.b(com.sumsub.sns.core.presentation.form.model.a.a((FormItem) it2.next()), com.sumsub.sns.core.presentation.form.model.a.a(formItem))) {
                break;
            } else {
                i12++;
            }
        }
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, f(), "validateForm: scroll to " + i12 + " position", (Throwable) null, 4, (Object) null);
        if (i12 >= 0 && (e11 = e()) != null) {
            e11.post(new h(this, i12));
        }
        return false;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f30942h.a(bundle);
        if (bundle != null) {
            a((String) null, bundle);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, f(), "onCreateView", (Throwable) null, 4, (Object) null);
        return layoutInflater.inflate(R.layout.sns_form_fragment, viewGroup, false);
    }

    public void onDestroy() {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, f(), "onDestroy", (Throwable) null, 4, (Object) null);
        i();
        super.onDestroy();
    }

    public void onDestroyView() {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, f(), "onDestroyView", (Throwable) null, 4, (Object) null);
        RecyclerView e11 = e();
        if (e11 != null) {
            e11.setAdapter((RecyclerView.Adapter) null);
        }
        super.onDestroyView();
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        FragmentTrackHelper.trackOnHiddenChanged(this, z11);
    }

    @SensorsDataInstrumented
    public void onPause() {
        super.onPause();
        FragmentTrackHelper.trackFragmentPause(this);
    }

    @SensorsDataInstrumented
    public void onResume() {
        super.onResume();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001d, code lost:
        r0 = r0.getLayoutManager();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onSaveInstanceState(android.os.Bundle r3) {
        /*
            r2 = this;
            super.onSaveInstanceState(r3)
            com.sumsub.sns.core.presentation.util.a r0 = r2.f30942h
            r0.b(r3)
            com.sumsub.sns.internal.core.android.a r0 = r2.f30941g
            if (r0 == 0) goto L_0x0017
            java.lang.String r0 = r0.b()
            if (r0 == 0) goto L_0x0017
            java.lang.String r1 = "OBSERVER_ITEM_ID"
            r3.putString(r1, r0)
        L_0x0017:
            androidx.recyclerview.widget.RecyclerView r0 = r2.e()
            if (r0 == 0) goto L_0x0028
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            if (r0 == 0) goto L_0x0028
            android.os.Parcelable r0 = r0.onSaveInstanceState()
            goto L_0x0029
        L_0x0028:
            r0 = 0
        L_0x0029:
            java.lang.String r1 = "SCROLL_STATE"
            r3.putParcelable(r1, r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.d.onSaveInstanceState(android.os.Bundle):void");
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        j1<b.a> b11;
        super.onViewCreated(view, bundle);
        RecyclerView e11 = e();
        if (e11 != null) {
            this.f30939e = new LinearLayoutManager(e11.getContext());
            e11.setLayoutManager(new LinearLayoutManager(e11.getContext()));
            com.sumsub.sns.core.presentation.form.viewadapter.i iVar = new com.sumsub.sns.core.presentation.form.viewadapter.i(this.f30943i);
            iVar.a((c) this.f30948n);
            this.f30940f = iVar;
            e11.setAdapter(iVar);
            RecyclerView.ItemAnimator itemAnimator = e11.getItemAnimator();
            if (itemAnimator != null) {
                itemAnimator.setChangeDuration(100);
            }
            RecyclerView.ItemAnimator itemAnimator2 = e11.getItemAnimator();
            if (itemAnimator2 != null) {
                itemAnimator2.setAddDuration(100);
            }
            RecyclerView.ItemAnimator itemAnimator3 = e11.getItemAnimator();
            if (itemAnimator3 != null) {
                itemAnimator3.setRemoveDuration(100);
            }
            RecyclerView.ItemAnimator itemAnimator4 = e11.getItemAnimator();
            if (itemAnimator4 != null) {
                itemAnimator4.setMoveDuration(100);
            }
        }
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String f11 = f();
        StringBuilder sb2 = new StringBuilder();
        sb2.append("onViewCreated: viewModel=");
        com.sumsub.sns.internal.core.presentation.form.b c11 = c();
        sb2.append(c11 != null ? com.sumsub.sns.internal.core.common.i.a((Object) c11) : null);
        com.sumsub.log.logger.a.d(aVar, f11, sb2.toString(), (Throwable) null, 4, (Object) null);
        com.sumsub.sns.internal.core.presentation.form.b c12 = c();
        if (!(c12 == null || (b11 = c12.b()) == null)) {
            b0.b(b11, (LifecycleOwner) this, new e(this, bundle, (kotlin.coroutines.c<? super e>) null));
        }
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final ViewGroup b() {
        return e();
    }

    public final com.sumsub.sns.internal.core.presentation.form.b c() {
        com.sumsub.sns.internal.core.presentation.form.b a11;
        Fragment parentFragment = getParentFragment();
        com.sumsub.sns.internal.core.presentation.form.a aVar = parentFragment instanceof com.sumsub.sns.internal.core.presentation.form.a ? (com.sumsub.sns.internal.core.presentation.form.a) parentFragment : null;
        if (aVar != null && (a11 = aVar.a()) != null) {
            return a11;
        }
        FragmentActivity activity = getActivity();
        com.sumsub.sns.internal.core.presentation.form.a aVar2 = activity instanceof com.sumsub.sns.internal.core.presentation.form.a ? (com.sumsub.sns.internal.core.presentation.form.a) activity : null;
        if (aVar2 != null) {
            return aVar2.a();
        }
        return null;
    }

    public final com.sumsub.sns.internal.core.presentation.form.d d() {
        return (com.sumsub.sns.internal.core.presentation.form.d) this.f30949o.getValue();
    }

    public final RecyclerView e() {
        return (RecyclerView) this.f30938d.a(this, f30930q[2]);
    }

    public final String f() {
        return a() + "::FormFragment";
    }

    public final TextView g() {
        return (TextView) this.f30937c.a(this, f30930q[1]);
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [java.util.List, java.util.Collection] */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0098, code lost:
        if (r5 != false) goto L_0x009c;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void b(com.sumsub.sns.internal.core.presentation.form.b.C0375b r11) {
        /*
            r10 = this;
            com.sumsub.sns.internal.core.presentation.form.b$b r0 = r10.f30935a
            boolean r0 = kotlin.jvm.internal.x.b(r0, r11)
            if (r0 == 0) goto L_0x0017
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r2 = r10.f()
            r4 = 0
            r5 = 4
            r6 = 0
            java.lang.String r3 = "skipping page update"
            com.sumsub.log.logger.a.d(r1, r2, r3, r4, r5, r6)
            return
        L_0x0017:
            boolean r0 = r10.isAdded()
            if (r0 != 0) goto L_0x001e
            return
        L_0x001e:
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r2 = r10.f()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r3 = "creating views for page "
            r0.append(r3)
            int r3 = r11.e()
            r0.append(r3)
            java.lang.String r3 = r0.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            com.sumsub.log.logger.a.d(r1, r2, r3, r4, r5, r6)
            r0 = 1
            r10.f30947m = r0
            java.util.Map r1 = kotlin.collections.MapsKt__MapsKt.h()
            r10.f30946l = r1
            r10.j()
            java.util.List<? extends com.sumsub.sns.internal.core.presentation.form.model.FormItem> r1 = r10.f30945k
            java.util.Iterator r1 = r1.iterator()
        L_0x0051:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x00c7
            java.lang.Object r2 = r1.next()
            com.sumsub.sns.internal.core.presentation.form.model.FormItem r2 = (com.sumsub.sns.internal.core.presentation.form.model.FormItem) r2
            com.sumsub.sns.internal.core.common.e0 r3 = com.sumsub.sns.internal.core.common.e0.f32018a
            boolean r3 = r3.isDebug()
            if (r3 == 0) goto L_0x0051
            com.sumsub.sns.internal.log.a r3 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r5 = r10.f()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r6 = "showing view for "
            r4.append(r6)
            java.lang.String r6 = r2.k()
            r4.append(r6)
            java.lang.String r6 = r4.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            com.sumsub.log.logger.a.d(r4, r5, r6, r7, r8, r9)
            java.lang.String r4 = r2.f()
            if (r4 != 0) goto L_0x009c
            java.util.List r4 = r2.g()
            if (r4 == 0) goto L_0x009b
            boolean r5 = r4.isEmpty()
            r5 = r5 ^ r0
            if (r5 == 0) goto L_0x009b
            goto L_0x009c
        L_0x009b:
            r4 = 0
        L_0x009c:
            if (r4 == 0) goto L_0x0051
            java.lang.String r5 = r10.f()
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r7 = "initial value for "
            r6.append(r7)
            java.lang.String r2 = r2.k()
            r6.append(r2)
            java.lang.String r2 = " = "
            r6.append(r2)
            r6.append(r4)
            java.lang.String r6 = r6.toString()
            r7 = 0
            r8 = 4
            r9 = 0
            r4 = r3
            com.sumsub.log.logger.a.d(r4, r5, r6, r7, r8, r9)
            goto L_0x0051
        L_0x00c7:
            r0 = 0
            r10.f30947m = r0
            r10.f30935a = r11
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.d.b(com.sumsub.sns.internal.core.presentation.form.b$b):void");
    }

    public static final class b implements c {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d f30950a;

        public b(d dVar) {
            this.f30950a = dVar;
        }

        public void a(FormItem formItem, List<String> list) {
            if (!this.f30950a.f30947m && !(formItem instanceof FormItem.h)) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String e11 = this.f30950a.f();
                com.sumsub.log.logger.a.d(aVar, e11, "onValuesChanged: " + formItem.k() + " -> " + list, (Throwable) null, 4, (Object) null);
                com.sumsub.sns.internal.core.presentation.form.b b11 = this.f30950a.c();
                if (b11 != null) {
                    b11.a(formItem, list);
                }
                this.f30950a.j();
            }
        }

        public /* synthetic */ void a(FormItem formItem, boolean z11, boolean z12) {
            g.b(this, formItem, z11, z12);
        }

        public void b(FormItem formItem, String str) {
            if (!this.f30950a.f30947m) {
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String e11 = this.f30950a.f();
                com.sumsub.log.logger.a.d(aVar, e11, "onValueChanged: " + formItem.k() + " -> " + str, (Throwable) null, 4, (Object) null);
                d dVar = this.f30950a;
                dVar.f30946l = com.sumsub.sns.internal.core.common.i.a(dVar.f30946l, com.sumsub.sns.core.presentation.form.model.a.a(formItem), null);
                if (!(formItem instanceof FormItem.h)) {
                    com.sumsub.sns.internal.core.presentation.form.b b11 = this.f30950a.c();
                    if (b11 != null) {
                        b11.b(formItem, str);
                    }
                    this.f30950a.j();
                }
            }
        }

        public void c(FormItem formItem) {
        }

        public void c(FormItem formItem, String str) {
            com.sumsub.sns.internal.core.common.r.a(this.f30950a, str);
        }

        public void a(FormItem formItem) {
            FieldId fieldId = new FieldId(formItem.e(), formItem.d().p());
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String e11 = this.f30950a.f();
            com.sumsub.log.logger.a.d(aVar, e11, "onPickFileClick: " + fieldId, (Throwable) null, 4, (Object) null);
            kotlinx.serialization.json.a a11 = com.sumsub.sns.internal.core.common.x.a(false, 1, (Object) null);
            kotlinx.serialization.modules.d a12 = a11.a();
            kotlin.reflect.p n11 = Reflection.n(FieldId.class);
            MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
            String b11 = a11.b(kotlinx.serialization.h.d(a12, n11), fieldId);
            com.sumsub.sns.internal.core.android.a f11 = this.f30950a.f30941g;
            if (f11 != null) {
                f11.a(b11);
            }
        }

        public void b(FormItem formItem) {
            FieldId fieldId = new FieldId(formItem.e(), formItem.d().p());
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String e11 = this.f30950a.f();
            com.sumsub.log.logger.a.d(aVar, e11, "onPickMultipleFilesClick: " + fieldId, (Throwable) null, 4, (Object) null);
            kotlinx.serialization.json.a a11 = com.sumsub.sns.internal.core.common.x.a(false, 1, (Object) null);
            kotlinx.serialization.modules.d a12 = a11.a();
            kotlin.reflect.p n11 = Reflection.n(FieldId.class);
            MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
            String b11 = a11.b(kotlinx.serialization.h.d(a12, n11), fieldId);
            com.sumsub.sns.internal.core.android.a f11 = this.f30950a.f30941g;
            if (f11 != null) {
                f11.b(b11);
            }
        }

        public void a(FormItem formItem, String str) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String e11 = this.f30950a.f();
            com.sumsub.log.logger.a.d(aVar, e11, "onDeleteFileClick: " + formItem + " -> " + str, (Throwable) null, 4, (Object) null);
            com.sumsub.sns.internal.core.presentation.form.b b11 = this.f30950a.c();
            if (b11 != null) {
                b11.a(formItem, str);
            }
        }
    }

    public final String a() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString(f30933t) : null;
        return string == null ? "_" : string;
    }

    public static final void a(d dVar, int i11) {
        RecyclerView e11 = dVar.e();
        if (e11 != null) {
            e11.scrollToPosition(i11);
        }
    }

    public final void a(b.a aVar, Bundle bundle) {
        Parcelable parcelable;
        RecyclerView.LayoutManager layoutManager;
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, f(), "handleFormStateUpdated:", (Throwable) null, 4, (Object) null);
        b.C0375b bVar = null;
        if (!aVar.h().isEmpty()) {
            com.sumsub.sns.internal.core.android.a aVar2 = this.f30941g;
            if ((aVar2 != null ? aVar2.a() : null) == null) {
                i();
            }
            a(aVar.g(), bundle);
        }
        a(aVar.f(), aVar.h());
        b.C0375b e11 = aVar.e();
        if (e11 != null) {
            if (!e11.f().isEmpty()) {
                bVar = e11;
            }
            if (bVar != null && bundle != null && (parcelable = (Parcelable) androidx.core.os.d.b(bundle, f30931r, Parcelable.class)) != null && !this.f30944j) {
                RecyclerView e12 = e();
                if (!(e12 == null || (layoutManager = e12.getLayoutManager()) == null)) {
                    layoutManager.onRestoreInstanceState(parcelable);
                }
                this.f30944j = true;
            }
        }
    }

    public final void a(String str, Bundle bundle) {
        String string;
        if (this.f30941g == null) {
            ActivityResultRegistry activityResultRegistry = requireActivity().getActivityResultRegistry();
            String a11 = this.f30942h.a();
            if (str == null) {
                str = getString(R.string.sns_questionnaire_mime_types);
            }
            com.sumsub.sns.internal.core.android.a aVar = new com.sumsub.sns.internal.core.android.a(activityResultRegistry, a11, com.sumsub.sns.internal.core.common.h.a(str), new f(this), new g(this));
            if (!(bundle == null || (string = bundle.getString(f30932s)) == null)) {
                aVar.c(string);
            }
            getLifecycle().a(aVar);
            this.f30941g = aVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0021, code lost:
        r4 = r0.f();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(int r8, java.util.List<com.sumsub.sns.internal.core.presentation.form.b.C0375b> r9) {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.collections.CollectionsKt___CollectionsKt.d0(r9, r8)
            com.sumsub.sns.internal.core.presentation.form.b$b r0 = (com.sumsub.sns.internal.core.presentation.form.b.C0375b) r0
            com.sumsub.sns.internal.log.a r1 = com.sumsub.sns.internal.log.a.f34862a
            java.lang.String r2 = r7.f()
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "showPage: "
            r3.append(r4)
            r3.append(r8)
            java.lang.String r8 = " has "
            r3.append(r8)
            r8 = 0
            if (r0 == 0) goto L_0x0030
            java.util.List r4 = r0.f()
            if (r4 == 0) goto L_0x0030
            int r4 = r4.size()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            goto L_0x0031
        L_0x0030:
            r4 = r8
        L_0x0031:
            r3.append(r4)
            java.lang.String r4 = " items"
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            r4 = 0
            r5 = 4
            r6 = 0
            com.sumsub.log.logger.a.d(r1, r2, r3, r4, r5, r6)
            boolean r9 = r9.isEmpty()
            if (r9 != 0) goto L_0x00a1
            if (r0 != 0) goto L_0x004c
            goto L_0x00a1
        L_0x004c:
            android.widget.TextView r9 = r7.h()
            if (r9 == 0) goto L_0x0065
            java.lang.String r1 = r0.h()
            if (r1 == 0) goto L_0x0061
            android.content.Context r2 = r7.requireContext()
            android.text.Spanned r1 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r1, (android.content.Context) r2)
            goto L_0x0062
        L_0x0061:
            r1 = r8
        L_0x0062:
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r9, (java.lang.CharSequence) r1)
        L_0x0065:
            android.widget.TextView r9 = r7.g()
            if (r9 == 0) goto L_0x0082
            java.lang.String r1 = r0.g()
            if (r1 == 0) goto L_0x007f
            java.lang.String r1 = kotlin.text.StringsKt__IndentKt.f(r1)
            if (r1 == 0) goto L_0x007f
            android.content.Context r8 = r7.requireContext()
            android.text.Spanned r8 = com.sumsub.sns.internal.core.common.i.a((java.lang.CharSequence) r1, (android.content.Context) r8)
        L_0x007f:
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r9, (java.lang.CharSequence) r8)
        L_0x0082:
            android.widget.TextView r8 = r7.h()
            if (r8 == 0) goto L_0x0090
            com.sumsub.sns.core.presentation.form.d$h r9 = new com.sumsub.sns.core.presentation.form.d$h
            r9.<init>(r7)
            com.sumsub.sns.core.common.b.a((android.widget.TextView) r8, (d10.l<? super java.lang.String, kotlin.Unit>) r9)
        L_0x0090:
            android.widget.TextView r8 = r7.g()
            if (r8 == 0) goto L_0x009e
            com.sumsub.sns.core.presentation.form.d$i r9 = new com.sumsub.sns.core.presentation.form.d$i
            r9.<init>(r7)
            com.sumsub.sns.core.common.b.a((android.widget.TextView) r8, (d10.l<? super java.lang.String, kotlin.Unit>) r9)
        L_0x009e:
            r7.b((com.sumsub.sns.internal.core.presentation.form.b.C0375b) r0)
        L_0x00a1:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.form.d.a(int, java.util.List):void");
    }

    public final List<FormItem> a(List<? extends FormItem> list) {
        j1<b.a> b11;
        b.a value;
        List<b.C0375b> h11;
        com.sumsub.sns.internal.core.presentation.form.b c11 = c();
        if (c11 == null || (b11 = c11.b()) == null || (value = b11.getValue()) == null || (h11 = value.h()) == null) {
            return list;
        }
        ArrayList arrayList = new ArrayList();
        for (b.C0375b f11 : h11) {
            boolean unused = CollectionsKt__MutableCollectionsKt.A(arrayList, f11.f());
        }
        b.a a11 = com.sumsub.sns.internal.core.presentation.form.model.b.f33832a.a(arrayList, d());
        Set<String> a12 = a11.a();
        Set<FieldId> b12 = a11.b();
        if (!a12.isEmpty()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String f12 = f();
            com.sumsub.log.logger.a.d(aVar, f12, "hidden sections: " + a12.size(), (Throwable) null, 4, (Object) null);
        }
        if (e0.f32018a.isDebug()) {
            ArrayList<FormItem> arrayList2 = new ArrayList<>();
            for (T next : list) {
                if (b12.contains(com.sumsub.sns.core.presentation.form.model.a.a((FormItem) next))) {
                    arrayList2.add(next);
                }
            }
            com.sumsub.sns.internal.log.a aVar2 = com.sumsub.sns.internal.log.a.f34862a;
            String f13 = f();
            com.sumsub.log.logger.a.d(aVar2, f13, "hidden items: " + arrayList2.size(), (Throwable) null, 4, (Object) null);
            for (FormItem formItem : arrayList2) {
                com.sumsub.sns.internal.log.a aVar3 = com.sumsub.sns.internal.log.a.f34862a;
                String f14 = f();
                com.sumsub.log.logger.a.d(aVar3, f14, "hidden " + formItem, (Throwable) null, 4, (Object) null);
            }
        }
        List L0 = CollectionsKt___CollectionsKt.L0(list);
        ArrayList arrayList3 = new ArrayList();
        for (Object next2 : L0) {
            FormItem formItem2 = (FormItem) next2;
            boolean z11 = formItem2 instanceof FormItem.l;
            if ((z11 && !a12.contains(((FormItem.l) formItem2).e())) || (!z11 && !b12.contains(com.sumsub.sns.core.presentation.form.model.a.a(formItem2)))) {
                arrayList3.add(next2);
            }
        }
        return arrayList3;
    }

    public final List<FormItem> a(b.C0375b bVar) {
        List<FormItem> f11 = bVar.f();
        ArrayList arrayList = new ArrayList();
        String h11 = bVar.h();
        if (h11 != null) {
            arrayList.add(new FormItem.r(h11, ""));
        }
        String g11 = bVar.g();
        if (g11 != null) {
            arrayList.add(new FormItem.o(g11, ""));
        }
        arrayList.addAll(f11);
        return arrayList;
    }

    public final void a(FormItem formItem, boolean z11) {
        j1<b.a> b11;
        b.a value;
        b.c i11;
        com.sumsub.sns.internal.core.presentation.form.b c11 = c();
        if (c11 != null && (b11 = c11.b()) != null && (value = b11.getValue()) != null && (i11 = value.i()) != null) {
            boolean z12 = this.f30946l.get(com.sumsub.sns.core.presentation.form.model.a.a(formItem)) == null;
            String str = null;
            if (!z11) {
                str = com.sumsub.sns.core.presentation.form.model.a.a(formItem, i11, this.f30943i);
            }
            this.f30946l = com.sumsub.sns.internal.core.common.i.a(this.f30946l, com.sumsub.sns.core.presentation.form.model.a.a(formItem), str);
            if (z12 != z11) {
                j();
            }
        }
    }

    public final void a(String str, List<? extends Uri> list) {
        com.sumsub.sns.internal.core.presentation.form.b c11;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String f11 = f();
        com.sumsub.log.logger.a.d(aVar, f11, "handleMultiFilePickResult: " + str + " -> " + list, (Throwable) null, 4, (Object) null);
        if (list != null && !list.isEmpty()) {
            try {
                kotlinx.serialization.json.a a11 = com.sumsub.sns.internal.core.common.x.a(false, 1, (Object) null);
                kotlinx.serialization.modules.d a12 = a11.a();
                kotlin.reflect.p g11 = Reflection.g(FieldId.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                FieldId fieldId = (FieldId) a11.c(kotlinx.serialization.h.d(a12, g11), str);
                if (fieldId != null && (c11 = c()) != null) {
                    c11.a(requireContext(), fieldId, list);
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void a(String str, Uri uri) {
        com.sumsub.sns.internal.core.presentation.form.b c11;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String f11 = f();
        com.sumsub.log.logger.a.d(aVar, f11, "handleFilePickResult: " + str + " -> " + uri, (Throwable) null, 4, (Object) null);
        if (uri != null) {
            try {
                kotlinx.serialization.json.a a11 = com.sumsub.sns.internal.core.common.x.a(false, 1, (Object) null);
                kotlinx.serialization.modules.d a12 = a11.a();
                kotlin.reflect.p g11 = Reflection.g(FieldId.class);
                MagicApiIntrinsics.a("kotlinx.serialization.serializer.withModule");
                FieldId fieldId = (FieldId) a11.c(kotlinx.serialization.h.d(a12, g11), str);
                if (fieldId != null && (c11 = c()) != null) {
                    c11.a(requireContext(), fieldId, CollectionsKt__CollectionsJVMKt.e(uri));
                }
            } catch (Throwable unused) {
            }
        }
    }
}
