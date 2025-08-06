package com.jumio.defaultui.view;

import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.i;
import com.jumio.commons.log.Log;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Iterator;
import jumio.dui.h;
import kotlin.jvm.internal.r;

public final class FastScrollerDecorator {
    public static final Companion Companion = new Companion((r) null);
    public static final int INVALID_SIZE = -1;
    private static final String TAG = "FastScrollerDecorator";
    private final RecyclerView.ItemDecoration fastScroller = getFastScroller();
    private boolean isTap;
    private float previousDownX;
    private float previousDownY;
    private final RecyclerView recyclerView;

    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(r rVar) {
            this();
        }
    }

    public FastScrollerDecorator(RecyclerView recyclerView2) {
        this.recyclerView = recyclerView2;
        recyclerView2.addOnItemTouchListener(getTouchListener());
    }

    private final RecyclerView.ItemDecoration getFastScroller() {
        try {
            Field declaredField = RecyclerView.class.getDeclaredField("mOnItemTouchListeners");
            declaredField.setAccessible(true);
            ArrayList arrayList = (ArrayList) declaredField.get(this.recyclerView);
            Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
            if (fastScrollerClass == null) {
                return null;
            }
            Iterator it2 = arrayList.iterator();
            while (it2.hasNext()) {
                RecyclerView.k kVar = (RecyclerView.k) it2.next();
                if (fastScrollerClass.isInstance(kVar)) {
                    return (RecyclerView.ItemDecoration) kVar;
                }
            }
            return null;
        } catch (Exception e11) {
            Log.w(TAG, "Could not get FastScroller for recycler view!", (Throwable) e11);
        }
    }

    private final Class<RecyclerView.ItemDecoration> getFastScrollerClass() {
        Class<i> cls = i.class;
        try {
            int[] iArr = i.D;
            return cls;
        } catch (Exception e11) {
            Log.w(TAG, "Could not get the class for FastScroller!", (Throwable) e11);
            return null;
        }
    }

    private final RecyclerView.k getTouchListener() {
        return new FastScrollerDecorator$getTouchListener$1(this);
    }

    private final int getVerticalTrackHeight() {
        if (this.fastScroller == null) {
            return -1;
        }
        return this.recyclerView.getHeight();
    }

    private final int getVerticalTrackWidth() {
        if (this.fastScroller == null) {
            return -1;
        }
        try {
            Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
            if (fastScrollerClass == null) {
                return -1;
            }
            Field declaredField = fastScrollerClass.getDeclaredField("mVerticalTrackWidth");
            declaredField.setAccessible(true);
            return declaredField.getInt(this.fastScroller);
        } catch (Exception e11) {
            Log.w(TAG, "Could not get the width for FastScroller track!", (Throwable) e11);
            return -1;
        }
    }

    /* access modifiers changed from: private */
    public final boolean handleTap(MotionEvent motionEvent) {
        int verticalTrackWidth = getVerticalTrackWidth();
        int verticalTrackHeight = getVerticalTrackHeight();
        if (!(verticalTrackWidth == -1 || verticalTrackHeight == -1)) {
            if (!insideTrackHorizontally(motionEvent.getX(), verticalTrackWidth) || !insideTrackVertically(motionEvent.getY(), verticalTrackHeight) || !isFastScrollerVisible()) {
                this.isTap = false;
            } else if (motionEvent.getAction() == 1 && isTap(motionEvent.getX(), this.previousDownX, motionEvent.getY(), this.previousDownY)) {
                verticallyScrollTo(motionEvent.getY());
                return true;
            } else if (motionEvent.getAction() == 0) {
                this.isTap = true;
                this.previousDownX = motionEvent.getX();
                this.previousDownY = motionEvent.getY();
            }
        }
        return false;
    }

    private final boolean insideTrackHorizontally(float f11, int i11) {
        if (h.a(this.recyclerView)) {
            if (f11 > this.recyclerView.getX() + ((float) i11) || f11 < this.recyclerView.getX()) {
                return false;
            }
            return true;
        }
        float f12 = (float) i11;
        if (f11 < (this.recyclerView.getX() + ((float) this.recyclerView.getWidth())) - f12 || f11 > this.recyclerView.getX() + ((float) this.recyclerView.getWidth()) + f12) {
            return false;
        }
        return true;
    }

    private final boolean insideTrackVertically(float f11, int i11) {
        return f11 <= this.recyclerView.getY() + ((float) i11) && f11 >= this.recyclerView.getY();
    }

    private final boolean isFastScrollerVisible() {
        if (this.fastScroller == null) {
            return false;
        }
        try {
            Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
            Field declaredField = fastScrollerClass != null ? fastScrollerClass.getDeclaredField("mState") : null;
            if (declaredField == null) {
                return false;
            }
            declaredField.setAccessible(true);
            if (declaredField.getInt(this.fastScroller) == 1) {
                return true;
            }
            return false;
        } catch (Exception e11) {
            Log.w(TAG, "Could not determine if FastScroller is visible!", (Throwable) e11);
            return false;
        }
    }

    private final boolean isTap(float f11, float f12, float f13, float f14) {
        float abs = Math.abs(f12 - f11);
        float f15 = (float) 20;
        return abs <= f15 && Math.abs(f14 - f13) <= f15;
    }

    private final void verticallyScrollTo(float f11) {
        Class<RecyclerView.ItemDecoration> fastScrollerClass = getFastScrollerClass();
        if (fastScrollerClass != null) {
            try {
                Method declaredMethod = fastScrollerClass.getDeclaredMethod("verticalScrollTo", new Class[]{Float.TYPE});
                declaredMethod.setAccessible(true);
                declaredMethod.invoke(this.fastScroller, new Object[]{Float.valueOf(f11)});
            } catch (Exception e11) {
                Log.w(TAG, "Could not scroll with FastScroller vertically!", (Throwable) e11);
            }
        }
    }

    public final RecyclerView getRecyclerView() {
        return this.recyclerView;
    }
}
