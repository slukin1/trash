package com.jumio.defaultui.view;

import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.dynamicanimation.animation.SpringForce;
import androidx.dynamicanimation.animation.b;
import androidx.dynamicanimation.animation.c;
import com.google.android.material.button.MaterialButton;
import com.jumio.commons.log.Log;
import com.jumio.core.util.DeviceUtilKt;
import com.jumio.defaultui.R;
import com.jumio.sdk.error.JumioError;
import java.io.Serializable;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;

public final class LoadingView implements MotionLayout.k {
    /* access modifiers changed from: private */
    public a animationState = a.START;
    private AnimatorSet animatorSet = new AnimatorSet();
    private final boolean areAnimationsEnabled;
    private final Context context;
    private State currentState;
    /* access modifiers changed from: private */
    public final Object currentStateLock;
    private AppCompatTextView description;
    /* access modifiers changed from: private */
    public boolean isActive;
    private boolean isShowing;
    private ImageView ivLoadingGradient;
    private ImageView ivLoadingIcon;
    private ImageView ivLoadingPlain;
    /* access modifiers changed from: private */
    public final FrameLayout loadingViewContainer;
    /* access modifiers changed from: private */
    public MotionLayout loadingViewLayout;
    /* access modifiers changed from: private */
    public State nextState;
    /* access modifiers changed from: private */
    public final Object nextStateLock;
    private boolean pause = true;
    private MaterialButton retryButton;
    private TextView title;

    public static final class ErrorState extends State {
        private final int buttonTextId;
        private final JumioError error;

        public ErrorState(JumioError jumioError, String str, View.OnClickListener onClickListener) {
            super(ViewState.ERROR, str, (String) null, 0, onClickListener, 12, (r) null);
            int i11;
            this.error = jumioError;
            boolean z11 = true;
            if ((jumioError == null || !jumioError.isRetryable()) ? false : z11) {
                i11 = R.string.jumio_button_retry;
            } else {
                i11 = R.string.jumio_button_cancel;
            }
            this.buttonTextId = i11;
        }

        public int getButtonTextId() {
            return this.buttonTextId;
        }

        public final JumioError getError() {
            return this.error;
        }
    }

    public enum ViewState {
        STOPPED,
        PROGRESS,
        SUCCESS,
        ERROR
    }

    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        /* JADX WARNING: Can't wrap try/catch for region: R(16:0|(2:1|2)|3|5|6|7|8|9|10|11|13|14|15|16|17|19) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0037 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0019 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0022 */
        static {
            /*
                com.jumio.defaultui.view.LoadingView$ViewState[] r0 = com.jumio.defaultui.view.LoadingView.ViewState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r1 = 1
                com.jumio.defaultui.view.LoadingView$ViewState r2 = com.jumio.defaultui.view.LoadingView.ViewState.PROGRESS     // Catch:{ NoSuchFieldError -> 0x0010 }
                int r2 = r2.ordinal()     // Catch:{ NoSuchFieldError -> 0x0010 }
                r0[r2] = r1     // Catch:{ NoSuchFieldError -> 0x0010 }
            L_0x0010:
                r2 = 2
                com.jumio.defaultui.view.LoadingView$ViewState r3 = com.jumio.defaultui.view.LoadingView.ViewState.ERROR     // Catch:{ NoSuchFieldError -> 0x0019 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0019 }
                r0[r3] = r2     // Catch:{ NoSuchFieldError -> 0x0019 }
            L_0x0019:
                com.jumio.defaultui.view.LoadingView$ViewState r3 = com.jumio.defaultui.view.LoadingView.ViewState.SUCCESS     // Catch:{ NoSuchFieldError -> 0x0022 }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x0022 }
                r4 = 3
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x0022 }
            L_0x0022:
                com.jumio.defaultui.view.LoadingView$ViewState r3 = com.jumio.defaultui.view.LoadingView.ViewState.STOPPED     // Catch:{ NoSuchFieldError -> 0x002b }
                int r3 = r3.ordinal()     // Catch:{ NoSuchFieldError -> 0x002b }
                r4 = 4
                r0[r3] = r4     // Catch:{ NoSuchFieldError -> 0x002b }
            L_0x002b:
                $EnumSwitchMapping$0 = r0
                com.jumio.defaultui.view.LoadingView$a[] r0 = com.jumio.defaultui.view.LoadingView.a.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                r3 = 0
                r0[r3] = r1     // Catch:{ NoSuchFieldError -> 0x0037 }
            L_0x0037:
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0039 }
            L_0x0039:
                $EnumSwitchMapping$1 = r0
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.LoadingView.WhenMappings.<clinit>():void");
        }
    }

    public enum a {
        START,
        END
    }

    public LoadingView(Context context2, FrameLayout frameLayout) {
        ViewState viewState;
        this.context = context2;
        this.loadingViewContainer = frameLayout;
        Object obj = new Object();
        this.nextStateLock = obj;
        Object obj2 = new Object();
        this.currentStateLock = obj2;
        this.areAnimationsEnabled = DeviceUtilKt.getDeviceUtil().areAnimationsEnabled(context2);
        inflateLayout();
        synchronized (obj2) {
            viewState = ViewState.STOPPED;
            this.currentState = new State(viewState, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null);
            Unit unit = Unit.f56620a;
        }
        synchronized (obj) {
            this.nextState = new State(viewState, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null);
        }
    }

    private final void animateLoadingIcon() {
        SpringForce springForce = new SpringForce(1.0f);
        springForce.d(0.3f);
        ImageView imageView = this.ivLoadingIcon;
        ImageView imageView2 = null;
        if (imageView == null) {
            imageView = null;
        }
        c cVar = new c(imageView, b.f9343p);
        ImageView imageView3 = this.ivLoadingIcon;
        if (imageView3 == null) {
            imageView3 = null;
        }
        c cVar2 = new c(imageView3, b.f9344q);
        cVar.u(springForce);
        ((c) cVar.l(0.0f)).m();
        cVar2.u(springForce);
        ((c) cVar2.l(0.0f)).m();
        ImageView imageView4 = this.ivLoadingIcon;
        if (imageView4 != null) {
            imageView2 = imageView4;
        }
        imageView2.setAlpha(1.0f);
    }

    public static /* synthetic */ void hide$default(LoadingView loadingView, AnimatorListenerAdapter animatorListenerAdapter, int i11, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            animatorListenerAdapter = null;
        }
        if ((i12 & 2) != 0) {
            i11 = 300;
        }
        if ((i12 & 4) != 0) {
            j11 = 0;
        }
        loadingView.hide(animatorListenerAdapter, i11, j11);
    }

    private final void inflateLayout() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.jumio_loading_view, this.loadingViewContainer, false);
        MotionLayout motionLayout = (MotionLayout) inflate.findViewById(R.id.ml_loading_view);
        this.loadingViewLayout = motionLayout;
        MotionLayout motionLayout2 = null;
        if (motionLayout == null) {
            motionLayout = null;
        }
        this.title = (AppCompatTextView) motionLayout.findViewById(R.id.tv_loading_title);
        MotionLayout motionLayout3 = this.loadingViewLayout;
        if (motionLayout3 == null) {
            motionLayout3 = null;
        }
        this.description = (AppCompatTextView) motionLayout3.findViewById(R.id.tv_loading_description);
        MotionLayout motionLayout4 = this.loadingViewLayout;
        if (motionLayout4 == null) {
            motionLayout4 = null;
        }
        this.ivLoadingGradient = (ImageView) motionLayout4.findViewById(R.id.iv_loading_gradient);
        MotionLayout motionLayout5 = this.loadingViewLayout;
        if (motionLayout5 == null) {
            motionLayout5 = null;
        }
        this.ivLoadingPlain = (ImageView) motionLayout5.findViewById(R.id.iv_loading_plain);
        MotionLayout motionLayout6 = this.loadingViewLayout;
        if (motionLayout6 == null) {
            motionLayout6 = null;
        }
        this.ivLoadingIcon = (ImageView) motionLayout6.findViewById(R.id.iv_loading_icon);
        MotionLayout motionLayout7 = this.loadingViewLayout;
        if (motionLayout7 != null) {
            motionLayout2 = motionLayout7;
        }
        this.retryButton = (MaterialButton) motionLayout2.findViewById(R.id.btn_retry);
        this.loadingViewContainer.addView(inflate);
    }

    /* access modifiers changed from: private */
    public final void log(String str) {
        Log.i("LoadingView", str);
    }

    private final void reverseTransition() {
        int ordinal = this.animationState.ordinal();
        MotionLayout motionLayout = null;
        if (ordinal == 0) {
            this.animationState = a.END;
            MotionLayout motionLayout2 = this.loadingViewLayout;
            if (motionLayout2 != null) {
                motionLayout = motionLayout2;
            }
            motionLayout.o0(R.id.progress_start, R.id.progress_end);
        } else if (ordinal == 1) {
            this.animationState = a.START;
            MotionLayout motionLayout3 = this.loadingViewLayout;
            if (motionLayout3 != null) {
                motionLayout = motionLayout3;
            }
            motionLayout.o0(R.id.progress_end, R.id.progress_start);
        } else {
            throw new NoWhenBranchMatchedException();
        }
    }

    public static /* synthetic */ void show$default(LoadingView loadingView, AnimatorListenerAdapter animatorListenerAdapter, int i11, long j11, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            animatorListenerAdapter = null;
        }
        if ((i12 & 2) != 0) {
            i11 = 300;
        }
        if ((i12 & 4) != 0) {
            j11 = 0;
        }
        loadingView.show(animatorListenerAdapter, i11, j11);
    }

    private final void showLoading(boolean z11, AnimatorListenerAdapter animatorListenerAdapter, int i11, long j11) {
        if (this.isShowing != z11) {
            this.isShowing = z11;
            MotionLayout motionLayout = this.loadingViewLayout;
            MotionLayout motionLayout2 = null;
            if (motionLayout == null) {
                motionLayout = null;
            }
            float f11 = 1.0f;
            motionLayout.setTranslationY(1.0f);
            MotionLayout motionLayout3 = this.loadingViewLayout;
            if (motionLayout3 != null) {
                motionLayout2 = motionLayout3;
            }
            float[] fArr = new float[2];
            fArr[0] = z11 ? 0.0f : 1.0f;
            if (!z11) {
                f11 = 0.0f;
            }
            fArr[1] = f11;
            ObjectAnimator ofFloat = ObjectAnimator.ofFloat(motionLayout2, "alpha", fArr);
            ofFloat.setDuration((long) i11);
            ofFloat.setInterpolator(new AccelerateDecelerateInterpolator());
            this.animatorSet.end();
            AnimatorSet animatorSet2 = new AnimatorSet();
            this.animatorSet = animatorSet2;
            animatorSet2.setupStartValues();
            this.animatorSet.play(ofFloat);
            if (animatorListenerAdapter != null) {
                this.animatorSet.addListener(animatorListenerAdapter);
            }
            this.animatorSet.addListener(new LoadingView$showLoading$1(this));
            this.animatorSet.setStartDelay(j11);
            this.animatorSet.start();
        }
    }

    public static /* synthetic */ void showLoading$default(LoadingView loadingView, boolean z11, AnimatorListenerAdapter animatorListenerAdapter, int i11, long j11, int i12, Object obj) {
        if ((i12 & 4) != 0) {
            i11 = 300;
        }
        int i13 = i11;
        if ((i12 & 8) != 0) {
            j11 = 0;
        }
        loadingView.showLoading(z11, animatorListenerAdapter, i13, j11);
    }

    private final void startExecution() {
        synchronized (this.currentStateLock) {
            if (!this.isActive && !this.pause) {
                this.isActive = true;
                log("isActive true update");
                MotionLayout motionLayout = this.loadingViewLayout;
                MotionLayout motionLayout2 = null;
                if (motionLayout == null) {
                    motionLayout = null;
                }
                motionLayout.setTransitionListener(this);
                log("transition listener was set with state " + this.nextState.getViewState());
                if (updateState()) {
                    MotionLayout motionLayout3 = this.loadingViewLayout;
                    if (motionLayout3 != null) {
                        motionLayout2 = motionLayout3;
                    }
                    motionLayout2.s0();
                } else {
                    MotionLayout motionLayout4 = this.loadingViewLayout;
                    if (motionLayout4 != null) {
                        motionLayout2 = motionLayout4;
                    }
                    onTransitionCompleted(motionLayout2, 0);
                }
            }
            Unit unit = Unit.f56620a;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x001b, code lost:
        updateUi();
        r1 = r5.title;
        r2 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0021, code lost:
        if (r1 != null) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0023, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0024, code lost:
        r1.sendAccessibilityEvent(8);
        r1 = r5.title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002b, code lost:
        if (r1 != null) goto L_0x002e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x002d, code lost:
        r1 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x002e, code lost:
        r3 = r5.title;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0030, code lost:
        if (r3 != null) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x0032, code lost:
        r3 = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0033, code lost:
        r1.announceForAccessibility(r3.getText());
        r1 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$0[r5.currentState.getViewState().ordinal()];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        if (r1 == 1) goto L_0x0080;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x004c, code lost:
        if (r1 == 2) goto L_0x0069;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x004f, code lost:
        if (r1 == 3) goto L_0x0052;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0052, code lost:
        r1 = r5.loadingViewLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0054, code lost:
        if (r1 != null) goto L_0x0057;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x0057, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x005c, code lost:
        if (r5.animationState != com.jumio.defaultui.view.LoadingView.a.f70837a) goto L_0x0061;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x005e, code lost:
        r1 = com.jumio.defaultui.R.id.progress_start;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0061, code lost:
        r1 = com.jumio.defaultui.R.id.progress_end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0063, code lost:
        r2.o0(r1, com.jumio.defaultui.R.id.success);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0069, code lost:
        r1 = r5.loadingViewLayout;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x006b, code lost:
        if (r1 != null) goto L_0x006e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006e, code lost:
        r2 = r1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0073, code lost:
        if (r5.animationState != com.jumio.defaultui.view.LoadingView.a.f70837a) goto L_0x0078;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0075, code lost:
        r1 = com.jumio.defaultui.R.id.progress_start;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0078, code lost:
        r1 = com.jumio.defaultui.R.id.progress_end;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x007a, code lost:
        r2.o0(r1, com.jumio.defaultui.R.id.error);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:0x0080, code lost:
        reverseTransition();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0084, code lost:
        return true;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean updateState() {
        /*
            r5 = this;
            java.lang.Object r0 = r5.currentStateLock
            monitor-enter(r0)
            java.lang.Object r1 = r5.nextStateLock     // Catch:{ all -> 0x0088 }
            monitor-enter(r1)     // Catch:{ all -> 0x0088 }
            com.jumio.defaultui.view.LoadingView$State r2 = r5.currentState     // Catch:{ all -> 0x0085 }
            com.jumio.defaultui.view.LoadingView$State r3 = r5.nextState     // Catch:{ all -> 0x0085 }
            boolean r2 = kotlin.jvm.internal.x.b(r2, r3)     // Catch:{ all -> 0x0085 }
            if (r2 == 0) goto L_0x0014
            r2 = 0
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            monitor-exit(r0)
            return r2
        L_0x0014:
            com.jumio.defaultui.view.LoadingView$State r2 = r5.nextState     // Catch:{ all -> 0x0085 }
            r5.currentState = r2     // Catch:{ all -> 0x0085 }
            kotlin.Unit r2 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0085 }
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            r5.updateUi()     // Catch:{ all -> 0x0088 }
            android.widget.TextView r1 = r5.title     // Catch:{ all -> 0x0088 }
            r2 = 0
            if (r1 != 0) goto L_0x0024
            r1 = r2
        L_0x0024:
            r3 = 8
            r1.sendAccessibilityEvent(r3)     // Catch:{ all -> 0x0088 }
            android.widget.TextView r1 = r5.title     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x002e
            r1 = r2
        L_0x002e:
            android.widget.TextView r3 = r5.title     // Catch:{ all -> 0x0088 }
            if (r3 != 0) goto L_0x0033
            r3 = r2
        L_0x0033:
            java.lang.CharSequence r3 = r3.getText()     // Catch:{ all -> 0x0088 }
            r1.announceForAccessibility(r3)     // Catch:{ all -> 0x0088 }
            com.jumio.defaultui.view.LoadingView$State r1 = r5.currentState     // Catch:{ all -> 0x0088 }
            com.jumio.defaultui.view.LoadingView$ViewState r1 = r1.getViewState()     // Catch:{ all -> 0x0088 }
            int[] r3 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x0088 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0088 }
            r1 = r3[r1]     // Catch:{ all -> 0x0088 }
            r3 = 1
            if (r1 == r3) goto L_0x0080
            r4 = 2
            if (r1 == r4) goto L_0x0069
            r4 = 3
            if (r1 == r4) goto L_0x0052
            goto L_0x0083
        L_0x0052:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r5.loadingViewLayout     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x0057
            goto L_0x0058
        L_0x0057:
            r2 = r1
        L_0x0058:
            com.jumio.defaultui.view.LoadingView$a r1 = r5.animationState     // Catch:{ all -> 0x0088 }
            com.jumio.defaultui.view.LoadingView$a r4 = com.jumio.defaultui.view.LoadingView.a.START     // Catch:{ all -> 0x0088 }
            if (r1 != r4) goto L_0x0061
            int r1 = com.jumio.defaultui.R.id.progress_start     // Catch:{ all -> 0x0088 }
            goto L_0x0063
        L_0x0061:
            int r1 = com.jumio.defaultui.R.id.progress_end     // Catch:{ all -> 0x0088 }
        L_0x0063:
            int r4 = com.jumio.defaultui.R.id.success     // Catch:{ all -> 0x0088 }
            r2.o0(r1, r4)     // Catch:{ all -> 0x0088 }
            goto L_0x0083
        L_0x0069:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r5.loadingViewLayout     // Catch:{ all -> 0x0088 }
            if (r1 != 0) goto L_0x006e
            goto L_0x006f
        L_0x006e:
            r2 = r1
        L_0x006f:
            com.jumio.defaultui.view.LoadingView$a r1 = r5.animationState     // Catch:{ all -> 0x0088 }
            com.jumio.defaultui.view.LoadingView$a r4 = com.jumio.defaultui.view.LoadingView.a.START     // Catch:{ all -> 0x0088 }
            if (r1 != r4) goto L_0x0078
            int r1 = com.jumio.defaultui.R.id.progress_start     // Catch:{ all -> 0x0088 }
            goto L_0x007a
        L_0x0078:
            int r1 = com.jumio.defaultui.R.id.progress_end     // Catch:{ all -> 0x0088 }
        L_0x007a:
            int r4 = com.jumio.defaultui.R.id.error     // Catch:{ all -> 0x0088 }
            r2.o0(r1, r4)     // Catch:{ all -> 0x0088 }
            goto L_0x0083
        L_0x0080:
            r5.reverseTransition()     // Catch:{ all -> 0x0088 }
        L_0x0083:
            monitor-exit(r0)
            return r3
        L_0x0085:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0088 }
            throw r2     // Catch:{ all -> 0x0088 }
        L_0x0088:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.LoadingView.updateState():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0071  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:65:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:74:0x010b  */
    /* JADX WARNING: Removed duplicated region for block: B:77:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0119  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x011a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void updateUi() {
        /*
            r6 = this;
            java.lang.Object r0 = r6.currentStateLock
            monitor-enter(r0)
            android.widget.TextView r1 = r6.title     // Catch:{ all -> 0x0148 }
            r2 = 0
            if (r1 != 0) goto L_0x0009
            r1 = r2
        L_0x0009:
            com.jumio.defaultui.view.LoadingView$State r3 = r6.currentState     // Catch:{ all -> 0x0148 }
            java.lang.String r3 = r3.getTitleText()     // Catch:{ all -> 0x0148 }
            java.lang.CharSequence r3 = jumio.dui.a.a(r3)     // Catch:{ all -> 0x0148 }
            r1.setText(r3)     // Catch:{ all -> 0x0148 }
            androidx.appcompat.widget.AppCompatTextView r1 = r6.description     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x001b
            r1 = r2
        L_0x001b:
            com.jumio.defaultui.view.LoadingView$State r3 = r6.currentState     // Catch:{ all -> 0x0148 }
            boolean r4 = r3 instanceof com.jumio.defaultui.view.LoadingView.ErrorState     // Catch:{ all -> 0x0148 }
            if (r4 == 0) goto L_0x0024
            com.jumio.defaultui.view.LoadingView$ErrorState r3 = (com.jumio.defaultui.view.LoadingView.ErrorState) r3     // Catch:{ all -> 0x0148 }
            goto L_0x0025
        L_0x0024:
            r3 = r2
        L_0x0025:
            if (r3 == 0) goto L_0x0051
            com.jumio.sdk.error.JumioError r3 = r3.getError()     // Catch:{ all -> 0x0148 }
            if (r3 == 0) goto L_0x0051
            java.lang.String r4 = r3.getMessage()     // Catch:{ all -> 0x0148 }
            java.lang.String r3 = r3.getCode()     // Catch:{ all -> 0x0148 }
            java.lang.StringBuilder r5 = new java.lang.StringBuilder     // Catch:{ all -> 0x0148 }
            r5.<init>()     // Catch:{ all -> 0x0148 }
            r5.append(r4)     // Catch:{ all -> 0x0148 }
            java.lang.String r4 = "\n("
            r5.append(r4)     // Catch:{ all -> 0x0148 }
            r5.append(r3)     // Catch:{ all -> 0x0148 }
            java.lang.String r3 = ")"
            r5.append(r3)     // Catch:{ all -> 0x0148 }
            java.lang.String r3 = r5.toString()     // Catch:{ all -> 0x0148 }
            if (r3 == 0) goto L_0x0051
            goto L_0x005b
        L_0x0051:
            com.jumio.defaultui.view.LoadingView$State r3 = r6.currentState     // Catch:{ all -> 0x0148 }
            java.lang.String r3 = r3.getDescriptionText()     // Catch:{ all -> 0x0148 }
            java.lang.CharSequence r3 = jumio.dui.a.a(r3)     // Catch:{ all -> 0x0148 }
        L_0x005b:
            r1.setText(r3)     // Catch:{ all -> 0x0148 }
            com.jumio.defaultui.view.LoadingView$State r1 = r6.currentState     // Catch:{ all -> 0x0148 }
            com.jumio.defaultui.view.LoadingView$ViewState r1 = r1.getViewState()     // Catch:{ all -> 0x0148 }
            int[] r3 = com.jumio.defaultui.view.LoadingView.WhenMappings.$EnumSwitchMapping$0     // Catch:{ all -> 0x0148 }
            int r1 = r1.ordinal()     // Catch:{ all -> 0x0148 }
            r1 = r3[r1]     // Catch:{ all -> 0x0148 }
            r3 = 2
            r4 = 1065353216(0x3f800000, float:1.0)
            if (r1 == r3) goto L_0x00c7
            r3 = 3
            if (r1 == r3) goto L_0x00aa
            android.widget.ImageView r1 = r6.ivLoadingGradient     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x0079
            r1 = r2
        L_0x0079:
            int r3 = com.jumio.defaultui.R.drawable.jumio_ic_loading_gradient     // Catch:{ all -> 0x0148 }
            r1.setImageResource(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingPlain     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x0083
            r1 = r2
        L_0x0083:
            int r3 = com.jumio.defaultui.R.drawable.jumio_ic_loading_plain     // Catch:{ all -> 0x0148 }
            r1.setImageResource(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingIcon     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x008d
            r1 = r2
        L_0x008d:
            r3 = 0
            r1.setAlpha(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingIcon     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x0096
            r1 = r2
        L_0x0096:
            r1.setScaleX(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingIcon     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x009e
            r1 = r2
        L_0x009e:
            r1.setScaleY(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingPlain     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00a6
            r1 = r2
        L_0x00a6:
            r1.setTranslationY(r3)     // Catch:{ all -> 0x0148 }
            goto L_0x00e3
        L_0x00aa:
            android.widget.ImageView r1 = r6.ivLoadingGradient     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00af
            r1 = r2
        L_0x00af:
            int r3 = com.jumio.defaultui.R.drawable.jumio_ic_loading_gradient     // Catch:{ all -> 0x0148 }
            r1.setImageResource(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingPlain     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00b9
            r1 = r2
        L_0x00b9:
            int r3 = com.jumio.defaultui.R.drawable.jumio_ic_loading_plain     // Catch:{ all -> 0x0148 }
            r1.setImageResource(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingIcon     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00c3
            r1 = r2
        L_0x00c3:
            r1.setAlpha(r4)     // Catch:{ all -> 0x0148 }
            goto L_0x00e3
        L_0x00c7:
            android.widget.ImageView r1 = r6.ivLoadingGradient     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00cc
            r1 = r2
        L_0x00cc:
            int r3 = com.jumio.defaultui.R.drawable.jumio_ic_loading_gradient_error     // Catch:{ all -> 0x0148 }
            r1.setImageResource(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingPlain     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00d6
            r1 = r2
        L_0x00d6:
            int r3 = com.jumio.defaultui.R.drawable.jumio_ic_error_plain     // Catch:{ all -> 0x0148 }
            r1.setImageResource(r3)     // Catch:{ all -> 0x0148 }
            android.widget.ImageView r1 = r6.ivLoadingIcon     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00e0
            r1 = r2
        L_0x00e0:
            r1.setAlpha(r4)     // Catch:{ all -> 0x0148 }
        L_0x00e3:
            com.jumio.defaultui.view.LoadingView$State r1 = r6.currentState     // Catch:{ all -> 0x0148 }
            int r1 = r1.getButtonTextId()     // Catch:{ all -> 0x0148 }
            if (r1 == 0) goto L_0x0107
            com.google.android.material.button.MaterialButton r1 = r6.retryButton     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00f0
            r1 = r2
        L_0x00f0:
            com.jumio.defaultui.view.LoadingView$State r3 = r6.currentState     // Catch:{ all -> 0x0148 }
            int r3 = r3.getButtonTextId()     // Catch:{ all -> 0x0148 }
            r1.setText(r3)     // Catch:{ all -> 0x0148 }
            com.google.android.material.button.MaterialButton r1 = r6.retryButton     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x00fe
            r1 = r2
        L_0x00fe:
            com.jumio.defaultui.view.LoadingView$State r3 = r6.currentState     // Catch:{ all -> 0x0148 }
            android.view.View$OnClickListener r3 = r3.getButtonOnClickListener()     // Catch:{ all -> 0x0148 }
            r1.setOnClickListener(r3)     // Catch:{ all -> 0x0148 }
        L_0x0107:
            androidx.constraintlayout.motion.widget.MotionLayout r1 = r6.loadingViewLayout     // Catch:{ all -> 0x0148 }
            if (r1 != 0) goto L_0x010c
            r1 = r2
        L_0x010c:
            android.widget.TextView r3 = r6.title     // Catch:{ all -> 0x0148 }
            if (r3 != 0) goto L_0x0111
            r3 = r2
        L_0x0111:
            java.lang.CharSequence r3 = r3.getText()     // Catch:{ all -> 0x0148 }
            androidx.appcompat.widget.AppCompatTextView r4 = r6.description     // Catch:{ all -> 0x0148 }
            if (r4 != 0) goto L_0x011a
            goto L_0x011b
        L_0x011a:
            r2 = r4
        L_0x011b:
            java.lang.CharSequence r2 = r2.getText()     // Catch:{ all -> 0x0148 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0148 }
            r4.<init>()     // Catch:{ all -> 0x0148 }
            java.lang.String r5 = "\n\t\t\t"
            r4.append(r5)     // Catch:{ all -> 0x0148 }
            r4.append(r3)     // Catch:{ all -> 0x0148 }
            java.lang.String r3 = "\n\t\t\t"
            r4.append(r3)     // Catch:{ all -> 0x0148 }
            r4.append(r2)     // Catch:{ all -> 0x0148 }
            java.lang.String r2 = "\n\t\t\t"
            r4.append(r2)     // Catch:{ all -> 0x0148 }
            java.lang.String r2 = r4.toString()     // Catch:{ all -> 0x0148 }
            java.lang.String r2 = kotlin.text.StringsKt__IndentKt.f(r2)     // Catch:{ all -> 0x0148 }
            r1.setContentDescription(r2)     // Catch:{ all -> 0x0148 }
            kotlin.Unit r1 = kotlin.Unit.f56620a     // Catch:{ all -> 0x0148 }
            monitor-exit(r0)
            return
        L_0x0148:
            r1 = move-exception
            monitor-exit(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.defaultui.view.LoadingView.updateUi():void");
    }

    public final State getCurrentState$jumio_defaultui_release() {
        return this.currentState;
    }

    public final boolean getPause() {
        return this.pause;
    }

    public final ViewState getViewState() {
        ViewState viewState;
        synchronized (this.nextStateLock) {
            viewState = this.nextState.getViewState();
        }
        return viewState;
    }

    public final synchronized void hide(AnimatorListenerAdapter animatorListenerAdapter, int i11, long j11) {
        showLoading(false, animatorListenerAdapter, i11, j11);
    }

    public final boolean isShowing() {
        return this.isShowing;
    }

    public void onTransitionChange(MotionLayout motionLayout, int i11, int i12, float f11) {
    }

    public void onTransitionCompleted(MotionLayout motionLayout, int i11) {
        synchronized (this.currentStateLock) {
            log("onTransitionCompleted ; state: " + this.currentState.getViewState().name() + " ; and animationState: " + this.animationState.name() + " ; isActive: " + this.isActive);
            if (this.isActive) {
                int i12 = WhenMappings.$EnumSwitchMapping$0[this.currentState.getViewState().ordinal()];
                MotionLayout motionLayout2 = null;
                if (i12 == 1) {
                    reverseTransition();
                } else if (i12 == 2) {
                    this.isActive = false;
                    log("isActive false onTransitionComplete ERROR");
                    MaterialButton materialButton = this.retryButton;
                    if (materialButton == null) {
                        materialButton = null;
                    }
                    materialButton.setEnabled(true);
                    animateLoadingIcon();
                } else if (i12 == 3) {
                    this.isActive = false;
                    log("isActive false onTransitionComplete SUCCESS");
                    animateLoadingIcon();
                } else if (i12 == 4) {
                    this.isActive = false;
                    log("isActive false onTransitionComplete STOPPED");
                }
                updateState();
                if (this.isActive && this.areAnimationsEnabled) {
                    log("after transition completion state: " + this.currentState.getViewState().name() + " ; and animationState: " + this.animationState.name() + ", animation still active");
                    MotionLayout motionLayout3 = this.loadingViewLayout;
                    if (motionLayout3 != null) {
                        motionLayout2 = motionLayout3;
                    }
                    motionLayout2.s0();
                }
                Unit unit = Unit.f56620a;
            }
        }
    }

    public void onTransitionStarted(MotionLayout motionLayout, int i11, int i12) {
        synchronized (this.currentStateLock) {
            String name = this.currentState.getViewState().name();
            String name2 = this.animationState.name();
            boolean z11 = this.isActive;
            log("onTransitionStarted ; state: " + name + " ; and animationState: " + name2 + " ; isActive: " + z11);
            Unit unit = Unit.f56620a;
        }
    }

    public void onTransitionTrigger(MotionLayout motionLayout, int i11, boolean z11, float f11) {
        synchronized (this.currentStateLock) {
            String name = this.currentState.getViewState().name();
            boolean z12 = this.isActive;
            log("onTransitionTriggered ; state: " + name + " ; isActive: " + z12);
            Unit unit = Unit.f56620a;
        }
    }

    public final void setCurrentState$jumio_defaultui_release(State state) {
        this.currentState = state;
    }

    public final void setPause(boolean z11) {
        this.pause = z11;
        if (!z11 && this.nextState.getViewState() != ViewState.STOPPED && this.areAnimationsEnabled) {
            startExecution();
        }
    }

    public final synchronized void show(AnimatorListenerAdapter animatorListenerAdapter, int i11, long j11) {
        showLoading(true, animatorListenerAdapter, i11, j11);
    }

    public final synchronized void update(State state) {
        log("update called with state " + state.getViewState() + ", current state is " + this.currentState.getViewState());
        synchronized (this.currentStateLock) {
            int i11 = WhenMappings.$EnumSwitchMapping$0[state.getViewState().ordinal()];
            MotionLayout motionLayout = null;
            if (i11 == 1) {
                MaterialButton materialButton = this.retryButton;
                if (materialButton == null) {
                    materialButton = null;
                }
                materialButton.setEnabled(false);
                MaterialButton materialButton2 = this.retryButton;
                if (materialButton2 == null) {
                    materialButton2 = null;
                }
                materialButton2.setAlpha(0.0f);
            } else if (i11 == 2) {
                MaterialButton materialButton3 = this.retryButton;
                if (materialButton3 == null) {
                    materialButton3 = null;
                }
                materialButton3.setEnabled(true);
                ImageView imageView = this.ivLoadingIcon;
                if (imageView == null) {
                    imageView = null;
                }
                imageView.setImageResource(R.drawable.jumio_ic_loading_exclamation);
            } else if (i11 == 3) {
                ImageView imageView2 = this.ivLoadingIcon;
                if (imageView2 == null) {
                    imageView2 = null;
                }
                imageView2.setImageResource(R.drawable.jumio_ic_loading_checkmark);
            }
            synchronized (this.nextStateLock) {
                this.nextState = state;
                Unit unit = Unit.f56620a;
            }
            if (this.areAnimationsEnabled) {
                startExecution();
            } else {
                updateState();
                MotionLayout motionLayout2 = this.loadingViewLayout;
                if (motionLayout2 != null) {
                    motionLayout = motionLayout2;
                }
                onTransitionCompleted(motionLayout, 0);
            }
        }
    }

    public static class State implements Serializable {
        private final transient View.OnClickListener buttonOnClickListener;
        private final int buttonTextId;
        private String descriptionText;
        private final String titleText;
        private final ViewState viewState;

        public State(ViewState viewState2, String str, String str2, int i11, View.OnClickListener onClickListener) {
            this.viewState = viewState2;
            this.titleText = str;
            this.descriptionText = str2;
            this.buttonTextId = i11;
            this.buttonOnClickListener = onClickListener;
        }

        public boolean equals(Object obj) {
            if (obj instanceof State) {
                State state = (State) obj;
                return this.viewState == state.viewState && x.b(this.titleText, state.titleText) && x.b(this.descriptionText, state.descriptionText) && getButtonTextId() == state.getButtonTextId();
            }
        }

        public final View.OnClickListener getButtonOnClickListener() {
            return this.buttonOnClickListener;
        }

        public int getButtonTextId() {
            return this.buttonTextId;
        }

        public final String getDescriptionText() {
            return this.descriptionText;
        }

        public final String getTitleText() {
            return this.titleText;
        }

        public final ViewState getViewState() {
            return this.viewState;
        }

        public int hashCode() {
            int hashCode = this.titleText.hashCode();
            int buttonTextId2 = (getButtonTextId() + ((this.descriptionText.hashCode() + ((hashCode + (this.viewState.hashCode() * 31)) * 31)) * 31)) * 31;
            View.OnClickListener onClickListener = this.buttonOnClickListener;
            return buttonTextId2 + (onClickListener != null ? onClickListener.hashCode() : 0);
        }

        public final void setDescriptionText(String str) {
            this.descriptionText = str;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ State(ViewState viewState2, String str, String str2, int i11, View.OnClickListener onClickListener, int i12, r rVar) {
            this(viewState2, (i12 & 2) != 0 ? "" : str, (i12 & 4) != 0 ? "" : str2, (i12 & 8) != 0 ? 0 : i11, (i12 & 16) != 0 ? null : onClickListener);
        }
    }
}
