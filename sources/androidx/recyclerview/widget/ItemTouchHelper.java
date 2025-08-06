package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.core.view.h0;
import androidx.recyclerview.R$dimen;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ItemTouchHelper extends RecyclerView.ItemDecoration implements RecyclerView.j {
    public f A;
    public final RecyclerView.k B = new b();
    public Rect C;
    public long D;

    /* renamed from: a  reason: collision with root package name */
    public final List<View> f10611a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    public final float[] f10612b = new float[2];

    /* renamed from: c  reason: collision with root package name */
    public RecyclerView.ViewHolder f10613c = null;

    /* renamed from: d  reason: collision with root package name */
    public float f10614d;

    /* renamed from: e  reason: collision with root package name */
    public float f10615e;

    /* renamed from: f  reason: collision with root package name */
    public float f10616f;

    /* renamed from: g  reason: collision with root package name */
    public float f10617g;

    /* renamed from: h  reason: collision with root package name */
    public float f10618h;

    /* renamed from: i  reason: collision with root package name */
    public float f10619i;

    /* renamed from: j  reason: collision with root package name */
    public float f10620j;

    /* renamed from: k  reason: collision with root package name */
    public float f10621k;

    /* renamed from: l  reason: collision with root package name */
    public int f10622l = -1;

    /* renamed from: m  reason: collision with root package name */
    public Callback f10623m;

    /* renamed from: n  reason: collision with root package name */
    public int f10624n = 0;

    /* renamed from: o  reason: collision with root package name */
    public int f10625o;

    /* renamed from: p  reason: collision with root package name */
    public List<g> f10626p = new ArrayList();

    /* renamed from: q  reason: collision with root package name */
    public int f10627q;

    /* renamed from: r  reason: collision with root package name */
    public RecyclerView f10628r;

    /* renamed from: s  reason: collision with root package name */
    public final Runnable f10629s = new a();

    /* renamed from: t  reason: collision with root package name */
    public VelocityTracker f10630t;

    /* renamed from: u  reason: collision with root package name */
    public List<RecyclerView.ViewHolder> f10631u;

    /* renamed from: v  reason: collision with root package name */
    public List<Integer> f10632v;

    /* renamed from: w  reason: collision with root package name */
    public RecyclerView.h f10633w = null;

    /* renamed from: x  reason: collision with root package name */
    public View f10634x = null;

    /* renamed from: y  reason: collision with root package name */
    public int f10635y = -1;

    /* renamed from: z  reason: collision with root package name */
    public androidx.core.view.e f10636z;

    public static abstract class Callback {
        private static final int ABS_HORIZONTAL_DIR_FLAGS = 789516;
        public static final int DEFAULT_DRAG_ANIMATION_DURATION = 200;
        public static final int DEFAULT_SWIPE_ANIMATION_DURATION = 250;
        private static final long DRAG_SCROLL_ACCELERATION_LIMIT_TIME_MS = 2000;
        public static final int RELATIVE_DIR_FLAGS = 3158064;
        private static final Interpolator sDragScrollInterpolator = new a();
        private static final Interpolator sDragViewScrollCapInterpolator = new b();
        private int mCachedMaxScrollSpeed = -1;

        public class a implements Interpolator {
            public float getInterpolation(float f11) {
                return f11 * f11 * f11 * f11 * f11;
            }
        }

        public class b implements Interpolator {
            public float getInterpolation(float f11) {
                float f12 = f11 - 1.0f;
                return (f12 * f12 * f12 * f12 * f12) + 1.0f;
            }
        }

        public static int convertToRelativeDirection(int i11, int i12) {
            int i13;
            int i14 = i11 & ABS_HORIZONTAL_DIR_FLAGS;
            if (i14 == 0) {
                return i11;
            }
            int i15 = i11 & (~i14);
            if (i12 == 0) {
                i13 = i14 << 2;
            } else {
                int i16 = i14 << 1;
                i15 |= -789517 & i16;
                i13 = (i16 & ABS_HORIZONTAL_DIR_FLAGS) << 2;
            }
            return i15 | i13;
        }

        public static k getDefaultUIUtil() {
            return l.f10900a;
        }

        private int getMaxDragScroll(RecyclerView recyclerView) {
            if (this.mCachedMaxScrollSpeed == -1) {
                this.mCachedMaxScrollSpeed = recyclerView.getResources().getDimensionPixelSize(R$dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.mCachedMaxScrollSpeed;
        }

        public static int makeFlag(int i11, int i12) {
            return i12 << (i11 * 8);
        }

        public static int makeMovementFlags(int i11, int i12) {
            int makeFlag = makeFlag(0, i12 | i11);
            return makeFlag(2, i11) | makeFlag(1, i12) | makeFlag;
        }

        public boolean canDropOver(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2) {
            return true;
        }

        @SuppressLint({"UnknownNullness"})
        public RecyclerView.ViewHolder chooseDropTarget(RecyclerView.ViewHolder viewHolder, List<RecyclerView.ViewHolder> list, int i11, int i12) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            RecyclerView.ViewHolder viewHolder2 = viewHolder;
            int width = i11 + viewHolder2.itemView.getWidth();
            int height = i12 + viewHolder2.itemView.getHeight();
            int left2 = i11 - viewHolder2.itemView.getLeft();
            int top2 = i12 - viewHolder2.itemView.getTop();
            int size = list.size();
            RecyclerView.ViewHolder viewHolder3 = null;
            int i13 = -1;
            for (int i14 = 0; i14 < size; i14++) {
                RecyclerView.ViewHolder viewHolder4 = list.get(i14);
                if (left2 > 0 && (right = viewHolder4.itemView.getRight() - width) < 0 && viewHolder4.itemView.getRight() > viewHolder2.itemView.getRight() && (abs4 = Math.abs(right)) > i13) {
                    viewHolder3 = viewHolder4;
                    i13 = abs4;
                }
                if (left2 < 0 && (left = viewHolder4.itemView.getLeft() - i11) > 0 && viewHolder4.itemView.getLeft() < viewHolder2.itemView.getLeft() && (abs3 = Math.abs(left)) > i13) {
                    viewHolder3 = viewHolder4;
                    i13 = abs3;
                }
                if (top2 < 0 && (top = viewHolder4.itemView.getTop() - i12) > 0 && viewHolder4.itemView.getTop() < viewHolder2.itemView.getTop() && (abs2 = Math.abs(top)) > i13) {
                    viewHolder3 = viewHolder4;
                    i13 = abs2;
                }
                if (top2 > 0 && (bottom = viewHolder4.itemView.getBottom() - height) < 0 && viewHolder4.itemView.getBottom() > viewHolder2.itemView.getBottom() && (abs = Math.abs(bottom)) > i13) {
                    viewHolder3 = viewHolder4;
                    i13 = abs;
                }
            }
            return viewHolder3;
        }

        public void clearView(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            l.f10900a.c(viewHolder.itemView);
        }

        public int convertToAbsoluteDirection(int i11, int i12) {
            int i13;
            int i14 = i11 & RELATIVE_DIR_FLAGS;
            if (i14 == 0) {
                return i11;
            }
            int i15 = i11 & (~i14);
            if (i12 == 0) {
                i13 = i14 >> 2;
            } else {
                int i16 = i14 >> 1;
                i15 |= -3158065 & i16;
                i13 = (i16 & RELATIVE_DIR_FLAGS) >> 2;
            }
            return i15 | i13;
        }

        public final int getAbsoluteMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return convertToAbsoluteDirection(getMovementFlags(recyclerView, viewHolder), h0.F(recyclerView));
        }

        public long getAnimationDuration(RecyclerView recyclerView, int i11, float f11, float f12) {
            RecyclerView.ItemAnimator itemAnimator = recyclerView.getItemAnimator();
            if (itemAnimator == null) {
                return i11 == 8 ? 200 : 250;
            }
            if (i11 == 8) {
                return itemAnimator.getMoveDuration();
            }
            return itemAnimator.getRemoveDuration();
        }

        public int getBoundingBoxMargin() {
            return 0;
        }

        public float getMoveThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public abstract int getMovementFlags(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder);

        public float getSwipeEscapeVelocity(float f11) {
            return f11;
        }

        public float getSwipeThreshold(RecyclerView.ViewHolder viewHolder) {
            return 0.5f;
        }

        public float getSwipeVelocityThreshold(float f11) {
            return f11;
        }

        public boolean hasDragFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 16711680) != 0;
        }

        public boolean hasSwipeFlag(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder) {
            return (getAbsoluteMovementFlags(recyclerView, viewHolder) & 65280) != 0;
        }

        public int interpolateOutOfBoundsScroll(RecyclerView recyclerView, int i11, int i12, int i13, long j11) {
            float f11 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i12)) * getMaxDragScroll(recyclerView))) * sDragViewScrollCapInterpolator.getInterpolation(Math.min(1.0f, (((float) Math.abs(i12)) * 1.0f) / ((float) i11))));
            if (j11 <= 2000) {
                f11 = ((float) j11) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * sDragScrollInterpolator.getInterpolation(f11));
            if (interpolation == 0) {
                return i12 > 0 ? 1 : -1;
            }
            return interpolation;
        }

        public boolean isItemViewSwipeEnabled() {
            return true;
        }

        public boolean isLongPressDragEnabled() {
            return true;
        }

        public void onChildDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, float f11, float f12, int i11, boolean z11) {
            l.f10900a.b(canvas, recyclerView, viewHolder.itemView, f11, f12, i11, z11);
        }

        public void onChildDrawOver(Canvas canvas, RecyclerView recyclerView, @SuppressLint({"UnknownNullness"}) RecyclerView.ViewHolder viewHolder, float f11, float f12, int i11, boolean z11) {
            l.f10900a.d(canvas, recyclerView, viewHolder.itemView, f11, f12, i11, z11);
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<g> list, int i11, float f11, float f12) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i12 = 0; i12 < size; i12++) {
                g gVar = list.get(i12);
                gVar.e();
                int save = canvas.save();
                onChildDraw(canvas, recyclerView, gVar.f10652f, gVar.f10657k, gVar.f10658l, gVar.f10653g, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDraw(canvas, recyclerView, viewHolder, f11, f12, i11, true);
                canvas.restoreToCount(save2);
            }
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, List<g> list, int i11, float f11, float f12) {
            Canvas canvas2 = canvas;
            List<g> list2 = list;
            int size = list.size();
            boolean z11 = false;
            for (int i12 = 0; i12 < size; i12++) {
                g gVar = list2.get(i12);
                int save = canvas.save();
                onChildDrawOver(canvas, recyclerView, gVar.f10652f, gVar.f10657k, gVar.f10658l, gVar.f10653g, false);
                canvas.restoreToCount(save);
            }
            if (viewHolder != null) {
                int save2 = canvas.save();
                onChildDrawOver(canvas, recyclerView, viewHolder, f11, f12, i11, true);
                canvas.restoreToCount(save2);
            }
            for (int i13 = size - 1; i13 >= 0; i13--) {
                g gVar2 = list2.get(i13);
                boolean z12 = gVar2.f10660n;
                if (z12 && !gVar2.f10656j) {
                    list2.remove(i13);
                } else if (!z12) {
                    z11 = true;
                }
            }
            if (z11) {
                recyclerView.invalidate();
            }
        }

        public abstract boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder viewHolder2);

        public void onMoved(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, int i11, RecyclerView.ViewHolder viewHolder2, int i12, int i13, int i14) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof h) {
                ((h) layoutManager).prepareForDrop(viewHolder.itemView, viewHolder2.itemView, i13, i14);
                return;
            }
            if (layoutManager.canScrollHorizontally()) {
                if (layoutManager.getDecoratedLeft(viewHolder2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.scrollToPosition(i12);
                }
                if (layoutManager.getDecoratedRight(viewHolder2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.scrollToPosition(i12);
                }
            }
            if (layoutManager.canScrollVertically()) {
                if (layoutManager.getDecoratedTop(viewHolder2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.scrollToPosition(i12);
                }
                if (layoutManager.getDecoratedBottom(viewHolder2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.scrollToPosition(i12);
                }
            }
        }

        public void onSelectedChanged(RecyclerView.ViewHolder viewHolder, int i11) {
            if (viewHolder != null) {
                l.f10900a.a(viewHolder.itemView);
            }
        }

        public abstract void onSwiped(RecyclerView.ViewHolder viewHolder, int i11);
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            if (itemTouchHelper.f10613c != null && itemTouchHelper.t()) {
                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper2.f10613c;
                if (viewHolder != null) {
                    itemTouchHelper2.o(viewHolder);
                }
                ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                itemTouchHelper3.f10628r.removeCallbacks(itemTouchHelper3.f10629s);
                h0.p0(ItemTouchHelper.this.f10628r, this);
            }
        }
    }

    public class b implements RecyclerView.k {
        public b() {
        }

        public boolean onInterceptTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            g h11;
            ItemTouchHelper.this.f10636z.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                ItemTouchHelper.this.f10622l = motionEvent.getPointerId(0);
                ItemTouchHelper.this.f10614d = motionEvent.getX();
                ItemTouchHelper.this.f10615e = motionEvent.getY();
                ItemTouchHelper.this.p();
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f10613c == null && (h11 = itemTouchHelper.h(motionEvent)) != null) {
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f10614d -= h11.f10657k;
                    itemTouchHelper2.f10615e -= h11.f10658l;
                    itemTouchHelper2.g(h11.f10652f, true);
                    if (ItemTouchHelper.this.f10611a.remove(h11.f10652f.itemView)) {
                        ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                        itemTouchHelper3.f10623m.clearView(itemTouchHelper3.f10628r, h11.f10652f);
                    }
                    ItemTouchHelper.this.u(h11.f10652f, h11.f10653g);
                    ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                    itemTouchHelper4.A(motionEvent, itemTouchHelper4.f10625o, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                ItemTouchHelper itemTouchHelper5 = ItemTouchHelper.this;
                itemTouchHelper5.f10622l = -1;
                itemTouchHelper5.u((RecyclerView.ViewHolder) null, 0);
            } else {
                int i11 = ItemTouchHelper.this.f10622l;
                if (i11 != -1 && (findPointerIndex = motionEvent.findPointerIndex(i11)) >= 0) {
                    ItemTouchHelper.this.d(actionMasked, motionEvent, findPointerIndex);
                }
            }
            VelocityTracker velocityTracker = ItemTouchHelper.this.f10630t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f10613c != null) {
                return true;
            }
            return false;
        }

        public void onRequestDisallowInterceptTouchEvent(boolean z11) {
            if (z11) {
                ItemTouchHelper.this.u((RecyclerView.ViewHolder) null, 0);
            }
        }

        public void onTouchEvent(RecyclerView recyclerView, MotionEvent motionEvent) {
            ItemTouchHelper.this.f10636z.a(motionEvent);
            VelocityTracker velocityTracker = ItemTouchHelper.this.f10630t;
            if (velocityTracker != null) {
                velocityTracker.addMovement(motionEvent);
            }
            if (ItemTouchHelper.this.f10622l != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(ItemTouchHelper.this.f10622l);
                if (findPointerIndex >= 0) {
                    ItemTouchHelper.this.d(actionMasked, motionEvent, findPointerIndex);
                }
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                RecyclerView.ViewHolder viewHolder = itemTouchHelper.f10613c;
                if (viewHolder != null) {
                    int i11 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked == 3) {
                                VelocityTracker velocityTracker2 = itemTouchHelper.f10630t;
                                if (velocityTracker2 != null) {
                                    velocityTracker2.clear();
                                }
                            } else if (actionMasked == 6) {
                                int actionIndex = motionEvent.getActionIndex();
                                int pointerId = motionEvent.getPointerId(actionIndex);
                                ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                                if (pointerId == itemTouchHelper2.f10622l) {
                                    if (actionIndex == 0) {
                                        i11 = 1;
                                    }
                                    itemTouchHelper2.f10622l = motionEvent.getPointerId(i11);
                                    ItemTouchHelper itemTouchHelper3 = ItemTouchHelper.this;
                                    itemTouchHelper3.A(motionEvent, itemTouchHelper3.f10625o, actionIndex);
                                    return;
                                }
                                return;
                            } else {
                                return;
                            }
                        } else if (findPointerIndex >= 0) {
                            itemTouchHelper.A(motionEvent, itemTouchHelper.f10625o, findPointerIndex);
                            ItemTouchHelper.this.o(viewHolder);
                            ItemTouchHelper itemTouchHelper4 = ItemTouchHelper.this;
                            itemTouchHelper4.f10628r.removeCallbacks(itemTouchHelper4.f10629s);
                            ItemTouchHelper.this.f10629s.run();
                            ItemTouchHelper.this.f10628r.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    ItemTouchHelper.this.u((RecyclerView.ViewHolder) null, 0);
                    ItemTouchHelper.this.f10622l = -1;
                }
            }
        }
    }

    public class c extends g {

        /* renamed from: p  reason: collision with root package name */
        public final /* synthetic */ int f10639p;

        /* renamed from: q  reason: collision with root package name */
        public final /* synthetic */ RecyclerView.ViewHolder f10640q;

        /* renamed from: r  reason: collision with root package name */
        public final /* synthetic */ ItemTouchHelper f10641r;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public c(ItemTouchHelper itemTouchHelper, RecyclerView.ViewHolder viewHolder, int i11, int i12, float f11, float f12, float f13, float f14, int i13, RecyclerView.ViewHolder viewHolder2) {
            super(viewHolder, i11, i12, f11, f12, f13, f14);
            this.f10641r = itemTouchHelper;
            this.f10639p = i13;
            this.f10640q = viewHolder2;
        }

        public void onAnimationEnd(Animator animator) {
            super.onAnimationEnd(animator);
            if (!this.f10659m) {
                if (this.f10639p <= 0) {
                    ItemTouchHelper itemTouchHelper = this.f10641r;
                    itemTouchHelper.f10623m.clearView(itemTouchHelper.f10628r, this.f10640q);
                } else {
                    this.f10641r.f10611a.add(this.f10640q.itemView);
                    this.f10656j = true;
                    int i11 = this.f10639p;
                    if (i11 > 0) {
                        this.f10641r.q(this, i11);
                    }
                }
                ItemTouchHelper itemTouchHelper2 = this.f10641r;
                View view = itemTouchHelper2.f10634x;
                View view2 = this.f10640q.itemView;
                if (view == view2) {
                    itemTouchHelper2.s(view2);
                }
            }
        }
    }

    public class d implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f10642b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ int f10643c;

        public d(g gVar, int i11) {
            this.f10642b = gVar;
            this.f10643c = i11;
        }

        public void run() {
            RecyclerView recyclerView = ItemTouchHelper.this.f10628r;
            if (recyclerView != null && recyclerView.isAttachedToWindow()) {
                g gVar = this.f10642b;
                if (!gVar.f10659m && gVar.f10652f.getAbsoluteAdapterPosition() != -1) {
                    RecyclerView.ItemAnimator itemAnimator = ItemTouchHelper.this.f10628r.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.isRunning((RecyclerView.ItemAnimator.a) null)) && !ItemTouchHelper.this.m()) {
                        ItemTouchHelper.this.f10623m.onSwiped(this.f10642b.f10652f, this.f10643c);
                    } else {
                        ItemTouchHelper.this.f10628r.post(this);
                    }
                }
            }
        }
    }

    public class e implements RecyclerView.h {
        public e() {
        }

        public int a(int i11, int i12) {
            ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
            View view = itemTouchHelper.f10634x;
            if (view == null) {
                return i12;
            }
            int i13 = itemTouchHelper.f10635y;
            if (i13 == -1) {
                i13 = itemTouchHelper.f10628r.indexOfChild(view);
                ItemTouchHelper.this.f10635y = i13;
            }
            if (i12 == i11 - 1) {
                return i13;
            }
            return i12 < i13 ? i12 : i12 + 1;
        }
    }

    public class f extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        public boolean f10646b = true;

        public f() {
        }

        public void a() {
            this.f10646b = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View i11;
            RecyclerView.ViewHolder childViewHolder;
            int i12;
            if (this.f10646b && (i11 = ItemTouchHelper.this.i(motionEvent)) != null && (childViewHolder = ItemTouchHelper.this.f10628r.getChildViewHolder(i11)) != null) {
                ItemTouchHelper itemTouchHelper = ItemTouchHelper.this;
                if (itemTouchHelper.f10623m.hasDragFlag(itemTouchHelper.f10628r, childViewHolder) && motionEvent.getPointerId(0) == (i12 = ItemTouchHelper.this.f10622l)) {
                    int findPointerIndex = motionEvent.findPointerIndex(i12);
                    float x11 = motionEvent.getX(findPointerIndex);
                    float y11 = motionEvent.getY(findPointerIndex);
                    ItemTouchHelper itemTouchHelper2 = ItemTouchHelper.this;
                    itemTouchHelper2.f10614d = x11;
                    itemTouchHelper2.f10615e = y11;
                    itemTouchHelper2.f10619i = 0.0f;
                    itemTouchHelper2.f10618h = 0.0f;
                    if (itemTouchHelper2.f10623m.isLongPressDragEnabled()) {
                        ItemTouchHelper.this.u(childViewHolder, 2);
                    }
                }
            }
        }
    }

    public static class g implements Animator.AnimatorListener {

        /* renamed from: b  reason: collision with root package name */
        public final float f10648b;

        /* renamed from: c  reason: collision with root package name */
        public final float f10649c;

        /* renamed from: d  reason: collision with root package name */
        public final float f10650d;

        /* renamed from: e  reason: collision with root package name */
        public final float f10651e;

        /* renamed from: f  reason: collision with root package name */
        public final RecyclerView.ViewHolder f10652f;

        /* renamed from: g  reason: collision with root package name */
        public final int f10653g;

        /* renamed from: h  reason: collision with root package name */
        public final ValueAnimator f10654h;

        /* renamed from: i  reason: collision with root package name */
        public final int f10655i;

        /* renamed from: j  reason: collision with root package name */
        public boolean f10656j;

        /* renamed from: k  reason: collision with root package name */
        public float f10657k;

        /* renamed from: l  reason: collision with root package name */
        public float f10658l;

        /* renamed from: m  reason: collision with root package name */
        public boolean f10659m = false;

        /* renamed from: n  reason: collision with root package name */
        public boolean f10660n = false;

        /* renamed from: o  reason: collision with root package name */
        public float f10661o;

        public class a implements ValueAnimator.AnimatorUpdateListener {
            public a() {
            }

            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                g.this.c(valueAnimator.getAnimatedFraction());
            }
        }

        public g(RecyclerView.ViewHolder viewHolder, int i11, int i12, float f11, float f12, float f13, float f14) {
            this.f10653g = i12;
            this.f10655i = i11;
            this.f10652f = viewHolder;
            this.f10648b = f11;
            this.f10649c = f12;
            this.f10650d = f13;
            this.f10651e = f14;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f10654h = ofFloat;
            ofFloat.addUpdateListener(new a());
            ofFloat.setTarget(viewHolder.itemView);
            ofFloat.addListener(this);
            c(0.0f);
        }

        public void a() {
            this.f10654h.cancel();
        }

        public void b(long j11) {
            this.f10654h.setDuration(j11);
        }

        public void c(float f11) {
            this.f10661o = f11;
        }

        public void d() {
            this.f10652f.setIsRecyclable(false);
            this.f10654h.start();
        }

        public void e() {
            float f11 = this.f10648b;
            float f12 = this.f10650d;
            if (f11 == f12) {
                this.f10657k = this.f10652f.itemView.getTranslationX();
            } else {
                this.f10657k = f11 + (this.f10661o * (f12 - f11));
            }
            float f13 = this.f10649c;
            float f14 = this.f10651e;
            if (f13 == f14) {
                this.f10658l = this.f10652f.itemView.getTranslationY();
            } else {
                this.f10658l = f13 + (this.f10661o * (f14 - f13));
            }
        }

        public void onAnimationCancel(Animator animator) {
            c(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f10660n) {
                this.f10652f.setIsRecyclable(true);
            }
            this.f10660n = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface h {
        void prepareForDrop(View view, View view2, int i11, int i12);
    }

    public ItemTouchHelper(Callback callback) {
        this.f10623m = callback;
    }

    public static boolean n(View view, float f11, float f12, float f13, float f14) {
        return f11 >= f13 && f11 <= f13 + ((float) view.getWidth()) && f12 >= f14 && f12 <= f14 + ((float) view.getHeight());
    }

    public void A(MotionEvent motionEvent, int i11, int i12) {
        float x11 = motionEvent.getX(i12);
        float y11 = motionEvent.getY(i12);
        float f11 = x11 - this.f10614d;
        this.f10618h = f11;
        this.f10619i = y11 - this.f10615e;
        if ((i11 & 4) == 0) {
            this.f10618h = Math.max(0.0f, f11);
        }
        if ((i11 & 8) == 0) {
            this.f10618h = Math.min(0.0f, this.f10618h);
        }
        if ((i11 & 1) == 0) {
            this.f10619i = Math.max(0.0f, this.f10619i);
        }
        if ((i11 & 2) == 0) {
            this.f10619i = Math.min(0.0f, this.f10619i);
        }
    }

    public final void a() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.f10633w == null) {
                this.f10633w = new e();
            }
            this.f10628r.setChildDrawingOrderCallback(this.f10633w);
        }
    }

    public void b(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f10628r;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                f();
            }
            this.f10628r = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f10616f = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_velocity);
                this.f10617g = resources.getDimension(R$dimen.item_touch_helper_swipe_escape_max_velocity);
                v();
            }
        }
    }

    public final int c(RecyclerView.ViewHolder viewHolder, int i11) {
        if ((i11 & 12) == 0) {
            return 0;
        }
        int i12 = 8;
        int i13 = this.f10618h > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f10630t;
        if (velocityTracker != null && this.f10622l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f10623m.getSwipeVelocityThreshold(this.f10617g));
            float xVelocity = this.f10630t.getXVelocity(this.f10622l);
            float yVelocity = this.f10630t.getYVelocity(this.f10622l);
            if (xVelocity <= 0.0f) {
                i12 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i12 & i11) != 0 && i13 == i12 && abs >= this.f10623m.getSwipeEscapeVelocity(this.f10616f) && abs > Math.abs(yVelocity)) {
                return i12;
            }
        }
        float width = ((float) this.f10628r.getWidth()) * this.f10623m.getSwipeThreshold(viewHolder);
        if ((i11 & i13) == 0 || Math.abs(this.f10618h) <= width) {
            return 0;
        }
        return i13;
    }

    public void d(int i11, MotionEvent motionEvent, int i12) {
        RecyclerView.ViewHolder k11;
        int absoluteMovementFlags;
        if (this.f10613c == null && i11 == 2 && this.f10624n != 2 && this.f10623m.isItemViewSwipeEnabled() && this.f10628r.getScrollState() != 1 && (k11 = k(motionEvent)) != null && (absoluteMovementFlags = (this.f10623m.getAbsoluteMovementFlags(this.f10628r, k11) & 65280) >> 8) != 0) {
            float x11 = motionEvent.getX(i12);
            float y11 = motionEvent.getY(i12);
            float f11 = x11 - this.f10614d;
            float f12 = y11 - this.f10615e;
            float abs = Math.abs(f11);
            float abs2 = Math.abs(f12);
            int i13 = this.f10627q;
            if (abs >= ((float) i13) || abs2 >= ((float) i13)) {
                if (abs > abs2) {
                    if (f11 < 0.0f && (absoluteMovementFlags & 4) == 0) {
                        return;
                    }
                    if (f11 > 0.0f && (absoluteMovementFlags & 8) == 0) {
                        return;
                    }
                } else if (f12 < 0.0f && (absoluteMovementFlags & 1) == 0) {
                    return;
                } else {
                    if (f12 > 0.0f && (absoluteMovementFlags & 2) == 0) {
                        return;
                    }
                }
                this.f10619i = 0.0f;
                this.f10618h = 0.0f;
                this.f10622l = motionEvent.getPointerId(0);
                u(k11, 1);
            }
        }
    }

    public final int e(RecyclerView.ViewHolder viewHolder, int i11) {
        if ((i11 & 3) == 0) {
            return 0;
        }
        int i12 = 2;
        int i13 = this.f10619i > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f10630t;
        if (velocityTracker != null && this.f10622l > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f10623m.getSwipeVelocityThreshold(this.f10617g));
            float xVelocity = this.f10630t.getXVelocity(this.f10622l);
            float yVelocity = this.f10630t.getYVelocity(this.f10622l);
            if (yVelocity <= 0.0f) {
                i12 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i12 & i11) != 0 && i12 == i13 && abs >= this.f10623m.getSwipeEscapeVelocity(this.f10616f) && abs > Math.abs(xVelocity)) {
                return i12;
            }
        }
        float height = ((float) this.f10628r.getHeight()) * this.f10623m.getSwipeThreshold(viewHolder);
        if ((i11 & i13) == 0 || Math.abs(this.f10619i) <= height) {
            return 0;
        }
        return i13;
    }

    public final void f() {
        this.f10628r.removeItemDecoration(this);
        this.f10628r.removeOnItemTouchListener(this.B);
        this.f10628r.removeOnChildAttachStateChangeListener(this);
        for (int size = this.f10626p.size() - 1; size >= 0; size--) {
            g gVar = this.f10626p.get(0);
            gVar.a();
            this.f10623m.clearView(this.f10628r, gVar.f10652f);
        }
        this.f10626p.clear();
        this.f10634x = null;
        this.f10635y = -1;
        r();
        y();
    }

    public void g(RecyclerView.ViewHolder viewHolder, boolean z11) {
        for (int size = this.f10626p.size() - 1; size >= 0; size--) {
            g gVar = this.f10626p.get(size);
            if (gVar.f10652f == viewHolder) {
                gVar.f10659m |= z11;
                if (!gVar.f10660n) {
                    gVar.a();
                }
                this.f10626p.remove(size);
                return;
            }
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
        rect.setEmpty();
    }

    public g h(MotionEvent motionEvent) {
        if (this.f10626p.isEmpty()) {
            return null;
        }
        View i11 = i(motionEvent);
        for (int size = this.f10626p.size() - 1; size >= 0; size--) {
            g gVar = this.f10626p.get(size);
            if (gVar.f10652f.itemView == i11) {
                return gVar;
            }
        }
        return null;
    }

    public View i(MotionEvent motionEvent) {
        float x11 = motionEvent.getX();
        float y11 = motionEvent.getY();
        RecyclerView.ViewHolder viewHolder = this.f10613c;
        if (viewHolder != null) {
            View view = viewHolder.itemView;
            if (n(view, x11, y11, this.f10620j + this.f10618h, this.f10621k + this.f10619i)) {
                return view;
            }
        }
        for (int size = this.f10626p.size() - 1; size >= 0; size--) {
            g gVar = this.f10626p.get(size);
            View view2 = gVar.f10652f.itemView;
            if (n(view2, x11, y11, gVar.f10657k, gVar.f10658l)) {
                return view2;
            }
        }
        return this.f10628r.findChildViewUnder(x11, y11);
    }

    public final List<RecyclerView.ViewHolder> j(RecyclerView.ViewHolder viewHolder) {
        RecyclerView.ViewHolder viewHolder2 = viewHolder;
        List<RecyclerView.ViewHolder> list = this.f10631u;
        if (list == null) {
            this.f10631u = new ArrayList();
            this.f10632v = new ArrayList();
        } else {
            list.clear();
            this.f10632v.clear();
        }
        int boundingBoxMargin = this.f10623m.getBoundingBoxMargin();
        int round = Math.round(this.f10620j + this.f10618h) - boundingBoxMargin;
        int round2 = Math.round(this.f10621k + this.f10619i) - boundingBoxMargin;
        int i11 = boundingBoxMargin * 2;
        int width = viewHolder2.itemView.getWidth() + round + i11;
        int height = viewHolder2.itemView.getHeight() + round2 + i11;
        int i12 = (round + width) / 2;
        int i13 = (round2 + height) / 2;
        RecyclerView.LayoutManager layoutManager = this.f10628r.getLayoutManager();
        int childCount = layoutManager.getChildCount();
        int i14 = 0;
        while (i14 < childCount) {
            View childAt = layoutManager.getChildAt(i14);
            if (childAt != viewHolder2.itemView && childAt.getBottom() >= round2 && childAt.getTop() <= height && childAt.getRight() >= round && childAt.getLeft() <= width) {
                RecyclerView.ViewHolder childViewHolder = this.f10628r.getChildViewHolder(childAt);
                if (this.f10623m.canDropOver(this.f10628r, this.f10613c, childViewHolder)) {
                    int abs = Math.abs(i12 - ((childAt.getLeft() + childAt.getRight()) / 2));
                    int abs2 = Math.abs(i13 - ((childAt.getTop() + childAt.getBottom()) / 2));
                    int i15 = (abs * abs) + (abs2 * abs2);
                    int size = this.f10631u.size();
                    int i16 = 0;
                    int i17 = 0;
                    while (i16 < size && i15 > this.f10632v.get(i16).intValue()) {
                        i17++;
                        i16++;
                        RecyclerView.ViewHolder viewHolder3 = viewHolder;
                    }
                    this.f10631u.add(i17, childViewHolder);
                    this.f10632v.add(i17, Integer.valueOf(i15));
                }
            }
            i14++;
            viewHolder2 = viewHolder;
        }
        return this.f10631u;
    }

    public final RecyclerView.ViewHolder k(MotionEvent motionEvent) {
        View i11;
        RecyclerView.LayoutManager layoutManager = this.f10628r.getLayoutManager();
        int i12 = this.f10622l;
        if (i12 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i12);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f10614d);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f10615e);
        int i13 = this.f10627q;
        if (abs < ((float) i13) && abs2 < ((float) i13)) {
            return null;
        }
        if (abs > abs2 && layoutManager.canScrollHorizontally()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.canScrollVertically()) && (i11 = i(motionEvent)) != null) {
            return this.f10628r.getChildViewHolder(i11);
        }
        return null;
    }

    public final void l(float[] fArr) {
        if ((this.f10625o & 12) != 0) {
            fArr[0] = (this.f10620j + this.f10618h) - ((float) this.f10613c.itemView.getLeft());
        } else {
            fArr[0] = this.f10613c.itemView.getTranslationX();
        }
        if ((this.f10625o & 3) != 0) {
            fArr[1] = (this.f10621k + this.f10619i) - ((float) this.f10613c.itemView.getTop());
        } else {
            fArr[1] = this.f10613c.itemView.getTranslationY();
        }
    }

    public boolean m() {
        int size = this.f10626p.size();
        for (int i11 = 0; i11 < size; i11++) {
            if (!this.f10626p.get(i11).f10660n) {
                return true;
            }
        }
        return false;
    }

    public void o(RecyclerView.ViewHolder viewHolder) {
        if (!this.f10628r.isLayoutRequested() && this.f10624n == 2) {
            float moveThreshold = this.f10623m.getMoveThreshold(viewHolder);
            int i11 = (int) (this.f10620j + this.f10618h);
            int i12 = (int) (this.f10621k + this.f10619i);
            if (((float) Math.abs(i12 - viewHolder.itemView.getTop())) >= ((float) viewHolder.itemView.getHeight()) * moveThreshold || ((float) Math.abs(i11 - viewHolder.itemView.getLeft())) >= ((float) viewHolder.itemView.getWidth()) * moveThreshold) {
                List<RecyclerView.ViewHolder> j11 = j(viewHolder);
                if (j11.size() != 0) {
                    RecyclerView.ViewHolder chooseDropTarget = this.f10623m.chooseDropTarget(viewHolder, j11, i11, i12);
                    if (chooseDropTarget == null) {
                        this.f10631u.clear();
                        this.f10632v.clear();
                        return;
                    }
                    int absoluteAdapterPosition = chooseDropTarget.getAbsoluteAdapterPosition();
                    int absoluteAdapterPosition2 = viewHolder.getAbsoluteAdapterPosition();
                    if (this.f10623m.onMove(this.f10628r, viewHolder, chooseDropTarget)) {
                        this.f10623m.onMoved(this.f10628r, viewHolder, absoluteAdapterPosition2, chooseDropTarget, absoluteAdapterPosition, i11, i12);
                    }
                }
            }
        }
    }

    public void onChildViewAttachedToWindow(View view) {
    }

    public void onChildViewDetachedFromWindow(View view) {
        s(view);
        RecyclerView.ViewHolder childViewHolder = this.f10628r.getChildViewHolder(view);
        if (childViewHolder != null) {
            RecyclerView.ViewHolder viewHolder = this.f10613c;
            if (viewHolder == null || childViewHolder != viewHolder) {
                g(childViewHolder, false);
                if (this.f10611a.remove(childViewHolder.itemView)) {
                    this.f10623m.clearView(this.f10628r, childViewHolder);
                    return;
                }
                return;
            }
            u((RecyclerView.ViewHolder) null, 0);
        }
    }

    @SuppressLint({"UnknownNullness"})
    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f11;
        float f12;
        this.f10635y = -1;
        if (this.f10613c != null) {
            l(this.f10612b);
            float[] fArr = this.f10612b;
            float f13 = fArr[0];
            f11 = fArr[1];
            f12 = f13;
        } else {
            f12 = 0.0f;
            f11 = 0.0f;
        }
        this.f10623m.onDraw(canvas, recyclerView, this.f10613c, this.f10626p, this.f10624n, f12, f11);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
        float f11;
        float f12;
        if (this.f10613c != null) {
            l(this.f10612b);
            float[] fArr = this.f10612b;
            float f13 = fArr[0];
            f11 = fArr[1];
            f12 = f13;
        } else {
            f12 = 0.0f;
            f11 = 0.0f;
        }
        this.f10623m.onDrawOver(canvas, recyclerView, this.f10613c, this.f10626p, this.f10624n, f12, f11);
    }

    public void p() {
        VelocityTracker velocityTracker = this.f10630t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f10630t = VelocityTracker.obtain();
    }

    public void q(g gVar, int i11) {
        this.f10628r.post(new d(gVar, i11));
    }

    public final void r() {
        VelocityTracker velocityTracker = this.f10630t;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f10630t = null;
        }
    }

    public void s(View view) {
        if (view == this.f10634x) {
            this.f10634x = null;
            if (this.f10633w != null) {
                this.f10628r.setChildDrawingOrderCallback((RecyclerView.h) null);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        if (r1 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean t() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r0.f10613c
            r2 = 0
            r3 = -9223372036854775808
            if (r1 != 0) goto L_0x000c
            r0.D = r3
            return r2
        L_0x000c:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.D
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0019
            r7 = 0
            goto L_0x001b
        L_0x0019:
            long r7 = r5 - r7
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r1 = r0.f10628r
            androidx.recyclerview.widget.RecyclerView$LayoutManager r1 = r1.getLayoutManager()
            android.graphics.Rect r9 = r0.C
            if (r9 != 0) goto L_0x002c
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r0.C = r9
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r0.f10613c
            android.view.View r9 = r9.itemView
            android.graphics.Rect r10 = r0.C
            r1.calculateItemDecorationsForChild(r9, r10)
            boolean r9 = r1.canScrollHorizontally()
            r10 = 0
            if (r9 == 0) goto L_0x007d
            float r9 = r0.f10620j
            float r11 = r0.f10618h
            float r9 = r9 + r11
            int r9 = (int) r9
            android.graphics.Rect r11 = r0.C
            int r11 = r11.left
            int r11 = r9 - r11
            androidx.recyclerview.widget.RecyclerView r12 = r0.f10628r
            int r12 = r12.getPaddingLeft()
            int r11 = r11 - r12
            float r12 = r0.f10618h
            int r13 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0059
            if (r11 >= 0) goto L_0x0059
            r12 = r11
            goto L_0x007e
        L_0x0059:
            int r11 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x007d
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f10613c
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            int r9 = r9 + r11
            android.graphics.Rect r11 = r0.C
            int r11 = r11.right
            int r9 = r9 + r11
            androidx.recyclerview.widget.RecyclerView r11 = r0.f10628r
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f10628r
            int r12 = r12.getPaddingRight()
            int r11 = r11 - r12
            int r9 = r9 - r11
            if (r9 <= 0) goto L_0x007d
            r12 = r9
            goto L_0x007e
        L_0x007d:
            r12 = r2
        L_0x007e:
            boolean r1 = r1.canScrollVertically()
            if (r1 == 0) goto L_0x00c4
            float r1 = r0.f10621k
            float r9 = r0.f10619i
            float r1 = r1 + r9
            int r1 = (int) r1
            android.graphics.Rect r9 = r0.C
            int r9 = r9.top
            int r9 = r1 - r9
            androidx.recyclerview.widget.RecyclerView r11 = r0.f10628r
            int r11 = r11.getPaddingTop()
            int r9 = r9 - r11
            float r11 = r0.f10619i
            int r13 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a1
            if (r9 >= 0) goto L_0x00a1
            r1 = r9
            goto L_0x00c5
        L_0x00a1:
            int r9 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r0.f10613c
            android.view.View r9 = r9.itemView
            int r9 = r9.getHeight()
            int r1 = r1 + r9
            android.graphics.Rect r9 = r0.C
            int r9 = r9.bottom
            int r1 = r1 + r9
            androidx.recyclerview.widget.RecyclerView r9 = r0.f10628r
            int r9 = r9.getHeight()
            androidx.recyclerview.widget.RecyclerView r10 = r0.f10628r
            int r10 = r10.getPaddingBottom()
            int r9 = r9 - r10
            int r1 = r1 - r9
            if (r1 <= 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r1 = r2
        L_0x00c5:
            if (r12 == 0) goto L_0x00de
            androidx.recyclerview.widget.ItemTouchHelper$Callback r9 = r0.f10623m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f10628r
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f10613c
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r13 = r0.f10628r
            int r13 = r13.getWidth()
            r14 = r7
            int r12 = r9.interpolateOutOfBoundsScroll(r10, r11, r12, r13, r14)
        L_0x00de:
            r14 = r12
            if (r1 == 0) goto L_0x00fd
            androidx.recyclerview.widget.ItemTouchHelper$Callback r9 = r0.f10623m
            androidx.recyclerview.widget.RecyclerView r10 = r0.f10628r
            androidx.recyclerview.widget.RecyclerView$ViewHolder r11 = r0.f10613c
            android.view.View r11 = r11.itemView
            int r11 = r11.getHeight()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f10628r
            int r13 = r12.getHeight()
            r12 = r1
            r1 = r14
            r14 = r7
            int r7 = r9.interpolateOutOfBoundsScroll(r10, r11, r12, r13, r14)
            r12 = r1
            r1 = r7
            goto L_0x00fe
        L_0x00fd:
            r12 = r14
        L_0x00fe:
            if (r12 != 0) goto L_0x0106
            if (r1 == 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r0.D = r3
            return r2
        L_0x0106:
            long r7 = r0.D
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010e
            r0.D = r5
        L_0x010e:
            androidx.recyclerview.widget.RecyclerView r2 = r0.f10628r
            r2.scrollBy(r12, r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.t():boolean");
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x012a  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0136  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void u(androidx.recyclerview.widget.RecyclerView.ViewHolder r24, int r25) {
        /*
            r23 = this;
            r11 = r23
            r12 = r24
            r13 = r25
            androidx.recyclerview.widget.RecyclerView$ViewHolder r0 = r11.f10613c
            if (r12 != r0) goto L_0x000f
            int r0 = r11.f10624n
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.D = r0
            int r4 = r11.f10624n
            r14 = 1
            r11.g(r12, r14)
            r11.f10624n = r13
            r15 = 2
            if (r13 != r15) goto L_0x0030
            if (r12 == 0) goto L_0x0028
            android.view.View r0 = r12.itemView
            r11.f10634x = r0
            r23.a()
            goto L_0x0030
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$ViewHolder r9 = r11.f10613c
            r8 = 0
            if (r9 == 0) goto L_0x00ed
            android.view.View r0 = r9.itemView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00d9
            if (r4 != r15) goto L_0x004a
            r7 = r8
            goto L_0x004f
        L_0x004a:
            int r0 = r11.z(r9)
            r7 = r0
        L_0x004f:
            r23.r()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x007c
            if (r7 == r15) goto L_0x007c
            if (r7 == r0) goto L_0x0069
            if (r7 == r10) goto L_0x0069
            r2 = 16
            if (r7 == r2) goto L_0x0069
            r2 = 32
            if (r7 == r2) goto L_0x0069
            r17 = r1
            r18 = r17
            goto L_0x008e
        L_0x0069:
            float r2 = r11.f10618h
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f10628r
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r1
            r17 = r2
            goto L_0x008e
        L_0x007c:
            float r2 = r11.f10619i
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f10628r
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r1
            r18 = r2
        L_0x008e:
            if (r4 != r15) goto L_0x0092
            r6 = r10
            goto L_0x0097
        L_0x0092:
            if (r7 <= 0) goto L_0x0096
            r6 = r15
            goto L_0x0097
        L_0x0096:
            r6 = r0
        L_0x0097:
            float[] r0 = r11.f10612b
            r11.l(r0)
            float[] r0 = r11.f10612b
            r19 = r0[r8]
            r20 = r0[r14]
            androidx.recyclerview.widget.ItemTouchHelper$c r5 = new androidx.recyclerview.widget.ItemTouchHelper$c
            r0 = r5
            r1 = r23
            r2 = r9
            r3 = r6
            r14 = r5
            r5 = r19
            r15 = r6
            r6 = r20
            r21 = r7
            r7 = r17
            r8 = r18
            r22 = r9
            r9 = r21
            r21 = r10
            r10 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f10623m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f10628r
            float r2 = r17 - r19
            float r3 = r18 - r20
            long r0 = r0.getAnimationDuration(r1, r15, r2, r3)
            r14.b(r0)
            java.util.List<androidx.recyclerview.widget.ItemTouchHelper$g> r0 = r11.f10626p
            r0.add(r14)
            r14.d()
            r8 = 1
            goto L_0x00e9
        L_0x00d9:
            r0 = r9
            r21 = r10
            android.view.View r1 = r0.itemView
            r11.s(r1)
            androidx.recyclerview.widget.ItemTouchHelper$Callback r1 = r11.f10623m
            androidx.recyclerview.widget.RecyclerView r2 = r11.f10628r
            r1.clearView(r2, r0)
            r8 = 0
        L_0x00e9:
            r0 = 0
            r11.f10613c = r0
            goto L_0x00f0
        L_0x00ed:
            r21 = r10
            r8 = 0
        L_0x00f0:
            if (r12 == 0) goto L_0x0121
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f10623m
            androidx.recyclerview.widget.RecyclerView r1 = r11.f10628r
            int r0 = r0.getAbsoluteMovementFlags(r1, r12)
            r0 = r0 & r16
            int r1 = r11.f10624n
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.f10625o = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.f10620j = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.f10621k = r0
            r11.f10613c = r12
            r0 = 2
            if (r13 != r0) goto L_0x0121
            android.view.View r0 = r12.itemView
            r1 = 0
            r0.performHapticFeedback(r1)
            goto L_0x0122
        L_0x0121:
            r1 = 0
        L_0x0122:
            androidx.recyclerview.widget.RecyclerView r0 = r11.f10628r
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0134
            androidx.recyclerview.widget.RecyclerView$ViewHolder r2 = r11.f10613c
            if (r2 == 0) goto L_0x0130
            r14 = 1
            goto L_0x0131
        L_0x0130:
            r14 = r1
        L_0x0131:
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0134:
            if (r8 != 0) goto L_0x013f
            androidx.recyclerview.widget.RecyclerView r0 = r11.f10628r
            androidx.recyclerview.widget.RecyclerView$LayoutManager r0 = r0.getLayoutManager()
            r0.requestSimpleAnimationsInNextLayout()
        L_0x013f:
            androidx.recyclerview.widget.ItemTouchHelper$Callback r0 = r11.f10623m
            androidx.recyclerview.widget.RecyclerView$ViewHolder r1 = r11.f10613c
            int r2 = r11.f10624n
            r0.onSelectedChanged(r1, r2)
            androidx.recyclerview.widget.RecyclerView r0 = r11.f10628r
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.ItemTouchHelper.u(androidx.recyclerview.widget.RecyclerView$ViewHolder, int):void");
    }

    public final void v() {
        this.f10627q = ViewConfiguration.get(this.f10628r.getContext()).getScaledTouchSlop();
        this.f10628r.addItemDecoration(this);
        this.f10628r.addOnItemTouchListener(this.B);
        this.f10628r.addOnChildAttachStateChangeListener(this);
        x();
    }

    public void w(RecyclerView.ViewHolder viewHolder) {
        if (!this.f10623m.hasDragFlag(this.f10628r, viewHolder)) {
            Log.e("ItemTouchHelper", "Start drag has been called but dragging is not enabled");
        } else if (viewHolder.itemView.getParent() != this.f10628r) {
            Log.e("ItemTouchHelper", "Start drag has been called with a view holder which is not a child of the RecyclerView which is controlled by this ItemTouchHelper.");
        } else {
            p();
            this.f10619i = 0.0f;
            this.f10618h = 0.0f;
            u(viewHolder, 2);
        }
    }

    public final void x() {
        this.A = new f();
        this.f10636z = new androidx.core.view.e(this.f10628r.getContext(), this.A);
    }

    public final void y() {
        f fVar = this.A;
        if (fVar != null) {
            fVar.a();
            this.A = null;
        }
        if (this.f10636z != null) {
            this.f10636z = null;
        }
    }

    public final int z(RecyclerView.ViewHolder viewHolder) {
        if (this.f10624n == 2) {
            return 0;
        }
        int movementFlags = this.f10623m.getMovementFlags(this.f10628r, viewHolder);
        int convertToAbsoluteDirection = (this.f10623m.convertToAbsoluteDirection(movementFlags, h0.F(this.f10628r)) & 65280) >> 8;
        if (convertToAbsoluteDirection == 0) {
            return 0;
        }
        int i11 = (movementFlags & 65280) >> 8;
        if (Math.abs(this.f10618h) > Math.abs(this.f10619i)) {
            int c11 = c(viewHolder, convertToAbsoluteDirection);
            if (c11 > 0) {
                return (i11 & c11) == 0 ? Callback.convertToRelativeDirection(c11, h0.F(this.f10628r)) : c11;
            }
            int e11 = e(viewHolder, convertToAbsoluteDirection);
            if (e11 > 0) {
                return e11;
            }
        } else {
            int e12 = e(viewHolder, convertToAbsoluteDirection);
            if (e12 > 0) {
                return e12;
            }
            int c12 = c(viewHolder, convertToAbsoluteDirection);
            if (c12 > 0) {
                return (i11 & c12) == 0 ? Callback.convertToRelativeDirection(c12, h0.F(this.f10628r)) : c12;
            }
        }
        return 0;
    }
}
