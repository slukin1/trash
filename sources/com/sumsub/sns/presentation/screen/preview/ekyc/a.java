package com.sumsub.sns.presentation.screen.preview.ekyc;

import android.annotation.SuppressLint;
import android.net.Uri;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentTransaction;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSIconHandler;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.SNSBottomSheetView;
import com.sumsub.sns.core.widget.SNSErrorBottomSheetView;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.core.widget.SNSTextButton;
import com.sumsub.sns.core.widget.SNSToolbarView;
import com.sumsub.sns.core.widget.pincode.SNSPinView;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.GlobalStatePayload;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.Document;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.data.source.applicant.remote.s;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import com.sumsub.sns.internal.presentation.screen.preview.ekyc.b;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.reflect.l;

@Metadata(bv = {}, d1 = {"\u0000à\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\u0018\u0000 ^2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u00012\u00020\u0004:\u0001\fB\t¢\u0006\u0006\b\u0001\u0010\u0001J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0005H\u0003J\u001a\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\u0002H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\rH\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0005H\u0002J\u0010\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u000eH\u0002J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\b\u0010\u0010\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0011H\u0014J\u001a\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0014\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0016J\b\u0010\u0018\u001a\u00020\u0007H\u0016J\u0012\u0010\u0019\u001a\u00020\u00072\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014J\u0010\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001aH\u0016J\u0010\u0010 \u001a\u00020\u00072\u0006\u0010\u001f\u001a\u00020\u001eH\u0014J$\u0010\f\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u00022\b\u0010\u000b\u001a\u0004\u0018\u00010\u00022\b\u0010\u0016\u001a\u0004\u0018\u00010\u0015H\u0014R\u001b\u0010$\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\f\u0010!\u001a\u0004\b\"\u0010#R\u001d\u0010)\u001a\u0004\u0018\u00010%8BX\u0002¢\u0006\f\n\u0004\b\b\u0010&\u001a\u0004\b'\u0010(R\u001d\u0010,\u001a\u0004\u0018\u00010%8BX\u0002¢\u0006\f\n\u0004\b*\u0010&\u001a\u0004\b+\u0010(R\u001d\u00101\u001a\u0004\u0018\u00010-8BX\u0002¢\u0006\f\n\u0004\b.\u0010&\u001a\u0004\b/\u00100R\u001d\u00104\u001a\u0004\u0018\u00010-8BX\u0002¢\u0006\f\n\u0004\b2\u0010&\u001a\u0004\b3\u00100R\u001d\u00109\u001a\u0004\u0018\u0001058BX\u0002¢\u0006\f\n\u0004\b6\u0010&\u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u0004\u0018\u00010:8BX\u0002¢\u0006\f\n\u0004\b;\u0010&\u001a\u0004\b<\u0010=R\u001d\u0010A\u001a\u0004\u0018\u00010-8BX\u0002¢\u0006\f\n\u0004\b?\u0010&\u001a\u0004\b@\u00100R\u001d\u0010F\u001a\u0004\u0018\u00010B8BX\u0002¢\u0006\f\n\u0004\bC\u0010&\u001a\u0004\bD\u0010ER\u001d\u0010K\u001a\u0004\u0018\u00010G8BX\u0002¢\u0006\f\n\u0004\bH\u0010&\u001a\u0004\bI\u0010JR\u001d\u0010P\u001a\u0004\u0018\u00010L8BX\u0002¢\u0006\f\n\u0004\bM\u0010&\u001a\u0004\bN\u0010OR\u001d\u0010S\u001a\u0004\u0018\u00010Q8BX\u0002¢\u0006\f\n\u0004\bD\u0010&\u001a\u0004\bM\u0010RR\u001e\u0010V\u001a\n\u0012\u0004\u0012\u00020Q\u0018\u00010T8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b+\u0010UR\u001d\u0010Z\u001a\u0004\u0018\u00010W8BX\u0002¢\u0006\f\n\u0004\bI\u0010&\u001a\u0004\bX\u0010YR\u001d\u0010\\\u001a\u0004\u0018\u00010-8BX\u0002¢\u0006\f\n\u0004\b7\u0010&\u001a\u0004\b[\u00100R\u001d\u0010_\u001a\u0004\u0018\u00010-8BX\u0002¢\u0006\f\n\u0004\b]\u0010&\u001a\u0004\b^\u00100R\u0018\u0010b\u001a\u0004\u0018\u00010`8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\bX\u0010aR\u0018\u0010e\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b@\u0010dR\u0018\u0010f\u001a\u0004\u0018\u00010c8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b<\u0010dR\u0016\u0010i\u001a\u00020g8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b'\u0010hR\u0016\u0010l\u001a\u0004\u0018\u00010j8BX\u0004¢\u0006\u0006\u001a\u0004\b]\u0010kR \u0010q\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020n0m8BX\u0004¢\u0006\u0006\u001a\u0004\bo\u0010pR\u0018\u0010i\u001a\u00020g*\u00020\u00028BX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010rR\u0014\u0010u\u001a\u00020c8TX\u0004¢\u0006\u0006\u001a\u0004\bs\u0010tR\u0014\u0010x\u001a\u00020v8VX\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010wR \u0010z\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020n0m8VX\u0004¢\u0006\u0006\u001a\u0004\by\u0010pR \u0010|\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020n0m8VX\u0004¢\u0006\u0006\u001a\u0004\b{\u0010pR \u0010~\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020n0m8VX\u0004¢\u0006\u0006\u001a\u0004\b}\u0010pR!\u0010\u0001\u001a\u000e\u0012\u0004\u0012\u00020c\u0012\u0004\u0012\u00020n0m8VX\u0004¢\u0006\u0006\u001a\u0004\b\u0010p¨\u0006\u0001"}, d2 = {"Lcom/sumsub/sns/presentation/screen/preview/ekyc/a;", "Lcom/sumsub/sns/presentation/screen/preview/a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b$f;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b;", "Lcom/sumsub/sns/internal/core/presentation/form/a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b$f$d;", "viewState", "", "b", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b$f$e;", "state", "prevState", "a", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b$f$a;", "Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b$f$f;", "nextViewState", "A", "", "getLayoutId", "Landroid/view/View;", "view", "Landroid/os/Bundle;", "savedInstanceState", "onViewCreated", "onDestroyView", "onViewModelPrepared", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "Lkotlin/i;", "y", "()Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b;", "viewModel", "Landroid/widget/Button;", "Lcom/sumsub/sns/internal/core/common/z;", "t", "()Landroid/widget/Button;", "primaryButton", "c", "m", "btnSkip", "Landroid/widget/TextView;", "d", "x", "()Landroid/widget/TextView;", "tvTitle", "e", "w", "tvSubtitle", "Landroid/view/ViewGroup;", "f", "o", "()Landroid/view/ViewGroup;", "formContainer", "Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", "g", "s", "()Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", "pinField", "h", "r", "pinError", "Lcom/sumsub/sns/core/widget/SNSTextButton;", "i", "l", "()Lcom/sumsub/sns/core/widget/SNSTextButton;", "btnResendCode", "Lcom/sumsub/sns/core/widget/SNSErrorBottomSheetView;", "j", "n", "()Lcom/sumsub/sns/core/widget/SNSErrorBottomSheetView;", "errorBottomSheet", "Landroid/webkit/WebView;", "k", "z", "()Landroid/webkit/WebView;", "webView", "Lcom/sumsub/sns/core/widget/SNSBottomSheetView;", "()Lcom/sumsub/sns/core/widget/SNSBottomSheetView;", "bottomSheet", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "Lcom/google/android/material/bottomsheet/BottomSheetBehavior;", "bottomSheetBehavior", "Landroid/widget/ImageView;", "q", "()Landroid/widget/ImageView;", "ivIcon", "v", "tvStatusTitle", "p", "u", "tvStatusComment", "Lcom/sumsub/sns/internal/domain/c;", "Lcom/sumsub/sns/internal/domain/c;", "resources", "", "Ljava/lang/String;", "analyticsCountry", "analyticsSourceId", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "analyticsScreen", "Lcom/sumsub/sns/core/presentation/form/d;", "()Lcom/sumsub/sns/core/presentation/form/d;", "formFragment", "", "", "getCommonPayload", "()Ljava/util/Map;", "commonPayload", "(Lcom/sumsub/sns/internal/presentation/screen/preview/ekyc/b$f;)Lcom/sumsub/sns/internal/core/analytics/Screen;", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "Lcom/sumsub/sns/internal/core/presentation/form/b;", "()Lcom/sumsub/sns/internal/core/presentation/form/b;", "hostViewModel", "getOpenPayload", "openPayload", "getAppearPayload", "appearPayload", "getCancelPayload", "cancelPayload", "getClosePayload", "closePayload", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.presentation.screen.preview.a<b.f, com.sumsub.sns.internal.presentation.screen.preview.ekyc.b> implements com.sumsub.sns.internal.core.presentation.form.a {

    /* renamed from: u  reason: collision with root package name */
    public static final C0532a f39836u = new C0532a((r) null);

    /* renamed from: v  reason: collision with root package name */
    public static final /* synthetic */ l<Object>[] f39837v = {Reflection.j(new PropertyReference1Impl(a.class, "primaryButton", "getPrimaryButton()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "btnSkip", "getBtnSkip()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvSubtitle", "getTvSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "formContainer", "getFormContainer()Landroid/view/ViewGroup;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "pinField", "getPinField()Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "pinError", "getPinError()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "btnResendCode", "getBtnResendCode()Lcom/sumsub/sns/core/widget/SNSTextButton;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "errorBottomSheet", "getErrorBottomSheet()Lcom/sumsub/sns/core/widget/SNSErrorBottomSheetView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "webView", "getWebView()Landroid/webkit/WebView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "bottomSheet", "getBottomSheet()Lcom/sumsub/sns/core/widget/SNSBottomSheetView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "ivIcon", "getIvIcon()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvStatusTitle", "getTvStatusTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvStatusComment", "getTvStatusComment()Landroid/widget/TextView;", 0))};

    /* renamed from: w  reason: collision with root package name */
    public static final String f39838w = "eid_request_key";

    /* renamed from: x  reason: collision with root package name */
    public static final String f39839x = "ARGS_DOCUMENT";

    /* renamed from: y  reason: collision with root package name */
    public static final String f39840y = "SNSEkycFragment";

    /* renamed from: a  reason: collision with root package name */
    public final kotlin.i f39841a;

    /* renamed from: b  reason: collision with root package name */
    public final z f39842b = a0.a(this, R.id.sns_primary_button);

    /* renamed from: c  reason: collision with root package name */
    public final z f39843c = a0.a(this, R.id.sns_secondary_button);

    /* renamed from: d  reason: collision with root package name */
    public final z f39844d = a0.a(this, R.id.sns_title);

    /* renamed from: e  reason: collision with root package name */
    public final z f39845e = a0.a(this, R.id.sns_subtitle);

    /* renamed from: f  reason: collision with root package name */
    public final z f39846f = a0.a(this, R.id.sns_form_container);

    /* renamed from: g  reason: collision with root package name */
    public final z f39847g = a0.a(this, R.id.sns_pin_code);

    /* renamed from: h  reason: collision with root package name */
    public final z f39848h = a0.a(this, R.id.sns_pin_error);

    /* renamed from: i  reason: collision with root package name */
    public final z f39849i = a0.a(this, R.id.sns_resend_verification_code);

    /* renamed from: j  reason: collision with root package name */
    public final z f39850j = a0.a(this, R.id.sns_error_bottom_sheet);

    /* renamed from: k  reason: collision with root package name */
    public final z f39851k = a0.a(this, R.id.sns_webview);

    /* renamed from: l  reason: collision with root package name */
    public final z f39852l = a0.a(this, R.id.sns_web_view_bottom_sheet);

    /* renamed from: m  reason: collision with root package name */
    public BottomSheetBehavior<SNSBottomSheetView> f39853m;

    /* renamed from: n  reason: collision with root package name */
    public final z f39854n = a0.a(this, R.id.sns_status_icon);

    /* renamed from: o  reason: collision with root package name */
    public final z f39855o = a0.a(this, R.id.sns_status_title);

    /* renamed from: p  reason: collision with root package name */
    public final z f39856p = a0.a(this, R.id.sns_status_comment);

    /* renamed from: q  reason: collision with root package name */
    public com.sumsub.sns.internal.domain.c f39857q;

    /* renamed from: r  reason: collision with root package name */
    public String f39858r;

    /* renamed from: s  reason: collision with root package name */
    public String f39859s;

    /* renamed from: t  reason: collision with root package name */
    public Screen f39860t = Screen.Other;

    /* renamed from: com.sumsub.sns.presentation.screen.preview.ekyc.a$a  reason: collision with other inner class name */
    public static final class C0532a {
        public /* synthetic */ C0532a(r rVar) {
            this();
        }

        public final Fragment a(Document document) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putParcelable("ARGS_DOCUMENT", document);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0532a() {
        }
    }

    public static final class b implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39861a;

        public b(a aVar) {
            this.f39861a = aVar;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f39861a.getViewModel().a(charSequence);
            TextView b11 = this.f39861a.r();
            if (b11 != null) {
                b11.setText((CharSequence) null);
            }
            SNSPinView c11 = this.f39861a.s();
            if (c11 != null) {
                c11.setError(false);
            }
        }
    }

    public static final class c extends BottomSheetBehavior.BottomSheetCallback {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39862a;

        public c(a aVar) {
            this.f39862a = aVar;
        }

        public void onSlide(View view, float f11) {
            float f12 = 1.0f;
            if (f11 >= 0.7f) {
                f12 = RangesKt___RangesKt.i((1.0f - f11) - 0.05f, 0.0f, 1.0f);
            }
            FragmentActivity activity = this.f39862a.getActivity();
            View findViewById = activity != null ? activity.findViewById(R.id.sns_toolbar) : null;
            if (findViewById != null) {
                findViewById.setAlpha(f12);
            }
        }

        public void onStateChanged(View view, int i11) {
            View findViewById;
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            StringBuilder sb2 = new StringBuilder();
            sb2.append("webViewSheet hidden=");
            boolean z11 = true;
            sb2.append(i11 == 4);
            com.sumsub.log.logger.a.d(aVar, com.sumsub.sns.internal.presentation.screen.preview.ekyc.a.f35376b, sb2.toString(), (Throwable) null, 4, (Object) null);
            FragmentActivity activity = this.f39862a.getActivity();
            if (activity != null && (findViewById = activity.findViewById(R.id.sns_toolbar)) != null) {
                if (i11 != 4) {
                    z11 = false;
                }
                com.sumsub.sns.internal.core.common.i.b(findViewById, z11);
            }
        }
    }

    public static final class d implements SNSPinView.OnTextCompleteListener {
        public boolean onTextComplete(String str) {
            return true;
        }
    }

    public static final class e extends WebViewClient {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39863a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ b.f.d f39864b;

        public e(a aVar, b.f.d dVar) {
            this.f39863a = aVar;
            this.f39864b = dVar;
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            BottomSheetBehavior a11 = this.f39863a.f39853m;
            if (!(a11 != null && a11.getState() == 3)) {
                return false;
            }
            Uri url = webResourceRequest != null ? webResourceRequest.getUrl() : null;
            if (url == null) {
                return false;
            }
            return this.f39863a.getViewModel().a(url, this.f39864b.c());
        }
    }

    public static final class f extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39865a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public f(Fragment fragment) {
            super(0);
            this.f39865a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f39865a;
        }
    }

    public static final class g extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39866a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(d10.a aVar) {
            super(0);
            this.f39866a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f39866a.invoke();
        }
    }

    public static final class h extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39867a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(kotlin.i iVar) {
            super(0);
            this.f39867a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f39867a).getViewModelStore();
        }
    }

    public static final class i extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f39868a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39869b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f39868a = aVar;
            this.f39869b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f39868a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f39869b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class j extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f39870a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f39871b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f39870a = fragment;
            this.f39871b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f39871b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f39870a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class k extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f39872a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(a aVar) {
            super(0);
            this.f39872a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            Bundle arguments = this.f39872a.getArguments();
            Document document = arguments != null ? (Document) androidx.core.os.d.b(arguments, "ARGS_DOCUMENT", Document.class) : null;
            a aVar = this.f39872a;
            return new b.e(document, aVar, aVar.getServiceLocator(), this.f39872a.getArguments());
        }
    }

    public a() {
        k kVar = new k(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new g(new f(this)));
        this.f39841a = FragmentViewModelLazyKt.c(this, Reflection.b(com.sumsub.sns.internal.presentation.screen.preview.ekyc.b.class), new h(b11), new i((d10.a) null, b11), kVar);
    }

    public static final void e(a aVar, View view) {
        aVar.getAnalyticsDelegate().b(aVar.f39860t, aVar.getIdDocSetType(), Control.SkipButton, aVar.getCommonPayload());
        aVar.getViewModel().M();
    }

    public final void A() {
        getViewModel().J();
    }

    public Map<String, Object> getAppearPayload() {
        return getCommonPayload();
    }

    public Map<String, Object> getCancelPayload() {
        return getCommonPayload();
    }

    public Map<String, Object> getClosePayload() {
        return getCommonPayload();
    }

    public final Map<String, Object> getCommonPayload() {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        String str = this.f39858r;
        if (str != null) {
            linkedHashMap.put(GlobalStatePayload.Country.getText(), str);
        }
        String str2 = this.f39859s;
        if (str2 != null) {
            linkedHashMap.put("sourceId", str2);
        }
        if (this.f39860t == Screen.EkycFinishScreen) {
            linkedHashMap.put("result", LoginLogger.EVENT_EXTRAS_FAILURE);
        }
        return linkedHashMap;
    }

    public String getIdDocSetType() {
        DocumentType type;
        String c11;
        Bundle arguments = getArguments();
        Document document = arguments != null ? (Document) androidx.core.os.d.b(arguments, "ARGS_DOCUMENT", Document.class) : null;
        return (document == null || (type = document.getType()) == null || (c11 = type.c()) == null) ? DocumentType.f32355j : c11;
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_ekyc;
    }

    public Map<String, Object> getOpenPayload() {
        return getCommonPayload();
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof b.d) {
            SNSErrorBottomSheetView n11 = n();
            if (n11 != null) {
                b.d dVar = (b.d) jVar;
                SNSErrorBottomSheetView.show$default(n11, dVar.d(), (CharSequence) null, dVar.c(), (d10.a) null, (d10.a) null, 26, (Object) null);
            }
        } else if (jVar instanceof b.c) {
            b.c cVar = (b.c) jVar;
            navigateTo(com.sumsub.sns.presentation.screen.preview.ekyc.eid.a.f39877l.a(cVar.e(), cVar.f(), cVar.d()).forResult(f39838w), com.sumsub.sns.presentation.screen.preview.ekyc.eid.a.f39881p);
        } else {
            super.handleEvent(jVar);
        }
    }

    public final SNSBottomSheetView k() {
        return (SNSBottomSheetView) this.f39852l.a(this, f39837v[10]);
    }

    public final SNSTextButton l() {
        return (SNSTextButton) this.f39849i.a(this, f39837v[7]);
    }

    public final Button m() {
        return (Button) this.f39843c.a(this, f39837v[1]);
    }

    public final SNSErrorBottomSheetView n() {
        return (SNSErrorBottomSheetView) this.f39850j.a(this, f39837v[8]);
    }

    public final ViewGroup o() {
        return (ViewGroup) this.f39846f.a(this, f39837v[4]);
    }

    public void onDestroyView() {
        WebView z11 = z();
        if (z11 != null) {
            z11.destroy();
        }
        super.onDestroyView();
    }

    public boolean onFinishCalled(q qVar) {
        SNSPinView s11 = s();
        if (s11 != null) {
            com.sumsub.sns.internal.core.common.i.b((View) s11);
        }
        return getViewModel().A() && super.onFinishCalled(qVar);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        SNSBottomSheetView k11 = k();
        if (k11 != null) {
            BottomSheetBehavior<SNSBottomSheetView> from = BottomSheetBehavior.from(k11);
            from.setState(4);
            from.setHideable(false);
            from.setDraggable(false);
            from.setPeekHeight(0);
            from.setFitToContents(false);
            from.setExpandedOffset(0);
            from.addBottomSheetCallback(new c(this));
            from.setState(4);
            this.f39853m = from;
        }
        SNSBottomSheetView k12 = k();
        SNSToolbarView sNSToolbarView = k12 != null ? (SNSToolbarView) k12.findViewById(R.id.sns_bottomsheet_toolbar) : null;
        if (sNSToolbarView != null) {
            sNSToolbarView.setCloseButtonDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), SNSIconHandler.SNSCommonIcons.CLOSE.getImageName()));
        }
        if (sNSToolbarView != null) {
            sNSToolbarView.setOnCloseButtonClickListener(new e(this));
        }
        Button m11 = m();
        if (m11 != null) {
            m11.setOnClickListener(new f(this));
        }
        SNSPinView s11 = s();
        if (s11 != null) {
            s11.addTextChangedListener(new b(this));
        }
        SNSPinView s12 = s();
        if (s12 != null) {
            s12.setOnTextCompleteListener(new d());
        }
    }

    public void onViewModelPrepared(Bundle bundle) {
        super.onViewModelPrepared(bundle);
        requireActivity().getSupportFragmentManager().H1(f39838w, this, new g(this));
    }

    public final com.sumsub.sns.core.presentation.form.d p() {
        Fragment l02 = getChildFragmentManager().l0(R.id.sns_form_container);
        if (l02 instanceof com.sumsub.sns.core.presentation.form.d) {
            return (com.sumsub.sns.core.presentation.form.d) l02;
        }
        return null;
    }

    public final ImageView q() {
        return (ImageView) this.f39854n.a(this, f39837v[11]);
    }

    public final TextView r() {
        return (TextView) this.f39848h.a(this, f39837v[6]);
    }

    public final SNSPinView s() {
        return (SNSPinView) this.f39847g.a(this, f39837v[5]);
    }

    public final Button t() {
        return (Button) this.f39842b.a(this, f39837v[0]);
    }

    public final TextView u() {
        return (TextView) this.f39856p.a(this, f39837v[13]);
    }

    public final TextView v() {
        return (TextView) this.f39855o.a(this, f39837v[12]);
    }

    public final TextView w() {
        return (TextView) this.f39845e.a(this, f39837v[3]);
    }

    public final TextView x() {
        return (TextView) this.f39844d.a(this, f39837v[2]);
    }

    /* renamed from: y */
    public com.sumsub.sns.internal.presentation.screen.preview.ekyc.b getViewModel() {
        return (com.sumsub.sns.internal.presentation.screen.preview.ekyc.b) this.f39841a.getValue();
    }

    public final WebView z() {
        return (WebView) this.f39851k.a(this, f39837v[9]);
    }

    @SensorsDataInstrumented
    public static final void c(a aVar, View view) {
        aVar.getViewModel().K();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public static final void d(a aVar, View view) {
        aVar.getViewModel().H();
    }

    public com.sumsub.sns.internal.core.presentation.form.b a() {
        return getViewModel();
    }

    @SuppressLint({"SetJavaScriptEnabled"})
    public final void b(b.f.d dVar) {
        com.sumsub.sns.internal.core.common.i.c(k());
        View view = getView();
        if (view != null) {
            com.sumsub.sns.internal.core.common.i.b(view);
        }
        WebView z11 = z();
        if (z11 != null) {
            com.sumsub.sns.internal.core.common.i.b((View) z11, true);
        }
        WebView z12 = z();
        if (z12 != null) {
            z12.setWebViewClient(new e(this, dVar));
        }
        WebView z13 = z();
        WebSettings settings = z13 != null ? z13.getSettings() : null;
        if (settings != null) {
            settings.setJavaScriptEnabled(true);
        }
        String d11 = dVar.d();
        if (d11 != null) {
            WebView z14 = z();
            if (z14 != null) {
                z14.loadUrl(d11);
                SensorsDataAutoTrackHelper.loadUrl2(z14, d11);
            }
            WebView z15 = z();
            if (z15 != null) {
                z15.getUrl();
            }
        }
        BottomSheetBehavior<SNSBottomSheetView> bottomSheetBehavior = this.f39853m;
        if (bottomSheetBehavior != null) {
            bottomSheetBehavior.setState(3);
        }
    }

    public static final void a(a aVar, String str, Bundle bundle) {
        if (com.sumsub.sns.core.presentation.b.Companion.b(bundle)) {
            String string = bundle.getString(com.sumsub.sns.presentation.screen.preview.ekyc.eid.a.f39879n);
            if (string != null) {
                aVar.getViewModel().d(string);
                return;
            }
            aVar.getViewModel().I();
            com.sumsub.sns.internal.core.common.i.c(aVar.o());
            return;
        }
        aVar.getViewModel().I();
        com.sumsub.sns.internal.core.common.i.c(aVar.o());
    }

    /* renamed from: a */
    public void handleState(b.f fVar, b.f fVar2, Bundle bundle) {
        com.sumsub.sns.core.presentation.form.d p11;
        BottomSheetBehavior<SNSBottomSheetView> bottomSheetBehavior;
        b(fVar);
        boolean z11 = fVar instanceof b.f.d;
        if (!z11) {
            BottomSheetBehavior<SNSBottomSheetView> bottomSheetBehavior2 = this.f39853m;
            if ((bottomSheetBehavior2 != null && com.sumsub.sns.core.common.a.a(bottomSheetBehavior2)) && (bottomSheetBehavior = this.f39853m) != null) {
                bottomSheetBehavior.setState(4);
            }
        }
        boolean z12 = fVar instanceof b.f.a;
        if (!z12 && (p11 = p()) != null) {
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.s(p11);
            q11.l();
        }
        if (fVar instanceof b.f.c) {
            com.sumsub.sns.internal.core.common.i.a(t(), m(), x(), w(), r(), s(), l(), z(), q(), v(), u(), k());
            View view = getView();
            if (view != null) {
                com.sumsub.sns.internal.core.common.i.b(view);
            }
        } else if (z11) {
            a((b.f.d) fVar);
        } else if (z12) {
            a((b.f.a) fVar);
        } else if (fVar instanceof b.f.e) {
            a((b.f.e) fVar, fVar2);
        } else if (fVar instanceof b.f.C0433f) {
            a((b.f.C0433f) fVar);
        }
    }

    @SensorsDataInstrumented
    public static final void b(a aVar, View view) {
        aVar.getAnalyticsDelegate().b(aVar.f39860t, aVar.getIdDocSetType(), Control.RetryButton, aVar.getCommonPayload());
        aVar.A();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void b(b.f fVar) {
        Screen a11 = a(fVar);
        if (a11 != Screen.Other) {
            com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
            com.sumsub.log.logger.a.d(aVar, com.sumsub.sns.internal.presentation.screen.preview.ekyc.a.f35376b, "handleAnalyticsScreenChange: nextScreen=" + a11, (Throwable) null, 4, (Object) null);
            if (fVar instanceof b.f.a) {
                b.f.a aVar2 = (b.f.a) fVar;
                this.f39858r = aVar2.k();
                this.f39859s = aVar2.l();
                com.sumsub.log.logger.a.d(aVar, com.sumsub.sns.internal.presentation.screen.preview.ekyc.a.f35376b, "handleAnalyticsScreenChange: country=" + this.f39858r + ", sourceId=" + this.f39859s, (Throwable) null, 4, (Object) null);
            }
            if (a11 != this.f39860t) {
                getAnalyticsDelegate().c(this.f39860t, getIdDocSetType(), getCommonPayload());
                this.f39860t = a11;
                getAnalyticsDelegate().d(this.f39860t, getIdDocSetType(), getCommonPayload());
                getAnalyticsDelegate().a(this.f39860t, getIdDocSetType(), getCommonPayload());
            }
        }
    }

    public final void a(b.f.e eVar, b.f fVar) {
        s r11;
        Integer b11;
        com.sumsub.sns.internal.core.common.i.a(t(), m(), x(), w(), z(), q(), v(), u(), k());
        com.sumsub.sns.internal.core.common.i.c(r(), s());
        TextView x11 = x();
        if (x11 != null) {
            com.sumsub.sns.internal.core.common.i.a(x11, eVar.l());
        }
        TextView w11 = w();
        if (w11 != null) {
            com.sumsub.sns.internal.core.common.i.a(w11, eVar.k());
        }
        if (eVar.i() > 0) {
            SNSTextButton l11 = l();
            if (l11 != null) {
                l11.setEnabled(false);
            }
            SNSTextButton l12 = l();
            if (l12 != null) {
                l12.setOnClickListener((View.OnClickListener) null);
            }
        } else {
            SNSTextButton l13 = l();
            if (l13 != null) {
                l13.setEnabled(true);
            }
            SNSTextButton l14 = l();
            if (l14 != null) {
                l14.setOnClickListener(new c(this));
            }
        }
        SNSTextButton l15 = l();
        if (l15 != null) {
            com.sumsub.sns.internal.core.common.i.a((TextView) l15, eVar.g());
        }
        if (!(fVar instanceof b.f.e)) {
            SNSPinView s11 = s();
            if (s11 != null) {
                s11.setText((CharSequence) null);
            }
            TextView r12 = r();
            if (r12 != null) {
                r12.setText(eVar.h());
            }
            com.sumsub.sns.internal.core.data.source.applicant.remote.e0 j11 = eVar.j();
            if (!(j11 == null || (r11 = j11.r()) == null || (b11 = r11.b()) == null)) {
                int intValue = b11.intValue();
                SNSPinView s12 = s();
                if (s12 != null) {
                    s12.setItemCount(intValue);
                }
            }
            SNSPinView s13 = s();
            if (s13 != null) {
                com.sumsub.sns.internal.core.common.i.g(s13);
            }
        }
    }

    public final void a(b.f.a aVar) {
        this.f39857q = aVar.n();
        TextView x11 = x();
        if (x11 != null) {
            x11.setVisibility(8);
        }
        TextView w11 = w();
        if (w11 != null) {
            w11.setVisibility(8);
        }
        Button t11 = t();
        if (t11 != null) {
            com.sumsub.sns.internal.core.common.i.a((TextView) t11, aVar.i());
        }
        Button m11 = m();
        if (m11 != null) {
            com.sumsub.sns.internal.core.common.i.a((TextView) m11, aVar.j());
        }
        if (p() == null) {
            FragmentTransaction q11 = getChildFragmentManager().q();
            q11.t(R.id.sns_form_container, com.sumsub.sns.core.presentation.form.d.f30929p.a(com.sumsub.sns.internal.presentation.screen.preview.ekyc.a.f35376b));
            q11.l();
        }
        com.sumsub.sns.internal.core.common.i.c(o());
        com.sumsub.sns.internal.core.common.i.a(r(), s(), l(), z(), q(), v(), u(), k());
        Button t12 = t();
        if (t12 != null) {
            t12.setOnClickListener(new b(this));
        }
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, View view) {
        aVar.getAnalyticsDelegate().b(aVar.f39860t, aVar.getIdDocSetType(), Control.ContinueButton, aVar.getCommonPayload());
        aVar.A();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void a(b.f.d dVar) {
        com.sumsub.sns.internal.core.common.i.a(t(), m(), x(), w(), r(), s(), l(), q(), v(), u());
        View view = getView();
        if (view != null) {
            com.sumsub.sns.internal.core.common.i.b(view);
        }
        b(dVar);
    }

    public final void a(b.f.C0433f fVar) {
        com.sumsub.sns.internal.core.common.i.a(t(), m(), x(), w(), r(), s(), l(), k());
        View view = getView();
        if (view != null) {
            com.sumsub.sns.internal.core.common.i.b(view);
        }
        ImageView q11 = q();
        if (q11 != null) {
            com.sumsub.sns.internal.core.common.i.b((View) q11, true);
        }
        ImageView q12 = q();
        if (q12 != null) {
            SNSStepViewExtensionsKt.setSnsStepState(q12, fVar.e() ? SNSStepState.REJECTED : SNSStepState.APPROVED);
        }
        ImageView q13 = q();
        if (q13 != null) {
            q13.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), fVar.a()));
        }
        TextView v11 = v();
        if (v11 != null) {
            com.sumsub.sns.internal.core.common.i.a(v11, fVar.d());
        }
        TextView u11 = u();
        if (u11 != null) {
            com.sumsub.sns.internal.core.common.i.a(u11, fVar.c());
        }
        Button t11 = t();
        if (t11 != null) {
            com.sumsub.sns.internal.core.common.i.a((TextView) t11, fVar.b());
        }
        Button t12 = t();
        if (t12 != null) {
            t12.setEnabled(true);
        }
        Button t13 = t();
        if (t13 != null) {
            t13.setOnClickListener(new d(this));
        }
    }

    public final Screen a(b.f fVar) {
        boolean z11;
        if (fVar instanceof b.f.C0432b) {
            z11 = true;
        } else {
            z11 = fVar instanceof b.f.a;
        }
        if (z11) {
            return Screen.EkycFormScreen;
        }
        if (fVar instanceof b.f.e) {
            return Screen.EkycOtpConfirmationScreen;
        }
        if (fVar instanceof b.f.d) {
            return Screen.EkycOauthConfirmationScreen;
        }
        if (!(fVar instanceof b.f.C0433f)) {
            return Screen.Other;
        }
        Screen screen = ((b.f.C0433f) fVar).e() ? Screen.EkycFinishScreen : null;
        if (screen == null) {
            return Screen.Other;
        }
        return screen;
    }
}
