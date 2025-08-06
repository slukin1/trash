package com.jumio.defaultui.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.z;
import com.jumio.commons.log.Log;
import com.jumio.defaultui.R;
import com.jumio.defaultui.view.LoadingView;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.retry.JumioRetryReason;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioDigitalIdentityView;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.a;
import jumio.dui.b;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import pw.e;
import pw.f;
import pw.g;

public final class DigitalIdentityFragment extends BaseFragment {
    private JumioDigitalIdentityView digitalIdView;
    private final i jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(b.class), new DigitalIdentityFragment$special$$inlined$activityViewModels$default$1(this), new DigitalIdentityFragment$special$$inlined$activityViewModels$default$2((a) null, this), new DigitalIdentityFragment$special$$inlined$activityViewModels$default$3(this));
    private final View.OnClickListener retryClickListener = new f(this);
    private final z<JumioScanStep> scanStepObserver = new g(this);
    private final View.OnClickListener userCancellationClickListener = new e(this);

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        /* JADX WARNING: Can't wrap try/catch for region: R(15:0|1|2|3|4|5|6|7|8|9|10|11|12|13|15) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x0034 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0010 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0022 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x002b */
        static {
            /*
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.DIGITAL_IDENTITY_VIEW     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.PREPARE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.STARTED     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.THIRD_PARTY_VERIFICATION     // Catch:{ NoSuchFieldError -> 0x002b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.PROCESSING     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                com.jumio.sdk.enums.JumioScanStep r1 = com.jumio.sdk.enums.JumioScanStep.RETRY     // Catch:{ NoSuchFieldError -> 0x003d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                $EnumSwitchMapping$0 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.DigitalIdentityFragment.WhenMappings.<clinit>():void");
        }
    }

    private final LoadingView.State buildErrorState(String str, String str2, int i11, View.OnClickListener onClickListener) {
        return new LoadingView.State(LoadingView.ViewState.ERROR, str, str2, i11, onClickListener);
    }

    public static /* synthetic */ LoadingView.State buildErrorState$default(DigitalIdentityFragment digitalIdentityFragment, String str, String str2, int i11, View.OnClickListener onClickListener, int i12, Object obj) {
        if ((i12 & 2) != 0) {
            str2 = "";
        }
        if ((i12 & 4) != 0) {
            i11 = R.string.jumio_button_retry;
        }
        return digitalIdentityFragment.buildErrorState(str, str2, i11, onClickListener);
    }

    private final LoadingView.State buildUserCancelViewState(String str) {
        return buildErrorState(str, getString(R.string.jumio_di_back_to_document_selection), R.string.jumio_id_confirm_button_confirm, this.userCancellationClickListener);
    }

    private final b getJumioViewModel() {
        return (b) this.jumioViewModel$delegate.getValue();
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void retryClickListener$lambda$1(DigitalIdentityFragment digitalIdentityFragment, View view) {
        JumioRetryReason i11 = digitalIdentityFragment.getJumioViewModel().i();
        if (i11 == null) {
            SensorsDataAutoTrackHelper.trackViewOnClick(view);
            return;
        }
        JumioScanPart j11 = digitalIdentityFragment.getJumioViewModel().j();
        if (j11 != null) {
            j11.retry(i11);
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: com.jumio.sdk.views.JumioDigitalIdentityView} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.jumio.sdk.document.JumioDigitalDocument} */
    /* JADX WARNING: type inference failed for: r0v0 */
    /* JADX WARNING: type inference failed for: r0v2 */
    /* JADX WARNING: type inference failed for: r0v15 */
    /* access modifiers changed from: private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void scanStepObserver$lambda$2(com.jumio.defaultui.view.DigitalIdentityFragment r10, com.jumio.sdk.enums.JumioScanStep r11) {
        /*
            if (r11 != 0) goto L_0x0004
            r11 = -1
            goto L_0x000c
        L_0x0004:
            int[] r0 = com.jumio.defaultui.view.DigitalIdentityFragment.WhenMappings.$EnumSwitchMapping$0
            int r11 = r11.ordinal()
            r11 = r0[r11]
        L_0x000c:
            r0 = 0
            switch(r11) {
                case 1: goto L_0x00dc;
                case 2: goto L_0x00be;
                case 3: goto L_0x00b4;
                case 4: goto L_0x0066;
                case 5: goto L_0x0047;
                case 6: goto L_0x0012;
                default: goto L_0x0010;
            }
        L_0x0010:
            goto L_0x00f0
        L_0x0012:
            jumio.dui.b r11 = r10.getJumioViewModel()
            com.jumio.sdk.retry.JumioRetryReason r11 = r11.i()
            if (r11 != 0) goto L_0x001d
            return
        L_0x001d:
            int r0 = r11.getCode()
            r1 = 2
            if (r0 != r1) goto L_0x002d
            java.lang.String r11 = r11.getMessage()
            com.jumio.defaultui.view.LoadingView$State r11 = r10.buildUserCancelViewState(r11)
            goto L_0x003c
        L_0x002d:
            java.lang.String r1 = r11.getMessage()
            android.view.View$OnClickListener r4 = r10.retryClickListener
            r2 = 0
            r3 = 0
            r5 = 6
            r6 = 0
            r0 = r10
            com.jumio.defaultui.view.LoadingView$State r11 = buildErrorState$default(r0, r1, r2, r3, r4, r5, r6)
        L_0x003c:
            com.jumio.defaultui.view.JumioFragmentCallback r10 = r10.getCallback()
            if (r10 == 0) goto L_0x00f0
            r10.updateLoadingState(r11)
            goto L_0x00f0
        L_0x0047:
            com.jumio.defaultui.view.JumioFragmentCallback r11 = r10.getCallback()
            if (r11 == 0) goto L_0x00f0
            com.jumio.defaultui.view.LoadingView$State r8 = new com.jumio.defaultui.view.LoadingView$State
            com.jumio.defaultui.view.LoadingView$ViewState r1 = com.jumio.defaultui.view.LoadingView.ViewState.PROGRESS
            int r0 = com.jumio.defaultui.R.string.jumio_processing_title
            java.lang.String r2 = r10.getString(r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 28
            r7 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r11.updateLoadingState(r8)
            goto L_0x00f0
        L_0x0066:
            jumio.dui.b r11 = r10.getJumioViewModel()
            com.jumio.sdk.document.JumioDocument r11 = r11.g()
            boolean r1 = r11 instanceof com.jumio.sdk.document.JumioDigitalDocument
            if (r1 == 0) goto L_0x0075
            r0 = r11
            com.jumio.sdk.document.JumioDigitalDocument r0 = (com.jumio.sdk.document.JumioDigitalDocument) r0
        L_0x0075:
            if (r0 != 0) goto L_0x0078
            return
        L_0x0078:
            com.jumio.defaultui.view.JumioFragmentCallback r11 = r10.getCallback()
            if (r11 == 0) goto L_0x00f0
            com.jumio.defaultui.view.LoadingView$State r9 = new com.jumio.defaultui.view.LoadingView$State
            com.jumio.defaultui.view.LoadingView$ViewState r2 = com.jumio.defaultui.view.LoadingView.ViewState.PROGRESS
            int r1 = com.jumio.defaultui.R.string.jumio_di_verification_prompt_processing
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.String r0 = r0.getTitle()
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "'"
            r4.append(r5)
            r4.append(r0)
            r4.append(r5)
            java.lang.String r0 = r4.toString()
            r4 = 0
            r3[r4] = r0
            java.lang.String r4 = r10.getString(r1, r3)
            r3 = 0
            r5 = 0
            r6 = 0
            r7 = 26
            r8 = 0
            r1 = r9
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)
            r11.updateLoadingState(r9)
            goto L_0x00f0
        L_0x00b4:
            com.jumio.defaultui.view.JumioFragmentCallback r10 = r10.getCallback()
            if (r10 == 0) goto L_0x00f0
            r10.hideLoading()
            goto L_0x00f0
        L_0x00be:
            com.jumio.defaultui.view.JumioFragmentCallback r11 = r10.getCallback()
            if (r11 == 0) goto L_0x00f0
            com.jumio.defaultui.view.LoadingView$State r8 = new com.jumio.defaultui.view.LoadingView$State
            com.jumio.defaultui.view.LoadingView$ViewState r1 = com.jumio.defaultui.view.LoadingView.ViewState.PROGRESS
            int r0 = com.jumio.defaultui.R.string.jumio_loading_title
            java.lang.String r2 = r10.getString(r0)
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 28
            r7 = 0
            r0 = r8
            r0.<init>(r1, r2, r3, r4, r5, r6, r7)
            r11.updateLoadingState(r8)
            goto L_0x00f0
        L_0x00dc:
            jumio.dui.b r11 = r10.getJumioViewModel()
            com.jumio.sdk.scanpart.JumioScanPart r11 = r11.j()
            if (r11 != 0) goto L_0x00e7
            return
        L_0x00e7:
            com.jumio.sdk.views.JumioDigitalIdentityView r10 = r10.digitalIdView
            if (r10 != 0) goto L_0x00ec
            goto L_0x00ed
        L_0x00ec:
            r0 = r10
        L_0x00ed:
            r0.attach(r11)
        L_0x00f0:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.DigitalIdentityFragment.scanStepObserver$lambda$2(com.jumio.defaultui.view.DigitalIdentityFragment, com.jumio.sdk.enums.JumioScanStep):void");
    }

    /* access modifiers changed from: private */
    @SensorsDataInstrumented
    public static final void userCancellationClickListener$lambda$0(DigitalIdentityFragment digitalIdentityFragment, View view) {
        digitalIdentityFragment.getJumioViewModel().a();
        b jumioViewModel = digitalIdentityFragment.getJumioViewModel();
        jumioViewModel.getClass();
        Log.i("SdkState: ViewModel set SELECTION_DOCUMENT");
        jumioViewModel.f56362j.setValue(null);
        jumioViewModel.f56361i.setValue(b.C0659b.SELECTION_DOCUMENT);
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_web_verification, viewGroup, false);
        this.digitalIdView = (JumioDigitalIdentityView) inflate.findViewById(R.id.web_verification_view);
        return inflate;
    }

    public void onDestroyView() {
        getJumioViewModel().f56362j.removeObserver(this.scanStepObserver);
        super.onDestroyView();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        JumioDigitalIdentityView jumioDigitalIdentityView = this.digitalIdView;
        if (jumioDigitalIdentityView != null) {
            jumioDigitalIdentityView.saveState(bundle);
        }
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        getJumioViewModel().f56362j.observe(getViewLifecycleOwner(), this.scanStepObserver);
        if (bundle != null) {
            JumioDigitalIdentityView jumioDigitalIdentityView = this.digitalIdView;
            if (jumioDigitalIdentityView == null) {
                jumioDigitalIdentityView = null;
            }
            jumioDigitalIdentityView.restoreState(bundle);
        }
    }
}
