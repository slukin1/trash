package com.jumio.defaultui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.OnBackPressedDispatcher;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.z;
import com.google.android.material.button.MaterialButton;
import com.jumio.commons.log.Log;
import com.jumio.defaultui.R;
import com.jumio.defaultui.view.LoadingView;
import com.jumio.sdk.credentials.JumioDocumentCredential;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.handler.JumioConfirmationHandler;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioConfirmationView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.l;
import java.util.List;
import jumio.dui.b;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import zendesk.support.request.DocumentRenderer;

public final class ConfirmationFragment extends BaseFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion((r) null);
    private static String TAG = "ConfirmationFragment";
    private MaterialButton confirmButton;
    private JumioConfirmationHandler confirmationHandler = new JumioConfirmationHandler();
    private JumioConfirmationView confirmationView;
    private AppCompatTextView confirmationViewSubtitle;
    private AppCompatTextView description;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new ConfirmationFragment$special$$inlined$activityViewModels$default$1(this), new ConfirmationFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new ConfirmationFragment$special$$inlined$activityViewModels$default$3(this));
    private MaterialButton retakeButton;
    private final z<JumioScanStep> scanStepObserver = new pw.a(this);
    private AppCompatTextView title;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0021 */
        static {
            /*
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.sdk.enums.JumioScanStep r2 = com.jumio.sdk.enums.JumioScanStep.PROCESSING     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                $EnumSwitchMapping$0 = r0
                com.jumio.sdk.enums.JumioScanMode[] r0 = com.jumio.sdk.enums.JumioScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanMode r2 = com.jumio.sdk.enums.JumioScanMode.FILE     // Catch:{ NoSuchFieldError -> 0x0021 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0021 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0021 }
            L_0x0021:
                com.jumio.sdk.enums.JumioScanMode r1 = com.jumio.sdk.enums.JumioScanMode.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x002a }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.ConfirmationFragment.WhenMappings.<clinit>():void");
        }
    }

    public static final class a extends Lambda implements l<Integer, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ ConfirmationFragment f70823a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ConfirmationFragment confirmationFragment) {
            super(1);
            this.f70823a = confirmationFragment;
        }

        public final Object invoke(Object obj) {
            return this.f70823a.getString(((Number) obj).intValue());
        }
    }

    private final void faceConfirmationCustomization() {
        List n11 = CollectionsKt__CollectionsKt.n(Integer.valueOf(R.string.jumio_identity_confirm_paragraph_placing), Integer.valueOf(R.string.jumio_identity_confirm_paragraph_focusing));
        AppCompatTextView appCompatTextView = this.description;
        if (appCompatTextView != null) {
            appCompatTextView.setText(CollectionsKt___CollectionsKt.k0(n11, "\n" + DocumentRenderer.Style.Li.UNICODE_BULLET + " ", DocumentRenderer.Style.Li.UNICODE_BULLET + " ", (CharSequence) null, 0, (CharSequence) null, new a(this), 28, (Object) null));
            appCompatTextView.setGravity(8388611);
            JumioConfirmationView jumioConfirmationView = this.confirmationView;
            if (jumioConfirmationView != null) {
                jumioConfirmationView.setContentDescription(appCompatTextView.getText());
            }
        }
    }

    private final void fileConfirmationCustomization() {
        AppCompatTextView appCompatTextView = this.title;
        if (appCompatTextView != null) {
            appCompatTextView.setText(getString(R.string.jumio_dv_confirm_file_title));
        }
        MaterialButton materialButton = this.retakeButton;
        if (materialButton != null) {
            materialButton.setText(getString(R.string.jumio_dv_confirm_button_reselect));
        }
        AppCompatTextView appCompatTextView2 = this.confirmationViewSubtitle;
        String str = "";
        if (appCompatTextView2 != null) {
            String str2 = (String) getJumioViewModel().f56353a.f("selectedFilePath");
            if (str2 == null) {
                str2 = str;
            }
            appCompatTextView2.setText(str2);
        }
        AppCompatTextView appCompatTextView3 = this.confirmationViewSubtitle;
        if (appCompatTextView3 != null) {
            String str3 = (String) getJumioViewModel().f56353a.f("selectedFilePath");
            if (str3 != null) {
                str = str3;
            }
            int i11 = 0;
            if (!(str.length() > 0)) {
                i11 = 8;
            }
            appCompatTextView3.setVisibility(i11);
        }
        AppCompatTextView appCompatTextView4 = this.description;
        if (appCompatTextView4 != null) {
            appCompatTextView4.setText(getString(R.string.jumio_dv_confirm_file_info));
        }
        JumioConfirmationView jumioConfirmationView = this.confirmationView;
        if (jumioConfirmationView != null) {
            AppCompatTextView appCompatTextView5 = this.description;
            jumioConfirmationView.setContentDescription(appCompatTextView5 != null ? appCompatTextView5.getText() : null);
        }
    }

    /* access modifiers changed from: private */
    public final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    private final void initObservers() {
        getJumioViewModel().f56362j.observe(getViewLifecycleOwner(), this.scanStepObserver);
    }

    /* access modifiers changed from: private */
    public final void retakeImage() {
        this.confirmationHandler.retake();
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.retakeImage();
        }
    }

    /* access modifiers changed from: private */
    public static final void scanStepObserver$lambda$0(ConfirmationFragment confirmationFragment, JumioScanStep jumioScanStep) {
        int i11;
        JumioFragmentCallback callback;
        String str = TAG;
        String name = jumioScanStep != null ? jumioScanStep.name() : null;
        Log.i(str, "Event " + name + " received");
        if (jumioScanStep == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[jumioScanStep.ordinal()];
        }
        if (i11 == 1 && (confirmationFragment.getJumioViewModel().d() instanceof JumioDocumentCredential) && (callback = confirmationFragment.getCallback()) != null) {
            callback.updateLoadingState(new LoadingView.State(LoadingView.ViewState.PROGRESS, confirmationFragment.getString(R.string.jumio_uploading_title), (String) null, 0, (View.OnClickListener) null, 28, (r) null));
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_confirmation, viewGroup, false);
        this.confirmationView = (JumioConfirmationView) inflate.findViewById(R.id.confirmationView);
        this.confirmationViewSubtitle = (AppCompatTextView) inflate.findViewById(R.id.confirmationViewSubtitle);
        this.confirmButton = (MaterialButton) inflate.findViewById(R.id.confirmationPositiveButton);
        MaterialButton materialButton = (MaterialButton) inflate.findViewById(R.id.confirmationNegativeButton);
        this.retakeButton = materialButton;
        for (MaterialButton materialButton2 : CollectionsKt__CollectionsKt.n(this.confirmButton, materialButton)) {
            if (materialButton2 != null) {
                materialButton2.setOnClickListener(this);
            }
        }
        this.title = (AppCompatTextView) inflate.findViewById(R.id.confirmationTitle);
        this.description = (AppCompatTextView) inflate.findViewById(R.id.confirmationDescription);
        MaterialButton materialButton3 = this.confirmButton;
        if (materialButton3 != null) {
            materialButton3.setVisibility(0);
        }
        MaterialButton materialButton4 = this.retakeButton;
        if (materialButton4 != null) {
            materialButton4.setVisibility(0);
        }
        AppCompatTextView appCompatTextView = this.title;
        JumioScanMode jumioScanMode = null;
        if (appCompatTextView != null) {
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R.string.jumio_id_confirm_title) : null);
        }
        JumioConfirmationView jumioConfirmationView = this.confirmationView;
        if (jumioConfirmationView != null) {
            AppCompatTextView appCompatTextView2 = this.description;
            jumioConfirmationView.setContentDescription(appCompatTextView2 != null ? appCompatTextView2.getText() : null);
        }
        JumioScanPart j11 = getJumioViewModel().j();
        if (j11 != null) {
            jumioScanMode = j11.getScanMode();
        }
        int i11 = jumioScanMode == null ? -1 : WhenMappings.$EnumSwitchMapping$1[jumioScanMode.ordinal()];
        if (i11 == 1) {
            fileConfirmationCustomization();
        } else if (i11 == 2) {
            faceConfirmationCustomization();
        }
        return inflate;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i11 = R.id.confirmationPositiveButton;
        if (valueOf != null && valueOf.intValue() == i11) {
            this.confirmationHandler.confirm();
        } else {
            int i12 = R.id.confirmationNegativeButton;
            if (valueOf != null && valueOf.intValue() == i12) {
                retakeImage();
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public void onDestroyView() {
        super.onDestroyView();
        this.confirmationView = null;
        this.confirmButton = null;
        this.retakeButton = null;
        this.confirmationViewSubtitle = null;
        this.title = null;
        this.description = null;
    }

    public void onStart() {
        JumioConfirmationView jumioConfirmationView;
        super.onStart();
        JumioScanPart j11 = getJumioViewModel().j();
        if (j11 != null) {
            this.confirmationHandler.attach(j11);
        }
        if ((!this.confirmationHandler.getParts().isEmpty()) && (jumioConfirmationView = this.confirmationView) != null) {
            JumioConfirmationHandler jumioConfirmationHandler = this.confirmationHandler;
            jumioConfirmationHandler.renderPart((JumioCredentialPart) CollectionsKt___CollectionsKt.a0(jumioConfirmationHandler.getParts()), jumioConfirmationView);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        super.onViewCreated(view, bundle);
        FragmentActivity activity = getActivity();
        if (!(activity == null || (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) == null)) {
            onBackPressedDispatcher.i(getViewLifecycleOwner(), new ConfirmationFragment$onViewCreated$1(this));
        }
        initObservers();
    }
}
