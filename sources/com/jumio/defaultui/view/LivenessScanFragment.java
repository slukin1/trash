package com.jumio.defaultui.view;

import android.os.Bundle;
import android.view.View;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.v;
import com.jumio.defaultui.R;
import com.jumio.sdk.enums.JumioScanMode;
import com.jumio.sdk.scanpart.JumioScanPart;
import d10.p;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.jvm.internal.r;
import kotlin.k;
import kotlinx.coroutines.CoroutineStart;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.i;
import kotlinx.coroutines.n1;

public final class LivenessScanFragment extends ScanFragment {
    private final int closeButtonResource = R.drawable.jumio_ic_close_dark;
    private boolean firstImageTakenSeen;
    private final int helpButtonResource = R.drawable.jumio_ic_help_dark;
    private final int requestedOrientation = 1;
    private final int shutterButtonResource = R.drawable.jumio_shutter_button_dark;

    @d(c = "com.jumio.defaultui.view.LivenessScanFragment$handleProcessing$1", f = "LivenessScanFragment.kt", l = {90}, m = "invokeSuspend")
    public static final class a extends SuspendLambda implements p<h0, c<? super Unit>, Object> {

        /* renamed from: a  reason: collision with root package name */
        public int f70835a;

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ LivenessScanFragment f70836b;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public a(LivenessScanFragment livenessScanFragment, c<? super a> cVar) {
            super(2, cVar);
            this.f70836b = livenessScanFragment;
        }

        public final c<Unit> create(Object obj, c<?> cVar) {
            return new a(this.f70836b, cVar);
        }

        public final Object invoke(Object obj, Object obj2) {
            return ((a) create((h0) obj, (c) obj2)).invokeSuspend(Unit.f56620a);
        }

        public final Object invokeSuspend(Object obj) {
            Object d11 = IntrinsicsKt__IntrinsicsKt.d();
            int i11 = this.f70835a;
            if (i11 == 0) {
                k.b(obj);
                this.f70835a = 1;
                if (DelayKt.b(com.sumsub.sns.internal.ml.autocapture.a.f34923p, this) == d11) {
                    return d11;
                }
            } else if (i11 == 1) {
                k.b(obj);
            } else {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            LivenessScanFragment livenessScanFragment = this.f70836b;
            livenessScanFragment.setProgressText(livenessScanFragment.getResources().getString(R.string.jumio_analyzing_biometric));
            return Unit.f56620a;
        }
    }

    public LivenessScanFragment() {
        super((r) null);
    }

    private final boolean getFallbackHappened() {
        JumioScanPart j11 = getJumioViewModel$jumio_defaultui_release().j();
        return (j11 != null ? j11.getScanMode() : null) == JumioScanMode.FACE_MANUAL;
    }

    public int getCloseButtonResource() {
        return this.closeButtonResource;
    }

    public int getHelpButtonResource() {
        return this.helpButtonResource;
    }

    public Integer getRequestedOrientation() {
        return Integer.valueOf(this.requestedOrientation);
    }

    public int getScanTitleStringResource() {
        return 0;
    }

    public int getShutterButtonResource() {
        return this.shutterButtonResource;
    }

    public void handleFallback() {
        enableButtons(true);
        hideHelpButton(false);
        setProgressText(getString(R.string.jumio_identity_scan_prompt_initial));
    }

    public void handleImageTaken() {
        int i11;
        if (getFallbackHappened()) {
            super.handleImageTaken();
            return;
        }
        if (this.firstImageTakenSeen) {
            i11 = R.string.jumio_id_scan_prompt_capture_success;
        } else {
            i11 = R.string.jumio_liveness_prompt_success_another_shot;
        }
        setProgressText(getResources().getString(i11));
        this.firstImageTakenSeen = true;
    }

    public void handleNextPart() {
    }

    public void handleProcessing() {
        super.handleProcessing();
        n1 unused = i.d(v.a(getViewLifecycleOwner()), (CoroutineContext) null, (CoroutineStart) null, new a(this, (c<? super a>) null), 3, (Object) null);
    }

    public void handleStarted() {
        super.handleStarted();
        this.firstImageTakenSeen = false;
        enableButtons(getFallbackHappened());
        hideHelpButton(!getFallbackHappened());
        showAndEnableShutterIfRequired();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        hideHelpButton(!getFallbackHappened());
    }

    public void playHoldStillAnimation() {
    }

    public void stopHoldStillAnimationIfRunning(boolean z11) {
    }

    public void updateProgressChipPosition(View view) {
        ((Guideline) view.findViewById(R.id.chipGuideline)).setGuidelinePercent(0.3f);
    }
}
