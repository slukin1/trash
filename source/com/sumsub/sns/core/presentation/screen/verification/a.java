package com.sumsub.sns.core.presentation.screen.verification;

import android.os.Bundle;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.o;
import androidx.lifecycle.q0;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import com.sumsub.sns.R;
import com.sumsub.sns.core.data.listener.SNSCountryPicker;
import com.sumsub.sns.core.presentation.base.a;
import com.sumsub.sns.core.widget.PhoneKit;
import com.sumsub.sns.core.widget.SNSFlaggedInputLayout;
import com.sumsub.sns.core.widget.SNSStepViewExtensionsKt;
import com.sumsub.sns.core.widget.SNSTextInputEditText;
import com.sumsub.sns.core.widget.autocompletePhone.PhoneKitProviderKt;
import com.sumsub.sns.core.widget.autocompletePhone.ValidationListener;
import com.sumsub.sns.core.widget.pincode.SNSPinView;
import com.sumsub.sns.internal.core.analytics.Control;
import com.sumsub.sns.internal.core.analytics.Screen;
import com.sumsub.sns.internal.core.common.a0;
import com.sumsub.sns.internal.core.common.e0;
import com.sumsub.sns.internal.core.common.q;
import com.sumsub.sns.internal.core.common.z;
import com.sumsub.sns.internal.core.data.model.DocumentType;
import com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel;
import com.sumsub.sns.internal.core.presentation.screen.verification.ValidationIdentifierType;
import com.sumsub.sns.internal.core.widget.SNSStepState;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

@Metadata(bv = {}, d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 K2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u0007B\u0007¢\u0006\u0004\bf\u0010gJ\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0004H\u0002J\u001a\u0010\u000b\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\fH\u0002J\u0010\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u0006H\u0002J\b\u0010\u000f\u001a\u00020\u0006H\u0002J\b\u0010\u0010\u001a\u00020\u0006H\u0002J\b\u0010\u0011\u001a\u00020\u0006H\u0002J\b\u0010\u0012\u001a\u00020\u0006H\u0002J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0002J\b\u0010\u0014\u001a\u00020\u0013H\u0014J\u0010\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0016\u001a\u00020\u0015H\u0014J\u0010\u0010\u001b\u001a\u00020\u001a2\u0006\u0010\u0019\u001a\u00020\u0018H\u0016J\u001a\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u00022\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0014J\b\u0010\u001c\u001a\u00020\u0006H\u0016J\u0010\u0010\u001e\u001a\u00020\u00062\u0006\u0010\u001d\u001a\u00020\tH\u0016R\u001d\u0010#\u001a\u0004\u0018\u00010\u001f8BX\u0002¢\u0006\f\n\u0004\b\u0007\u0010 \u001a\u0004\b!\u0010\"R\u001d\u0010%\u001a\u0004\u0018\u00010\u001f8BX\u0002¢\u0006\f\n\u0004\b\u000b\u0010 \u001a\u0004\b$\u0010\"R\u001d\u0010*\u001a\u0004\u0018\u00010&8FX\u0002¢\u0006\f\n\u0004\b'\u0010 \u001a\u0004\b(\u0010)R\u001d\u0010/\u001a\u0004\u0018\u00010+8FX\u0002¢\u0006\f\n\u0004\b,\u0010 \u001a\u0004\b-\u0010.R\u001d\u00104\u001a\u0004\u0018\u0001008FX\u0002¢\u0006\f\n\u0004\b1\u0010 \u001a\u0004\b2\u00103R\u001d\u00109\u001a\u0004\u0018\u0001058BX\u0002¢\u0006\f\n\u0004\b6\u0010 \u001a\u0004\b7\u00108R\u001d\u0010>\u001a\u0004\u0018\u00010:8FX\u0002¢\u0006\f\n\u0004\b;\u0010 \u001a\u0004\b<\u0010=R\u001d\u0010A\u001a\u0004\u0018\u00010\u001f8BX\u0002¢\u0006\f\n\u0004\b?\u0010 \u001a\u0004\b@\u0010\"R\u001d\u0010F\u001a\u0004\u0018\u00010B8BX\u0002¢\u0006\f\n\u0004\bC\u0010 \u001a\u0004\bD\u0010ER\u001d\u0010I\u001a\u0004\u0018\u00010\u001f8BX\u0002¢\u0006\f\n\u0004\bG\u0010 \u001a\u0004\bH\u0010\"R\u001d\u0010M\u001a\u0004\u0018\u00010J8FX\u0002¢\u0006\f\n\u0004\b\u0012\u0010 \u001a\u0004\bK\u0010LR\u001d\u0010O\u001a\u0004\u0018\u00010\u001f8BX\u0002¢\u0006\f\n\u0004\b\u000e\u0010 \u001a\u0004\bN\u0010\"R\u0018\u0010R\u001a\u0004\u0018\u00010P8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u0011\u0010QR\u001b\u0010V\u001a\u00020\u00038TX\u0002¢\u0006\f\n\u0004\b\u0010\u0010S\u001a\u0004\bT\u0010UR\u0018\u0010Y\u001a\u0004\u0018\u00010W8\u0002@\u0002X\u000e¢\u0006\u0006\n\u0004\b\u000f\u0010XR\u0014\u0010]\u001a\u00020Z8BX\u0004¢\u0006\u0006\u001a\u0004\b[\u0010\\R\u0014\u0010a\u001a\u00020^8VX\u0004¢\u0006\u0006\u001a\u0004\b_\u0010`R\u0014\u0010e\u001a\u00020b8TX\u0004¢\u0006\u0006\u001a\u0004\bc\u0010d¨\u0006h"}, d2 = {"Lcom/sumsub/sns/core/presentation/screen/verification/a;", "Lcom/sumsub/sns/core/presentation/b;", "Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$e;", "Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel;", "Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$e$d;", "state", "", "a", "Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$e$e;", "Landroid/os/Bundle;", "savedInstanceState", "b", "Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$e$c;", "Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel$e$b;", "l", "o", "n", "m", "k", "", "getLayoutId", "Lcom/sumsub/sns/core/presentation/base/a$j;", "event", "handleEvent", "Lcom/sumsub/sns/internal/core/common/q;", "finishReason", "", "onFinishCalled", "onDestroyView", "outState", "onSaveInstanceState", "Landroid/widget/TextView;", "Lcom/sumsub/sns/internal/core/common/z;", "A", "()Landroid/widget/TextView;", "tvTitle", "z", "tvSubtitle", "Lcom/google/android/material/textfield/TextInputLayout;", "c", "v", "()Lcom/google/android/material/textfield/TextInputLayout;", "tlEmail", "Lcom/google/android/material/textfield/TextInputEditText;", "d", "q", "()Lcom/google/android/material/textfield/TextInputEditText;", "etEmailId", "Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "e", "w", "()Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", "tlPhone", "Lcom/sumsub/sns/core/widget/SNSTextInputEditText;", "f", "r", "()Lcom/sumsub/sns/core/widget/SNSTextInputEditText;", "etPhone", "Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", "g", "u", "()Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", "pinCode", "h", "x", "tvResendCode", "Landroid/widget/ImageView;", "i", "s", "()Landroid/widget/ImageView;", "ivIcon", "j", "y", "tvStatus", "Landroid/widget/Button;", "p", "()Landroid/widget/Button;", "btnPrimary", "t", "otpErrorText", "Landroid/text/TextWatcher;", "Landroid/text/TextWatcher;", "emailTextWatcher", "Lkotlin/i;", "C", "()Lcom/sumsub/sns/internal/core/presentation/screen/verification/SNSVerificationStepViewModel;", "viewModel", "Lcom/sumsub/sns/core/widget/PhoneKit;", "Lcom/sumsub/sns/core/widget/PhoneKit;", "phoneNumberKit", "Lcom/sumsub/sns/internal/core/presentation/screen/verification/ValidationIdentifierType;", "B", "()Lcom/sumsub/sns/internal/core/presentation/screen/verification/ValidationIdentifierType;", "type", "Lcom/sumsub/sns/internal/core/analytics/Screen;", "getScreen", "()Lcom/sumsub/sns/internal/core/analytics/Screen;", "screen", "", "getIdDocSetType", "()Ljava/lang/String;", "idDocSetType", "<init>", "()V", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public final class a extends com.sumsub.sns.core.presentation.b<SNSVerificationStepViewModel.e, SNSVerificationStepViewModel> {

    /* renamed from: p  reason: collision with root package name */
    public static final C0296a f31123p = new C0296a((r) null);

    /* renamed from: q  reason: collision with root package name */
    public static final /* synthetic */ kotlin.reflect.l<Object>[] f31124q = {Reflection.j(new PropertyReference1Impl(a.class, "tvTitle", "getTvTitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvSubtitle", "getTvSubtitle()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tlEmail", "getTlEmail()Lcom/google/android/material/textfield/TextInputLayout;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "etEmailId", "getEtEmailId()Lcom/google/android/material/textfield/TextInputEditText;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tlPhone", "getTlPhone()Lcom/sumsub/sns/core/widget/SNSFlaggedInputLayout;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "etPhone", "getEtPhone()Lcom/sumsub/sns/core/widget/SNSTextInputEditText;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "pinCode", "getPinCode()Lcom/sumsub/sns/core/widget/pincode/SNSPinView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvResendCode", "getTvResendCode()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "ivIcon", "getIvIcon()Landroid/widget/ImageView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "tvStatus", "getTvStatus()Landroid/widget/TextView;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "btnPrimary", "getBtnPrimary()Landroid/widget/Button;", 0)), Reflection.j(new PropertyReference1Impl(a.class, "otpErrorText", "getOtpErrorText()Landroid/widget/TextView;", 0))};

    /* renamed from: r  reason: collision with root package name */
    public static final String f31125r = "SNSVerificationStepFragment";

    /* renamed from: s  reason: collision with root package name */
    public static final String f31126s = "ValidationIdentifier";

    /* renamed from: t  reason: collision with root package name */
    public static final int f31127t = 1;

    /* renamed from: u  reason: collision with root package name */
    public static final int f31128u = 2;

    /* renamed from: v  reason: collision with root package name */
    public static final int f31129v = 3;

    /* renamed from: w  reason: collision with root package name */
    public static final int f31130w = 4;

    /* renamed from: x  reason: collision with root package name */
    public static final int f31131x = 5;

    /* renamed from: y  reason: collision with root package name */
    public static final int f31132y = 6;

    /* renamed from: a  reason: collision with root package name */
    public final z f31133a = a0.a(this, R.id.sns_title);

    /* renamed from: b  reason: collision with root package name */
    public final z f31134b = a0.a(this, R.id.sns_subtitle);

    /* renamed from: c  reason: collision with root package name */
    public final z f31135c = a0.a(this, R.id.sns_email);

    /* renamed from: d  reason: collision with root package name */
    public final z f31136d = a0.a(this, R.id.sns_email_id);

    /* renamed from: e  reason: collision with root package name */
    public final z f31137e = a0.a(this, R.id.sns_phone);

    /* renamed from: f  reason: collision with root package name */
    public final z f31138f = a0.a(this, R.id.sns_phone_id);

    /* renamed from: g  reason: collision with root package name */
    public final z f31139g = a0.a(this, R.id.sns_pin_code);

    /* renamed from: h  reason: collision with root package name */
    public final z f31140h = a0.a(this, R.id.sns_resend_verification_code);

    /* renamed from: i  reason: collision with root package name */
    public final z f31141i = a0.a(this, R.id.sns_status_icon);

    /* renamed from: j  reason: collision with root package name */
    public final z f31142j = a0.a(this, R.id.sns_status_comment);

    /* renamed from: k  reason: collision with root package name */
    public final z f31143k = a0.a(this, R.id.sns_primary_button);

    /* renamed from: l  reason: collision with root package name */
    public final z f31144l = a0.a(this, R.id.sns_otp_error);

    /* renamed from: m  reason: collision with root package name */
    public TextWatcher f31145m;

    /* renamed from: n  reason: collision with root package name */
    public final kotlin.i f31146n;

    /* renamed from: o  reason: collision with root package name */
    public PhoneKit f31147o;

    /* renamed from: com.sumsub.sns.core.presentation.screen.verification.a$a  reason: collision with other inner class name */
    public static final class C0296a {
        public /* synthetic */ C0296a(r rVar) {
            this();
        }

        public final a a(ValidationIdentifierType validationIdentifierType) {
            a aVar = new a();
            Bundle bundle = new Bundle();
            bundle.putSerializable(a.f31126s, validationIdentifierType);
            aVar.setArguments(bundle);
            return aVar;
        }

        public C0296a() {
        }
    }

    public /* synthetic */ class b {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f31148a;

        static {
            int[] iArr = new int[ValidationIdentifierType.values().length];
            iArr[ValidationIdentifierType.EMAIL.ordinal()] = 1;
            iArr[ValidationIdentifierType.PHONE.ordinal()] = 2;
            iArr[ValidationIdentifierType.UNKNOWN.ordinal()] = 3;
            f31148a = iArr;
        }
    }

    public static final class c implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ TextView f31149a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ a f31150b;

        public c(TextView textView, a aVar) {
            this.f31149a = textView;
            this.f31150b = aVar;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            this.f31150b.getViewModel().p();
            this.f31149a.removeTextChangedListener(this);
        }
    }

    public static final class d implements ValidationListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31151a;

        public d(a aVar) {
            this.f31151a = aVar;
        }

        public void onValidate(boolean z11, boolean z12) {
            Button p11 = this.f31151a.p();
            if (p11 != null) {
                p11.setEnabled(z11);
            }
            SNSFlaggedInputLayout w11 = this.f31151a.w();
            if (w11 != null) {
                w11.setError((CharSequence) null);
            }
        }
    }

    public static final class e implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31152a;

        public e(a aVar) {
            this.f31152a = aVar;
        }

        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
        }

        public void onTextChanged(CharSequence charSequence, int i11, int i12, int i13) {
            boolean z11 = false;
            if (charSequence != null && (StringsKt__StringsJVMKt.z(charSequence) ^ true)) {
                this.f31152a.getViewModel().p();
            }
            Button p11 = this.f31152a.p();
            if (p11 != null) {
                TextInputEditText q11 = this.f31152a.q();
                Editable text = q11 != null ? q11.getText() : null;
                if (text == null || StringsKt__StringsJVMKt.z(text)) {
                    z11 = true;
                }
                p11.setEnabled(!z11);
            }
        }
    }

    public static final class f implements SNSPinView.OnTextCompleteListener {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31153a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ SNSVerificationStepViewModel.e.c f31154b;

        public f(a aVar, SNSVerificationStepViewModel.e.c cVar) {
            this.f31153a = aVar;
            this.f31154b = cVar;
        }

        public boolean onTextComplete(String str) {
            this.f31153a.getViewModel().a(this.f31154b.m(), str);
            SNSPinView u11 = this.f31153a.u();
            if (u11 == null) {
                return true;
            }
            com.sumsub.sns.internal.core.common.i.b((View) u11);
            return true;
        }
    }

    public static final class g extends Lambda implements d10.a<Fragment> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31155a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public g(Fragment fragment) {
            super(0);
            this.f31155a = fragment;
        }

        /* renamed from: a */
        public final Fragment invoke() {
            return this.f31155a;
        }
    }

    public static final class h extends Lambda implements d10.a<q0> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31156a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public h(d10.a aVar) {
            super(0);
            this.f31156a = aVar;
        }

        /* renamed from: a */
        public final q0 invoke() {
            return (q0) this.f31156a.invoke();
        }
    }

    public static final class i extends Lambda implements d10.a<ViewModelStore> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f31157a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public i(kotlin.i iVar) {
            super(0);
            this.f31157a = iVar;
        }

        /* renamed from: a */
        public final ViewModelStore invoke() {
            return FragmentViewModelLazyKt.e(this.f31157a).getViewModelStore();
        }
    }

    public static final class j extends Lambda implements d10.a<CreationExtras> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ d10.a f31158a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f31159b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public j(d10.a aVar, kotlin.i iVar) {
            super(0);
            this.f31158a = aVar;
            this.f31159b = iVar;
        }

        /* renamed from: a */
        public final CreationExtras invoke() {
            CreationExtras creationExtras;
            d10.a aVar = this.f31158a;
            if (aVar != null && (creationExtras = (CreationExtras) aVar.invoke()) != null) {
                return creationExtras;
            }
            q0 b11 = FragmentViewModelLazyKt.e(this.f31159b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            if (oVar != null) {
                return oVar.getDefaultViewModelCreationExtras();
            }
            return CreationExtras.a.f10040b;
        }
    }

    public static final class k extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ Fragment f31160a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ kotlin.i f31161b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public k(Fragment fragment, kotlin.i iVar) {
            super(0);
            this.f31160a = fragment;
            this.f31161b = iVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            ViewModelProvider.Factory defaultViewModelProviderFactory;
            q0 b11 = FragmentViewModelLazyKt.e(this.f31161b);
            o oVar = b11 instanceof o ? (o) b11 : null;
            return (oVar == null || (defaultViewModelProviderFactory = oVar.getDefaultViewModelProviderFactory()) == null) ? this.f31160a.getDefaultViewModelProviderFactory() : defaultViewModelProviderFactory;
        }
    }

    public static final class l extends Lambda implements d10.a<ViewModelProvider.Factory> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ a f31162a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public l(a aVar) {
            super(0);
            this.f31162a = aVar;
        }

        /* renamed from: a */
        public final ViewModelProvider.Factory invoke() {
            a aVar = this.f31162a;
            return new SNSVerificationStepViewModel.d(aVar, aVar.B(), this.f31162a.getServiceLocator(), this.f31162a.getArguments());
        }
    }

    public a() {
        l lVar = new l(this);
        kotlin.i b11 = LazyKt__LazyJVMKt.b(LazyThreadSafetyMode.NONE, new h(new g(this)));
        this.f31146n = FragmentViewModelLazyKt.c(this, Reflection.b(SNSVerificationStepViewModel.class), new i(b11), new j((d10.a) null, b11), lVar);
    }

    @SensorsDataInstrumented
    public static final void c(a aVar, View view) {
        Button p11 = aVar.p();
        if (p11 != null) {
            p11.setEnabled(false);
        }
        SNSVerificationStepViewModel C = aVar.getViewModel();
        SNSTextInputEditText r11 = aVar.r();
        C.b(String.valueOf(r11 != null ? r11.getRawText() : null));
        SNSTextInputEditText r12 = aVar.r();
        if (r12 != null) {
            com.sumsub.sns.internal.core.common.i.b((View) r12);
        }
        aVar.o();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final TextView A() {
        return (TextView) this.f31133a.a(this, f31124q[0]);
    }

    public final ValidationIdentifierType B() {
        Bundle arguments = getArguments();
        ValidationIdentifierType validationIdentifierType = null;
        Object obj = arguments != null ? arguments.get(f31126s) : null;
        if (obj instanceof ValidationIdentifierType) {
            validationIdentifierType = (ValidationIdentifierType) obj;
        }
        return validationIdentifierType == null ? ValidationIdentifierType.UNKNOWN : validationIdentifierType;
    }

    /* renamed from: C */
    public SNSVerificationStepViewModel getViewModel() {
        return (SNSVerificationStepViewModel) this.f31146n.getValue();
    }

    public String getIdDocSetType() {
        int i11 = b.f31148a[B().ordinal()];
        if (i11 == 1) {
            return DocumentType.f32352g;
        }
        if (i11 == 2) {
            return DocumentType.f32353h;
        }
        if (i11 == 3) {
            return DocumentType.f32355j;
        }
        throw new NoWhenBranchMatchedException();
    }

    public int getLayoutId() {
        return R.layout.sns_fragment_verification_step;
    }

    public Screen getScreen() {
        return Screen.ConfirmationContactScreen;
    }

    public void handleEvent(a.j jVar) {
        if (jVar instanceof SNSVerificationStepViewModel.c.b) {
            SNSPinView u11 = u();
            if (u11 != null) {
                u11.setText((CharSequence) null);
            }
            SNSPinView u12 = u();
            if (u12 != null) {
                com.sumsub.sns.internal.core.common.i.g(u12);
            }
            SNSPinView u13 = u();
            if (u13 != null) {
                u13.addTextChangedListener(new c(u13, this));
            }
        } else if (jVar instanceof SNSVerificationStepViewModel.c.a) {
            l();
        } else {
            super.handleEvent(jVar);
        }
    }

    public final void k() {
        com.sumsub.sns.core.presentation.b.setResult$default(this, 5, (Bundle) null, 2, (Object) null);
    }

    public final void l() {
        if (isForResult()) {
            com.sumsub.sns.core.presentation.b.setResult$default(this, 1, (Bundle) null, 2, (Object) null);
            return;
        }
        com.sumsub.sns.core.presentation.b.finish$default(this, new q.b(false, 1, (r) null), (Object) null, (Long) null, 6, (Object) null);
    }

    public final void m() {
        com.sumsub.sns.core.presentation.b.setResult$default(this, 4, (Bundle) null, 2, (Object) null);
    }

    public final void n() {
        com.sumsub.sns.core.presentation.b.setResult$default(this, 3, (Bundle) null, 2, (Object) null);
    }

    public final void o() {
        com.sumsub.sns.core.presentation.b.setResult$default(this, 2, (Bundle) null, 2, (Object) null);
    }

    public void onDestroyView() {
        super.onDestroyView();
        PhoneKit phoneKit = this.f31147o;
        if (phoneKit != null) {
            phoneKit.detach(getContext());
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0019, code lost:
        if ((r0.getVisibility() == 0) == true) goto L_0x001d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onFinishCalled(com.sumsub.sns.internal.core.common.q r4) {
        /*
            r3 = this;
            com.sumsub.sns.internal.core.common.q$c r0 = com.sumsub.sns.internal.core.common.q.c.f32251b
            boolean r0 = kotlin.jvm.internal.x.b(r4, r0)
            if (r0 == 0) goto L_0x002a
            com.sumsub.sns.core.widget.pincode.SNSPinView r0 = r3.u()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x001c
            int r0 = r0.getVisibility()
            if (r0 != 0) goto L_0x0018
            r0 = r1
            goto L_0x0019
        L_0x0018:
            r0 = r2
        L_0x0019:
            if (r0 != r1) goto L_0x001c
            goto L_0x001d
        L_0x001c:
            r1 = r2
        L_0x001d:
            if (r1 == 0) goto L_0x0027
            com.sumsub.sns.internal.core.presentation.screen.verification.SNSVerificationStepViewModel r4 = r3.getViewModel()
            r4.w()
            return r2
        L_0x0027:
            r3.k()
        L_0x002a:
            boolean r4 = super.onFinishCalled(r4)
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sumsub.sns.core.presentation.screen.verification.a.onFinishCalled(com.sumsub.sns.internal.core.common.q):boolean");
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        PhoneKit phoneKit = this.f31147o;
        if (phoneKit != null) {
            phoneKit.saveInstanceState(bundle);
        }
    }

    public final Button p() {
        return (Button) this.f31143k.a(this, f31124q[10]);
    }

    public final TextInputEditText q() {
        return (TextInputEditText) this.f31136d.a(this, f31124q[3]);
    }

    public final SNSTextInputEditText r() {
        return (SNSTextInputEditText) this.f31138f.a(this, f31124q[5]);
    }

    public final ImageView s() {
        return (ImageView) this.f31141i.a(this, f31124q[8]);
    }

    public final TextView t() {
        return (TextView) this.f31144l.a(this, f31124q[11]);
    }

    public final SNSPinView u() {
        return (SNSPinView) this.f31139g.a(this, f31124q[6]);
    }

    public final TextInputLayout v() {
        return (TextInputLayout) this.f31135c.a(this, f31124q[2]);
    }

    public final SNSFlaggedInputLayout w() {
        return (SNSFlaggedInputLayout) this.f31137e.a(this, f31124q[4]);
    }

    public final TextView x() {
        return (TextView) this.f31140h.a(this, f31124q[7]);
    }

    public final TextView y() {
        return (TextView) this.f31142j.a(this, f31124q[9]);
    }

    public final TextView z() {
        return (TextView) this.f31134b.a(this, f31124q[1]);
    }

    @SensorsDataInstrumented
    public static final void b(a aVar, View view) {
        Button p11 = aVar.p();
        if (p11 != null) {
            p11.setEnabled(false);
        }
        SNSVerificationStepViewModel C = aVar.getViewModel();
        TextInputEditText q11 = aVar.q();
        C.b(String.valueOf(q11 != null ? q11.getText() : null));
        TextInputEditText q12 = aVar.q();
        if (q12 != null) {
            com.sumsub.sns.internal.core.common.i.b((View) q12);
        }
        aVar.o();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* renamed from: a */
    public void handleState(SNSVerificationStepViewModel.e eVar, Bundle bundle) {
        if (eVar instanceof SNSVerificationStepViewModel.e.d) {
            a((SNSVerificationStepViewModel.e.d) eVar);
        } else if (eVar instanceof SNSVerificationStepViewModel.e.C0383e) {
            b((SNSVerificationStepViewModel.e.C0383e) eVar, bundle);
        } else if (eVar instanceof SNSVerificationStepViewModel.e.c) {
            a((SNSVerificationStepViewModel.e.c) eVar);
        } else if (eVar instanceof SNSVerificationStepViewModel.e.b) {
            a((SNSVerificationStepViewModel.e.b) eVar);
        }
    }

    public final void b(SNSVerificationStepViewModel.e.C0383e eVar, Bundle bundle) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "showValidatePhoneForm " + eVar, (Throwable) null, 4, (Object) null);
        com.sumsub.sns.internal.core.common.i.c(A(), z(), w(), r(), p());
        com.sumsub.sns.internal.core.common.i.a(v(), q(), u(), t(), x(), s(), y());
        TextView A = A();
        Spanned spanned = null;
        if (A != null) {
            CharSequence c11 = eVar.c();
            A.setText(c11 != null ? com.sumsub.sns.internal.core.common.i.a(c11, requireContext()) : null);
        }
        TextView z11 = z();
        if (z11 != null) {
            CharSequence b11 = eVar.b();
            if (b11 != null) {
                spanned = com.sumsub.sns.internal.core.common.i.a(b11, requireContext());
            }
            z11.setText(spanned);
        }
        TextInputLayout v11 = v();
        if (v11 != null) {
            v11.setVisibility(8);
        }
        SNSFlaggedInputLayout w11 = w();
        if (w11 != null) {
            w11.setError(eVar.k());
        }
        SNSTextInputEditText r11 = r();
        if (r11 != null) {
            r11.setOnEditorActionListener(new g(this));
        }
        Button p11 = p();
        if (p11 != null) {
            p11.setText(eVar.l());
        }
        Button p12 = p();
        if (p12 != null) {
            p12.setEnabled(true);
        }
        Button p13 = p();
        if (p13 != null) {
            p13.setOnClickListener(new d(this));
        }
        SNSTextInputEditText r12 = r();
        if (r12 != null) {
            com.sumsub.sns.internal.core.common.i.g(r12);
        }
        a(eVar, bundle);
    }

    public final void a(SNSVerificationStepViewModel.e.d dVar) {
        e eVar;
        TextInputEditText q11;
        com.sumsub.log.logger.a.d(com.sumsub.sns.internal.log.a.f34862a, com.sumsub.sns.internal.log.c.a(this), "showValidateEmailForm " + dVar, (Throwable) null, 4, (Object) null);
        boolean z11 = false;
        com.sumsub.sns.internal.core.common.i.c(A(), z(), v(), q(), p());
        com.sumsub.sns.internal.core.common.i.a(w(), r(), u(), t(), x(), s(), y());
        TextView A = A();
        Editable editable = null;
        if (A != null) {
            CharSequence c11 = dVar.c();
            A.setText(c11 != null ? com.sumsub.sns.internal.core.common.i.a(c11, requireContext()) : null);
        }
        TextView z12 = z();
        if (z12 != null) {
            CharSequence b11 = dVar.b();
            z12.setText(b11 != null ? com.sumsub.sns.internal.core.common.i.a(b11, requireContext()) : null);
        }
        TextInputLayout v11 = v();
        if (v11 != null) {
            v11.setError(dVar.j());
        }
        CharSequence a11 = dVar.a();
        if (a11 != null && (StringsKt__StringsJVMKt.z(a11) ^ true)) {
            TextInputEditText q12 = q();
            if (q12 != null) {
                q12.setText(dVar.a());
            }
            TextInputEditText q13 = q();
            if (q13 != null) {
                q13.setSelection(dVar.a().length());
            }
        }
        TextInputEditText q14 = q();
        if (q14 != null) {
            q14.setHint(dVar.k());
        }
        TextInputEditText q15 = q();
        if (q15 != null) {
            q15.setOnEditorActionListener(new f(this));
        }
        TextWatcher textWatcher = this.f31145m;
        if (!(textWatcher == null || (q11 = q()) == null)) {
            q11.removeTextChangedListener(textWatcher);
        }
        TextInputEditText q16 = q();
        if (q16 != null) {
            eVar = new e(this);
            q16.addTextChangedListener(eVar);
        } else {
            eVar = null;
        }
        this.f31145m = eVar;
        TextInputEditText q17 = q();
        if (q17 != null) {
            com.sumsub.sns.internal.core.common.i.g(q17);
        }
        Button p11 = p();
        if (p11 != null) {
            p11.setText(dVar.l());
        }
        Button p12 = p();
        if (p12 != null) {
            TextInputEditText q18 = q();
            if (q18 != null) {
                editable = q18.getText();
            }
            if (editable == null || StringsKt__StringsJVMKt.z(editable)) {
                z11 = true;
            }
            p12.setEnabled(!z11);
        }
        Button p13 = p();
        if (p13 != null) {
            p13.setOnClickListener(new c(this));
        }
    }

    public static final boolean b(a aVar, TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 6) {
            return false;
        }
        PhoneKit phoneKit = aVar.f31147o;
        if (phoneKit != null && phoneKit.isValid()) {
            Button p11 = aVar.p();
            if (p11 != null) {
                p11.setEnabled(false);
            }
            SNSVerificationStepViewModel C = aVar.getViewModel();
            SNSTextInputEditText r11 = aVar.r();
            C.b(String.valueOf(r11 != null ? r11.getRawText() : null));
            aVar.o();
        }
        com.sumsub.sns.internal.core.common.i.b((View) textView);
        return true;
    }

    public static final boolean a(a aVar, TextView textView, int i11, KeyEvent keyEvent) {
        if (i11 != 6) {
            return false;
        }
        Button p11 = aVar.p();
        if (p11 != null) {
            p11.setEnabled(false);
        }
        SNSVerificationStepViewModel C = aVar.getViewModel();
        TextInputEditText q11 = aVar.q();
        C.b(String.valueOf(q11 != null ? q11.getText() : null));
        com.sumsub.sns.internal.core.common.i.b((View) textView);
        aVar.o();
        return true;
    }

    public final void a(SNSVerificationStepViewModel.e.c cVar) {
        SNSPinView u11;
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "showVerifyCode " + cVar, (Throwable) null, 4, (Object) null);
        SNSPinView u12 = u();
        if (!(u12 != null && u12.getVisibility() == 0) && (u11 = u()) != null) {
            com.sumsub.sns.internal.core.common.i.g(u11);
        }
        com.sumsub.sns.internal.core.common.i.c(A(), z(), u(), t(), x());
        int i11 = 6;
        com.sumsub.sns.internal.core.common.i.a(v(), q(), w(), r(), s(), y(), p());
        TextView A = A();
        if (A != null) {
            CharSequence c11 = cVar.c();
            A.setText(c11 != null ? com.sumsub.sns.internal.core.common.i.a(c11, requireContext()) : null);
        }
        TextView z11 = z();
        if (z11 != null) {
            CharSequence b11 = cVar.b();
            z11.setText(b11 != null ? com.sumsub.sns.internal.core.common.i.a(b11, requireContext()) : null);
        }
        SNSPinView u13 = u();
        if (u13 != null) {
            Integer q11 = cVar.q();
            if (q11 != null) {
                i11 = q11.intValue();
            }
            u13.setItemCount(i11);
        }
        SNSPinView u14 = u();
        if (u14 != null) {
            u14.setOnTextCompleteListener(new f(this, cVar));
        }
        TextView t11 = t();
        if (t11 != null) {
            t11.setText(cVar.l());
        }
        SNSPinView u15 = u();
        if (u15 != null) {
            u15.setError(cVar.l() != null);
        }
        if (cVar.l() != null) {
            m();
        }
        if (cVar.p() != null) {
            TextView x11 = x();
            if (x11 != null) {
                x11.setEnabled(false);
            }
            TextView x12 = x();
            if (x12 != null) {
                x12.setText(cVar.p());
            }
            TextView x13 = x();
            if (x13 != null) {
                x13.setOnClickListener((View.OnClickListener) null);
            }
        } else if (cVar.o() != null) {
            TextView x14 = x();
            if (x14 != null) {
                x14.setEnabled(true);
            }
            TextView x15 = x();
            if (x15 != null) {
                x15.setText(cVar.o());
            }
            TextView x16 = x();
            if (x16 != null) {
                x16.setOnClickListener(new e(this, cVar));
            }
        }
        SNSPinView u16 = u();
        if (u16 != null) {
            u16.requestFocus();
        }
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, SNSVerificationStepViewModel.e.c cVar, View view) {
        com.sumsub.sns.internal.core.analytics.c.b(aVar.getAnalyticsDelegate(), Screen.ConfirmationCodeScreen, aVar.getIdDocSetType(), Control.RetryButton, (Map) null, 8, (Object) null);
        aVar.getViewModel().b(cVar.n());
        aVar.n();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void a(SNSVerificationStepViewModel.e.b bVar) {
        com.sumsub.sns.internal.log.a aVar = com.sumsub.sns.internal.log.a.f34862a;
        String a11 = com.sumsub.sns.internal.log.c.a(this);
        com.sumsub.log.logger.a.d(aVar, a11, "showStatus " + bVar, (Throwable) null, 4, (Object) null);
        com.sumsub.sns.internal.core.common.i.c(s(), y());
        com.sumsub.sns.internal.core.common.i.a(A(), z(), v(), q(), w(), r(), u(), t(), x(), p());
        if (bVar.f()) {
            m();
        }
        ImageView s11 = s();
        if (s11 != null) {
            SNSStepViewExtensionsKt.setSnsStepState(s11, bVar.f() ? SNSStepState.REJECTED : SNSStepState.APPROVED);
        }
        ImageView s12 = s();
        if (s12 != null) {
            s12.setImageDrawable(e0.f32018a.getIconHandler().onResolveIcon(requireContext(), bVar.d()));
        }
        TextView y11 = y();
        if (y11 != null) {
            y11.setText(bVar.c());
        }
        if (bVar.e() != null) {
            Button p11 = p();
            if (p11 != null) {
                p11.setVisibility(0);
            }
            Button p12 = p();
            if (p12 != null) {
                p12.setText(bVar.e());
            }
            Button p13 = p();
            if (p13 != null) {
                p13.setVisibility(0);
            }
            Button p14 = p();
            if (p14 != null) {
                p14.setEnabled(true);
            }
            Button p15 = p();
            if (p15 != null) {
                p15.setOnClickListener(new b(this));
            }
        }
    }

    @SensorsDataInstrumented
    public static final void a(a aVar, View view) {
        aVar.getViewModel().w();
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public final void a(SNSVerificationStepViewModel.e.C0383e eVar, Bundle bundle) {
        T t11;
        if (this.f31147o == null) {
            this.f31147o = PhoneKitProviderKt.getPhoneKit(w(), eVar.j().g(), eVar.j().k(), new d(this), eVar.a());
            SNSFlaggedInputLayout w11 = w();
            if (w11 != null) {
                SNSCountryPicker.CountryItem.Companion companion = SNSCountryPicker.CountryItem.Companion;
                Map<String, String> h11 = eVar.j().h();
                if (h11 == null) {
                    h11 = MapsKt__MapsKt.h();
                }
                List<SNSCountryPicker.CountryItem> fromMap = companion.fromMap(h11);
                Iterator<T> it2 = fromMap.iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        t11 = null;
                        break;
                    }
                    t11 = it2.next();
                    if (x.b(((SNSCountryPicker.CountryItem) t11).getCode(), eVar.j().i())) {
                        break;
                    }
                }
                SNSCountryPicker.CountryItem countryItem = (SNSCountryPicker.CountryItem) t11;
                PhoneKit phoneKit = this.f31147o;
                if (phoneKit != null) {
                    phoneKit.attachToInput(w11, fromMap, countryItem, bundle);
                }
            }
        }
    }
}
