package com.sumsub.sns.presentation.screen.preview.ekyc.eid;

import android.animation.LayoutTransition;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.nfc.NfcAdapter;
import android.nfc.NfcManager;
import android.os.Bundle;
import android.text.Spanned;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSCommonBottomSheetView;
import com.sumsub.sns.core.widget.SNSDotsProgressView;
import com.sumsub.sns.core.widget.SNSToolbarView;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.n0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.i;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000À\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\f\u0018\u0000 A2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\bB\u0007¢\u0006\u0004\bh\u0010iJ\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\tH\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\nH\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u000bH\u0003J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\fH\u0003J\b\u0010\r\u001a\u00020\u0007H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u000eH\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\"\u0010\b\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00112\b\u0010\u0014\u001a\u0004\u0018\u00010\u0011H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0015\u001a\u00020\u0011H\u0002J\u001a\u0010\b\u001a\u0004\u0018\u00010\u00182\u0006\u0010\u0006\u001a\u00020\u00022\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u0019H\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u0016H\u0014J\u0010\u0010 \u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016J\b\u0010!\u001a\u00020\u0007H\u0017J\b\u0010\"\u001a\u00020\u0007H\u0016J\u001a\u0010&\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010$H\u0016J\b\u0010'\u001a\u00020\u0007H\u0016J\b\u0010(\u001a\u00020\u0007H\u0016J\u0010\u0010*\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020)H\u0014J\u001a\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u00022\b\u0010%\u001a\u0004\u0018\u00010$H\u0014J\b\u0010+\u001a\u00020\u0007H\u0016J\b\u0010,\u001a\u00020\u0007H\u0016R\u001b\u00100\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\b\u0010-\u001a\u0004\b.\u0010/R\u001a\u00104\u001a\u00020\u00118\u0014XD¢\u0006\f\n\u0004\b+\u00101\u001a\u0004\b2\u00103R\u001d\u0010:\u001a\u0004\u0018\u0001058BX\u0002¢\u0006\f\n\u0004\b6\u00107\u001a\u0004\b8\u00109R\u001d\u0010>\u001a\u0004\u0018\u00010;8BX\u0002¢\u0006\f\n\u0004\b,\u00107\u001a\u0004\b<\u0010=R\u001d\u0010C\u001a\u0004\u0018\u00010?8BX\u0002¢\u0006\f\n\u0004\b@\u00107\u001a\u0004\bA\u0010BR\u0018\u0010F\u001a\u0004\u0018\u00010\u00028\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bD\u0010ER\u0018\u0010J\u001a\u0004\u0018\u00010G8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bH\u0010IR\u0016\u0010N\u001a\u00020K8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bL\u0010MR\u0018\u0010R\u001a\u0004\u0018\u00010O8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bP\u0010QR\u0016\u0010U\u001a\u00020\u000e8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bS\u0010TR\u0018\u0010X\u001a\u0004\u0018\u00010V8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0010\u0010WR\u0014\u0010\\\u001a\u00020Y8VX\u0004¢\u0006\u0006\u001a\u0004\bZ\u0010[R \u0010a\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020^0]8VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R \u0010c\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020^0]8VX\u0004¢\u0006\u0006\u001a\u0004\bb\u0010`R \u0010e\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020^0]8VX\u0004¢\u0006\u0006\u001a\u0004\bd\u0010`R \u0010g\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020^0]8VX\u0004¢\u0006\u0006\u001a\u0004\bf\u0010`¨\u0006j"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/ekyc/eid/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/b;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/i$b;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/b$b;", "state", "", "a", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/b$a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/b$f;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/b$e;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/b$d;", "p", "", "needCan", "k", "", "oldPin", "newPin", "lastPinDigit", "pin", "", "layout", "Landroid/view/View;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/a$k;", "event", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/a$l;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/a$j;", "getLayoutId", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "onFinishCalled", "onResume", "onPause", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onDestroyView", "onDestroy", "Lcom/sumsub/sns/core/presentation/base/a$j;", "handleEvent", "b", "d", "Lkotlin/i;", "o", "()Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/a;", "viewModel", "Ljava/lang/String;", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Landroid/view/ViewGroup;", "c", "Lcom/sumsub/sns/internal/core/common/z;", "m", "()Landroid/view/ViewGroup;", "content", "Lcom/sumsub/sns/core/widget/SNSToolbarView;", "n", "()Lcom/sumsub/sns/core/widget/SNSToolbarView;", "toolbarView", "Lcom/sumsub/sns/core/widget/SNSCommonBottomSheetView;", "e", "l", "()Lcom/sumsub/sns/core/widget/SNSCommonBottomSheetView;", "bottomSheet", "f", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/b;", "currentState", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/d;", "g", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/d;", "authadaInteractor", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/i;", "h", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/i;", "nfcBroadcastReceiver", "Landroid/app/AlertDialog;", "i", "Landroid/app/AlertDialog;", "nfcStateAlertDialog", "j", "Z", "forcedFinish", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/a$a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/eid/main/a$a;", "analyticsWrapper", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "", "", "getOpenPayload", "()Ljava/util/Map;", "openPayload", "getCancelPayload", "cancelPayload", "getClosePayload", "closePayload", "getAppearPayload", "appearPayload", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a> implements i.b {

    /* renamed from: l  reason: collision with root package name */
    public static final C0533a f39877l = new C0533a((r) null);

    /* renamed from: m  reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.l<Object>[] f39878m = {Reflection.j(new PropertyReference1Impl(a.class, "content", "getContent()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "toolbarView", "getToolbarView()Lcom/sumsub/sns/core/widget/SNSToolbarView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "bottomSheet", "getBottomSheet()Lcom/sumsub/sns/core/widget/SNSCommonBottomSheetView;", 0))};

    /* renamed from: n  reason: collision with root package name */
    public static final String f39879n = "result_token";

    /* renamed from: o  reason: collision with root package name */
    public static final String f39880o = "request_key_pin";

    /* renamed from: p  reason: collision with root package name */
    public static final String f39881p = "SNSEidMainFragment";

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.i f39882a;

    /* renamed from: b  reason: collision with root package name */
    public final String f39883b = DocumentType.f32357l;

    /* renamed from: c  reason: collision with root package name */
    public final z f39884c = a0.a(this, R.id.sns_content);

    /* renamed from: d  reason: collision with root package name */
    public final z f39885d = a0.a(this, R.id.sns_toolbar);

    /* renamed from: e  reason: collision with root package name */
    public final z f39886e = a0.a(this, R.id.sns_eid_bottom_sheet);

    /* renamed from: f  reason: collision with root package name */
    public com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b f39887f;

    /* renamed from: g  reason: collision with root package name */
    public com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.d f39888g;

    /* renamed from: h  reason: collision with root package name */
    public com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.i f39889h = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.i(this);

    /* renamed from: i  reason: collision with root package name */
    public AlertDialog f39890i;

    /* renamed from: j  reason: collision with root package name */
    public boolean f39891j;

    /* renamed from: k  reason: collision with root package name */
    public a.C0436a f39892k;

    /* renamed from: com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$a  reason: collision with other inner class name */
    public static final class C0533a {
        public /* synthetic */ C0533a(r rVar) {
            this();
        }

        public C0533a() {
        }

        public final a a(String str, String str2, String str3) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.J, str);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.L, str3);
            bundle.putString(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.K, str2);
            aVar.setArguments(bundle);
            return aVar;
        }

        public final boolean a(Context context) {
            NfcAdapter nfcAdapter = null;
            NfcManager nfcManager = (NfcManager) (context != null ? context.getSystemService("nfc") : null);
            if (nfcManager != null) {
                nfcAdapter = nfcManager.getDefaultAdapter();
            }
            if (nfcAdapter != null) {
                return nfcAdapter.isEnabled();
            }
            return false;
        }
    }

    public static final class b extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39893a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.a f39894b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public b(a aVar, b.a aVar2) {
            super(0);
            this.f39893a = aVar;
            this.f39894b = aVar2;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.b(this.f39893a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39893a.getViewModel(), (a.n) null, 1, (Object) null), this.f39893a.getIdDocSetType(), Control.ContinueButton, (Map) null, 8, (Object) null);
            this.f39893a.getViewModel().a(this.f39894b.j());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class c extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39895a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(a aVar) {
            super(0);
            this.f39895a = aVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.a(this.f39895a.getAnalyticsDelegate(), Screen.EidServiceInfo, (Map) null, 2, (Object) null);
            SNSCommonBottomSheetView a11 = this.f39895a.l();
            if (a11 != null) {
                a11.hide();
            }
            com.sumsub.sns.internal.core.analytics.c.b(this.f39895a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39895a.getViewModel(), (a.n) null, 1, (Object) null), this.f39895a.getIdDocSetType(), Control.DismissButton, (Map) null, 8, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class d extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39896a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.C0466b f39897b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public d(a aVar, b.C0466b bVar) {
            super(0);
            this.f39896a = aVar;
            this.f39897b = bVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.b(this.f39896a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39896a.getViewModel(), (a.n) null, 1, (Object) null), this.f39896a.getIdDocSetType(), Control.InfoButton, (Map) null, 8, (Object) null);
            this.f39896a.getViewModel().a(this.f39897b.l());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class e extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39898a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.C0466b f39899b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public e(a aVar, b.C0466b bVar) {
            super(0);
            this.f39898a = aVar;
            this.f39899b = bVar;
        }

        public final void a() {
            this.f39898a.getViewModel().a(this.f39899b.j());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class f extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39900a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(a aVar) {
            super(0);
            this.f39900a = aVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.a(this.f39900a.getAnalyticsDelegate(), Screen.EidPinInfo, (Map) null, 2, (Object) null);
            SNSCommonBottomSheetView a11 = this.f39900a.l();
            if (a11 != null) {
                a11.hide();
            }
            com.sumsub.sns.internal.core.analytics.c.b(this.f39900a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39900a.getViewModel(), (a.n) null, 1, (Object) null), this.f39900a.getIdDocSetType(), Control.DismissButton, (Map) null, 8, (Object) null);
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class g extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39901a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.d f39902b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(a aVar, b.d dVar) {
            super(0);
            this.f39901a = aVar;
            this.f39902b = dVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.b(this.f39901a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39901a.getViewModel(), (a.n) null, 1, (Object) null), this.f39901a.getIdDocSetType(), Control.InfoButton, (Map) null, 8, (Object) null);
            this.f39901a.getViewModel().a(this.f39902b.n());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class h extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39903a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.d f39904b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(a aVar, b.d dVar) {
            super(0);
            this.f39903a = aVar;
            this.f39904b = dVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.b(this.f39903a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39903a.getViewModel(), (a.n) null, 1, (Object) null), this.f39903a.getIdDocSetType(), Control.EidProceedToIdentButton, (Map) null, 8, (Object) null);
            this.f39903a.getViewModel().a(this.f39904b.p());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class i extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39905a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.d f39906b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(a aVar, b.d dVar) {
            super(0);
            this.f39905a = aVar;
            this.f39906b = dVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.b(this.f39905a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39905a.getViewModel(), (a.n) null, 1, (Object) null), this.f39905a.getIdDocSetType(), Control.EidChangeTransportPinButton, (Map) null, 8, (Object) null);
            this.f39905a.getViewModel().a(this.f39906b.l());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class j extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39907a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.e f39908b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(a aVar, b.e eVar) {
            super(0);
            this.f39907a = aVar;
            this.f39908b = eVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.b(this.f39907a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39907a.getViewModel(), (a.n) null, 1, (Object) null), this.f39907a.getIdDocSetType(), Control.CancelButton, (Map) null, 8, (Object) null);
            this.f39907a.getViewModel().a(this.f39908b.j());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class k extends Lambda implements d10.a<Unit> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39909a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.f f39910b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(a aVar, b.f fVar) {
            super(0);
            this.f39909a = aVar;
            this.f39910b = fVar;
        }

        public final void a() {
            com.sumsub.sns.internal.core.analytics.c.b(this.f39909a.getAnalyticsDelegate(), com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(this.f39909a.getViewModel(), (a.n) null, 1, (Object) null), this.f39909a.getIdDocSetType(), Control.ContinueButton, (Map) null, 8, (Object) null);
            this.f39909a.getViewModel().a(this.f39910b.j());
        }

        public /* bridge */ /* synthetic */ Object invoke() {
            a();
            return Unit.f56620a;
        }
    }

    public static final class l extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39911a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(Fragment fragment) {
            super(0);
            this.f39911a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39911a;
        }
    }

    public static final class m extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39912a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public m(d10.a aVar) {
            super(0);
            this.f39912a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39912a.invoke();
        }
    }

    public static final class n extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39913a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public n(kotlin.i iVar) {
            super(0);
            this.f39913a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39913a).getViewModelStore();
        }
    }

    public static final class o extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39914a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39915b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public o(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f39914a = aVar;
            this.f39915b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39914a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39915b);
            androidx.lifecycle.o oVar = b11 instanceof androidx.lifecycle.o ? (androidx.lifecycle.o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class p extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39916a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39917b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public p(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f39916a = fragment;
            this.f39917b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39917b);
            androidx.lifecycle.o oVar = b11 instanceof androidx.lifecycle.o ? (androidx.lifecycle.o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39916a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class q extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39918a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public q(a aVar) {
            super(0);
            this.f39918a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f39918a;
            return new a.m(aVar, aVar.getServiceLocator(), this.f39918a.getArguments());
        }
    }

    public a() {
        q qVar = new q(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new m(new l(this)));
        this.f39882a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.class), new n(b11), new o((d10.a) null, b11), qVar);
    }

    public void d() {
        AlertDialog alertDialog = this.f39890i;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public Map<String, Object> getAppearPayload() {
        return com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.a(getViewModel(), (a.n) null, 1, (Object) null);
    }

    public Map<String, Object> getCancelPayload() {
        return com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.a(getViewModel(), (a.n) null, 1, (Object) null);
    }

    public Map<String, Object> getClosePayload() {
        return com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.a(getViewModel(), (a.n) null, 1, (Object) null);
    }

    public String getIdDocSetType() {
        return this.f39883b;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_eid;
    }

    public Map<String, Object> getOpenPayload() {
        return com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.a(getViewModel(), (a.n) null, 1, (Object) null);
    }

    public Screen getScreen() {
        return com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a.b(getViewModel(), (a.n) null, 1, (Object) null);
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof a.o) {
            Bundle bundle = new Bundle();
            bundle.putString(f39879n, ((a.o) jVar).b());
            Unit unit = Unit.f56620a;
            com.sumsub.sns.core.presentation.b.finishWithResult$default(this, 0, bundle, 1, (Object) null);
        } else if (jVar instanceof a.f) {
            a.f fVar = (a.f) jVar;
            a(fVar.f(), fVar.e(), fVar.d());
        } else if (jVar instanceof a.e) {
            a(((a.e) jVar).b());
        } else if (jVar instanceof a.c) {
            k();
        } else if (jVar instanceof a.g) {
            a(((a.g) jVar).b());
        } else if (jVar instanceof a.h) {
            p();
        } else if (jVar instanceof a.l) {
            a((a.l) jVar);
        } else if (jVar instanceof a.j) {
            a((a.j) jVar);
        } else if (jVar instanceof a.b) {
            if (this.f39888g == null) {
                this.f39888g = new com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.d(requireActivity());
            }
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.d dVar = this.f39888g;
            if (dVar != null) {
                dVar.a(((a.b) jVar).b());
            }
        } else if (jVar instanceof a.k) {
            a((a.k) jVar);
        } else {
            super.handleEvent(jVar);
        }
    }

    public final void k() {
        com.sumsub.sns.core.presentation.b.navigateTo$default(this, b.f39919i.a(a.e.f35862a).forResult(f39880o), (String) null, 2, (Object) null);
    }

    public final SNSCommonBottomSheetView l() {
        return (SNSCommonBottomSheetView) this.f39886e.a(this, f39878m[2]);
    }

    public final ViewGroup m() {
        return (ViewGroup) this.f39884c.a(this, f39878m[0]);
    }

    public final SNSToolbarView n() {
        return (SNSToolbarView) this.f39885d.a(this, f39878m[1]);
    }

    /* renamed from: o */
    public com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.a) this.f39882a.getValue();
    }

    public void onDestroy() {
        super.onDestroy();
        getViewModel().E();
        com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.d dVar = this.f39888g;
        if (dVar != null) {
            dVar.a();
        }
        this.f39888g = null;
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.f39887f = null;
    }

    public boolean onFinishCalled(com.sumsub.sns.internal.core.common.q qVar) {
        SNSCommonBottomSheetView l11 = l();
        if (l11 != null && !l11.isHidden()) {
            SNSCommonBottomSheetView l12 = l();
            if (l12 != null) {
                l12.hide();
            }
            return false;
        } else if (this.f39891j || getViewModel().a(qVar)) {
            return super.onFinishCalled(qVar);
        } else {
            return false;
        }
    }

    public void onPause() {
        super.onPause();
        Context applicationContext = requireContext().getApplicationContext();
        if (applicationContext != null) {
            applicationContext.unregisterReceiver(this.f39889h);
        }
    }

    @SuppressLint({"WrongConstant"})
    public void onResume() {
        super.onResume();
        ContextCompat.registerReceiver(requireContext().getApplicationContext(), this.f39889h, com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.i.f35643b.a(), 2);
        boolean a11 = f39877l.a(requireContext());
        if (a11) {
            d();
        } else if (!a11) {
            b();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        requireActivity().getSupportFragmentManager().H1(f39880o, this, new e(this));
    }

    public final void p() {
        com.sumsub.sns.core.presentation.b.navigateTo$default(this, b.f39919i.a(a.d.f35861a).forResult(f39880o), (String) null, 2, (Object) null);
    }

    public static final void a(a aVar, String str, Bundle bundle) {
        boolean z11;
        if (com.sumsub.sns.core.presentation.b.Companion.b(bundle)) {
            com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.b bVar = (com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.b) bundle.getParcelable(n0.d.f32148b);
            if (bVar != null) {
                com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.pin.a i11 = bVar.i();
                if (i11 instanceof a.c) {
                    aVar.getViewModel().a(bVar.j(), ((a.c) bVar.i()).b());
                } else if (i11 instanceof a.C0469a) {
                    aVar.getViewModel().b(bVar.j(), bVar.f());
                } else {
                    if (i11 instanceof a.e) {
                        z11 = true;
                    } else {
                        z11 = i11 instanceof a.b;
                    }
                    if (z11) {
                        aVar.getViewModel().a(bVar.h(), bVar.j(), bVar.f(), bVar.g());
                    } else if (i11 instanceof a.d) {
                        aVar.getViewModel().c(bVar.j());
                    }
                }
            }
        } else if (!(aVar.f39887f instanceof b.d)) {
            aVar.getViewModel().a((com.sumsub.sns.internal.core.common.q) q.c.f32251b);
        }
    }

    public void b() {
        getViewModel().A();
    }

    @SensorsDataInstrumented
    public static final void b(a aVar, DialogInterface dialogInterface, int i11) {
        aVar.f39891j = true;
        com.sumsub.sns.core.presentation.b.finish$default(aVar, (com.sumsub.sns.internal.core.common.q) null, (Object) null, (Long) null, 7, (Object) null);
        SensorsDataAutoTrackHelper.trackDialog(dialogInterface, i11);
    }

    /* renamed from: a */
    public void handleState(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b bVar, Bundle bundle) {
        ViewGroup m11;
        LayoutTransition layoutTransition;
        SNSToolbarView n11 = n();
        if (n11 != null) {
            n11.setOptionButtonVisible(false);
        }
        ViewGroup m12 = m();
        if (m12 != null) {
            com.sumsub.sns.internal.core.common.i.a(m12);
        }
        if (bVar instanceof b.a) {
            a((b.a) bVar);
        } else if (bVar instanceof b.e) {
            if (!(!(this.f39887f instanceof b.e) || (m11 = m()) == null || (layoutTransition = m11.getLayoutTransition()) == null)) {
                layoutTransition.setDuration(0);
            }
            a((b.e) bVar);
        } else if (bVar instanceof b.f) {
            a((b.f) bVar);
        } else if (bVar instanceof b.d) {
            a((b.d) bVar);
        } else if (bVar instanceof b.C0466b) {
            a((b.C0466b) bVar);
        } else {
            boolean z11 = bVar instanceof b.c;
        }
        a.C0436a aVar = this.f39892k;
        Screen d11 = aVar != null ? aVar.d() : null;
        a.C0436a a11 = bVar.a();
        if (d11 != (a11 != null ? a11.d() : null)) {
            a.C0436a aVar2 = this.f39892k;
            if (aVar2 != null) {
                com.sumsub.sns.internal.log.a aVar3 = com.sumsub.sns.internal.log.a.f34862a;
                com.sumsub.log.logger.a.c(aVar3, f39881p, "Screen closed " + aVar2.d() + ' ' + aVar2.c(), (Throwable) null, 4, (Object) null);
                getAnalyticsDelegate().c(aVar2.d(), getIdDocSetType(), aVar2.c());
                a.C0436a a12 = bVar.a();
                if (a12 != null) {
                    com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.g.b(f39881p, "Screen changed " + a12.d() + ' ' + a12.c(), (Throwable) null, 4, (Object) null);
                    getAnalyticsDelegate().d(a12.d(), getIdDocSetType(), a12.c());
                }
            }
            this.f39892k = bVar.a();
        }
        this.f39887f = bVar;
    }

    /* JADX WARNING: type inference failed for: r0v12, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"MissingInflatedId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b.C0466b r10) {
        /*
            r9 = this;
            int r0 = com.sumsub.sns.R.layout.sns_eid_pin_selector
            android.view.View r0 = r9.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b) r10, (int) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0012
            int r2 = com.sumsub.sns.R.id.sns_title
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            if (r0 == 0) goto L_0x001e
            int r3 = com.sumsub.sns.R.id.sns_subtitle
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            if (r0 == 0) goto L_0x002a
            int r4 = com.sumsub.sns.R.id.sns_button_option
            android.view.View r4 = r0.findViewById(r4)
            android.widget.Button r4 = (android.widget.Button) r4
            goto L_0x002b
        L_0x002a:
            r4 = r1
        L_0x002b:
            if (r0 == 0) goto L_0x0036
            int r5 = com.sumsub.sns.R.id.sns_primary_button
            android.view.View r5 = r0.findViewById(r5)
            android.widget.Button r5 = (android.widget.Button) r5
            goto L_0x0037
        L_0x0036:
            r5 = r1
        L_0x0037:
            if (r0 == 0) goto L_0x0042
            int r6 = com.sumsub.sns.R.id.sns_secondary_button
            android.view.View r6 = r0.findViewById(r6)
            android.widget.Button r6 = (android.widget.Button) r6
            goto L_0x0043
        L_0x0042:
            r6 = r1
        L_0x0043:
            if (r0 == 0) goto L_0x004e
            int r1 = com.sumsub.sns.R.id.sns_image
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x004e:
            if (r1 == 0) goto L_0x0067
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r0 = r0.getIconHandler()
            android.content.Context r7 = r9.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSEidIcons r8 = com.sumsub.sns.core.data.listener.SNSIconHandler.SNSEidIcons.PIN
            java.lang.String r8 = r8.getImageName()
            android.graphics.drawable.Drawable r0 = r0.onResolveIcon(r7, r8)
            r1.setImageDrawable(r0)
        L_0x0067:
            if (r2 != 0) goto L_0x006a
            goto L_0x0071
        L_0x006a:
            java.lang.CharSequence r0 = r10.o()
            r2.setText(r0)
        L_0x0071:
            if (r3 != 0) goto L_0x0074
            goto L_0x007b
        L_0x0074:
            java.lang.CharSequence r0 = r10.n()
            r3.setText(r0)
        L_0x007b:
            if (r6 != 0) goto L_0x007e
            goto L_0x0083
        L_0x007e:
            r0 = 8
            r6.setVisibility(r0)
        L_0x0083:
            if (r4 == 0) goto L_0x0094
            java.lang.CharSequence r0 = r10.m()
            r4.setText(r0)
            com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$d r0 = new com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$d
            r0.<init>(r9, r10)
            com.sumsub.sns.internal.core.common.l.a((android.view.View) r4, (d10.a<kotlin.Unit>) r0)
        L_0x0094:
            if (r5 == 0) goto L_0x00a5
            java.lang.CharSequence r0 = r10.k()
            r5.setText(r0)
            com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$e r0 = new com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$e
            r0.<init>(r9, r10)
            com.sumsub.sns.internal.core.common.l.a((android.view.View) r5, (d10.a<kotlin.Unit>) r0)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.ekyc.eid.a.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$b):void");
    }

    /* JADX WARNING: type inference failed for: r0v10, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"MissingInflatedId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b.a r6) {
        /*
            r5 = this;
            int r0 = com.sumsub.sns.R.layout.sns_eid_info
            android.view.View r0 = r5.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b) r6, (int) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0012
            int r2 = com.sumsub.sns.R.id.sns_title
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            if (r0 == 0) goto L_0x001e
            int r3 = com.sumsub.sns.R.id.sns_subtitle
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            if (r0 == 0) goto L_0x002a
            int r4 = com.sumsub.sns.R.id.sns_continue
            android.view.View r4 = r0.findViewById(r4)
            android.widget.Button r4 = (android.widget.Button) r4
            goto L_0x002b
        L_0x002a:
            r4 = r1
        L_0x002b:
            if (r0 == 0) goto L_0x0036
            int r1 = com.sumsub.sns.R.id.sns_image
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x0036:
            if (r2 == 0) goto L_0x003f
            java.lang.CharSequence r0 = r6.o()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
        L_0x003f:
            if (r3 == 0) goto L_0x0048
            java.lang.CharSequence r0 = r6.n()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r3, (java.lang.CharSequence) r0)
        L_0x0048:
            if (r4 == 0) goto L_0x0059
            java.lang.CharSequence r0 = r6.k()
            r4.setText(r0)
            com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$b r0 = new com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$b
            r0.<init>(r5, r6)
            com.sumsub.sns.internal.core.common.l.a((android.view.View) r4, (d10.a<kotlin.Unit>) r0)
        L_0x0059:
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSEidIcons r0 = r6.l()
            if (r0 == 0) goto L_0x0082
            if (r1 != 0) goto L_0x0062
            goto L_0x0066
        L_0x0062:
            r0 = 0
            r1.setVisibility(r0)
        L_0x0066:
            if (r1 == 0) goto L_0x008a
            com.sumsub.sns.internal.core.common.e0 r0 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r0 = r0.getIconHandler()
            android.content.Context r2 = r5.requireContext()
            com.sumsub.sns.core.data.listener.SNSIconHandler$SNSEidIcons r6 = r6.l()
            java.lang.String r6 = r6.getImageName()
            android.graphics.drawable.Drawable r6 = r0.onResolveIcon(r2, r6)
            r1.setImageDrawable(r6)
            goto L_0x008a
        L_0x0082:
            if (r1 != 0) goto L_0x0085
            goto L_0x008a
        L_0x0085:
            r6 = 8
            r1.setVisibility(r6)
        L_0x008a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.ekyc.eid.a.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$a):void");
    }

    /* JADX WARNING: type inference failed for: r0v11, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    @android.annotation.SuppressLint({"MissingInflatedId"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b.f r8) {
        /*
            r7 = this;
            int r0 = com.sumsub.sns.R.layout.sns_eid_status
            android.view.View r0 = r7.a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b) r8, (int) r0)
            r1 = 0
            if (r0 == 0) goto L_0x0012
            int r2 = com.sumsub.sns.R.id.sns_title
            android.view.View r2 = r0.findViewById(r2)
            android.widget.TextView r2 = (android.widget.TextView) r2
            goto L_0x0013
        L_0x0012:
            r2 = r1
        L_0x0013:
            if (r0 == 0) goto L_0x001e
            int r3 = com.sumsub.sns.R.id.sns_subtitle
            android.view.View r3 = r0.findViewById(r3)
            android.widget.TextView r3 = (android.widget.TextView) r3
            goto L_0x001f
        L_0x001e:
            r3 = r1
        L_0x001f:
            if (r0 == 0) goto L_0x002a
            int r4 = com.sumsub.sns.R.id.sns_button
            android.view.View r4 = r0.findViewById(r4)
            android.widget.Button r4 = (android.widget.Button) r4
            goto L_0x002b
        L_0x002a:
            r4 = r1
        L_0x002b:
            if (r0 == 0) goto L_0x0036
            int r1 = com.sumsub.sns.R.id.sns_status
            android.view.View r0 = r0.findViewById(r1)
            r1 = r0
            android.widget.ImageView r1 = (android.widget.ImageView) r1
        L_0x0036:
            boolean r0 = r8.m()
            if (r0 == 0) goto L_0x0045
            if (r1 != 0) goto L_0x003f
            goto L_0x004d
        L_0x003f:
            com.sumsub.sns.internal.core.widget.SNSStepState r0 = com.sumsub.sns.internal.core.widget.SNSStepState.PROCESSING
            com.sumsub.sns.core.widget.SNSStepViewExtensionsKt.setSnsStepState(r1, r0)
            goto L_0x004d
        L_0x0045:
            if (r1 != 0) goto L_0x0048
            goto L_0x004d
        L_0x0048:
            com.sumsub.sns.internal.core.widget.SNSStepState r0 = com.sumsub.sns.internal.core.widget.SNSStepState.REJECTED
            com.sumsub.sns.core.widget.SNSStepViewExtensionsKt.setSnsStepState(r1, r0)
        L_0x004d:
            java.lang.String r0 = r8.l()
            if (r0 == 0) goto L_0x0066
            if (r1 == 0) goto L_0x0066
            com.sumsub.sns.internal.core.common.e0 r5 = com.sumsub.sns.internal.core.common.e0.f32018a
            com.sumsub.sns.core.data.listener.SNSIconHandler r5 = r5.getIconHandler()
            android.content.Context r6 = r7.requireContext()
            android.graphics.drawable.Drawable r0 = r5.onResolveIcon(r6, r0)
            r1.setImageDrawable(r0)
        L_0x0066:
            if (r2 == 0) goto L_0x006f
            java.lang.CharSequence r0 = r8.o()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r2, (java.lang.CharSequence) r0)
        L_0x006f:
            if (r3 == 0) goto L_0x0078
            java.lang.CharSequence r0 = r8.n()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r3, (java.lang.CharSequence) r0)
        L_0x0078:
            if (r4 == 0) goto L_0x0089
            java.lang.CharSequence r0 = r8.k()
            com.sumsub.sns.internal.core.common.i.a((android.widget.TextView) r4, (java.lang.CharSequence) r0)
            com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$k r0 = new com.sumsub.sns.presentation.screen.preview.ekyc.eid.a$k
            r0.<init>(r7, r8)
            com.sumsub.sns.internal.core.common.l.a((android.view.View) r4, (d10.a<kotlin.Unit>) r0)
        L_0x0089:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.ekyc.eid.a.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b$f):void");
    }

    @SuppressLint({"MissingInflatedId"})
    public final void a(b.e eVar) {
        View a11 = a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b) eVar, R.layout.sns_eid_scanning);
        Button button = null;
        TextView textView = a11 != null ? (TextView) a11.findViewById(R.id.sns_title) : null;
        TextView textView2 = a11 != null ? (TextView) a11.findViewById(R.id.sns_subtitle) : null;
        TextView textView3 = a11 != null ? (TextView) a11.findViewById(R.id.sns_status) : null;
        ImageView imageView = a11 != null ? (ImageView) a11.findViewById(R.id.sns_image) : null;
        SNSDotsProgressView sNSDotsProgressView = a11 != null ? (SNSDotsProgressView) a11.findViewById(R.id.sns_reading_progress) : null;
        if (!x.b(eVar, this.f39887f)) {
            View view = getView();
            if (view != null) {
                button = (Button) view.findViewById(R.id.sns_button);
            }
            if (button != null) {
                button.setText(eVar.k());
                com.sumsub.sns.internal.core.common.l.a((View) button, (d10.a<Unit>) new j(this, eVar));
            }
        }
        if (textView != null) {
            com.sumsub.sns.internal.core.common.i.a(textView, eVar.o());
        }
        if (textView2 != null) {
            com.sumsub.sns.internal.core.common.i.a(textView2, eVar.n());
        }
        if (textView3 != null) {
            com.sumsub.sns.internal.core.common.i.a(textView3, eVar.m());
        }
        if (imageView != null) {
            imageView.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSEidIcons.NFC_SCAN.getImageName()));
        }
        if (eVar.l() != null) {
            if (sNSDotsProgressView != null) {
                sNSDotsProgressView.setProgress(eVar.l().intValue());
            }
            if (sNSDotsProgressView != null) {
                sNSDotsProgressView.setVisibility(0);
            }
        } else if (sNSDotsProgressView != null) {
            sNSDotsProgressView.setVisibility(8);
        }
    }

    @SuppressLint({"MissingInflatedId"})
    public final void a(b.d dVar) {
        View a11 = a((com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b) dVar, R.layout.sns_eid_pin_selector);
        Spanned spanned = null;
        TextView textView = a11 != null ? (TextView) a11.findViewById(R.id.sns_title) : null;
        TextView textView2 = a11 != null ? (TextView) a11.findViewById(R.id.sns_subtitle) : null;
        Button button = a11 != null ? (Button) a11.findViewById(R.id.sns_button_option) : null;
        Button button2 = a11 != null ? (Button) a11.findViewById(R.id.sns_primary_button) : null;
        Button button3 = a11 != null ? (Button) a11.findViewById(R.id.sns_secondary_button) : null;
        ImageView imageView = a11 != null ? (ImageView) a11.findViewById(R.id.sns_image) : null;
        if (textView != null) {
            textView.setText(dVar.s());
        }
        if (textView2 != null) {
            CharSequence r11 = dVar.r();
            if (r11 != null) {
                spanned = com.sumsub.sns.internal.core.common.i.a(r11, requireContext());
            }
            textView2.setText(spanned);
        }
        if (button != null) {
            button.setText(dVar.o());
            com.sumsub.sns.internal.core.common.l.a((View) button, (d10.a<Unit>) new g(this, dVar));
        }
        if (button2 != null) {
            button2.setText(dVar.q());
            com.sumsub.sns.internal.core.common.l.a((View) button2, (d10.a<Unit>) new h(this, dVar));
        }
        if (button3 != null) {
            button3.setText(dVar.m());
            com.sumsub.sns.internal.core.common.l.a((View) button3, (d10.a<Unit>) new i(this, dVar));
        }
        if (imageView != null) {
            imageView.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSEidIcons.ID_CARD.getImageName()));
        }
    }

    public final void a(boolean z11) {
        com.sumsub.sns.core.presentation.b.navigateTo$default(this, b.f39919i.a(new a.c(z11)).forResult(f39880o), (String) null, 2, (Object) null);
    }

    public final void a(String str, String str2, String str3) {
        com.sumsub.sns.core.presentation.b.navigateTo$default(this, b.f39919i.a(new a.b(str, str2, str3)).forResult(f39880o), (String) null, 2, (Object) null);
    }

    public final void a(String str) {
        com.sumsub.sns.core.presentation.b.navigateTo$default(this, b.f39919i.a(new a.C0469a(str)).forResult(f39880o), (String) null, 2, (Object) null);
    }

    public final View a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.eid.main.b bVar, int i11) {
        if (x.b(this.f39887f, bVar)) {
            return m();
        }
        ViewGroup m11 = m();
        if (m11 != null) {
            m11.removeAllViews();
        }
        LayoutInflater.from(requireContext()).inflate(i11, m());
        return m();
    }

    public final void a(a.k kVar) {
        AlertDialog alertDialog = this.f39890i;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(kVar.h());
        builder.setMessage(kVar.f());
        builder.setCancelable(false);
        builder.setPositiveButton(kVar.g(), new c(this));
        builder.setNegativeButton(kVar.e(), new d(this));
        AlertDialog create = builder.create();
        this.f39890i = create;
        if (create != null) {
            create.show();
        }
    }

    /* JADX WARNING: type inference failed for: r1v2, types: [android.content.DialogInterface] */
    /* JADX WARNING: type inference failed for: r1v4 */
    /* JADX WARNING: type inference failed for: r1v5 */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void a(com.sumsub.sns.presentation.screen.preview.ekyc.eid.a r1, android.content.DialogInterface r2, int r3) {
        /*
            android.content.Intent r2 = new android.content.Intent
            java.lang.String r0 = "android.settings.NFC_SETTINGS"
            r2.<init>(r0)
            r0 = 268435456(0x10000000, float:2.5243549E-29)
            r2.setFlags(r0)
            androidx.fragment.app.FragmentActivity r1 = r1.getActivity()
            if (r1 == 0) goto L_0x001b
            android.content.Context r1 = r1.getApplicationContext()
            if (r1 == 0) goto L_0x001b
            r1.startActivity(r2)
        L_0x001b:
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackDialog(r1, r3)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.presentation.screen.preview.ekyc.eid.a.a(com.sumsub.sns.presentation.screen.preview.ekyc.eid.a, android.content.DialogInterface, int):void");
    }

    public final void a(a.l lVar) {
        SNSCommonBottomSheetView l11 = l();
        View inflate = l11 != null ? l11.inflate(R.layout.sns_eid_pin_bottom_sheet) : null;
        Button button = inflate != null ? (Button) inflate.findViewById(R.id.sns_button) : null;
        TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.sns_title) : null;
        TextView textView2 = inflate != null ? (TextView) inflate.findViewById(R.id.sns_text) : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        if (textView2 != null) {
            CharSequence d11 = lVar.d();
            textView2.setText(d11 != null ? com.sumsub.sns.internal.core.common.i.a(d11, requireContext()) : null);
        }
        if (button != null) {
            button.setText(lVar.c());
        }
        if (button != null) {
            com.sumsub.sns.internal.core.common.l.a((View) button, (d10.a<Unit>) new f(this));
        }
        SNSCommonBottomSheetView l12 = l();
        if (l12 != null) {
            l12.show();
        }
        com.sumsub.sns.internal.core.analytics.c.b(getAnalyticsDelegate(), Screen.EidPinInfo, (Map) null, 2, (Object) null);
    }

    public final void a(a.j jVar) {
        SNSCommonBottomSheetView l11 = l();
        View inflate = l11 != null ? l11.inflate(R.layout.sns_eid_pin_bottom_sheet) : null;
        Button button = inflate != null ? (Button) inflate.findViewById(R.id.sns_button) : null;
        TextView textView = inflate != null ? (TextView) inflate.findViewById(R.id.sns_title) : null;
        TextView textView2 = inflate != null ? (TextView) inflate.findViewById(R.id.sns_text) : null;
        if (textView != null) {
            textView.setText(jVar.f());
        }
        if (textView2 != null) {
            textView2.setText(jVar.e());
        }
        if (button != null) {
            button.setText(jVar.d());
        }
        if (button != null) {
            com.sumsub.sns.internal.core.common.l.a((View) button, (d10.a<Unit>) new c(this));
        }
        SNSCommonBottomSheetView l12 = l();
        if (l12 != null) {
            l12.show();
        }
        com.sumsub.sns.internal.core.analytics.c.b(getAnalyticsDelegate(), Screen.EidServiceInfo, (Map) null, 2, (Object) null);
    }
}
