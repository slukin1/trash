package com.google.android.material.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.core.view.h0;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;

class ViewOverlayApi14 implements ViewOverlayImpl {
    public OverlayViewGroup overlayViewGroup;

    public ViewOverlayApi14(Context context, ViewGroup viewGroup, View view) {
        this.overlayViewGroup = new OverlayViewGroup(context, viewGroup, view, this);
    }

    public static ViewOverlayApi14 createFrom(View view) {
        ViewGroup contentView = ViewUtils.getContentView(view);
        if (contentView == null) {
            return null;
        }
        int childCount = contentView.getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            View childAt = contentView.getChildAt(i11);
            if (childAt instanceof OverlayViewGroup) {
                return ((OverlayViewGroup) childAt).viewOverlay;
            }
        }
        return new ViewGroupOverlayApi14(contentView.getContext(), contentView, view);
    }

    public void add(Drawable drawable) {
        this.overlayViewGroup.add(drawable);
    }

    public void remove(Drawable drawable) {
        this.overlayViewGroup.remove(drawable);
    }

    @SuppressLint({"ViewConstructor", "PrivateApi"})
    public static class OverlayViewGroup extends ViewGroup {
        public static Method invalidateChildInParentFastMethod;
        private boolean disposed;
        public ArrayList<Drawable> drawables = null;
        public ViewGroup hostView;
        public View requestingView;
        public ViewOverlayApi14 viewOverlay;

        static {
            Class<ViewGroup> cls = ViewGroup.class;
            try {
                Class cls2 = Integer.TYPE;
                invalidateChildInParentFastMethod = cls.getDeclaredMethod("invalidateChildInParentFast", new Class[]{cls2, cls2, Rect.class});
            } catch (NoSuchMethodException unused) {
            }
        }

        public OverlayViewGroup(Context context, ViewGroup viewGroup, View view, ViewOverlayApi14 viewOverlayApi14) {
            super(context);
            this.hostView = viewGroup;
            this.requestingView = view;
            setRight(viewGroup.getWidth());
            setBottom(viewGroup.getHeight());
            viewGroup.addView(this);
            this.viewOverlay = viewOverlayApi14;
        }

        private void assertNotDisposed() {
            if (this.disposed) {
                throw new IllegalStateException("This overlay was disposed already. Please use a new one via ViewGroupUtils.getOverlay()");
            }
        }

        private void disposeIfEmpty() {
            if (getChildCount() == 0) {
                ArrayList<Drawable> arrayList = this.drawables;
                if (arrayList == null || arrayList.size() == 0) {
                    this.disposed = true;
                    this.hostView.removeView(this);
                }
            }
        }

        private void getOffset(int[] iArr) {
            int[] iArr2 = new int[2];
            int[] iArr3 = new int[2];
            this.hostView.getLocationOnScreen(iArr2);
            this.requestingView.getLocationOnScreen(iArr3);
            iArr[0] = iArr3[0] - iArr2[0];
            iArr[1] = iArr3[1] - iArr2[1];
        }

        public void add(Drawable drawable) {
            assertNotDisposed();
            if (this.drawables == null) {
                this.drawables = new ArrayList<>();
            }
            if (!this.drawables.contains(drawable)) {
                this.drawables.add(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback(this);
            }
        }

        public void dispatchDraw(Canvas canvas) {
            int[] iArr = new int[2];
            int[] iArr2 = new int[2];
            this.hostView.getLocationOnScreen(iArr);
            this.requestingView.getLocationOnScreen(iArr2);
            canvas.translate((float) (iArr2[0] - iArr[0]), (float) (iArr2[1] - iArr[1]));
            canvas.clipRect(new Rect(0, 0, this.requestingView.getWidth(), this.requestingView.getHeight()));
            super.dispatchDraw(canvas);
            ArrayList<Drawable> arrayList = this.drawables;
            int size = arrayList == null ? 0 : arrayList.size();
            for (int i11 = 0; i11 < size; i11++) {
                this.drawables.get(i11).draw(canvas);
            }
        }

        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            return false;
        }

        public ViewParent invalidateChildInParent(int[] iArr, Rect rect) {
            if (this.hostView == null) {
                return null;
            }
            rect.offset(iArr[0], iArr[1]);
            if (this.hostView != null) {
                iArr[0] = 0;
                iArr[1] = 0;
                int[] iArr2 = new int[2];
                getOffset(iArr2);
                rect.offset(iArr2[0], iArr2[1]);
                return super.invalidateChildInParent(iArr, rect);
            }
            invalidate(rect);
            return null;
        }

        public ViewParent invalidateChildInParentFast(int i11, int i12, Rect rect) {
            if (this.hostView == null || invalidateChildInParentFastMethod == null) {
                return null;
            }
            try {
                getOffset(new int[2]);
                invalidateChildInParentFastMethod.invoke(this.hostView, new Object[]{Integer.valueOf(i11), Integer.valueOf(i12), rect});
                return null;
            } catch (IllegalAccessException e11) {
                e11.printStackTrace();
                return null;
            } catch (InvocationTargetException e12) {
                e12.printStackTrace();
                return null;
            }
        }

        public void invalidateDrawable(Drawable drawable) {
            invalidate(drawable.getBounds());
        }

        public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        }

        public void remove(Drawable drawable) {
            ArrayList<Drawable> arrayList = this.drawables;
            if (arrayList != null) {
                arrayList.remove(drawable);
                invalidate(drawable.getBounds());
                drawable.setCallback((Drawable.Callback) null);
                disposeIfEmpty();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:2:0x0006, code lost:
            r0 = r1.drawables;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean verifyDrawable(android.graphics.drawable.Drawable r2) {
            /*
                r1 = this;
                boolean r0 = super.verifyDrawable(r2)
                if (r0 != 0) goto L_0x0013
                java.util.ArrayList<android.graphics.drawable.Drawable> r0 = r1.drawables
                if (r0 == 0) goto L_0x0011
                boolean r2 = r0.contains(r2)
                if (r2 == 0) goto L_0x0011
                goto L_0x0013
            L_0x0011:
                r2 = 0
                goto L_0x0014
            L_0x0013:
                r2 = 1
            L_0x0014:
                return r2
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.internal.ViewOverlayApi14.OverlayViewGroup.verifyDrawable(android.graphics.drawable.Drawable):boolean");
        }

        public void remove(View view) {
            super.removeView(view);
            disposeIfEmpty();
        }

        public void add(View view) {
            assertNotDisposed();
            if (view.getParent() instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view.getParent();
                if (!(viewGroup == this.hostView || viewGroup.getParent() == null || !h0.Z(viewGroup))) {
                    int[] iArr = new int[2];
                    int[] iArr2 = new int[2];
                    viewGroup.getLocationOnScreen(iArr);
                    this.hostView.getLocationOnScreen(iArr2);
                    h0.g0(view, iArr[0] - iArr2[0]);
                    h0.h0(view, iArr[1] - iArr2[1]);
                }
                viewGroup.removeView(view);
                if (view.getParent() != null) {
                    viewGroup.removeView(view);
                }
            }
            super.addView(view);
        }
    }
}
