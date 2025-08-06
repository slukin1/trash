package com.huochat.community.listener;

import androidx.recyclerview.widget.RecyclerView;
import kotlin.jvm.internal.r;

public final class OnHideScrollListener extends RecyclerView.OnScrollListener {
    public static final Companion Companion = new Companion((r) null);
    public static final int THRESHOLD = 20;
    private int distance;
    private OnFloatHideListener hideListener;
    private boolean isVisible = true;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public OnHideScrollListener(OnFloatHideListener onFloatHideListener) {
        this.hideListener = onFloatHideListener;
    }

    public final OnFloatHideListener getHideListener() {
        return this.hideListener;
    }

    public void onScrolled(RecyclerView recyclerView, int i11, int i12) {
        super.onScrolled(recyclerView, i11, i12);
        int i13 = this.distance;
        if (i13 > 20 && this.isVisible) {
            this.isVisible = false;
            this.hideListener.onHide();
            this.distance = 0;
        } else if (i13 < -20 && !this.isVisible) {
            this.isVisible = true;
            this.hideListener.onShow();
            this.distance = 0;
        }
        boolean z11 = this.isVisible;
        if ((z11 && i12 > 0) || (!z11 && i12 < 0)) {
            this.distance += i12;
        }
    }

    public final void setHideListener(OnFloatHideListener onFloatHideListener) {
        this.hideListener = onFloatHideListener;
    }
}
