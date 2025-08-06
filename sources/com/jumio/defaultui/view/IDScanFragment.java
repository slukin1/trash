package com.jumio.defaultui.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import androidx.lifecycle.v;
import androidx.vectordrawable.graphics.drawable.b;
import com.google.android.material.progressindicator.CircularProgressIndicator;
import com.jumio.core.views.CameraScanView;
import com.jumio.defaultui.R;
import com.jumio.sdk.enums.JumioCredentialPart;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.scanpart.JumioScanPart;
import d10.p;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;
import pw.l;

public final class IDScanFragment extends ScanFragment {

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(23:0|(2:1|2)|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Can't wrap try/catch for region: R(24:0|1|2|3|(2:5|6)|7|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|27) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x002a */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0032 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x003b */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0044 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x004d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0056 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x005f */
        static {
            /*
                com.jumio.sdk.enums.JumioScanMode[] r0 = com.jumio.sdk.enums.JumioScanMode.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.sdk.enums.JumioScanMode r2 = com.jumio.sdk.enums.JumioScanMode.DOCFINDER     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.sdk.enums.JumioScanMode r3 = com.jumio.sdk.enums.JumioScanMode.BARCODE     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                $EnumSwitchMapping$0 = r0
                com.jumio.sdk.enums.JumioCredentialPart[] r0 = com.jumio.sdk.enums.JumioCredentialPart.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                com.jumio.sdk.enums.JumioCredentialPart r3 = com.jumio.sdk.enums.JumioCredentialPart.FRONT     // Catch:{ NoSuchFieldError -> 0x002a }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002a }
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x002a }
            L_0x002a:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.BACK     // Catch:{ NoSuchFieldError -> 0x0032 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0032 }
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0032 }
            L_0x0032:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.DOCUMENT     // Catch:{ NoSuchFieldError -> 0x003b }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003b }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003b }
            L_0x003b:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.DIGITAL     // Catch:{ NoSuchFieldError -> 0x0044 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0044 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0044 }
            L_0x0044:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.DEVICE_RISK     // Catch:{ NoSuchFieldError -> 0x004d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x004d }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x004d }
            L_0x004d:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.FACE     // Catch:{ NoSuchFieldError -> 0x0056 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0056 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0056 }
            L_0x0056:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.MULTIPART     // Catch:{ NoSuchFieldError -> 0x005f }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x005f }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x005f }
            L_0x005f:
                com.jumio.sdk.enums.JumioCredentialPart r1 = com.jumio.sdk.enums.JumioCredentialPart.NFC     // Catch:{ NoSuchFieldError -> 0x0069 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0069 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0069 }
            L_0x0069:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.IDScanFragment.WhenMappings.<clinit>():void");
        }
    }

    @d(c = "com.jumio.defaultui.view.IDScanFragment$startRotateIndicatorAnimation$1", f = "IDScanFragment.kt", l = {233}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f70828a;

        /* renamed from: b  reason: collision with root package name */
        public /* synthetic */ Object f70829b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ IDScanFragment f70830c;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(IDScanFragment iDScanFragment, c<? super a> cVar) {
            super(2, cVar);
            this.f70830c = iDScanFragment;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            a aVar = new a(this.f70830c, cVar);
            aVar.f70829b = obj;
            return aVar;
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
        }

        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v7, resolved type: java.lang.Object} */
        /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: kotlinx.coroutines.h0} */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt__IntrinsicsKt.d()
                int r1 = r5.f70828a
                r2 = 1
                if (r1 == 0) goto L_0x001b
                if (r1 != r2) goto L_0x0013
                java.lang.Object r1 = r5.f70829b
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
                kotlin.k.b(r6)
                goto L_0x0023
            L_0x0013:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L_0x001b:
                kotlin.k.b(r6)
                java.lang.Object r6 = r5.f70829b
                r1 = r6
                kotlinx.coroutines.h0 r1 = (kotlinx.coroutines.h0) r1
            L_0x0023:
                boolean r6 = kotlinx.coroutines.i0.i(r1)
                if (r6 == 0) goto L_0x005b
                com.jumio.defaultui.view.IDScanFragment r6 = r5.f70830c
                android.widget.ImageView r6 = r6.getAnimationIcon()
                if (r6 == 0) goto L_0x004e
                android.view.ViewPropertyAnimator r6 = r6.animate()
                if (r6 == 0) goto L_0x004e
                r3 = 1114636288(0x42700000, float:60.0)
                r6.rotationBy(r3)
                r3 = 800(0x320, double:3.953E-321)
                r6.setStartDelay(r3)
                r3 = 300(0x12c, double:1.48E-321)
                r6.setDuration(r3)
                android.view.animation.AccelerateDecelerateInterpolator r3 = new android.view.animation.AccelerateDecelerateInterpolator
                r3.<init>()
                r6.setInterpolator(r3)
            L_0x004e:
                r5.f70829b = r1
                r5.f70828a = r2
                r3 = 1500(0x5dc, double:7.41E-321)
                java.lang.Object r6 = kotlinx.coroutines.DelayKt.b(r3, r5)
                if (r6 != r0) goto L_0x0023
                return r0
            L_0x005b:
                kotlin.Unit r6 = kotlin.Unit.f56620a
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.IDScanFragment.a.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    public IDScanFragment() {
        super((r) null);
    }

    private final void flipCardAndHide() {
        ObjectAnimator ofFloat = ObjectAnimator.ofFloat(getAnimationIcon(), View.ALPHA, new float[]{0.0f, 1.0f});
        ofFloat.setDuration(50);
        ofFloat.setStartDelay(500);
        ofFloat.addListener(new IDScanFragment$flipCardAndHide$$inlined$doOnStart$1(this));
        ObjectAnimator ofFloat2 = ObjectAnimator.ofFloat(getAnimationIcon(), View.ROTATION_Y, new float[]{0.0f, -180.0f});
        ofFloat2.setDuration(1200);
        ofFloat2.setStartDelay(com.sumsub.sns.internal.ml.autocapture.a.f34923p);
        ObjectAnimator ofFloat3 = ObjectAnimator.ofFloat(getAnimationIcon(), View.ALPHA, new float[]{1.0f, 1.0f});
        ofFloat3.setDuration(100);
        ofFloat3.setStartDelay(2000);
        ofFloat3.addListener(new IDScanFragment$flipCardAndHide$lambda$18$$inlined$doOnEnd$1(this));
        ObjectAnimator ofFloat4 = ObjectAnimator.ofFloat(getAnimationIcon(), View.ALPHA, new float[]{1.0f, 0.0f});
        ofFloat4.setStartDelay(com.sumsub.sns.internal.ml.autocapture.a.f34923p);
        ofFloat4.setDuration(400);
        ofFloat4.addListener(new IDScanFragment$flipCardAndHide$$inlined$doOnEnd$1(this));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.play(ofFloat).with(ofFloat2);
        animatorSet.play(ofFloat2).with(ofFloat3);
        animatorSet.play(ofFloat4).after(ofFloat2);
        animatorSet.start();
        setScanAnimatorSet(animatorSet);
    }

    /* access modifiers changed from: private */
    public static final void playHoldStillAnimation$lambda$10$lambda$9(IDScanFragment iDScanFragment, ValueAnimator valueAnimator) {
        CircularProgressIndicator processingIndicator = iDScanFragment.getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setProgress(((Integer) valueAnimator.getAnimatedValue()).intValue());
        }
    }

    private final void setProcessingTrackColor() {
        Resources.Theme theme;
        TypedValue typedValue = new TypedValue();
        Context context = getContext();
        if (!(context == null || (theme = context.getTheme()) == null)) {
            theme.resolveAttribute(R.attr.jumio_scanview_foreground, typedValue, true);
        }
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setTrackColor(t0.c.j(typedValue.data, 102));
        }
    }

    private final n1 startRotateIndicatorAnimation() {
        return i.d(v.a(getViewLifecycleOwner()), (CoroutineContext) null, (CoroutineStart) null, new a(this, (c<? super a>) null), 3, (Object) null);
    }

    public void cancelCurrentAnimations() {
        AnimatorSet scanAnimatorSet = getScanAnimatorSet();
        scanAnimatorSet.end();
        scanAnimatorSet.removeAllListeners();
        for (Animator animator : scanAnimatorSet.getChildAnimations()) {
            animator.cancel();
            animator.removeAllListeners();
            ValueAnimator valueAnimator = animator instanceof ValueAnimator ? (ValueAnimator) animator : null;
            if (valueAnimator != null) {
                valueAnimator.removeAllUpdateListeners();
            }
        }
        ImageView animationIcon = getAnimationIcon();
        if (animationIcon != null) {
            animationIcon.setRotation(0.0f);
            animationIcon.setRotationY(0.0f);
            animationIcon.clearAnimation();
        }
        super.cancelCurrentAnimations();
    }

    public int getScanTitleStringResource() {
        JumioCredentialPart f11 = getJumioViewModel$jumio_defaultui_release().f();
        if (f11 == null) {
            return 0;
        }
        JumioScanMode jumioScanMode = null;
        switch (WhenMappings.$EnumSwitchMapping$1[f11.ordinal()]) {
            case 1:
                JumioScanPart j11 = getJumioViewModel$jumio_defaultui_release().j();
                if (j11 != null) {
                    jumioScanMode = j11.getScanMode();
                }
                if (jumioScanMode == JumioScanMode.MANUAL) {
                    return R.string.jumio_id_scan_guide_photo_side_manually;
                }
                return R.string.jumio_id_scan_guide_photo_side;
            case 2:
                JumioScanPart j12 = getJumioViewModel$jumio_defaultui_release().j();
                if (j12 != null) {
                    jumioScanMode = j12.getScanMode();
                }
                if (jumioScanMode == JumioScanMode.MANUAL) {
                    return R.string.jumio_id_scan_guide_back_side_manually;
                }
                return R.string.jumio_id_scan_guide_back_side;
            case 3:
                return R.string.jumio_id_scan_manual;
            case 4:
            case 5:
            case 6:
            case 7:
            case 8:
                return 0;
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    public void handleCanFinish() {
        super.handleCanFinish();
        BaseFragment.fadeAndScaleTo$default(this, getProgressChip(), 0, 0, 0, 6, (Object) null);
        setProgressTextWithId(R.string.jumio_id_scan_prompt_capture_success);
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setAlpha(0.0f);
        }
        ImageView animationIcon = getAnimationIcon();
        if (animationIcon != null) {
            animationIcon.setImageResource(R.drawable.jumio_ic_green_checkmark);
            BaseFragment.fadeAndScaleTo$default(this, animationIcon, 0, 0, 0, 6, (Object) null);
        }
        ImageView animationScrim = getAnimationScrim();
        if (animationScrim != null) {
            BaseFragment.fadeAndScaleTo$default(this, animationScrim, 4, 0, 0, 6, (Object) null);
        }
        ImageView plusIcon = getPlusIcon();
        if (plusIcon != null) {
            BaseFragment.fadeAndScaleTo$default(this, plusIcon, 4, 0, 0, 6, (Object) null);
        }
    }

    public void handleFallback() {
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setAlpha(0.0f);
        }
        setProgressText(getScanModePromptStringResource());
        updateScanTitleTextAndBackground();
    }

    public void handleImageTaken() {
        super.handleImageTaken();
        ImageView plusIcon = getPlusIcon();
        if (plusIcon != null) {
            BaseFragment.fadeAndScaleTo$default(this, plusIcon, 4, 0, 0, 6, (Object) null);
        }
        if (getJumioViewModel$jumio_defaultui_release().f() == JumioCredentialPart.FRONT) {
            setProgressTextWithId(R.string.jumio_id_scan_prompt_front_captured);
        } else if (getJumioViewModel$jumio_defaultui_release().f() == JumioCredentialPart.BACK) {
            setProgressTextWithId(R.string.jumio_id_scan_prompt_back_captured);
        }
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setProgress(100);
        }
    }

    public void handleNextPart() {
        CameraScanView scanView = getScanView();
        if (scanView != null) {
            scanView.setExtraction(false);
        }
        showAndEnableShutterIfRequired();
        cancelCurrentAnimations();
        flipCardAndHide();
    }

    public void handleProcessing() {
        super.handleProcessing();
        setProgressTextWithId(R.string.jumio_id_scan_prompt_processing);
    }

    public void handleStarted() {
        super.handleStarted();
        setProcessingTrackColor();
        if (getJumioViewModel$jumio_defaultui_release().j() != null) {
            ScanFragment.showScanUiElementsIfRequired$default(this, 0, 1, (Object) null);
            showAndEnableShutterIfRequired();
            enableButtons(true);
            setupTooltip();
        }
    }

    public void onDestroyView() {
        ValueAnimator holdStillAnimator = getHoldStillAnimator();
        if (holdStillAnimator != null) {
            holdStillAnimator.removeAllUpdateListeners();
        }
        setHoldStillAnimator((ValueAnimator) null);
        setAnimationScrim((ImageView) null);
        b animatedDrawable = getAnimatedDrawable();
        if (animatedDrawable != null) {
            animatedDrawable.a();
        }
        setAnimatedDrawable((b) null);
        setAnimationIcon((ImageView) null);
        setPlusIcon((ImageView) null);
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setIndeterminate(true);
        }
        setProcessingIndicator((CircularProgressIndicator) null);
        getJumioViewModel$jumio_defaultui_release().f56365m.setValue(Boolean.TRUE);
        super.onDestroyView();
    }

    public void playHoldStillAnimation() {
        setHoldStill(true);
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setIndeterminate(false);
            processingIndicator.setAlpha(1.0f);
        }
        ValueAnimator ofInt = ValueAnimator.ofInt(new int[]{0, 100});
        if (ofInt != null) {
            ofInt.setDuration(1550);
            ofInt.addListener(new IDScanFragment$playHoldStillAnimation$lambda$10$$inlined$doOnStart$1(this));
            ofInt.addListener(new IDScanFragment$playHoldStillAnimation$lambda$10$$inlined$doOnStart$2(this));
            ofInt.addUpdateListener(new l(this));
        } else {
            ofInt = null;
        }
        setHoldStillAnimator(ofInt);
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playSequentially(new Animator[]{getHoldStillAnimator()});
        animatorSet.start();
        setScanAnimatorSet(animatorSet);
    }

    public void processingFinished(boolean z11) {
        super.processingFinished(z11);
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setAlpha(0.0f);
        }
        CircularProgressIndicator processingIndicator2 = getProcessingIndicator();
        if (processingIndicator2 != null) {
            processingIndicator2.setIndeterminate(true);
        }
        ImageView animationIcon = getAnimationIcon();
        if (animationIcon != null) {
            animationIcon.setImageResource(R.drawable.jumio_ic_green_checkmark);
        }
        ImageView animationIcon2 = getAnimationIcon();
        if (animationIcon2 != null) {
            BaseFragment.fadeAndScaleTo$default(this, animationIcon2, z11 ? 0 : 4, 0, 0, 6, (Object) null);
        }
        ImageView plusIcon = getPlusIcon();
        if (plusIcon != null) {
            BaseFragment.fadeAndScaleTo$default(this, plusIcon, 4, 0, 0, 6, (Object) null);
        }
        ImageView animationScrim = getAnimationScrim();
        if (animationScrim != null) {
            BaseFragment.fadeAndScaleTo$default(this, animationScrim, 4, 0, 0, 6, (Object) null);
        }
    }

    public void showProcessingAnimation() {
        CircularProgressIndicator processingIndicator = getProcessingIndicator();
        if (processingIndicator != null) {
            processingIndicator.setAlpha(0.0f);
        }
        ImageView plusIcon = getPlusIcon();
        if (plusIcon != null) {
            BaseFragment.fadeAndScaleTo$default(this, plusIcon, 4, 0, 0, 6, (Object) null);
        }
        super.showProcessingAnimation();
    }

    public void showScanUiElementsIfRequired(long j11) {
        super.showScanUiElementsIfRequired(j11);
        JumioScanPart j12 = getJumioViewModel$jumio_defaultui_release().j();
        JumioScanMode scanMode = j12 != null ? j12.getScanMode() : null;
        int i11 = scanMode == null ? -1 : WhenMappings.$EnumSwitchMapping$0[scanMode.ordinal()];
        if (i11 == 1 || i11 == 2) {
            cancelCurrentAnimations();
            for (View fadeAndScaleTo$default : CollectionsKt__CollectionsKt.n(getProgressChip(), getAnimationIcon(), getPlusIcon(), getAnimationScrim())) {
                BaseFragment.fadeAndScaleTo$default(this, fadeAndScaleTo$default, 0, 0, j11, 2, (Object) null);
            }
            ImageView animationIcon = getAnimationIcon();
            if (animationIcon != null) {
                animationIcon.setImageResource(R.drawable.jumio_ic_scan_indicator);
            }
            ImageView animationScrim = getAnimationScrim();
            if (animationScrim != null) {
                animationScrim.setImageResource(R.drawable.jumio_ic_scrim_circle);
            }
            setAnimationJob(startRotateIndicatorAnimation());
            return;
        }
        for (View fadeAndScaleTo$default2 : CollectionsKt__CollectionsKt.n(getProgressChip(), getAnimationIcon(), getPlusIcon(), getAnimationScrim())) {
            BaseFragment.fadeAndScaleTo$default(this, fadeAndScaleTo$default2, 4, 0, j11, 2, (Object) null);
        }
    }

    public void stopHoldStillAnimationIfRunning(boolean z11) {
        if (isHoldStill()) {
            setHoldStill(false);
            CircularProgressIndicator processingIndicator = getProcessingIndicator();
            if (processingIndicator != null) {
                processingIndicator.setAlpha(0.0f);
            }
            ScanFragment.showScanUiElementsIfRequired$default(this, 0, 1, (Object) null);
            if (z11) {
                setProgressText(getScanModePromptStringResource());
            }
        }
    }
}
