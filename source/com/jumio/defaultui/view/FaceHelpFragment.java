package com.jumio.defaultui.view;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.z;
import com.google.android.material.button.MaterialButton;
import com.jumio.commons.log.Log;
import com.jumio.defaultui.R;
import com.jumio.defaultui.view.LoadingView;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioAnimationView;
import d10.l;
import java.util.Map;
import jumio.dui.b;
import kotlin.i;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import pw.j;
import pw.k;
import zendesk.support.request.DocumentRenderer;

public final class FaceHelpFragment extends BaseFragment {
    private ConstraintLayout baseLayout;
    private JumioAnimationView faceHelpAnimationLayout;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new FaceHelpFragment$special$$inlined$activityViewModels$default$1(this), new FaceHelpFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new FaceHelpFragment$special$$inlined$activityViewModels$default$3(this));
    private final int requestedOrientation = 1;
    private final z<JumioScanStep> scanStepObserver = new k(this);
    private MaterialButton startButton;
    private NestedScrollView svDescription;
    private AppCompatTextView tvDescription;
    private AppCompatTextView tvTitle;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(13:0|1|2|3|4|5|6|7|8|9|10|11|13) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.PREPARE     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.IMAGE_TAKEN     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.PROCESSING     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.REJECT_VIEW     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.RETRY     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.FaceHelpFragment.WhenMappings.<clinit>():void");
        }
    }

    public static final class a extends Lambda implements l<Integer, CharSequence> {

        /* renamed from: a  reason: collision with root package name */
        public final /* synthetic */ FaceHelpFragment f70827a;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(FaceHelpFragment faceHelpFragment) {
            super(1);
            this.f70827a = faceHelpFragment;
        }

        public final Object invoke(Object obj) {
            return this.f70827a.getString(((Number) obj).intValue());
        }
    }

    /* access modifiers changed from: private */
    public static final void createLayout$lambda$3(FaceHelpFragment faceHelpFragment, View view) {
        faceHelpFragment.showStartButtonLoading();
        faceHelpFragment.startFaceScanning();
    }

    private final String getFaceRetryHelpText() {
        return CollectionsKt___CollectionsKt.k0(CollectionsKt__CollectionsKt.n(Integer.valueOf(R.string.jumio_iproov_failure_generic_angle), Integer.valueOf(R.string.jumio_iproov_failure_generic_glare), Integer.valueOf(R.string.jumio_iproov_failure_generic_light)), "\n" + DocumentRenderer.Style.Li.UNICODE_BULLET + " ", DocumentRenderer.Style.Li.UNICODE_BULLET + " ", (CharSequence) null, 0, (CharSequence) null, new a(this), 28, (Object) null);
    }

    private final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    private final void hideStartButtonLoading() {
        MaterialButton materialButton = this.startButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            materialButton = null;
        }
        materialButton.setEnabled(true);
        MaterialButton materialButton3 = this.startButton;
        if (materialButton3 != null) {
            materialButton2 = materialButton3;
        }
        setShowProgress(materialButton2, false);
    }

    private final void initObservers() {
        getJumioViewModel().f56362j.observe(getViewLifecycleOwner(), this.scanStepObserver);
    }

    /* access modifiers changed from: private */
    public static final void scanStepObserver$lambda$0(FaceHelpFragment faceHelpFragment, JumioScanStep jumioScanStep) {
        int i11;
        JumioRetryReason i12;
        String str = null;
        String name = jumioScanStep != null ? jumioScanStep.name() : null;
        Log.i("FaceHelpFragment", "Event " + name + " received");
        if (jumioScanStep == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$0[jumioScanStep.ordinal()];
        }
        if (i11 == 1) {
            faceHelpFragment.showStartButtonLoading();
        } else if (i11 == 2) {
            JumioFragmentCallback callback = faceHelpFragment.getCallback();
            if (callback != null) {
                callback.updateLoadingState(new LoadingView.State(LoadingView.ViewState.PROGRESS, faceHelpFragment.getString(R.string.jumio_analyzing_biometric), (String) null, 0, (View.OnClickListener) null, 28, (r) null));
            }
        } else if (i11 == 4) {
            Map<JumioCredentialPart, String> h11 = faceHelpFragment.getJumioViewModel().h();
            if (h11 != null) {
                JumioFragmentCallback callback2 = faceHelpFragment.getCallback();
                if (callback2 != null) {
                    callback2.hideLoading();
                }
                if (h11.get(faceHelpFragment.getJumioViewModel().e()) != null) {
                    updateWithFailure$default(faceHelpFragment, 0, (String) null, R.string.jumio_error_button_retake_one, 3, (Object) null);
                }
            }
        } else if (i11 == 5 && (i12 = faceHelpFragment.getJumioViewModel().i()) != null) {
            JumioFragmentCallback callback3 = faceHelpFragment.getCallback();
            if (callback3 != null) {
                callback3.hideLoading();
            }
            if (!(i12.getCode() == 100 || i12.getCode() == 2)) {
                str = i12.getMessage();
            }
            updateWithFailure$default(faceHelpFragment, 0, str, 0, 5, (Object) null);
        }
    }

    private final void showStartButtonLoading() {
        MaterialButton materialButton = this.startButton;
        MaterialButton materialButton2 = null;
        if (materialButton == null) {
            materialButton = null;
        }
        if (materialButton.isEnabled()) {
            MaterialButton materialButton3 = this.startButton;
            if (materialButton3 != null) {
                materialButton2 = materialButton3;
            }
            materialButton2.setText(getString(R.string.jumio_loading_title));
            materialButton2.setEnabled(false);
            setShowProgress(materialButton2, true);
        }
    }

    private final void startFaceScanning() {
        b jumioViewModel = getJumioViewModel();
        JumioScanPart j11 = jumioViewModel.j();
        if ((j11 != null ? j11.getScanMode() : null) == JumioScanMode.FACE_IPROOV) {
            JumioScanPart j12 = jumioViewModel.j();
            if (j12 != null) {
                j12.start();
                return;
            }
            return;
        }
        jumioViewModel.f56361i.setValue(b.C0659b.SCAN);
        JumioScanPart j13 = jumioViewModel.j();
        if (j13 != null) {
            j13.start();
        }
    }

    private final void updateWithFailure(int i11, String str, int i12) {
        Resources resources;
        DisplayMetrics displayMetrics;
        AppCompatTextView appCompatTextView = this.tvTitle;
        JumioAnimationView jumioAnimationView = null;
        if (appCompatTextView == null) {
            appCompatTextView = null;
        }
        Context context = getContext();
        appCompatTextView.setText(context != null ? context.getText(i11) : null);
        String faceRetryHelpText = str == null ? getFaceRetryHelpText() : str;
        AppCompatTextView appCompatTextView2 = this.tvDescription;
        if (appCompatTextView2 == null) {
            appCompatTextView2 = null;
        }
        appCompatTextView2.setText(faceRetryHelpText);
        appCompatTextView2.setGravity(str == null ? 8388611 : 17);
        Context context2 = getContext();
        int i13 = (int) (((float) 16) * ((context2 == null || (resources = context2.getResources()) == null || (displayMetrics = resources.getDisplayMetrics()) == null) ? 0.0f : displayMetrics.density));
        NestedScrollView nestedScrollView = this.svDescription;
        if (nestedScrollView == null) {
            nestedScrollView = null;
        }
        nestedScrollView.setPadding(i13, i13, i13, i13);
        nestedScrollView.setBackgroundResource(R.drawable.jumio_rounded_text_background);
        hideStartButtonLoading();
        MaterialButton materialButton = this.startButton;
        if (materialButton == null) {
            materialButton = null;
        }
        materialButton.setText(getString(i12));
        JumioAnimationView jumioAnimationView2 = this.faceHelpAnimationLayout;
        if (jumioAnimationView2 != null) {
            jumioAnimationView = jumioAnimationView2;
        }
        JumioScanPart j11 = getJumioViewModel().j();
        if (j11 != null) {
            j11.getHelpAnimation(jumioAnimationView);
        }
    }

    public static /* synthetic */ void updateWithFailure$default(FaceHelpFragment faceHelpFragment, int i11, String str, int i12, int i13, Object obj) {
        if ((i13 & 1) != 0) {
            i11 = R.string.jumio_iproov_failure_generic_title;
        }
        if ((i13 & 2) != 0) {
            str = null;
        }
        if ((i13 & 4) != 0) {
            i12 = R.string.jumio_error_button_retry;
        }
        faceHelpFragment.updateWithFailure(i11, str, i12);
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_face_help, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.baseLayout);
        this.baseLayout = constraintLayout;
        MaterialButton materialButton = null;
        if (constraintLayout == null) {
            constraintLayout = null;
        }
        this.faceHelpAnimationLayout = (JumioAnimationView) constraintLayout.findViewById(R.id.face_help_animation_view);
        ConstraintLayout constraintLayout2 = this.baseLayout;
        if (constraintLayout2 == null) {
            constraintLayout2 = null;
        }
        MaterialButton materialButton2 = (MaterialButton) constraintLayout2.findViewById(R.id.btn_start);
        Context context = materialButton2.getContext();
        materialButton2.setText(context != null ? context.getString(R.string.jumio_start_button) : null);
        this.startButton = materialButton2;
        ConstraintLayout constraintLayout3 = this.baseLayout;
        if (constraintLayout3 == null) {
            constraintLayout3 = null;
        }
        AppCompatTextView appCompatTextView = (AppCompatTextView) constraintLayout3.findViewById(R.id.tv_title);
        appCompatTextView.setGravity(17);
        Context context2 = appCompatTextView.getContext();
        appCompatTextView.setText(context2 != null ? context2.getString(R.string.jumio_identity_title) : null);
        this.tvTitle = appCompatTextView;
        ConstraintLayout constraintLayout4 = this.baseLayout;
        if (constraintLayout4 == null) {
            constraintLayout4 = null;
        }
        this.tvDescription = (AppCompatTextView) constraintLayout4.findViewById(R.id.tv_description);
        ConstraintLayout constraintLayout5 = this.baseLayout;
        if (constraintLayout5 == null) {
            constraintLayout5 = null;
        }
        this.svDescription = (NestedScrollView) constraintLayout5.findViewById(R.id.sv_description);
        MaterialButton materialButton3 = this.startButton;
        if (materialButton3 != null) {
            materialButton = materialButton3;
        }
        materialButton.setOnClickListener(new j(this));
        return inflate;
    }

    public Integer getRequestedOrientation() {
        return Integer.valueOf(this.requestedOrientation);
    }

    public void onDestroyView() {
        getJumioViewModel().f56362j.removeObserver(this.scanStepObserver);
        super.onDestroyView();
    }

    public void onStart() {
        super.onStart();
        JumioAnimationView jumioAnimationView = this.faceHelpAnimationLayout;
        if (jumioAnimationView == null) {
            jumioAnimationView = null;
        }
        JumioScanPart j11 = getJumioViewModel().j();
        if (j11 != null) {
            j11.getHelpAnimation(jumioAnimationView);
        }
        hideStartButtonLoading();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initObservers();
    }
}
