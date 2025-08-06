package com.jumio.defaultui.view;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import androidx.constraintlayout.motion.widget.MotionLayout;
import com.jumio.defaultui.view.LoadingView;
import kotlin.Unit;
import kotlin.jvm.internal.r;

public final class LoadingView$showLoading$1 extends AnimatorListenerAdapter {
    public final /* synthetic */ LoadingView this$0;

    public LoadingView$showLoading$1(LoadingView loadingView) {
        this.this$0 = loadingView;
    }

    private final void reset() {
        Object access$getCurrentStateLock$p = this.this$0.currentStateLock;
        LoadingView loadingView = this.this$0;
        synchronized (access$getCurrentStateLock$p) {
            loadingView.animationState = LoadingView.a.START;
            LoadingView.ViewState viewState = LoadingView.ViewState.STOPPED;
            loadingView.setCurrentState$jumio_defaultui_release(new LoadingView.State(viewState, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null));
            synchronized (loadingView.nextStateLock) {
                loadingView.nextState = new LoadingView.State(viewState, (String) null, (String) null, 0, (View.OnClickListener) null, 30, (r) null);
                Unit unit = Unit.f56620a;
            }
            MotionLayout access$getLoadingViewLayout$p = loadingView.loadingViewLayout;
            if (access$getLoadingViewLayout$p == null) {
                access$getLoadingViewLayout$p = null;
            }
            access$getLoadingViewLayout$p.setTransitionListener((MotionLayout.k) null);
            loadingView.log("transition listener was reset with state " + loadingView.getCurrentState$jumio_defaultui_release().getViewState().name() + " to null");
        }
    }

    public void onAnimationEnd(Animator animator) {
        super.onAnimationEnd(animator);
        if (!this.this$0.isShowing()) {
            if (this.this$0.isActive) {
                this.this$0.isActive = false;
                this.this$0.log("isActive false onAnimationEnd");
                this.this$0.log("animationState reset to start");
                reset();
            }
            this.this$0.loadingViewContainer.setVisibility(4);
        }
    }

    public void onAnimationStart(Animator animator) {
        super.onAnimationStart(animator);
        this.this$0.loadingViewContainer.setVisibility(0);
        this.this$0.log("onAnimationStart: loadingViewContainer shown and transitioning to end");
    }
}
