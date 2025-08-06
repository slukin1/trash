package com.jumio.defaultui.view;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Group;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.z;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.jumio.commons.log.Log;
import com.jumio.defaultui.R;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioActivityAttacher;
import com.jumio.sdk.views.JumioAnimationView;
import d10.a;
import jumio.dui.b;
import kotlin.Pair;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import pw.q;

public final class NfcScanFragment extends BaseFragment implements View.OnClickListener {
    public static final Companion Companion = new Companion((r) null);
    private static String TAG = "NfcScanFragment";
    private ConstraintLayout baseLayout;
    private MaterialButton btnHelpSkip;
    private MaterialButton btnRetry;
    private MaterialButton btnRetrySkip;
    private CircularProgressIndicator cpiExtraction;
    private Group groupHelp;
    private Group groupProgress;
    private Group groupRetry;
    private ImageView ivStatus;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new NfcScanFragment$special$$inlined$activityViewModels$default$1(this), new NfcScanFragment$special$$inlined$activityViewModels$default$2((a) null, this), new NfcScanFragment$special$$inlined$activityViewModels$default$3(this));
    private JumioAnimationView nfcAnimationView;
    private JumioRetryReason retryReason;
    private final z<JumioScanStep> scanStepObserver = new q(this);
    private final z<Pair<JumioScanUpdate, JumioCredentialPart>> scanUpdateObserver = new pw.r(this);
    private AppCompatTextView tvDescription;
    private AppCompatTextView tvProgress;
    private AppCompatTextView tvRetryDescription;
    private AppCompatTextView tvTitle;

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

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|16|(2:17|18)|19|21) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0033 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x003b */
        static {
            /*
                com.jumio.sdk.enums.JumioScanUpdate[] r0 = com.jumio.sdk.enums.JumioScanUpdate.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.sdk.enums.JumioScanUpdate r2 = com.jumio.sdk.enums.JumioScanUpdate.NFC_EXTRACTION_STARTED     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.sdk.enums.JumioScanUpdate r3 = com.jumio.sdk.enums.JumioScanUpdate.NFC_EXTRACTION_PROGRESS     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.jumio.sdk.enums.JumioScanUpdate r4 = com.jumio.sdk.enums.JumioScanUpdate.NFC_EXTRACTION_FINISHED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                $EnumSwitchMapping$0 = r0
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanStep r4 = com.jumio.sdk.enums.JumioScanStep.ATTACH_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r0[r4] = r1     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.RETRY     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.CAN_FINISH     // Catch:{ NoSuchFieldError -> 0x0043 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0043 }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x0043 }
            L_0x0043:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.NfcScanFragment.WhenMappings.<clinit>():void");
        }
    }

    private final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    private final void initObservers() {
        getJumioViewModel().f56363k.observe(getViewLifecycleOwner(), this.scanUpdateObserver);
        getJumioViewModel().f56362j.observe(getViewLifecycleOwner(), this.scanStepObserver);
    }

    /* access modifiers changed from: private */
    public static final void scanStepObserver$lambda$4(NfcScanFragment nfcScanFragment, JumioScanStep jumioScanStep) {
        int i11;
        JumioScanPart j11;
        JumioAnimationView jumioAnimationView;
        if (jumioScanStep != null) {
            String str = TAG;
            String name = jumioScanStep.name();
            Log.i(str, "Event " + name + " received");
        }
        if (jumioScanStep == null) {
            i11 = -1;
        } else {
            i11 = WhenMappings.$EnumSwitchMapping$1[jumioScanStep.ordinal()];
        }
        if (i11 == 1) {
            FragmentActivity activity = nfcScanFragment.getActivity();
            if (activity != null && (j11 = nfcScanFragment.getJumioViewModel().j()) != null) {
                new JumioActivityAttacher(activity).attach(j11);
            }
        } else if (i11 != 2) {
            if (i11 == 3 && (jumioAnimationView = nfcScanFragment.nfcAnimationView) != null) {
                jumioAnimationView.destroy();
            }
        } else if (nfcScanFragment.getJumioViewModel().i() != null) {
            JumioRetryReason i12 = nfcScanFragment.getJumioViewModel().i();
            nfcScanFragment.retryReason = i12;
            AppCompatTextView appCompatTextView = nfcScanFragment.tvRetryDescription;
            if (appCompatTextView != null) {
                appCompatTextView.setText(i12 != null ? i12.getMessage() : null);
            }
            Group group = nfcScanFragment.groupHelp;
            if (group != null) {
                group.setVisibility(8);
            }
            Group group2 = nfcScanFragment.groupProgress;
            if (group2 != null) {
                group2.setVisibility(8);
            }
            Group group3 = nfcScanFragment.groupRetry;
            if (group3 != null) {
                group3.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: private */
    public static final void scanUpdateObserver$lambda$0(NfcScanFragment nfcScanFragment, Pair pair) {
        JumioScanUpdate jumioScanUpdate = (JumioScanUpdate) pair.component1();
        String str = TAG;
        String name = jumioScanUpdate.name();
        Log.i(str, "Update " + name + " received");
        int i11 = WhenMappings.$EnumSwitchMapping$0[jumioScanUpdate.ordinal()];
        if (i11 == 1) {
            Log.i(TAG, "NFC Extraction started");
            Group group = nfcScanFragment.groupHelp;
            if (group != null) {
                group.setVisibility(8);
            }
            Group group2 = nfcScanFragment.groupProgress;
            if (group2 != null) {
                group2.setVisibility(0);
            }
            Group group3 = nfcScanFragment.groupRetry;
            if (group3 != null) {
                group3.setVisibility(8);
            }
        } else if (i11 == 2) {
            Log.i(TAG, "NFC Extraction progress");
            AppCompatTextView appCompatTextView = nfcScanFragment.tvProgress;
            if (appCompatTextView != null) {
                int m11 = nfcScanFragment.getJumioViewModel().m();
                appCompatTextView.setText(m11 + "%");
            }
        } else if (i11 == 3) {
            Log.i(TAG, "NFC Extraction finished");
            CircularProgressIndicator circularProgressIndicator = nfcScanFragment.cpiExtraction;
            if (circularProgressIndicator != null) {
                circularProgressIndicator.hide();
            }
            AppCompatTextView appCompatTextView2 = nfcScanFragment.tvProgress;
            if (appCompatTextView2 != null) {
                appCompatTextView2.setVisibility(4);
            }
            ImageView imageView = nfcScanFragment.ivStatus;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.jumio_ic_nfc_success);
            }
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_scan_nfc, viewGroup, false);
        ConstraintLayout constraintLayout = (ConstraintLayout) inflate.findViewById(R.id.baseLayout);
        this.baseLayout = constraintLayout;
        String str = null;
        this.nfcAnimationView = constraintLayout != null ? (JumioAnimationView) constraintLayout.findViewById(R.id.nfc_animation_view) : null;
        ConstraintLayout constraintLayout2 = this.baseLayout;
        MaterialButton materialButton = constraintLayout2 != null ? (MaterialButton) constraintLayout2.findViewById(R.id.btn_help_skip) : null;
        this.btnHelpSkip = materialButton;
        if (materialButton != null) {
            materialButton.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout3 = this.baseLayout;
        MaterialButton materialButton2 = constraintLayout3 != null ? (MaterialButton) constraintLayout3.findViewById(R.id.btn_retry_skip) : null;
        this.btnRetrySkip = materialButton2;
        if (materialButton2 != null) {
            materialButton2.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout4 = this.baseLayout;
        MaterialButton materialButton3 = constraintLayout4 != null ? (MaterialButton) constraintLayout4.findViewById(R.id.btn_retry) : null;
        this.btnRetry = materialButton3;
        if (materialButton3 != null) {
            materialButton3.setOnClickListener(this);
        }
        ConstraintLayout constraintLayout5 = this.baseLayout;
        this.groupRetry = constraintLayout5 != null ? (Group) constraintLayout5.findViewById(R.id.group_retry) : null;
        ConstraintLayout constraintLayout6 = this.baseLayout;
        this.groupProgress = constraintLayout6 != null ? (Group) constraintLayout6.findViewById(R.id.group_progress) : null;
        ConstraintLayout constraintLayout7 = this.baseLayout;
        this.groupHelp = constraintLayout7 != null ? (Group) constraintLayout7.findViewById(R.id.group_help) : null;
        ConstraintLayout constraintLayout8 = this.baseLayout;
        this.tvProgress = constraintLayout8 != null ? (AppCompatTextView) constraintLayout8.findViewById(R.id.tv_progress_percentage) : null;
        ConstraintLayout constraintLayout9 = this.baseLayout;
        this.ivStatus = constraintLayout9 != null ? (ImageView) constraintLayout9.findViewById(R.id.iv_progress) : null;
        ConstraintLayout constraintLayout10 = this.baseLayout;
        this.cpiExtraction = constraintLayout10 != null ? (CircularProgressIndicator) constraintLayout10.findViewById(R.id.cpi_extraction) : null;
        ConstraintLayout constraintLayout11 = this.baseLayout;
        this.tvTitle = constraintLayout11 != null ? (AppCompatTextView) constraintLayout11.findViewById(R.id.tv_title) : null;
        ConstraintLayout constraintLayout12 = this.baseLayout;
        this.tvDescription = constraintLayout12 != null ? (AppCompatTextView) constraintLayout12.findViewById(R.id.tv_description) : null;
        ConstraintLayout constraintLayout13 = this.baseLayout;
        this.tvRetryDescription = constraintLayout13 != null ? (AppCompatTextView) constraintLayout13.findViewById(R.id.tv_retry_description) : null;
        AppCompatTextView appCompatTextView = this.tvTitle;
        if (appCompatTextView != null) {
            Context context = getContext();
            appCompatTextView.setText(context != null ? context.getString(R.string.jumio_nfc_header_start) : null);
        }
        AppCompatTextView appCompatTextView2 = this.tvDescription;
        if (appCompatTextView2 != null) {
            Context context2 = getContext();
            if (context2 != null) {
                str = context2.getString(R.string.jumio_nfc_description_start_other);
            }
            appCompatTextView2.setText(str);
        }
        return inflate;
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x0067  */
    @com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onClick(android.view.View r6) {
        /*
            r5 = this;
            r0 = 0
            if (r6 == 0) goto L_0x000c
            int r1 = r6.getId()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            goto L_0x000d
        L_0x000c:
            r1 = r0
        L_0x000d:
            int r2 = com.jumio.defaultui.R.id.btn_retry
            r3 = 0
            if (r1 != 0) goto L_0x0013
            goto L_0x004b
        L_0x0013:
            int r4 = r1.intValue()
            if (r4 != r2) goto L_0x004b
            com.jumio.sdk.retry.JumioRetryReason r1 = r5.retryReason
            if (r1 == 0) goto L_0x0080
            androidx.constraintlayout.widget.Group r1 = r5.groupHelp
            if (r1 != 0) goto L_0x0022
            goto L_0x0025
        L_0x0022:
            r1.setVisibility(r3)
        L_0x0025:
            androidx.constraintlayout.widget.Group r1 = r5.groupProgress
            r2 = 8
            if (r1 != 0) goto L_0x002c
            goto L_0x002f
        L_0x002c:
            r1.setVisibility(r2)
        L_0x002f:
            androidx.constraintlayout.widget.Group r1 = r5.groupRetry
            if (r1 != 0) goto L_0x0034
            goto L_0x0037
        L_0x0034:
            r1.setVisibility(r2)
        L_0x0037:
            com.jumio.sdk.retry.JumioRetryReason r1 = r5.retryReason
            if (r1 == 0) goto L_0x0048
            jumio.dui.b r2 = r5.getJumioViewModel()
            com.jumio.sdk.scanpart.JumioScanPart r2 = r2.j()
            if (r2 == 0) goto L_0x0048
            r2.retry(r1)
        L_0x0048:
            r5.retryReason = r0
            goto L_0x0080
        L_0x004b:
            int r0 = com.jumio.defaultui.R.id.btn_retry_skip
            if (r1 != 0) goto L_0x0050
            goto L_0x0057
        L_0x0050:
            int r2 = r1.intValue()
            if (r2 != r0) goto L_0x0057
            goto L_0x0062
        L_0x0057:
            int r0 = com.jumio.defaultui.R.id.btn_help_skip
            if (r1 != 0) goto L_0x005c
            goto L_0x0064
        L_0x005c:
            int r1 = r1.intValue()
            if (r1 != r0) goto L_0x0064
        L_0x0062:
            r0 = 1
            goto L_0x0065
        L_0x0064:
            r0 = r3
        L_0x0065:
            if (r0 == 0) goto L_0x0080
            com.google.android.material.button.MaterialButton r0 = r5.btnRetrySkip
            if (r0 != 0) goto L_0x006c
            goto L_0x006f
        L_0x006c:
            r0.setEnabled(r3)
        L_0x006f:
            com.google.android.material.button.MaterialButton r0 = r5.btnHelpSkip
            if (r0 != 0) goto L_0x0074
            goto L_0x0077
        L_0x0074:
            r0.setEnabled(r3)
        L_0x0077:
            com.jumio.defaultui.view.JumioFragmentCallback r0 = r5.getCallback()
            if (r0 == 0) goto L_0x0080
            r0.skipAddonPart()
        L_0x0080:
            com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper.trackViewOnClick(r6)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.NfcScanFragment.onClick(android.view.View):void");
    }

    public void onDestroyView() {
        super.onDestroyView();
        JumioAnimationView jumioAnimationView = this.nfcAnimationView;
        if (jumioAnimationView != null) {
            jumioAnimationView.destroy();
        }
        this.btnHelpSkip = null;
        this.btnRetrySkip = null;
        this.btnRetry = null;
        this.ivStatus = null;
        this.cpiExtraction = null;
        this.tvTitle = null;
        this.tvDescription = null;
        this.tvRetryDescription = null;
        this.tvProgress = null;
        this.baseLayout = null;
        this.groupRetry = null;
        this.groupProgress = null;
        this.groupHelp = null;
        this.nfcAnimationView = null;
    }

    public void onStart() {
        JumioScanPart j11;
        super.onStart();
        JumioAnimationView jumioAnimationView = this.nfcAnimationView;
        if (!(jumioAnimationView == null || (j11 = getJumioViewModel().j()) == null)) {
            j11.getHelpAnimation(jumioAnimationView);
        }
        JumioScanPart j12 = getJumioViewModel().j();
        if (j12 != null) {
            j12.start();
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        initObservers();
    }
}
