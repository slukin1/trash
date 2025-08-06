package com.facebook.stetho.inspector.elements.android;

import android.annotation.TargetApi;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.View;
import android.view.ViewGroup;

abstract class ViewHighlightOverlays {

    public static class NoOpViewHighlightOverlays extends ViewHighlightOverlays {
        private NoOpViewHighlightOverlays() {
        }

        public void highlightView(View view, Rect rect, int i11) {
        }

        public void removeHighlight(View view) {
        }
    }

    public static ViewHighlightOverlays newInstance() {
        if (Build.VERSION.SDK_INT >= 18) {
            return new ViewHighlightOverlaysJellybeanMR2();
        }
        return new NoOpViewHighlightOverlays();
    }

    public abstract void highlightView(View view, Rect rect, int i11);

    public abstract void removeHighlight(View view);

    @TargetApi(18)
    public static class ViewHighlightOverlaysJellybeanMR2 extends ViewHighlightOverlays {
        private static final int MARGIN_OVERLAY_COLOR = -1426797922;
        private static final int PADDING_OVERLAY_COLOR = -1430332746;
        private final HighlightDrawable[] mHighlightDrawables;
        private final MainHighlightDrawable mMainHighlightDrawable;

        public static class MainHighlightDrawable extends HighlightDrawable {
            public void draw(Canvas canvas) {
                Rect clipBounds = canvas.getClipBounds();
                Rect rect = this.mMargins;
                clipBounds.inset(-(rect.right + rect.left), -(rect.top + rect.bottom));
                if (Build.VERSION.SDK_INT < 26) {
                    canvas.clipRect(clipBounds, Region.Op.REPLACE);
                } else {
                    canvas.clipOutRect(clipBounds);
                }
                super.draw(canvas);
            }

            public void highlightView(View view) {
                super.highlightView(view);
            }
        }

        public static class MarginBottomHighlightDrawable extends HighlightDrawable {
            public MarginBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate(0.0f, (float) (rect.bottom + rect.top));
                super.draw(canvas);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, view.getHeight() - this.mMargins.bottom, view.getWidth(), view.getHeight());
            }
        }

        public static class MarginLeftHighlightDrawable extends HighlightDrawable {
            public MarginLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate((float) (-(rect.left + rect.right)), 0.0f);
                super.draw(canvas);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                int i11 = this.mMargins.left;
                int height = view.getHeight();
                Rect rect = this.mMargins;
                setBounds(0, 0, i11, height + rect.top + rect.bottom);
            }
        }

        public static class MarginRightHighlightDrawable extends HighlightDrawable {
            public MarginRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            public void draw(Canvas canvas) {
                Rect rect = this.mMargins;
                canvas.translate((float) rect.right, (float) (-(rect.top + rect.bottom)));
                super.draw(canvas);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                int width = view.getWidth() - this.mMargins.right;
                int width2 = view.getWidth();
                int height = view.getHeight();
                Rect rect = this.mMargins;
                setBounds(width, 0, width2, height + rect.top + rect.bottom);
            }
        }

        public static class MarginTopHighlightDrawable extends HighlightDrawable {
            public MarginTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.MARGIN_OVERLAY_COLOR);
            }

            public void draw(Canvas canvas) {
                canvas.translate(0.0f, (float) (-this.mMargins.top));
                super.draw(canvas);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, view.getWidth(), this.mMargins.top);
            }
        }

        public static class PaddingBottomHighlightDrawable extends HighlightDrawable {
            public PaddingBottomHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(this.mPaddings.left, view.getHeight() - this.mPaddings.bottom, view.getWidth() - this.mPaddings.right, view.getHeight());
            }
        }

        public static class PaddingLeftHighlightDrawable extends HighlightDrawable {
            public PaddingLeftHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(0, 0, this.mPaddings.left, view.getHeight());
            }
        }

        public static class PaddingRightHighlightDrawable extends HighlightDrawable {
            public PaddingRightHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                setBounds(view.getWidth() - this.mPaddings.right, 0, view.getWidth(), view.getHeight());
            }
        }

        public static class PaddingTopHighlightDrawable extends HighlightDrawable {
            public PaddingTopHighlightDrawable() {
                super(ViewHighlightOverlaysJellybeanMR2.PADDING_OVERLAY_COLOR);
            }

            public void highlightView(View view) {
                super.highlightView(view);
                int i11 = this.mPaddings.left;
                int width = view.getWidth();
                Rect rect = this.mPaddings;
                setBounds(i11, 0, width - rect.right, rect.top);
            }
        }

        public ViewHighlightOverlaysJellybeanMR2() {
            MainHighlightDrawable mainHighlightDrawable = new MainHighlightDrawable();
            this.mMainHighlightDrawable = mainHighlightDrawable;
            this.mHighlightDrawables = new HighlightDrawable[]{mainHighlightDrawable, new PaddingTopHighlightDrawable(), new PaddingBottomHighlightDrawable(), new PaddingRightHighlightDrawable(), new PaddingLeftHighlightDrawable(), new MarginTopHighlightDrawable(), new MarginBottomHighlightDrawable(), new MarginRightHighlightDrawable(), new MarginLeftHighlightDrawable()};
        }

        public void highlightView(View view, Rect rect, int i11) {
            this.mMainHighlightDrawable.setColor(i11);
            if (rect.isEmpty()) {
                this.mMainHighlightDrawable.setBounds(0, 0, view.getWidth(), view.getHeight());
            } else {
                this.mMainHighlightDrawable.setBounds(rect);
            }
            for (HighlightDrawable highlightDrawable : this.mHighlightDrawables) {
                highlightDrawable.highlightView(view);
                view.getOverlay().add(highlightDrawable);
            }
        }

        public void removeHighlight(View view) {
            for (HighlightDrawable remove : this.mHighlightDrawables) {
                view.getOverlay().remove(remove);
            }
        }

        public static abstract class HighlightDrawable extends ColorDrawable {
            public final Rect mMargins = new Rect();
            public final Rect mPaddings = new Rect();

            public HighlightDrawable(int i11) {
                super(i11);
            }

            public void highlightView(View view) {
                ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    Rect rect = this.mMargins;
                    rect.left = marginLayoutParams.leftMargin;
                    rect.top = marginLayoutParams.topMargin;
                    rect.right = marginLayoutParams.rightMargin;
                    rect.bottom = marginLayoutParams.bottomMargin;
                } else {
                    Rect rect2 = this.mMargins;
                    rect2.left = 0;
                    rect2.top = 0;
                    rect2.right = 0;
                    rect2.bottom = 0;
                }
                this.mPaddings.left = view.getPaddingLeft();
                this.mPaddings.top = view.getPaddingTop();
                this.mPaddings.right = view.getPaddingRight();
                this.mPaddings.bottom = view.getPaddingBottom();
            }

            public HighlightDrawable() {
            }
        }
    }
}
