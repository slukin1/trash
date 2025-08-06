package com.jumio.defaultui.view;

import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.i0;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.v;
import androidx.lifecycle.z;
import androidx.vectordrawable.graphics.drawable.b;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.google.android.material.snackbar.Snackbar;
import com.jumio.commons.log.Log;
import com.jumio.core.util.DeviceUtilKt;
import com.jumio.core.views.CameraScanView;
import com.jumio.defaultui.R;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioFallbackReason;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.enums.JumioScanStep;
import com.jumio.sdk.enums.JumioScanUpdate;
import com.jumio.sdk.scanpart.JumioScanPart;
import com.jumio.sdk.views.JumioActivityAttacher;
import com.sensorsdata.analytics.android.sdk.SensorsDataAutoTrackHelper;
import com.sensorsdata.analytics.android.sdk.SensorsDataInstrumented;
import d10.p;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import pw.s;
import pw.t;
import pw.u;

public abstract class ScanFragment extends BaseFragment implements View.OnClickListener {
    private b animatedDrawable;
    private final ScanFragment$animatedDrawableCallback$1 animatedDrawableCallback;
    private ImageView animationIcon;
    private n1 animationJob;
    private ImageView animationScrim;
    /* access modifiers changed from: private */
    public JumioBottomSheet<String[]> bottomSheet;
    private ImageButton cameraSwitchButton;
    private final int closeButtonResource;
    /* access modifiers changed from: private */
    public int height;
    /* access modifiers changed from: private */
    public ImageButton helpButton;
    private final int helpButtonResource;
    private final z<Boolean> helpViewObserver;
    private ValueAnimator holdStillAnimator;
    private boolean isHoldStill;
    private final i jumioViewModel$delegate;
    private AlertDialog legalDialog;
    private Snackbar notificationSnackbar;
    private ImageView plusIcon;
    private CircularProgressIndicator processingIndicator;
    private AppCompatTextView progressChip;
    private AnimatorSet scanAnimatorSet;
    private final z<JumioScanStep> scanStepObserver;
    private AppCompatTextView scanTitle;
    private final z<Pair<JumioScanUpdate, JumioCredentialPart>> scanUpdateObserver;
    private CameraScanView scanView;
    private ImageButton shutterButton;
    private final int shutterButtonResource;
    private int sidePadding;
    private n1 tooltipJob;
    /* access modifiers changed from: private */
    public int width;

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;
        public static final /* synthetic */ int[] $EnumSwitchMapping$2;

        /* JADX WARNING: Can't wrap try/catch for region: R(56:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|(2:25|26)|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|(2:73|74)|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(58:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|(2:21|22)|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(59:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|(2:17|18)|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(60:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|(2:13|14)|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(61:0|(2:1|2)|3|(2:5|6)|7|(2:9|10)|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|(2:63|64)|65|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(63:0|(2:1|2)|3|(2:5|6)|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|(2:33|34)|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(65:0|(2:1|2)|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|(2:29|30)|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Can't wrap try/catch for region: R(67:0|1|2|3|5|6|7|9|10|11|13|14|15|17|18|19|21|22|23|25|26|27|29|30|31|33|34|35|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|67|68|69|70|71|72|73|74|75|77) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x006b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x0073 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x007b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0083 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x008b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0093 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x009b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x00a3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x00ab */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x00b5 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x00bf */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x00c9 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x00d3 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x00ee */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x00f6 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x00fe */
        static {
            /*
                com.jumio.sdk.enums.JumioScanStep[] r0 = com.jumio.sdk.enums.JumioScanStep.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.sdk.enums.JumioScanStep r2 = com.jumio.sdk.enums.JumioScanStep.SCAN_VIEW     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.sdk.enums.JumioScanStep r3 = com.jumio.sdk.enums.JumioScanStep.STARTED     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                r3 = 3
                com.jumio.sdk.enums.JumioScanStep r4 = com.jumio.sdk.enums.JumioScanStep.NEXT_PART     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r4 = r4.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r0[r4] = r3     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                r4 = 4
                com.jumio.sdk.enums.JumioScanStep r5 = com.jumio.sdk.enums.JumioScanStep.PROCESSING     // Catch:{ NoSuchFieldError -> 0x002b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r0[r5] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                r5 = 5
                com.jumio.sdk.enums.JumioScanStep r6 = com.jumio.sdk.enums.JumioScanStep.CONFIRMATION_VIEW     // Catch:{ NoSuchFieldError -> 0x0034 }
                int r6 = r6.ordinal()     // Catch:{ NoSuchFieldError -> 0x0034 }
                r0[r6] = r5     // Catch:{ NoSuchFieldError -> 0x0034 }
            L_0x0034:
                r6 = 6
                com.jumio.sdk.enums.JumioScanStep r7 = com.jumio.sdk.enums.JumioScanStep.REJECT_VIEW     // Catch:{ NoSuchFieldError -> 0x003d }
                int r7 = r7.ordinal()     // Catch:{ NoSuchFieldError -> 0x003d }
                r0[r7] = r6     // Catch:{ NoSuchFieldError -> 0x003d }
            L_0x003d:
                r7 = 7
                com.jumio.sdk.enums.JumioScanStep r8 = com.jumio.sdk.enums.JumioScanStep.ATTACH_ACTIVITY     // Catch:{ NoSuchFieldError -> 0x0046 }
                int r8 = r8.ordinal()     // Catch:{ NoSuchFieldError -> 0x0046 }
                r0[r8] = r7     // Catch:{ NoSuchFieldError -> 0x0046 }
            L_0x0046:
                r8 = 8
                com.jumio.sdk.enums.JumioScanStep r9 = com.jumio.sdk.enums.JumioScanStep.IMAGE_TAKEN     // Catch:{ NoSuchFieldError -> 0x0050 }
                int r9 = r9.ordinal()     // Catch:{ NoSuchFieldError -> 0x0050 }
                r0[r9] = r8     // Catch:{ NoSuchFieldError -> 0x0050 }
            L_0x0050:
                r9 = 9
                com.jumio.sdk.enums.JumioScanStep r10 = com.jumio.sdk.enums.JumioScanStep.CAN_FINISH     // Catch:{ NoSuchFieldError -> 0x005a }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x005a }
                r0[r10] = r9     // Catch:{ NoSuchFieldError -> 0x005a }
            L_0x005a:
                $EnumSwitchMapping$0 = r0
                com.jumio.sdk.enums.JumioScanUpdate[] r0 = com.jumio.sdk.enums.JumioScanUpdate.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanUpdate r10 = com.jumio.sdk.enums.JumioScanUpdate.FALLBACK     // Catch:{ NoSuchFieldError -> 0x006b }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x006b }
                r0[r10] = r1     // Catch:{ NoSuchFieldError -> 0x006b }
            L_0x006b:
                com.jumio.sdk.enums.JumioScanUpdate r10 = com.jumio.sdk.enums.JumioScanUpdate.CAMERA_AVAILABLE     // Catch:{ NoSuchFieldError -> 0x0073 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0073 }
                r0[r10] = r2     // Catch:{ NoSuchFieldError -> 0x0073 }
            L_0x0073:
                com.jumio.sdk.enums.JumioScanUpdate r10 = com.jumio.sdk.enums.JumioScanUpdate.CENTER_ID     // Catch:{ NoSuchFieldError -> 0x007b }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x007b }
                r0[r10] = r3     // Catch:{ NoSuchFieldError -> 0x007b }
            L_0x007b:
                com.jumio.sdk.enums.JumioScanUpdate r10 = com.jumio.sdk.enums.JumioScanUpdate.CENTER_FACE     // Catch:{ NoSuchFieldError -> 0x0083 }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x0083 }
                r0[r10] = r4     // Catch:{ NoSuchFieldError -> 0x0083 }
            L_0x0083:
                com.jumio.sdk.enums.JumioScanUpdate r10 = com.jumio.sdk.enums.JumioScanUpdate.LEVEL_EYES_AND_DEVICE     // Catch:{ NoSuchFieldError -> 0x008b }
                int r10 = r10.ordinal()     // Catch:{ NoSuchFieldError -> 0x008b }
                r0[r10] = r5     // Catch:{ NoSuchFieldError -> 0x008b }
            L_0x008b:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.HOLD_STILL     // Catch:{ NoSuchFieldError -> 0x0093 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x0093 }
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x0093 }
            L_0x0093:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.HOLD_STRAIGHT     // Catch:{ NoSuchFieldError -> 0x009b }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x009b }
                r0[r5] = r7     // Catch:{ NoSuchFieldError -> 0x009b }
            L_0x009b:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.MOVE_CLOSER     // Catch:{ NoSuchFieldError -> 0x00a3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a3 }
                r0[r5] = r8     // Catch:{ NoSuchFieldError -> 0x00a3 }
            L_0x00a3:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.TOO_CLOSE     // Catch:{ NoSuchFieldError -> 0x00ab }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ab }
                r0[r5] = r9     // Catch:{ NoSuchFieldError -> 0x00ab }
            L_0x00ab:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.FACE_TOO_CLOSE     // Catch:{ NoSuchFieldError -> 0x00b5 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b5 }
                r6 = 10
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00b5 }
            L_0x00b5:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.MOVE_FACE_CLOSER     // Catch:{ NoSuchFieldError -> 0x00bf }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00bf }
                r6 = 11
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00bf }
            L_0x00bf:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.NFC_EXTRACTION_STARTED     // Catch:{ NoSuchFieldError -> 0x00c9 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c9 }
                r6 = 12
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00c9 }
            L_0x00c9:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.NFC_EXTRACTION_PROGRESS     // Catch:{ NoSuchFieldError -> 0x00d3 }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d3 }
                r6 = 13
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00d3 }
            L_0x00d3:
                com.jumio.sdk.enums.JumioScanUpdate r5 = com.jumio.sdk.enums.JumioScanUpdate.NFC_EXTRACTION_FINISHED     // Catch:{ NoSuchFieldError -> 0x00dd }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00dd }
                r6 = 14
                r0[r5] = r6     // Catch:{ NoSuchFieldError -> 0x00dd }
            L_0x00dd:
                $EnumSwitchMapping$1 = r0
                com.jumio.sdk.enums.JumioScanMode[] r0 = com.jumio.sdk.enums.JumioScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioScanMode r5 = com.jumio.sdk.enums.JumioScanMode.BARCODE     // Catch:{ NoSuchFieldError -> 0x00ee }
                int r5 = r5.ordinal()     // Catch:{ NoSuchFieldError -> 0x00ee }
                r0[r5] = r1     // Catch:{ NoSuchFieldError -> 0x00ee }
            L_0x00ee:
                com.jumio.sdk.enums.JumioScanMode r1 = com.jumio.sdk.enums.JumioScanMode.FACE_MANUAL     // Catch:{ NoSuchFieldError -> 0x00f6 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f6 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f6 }
            L_0x00f6:
                com.jumio.sdk.enums.JumioScanMode r1 = com.jumio.sdk.enums.JumioScanMode.JUMIO_LIVENESS     // Catch:{ NoSuchFieldError -> 0x00fe }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fe }
                r0[r1] = r3     // Catch:{ NoSuchFieldError -> 0x00fe }
            L_0x00fe:
                com.jumio.sdk.enums.JumioScanMode r1 = com.jumio.sdk.enums.JumioScanMode.MANUAL     // Catch:{ NoSuchFieldError -> 0x0106 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0106 }
                r0[r1] = r4     // Catch:{ NoSuchFieldError -> 0x0106 }
            L_0x0106:
                $EnumSwitchMapping$2 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.ScanFragment.WhenMappings.<clinit>():void");
        }
    }

    @d(c = "com.jumio.defaultui.view.ScanFragment$setupTooltip$2", f = "ScanFragment.kt", l = {345}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f70842a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ScanFragment f70843b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(ScanFragment scanFragment, c<? super a> cVar) {
            super(2, cVar);
            this.f70843b = scanFragment;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new a(this.f70843b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            ImageButton access$getHelpButton$p;
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f70842a;
            if (i11 == 0) {
                k.b(obj);
                this.f70842a = 1;
                if (DelayKt.b(10000, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            if (!(this.f70843b.getJumioViewModel$jumio_defaultui_release().f56362j.getValue() == JumioScanStep.SCAN_VIEW || this.f70843b.bottomSheet != null || (access$getHelpButton$p = this.f70843b.helpButton) == null)) {
                kotlin.coroutines.jvm.internal.a.a(access$getHelpButton$p.performLongClick());
            }
            return Unit.f56620a;
        }
    }

    private ScanFragment() {
        this.jumioViewModel$delegate = FragmentViewModelLazyKt.c(this, Reflection.b(jumio.dui.b.class), new ScanFragment$special$$inlined$activityViewModels$default$1(this), new ScanFragment$special$$inlined$activityViewModels$default$2((d10.a) null, this), new ScanFragment$special$$inlined$activityViewModels$default$3(this));
        this.scanAnimatorSet = new AnimatorSet();
        this.animatedDrawableCallback = new ScanFragment$animatedDrawableCallback$1(this);
        this.scanStepObserver = new s(this);
        this.closeButtonResource = R.drawable.jumio_ic_clear_white;
        this.helpButtonResource = R.drawable.jumio_ic_help;
        this.shutterButtonResource = R.drawable.jumio_shutter_button;
        this.scanUpdateObserver = new u(this);
        this.helpViewObserver = new t(this);
    }

    public /* synthetic */ ScanFragment(r rVar) {
        this();
    }

    private final void attachScanView() {
        JumioScanPart j11;
        CameraScanView cameraScanView;
        CameraScanView cameraScanView2 = this.scanView;
        boolean z11 = false;
        if (!(cameraScanView2 != null && cameraScanView2.isAttached())) {
            JumioFragmentCallback callback = getCallback();
            if (callback != null && callback.validatePermissions()) {
                z11 = true;
            }
            if (z11 && (j11 = getJumioViewModel$jumio_defaultui_release().j()) != null && (cameraScanView = this.scanView) != null) {
                cameraScanView.attach(j11);
            }
        }
    }

    private final void cancelToolTip() {
        n1 n1Var = this.tooltipJob;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.tooltipJob = null;
        ImageButton imageButton = this.helpButton;
        if (imageButton != null) {
            i0.a(imageButton, (CharSequence) null);
        }
    }

    private final int getScanTitleTopMargin() {
        return Math.max((int) (((float) (this.height - this.width)) * 0.25f), getResources().getDimensionPixelSize(R.dimen.jumio_padding_medium) + getResources().getDimensionPixelSize(R.dimen.jumio_ic_clear_width));
    }

    /* access modifiers changed from: private */
    public static final void helpViewObserver$lambda$5(ScanFragment scanFragment, boolean z11) {
        CameraScanView cameraScanView = scanFragment.scanView;
        if (cameraScanView != null) {
            cameraScanView.setExtraction(!z11);
        }
        scanFragment.enableButtons(!z11);
    }

    private final void initObservers() {
        getJumioViewModel$jumio_defaultui_release().f56363k.observe(getViewLifecycleOwner(), this.scanUpdateObserver);
        getJumioViewModel$jumio_defaultui_release().f56362j.observe(getViewLifecycleOwner(), this.scanStepObserver);
        getJumioViewModel$jumio_defaultui_release().f56364l.observe(getViewLifecycleOwner(), this.helpViewObserver);
    }

    public static /* synthetic */ void processingFinished$default(ScanFragment scanFragment, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            scanFragment.processingFinished(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: processingFinished");
    }

    /* access modifiers changed from: private */
    public static final void scanStepObserver$lambda$0(ScanFragment scanFragment, JumioScanStep jumioScanStep) {
        String name = jumioScanStep != null ? jumioScanStep.name() : null;
        JumioCredentialPart f11 = scanFragment.getJumioViewModel$jumio_defaultui_release().f();
        Log.i("ScanFragment", "ScanStep " + name + " received on part " + f11);
        scanFragment.handleScanStep(jumioScanStep);
    }

    /* access modifiers changed from: private */
    public static final void scanUpdateObserver$lambda$4(ScanFragment scanFragment, Pair pair) {
        switch (WhenMappings.$EnumSwitchMapping$1[((JumioScanUpdate) pair.component1()).ordinal()]) {
            case 1:
                scanFragment.handleFallback();
                scanFragment.cancelCurrentAnimations();
                showScanUiElementsIfRequired$default(scanFragment, 0, 1, (Object) null);
                scanFragment.showAndEnableShutterIfRequired();
                if (scanFragment.getJumioViewModel$jumio_defaultui_release().f56360h == JumioFallbackReason.LOW_PERFORMANCE) {
                    scanFragment.showLowPerformanceNotification();
                    scanFragment.getJumioViewModel$jumio_defaultui_release().f56360h = null;
                    return;
                }
                return;
            case 2:
                scanFragment.showAndEnableCameraSwitchIfAvailable();
                return;
            case 3:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressText(scanFragment.getScanModePromptStringResource());
                return;
            case 4:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressText(scanFragment.getString(R.string.jumio_liveness_prompt_no_target));
                return;
            case 5:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressText(scanFragment.getString(R.string.jumio_iproov_failure_generic_angle));
                return;
            case 6:
                scanFragment.cancelCurrentAnimations();
                scanFragment.playHoldStillAnimation();
                scanFragment.setProgressTextWithId(R.string.jumio_id_scan_prompt_hold_still);
                return;
            case 7:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressTextWithId(R.string.jumio_id_scan_prompt_hold_straight);
                return;
            case 8:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressTextWithId(R.string.jumio_id_scan_prompt_move_closer);
                return;
            case 9:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressTextWithId(R.string.jumio_id_scan_prompt_too_close);
                return;
            case 10:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressTextWithId(R.string.jumio_liveness_prompt_too_close);
                return;
            case 11:
                stopHoldStillAnimationIfRunning$default(scanFragment, false, 1, (Object) null);
                scanFragment.setProgressTextWithId(R.string.jumio_liveness_prompt_too_far);
                return;
            default:
                return;
        }
    }

    private final Unit showAndEnableCameraSwitchIfAvailable() {
        ImageButton imageButton = this.cameraSwitchButton;
        if (imageButton == null) {
            return null;
        }
        CameraScanView cameraScanView = this.scanView;
        boolean z11 = true;
        int i11 = 0;
        if (cameraScanView == null || !cameraScanView.getHasMultipleCameras()) {
            z11 = false;
        }
        imageButton.setEnabled(z11);
        if (!imageButton.isEnabled()) {
            i11 = 8;
        }
        imageButton.setVisibility(i11);
        return Unit.f56620a;
    }

    private final void showLowPerformanceNotification() {
        CameraScanView cameraScanView = this.scanView;
        Snackbar make = cameraScanView != null ? Snackbar.make((View) cameraScanView, (CharSequence) getString(R.string.jumio_id_scan_hint_performance_fallback), 0) : null;
        this.notificationSnackbar = make;
        if (make != null) {
            make.show();
        }
    }

    public static /* synthetic */ void showScanUiElementsIfRequired$default(ScanFragment scanFragment, long j11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                j11 = 0;
            }
            scanFragment.showScanUiElementsIfRequired(j11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: showScanUiElementsIfRequired");
    }

    public static /* synthetic */ void stopHoldStillAnimationIfRunning$default(ScanFragment scanFragment, boolean z11, int i11, Object obj) {
        if (obj == null) {
            if ((i11 & 1) != 0) {
                z11 = false;
            }
            scanFragment.stopHoldStillAnimationIfRunning(z11);
            return;
        }
        throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: stopHoldStillAnimationIfRunning");
    }

    /* access modifiers changed from: private */
    public final void updateScanTitleLayout() {
        AppCompatTextView appCompatTextView = this.scanTitle;
        if (appCompatTextView != null) {
            int i11 = this.sidePadding;
            appCompatTextView.setPaddingRelative(i11, 0, i11, 0);
        }
        AppCompatTextView appCompatTextView2 = this.scanTitle;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        ViewGroup.LayoutParams layoutParams = appCompatTextView2 != null ? appCompatTextView2.getLayoutParams() : null;
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
        }
        if (marginLayoutParams != null) {
            marginLayoutParams.topMargin = getScanTitleTopMargin();
        }
    }

    public void cancelCurrentAnimations() {
        n1 n1Var = this.animationJob;
        if (n1Var != null) {
            n1Var.b(new CancellationException("Animation has been cancelled"));
        }
    }

    public View createLayout(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.jumio_fragment_scan, viewGroup, false);
        CameraScanView cameraScanView = (CameraScanView) inflate.findViewById(R.id.scanView);
        getViewLifecycleOwner().getLifecycle().a(cameraScanView);
        this.scanView = cameraScanView;
        ImageButton imageButton = (ImageButton) inflate.findViewById(R.id.btn_help);
        imageButton.setImageResource(getHelpButtonResource());
        imageButton.setOnClickListener(this);
        this.helpButton = imageButton;
        ImageButton imageButton2 = (ImageButton) inflate.findViewById(R.id.btn_switchCamera);
        this.cameraSwitchButton = imageButton2;
        if (imageButton2 != null) {
            imageButton2.setOnClickListener(this);
        }
        this.progressChip = (AppCompatTextView) inflate.findViewById(R.id.progressChip);
        ImageButton imageButton3 = (ImageButton) inflate.findViewById(R.id.btn_shutter);
        imageButton3.setClickable(true);
        imageButton3.setContentDescription(getString(R.string.jumio_accessibility_scan_shutter_button));
        Integer num = (Integer) getJumioViewModel$jumio_defaultui_release().f56353a.f("shutterButtonVisibility");
        imageButton3.setVisibility(num != null ? num.intValue() : 8);
        imageButton3.setImageResource(getShutterButtonResource());
        imageButton3.setOnClickListener(this);
        this.shutterButton = imageButton3;
        this.scanTitle = (AppCompatTextView) inflate.findViewById(R.id.tv_scan_title);
        this.animationScrim = (ImageView) inflate.findViewById(R.id.iv_animation_scrim);
        this.animationIcon = (ImageView) inflate.findViewById(R.id.iv_animation_icon);
        this.plusIcon = (ImageView) inflate.findViewById(R.id.iv_plus_icon);
        this.processingIndicator = (CircularProgressIndicator) inflate.findViewById(R.id.cpi_processing);
        updateScanTitleLayout();
        updateProgressChipPosition(inflate);
        return inflate;
    }

    public final void enableButtons(boolean z11) {
        boolean z12;
        ImageButton imageButton = this.cameraSwitchButton;
        boolean z13 = false;
        if (imageButton != null) {
            if (z11) {
                CameraScanView cameraScanView = this.scanView;
                if (cameraScanView != null && cameraScanView.getHasMultipleCameras()) {
                    z12 = true;
                    imageButton.setEnabled(z12);
                }
            }
            z12 = false;
            imageButton.setEnabled(z12);
        }
        ImageButton imageButton2 = this.shutterButton;
        if (imageButton2 != null) {
            if (z11) {
                CameraScanView cameraScanView2 = this.scanView;
                if (cameraScanView2 != null && cameraScanView2.isShutterEnabled()) {
                    z13 = true;
                }
            }
            imageButton2.setEnabled(z13);
        }
        ImageButton imageButton3 = this.helpButton;
        if (imageButton3 != null) {
            imageButton3.setEnabled(z11);
        }
    }

    public final b getAnimatedDrawable() {
        return this.animatedDrawable;
    }

    public final ImageView getAnimationIcon() {
        return this.animationIcon;
    }

    public final n1 getAnimationJob() {
        return this.animationJob;
    }

    public final ImageView getAnimationScrim() {
        return this.animationScrim;
    }

    public int getCloseButtonResource() {
        return this.closeButtonResource;
    }

    public int getHelpButtonResource() {
        return this.helpButtonResource;
    }

    public final ValueAnimator getHoldStillAnimator() {
        return this.holdStillAnimator;
    }

    public final jumio.dui.b getJumioViewModel$jumio_defaultui_release() {
        return (jumio.dui.b) this.jumioViewModel$delegate.getValue();
    }

    public final ImageView getPlusIcon() {
        return this.plusIcon;
    }

    public final CircularProgressIndicator getProcessingIndicator() {
        return this.processingIndicator;
    }

    public final AppCompatTextView getProgressChip() {
        return this.progressChip;
    }

    public final AnimatorSet getScanAnimatorSet() {
        return this.scanAnimatorSet;
    }

    public final String getScanModePromptStringResource() {
        int i11;
        JumioScanPart j11 = getJumioViewModel$jumio_defaultui_release().j();
        JumioScanMode scanMode = j11 != null ? j11.getScanMode() : null;
        int i12 = scanMode == null ? -1 : WhenMappings.$EnumSwitchMapping$2[scanMode.ordinal()];
        if (i12 == 1) {
            i11 = R.string.jumio_id_scan_prompt_zoom_barcode;
        } else if (i12 == 2) {
            i11 = R.string.jumio_identity_scan_prompt_initial;
        } else if (i12 == 3) {
            i11 = R.string.jumio_liveness_prompt_no_target;
        } else if (i12 != 4) {
            i11 = R.string.jumio_id_scan_prompt_center_id;
        } else {
            i11 = R.string.jumio_id_scan_manual;
        }
        return getString(i11);
    }

    public abstract int getScanTitleStringResource();

    public final CameraScanView getScanView() {
        return this.scanView;
    }

    public int getShutterButtonResource() {
        return this.shutterButtonResource;
    }

    public void handleCanFinish() {
        BaseFragment.fadeAndScaleTo$default(this, this.scanTitle, 4, 0, 0, 6, (Object) null);
        cancelCurrentAnimations();
    }

    public abstract void handleFallback();

    public void handleImageTaken() {
        CameraScanView cameraScanView = this.scanView;
        if (cameraScanView != null) {
            cameraScanView.setExtraction(false);
        }
        this.isHoldStill = false;
        cancelCurrentAnimations();
    }

    public abstract void handleNextPart();

    public void handleProcessing() {
        showProcessingAnimation();
        enableButtons(false);
        cancelToolTip();
    }

    public void handleScanStep(JumioScanStep jumioScanStep) {
        JumioScanPart j11;
        switch (jumioScanStep == null ? -1 : WhenMappings.$EnumSwitchMapping$0[jumioScanStep.ordinal()]) {
            case 1:
                attachScanView();
                return;
            case 2:
                handleStarted();
                return;
            case 3:
                attachScanView();
                handleNextPart();
                return;
            case 4:
                handleProcessing();
                return;
            case 5:
                processingFinished(true);
                return;
            case 6:
                processingFinished(false);
                return;
            case 7:
                FragmentActivity activity = getActivity();
                if (activity != null && (j11 = getJumioViewModel$jumio_defaultui_release().j()) != null) {
                    new JumioActivityAttacher(activity).attach(j11);
                    return;
                }
                return;
            case 8:
                handleImageTaken();
                return;
            case 9:
                handleCanFinish();
                return;
            default:
                return;
        }
    }

    public void handleStarted() {
        attachScanView();
        CameraScanView cameraScanView = this.scanView;
        if (cameraScanView != null) {
            cameraScanView.setExtraction(true);
        }
        setProgressText(getScanModePromptStringResource());
        updateScanTitleTextAndBackground();
    }

    public final void hideHelpButton(boolean z11) {
        ImageButton imageButton = this.helpButton;
        if (imageButton != null) {
            imageButton.setVisibility(z11 ? 8 : 0);
        }
    }

    public final boolean isHoldStill() {
        return this.isHoldStill;
    }

    @SensorsDataInstrumented
    public void onClick(View view) {
        CameraScanView cameraScanView;
        int i11;
        FragmentManager supportFragmentManager;
        JumioBottomSheet<String[]> jumioBottomSheet;
        JumioScanMode jumioScanMode = null;
        Integer valueOf = view != null ? Integer.valueOf(view.getId()) : null;
        int i12 = R.id.btn_help;
        if (valueOf != null && valueOf.intValue() == i12) {
            stopHoldStillAnimationIfRunning(true);
            if (x.b(getJumioViewModel$jumio_defaultui_release().f56365m.getValue(), Boolean.FALSE)) {
                SensorsDataAutoTrackHelper.trackViewOnClick(view);
                return;
            }
            getJumioViewModel$jumio_defaultui_release().f56364l.setValue(Boolean.TRUE);
            JumioScanPart j11 = getJumioViewModel$jumio_defaultui_release().j();
            if (j11 != null) {
                jumioScanMode = j11.getScanMode();
            }
            int i13 = jumioScanMode == null ? -1 : WhenMappings.$EnumSwitchMapping$2[jumioScanMode.ordinal()];
            if (i13 == 1) {
                i11 = R.string.jumio_id_scan_prompt_zoom_barcode;
            } else if (i13 == 2) {
                i11 = R.string.jumio_identity_scan_tips_placing;
            } else if (i13 != 4) {
                i11 = R.string.jumio_id_scan_tips_placing;
            } else {
                i11 = R.string.jumio_id_scan_manual_tips;
            }
            JumioScanPart j12 = getJumioViewModel$jumio_defaultui_release().j();
            String string = j12 != null && j12.getHasFallback() ? getString(R.string.jumio_id_scan_tips_button_fallback) : "";
            ArrayList<Number> g11 = CollectionsKt__CollectionsKt.g(Integer.valueOf(i11), Integer.valueOf(R.string.jumio_id_scan_tips_focusing), Integer.valueOf(R.string.jumio_id_scan_tips_lighting), Integer.valueOf(R.string.jumio_id_scan_tips_glare));
            ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(g11, 10));
            for (Number intValue : g11) {
                arrayList.add(getString(intValue.intValue()));
            }
            this.bottomSheet = HelpViewBottomSheet.Companion.newInstance(getString(R.string.jumio_id_scan_tips_title), (String[]) arrayList.toArray(new String[0]), getString(R.string.jumio_id_scan_tips_button_retry), string);
            FragmentActivity activity = getActivity();
            if (!(activity == null || (supportFragmentManager = activity.getSupportFragmentManager()) == null || (jumioBottomSheet = this.bottomSheet) == null)) {
                jumioBottomSheet.show(supportFragmentManager, "dialog");
            }
        } else {
            int i14 = R.id.btn_switchCamera;
            if (valueOf != null && valueOf.intValue() == i14) {
                CameraScanView cameraScanView2 = this.scanView;
                if (cameraScanView2 != null) {
                    cameraScanView2.switchCamera();
                }
            } else {
                int i15 = R.id.btn_shutter;
                if (!(valueOf == null || valueOf.intValue() != i15 || (cameraScanView = this.scanView) == null)) {
                    cameraScanView.takePicture();
                }
            }
        }
        SensorsDataAutoTrackHelper.trackViewOnClick(view);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewTreeObserver viewTreeObserver;
        int hashCode = hashCode();
        Log.v("ScanFragment", "Scan fragment onViewCreated " + hashCode);
        this.sidePadding = getResources().getDimensionPixelSize(R.dimen.jumio_padding_medium);
        View onCreateView = super.onCreateView(layoutInflater, viewGroup, bundle);
        if (!(onCreateView == null || (viewTreeObserver = onCreateView.getViewTreeObserver()) == null)) {
            viewTreeObserver.addOnGlobalLayoutListener(new ScanFragment$onCreateView$1(onCreateView, this));
        }
        return onCreateView;
    }

    public void onDestroyView() {
        int hashCode = hashCode();
        Log.v("ScanFragment", "Scan fragment onDestroyView " + hashCode);
        cancelCurrentAnimations();
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.setActionBarQuitIcon(R.drawable.jumio_ic_close);
        }
        CameraScanView cameraScanView = this.scanView;
        if (cameraScanView != null) {
            getViewLifecycleOwner().getLifecycle().d(cameraScanView);
            cameraScanView.removeAllViews();
        }
        getJumioViewModel$jumio_defaultui_release().o().removeObserver(this.scanUpdateObserver);
        getJumioViewModel$jumio_defaultui_release().n().removeObserver(this.scanStepObserver);
        getJumioViewModel$jumio_defaultui_release().l().removeObserver(this.helpViewObserver);
        this.scanView = null;
        cancelToolTip();
        Snackbar snackbar = this.notificationSnackbar;
        if (snackbar != null) {
            snackbar.dismiss();
        }
        this.notificationSnackbar = null;
        this.helpButton = null;
        this.cameraSwitchButton = null;
        this.progressChip = null;
        this.bottomSheet = null;
        this.shutterButton = null;
        this.scanTitle = null;
        AlertDialog alertDialog = this.legalDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
        this.legalDialog = null;
        super.onDestroyView();
    }

    public void onPause() {
        super.onPause();
        int hashCode = hashCode();
        Log.v("ScanFragment", "Scan fragment onPause " + hashCode);
    }

    public void onResume() {
        super.onResume();
        int hashCode = hashCode();
        Log.v("ScanFragment", "Scan fragment onResume " + hashCode);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        jumio.dui.b jumioViewModel$jumio_defaultui_release = getJumioViewModel$jumio_defaultui_release();
        ImageButton imageButton = this.shutterButton;
        jumioViewModel$jumio_defaultui_release.f56353a.k("shutterButtonVisibility", Integer.valueOf(imageButton != null ? imageButton.getVisibility() : 8));
    }

    public void onStart() {
        super.onStart();
        int hashCode = hashCode();
        Log.v("ScanFragment", "Scan fragment onStart " + hashCode);
    }

    public void onStop() {
        super.onStop();
        int hashCode = hashCode();
        Log.v("ScanFragment", "Scan fragment onStop " + hashCode);
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        JumioFragmentCallback callback = getCallback();
        if (callback != null) {
            callback.setActionBarQuitIcon(getCloseButtonResource());
        }
        int hashCode = hashCode();
        Log.v("ScanFragment", "Scan fragment onViewCreated " + hashCode);
        initObservers();
    }

    public abstract void playHoldStillAnimation();

    public void processingFinished(boolean z11) {
        cancelCurrentAnimations();
    }

    public final void setAnimatedDrawable(b bVar) {
        this.animatedDrawable = bVar;
    }

    public final void setAnimationIcon(ImageView imageView) {
        this.animationIcon = imageView;
    }

    public final void setAnimationJob(n1 n1Var) {
        this.animationJob = n1Var;
    }

    public final void setAnimationScrim(ImageView imageView) {
        this.animationScrim = imageView;
    }

    public final void setHoldStill(boolean z11) {
        this.isHoldStill = z11;
    }

    public final void setHoldStillAnimator(ValueAnimator valueAnimator) {
        this.holdStillAnimator = valueAnimator;
    }

    public final void setPlusIcon(ImageView imageView) {
        this.plusIcon = imageView;
    }

    public final void setProcessingIndicator(CircularProgressIndicator circularProgressIndicator) {
        this.processingIndicator = circularProgressIndicator;
    }

    public final void setProgressChip(AppCompatTextView appCompatTextView) {
        this.progressChip = appCompatTextView;
    }

    public final void setProgressText(String str) {
        AppCompatTextView appCompatTextView = this.progressChip;
        if (appCompatTextView != null) {
            BaseFragment.fadeAndScaleTo$default(this, appCompatTextView, 0, 0, 0, 2, (Object) null);
            if (str.length() > 0) {
                appCompatTextView.setText(str);
                appCompatTextView.requestFocus();
                appCompatTextView.sendAccessibilityEvent(8);
                appCompatTextView.announceForAccessibility(appCompatTextView.getText());
            }
        }
    }

    public final void setProgressTextWithId(int i11) {
        setProgressText(getString(i11));
    }

    public final void setScanAnimatorSet(AnimatorSet animatorSet) {
        this.scanAnimatorSet = animatorSet;
    }

    public final void setScanView(CameraScanView cameraScanView) {
        this.scanView = cameraScanView;
    }

    public final void setupTooltip() {
        ImageButton imageButton = this.helpButton;
        if (imageButton != null) {
            i0.a(imageButton, getString(R.string.jumio_id_scan_tooltip));
        }
        n1 n1Var = this.tooltipJob;
        if (n1Var != null) {
            n1.a.a(n1Var, (CancellationException) null, 1, (Object) null);
        }
        this.tooltipJob = kotlinx.coroutines.i.d(v.a(getViewLifecycleOwner()), (CoroutineContext) null, (CoroutineStart) null, new a(this, (c<? super a>) null), 3, (Object) null);
    }

    public final void showAndEnableShutterIfRequired() {
        ImageButton imageButton = this.shutterButton;
        int i11 = 8;
        if (imageButton != null) {
            CameraScanView cameraScanView = this.scanView;
            int i12 = 0;
            imageButton.setEnabled(cameraScanView != null ? cameraScanView.isShutterEnabled() : false);
            if (!imageButton.isEnabled()) {
                i12 = 8;
            }
            imageButton.setVisibility(i12);
        }
        jumio.dui.b jumioViewModel$jumio_defaultui_release = getJumioViewModel$jumio_defaultui_release();
        ImageButton imageButton2 = this.shutterButton;
        if (imageButton2 != null) {
            i11 = imageButton2.getVisibility();
        }
        jumioViewModel$jumio_defaultui_release.f56353a.k("shutterButtonVisibility", Integer.valueOf(i11));
    }

    public void showProcessingAnimation() {
        b bVar;
        cancelCurrentAnimations();
        ImageView imageView = this.animationIcon;
        if (imageView != null) {
            BaseFragment.fadeAndScaleTo$default(this, imageView, 0, 0, 0, 6, (Object) null);
        }
        ImageView imageView2 = this.animationScrim;
        if (imageView2 != null) {
            BaseFragment.fadeAndScaleTo$default(this, imageView2, 0, 0, 0, 6, (Object) null);
        }
        Context context = getContext();
        b b11 = context != null ? b.b(context, R.drawable.jumio_ic_circle_animated) : null;
        this.animatedDrawable = b11;
        if (b11 != null) {
            b11.e(this.animatedDrawableCallback);
        }
        ImageView imageView3 = this.animationIcon;
        if (imageView3 != null) {
            imageView3.setImageDrawable(this.animatedDrawable);
        }
        if (DeviceUtilKt.getDeviceUtil().areAnimationsEnabled(getContext()) && (bVar = this.animatedDrawable) != null) {
            bVar.start();
        }
    }

    public void showScanUiElementsIfRequired(long j11) {
        Log.v("ScanFragment", "playScanAnimations with delay " + j11);
    }

    public abstract void stopHoldStillAnimationIfRunning(boolean z11);

    public void updateProgressChipPosition(View view) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003f, code lost:
        if ((r1 != null ? r1.getScanMode() : null) == com.jumio.sdk.enums.JumioScanMode.MANUAL) goto L_0x0041;
     */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0063  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0070  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void updateScanTitleTextAndBackground() {
        /*
            r6 = this;
            int r0 = r6.getScanTitleStringResource()
            jumio.dui.b r1 = r6.getJumioViewModel$jumio_defaultui_release()
            com.jumio.sdk.enums.JumioCredentialPart r1 = r1.f()
            com.jumio.sdk.enums.JumioCredentialPart r2 = com.jumio.sdk.enums.JumioCredentialPart.DOCUMENT
            r3 = 0
            if (r1 == r2) goto L_0x0041
            jumio.dui.b r1 = r6.getJumioViewModel$jumio_defaultui_release()
            com.jumio.sdk.document.JumioDocument r1 = r1.g()
            boolean r2 = r1 instanceof com.jumio.sdk.document.JumioPhysicalDocument
            if (r2 == 0) goto L_0x0020
            com.jumio.sdk.document.JumioPhysicalDocument r1 = (com.jumio.sdk.document.JumioPhysicalDocument) r1
            goto L_0x0021
        L_0x0020:
            r1 = r3
        L_0x0021:
            if (r1 == 0) goto L_0x0028
            com.jumio.sdk.document.JumioDocumentVariant r1 = r1.getVariant()
            goto L_0x0029
        L_0x0028:
            r1 = r3
        L_0x0029:
            com.jumio.sdk.document.JumioDocumentVariant r2 = com.jumio.sdk.document.JumioDocumentVariant.PAPER
            if (r1 != r2) goto L_0x0061
            jumio.dui.b r1 = r6.getJumioViewModel$jumio_defaultui_release()
            com.jumio.sdk.scanpart.JumioScanPart r1 = r1.j()
            if (r1 == 0) goto L_0x003c
            com.jumio.sdk.enums.JumioScanMode r1 = r1.getScanMode()
            goto L_0x003d
        L_0x003c:
            r1 = r3
        L_0x003d:
            com.jumio.sdk.enums.JumioScanMode r2 = com.jumio.sdk.enums.JumioScanMode.MANUAL
            if (r1 != r2) goto L_0x0061
        L_0x0041:
            android.util.TypedValue r1 = new android.util.TypedValue
            r1.<init>()
            android.content.Context r2 = r6.getContext()
            if (r2 == 0) goto L_0x0058
            android.content.res.Resources$Theme r2 = r2.getTheme()
            if (r2 == 0) goto L_0x0058
            int r4 = com.jumio.defaultui.R.attr.jumio_scanview_bubble_background
            r5 = 1
            r2.resolveAttribute(r4, r1, r5)
        L_0x0058:
            androidx.appcompat.widget.AppCompatTextView r2 = r6.scanTitle
            if (r2 == 0) goto L_0x0061
            int r1 = r1.data
            r2.setBackgroundColor(r1)
        L_0x0061:
            if (r0 == 0) goto L_0x0070
            androidx.appcompat.widget.AppCompatTextView r1 = r6.scanTitle
            if (r1 != 0) goto L_0x0068
            goto L_0x0082
        L_0x0068:
            java.lang.String r0 = r6.getString(r0)
            r1.setText(r0)
            goto L_0x0082
        L_0x0070:
            androidx.appcompat.widget.AppCompatTextView r0 = r6.scanTitle
            if (r0 != 0) goto L_0x0075
            goto L_0x007a
        L_0x0075:
            java.lang.String r1 = ""
            r0.setText(r1)
        L_0x007a:
            androidx.appcompat.widget.AppCompatTextView r0 = r6.scanTitle
            if (r0 != 0) goto L_0x007f
            goto L_0x0082
        L_0x007f:
            r0.setBackground(r3)
        L_0x0082:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.ScanFragment.updateScanTitleTextAndBackground():void");
    }
}
