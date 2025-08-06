package com.sumsub.sns.core.presentation;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.q0;
import androidx.core.view.r0;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.v;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sensorsdata.analytics.android.sdk.autotrack.aop.FragmentTrackHelper;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.data.model.SNSCompletionResult;
import com.sumsub.sns.core.data.model.SNSLivenessReason;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.presentation.base.a.l;
import com.sumsub.sns.core.theme.SNSColorElement;
import com.sumsub.sns.core.theme.SNSMetricElement;
import com.sumsub.sns.core.widget.SNSToolbarView;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.SNSSession;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.b0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.i;
import com.sumsub.sns.internal.core.common.k0;
import com.sumsub.sns.internal.core.common.l0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.o;
import d10.p;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.internal.AdaptedFunctionReference;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.flow.f;
import kotlinx.coroutines.h0;
import v1.m;

@Metadata(d1 = {"\u0000Ò\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010$\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b&\u0018\u0000 \u0001*\b\b\u0000\u0010\u0002*\u00020\u0001*\u000e\b\u0001\u0010\u0004*\b\u0012\u0004\u0012\u00028\u00000\u00032\u00020\u0005:\u0002\u0001B\t¢\u0006\u0006\b\u0001\u0010\u0001J\b\u0010\u0007\u001a\u00020\u0006H\u0002J\b\u0010\b\u001a\u00020\u0006H\u0002J\b\u0010\t\u001a\u00020\u0006H\u0002J\b\u0010\n\u001a\u00020\u0006H\u0002J\u0006\u0010\f\u001a\u00020\u000bJ\b\u0010\r\u001a\u00020\u0006H\u0016J\u0012\u0010\u0010\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u0012\u001a\u00020\u00062\u0006\u0010\u0011\u001a\u00020\u000eH\u0016J&\u0010\u0018\u001a\u0004\u0018\u00010\u00172\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\u0010\u0010\u001b\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u0019H\u0004J\b\u0010\u001c\u001a\u00020\u0006H\u0004J\u001a\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u00172\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0016J\b\u0010\u001f\u001a\u00020\u0006H\u0016J\b\u0010 \u001a\u00020\u0006H\u0016J\b\u0010!\u001a\u00020\u0006H\u0016J\u001c\u0010%\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u000eH\u0004J\u001c\u0010&\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\"2\b\b\u0002\u0010$\u001a\u00020\u000eH\u0004J1\u0010-\u001a\u00020\u00062\b\b\u0002\u0010(\u001a\u00020'2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010)2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010+H\u0014¢\u0006\u0004\b-\u0010.J\u0010\u00101\u001a\u00020\u00062\u0006\u00100\u001a\u00020/H\u0016J\u0010\u00103\u001a\u00020\u00062\u0006\u00102\u001a\u00020/H\u0014J\u0010\u00105\u001a\u00020\u00062\u0006\u00104\u001a\u00020/H\u0014J\u0012\u00106\u001a\u00020\u00062\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0015J\u0010\u00109\u001a\u00020\u00062\u0006\u00108\u001a\u000207H\u0015J!\u0010:\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00028\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b:\u0010;J+\u0010:\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00028\u00002\b\u0010<\u001a\u0004\u0018\u00018\u00002\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eH\u0014¢\u0006\u0004\b:\u0010=J\b\u0010>\u001a\u00020/H\u0004J\b\u0010?\u001a\u00020\u000bH\u0004J\u001c\u0010B\u001a\u00020\u00062\u0006\u0010@\u001a\u00020\u00052\n\b\u0002\u0010A\u001a\u0004\u0018\u00010\u000bH\u0004J\u000e\u0010E\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CJ\u000e\u0010F\u001a\u00020\u00062\u0006\u0010D\u001a\u00020CJ\u0010\u0010H\u001a\u00020/2\u0006\u0010G\u001a\u00020'H\u0017J\b\u0010J\u001a\u00020IH\u0016J\b\u0010K\u001a\u00020\u0006H\u0016J\u001c\u0010M\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\b\u0010L\u001a\u0004\u0018\u00010\u000bJ\b\u0010N\u001a\u00020\"H%R\u001a\u0010P\u001a\u00020O8\u0016X\u0004¢\u0006\f\n\u0004\bP\u0010Q\u001a\u0004\bR\u0010SR&\u0010U\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0T8\u0016X\u0004¢\u0006\f\n\u0004\bU\u0010V\u001a\u0004\bW\u0010XR&\u0010Y\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0T8\u0016X\u0004¢\u0006\f\n\u0004\bY\u0010V\u001a\u0004\bZ\u0010XR&\u0010[\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0T8\u0016X\u0004¢\u0006\f\n\u0004\b[\u0010V\u001a\u0004\b\\\u0010XR&\u0010]\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020)0T8\u0016X\u0004¢\u0006\f\n\u0004\b]\u0010V\u001a\u0004\b^\u0010XR\u001a\u0010_\u001a\u00020/8\u0016XD¢\u0006\f\n\u0004\b_\u0010`\u001a\u0004\b_\u0010aR\u001a\u0010b\u001a\u00020\u000b8\u0016X\u0004¢\u0006\f\n\u0004\bb\u0010c\u001a\u0004\bd\u0010eR\u0016\u0010f\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bf\u0010gR\u0016\u0010h\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bh\u0010gR\u0016\u0010i\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bi\u0010gR\u0016\u0010j\u001a\u00020\"8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bj\u0010gR\u0018\u0010k\u001a\u0004\u0018\u00018\u00008\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bk\u0010lR$\u0010n\u001a\u00020/2\u0006\u0010m\u001a\u00020/8\u0004@BX\u000e¢\u0006\f\n\u0004\bn\u0010`\u001a\u0004\bn\u0010aR\u0016\u0010o\u001a\u00020/8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bo\u0010`R\u001d\u0010u\u001a\u0004\u0018\u00010p8DX\u0002¢\u0006\f\n\u0004\bq\u0010r\u001a\u0004\bs\u0010tR\u0014\u0010w\u001a\u00020v8\u0002X\u0004¢\u0006\u0006\n\u0004\bw\u0010xR\u001e\u0010|\u001a\f\u0012\u0002\b\u0003\u0012\u0002\b\u0003\u0018\u00010y8BX\u0004¢\u0006\u0006\u001a\u0004\bz\u0010{R\u0017\u0010\u0001\u001a\u0004\u0018\u00010}8BX\u0004¢\u0006\u0006\u001a\u0004\b~\u0010R\u0017\u0010\u0001\u001a\u00028\u00018$X¤\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0016\u0010\u0001\u001a\u00020\u000b8$X¤\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010eR\u0018\u0010\u0001\u001a\u0004\u0018\u00010p8TX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010tR\u0015\u0010\u0001\u001a\u00030\u00018F¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001e\u0010\u0001\u001a\n\u0012\u0002\b\u0003\u0012\u0002\b\u00030y8DX\u0004¢\u0006\u0007\u001a\u0005\b\u0001\u0010{R\u0018\u0010\u0001\u001a\u00030\u00018DX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018DX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u0018\u0010\u0001\u001a\u00030\u00018DX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001R\u001a\u0010\u0001\u001a\u0005\u0018\u00010\u00018DX\u0004¢\u0006\b\u001a\u0006\b\u0001\u0010\u0001¨\u0006 \u0001"}, d2 = {"Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/core/presentation/base/a$l;", "S", "Lcom/sumsub/sns/core/presentation/base/a;", "VM", "Landroidx/fragment/app/Fragment;", "", "g", "j", "i", "h", "", "getUniqueId", "onResume", "Landroid/os/Bundle;", "savedInstanceState", "onCreate", "outState", "onSaveInstanceState", "Landroid/view/LayoutInflater;", "inflater", "Landroid/view/ViewGroup;", "container", "Landroid/view/View;", "onCreateView", "Lcom/sumsub/sns/core/presentation/base/a$k;", "state", "updateCommonUiState", "initCommonUI", "view", "onViewCreated", "onStart", "onStop", "onDestroyView", "", "result", "data", "setResult", "finishWithResult", "Lcom/sumsub/sns/internal/core/common/q;", "reason", "", "payload", "", "delay", "finish", "(Lcom/sumsub/sns/internal/core/common/q;Ljava/lang/Object;Ljava/lang/Long;)V", "", "hidden", "onHiddenChanged", "showProgress", "updateShowProgress", "hideLogo", "updatePoweredByVisibility", "onViewModelPrepared", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "handleState", "(Lcom/sumsub/sns/core/presentation/base/a$l;Landroid/os/Bundle;)V", "prevState", "(Lcom/sumsub/sns/core/presentation/base/a$l;Lcom/sumsub/sns/core/presentation/base/a$l;Landroid/os/Bundle;)V", "isForResult", "getFragmentRequestKey", "fragment", "tag", "navigateTo", "Lcom/sumsub/sns/internal/core/data/model/o;", "error", "onHandleError", "onErrorCancelled", "finishReason", "onFinishCalled", "Lcom/sumsub/sns/core/data/model/SNSCompletionResult;", "onCancelResult", "onCloseButtonClick", "requestKey", "forResult", "getLayoutId", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "", "openPayload", "Ljava/util/Map;", "getOpenPayload", "()Ljava/util/Map;", "appearPayload", "getAppearPayload", "cancelPayload", "getCancelPayload", "closePayload", "getClosePayload", "isTransparentStatusBar", "Z", "()Z", "logTag", "Ljava/lang/String;", "getLogTag", "()Ljava/lang/String;", "statusBarColor", "I", "navigationBarColor", "sysUiVisibility", "windowFlags", "lastViewState", "Lcom/sumsub/sns/core/presentation/base/a$l;", "<set-?>", "isPrepared", "isResultSet", "Landroid/widget/TextView;", "progressTextView$delegate", "Lcom/sumsub/sns/internal/core/common/z;", "getProgressTextView", "()Landroid/widget/TextView;", "progressTextView", "Lcom/sumsub/sns/core/presentation/util/a;", "uniqueIdHolder", "Lcom/sumsub/sns/core/presentation/util/a;", "Lcom/sumsub/sns/core/presentation/a;", "e", "()Lcom/sumsub/sns/core/presentation/a;", "baseActivitySafe", "Lcom/sumsub/sns/internal/core/common/l0;", "f", "()Lcom/sumsub/sns/internal/core/common/l0;", "navigation", "getViewModel", "()Lcom/sumsub/sns/core/presentation/base/a;", "viewModel", "getIdDocSetType", "idDocSetType", "getPoweredByText", "poweredByText", "Lcom/sumsub/sns/internal/core/analytics/c;", "getAnalyticsDelegate", "()Lcom/sumsub/sns/internal/core/analytics/c;", "analyticsDelegate", "getBaseActivity", "baseActivity", "Lcom/sumsub/sns/internal/core/a;", "getServiceLocator", "()Lcom/sumsub/sns/internal/core/a;", "serviceLocator", "getServiceLocatorSafe", "serviceLocatorSafe", "Lcom/sumsub/sns/internal/core/common/SNSSession;", "getSession", "()Lcom/sumsub/sns/internal/core/common/SNSSession;", "session", "Lcom/sumsub/sns/internal/core/common/k0;", "getAppListener", "()Lcom/sumsub/sns/internal/core/common/k0;", "appListener", "<init>", "()V", "Companion", "a", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public abstract class b<S extends a.l, VM extends com.sumsub.sns.core.presentation.base.a<S>> extends Fragment {
    public static final /* synthetic */ kotlin.reflect.l<Object>[] $$delegatedProperties = {Reflection.j(new PropertyReference1Impl(b.class, "progressTextView", "getProgressTextView()Landroid/widget/TextView;", 0))};
    private static final String ARG_NAV_BAR_COLOR = "nav_bar_color";
    private static final String ARG_STATUS_BAR_COLOR = "status_bar_color";
    private static final String ARG_UI_VISIBILITY = "system_ui_visibility";
    private static final String ARG_WINDOW_FLAGS = "window_flags";
    public static final a Companion = new a((r) null);
    public static final String FRAGMENT_REQUEST_KEY = "fragment_request_key";
    public static final String FRAGMENT_RESULT_KEY = "fragment_result_key";
    private final Map<String, Object> appearPayload = MapsKt__MapsKt.h();
    private final Map<String, Object> cancelPayload = MapsKt__MapsKt.h();
    private final Map<String, Object> closePayload = MapsKt__MapsKt.h();
    /* access modifiers changed from: private */
    public boolean isPrepared;
    private boolean isResultSet;
    private final boolean isTransparentStatusBar;
    /* access modifiers changed from: private */
    public S lastViewState;
    private final String logTag = com.sumsub.sns.internal.log.c.a(this);
    private int navigationBarColor;
    private final Map<String, Object> openPayload = MapsKt__MapsKt.h();
    private final z progressTextView$delegate = a0.a(this, R.id.sns_progress_text);
    private final Screen screen = c.f30925a.a((Fragment) this);
    private int statusBarColor;
    private int sysUiVisibility;
    private final com.sumsub.sns.core.presentation.util.a uniqueIdHolder = new com.sumsub.sns.core.presentation.util.a();
    private int windowFlags;

    public static final class a {
        public /* synthetic */ a(r rVar) {
            this();
        }

        public final int a(Bundle bundle) {
            return bundle.getInt(b.FRAGMENT_RESULT_KEY);
        }

        public final boolean b(Bundle bundle) {
            return bundle.getInt(b.FRAGMENT_RESULT_KEY) == -1;
        }

        public a() {
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.BaseFragment$navigateTo$1", f = "BaseFragment.kt", l = {}, m = "invokeSuspend")
    /* renamed from: com.sumsub.sns.core.presentation.b$b  reason: collision with other inner class name */
    public static final class C0280b extends SuspendLambda implements p<h0, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30767a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b<S, VM> f30768b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ Fragment f30769c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ String f30770d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public C0280b(b<S, VM> bVar, Fragment fragment, String str, kotlin.coroutines.c<? super C0280b> cVar) {
            super(2, cVar);
            this.f30768b = bVar;
            this.f30769c = fragment;
            this.f30770d = str;
        }

        /* renamed from: a */
        public final Object invoke(h0 h0Var, kotlin.coroutines.c<? super Unit> cVar) {
            return ((C0280b) create(h0Var, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            return new C0280b(this.f30768b, this.f30769c, this.f30770d, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30767a == 0) {
                k.b(obj);
                if (!this.f30768b.isAdded()) {
                    return Unit.f56620a;
                }
                l0 access$getNavigation = this.f30768b.f();
                if (access$getNavigation != null) {
                    access$getNavigation.a(this.f30769c, this.f30770d);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public /* synthetic */ class c extends AdaptedFunctionReference implements p<a.j, kotlin.coroutines.c<? super Unit>, Object> {
        public c(Object obj) {
            super(2, obj, b.class, "handleEvent", "handleEvent(Lcom/sumsub/sns/core/presentation/base/SNSViewModel$SNSViewModelEvent;)V", 4);
        }

        /* renamed from: a */
        public final Object invoke(a.j jVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((b) this.receiver).handleEvent(jVar);
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.BaseFragment$onViewCreated$2", f = "BaseFragment.kt", l = {}, m = "invokeSuspend")
    public static final class d extends SuspendLambda implements p<a.k, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30771a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30772b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b<S, VM> f30773c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f30774d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(b<S, VM> bVar, Bundle bundle, kotlin.coroutines.c<? super d> cVar) {
            super(2, cVar);
            this.f30773c = bVar;
            this.f30774d = bundle;
        }

        /* renamed from: a */
        public final Object invoke(a.k kVar, kotlin.coroutines.c<? super Unit> cVar) {
            return ((d) create(kVar, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            d dVar = new d(this.f30773c, this.f30774d, cVar);
            dVar.f30772b = obj;
            return dVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30771a == 0) {
                k.b(obj);
                a.k kVar = (a.k) this.f30772b;
                this.f30773c.updateCommonUiState(kVar);
                if (this.f30773c.isPrepared() != kVar.j()) {
                    this.f30773c.isPrepared = kVar.j();
                    this.f30773c.onViewModelPrepared(this.f30774d);
                }
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    @kotlin.coroutines.jvm.internal.d(c = "com.sumsub.sns.core.presentation.BaseFragment$onViewModelPrepared$1", f = "BaseFragment.kt", l = {}, m = "invokeSuspend")
    public static final class e extends SuspendLambda implements p<S, kotlin.coroutines.c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f30775a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f30776b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ b<S, VM> f30777c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ Bundle f30778d;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(b<S, VM> bVar, Bundle bundle, kotlin.coroutines.c<? super e> cVar) {
            super(2, cVar);
            this.f30777c = bVar;
            this.f30778d = bundle;
        }

        /* renamed from: a */
        public final Object invoke(S s11, kotlin.coroutines.c<? super Unit> cVar) {
            return ((e) create(s11, cVar)).invokeSuspend(Unit.f56620a);
        }

        public final kotlin.coroutines.c<Unit> create(Object obj, kotlin.coroutines.c<?> cVar) {
            e eVar = new e(this.f30777c, this.f30778d, cVar);
            eVar.f30776b = obj;
            return eVar;
        }

        public final Object invokeSuspend(Object obj) {
            Object unused = IntrinsicsKt__IntrinsicsKt.d();
            if (this.f30775a == 0) {
                k.b(obj);
                a.l lVar = (a.l) this.f30776b;
                com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
                String a11 = com.sumsub.sns.internal.log.c.a(this.f30777c);
                com.sumsub.log.logger.a.c(aVar, a11, "Lifecycle New state: " + lVar, (Throwable) null, 4, (Object) null);
                b<S, VM> bVar = this.f30777c;
                bVar.handleState(lVar, bVar.lastViewState, this.f30778d);
                this.f30777c.lastViewState = lVar;
                return Unit.f56620a;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public static /* synthetic */ void finish$default(b bVar, q qVar, Object obj, Long l11, int i11, Object obj2) {
        if (obj2 == null) {
            if ((i11 & 1) != 0) {
                qVar = q.c.f32251b;
            }
            if ((i11 & 2) != 0) {
                obj = null;
            }
            if ((i11 & 4) != 0) {
                l11 = null;
            }
            bVar.finish(qVar, obj, l11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finish");
    }

    public static /* synthetic */ void finishWithResult$default(b bVar, int i11, Bundle bundle, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = -1;
            }
            if ((i12 & 2) != 0) {
                bundle = new Bundle();
            }
            bVar.finishWithResult(i11, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: finishWithResult");
    }

    public static /* synthetic */ void navigateTo$default(b bVar, Fragment fragment, String str, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 2) != 0) {
                str = null;
            }
            bVar.navigateTo(fragment, str);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: navigateTo");
    }

    public static /* synthetic */ void setResult$default(b bVar, int i11, Bundle bundle, int i12, Object obj) {
        if (obj == null) {
            if ((i12 & 1) != 0) {
                i11 = -1;
            }
            if ((i12 & 2) != 0) {
                bundle = new Bundle();
            }
            bVar.setResult(i11, bundle);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setResult");
    }

    public final a<?, ?> e() {
        FragmentActivity activity = getActivity();
        if (activity instanceof a) {
            return (a) activity;
        }
        return null;
    }

    public final l0 f() {
        FragmentActivity activity = getActivity();
        if (activity instanceof l0) {
            return (l0) activity;
        }
        return null;
    }

    public void finish(q qVar, Object obj, Long l11) {
        if (onFinishCalled(qVar)) {
            i();
            l0 f11 = f();
            if (f11 != null) {
                f11.a(qVar, l11);
            }
        }
    }

    public final void finishWithResult(int i11, Bundle bundle) {
        setResult(i11, bundle);
        finish$default(this, (q) null, (Object) null, (Long) null, 7, (Object) null);
    }

    public final b<S, VM> forResult(String str) {
        Bundle arguments;
        if (!(str == null || (arguments = getArguments()) == null)) {
            arguments.putString(FRAGMENT_REQUEST_KEY, str);
        }
        return this;
    }

    public final void g() {
        Window window = requireActivity().getWindow();
        q0.a(window, false);
        r0 r0Var = new r0(window, requireView());
        r0Var.a(WindowInsetsCompat.l.b());
        r0Var.d(2);
    }

    public final com.sumsub.sns.internal.core.analytics.c getAnalyticsDelegate() {
        return new com.sumsub.sns.internal.core.analytics.c(getScreen(), getIdDocSetType(), getOpenPayload(), getAppearPayload(), getClosePayload(), getCancelPayload());
    }

    public final k0 getAppListener() {
        FragmentActivity activity = getActivity();
        if (activity instanceof k0) {
            return (k0) activity;
        }
        return null;
    }

    public Map<String, Object> getAppearPayload() {
        return this.appearPayload;
    }

    public final a<?, ?> getBaseActivity() {
        return (a) getActivity();
    }

    public Map<String, Object> getCancelPayload() {
        return this.cancelPayload;
    }

    public Map<String, Object> getClosePayload() {
        return this.closePayload;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r0.getString(FRAGMENT_REQUEST_KEY);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getFragmentRequestKey() {
        /*
            r2 = this;
            android.os.Bundle r0 = r2.getArguments()
            java.lang.String r1 = "fragment_request_key"
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = r0.getString(r1)
            if (r0 != 0) goto L_0x000f
            goto L_0x0010
        L_0x000f:
            r1 = r0
        L_0x0010:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.b.getFragmentRequestKey():java.lang.String");
    }

    public abstract String getIdDocSetType();

    public abstract int getLayoutId();

    public String getLogTag() {
        return this.logTag;
    }

    public Map<String, Object> getOpenPayload() {
        return this.openPayload;
    }

    public TextView getPoweredByText() {
        View view = getView();
        if (view != null) {
            return (TextView) view.findViewById(R.id.sns_powered);
        }
        return null;
    }

    public final TextView getProgressTextView() {
        return (TextView) this.progressTextView$delegate.a(this, $$delegatedProperties[0]);
    }

    public Screen getScreen() {
        return this.screen;
    }

    public final com.sumsub.sns.internal.core.a getServiceLocator() {
        return getBaseActivity().f();
    }

    public final com.sumsub.sns.internal.core.a getServiceLocatorSafe() {
        a<?, ?> e11 = e();
        if (e11 != null) {
            return e11.f();
        }
        return null;
    }

    public final SNSSession getSession() {
        return getServiceLocator().E();
    }

    public final String getUniqueId() {
        return this.uniqueIdHolder.a();
    }

    public abstract VM getViewModel();

    public final void h() {
        View view = getView();
        SNSToolbarView sNSToolbarView = view != null ? (SNSToolbarView) view.findViewById(R.id.sns_toolbar) : null;
        if (sNSToolbarView != null) {
            sNSToolbarView.setOnCloseButtonClickListener(new e(this));
        }
        if (sNSToolbarView != null) {
            sNSToolbarView.setCloseButtonDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.CLOSE.getImageName()));
        }
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof a.f) {
            i.a((Activity) requireActivity());
        } else if (jVar instanceof a.g) {
            startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
        } else if (jVar instanceof a.d) {
            a.d dVar = (a.d) jVar;
            getBaseActivity().a(dVar.e(), dVar.f(), dVar.d());
        } else if (jVar instanceof a.h) {
            k0 appListener = getAppListener();
            if (appListener != null) {
                appListener.a(((a.h) jVar).b());
            }
        } else if (jVar instanceof a.p) {
            l0 f11 = f();
            if (f11 != null) {
                f11.a(com.sumsub.sns.core.presentation.support.a.f31170d.a(), com.sumsub.sns.core.presentation.support.a.f31171e);
            }
        } else if (jVar instanceof a.m) {
            k0 appListener2 = getAppListener();
            if (appListener2 != null) {
                appListener2.a(((a.m) jVar).b());
            }
        } else if (jVar instanceof a.e) {
            a.e eVar = (a.e) jVar;
            finish(eVar.f(), eVar.e(), eVar.d());
        } else if (jVar instanceof a.o) {
            updateShowProgress(((a.o) jVar).b());
        } else if (jVar instanceof a.q) {
            Toast.makeText(getActivity(), ((a.q) jVar).b(), 0).show();
        }
    }

    public void handleState(S s11, Bundle bundle) {
    }

    public void handleState(S s11, S s12, Bundle bundle) {
        handleState(s11, bundle);
    }

    public final void i() {
        if (!this.isResultSet && isForResult()) {
            String fragmentRequestKey = getFragmentRequestKey();
            Bundle bundle = new Bundle();
            bundle.putInt(FRAGMENT_RESULT_KEY, 0);
            Unit unit = Unit.f56620a;
            androidx.fragment.app.p.a(this, fragmentRequestKey, bundle);
        }
    }

    public final void initCommonUI() {
        TextView textView;
        TextView textView2;
        View view = getView();
        if (view != null) {
            h();
            com.sumsub.sns.core.presentation.helper.a aVar = com.sumsub.sns.core.presentation.helper.a.f31095a;
            com.sumsub.sns.internal.core.theme.d a11 = aVar.a();
            if (a11 != null) {
                String c11 = aVar.c(a11, SNSMetricElement.SCREEN_HEADER_ALIGNMENT);
                if (!(c11 == null || (textView2 = (TextView) view.findViewById(R.id.sns_title)) == null)) {
                    aVar.a(textView2, c11);
                }
                String c12 = aVar.c(a11, SNSMetricElement.SECTION_HEADER_ALIGNMENT);
                if (!(c12 == null || (textView = (TextView) view.findViewById(R.id.sns_subtitle)) == null)) {
                    aVar.a(textView, c12);
                }
                Float a12 = aVar.a(a11, SNSMetricElement.SCREEN_HORIZONTAL_MARGIN);
                if (a12 != null) {
                    float floatValue = a12.floatValue();
                    ViewGroup viewGroup = (ViewGroup) view.findViewById(R.id.sns_fragment_content);
                    if (viewGroup != null) {
                        int i11 = (int) floatValue;
                        viewGroup.setPadding(i11, viewGroup.getPaddingTop(), i11, viewGroup.getPaddingBottom());
                    }
                    Guideline guideline = (Guideline) view.findViewById(R.id.sns_guideline_start);
                    if (guideline != null) {
                        guideline.setGuidelineBegin((int) floatValue);
                    }
                    Guideline guideline2 = (Guideline) view.findViewById(R.id.sns_guideline_end);
                    if (guideline2 != null) {
                        guideline2.setGuidelineEnd((int) floatValue);
                    }
                }
                SNSColorElement sNSColorElement = SNSColorElement.CONTENT_WEAK;
                TextView poweredByText = getPoweredByText();
                Integer a13 = aVar.a(a11, sNSColorElement, poweredByText != null ? aVar.a((View) poweredByText) : false);
                if (a13 != null) {
                    int intValue = a13.intValue();
                    TextView poweredByText2 = getPoweredByText();
                    if (poweredByText2 != null) {
                        poweredByText2.setTextColor(intValue);
                    }
                }
            }
        }
    }

    public final boolean isForResult() {
        Bundle arguments = getArguments();
        return (arguments != null ? arguments.getString(FRAGMENT_REQUEST_KEY) : null) != null;
    }

    public final boolean isPrepared() {
        return this.isPrepared;
    }

    public boolean isTransparentStatusBar() {
        return this.isTransparentStatusBar;
    }

    public final void j() {
        Window window = requireActivity().getWindow();
        q0.a(window, true);
        new r0(window, requireView()).e(WindowInsetsCompat.l.b());
    }

    public final void navigateTo(Fragment fragment, String str) {
        v.a(this).d(new C0280b(this, fragment, str, (kotlin.coroutines.c<? super C0280b>) null));
    }

    public SNSCompletionResult onCancelResult() {
        return new SNSCompletionResult.SuccessTermination((SNSLivenessReason) null, 1, (r) null);
    }

    public void onCloseButtonClick() {
    }

    public void onCreate(Bundle bundle) {
        Window window;
        this.uniqueIdHolder.a(bundle);
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String logTag2 = getLogTag();
            com.sumsub.log.logger.a.d(aVar, logTag2, "Lifecycle " + this + ".onCreate", (Throwable) null, 4, (Object) null);
        }
        if (bundle != null) {
            this.statusBarColor = bundle.getInt("status_bar_color");
            this.navigationBarColor = bundle.getInt("nav_bar_color");
            this.sysUiVisibility = bundle.getInt(ARG_UI_VISIBILITY);
            this.windowFlags = bundle.getInt(ARG_WINDOW_FLAGS);
        } else {
            FragmentActivity activity = getActivity();
            if (!(activity == null || (window = activity.getWindow()) == null)) {
                this.statusBarColor = window.getStatusBarColor();
                this.navigationBarColor = window.getNavigationBarColor();
                this.sysUiVisibility = window.getDecorView().getSystemUiVisibility();
                this.windowFlags = window.getAttributes().flags;
            }
        }
        super.onCreate(bundle);
        m c11 = m.c(requireContext());
        setEnterTransition(c11.e(R.transition.fade));
        setExitTransition(c11.e(R.transition.fade_delayed));
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return layoutInflater.inflate(getLayoutId(), viewGroup, false);
    }

    public void onDestroyView() {
        getAnalyticsDelegate().d();
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        String logTag2 = getLogTag();
        com.sumsub.sns.core.c.b(cVar, logTag2, "closing " + getScreen().getText(), (Throwable) null, 4, (Object) null);
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.d(aVar, a11, "Lifecycle " + this + ".onDestroyView", (Throwable) null, 4, (Object) null);
        }
        super.onDestroyView();
    }

    public final void onErrorCancelled(o oVar) {
        getViewModel().a(oVar);
    }

    public boolean onFinishCalled(q qVar) {
        i();
        return true;
    }

    public final void onHandleError(o oVar) {
        getViewModel().b(oVar);
    }

    @SensorsDataInstrumented
    public void onHiddenChanged(boolean z11) {
        super.onHiddenChanged(z11);
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.d(aVar, a11, "Lifecycle " + this + ".onHiddenChanged, hidden=" + z11, (Throwable) null, 4, (Object) null);
        }
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
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String logTag2 = getLogTag();
            com.sumsub.log.logger.a.d(aVar, logTag2, "Lifecycle " + this + ".onResume", (Throwable) null, 4, (Object) null);
        }
        getAnalyticsDelegate().c();
        FragmentTrackHelper.trackFragmentResume(this);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        this.uniqueIdHolder.b(bundle);
        bundle.putInt("status_bar_color", this.statusBarColor);
        bundle.putInt("nav_bar_color", this.navigationBarColor);
        bundle.putInt(ARG_UI_VISIBILITY, this.sysUiVisibility);
        bundle.putInt(ARG_WINDOW_FLAGS, this.windowFlags);
    }

    public void onStart() {
        super.onStart();
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String logTag2 = getLogTag();
            com.sumsub.log.logger.a.d(aVar, logTag2, "Lifecycle " + this + ".onStart", (Throwable) null, 4, (Object) null);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.getWindow() != null && isTransparentStatusBar()) {
            g();
        }
    }

    public void onStop() {
        super.onStop();
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String logTag2 = getLogTag();
            com.sumsub.log.logger.a.d(aVar, logTag2, "Lifecycle " + this + ".onStop", (Throwable) null, 4, (Object) null);
        }
        FragmentActivity activity = getActivity();
        if (activity != null && activity.getWindow() != null && isTransparentStatusBar()) {
            j();
        }
    }

    @SensorsDataInstrumented
    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        if (e0.f32018a.isDebug()) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            String a11 = com.sumsub.sns.internal.log.c.a(this);
            com.sumsub.log.logger.a.d(aVar, a11, "Lifecycle " + this + ".onViewCreated", (Throwable) null, 4, (Object) null);
        }
        getAnalyticsDelegate().e();
        com.sumsub.sns.core.c cVar = com.sumsub.sns.core.c.f30748a;
        String logTag2 = getLogTag();
        com.sumsub.sns.core.c.b(cVar, logTag2, "opening " + getScreen().getText(), (Throwable) null, 4, (Object) null);
        b0.a(getViewModel().g(), getViewLifecycleOwner(), new c(this));
        b0.b(getViewModel().i(), getViewLifecycleOwner(), new d(this, bundle, (kotlin.coroutines.c<? super d>) null));
        initCommonUI();
        FragmentTrackHelper.onFragmentViewCreated(this, view, bundle);
    }

    public void onViewModelPrepared(Bundle bundle) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "Lifecycle " + this + " onViewModelPrepared", (Throwable) null, 4, (Object) null);
        b0.b(f.y(getViewModel().j()), (LifecycleOwner) this, new e(this, bundle, (kotlin.coroutines.c<? super e>) null));
    }

    public final void setResult(int i11, Bundle bundle) {
        if (isForResult()) {
            this.isResultSet = true;
            String fragmentRequestKey = getFragmentRequestKey();
            bundle.putInt(FRAGMENT_RESULT_KEY, i11);
            Unit unit = Unit.f56620a;
            androidx.fragment.app.p.a(this, fragmentRequestKey, bundle);
        }
    }

    @SensorsDataInstrumented
    public void setUserVisibleHint(boolean z11) {
        super.setUserVisibleHint(z11);
        FragmentTrackHelper.trackFragmentSetUserVisibleHint(this, z11);
    }

    public final void updateCommonUiState(a.k kVar) {
        updatePoweredByVisibility(kVar.g());
        TextView poweredByText = getPoweredByText();
        if (poweredByText != null) {
            i.a(poweredByText, kVar.h());
        }
        TextView progressTextView = getProgressTextView();
        if (progressTextView != null) {
            i.a(progressTextView, kVar.i());
        }
    }

    public void updatePoweredByVisibility(boolean z11) {
        TextView poweredByText = getPoweredByText();
        if (poweredByText != null) {
            i.a((View) poweredByText, z11);
        }
    }

    public void updateShowProgress(boolean z11) {
        k0 appListener = getAppListener();
        if (appListener != null) {
            appListener.a(z11);
        }
    }

    @SensorsDataInstrumented
    public static final void a(b bVar, View view) {
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(bVar), "close click", (Throwable) null, 4, (Object) null);
        bVar.onCloseButtonClick();
        bVar.getAnalyticsDelegate().a(false);
        FragmentActivity activity = bVar.getActivity();
        if (activity != null) {
            activity.onBackPressed();
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }
}
