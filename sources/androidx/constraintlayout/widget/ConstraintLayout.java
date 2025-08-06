package androidx.constraintlayout.widget;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.core.Metrics;
import androidx.constraintlayout.core.widgets.ConstraintAnchor;
import androidx.constraintlayout.core.widgets.ConstraintWidget;
import androidx.constraintlayout.core.widgets.ConstraintWidgetContainer;
import androidx.constraintlayout.core.widgets.Guideline;
import androidx.constraintlayout.core.widgets.Optimizer;
import androidx.constraintlayout.core.widgets.VirtualLayout;
import androidx.constraintlayout.core.widgets.analyzer.BasicMeasure;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.HashMap;

public class ConstraintLayout extends ViewGroup {
    private static final boolean DEBUG = false;
    private static final boolean DEBUG_DRAW_CONSTRAINTS = false;
    public static final int DESIGN_INFO_ID = 0;
    private static final boolean MEASURE = false;
    private static final boolean OPTIMIZE_HEIGHT_CHANGE = false;
    private static final String TAG = "ConstraintLayout";
    private static final boolean USE_CONSTRAINTS_HELPER = true;
    public static final String VERSION = "ConstraintLayout-2.1.0";
    private static SharedValues sSharedValues;
    public SparseArray<View> mChildrenByIds = new SparseArray<>();
    /* access modifiers changed from: private */
    public ArrayList<ConstraintHelper> mConstraintHelpers = new ArrayList<>(4);
    public n0.a mConstraintLayoutSpec = null;
    private ConstraintSet mConstraintSet = null;
    private int mConstraintSetId = -1;
    private ConstraintsChangedListener mConstraintsChangedListener;
    private HashMap<String, Integer> mDesignIds = new HashMap<>();
    public boolean mDirtyHierarchy = true;
    private int mLastMeasureHeight = -1;
    public int mLastMeasureHeightMode = 0;
    public int mLastMeasureHeightSize = -1;
    private int mLastMeasureWidth = -1;
    public int mLastMeasureWidthMode = 0;
    public int mLastMeasureWidthSize = -1;
    public ConstraintWidgetContainer mLayoutWidget = new ConstraintWidgetContainer();
    private int mMaxHeight = Integer.MAX_VALUE;
    private int mMaxWidth = Integer.MAX_VALUE;
    public b mMeasurer = new b(this);
    private Metrics mMetrics;
    private int mMinHeight = 0;
    private int mMinWidth = 0;
    private int mOnMeasureHeightMeasureSpec = 0;
    private int mOnMeasureWidthMeasureSpec = 0;
    /* access modifiers changed from: private */
    public int mOptimizationLevel = 257;
    private SparseArray<ConstraintWidget> mTempMapIdToWidget = new SparseArray<>();

    public static /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f7977a;

        /* JADX WARNING: Can't wrap try/catch for region: R(8:0|1|2|3|4|5|6|(3:7|8|10)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        static {
            /*
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour[] r0 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f7977a = r0
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.FIXED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f7977a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.WRAP_CONTENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f7977a     // Catch:{ NoSuchFieldError -> 0x0028 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_PARENT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f7977a     // Catch:{ NoSuchFieldError -> 0x0033 }
                androidx.constraintlayout.core.widgets.ConstraintWidget$DimensionBehaviour r1 = androidx.constraintlayout.core.widgets.ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.a.<clinit>():void");
        }
    }

    public class b implements BasicMeasure.a {

        /* renamed from: a  reason: collision with root package name */
        public ConstraintLayout f7978a;

        /* renamed from: b  reason: collision with root package name */
        public int f7979b;

        /* renamed from: c  reason: collision with root package name */
        public int f7980c;

        /* renamed from: d  reason: collision with root package name */
        public int f7981d;

        /* renamed from: e  reason: collision with root package name */
        public int f7982e;

        /* renamed from: f  reason: collision with root package name */
        public int f7983f;

        /* renamed from: g  reason: collision with root package name */
        public int f7984g;

        public b(ConstraintLayout constraintLayout) {
            this.f7978a = constraintLayout;
        }

        public final void a() {
            int childCount = this.f7978a.getChildCount();
            for (int i11 = 0; i11 < childCount; i11++) {
                View childAt = this.f7978a.getChildAt(i11);
                if (childAt instanceof Placeholder) {
                    ((Placeholder) childAt).b(this.f7978a);
                }
            }
            int size = this.f7978a.mConstraintHelpers.size();
            if (size > 0) {
                for (int i12 = 0; i12 < size; i12++) {
                    ((ConstraintHelper) this.f7978a.mConstraintHelpers.get(i12)).o(this.f7978a);
                }
            }
        }

        @SuppressLint({"WrongCall"})
        public final void b(ConstraintWidget constraintWidget, BasicMeasure.Measure measure) {
            int i11;
            int i12;
            int i13;
            int i14;
            int i15;
            int i16;
            int i17;
            ConstraintWidget constraintWidget2 = constraintWidget;
            BasicMeasure.Measure measure2 = measure;
            if (constraintWidget2 != null) {
                if (constraintWidget.T() == 8 && !constraintWidget.h0()) {
                    measure2.f7245e = 0;
                    measure2.f7246f = 0;
                    measure2.f7247g = 0;
                } else if (constraintWidget.L() != null) {
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour = measure2.f7241a;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = measure2.f7242b;
                    int i18 = measure2.f7243c;
                    int i19 = measure2.f7244d;
                    int i21 = this.f7979b + this.f7980c;
                    int i22 = this.f7981d;
                    View view = (View) constraintWidget.t();
                    int[] iArr = a.f7977a;
                    int i23 = iArr[dimensionBehaviour.ordinal()];
                    if (i23 == 1) {
                        i11 = View.MeasureSpec.makeMeasureSpec(i18, 1073741824);
                    } else if (i23 == 2) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f7983f, i22, -2);
                    } else if (i23 == 3) {
                        i11 = ViewGroup.getChildMeasureSpec(this.f7983f, i22 + constraintWidget.C(), -1);
                    } else if (i23 != 4) {
                        i11 = 0;
                    } else {
                        i11 = ViewGroup.getChildMeasureSpec(this.f7983f, i22, -2);
                        boolean z11 = constraintWidget2.f7130v == 1;
                        int i24 = measure2.f7250j;
                        if (i24 == BasicMeasure.Measure.f7239l || i24 == BasicMeasure.Measure.f7240m) {
                            if (measure2.f7250j == BasicMeasure.Measure.f7240m || !z11 || (z11 && (view.getMeasuredHeight() == constraintWidget.y())) || (view instanceof Placeholder) || constraintWidget.l0()) {
                                i11 = View.MeasureSpec.makeMeasureSpec(constraintWidget.U(), 1073741824);
                            }
                        }
                    }
                    int i25 = iArr[dimensionBehaviour2.ordinal()];
                    if (i25 == 1) {
                        i12 = View.MeasureSpec.makeMeasureSpec(i19, 1073741824);
                    } else if (i25 == 2) {
                        i12 = ViewGroup.getChildMeasureSpec(this.f7984g, i21, -2);
                    } else if (i25 == 3) {
                        i12 = ViewGroup.getChildMeasureSpec(this.f7984g, i21 + constraintWidget.S(), -1);
                    } else if (i25 != 4) {
                        i12 = 0;
                    } else {
                        i12 = ViewGroup.getChildMeasureSpec(this.f7984g, i21, -2);
                        boolean z12 = constraintWidget2.f7132w == 1;
                        int i26 = measure2.f7250j;
                        if (i26 == BasicMeasure.Measure.f7239l || i26 == BasicMeasure.Measure.f7240m) {
                            if (measure2.f7250j == BasicMeasure.Measure.f7240m || !z12 || (z12 && (view.getMeasuredWidth() == constraintWidget.U())) || (view instanceof Placeholder) || constraintWidget.m0()) {
                                i12 = View.MeasureSpec.makeMeasureSpec(constraintWidget.y(), 1073741824);
                            }
                        }
                    }
                    ConstraintWidgetContainer constraintWidgetContainer = (ConstraintWidgetContainer) constraintWidget.L();
                    if (constraintWidgetContainer != null && Optimizer.b(ConstraintLayout.this.mOptimizationLevel, 256) && view.getMeasuredWidth() == constraintWidget.U() && view.getMeasuredWidth() < constraintWidgetContainer.U() && view.getMeasuredHeight() == constraintWidget.y() && view.getMeasuredHeight() < constraintWidgetContainer.y() && view.getBaseline() == constraintWidget.q() && !constraintWidget.k0()) {
                        if (d(constraintWidget.D(), i11, constraintWidget.U()) && d(constraintWidget.E(), i12, constraintWidget.y())) {
                            measure2.f7245e = constraintWidget.U();
                            measure2.f7246f = constraintWidget.y();
                            measure2.f7247g = constraintWidget.q();
                            return;
                        }
                    }
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour3 = ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT;
                    boolean z13 = dimensionBehaviour == dimensionBehaviour3;
                    boolean z14 = dimensionBehaviour2 == dimensionBehaviour3;
                    ConstraintWidget.DimensionBehaviour dimensionBehaviour4 = ConstraintWidget.DimensionBehaviour.MATCH_PARENT;
                    boolean z15 = dimensionBehaviour2 == dimensionBehaviour4 || dimensionBehaviour2 == ConstraintWidget.DimensionBehaviour.FIXED;
                    boolean z16 = dimensionBehaviour == dimensionBehaviour4 || dimensionBehaviour == ConstraintWidget.DimensionBehaviour.FIXED;
                    boolean z17 = z13 && constraintWidget2.f7097e0 > 0.0f;
                    boolean z18 = z14 && constraintWidget2.f7097e0 > 0.0f;
                    if (view != null) {
                        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                        int i27 = measure2.f7250j;
                        if (i27 == BasicMeasure.Measure.f7239l || i27 == BasicMeasure.Measure.f7240m || !z13 || constraintWidget2.f7130v != 0 || !z14 || constraintWidget2.f7132w != 0) {
                            if (!(view instanceof VirtualLayout) || !(constraintWidget2 instanceof VirtualLayout)) {
                                view.measure(i11, i12);
                            } else {
                                ((VirtualLayout) view).t((VirtualLayout) constraintWidget2, i11, i12);
                            }
                            constraintWidget2.Q0(i11, i12);
                            int measuredWidth = view.getMeasuredWidth();
                            int measuredHeight = view.getMeasuredHeight();
                            i14 = view.getBaseline();
                            int i28 = constraintWidget2.f7136y;
                            i13 = i28 > 0 ? Math.max(i28, measuredWidth) : measuredWidth;
                            int i29 = constraintWidget2.f7138z;
                            if (i29 > 0) {
                                i13 = Math.min(i29, i13);
                            }
                            int i30 = constraintWidget2.B;
                            if (i30 > 0) {
                                i15 = Math.max(i30, measuredHeight);
                                i17 = i11;
                            } else {
                                i17 = i11;
                                i15 = measuredHeight;
                            }
                            int i31 = constraintWidget2.C;
                            if (i31 > 0) {
                                i15 = Math.min(i31, i15);
                            }
                            if (!Optimizer.b(ConstraintLayout.this.mOptimizationLevel, 1)) {
                                if (z17 && z15) {
                                    i13 = (int) ((((float) i15) * constraintWidget2.f7097e0) + 0.5f);
                                } else if (z18 && z16) {
                                    i15 = (int) ((((float) i13) / constraintWidget2.f7097e0) + 0.5f);
                                }
                            }
                            if (!(measuredWidth == i13 && measuredHeight == i15)) {
                                int makeMeasureSpec = measuredWidth != i13 ? View.MeasureSpec.makeMeasureSpec(i13, 1073741824) : i17;
                                if (measuredHeight != i15) {
                                    i12 = View.MeasureSpec.makeMeasureSpec(i15, 1073741824);
                                }
                                view.measure(makeMeasureSpec, i12);
                                constraintWidget2.Q0(makeMeasureSpec, i12);
                                i13 = view.getMeasuredWidth();
                                i15 = view.getMeasuredHeight();
                                i14 = view.getBaseline();
                            }
                            i16 = -1;
                        } else {
                            i16 = -1;
                            i15 = 0;
                            i14 = 0;
                            i13 = 0;
                        }
                        boolean z19 = i14 != i16;
                        measure2.f7249i = (i13 == measure2.f7243c && i15 == measure2.f7244d) ? false : true;
                        if (layoutParams.f7939f0) {
                            z19 = true;
                        }
                        if (!(!z19 || i14 == -1 || constraintWidget.q() == i14)) {
                            measure2.f7249i = true;
                        }
                        measure2.f7245e = i13;
                        measure2.f7246f = i15;
                        measure2.f7248h = z19;
                        measure2.f7247g = i14;
                    }
                }
            }
        }

        public void c(int i11, int i12, int i13, int i14, int i15, int i16) {
            this.f7979b = i13;
            this.f7980c = i14;
            this.f7981d = i15;
            this.f7982e = i16;
            this.f7983f = i11;
            this.f7984g = i12;
        }

        public final boolean d(int i11, int i12, int i13) {
            if (i11 == i12) {
                return true;
            }
            int mode = View.MeasureSpec.getMode(i11);
            View.MeasureSpec.getSize(i11);
            int mode2 = View.MeasureSpec.getMode(i12);
            int size = View.MeasureSpec.getSize(i12);
            if (mode2 != 1073741824) {
                return false;
            }
            if ((mode == Integer.MIN_VALUE || mode == 0) && i13 == size) {
                return true;
            }
            return false;
        }
    }

    public ConstraintLayout(Context context) {
        super(context);
        init((AttributeSet) null, 0, 0);
    }

    private int getPaddingWidth() {
        int i11 = 0;
        int max = Math.max(0, getPaddingLeft()) + Math.max(0, getPaddingRight());
        if (Build.VERSION.SDK_INT >= 17) {
            i11 = Math.max(0, getPaddingEnd()) + Math.max(0, getPaddingStart());
        }
        return i11 > 0 ? i11 : max;
    }

    public static SharedValues getSharedValues() {
        if (sSharedValues == null) {
            sSharedValues = new SharedValues();
        }
        return sSharedValues;
    }

    private final ConstraintWidget getTargetWidget(int i11) {
        if (i11 == 0) {
            return this.mLayoutWidget;
        }
        View view = this.mChildrenByIds.get(i11);
        if (view == null && (view = findViewById(i11)) != null && view != this && view.getParent() == this) {
            onViewAdded(view);
        }
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f7969u0;
    }

    private void init(AttributeSet attributeSet, int i11, int i12) {
        this.mLayoutWidget.w0(this);
        this.mLayoutWidget.R1(this.mMeasurer);
        this.mChildrenByIds.put(getId(), this);
        this.mConstraintSet = null;
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout, i11, i12);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i13 = 0; i13 < indexCount; i13++) {
                int index = obtainStyledAttributes.getIndex(i13);
                if (index == R$styleable.ConstraintLayout_Layout_android_minWidth) {
                    this.mMinWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_minHeight) {
                    this.mMinHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMinHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxWidth) {
                    this.mMaxWidth = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxWidth);
                } else if (index == R$styleable.ConstraintLayout_Layout_android_maxHeight) {
                    this.mMaxHeight = obtainStyledAttributes.getDimensionPixelOffset(index, this.mMaxHeight);
                } else if (index == R$styleable.ConstraintLayout_Layout_layout_optimizationLevel) {
                    this.mOptimizationLevel = obtainStyledAttributes.getInt(index, this.mOptimizationLevel);
                } else if (index == R$styleable.ConstraintLayout_Layout_layoutDescription) {
                    int resourceId = obtainStyledAttributes.getResourceId(index, 0);
                    if (resourceId != 0) {
                        try {
                            parseLayoutDescription(resourceId);
                        } catch (Resources.NotFoundException unused) {
                            this.mConstraintLayoutSpec = null;
                        }
                    }
                } else if (index == R$styleable.ConstraintLayout_Layout_constraintSet) {
                    int resourceId2 = obtainStyledAttributes.getResourceId(index, 0);
                    try {
                        ConstraintSet constraintSet = new ConstraintSet();
                        this.mConstraintSet = constraintSet;
                        constraintSet.D(getContext(), resourceId2);
                    } catch (Resources.NotFoundException unused2) {
                        this.mConstraintSet = null;
                    }
                    this.mConstraintSetId = resourceId2;
                }
            }
            obtainStyledAttributes.recycle();
        }
        this.mLayoutWidget.S1(this.mOptimizationLevel);
    }

    private void markHierarchyDirty() {
        this.mDirtyHierarchy = true;
        this.mLastMeasureWidth = -1;
        this.mLastMeasureHeight = -1;
        this.mLastMeasureWidthSize = -1;
        this.mLastMeasureHeightSize = -1;
        this.mLastMeasureWidthMode = 0;
        this.mLastMeasureHeightMode = 0;
    }

    private void setChildrenConstraints() {
        boolean isInEditMode = isInEditMode();
        int childCount = getChildCount();
        for (int i11 = 0; i11 < childCount; i11++) {
            ConstraintWidget viewWidget = getViewWidget(getChildAt(i11));
            if (viewWidget != null) {
                viewWidget.r0();
            }
        }
        if (isInEditMode) {
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                try {
                    String resourceName = getResources().getResourceName(childAt.getId());
                    setDesignInformation(0, resourceName, Integer.valueOf(childAt.getId()));
                    int indexOf = resourceName.indexOf(47);
                    if (indexOf != -1) {
                        resourceName = resourceName.substring(indexOf + 1);
                    }
                    getTargetWidget(childAt.getId()).x0(resourceName);
                } catch (Resources.NotFoundException unused) {
                }
            }
        }
        if (this.mConstraintSetId != -1) {
            for (int i13 = 0; i13 < childCount; i13++) {
                View childAt2 = getChildAt(i13);
                if (childAt2.getId() == this.mConstraintSetId && (childAt2 instanceof Constraints)) {
                    this.mConstraintSet = ((Constraints) childAt2).getConstraintSet();
                }
            }
        }
        ConstraintSet constraintSet = this.mConstraintSet;
        if (constraintSet != null) {
            constraintSet.k(this, true);
        }
        this.mLayoutWidget.p1();
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i14 = 0; i14 < size; i14++) {
                this.mConstraintHelpers.get(i14).r(this);
            }
        }
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt3 = getChildAt(i15);
            if (childAt3 instanceof Placeholder) {
                ((Placeholder) childAt3).c(this);
            }
        }
        this.mTempMapIdToWidget.clear();
        this.mTempMapIdToWidget.put(0, this.mLayoutWidget);
        this.mTempMapIdToWidget.put(getId(), this.mLayoutWidget);
        for (int i16 = 0; i16 < childCount; i16++) {
            View childAt4 = getChildAt(i16);
            this.mTempMapIdToWidget.put(childAt4.getId(), getViewWidget(childAt4));
        }
        for (int i17 = 0; i17 < childCount; i17++) {
            View childAt5 = getChildAt(i17);
            ConstraintWidget viewWidget2 = getViewWidget(childAt5);
            if (viewWidget2 != null) {
                this.mLayoutWidget.a(viewWidget2);
                applyConstraintsFromLayoutParams(isInEditMode, childAt5, viewWidget2, (LayoutParams) childAt5.getLayoutParams(), this.mTempMapIdToWidget);
            }
        }
    }

    private void setWidgetBaseline(ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray, int i11, ConstraintAnchor.Type type) {
        View view = this.mChildrenByIds.get(i11);
        ConstraintWidget constraintWidget2 = sparseArray.get(i11);
        if (constraintWidget2 != null && view != null && (view.getLayoutParams() instanceof LayoutParams)) {
            layoutParams.f7939f0 = true;
            ConstraintAnchor.Type type2 = ConstraintAnchor.Type.BASELINE;
            if (type == type2) {
                LayoutParams layoutParams2 = (LayoutParams) view.getLayoutParams();
                layoutParams2.f7939f0 = true;
                layoutParams2.f7969u0.F0(true);
            }
            constraintWidget.p(type2).b(constraintWidget2.p(type), layoutParams.C, layoutParams.B, true);
            constraintWidget.F0(true);
            constraintWidget.p(ConstraintAnchor.Type.TOP).q();
            constraintWidget.p(ConstraintAnchor.Type.BOTTOM).q();
        }
    }

    private boolean updateHierarchy() {
        int childCount = getChildCount();
        boolean z11 = false;
        int i11 = 0;
        while (true) {
            if (i11 >= childCount) {
                break;
            } else if (getChildAt(i11).isLayoutRequested()) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            setChildrenConstraints();
        }
        return z11;
    }

    public void applyConstraintsFromLayoutParams(boolean z11, View view, ConstraintWidget constraintWidget, LayoutParams layoutParams, SparseArray<ConstraintWidget> sparseArray) {
        float f11;
        int i11;
        int i12;
        int i13;
        int i14;
        ConstraintWidget constraintWidget2;
        ConstraintWidget constraintWidget3;
        ConstraintWidget constraintWidget4;
        ConstraintWidget constraintWidget5;
        View view2 = view;
        ConstraintWidget constraintWidget6 = constraintWidget;
        LayoutParams layoutParams2 = layoutParams;
        SparseArray<ConstraintWidget> sparseArray2 = sparseArray;
        layoutParams.c();
        layoutParams2.f7971v0 = false;
        constraintWidget6.e1(view.getVisibility());
        if (layoutParams2.f7945i0) {
            constraintWidget6.O0(true);
            constraintWidget6.e1(8);
        }
        constraintWidget6.w0(view2);
        if (view2 instanceof ConstraintHelper) {
            ((ConstraintHelper) view2).m(constraintWidget6, this.mLayoutWidget.L1());
        }
        if (layoutParams2.f7941g0) {
            Guideline guideline = (Guideline) constraintWidget6;
            int i15 = layoutParams2.f7963r0;
            int i16 = layoutParams2.f7965s0;
            float f12 = layoutParams2.f7967t0;
            if (Build.VERSION.SDK_INT < 17) {
                i15 = layoutParams2.f7928a;
                i16 = layoutParams2.f7930b;
                f12 = layoutParams2.f7932c;
            }
            if (f12 != -1.0f) {
                guideline.u1(f12);
            } else if (i15 != -1) {
                guideline.s1(i15);
            } else if (i16 != -1) {
                guideline.t1(i16);
            }
        } else {
            int i17 = layoutParams2.f7949k0;
            int i18 = layoutParams2.f7951l0;
            int i19 = layoutParams2.f7953m0;
            int i21 = layoutParams2.f7955n0;
            int i22 = layoutParams2.f7957o0;
            int i23 = layoutParams2.f7959p0;
            float f13 = layoutParams2.f7961q0;
            if (Build.VERSION.SDK_INT < 17) {
                i17 = layoutParams2.f7934d;
                int i24 = layoutParams2.f7936e;
                int i25 = layoutParams2.f7938f;
                int i26 = layoutParams2.f7940g;
                int i27 = layoutParams2.f7970v;
                int i28 = layoutParams2.f7973x;
                float f14 = layoutParams2.F;
                if (i17 == -1 && i24 == -1) {
                    int i29 = layoutParams2.f7964s;
                    if (i29 != -1) {
                        i17 = i29;
                    } else {
                        int i30 = layoutParams2.f7962r;
                        if (i30 != -1) {
                            i24 = i30;
                        }
                    }
                }
                if (i25 == -1 && i26 == -1) {
                    i13 = layoutParams2.f7966t;
                    if (i13 == -1) {
                        int i31 = layoutParams2.f7968u;
                        if (i31 != -1) {
                            i11 = i28;
                            f11 = f14;
                            i22 = i27;
                            i12 = i31;
                            i18 = i24;
                            i13 = i25;
                        }
                    }
                    i11 = i28;
                    f11 = f14;
                    i22 = i27;
                    i12 = i26;
                    i18 = i24;
                }
                i13 = i25;
                i11 = i28;
                f11 = f14;
                i22 = i27;
                i12 = i26;
                i18 = i24;
            } else {
                i11 = i23;
                f11 = f13;
                i13 = i19;
                i12 = i21;
            }
            int i32 = layoutParams2.f7956o;
            if (i32 != -1) {
                ConstraintWidget constraintWidget7 = sparseArray2.get(i32);
                if (constraintWidget7 != null) {
                    constraintWidget6.l(constraintWidget7, layoutParams2.f7960q, layoutParams2.f7958p);
                }
            } else {
                if (i17 != -1) {
                    ConstraintWidget constraintWidget8 = sparseArray2.get(i17);
                    if (constraintWidget8 != null) {
                        ConstraintAnchor.Type type = ConstraintAnchor.Type.LEFT;
                        constraintWidget.c0(type, constraintWidget8, type, layoutParams2.leftMargin, i22);
                    }
                } else if (!(i18 == -1 || (constraintWidget5 = sparseArray2.get(i18)) == null)) {
                    constraintWidget.c0(ConstraintAnchor.Type.LEFT, constraintWidget5, ConstraintAnchor.Type.RIGHT, layoutParams2.leftMargin, i22);
                }
                if (i13 != -1) {
                    ConstraintWidget constraintWidget9 = sparseArray2.get(i13);
                    if (constraintWidget9 != null) {
                        constraintWidget.c0(ConstraintAnchor.Type.RIGHT, constraintWidget9, ConstraintAnchor.Type.LEFT, layoutParams2.rightMargin, i11);
                    }
                } else if (!(i12 == -1 || (constraintWidget4 = sparseArray2.get(i12)) == null)) {
                    ConstraintAnchor.Type type2 = ConstraintAnchor.Type.RIGHT;
                    constraintWidget.c0(type2, constraintWidget4, type2, layoutParams2.rightMargin, i11);
                }
                int i33 = layoutParams2.f7942h;
                if (i33 != -1) {
                    ConstraintWidget constraintWidget10 = sparseArray2.get(i33);
                    if (constraintWidget10 != null) {
                        ConstraintAnchor.Type type3 = ConstraintAnchor.Type.TOP;
                        constraintWidget.c0(type3, constraintWidget10, type3, layoutParams2.topMargin, layoutParams2.f7972w);
                    }
                } else {
                    int i34 = layoutParams2.f7944i;
                    if (!(i34 == -1 || (constraintWidget3 = sparseArray2.get(i34)) == null)) {
                        constraintWidget.c0(ConstraintAnchor.Type.TOP, constraintWidget3, ConstraintAnchor.Type.BOTTOM, layoutParams2.topMargin, layoutParams2.f7972w);
                    }
                }
                int i35 = layoutParams2.f7946j;
                if (i35 != -1) {
                    ConstraintWidget constraintWidget11 = sparseArray2.get(i35);
                    if (constraintWidget11 != null) {
                        constraintWidget.c0(ConstraintAnchor.Type.BOTTOM, constraintWidget11, ConstraintAnchor.Type.TOP, layoutParams2.bottomMargin, layoutParams2.f7974y);
                    }
                } else {
                    int i36 = layoutParams2.f7948k;
                    if (!(i36 == -1 || (constraintWidget2 = sparseArray2.get(i36)) == null)) {
                        ConstraintAnchor.Type type4 = ConstraintAnchor.Type.BOTTOM;
                        constraintWidget.c0(type4, constraintWidget2, type4, layoutParams2.bottomMargin, layoutParams2.f7974y);
                    }
                }
                int i37 = layoutParams2.f7950l;
                if (i37 != -1) {
                    setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i37, ConstraintAnchor.Type.BASELINE);
                } else {
                    int i38 = layoutParams2.f7952m;
                    if (i38 != -1) {
                        setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i38, ConstraintAnchor.Type.TOP);
                    } else {
                        int i39 = layoutParams2.f7954n;
                        if (i39 != -1) {
                            setWidgetBaseline(constraintWidget, layoutParams, sparseArray, i39, ConstraintAnchor.Type.BOTTOM);
                        }
                    }
                }
                if (f11 >= 0.0f) {
                    constraintWidget6.H0(f11);
                }
                float f15 = layoutParams2.G;
                if (f15 >= 0.0f) {
                    constraintWidget6.Y0(f15);
                }
            }
            if (z11 && !((i14 = layoutParams2.W) == -1 && layoutParams2.X == -1)) {
                constraintWidget6.W0(i14, layoutParams2.X);
            }
            if (layoutParams2.f7935d0) {
                constraintWidget6.K0(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.f1(layoutParams2.width);
                if (layoutParams2.width == -2) {
                    constraintWidget6.K0(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (layoutParams2.width == -1) {
                if (layoutParams2.Z) {
                    constraintWidget6.K0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.K0(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.p(ConstraintAnchor.Type.LEFT).f7084g = layoutParams2.leftMargin;
                constraintWidget6.p(ConstraintAnchor.Type.RIGHT).f7084g = layoutParams2.rightMargin;
            } else {
                constraintWidget6.K0(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.f1(0);
            }
            if (layoutParams2.f7937e0) {
                constraintWidget6.b1(ConstraintWidget.DimensionBehaviour.FIXED);
                constraintWidget6.G0(layoutParams2.height);
                if (layoutParams2.height == -2) {
                    constraintWidget6.b1(ConstraintWidget.DimensionBehaviour.WRAP_CONTENT);
                }
            } else if (layoutParams2.height == -1) {
                if (layoutParams2.f7929a0) {
                    constraintWidget6.b1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                } else {
                    constraintWidget6.b1(ConstraintWidget.DimensionBehaviour.MATCH_PARENT);
                }
                constraintWidget6.p(ConstraintAnchor.Type.TOP).f7084g = layoutParams2.topMargin;
                constraintWidget6.p(ConstraintAnchor.Type.BOTTOM).f7084g = layoutParams2.bottomMargin;
            } else {
                constraintWidget6.b1(ConstraintWidget.DimensionBehaviour.MATCH_CONSTRAINT);
                constraintWidget6.G0(0);
            }
            constraintWidget6.y0(layoutParams2.H);
            constraintWidget6.M0(layoutParams2.K);
            constraintWidget6.d1(layoutParams2.L);
            constraintWidget6.I0(layoutParams2.M);
            constraintWidget6.Z0(layoutParams2.N);
            constraintWidget6.g1(layoutParams2.f7933c0);
            constraintWidget6.L0(layoutParams2.O, layoutParams2.Q, layoutParams2.S, layoutParams2.U);
            constraintWidget6.c1(layoutParams2.P, layoutParams2.R, layoutParams2.T, layoutParams2.V);
        }
    }

    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    public void dispatchDraw(Canvas canvas) {
        Object tag;
        int size;
        ArrayList<ConstraintHelper> arrayList = this.mConstraintHelpers;
        if (arrayList != null && (size = arrayList.size()) > 0) {
            for (int i11 = 0; i11 < size; i11++) {
                this.mConstraintHelpers.get(i11).p(this);
            }
        }
        super.dispatchDraw(canvas);
        if (isInEditMode()) {
            float width = (float) getWidth();
            float height = (float) getHeight();
            int childCount = getChildCount();
            for (int i12 = 0; i12 < childCount; i12++) {
                View childAt = getChildAt(i12);
                if (!(childAt.getVisibility() == 8 || (tag = childAt.getTag()) == null || !(tag instanceof String))) {
                    String[] split = ((String) tag).split(Constants.ACCEPT_TIME_SEPARATOR_SP);
                    if (split.length == 4) {
                        int parseInt = Integer.parseInt(split[0]);
                        int parseInt2 = Integer.parseInt(split[1]);
                        int parseInt3 = Integer.parseInt(split[2]);
                        int i13 = (int) ((((float) parseInt) / 1080.0f) * width);
                        int i14 = (int) ((((float) parseInt2) / 1920.0f) * height);
                        Paint paint = new Paint();
                        paint.setColor(-65536);
                        float f11 = (float) i13;
                        float f12 = (float) (i13 + ((int) ((((float) parseInt3) / 1080.0f) * width)));
                        Canvas canvas2 = canvas;
                        float f13 = (float) i14;
                        float f14 = f11;
                        float f15 = f11;
                        float f16 = f13;
                        Paint paint2 = paint;
                        float f17 = f12;
                        Paint paint3 = paint2;
                        canvas2.drawLine(f14, f16, f17, f13, paint3);
                        float parseInt4 = (float) (i14 + ((int) ((((float) Integer.parseInt(split[3])) / 1920.0f) * height)));
                        float f18 = f12;
                        float f19 = parseInt4;
                        canvas2.drawLine(f18, f16, f17, f19, paint3);
                        float f21 = parseInt4;
                        float f22 = f15;
                        canvas2.drawLine(f18, f21, f22, f19, paint3);
                        float f23 = f15;
                        canvas2.drawLine(f23, f21, f22, f13, paint3);
                        Paint paint4 = paint2;
                        paint4.setColor(-16711936);
                        Paint paint5 = paint4;
                        float f24 = f12;
                        Paint paint6 = paint5;
                        canvas2.drawLine(f23, f13, f24, parseInt4, paint6);
                        canvas2.drawLine(f23, parseInt4, f24, f13, paint6);
                    }
                }
            }
        }
    }

    public void fillMetrics(Metrics metrics) {
        this.mMetrics = metrics;
        this.mLayoutWidget.D1(metrics);
    }

    public void forceLayout() {
        markHierarchyDirty();
        super.forceLayout();
    }

    public Object getDesignInformation(int i11, Object obj) {
        if (i11 != 0 || !(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        HashMap<String, Integer> hashMap = this.mDesignIds;
        if (hashMap == null || !hashMap.containsKey(str)) {
            return null;
        }
        return this.mDesignIds.get(str);
    }

    public int getMaxHeight() {
        return this.mMaxHeight;
    }

    public int getMaxWidth() {
        return this.mMaxWidth;
    }

    public int getMinHeight() {
        return this.mMinHeight;
    }

    public int getMinWidth() {
        return this.mMinWidth;
    }

    public int getOptimizationLevel() {
        return this.mLayoutWidget.F1();
    }

    public View getViewById(int i11) {
        return this.mChildrenByIds.get(i11);
    }

    public final ConstraintWidget getViewWidget(View view) {
        if (view == this) {
            return this.mLayoutWidget;
        }
        if (view == null) {
            return null;
        }
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f7969u0;
        }
        view.setLayoutParams(generateLayoutParams(view.getLayoutParams()));
        if (view.getLayoutParams() instanceof LayoutParams) {
            return ((LayoutParams) view.getLayoutParams()).f7969u0;
        }
        return null;
    }

    public boolean isRtl() {
        if (Build.VERSION.SDK_INT < 17) {
            return false;
        }
        if (!((getContext().getApplicationInfo().flags & 4194304) != 0) || 1 != getLayoutDirection()) {
            return false;
        }
        return true;
    }

    public void loadLayoutDescription(int i11) {
        if (i11 != 0) {
            try {
                this.mConstraintLayoutSpec = new n0.a(getContext(), this, i11);
            } catch (Resources.NotFoundException unused) {
                this.mConstraintLayoutSpec = null;
            }
        } else {
            this.mConstraintLayoutSpec = null;
        }
    }

    public void onLayout(boolean z11, int i11, int i12, int i13, int i14) {
        View content;
        int childCount = getChildCount();
        boolean isInEditMode = isInEditMode();
        for (int i15 = 0; i15 < childCount; i15++) {
            View childAt = getChildAt(i15);
            LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
            ConstraintWidget constraintWidget = layoutParams.f7969u0;
            if ((childAt.getVisibility() != 8 || layoutParams.f7941g0 || layoutParams.f7943h0 || layoutParams.f7947j0 || isInEditMode) && !layoutParams.f7945i0) {
                int V = constraintWidget.V();
                int W = constraintWidget.W();
                int U = constraintWidget.U() + V;
                int y11 = constraintWidget.y() + W;
                childAt.layout(V, W, U, y11);
                if ((childAt instanceof Placeholder) && (content = ((Placeholder) childAt).getContent()) != null) {
                    content.setVisibility(0);
                    content.layout(V, W, U, y11);
                }
            }
        }
        int size = this.mConstraintHelpers.size();
        if (size > 0) {
            for (int i16 = 0; i16 < size; i16++) {
                this.mConstraintHelpers.get(i16).n(this);
            }
        }
    }

    public void onMeasure(int i11, int i12) {
        if (this.mOnMeasureWidthMeasureSpec == i11) {
            int i13 = this.mOnMeasureHeightMeasureSpec;
        }
        if (!this.mDirtyHierarchy) {
            int childCount = getChildCount();
            int i14 = 0;
            while (true) {
                if (i14 >= childCount) {
                    break;
                } else if (getChildAt(i14).isLayoutRequested()) {
                    this.mDirtyHierarchy = true;
                    break;
                } else {
                    i14++;
                }
            }
        }
        boolean z11 = this.mDirtyHierarchy;
        this.mOnMeasureWidthMeasureSpec = i11;
        this.mOnMeasureHeightMeasureSpec = i12;
        this.mLayoutWidget.U1(isRtl());
        if (this.mDirtyHierarchy) {
            this.mDirtyHierarchy = false;
            if (updateHierarchy()) {
                this.mLayoutWidget.W1();
            }
        }
        resolveSystem(this.mLayoutWidget, this.mOptimizationLevel, i11, i12);
        resolveMeasuredDimension(i11, i12, this.mLayoutWidget.U(), this.mLayoutWidget.y(), this.mLayoutWidget.M1(), this.mLayoutWidget.K1());
    }

    public void onViewAdded(View view) {
        super.onViewAdded(view);
        ConstraintWidget viewWidget = getViewWidget(view);
        if ((view instanceof Guideline) && !(viewWidget instanceof Guideline)) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Guideline guideline = new Guideline();
            layoutParams.f7969u0 = guideline;
            layoutParams.f7941g0 = true;
            guideline.v1(layoutParams.Y);
        }
        if (view instanceof ConstraintHelper) {
            ConstraintHelper constraintHelper = (ConstraintHelper) view;
            constraintHelper.s();
            ((LayoutParams) view.getLayoutParams()).f7943h0 = true;
            if (!this.mConstraintHelpers.contains(constraintHelper)) {
                this.mConstraintHelpers.add(constraintHelper);
            }
        }
        this.mChildrenByIds.put(view.getId(), view);
        this.mDirtyHierarchy = true;
    }

    public void onViewRemoved(View view) {
        super.onViewRemoved(view);
        this.mChildrenByIds.remove(view.getId());
        this.mLayoutWidget.o1(getViewWidget(view));
        this.mConstraintHelpers.remove(view);
        this.mDirtyHierarchy = true;
    }

    public void parseLayoutDescription(int i11) {
        this.mConstraintLayoutSpec = new n0.a(getContext(), this, i11);
    }

    public void requestLayout() {
        markHierarchyDirty();
        super.requestLayout();
    }

    public void resolveMeasuredDimension(int i11, int i12, int i13, int i14, boolean z11, boolean z12) {
        b bVar = this.mMeasurer;
        int i15 = bVar.f7982e;
        int resolveSizeAndState = ViewGroup.resolveSizeAndState(i13 + bVar.f7981d, i11, 0);
        int resolveSizeAndState2 = ViewGroup.resolveSizeAndState(i14 + i15, i12, 0);
        int i16 = resolveSizeAndState & FlexItem.MAX_SIZE;
        int i17 = resolveSizeAndState2 & FlexItem.MAX_SIZE;
        int min = Math.min(this.mMaxWidth, i16);
        int min2 = Math.min(this.mMaxHeight, i17);
        if (z11) {
            min |= 16777216;
        }
        if (z12) {
            min2 |= 16777216;
        }
        setMeasuredDimension(min, min2);
        this.mLastMeasureWidth = min;
        this.mLastMeasureHeight = min2;
    }

    public void resolveSystem(ConstraintWidgetContainer constraintWidgetContainer, int i11, int i12, int i13) {
        int i14;
        int mode = View.MeasureSpec.getMode(i12);
        int size = View.MeasureSpec.getSize(i12);
        int mode2 = View.MeasureSpec.getMode(i13);
        int size2 = View.MeasureSpec.getSize(i13);
        int max = Math.max(0, getPaddingTop());
        int max2 = Math.max(0, getPaddingBottom());
        int i15 = max + max2;
        int paddingWidth = getPaddingWidth();
        this.mMeasurer.c(i12, i13, max, max2, paddingWidth, i15);
        if (Build.VERSION.SDK_INT >= 17) {
            int max3 = Math.max(0, getPaddingStart());
            int max4 = Math.max(0, getPaddingEnd());
            if (max3 <= 0 && max4 <= 0) {
                max3 = Math.max(0, getPaddingLeft());
            } else if (isRtl()) {
                max3 = max4;
            }
            i14 = max3;
        } else {
            i14 = Math.max(0, getPaddingLeft());
        }
        int i16 = size - paddingWidth;
        int i17 = size2 - i15;
        setSelfDimensionBehaviour(constraintWidgetContainer, mode, i16, mode2, i17);
        constraintWidgetContainer.N1(i11, mode, i16, mode2, i17, this.mLastMeasureWidth, this.mLastMeasureHeight, i14, max);
    }

    public void setConstraintSet(ConstraintSet constraintSet) {
        this.mConstraintSet = constraintSet;
    }

    public void setDesignInformation(int i11, Object obj, Object obj2) {
        if (i11 == 0 && (obj instanceof String) && (obj2 instanceof Integer)) {
            if (this.mDesignIds == null) {
                this.mDesignIds = new HashMap<>();
            }
            String str = (String) obj;
            int indexOf = str.indexOf("/");
            if (indexOf != -1) {
                str = str.substring(indexOf + 1);
            }
            this.mDesignIds.put(str, Integer.valueOf(((Integer) obj2).intValue()));
        }
    }

    public void setId(int i11) {
        this.mChildrenByIds.remove(getId());
        super.setId(i11);
        this.mChildrenByIds.put(getId(), this);
    }

    public void setMaxHeight(int i11) {
        if (i11 != this.mMaxHeight) {
            this.mMaxHeight = i11;
            requestLayout();
        }
    }

    public void setMaxWidth(int i11) {
        if (i11 != this.mMaxWidth) {
            this.mMaxWidth = i11;
            requestLayout();
        }
    }

    public void setMinHeight(int i11) {
        if (i11 != this.mMinHeight) {
            this.mMinHeight = i11;
            requestLayout();
        }
    }

    public void setMinWidth(int i11) {
        if (i11 != this.mMinWidth) {
            this.mMinWidth = i11;
            requestLayout();
        }
    }

    public void setOnConstraintsChanged(ConstraintsChangedListener constraintsChangedListener) {
        this.mConstraintsChangedListener = constraintsChangedListener;
        n0.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.c(constraintsChangedListener);
        }
    }

    public void setOptimizationLevel(int i11) {
        this.mOptimizationLevel = i11;
        this.mLayoutWidget.S1(i11);
    }

    public void setSelfDimensionBehaviour(ConstraintWidgetContainer constraintWidgetContainer, int i11, int i12, int i13, int i14) {
        ConstraintWidget.DimensionBehaviour dimensionBehaviour;
        b bVar = this.mMeasurer;
        int i15 = bVar.f7982e;
        int i16 = bVar.f7981d;
        ConstraintWidget.DimensionBehaviour dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.FIXED;
        int childCount = getChildCount();
        if (i11 != Integer.MIN_VALUE) {
            if (i11 == 0) {
                dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i12 = Math.max(0, this.mMinWidth);
                }
            } else if (i11 != 1073741824) {
                dimensionBehaviour = dimensionBehaviour2;
            } else {
                i12 = Math.min(this.mMaxWidth - i16, i12);
                dimensionBehaviour = dimensionBehaviour2;
            }
            i12 = 0;
        } else {
            dimensionBehaviour = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i12 = Math.max(0, this.mMinWidth);
            }
        }
        if (i13 != Integer.MIN_VALUE) {
            if (i13 == 0) {
                dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
                if (childCount == 0) {
                    i14 = Math.max(0, this.mMinHeight);
                }
            } else if (i13 == 1073741824) {
                i14 = Math.min(this.mMaxHeight - i15, i14);
            }
            i14 = 0;
        } else {
            dimensionBehaviour2 = ConstraintWidget.DimensionBehaviour.WRAP_CONTENT;
            if (childCount == 0) {
                i14 = Math.max(0, this.mMinHeight);
            }
        }
        if (!(i12 == constraintWidgetContainer.U() && i14 == constraintWidgetContainer.y())) {
            constraintWidgetContainer.J1();
        }
        constraintWidgetContainer.h1(0);
        constraintWidgetContainer.i1(0);
        constraintWidgetContainer.S0(this.mMaxWidth - i16);
        constraintWidgetContainer.R0(this.mMaxHeight - i15);
        constraintWidgetContainer.V0(0);
        constraintWidgetContainer.U0(0);
        constraintWidgetContainer.K0(dimensionBehaviour);
        constraintWidgetContainer.f1(i12);
        constraintWidgetContainer.b1(dimensionBehaviour2);
        constraintWidgetContainer.G0(i14);
        constraintWidgetContainer.V0(this.mMinWidth - i16);
        constraintWidgetContainer.U0(this.mMinHeight - i15);
    }

    public void setState(int i11, int i12, int i13) {
        n0.a aVar = this.mConstraintLayoutSpec;
        if (aVar != null) {
            aVar.d(i11, (float) i12, (float) i13);
        }
    }

    public boolean shouldDelayChildPressedState() {
        return false;
    }

    public LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(attributeSet, 0, 0);
    }

    public ConstraintLayout(Context context, AttributeSet attributeSet, int i11) {
        super(context, attributeSet, i11);
        init(attributeSet, i11, 0);
    }

    @TargetApi(21)
    public ConstraintLayout(Context context, AttributeSet attributeSet, int i11, int i12) {
        super(context, attributeSet, i11, i12);
        init(attributeSet, i11, i12);
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {
        public int A = Integer.MIN_VALUE;
        public int B = Integer.MIN_VALUE;
        public int C = 0;
        public boolean D = true;
        public boolean E = true;
        public float F = 0.5f;
        public float G = 0.5f;
        public String H = null;
        public float I = 0.0f;
        public int J = 1;
        public float K = -1.0f;
        public float L = -1.0f;
        public int M = 0;
        public int N = 0;
        public int O = 0;
        public int P = 0;
        public int Q = 0;
        public int R = 0;
        public int S = 0;
        public int T = 0;
        public float U = 1.0f;
        public float V = 1.0f;
        public int W = -1;
        public int X = -1;
        public int Y = -1;
        public boolean Z = false;

        /* renamed from: a  reason: collision with root package name */
        public int f7928a = -1;

        /* renamed from: a0  reason: collision with root package name */
        public boolean f7929a0 = false;

        /* renamed from: b  reason: collision with root package name */
        public int f7930b = -1;

        /* renamed from: b0  reason: collision with root package name */
        public String f7931b0 = null;

        /* renamed from: c  reason: collision with root package name */
        public float f7932c = -1.0f;

        /* renamed from: c0  reason: collision with root package name */
        public int f7933c0 = 0;

        /* renamed from: d  reason: collision with root package name */
        public int f7934d = -1;

        /* renamed from: d0  reason: collision with root package name */
        public boolean f7935d0 = true;

        /* renamed from: e  reason: collision with root package name */
        public int f7936e = -1;

        /* renamed from: e0  reason: collision with root package name */
        public boolean f7937e0 = true;

        /* renamed from: f  reason: collision with root package name */
        public int f7938f = -1;

        /* renamed from: f0  reason: collision with root package name */
        public boolean f7939f0 = false;

        /* renamed from: g  reason: collision with root package name */
        public int f7940g = -1;

        /* renamed from: g0  reason: collision with root package name */
        public boolean f7941g0 = false;

        /* renamed from: h  reason: collision with root package name */
        public int f7942h = -1;

        /* renamed from: h0  reason: collision with root package name */
        public boolean f7943h0 = false;

        /* renamed from: i  reason: collision with root package name */
        public int f7944i = -1;

        /* renamed from: i0  reason: collision with root package name */
        public boolean f7945i0 = false;

        /* renamed from: j  reason: collision with root package name */
        public int f7946j = -1;

        /* renamed from: j0  reason: collision with root package name */
        public boolean f7947j0 = false;

        /* renamed from: k  reason: collision with root package name */
        public int f7948k = -1;

        /* renamed from: k0  reason: collision with root package name */
        public int f7949k0 = -1;

        /* renamed from: l  reason: collision with root package name */
        public int f7950l = -1;

        /* renamed from: l0  reason: collision with root package name */
        public int f7951l0 = -1;

        /* renamed from: m  reason: collision with root package name */
        public int f7952m = -1;

        /* renamed from: m0  reason: collision with root package name */
        public int f7953m0 = -1;

        /* renamed from: n  reason: collision with root package name */
        public int f7954n = -1;

        /* renamed from: n0  reason: collision with root package name */
        public int f7955n0 = -1;

        /* renamed from: o  reason: collision with root package name */
        public int f7956o = -1;

        /* renamed from: o0  reason: collision with root package name */
        public int f7957o0 = Integer.MIN_VALUE;

        /* renamed from: p  reason: collision with root package name */
        public int f7958p = 0;

        /* renamed from: p0  reason: collision with root package name */
        public int f7959p0 = Integer.MIN_VALUE;

        /* renamed from: q  reason: collision with root package name */
        public float f7960q = 0.0f;

        /* renamed from: q0  reason: collision with root package name */
        public float f7961q0 = 0.5f;

        /* renamed from: r  reason: collision with root package name */
        public int f7962r = -1;

        /* renamed from: r0  reason: collision with root package name */
        public int f7963r0;

        /* renamed from: s  reason: collision with root package name */
        public int f7964s = -1;

        /* renamed from: s0  reason: collision with root package name */
        public int f7965s0;

        /* renamed from: t  reason: collision with root package name */
        public int f7966t = -1;

        /* renamed from: t0  reason: collision with root package name */
        public float f7967t0;

        /* renamed from: u  reason: collision with root package name */
        public int f7968u = -1;

        /* renamed from: u0  reason: collision with root package name */
        public ConstraintWidget f7969u0 = new ConstraintWidget();

        /* renamed from: v  reason: collision with root package name */
        public int f7970v = Integer.MIN_VALUE;

        /* renamed from: v0  reason: collision with root package name */
        public boolean f7971v0 = false;

        /* renamed from: w  reason: collision with root package name */
        public int f7972w = Integer.MIN_VALUE;

        /* renamed from: x  reason: collision with root package name */
        public int f7973x = Integer.MIN_VALUE;

        /* renamed from: y  reason: collision with root package name */
        public int f7974y = Integer.MIN_VALUE;

        /* renamed from: z  reason: collision with root package name */
        public int f7975z = Integer.MIN_VALUE;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            public static final SparseIntArray f7976a;

            static {
                SparseIntArray sparseIntArray = new SparseIntArray();
                f7976a = sparseIntArray;
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth, 64);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight, 65);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toLeftOf, 8);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_toRightOf, 9);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toLeftOf, 10);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_toRightOf, 11);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toTopOf, 12);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_toBottomOf, 13);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toTopOf, 14);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_toBottomOf, 15);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBaselineOf, 16);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toTopOf, 52);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_toBottomOf, 53);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircle, 2);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleRadius, 3);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintCircleAngle, 4);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteX, 49);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_editor_absoluteY, 50);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_begin, 5);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_end, 6);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintGuide_percent, 7);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_android_orientation, 1);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toEndOf, 17);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintStart_toStartOf, 18);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toStartOf, 19);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintEnd_toEndOf, 20);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginLeft, 21);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginTop, 22);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginRight, 23);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBottom, 24);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginStart, 25);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginEnd, 26);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_goneMarginBaseline, 55);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_marginBaseline, 54);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_bias, 29);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_bias, 30);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintDimensionRatio, 44);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_weight, 45);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_weight, 46);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHorizontal_chainStyle, 47);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintVertical_chainStyle, 48);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedWidth, 27);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constrainedHeight, 28);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_default, 31);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_default, 32);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_min, 33);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_max, 34);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintWidth_percent, 35);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_min, 36);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_max, 37);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintHeight_percent, 38);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintLeft_creator, 39);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTop_creator, 40);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintRight_creator, 41);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBottom_creator, 42);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintBaseline_creator, 43);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_constraintTag, 51);
                sparseIntArray.append(R$styleable.ConstraintLayout_Layout_layout_wrapBehaviorInParent, 66);
            }
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R$styleable.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i11 = 0; i11 < indexCount; i11++) {
                int index = obtainStyledAttributes.getIndex(i11);
                int i12 = a.f7976a.get(index);
                switch (i12) {
                    case 1:
                        this.Y = obtainStyledAttributes.getInt(index, this.Y);
                        break;
                    case 2:
                        int resourceId = obtainStyledAttributes.getResourceId(index, this.f7956o);
                        this.f7956o = resourceId;
                        if (resourceId != -1) {
                            break;
                        } else {
                            this.f7956o = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 3:
                        this.f7958p = obtainStyledAttributes.getDimensionPixelSize(index, this.f7958p);
                        break;
                    case 4:
                        float f11 = obtainStyledAttributes.getFloat(index, this.f7960q) % 360.0f;
                        this.f7960q = f11;
                        if (f11 >= 0.0f) {
                            break;
                        } else {
                            this.f7960q = (360.0f - f11) % 360.0f;
                            break;
                        }
                    case 5:
                        this.f7928a = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7928a);
                        break;
                    case 6:
                        this.f7930b = obtainStyledAttributes.getDimensionPixelOffset(index, this.f7930b);
                        break;
                    case 7:
                        this.f7932c = obtainStyledAttributes.getFloat(index, this.f7932c);
                        break;
                    case 8:
                        int resourceId2 = obtainStyledAttributes.getResourceId(index, this.f7934d);
                        this.f7934d = resourceId2;
                        if (resourceId2 != -1) {
                            break;
                        } else {
                            this.f7934d = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 9:
                        int resourceId3 = obtainStyledAttributes.getResourceId(index, this.f7936e);
                        this.f7936e = resourceId3;
                        if (resourceId3 != -1) {
                            break;
                        } else {
                            this.f7936e = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 10:
                        int resourceId4 = obtainStyledAttributes.getResourceId(index, this.f7938f);
                        this.f7938f = resourceId4;
                        if (resourceId4 != -1) {
                            break;
                        } else {
                            this.f7938f = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 11:
                        int resourceId5 = obtainStyledAttributes.getResourceId(index, this.f7940g);
                        this.f7940g = resourceId5;
                        if (resourceId5 != -1) {
                            break;
                        } else {
                            this.f7940g = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 12:
                        int resourceId6 = obtainStyledAttributes.getResourceId(index, this.f7942h);
                        this.f7942h = resourceId6;
                        if (resourceId6 != -1) {
                            break;
                        } else {
                            this.f7942h = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 13:
                        int resourceId7 = obtainStyledAttributes.getResourceId(index, this.f7944i);
                        this.f7944i = resourceId7;
                        if (resourceId7 != -1) {
                            break;
                        } else {
                            this.f7944i = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 14:
                        int resourceId8 = obtainStyledAttributes.getResourceId(index, this.f7946j);
                        this.f7946j = resourceId8;
                        if (resourceId8 != -1) {
                            break;
                        } else {
                            this.f7946j = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 15:
                        int resourceId9 = obtainStyledAttributes.getResourceId(index, this.f7948k);
                        this.f7948k = resourceId9;
                        if (resourceId9 != -1) {
                            break;
                        } else {
                            this.f7948k = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 16:
                        int resourceId10 = obtainStyledAttributes.getResourceId(index, this.f7950l);
                        this.f7950l = resourceId10;
                        if (resourceId10 != -1) {
                            break;
                        } else {
                            this.f7950l = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 17:
                        int resourceId11 = obtainStyledAttributes.getResourceId(index, this.f7962r);
                        this.f7962r = resourceId11;
                        if (resourceId11 != -1) {
                            break;
                        } else {
                            this.f7962r = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 18:
                        int resourceId12 = obtainStyledAttributes.getResourceId(index, this.f7964s);
                        this.f7964s = resourceId12;
                        if (resourceId12 != -1) {
                            break;
                        } else {
                            this.f7964s = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 19:
                        int resourceId13 = obtainStyledAttributes.getResourceId(index, this.f7966t);
                        this.f7966t = resourceId13;
                        if (resourceId13 != -1) {
                            break;
                        } else {
                            this.f7966t = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 20:
                        int resourceId14 = obtainStyledAttributes.getResourceId(index, this.f7968u);
                        this.f7968u = resourceId14;
                        if (resourceId14 != -1) {
                            break;
                        } else {
                            this.f7968u = obtainStyledAttributes.getInt(index, -1);
                            break;
                        }
                    case 21:
                        this.f7970v = obtainStyledAttributes.getDimensionPixelSize(index, this.f7970v);
                        break;
                    case 22:
                        this.f7972w = obtainStyledAttributes.getDimensionPixelSize(index, this.f7972w);
                        break;
                    case 23:
                        this.f7973x = obtainStyledAttributes.getDimensionPixelSize(index, this.f7973x);
                        break;
                    case 24:
                        this.f7974y = obtainStyledAttributes.getDimensionPixelSize(index, this.f7974y);
                        break;
                    case 25:
                        this.f7975z = obtainStyledAttributes.getDimensionPixelSize(index, this.f7975z);
                        break;
                    case 26:
                        this.A = obtainStyledAttributes.getDimensionPixelSize(index, this.A);
                        break;
                    case 27:
                        this.Z = obtainStyledAttributes.getBoolean(index, this.Z);
                        break;
                    case 28:
                        this.f7929a0 = obtainStyledAttributes.getBoolean(index, this.f7929a0);
                        break;
                    case 29:
                        this.F = obtainStyledAttributes.getFloat(index, this.F);
                        break;
                    case 30:
                        this.G = obtainStyledAttributes.getFloat(index, this.G);
                        break;
                    case 31:
                        int i13 = obtainStyledAttributes.getInt(index, 0);
                        this.O = i13;
                        if (i13 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintWidth_default=\"wrap\" is deprecated.\nUse layout_width=\"WRAP_CONTENT\" and layout_constrainedWidth=\"true\" instead.");
                            break;
                        }
                    case 32:
                        int i14 = obtainStyledAttributes.getInt(index, 0);
                        this.P = i14;
                        if (i14 != 1) {
                            break;
                        } else {
                            Log.e(ConstraintLayout.TAG, "layout_constraintHeight_default=\"wrap\" is deprecated.\nUse layout_height=\"WRAP_CONTENT\" and layout_constrainedHeight=\"true\" instead.");
                            break;
                        }
                    case 33:
                        try {
                            this.Q = obtainStyledAttributes.getDimensionPixelSize(index, this.Q);
                            break;
                        } catch (Exception unused) {
                            if (obtainStyledAttributes.getInt(index, this.Q) != -2) {
                                break;
                            } else {
                                this.Q = -2;
                                break;
                            }
                        }
                    case 34:
                        try {
                            this.S = obtainStyledAttributes.getDimensionPixelSize(index, this.S);
                            break;
                        } catch (Exception unused2) {
                            if (obtainStyledAttributes.getInt(index, this.S) != -2) {
                                break;
                            } else {
                                this.S = -2;
                                break;
                            }
                        }
                    case 35:
                        this.U = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.U));
                        this.O = 2;
                        break;
                    case 36:
                        try {
                            this.R = obtainStyledAttributes.getDimensionPixelSize(index, this.R);
                            break;
                        } catch (Exception unused3) {
                            if (obtainStyledAttributes.getInt(index, this.R) != -2) {
                                break;
                            } else {
                                this.R = -2;
                                break;
                            }
                        }
                    case 37:
                        try {
                            this.T = obtainStyledAttributes.getDimensionPixelSize(index, this.T);
                            break;
                        } catch (Exception unused4) {
                            if (obtainStyledAttributes.getInt(index, this.T) != -2) {
                                break;
                            } else {
                                this.T = -2;
                                break;
                            }
                        }
                    case 38:
                        this.V = Math.max(0.0f, obtainStyledAttributes.getFloat(index, this.V));
                        this.P = 2;
                        break;
                    default:
                        switch (i12) {
                            case 44:
                                ConstraintSet.I(this, obtainStyledAttributes.getString(index));
                                break;
                            case 45:
                                this.K = obtainStyledAttributes.getFloat(index, this.K);
                                break;
                            case 46:
                                this.L = obtainStyledAttributes.getFloat(index, this.L);
                                break;
                            case 47:
                                this.M = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 48:
                                this.N = obtainStyledAttributes.getInt(index, 0);
                                break;
                            case 49:
                                this.W = obtainStyledAttributes.getDimensionPixelOffset(index, this.W);
                                break;
                            case 50:
                                this.X = obtainStyledAttributes.getDimensionPixelOffset(index, this.X);
                                break;
                            case 51:
                                this.f7931b0 = obtainStyledAttributes.getString(index);
                                break;
                            case 52:
                                int resourceId15 = obtainStyledAttributes.getResourceId(index, this.f7952m);
                                this.f7952m = resourceId15;
                                if (resourceId15 != -1) {
                                    break;
                                } else {
                                    this.f7952m = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 53:
                                int resourceId16 = obtainStyledAttributes.getResourceId(index, this.f7954n);
                                this.f7954n = resourceId16;
                                if (resourceId16 != -1) {
                                    break;
                                } else {
                                    this.f7954n = obtainStyledAttributes.getInt(index, -1);
                                    break;
                                }
                            case 54:
                                this.C = obtainStyledAttributes.getDimensionPixelSize(index, this.C);
                                break;
                            case 55:
                                this.B = obtainStyledAttributes.getDimensionPixelSize(index, this.B);
                                break;
                            default:
                                switch (i12) {
                                    case 64:
                                        ConstraintSet.G(this, obtainStyledAttributes, index, 0);
                                        this.D = true;
                                        break;
                                    case 65:
                                        ConstraintSet.G(this, obtainStyledAttributes, index, 1);
                                        this.E = true;
                                        break;
                                    case 66:
                                        this.f7933c0 = obtainStyledAttributes.getInt(index, this.f7933c0);
                                        break;
                                }
                        }
                }
            }
            obtainStyledAttributes.recycle();
            c();
        }

        public String a() {
            return this.f7931b0;
        }

        public ConstraintWidget b() {
            return this.f7969u0;
        }

        public void c() {
            this.f7941g0 = false;
            this.f7935d0 = true;
            this.f7937e0 = true;
            int i11 = this.width;
            if (i11 == -2 && this.Z) {
                this.f7935d0 = false;
                if (this.O == 0) {
                    this.O = 1;
                }
            }
            int i12 = this.height;
            if (i12 == -2 && this.f7929a0) {
                this.f7937e0 = false;
                if (this.P == 0) {
                    this.P = 1;
                }
            }
            if (i11 == 0 || i11 == -1) {
                this.f7935d0 = false;
                if (i11 == 0 && this.O == 1) {
                    this.width = -2;
                    this.Z = true;
                }
            }
            if (i12 == 0 || i12 == -1) {
                this.f7937e0 = false;
                if (i12 == 0 && this.P == 1) {
                    this.height = -2;
                    this.f7929a0 = true;
                }
            }
            if (this.f7932c != -1.0f || this.f7928a != -1 || this.f7930b != -1) {
                this.f7941g0 = true;
                this.f7935d0 = true;
                this.f7937e0 = true;
                if (!(this.f7969u0 instanceof Guideline)) {
                    this.f7969u0 = new Guideline();
                }
                ((Guideline) this.f7969u0).v1(this.Y);
            }
        }

        /* JADX WARNING: Removed duplicated region for block: B:17:0x0054  */
        /* JADX WARNING: Removed duplicated region for block: B:20:0x005b  */
        /* JADX WARNING: Removed duplicated region for block: B:23:0x0062  */
        /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
        /* JADX WARNING: Removed duplicated region for block: B:29:0x006e  */
        /* JADX WARNING: Removed duplicated region for block: B:36:0x0080  */
        /* JADX WARNING: Removed duplicated region for block: B:37:0x0088  */
        /* JADX WARNING: Removed duplicated region for block: B:41:0x009a  */
        /* JADX WARNING: Removed duplicated region for block: B:67:0x00ce  */
        /* JADX WARNING: Removed duplicated region for block: B:8:0x0041  */
        /* JADX WARNING: Removed duplicated region for block: B:95:? A[RETURN, SYNTHETIC] */
        @android.annotation.TargetApi(17)
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void resolveLayoutDirection(int r11) {
            /*
                r10 = this;
                int r0 = r10.leftMargin
                int r1 = r10.rightMargin
                int r2 = android.os.Build.VERSION.SDK_INT
                r3 = 0
                r4 = 1
                r5 = 17
                if (r2 < r5) goto L_0x0017
                super.resolveLayoutDirection(r11)
                int r11 = r10.getLayoutDirection()
                if (r4 != r11) goto L_0x0017
                r11 = r4
                goto L_0x0018
            L_0x0017:
                r11 = r3
            L_0x0018:
                r2 = -1
                r10.f7953m0 = r2
                r10.f7955n0 = r2
                r10.f7949k0 = r2
                r10.f7951l0 = r2
                r10.f7957o0 = r2
                r10.f7959p0 = r2
                int r5 = r10.f7970v
                r10.f7957o0 = r5
                int r5 = r10.f7973x
                r10.f7959p0 = r5
                float r5 = r10.F
                r10.f7961q0 = r5
                int r6 = r10.f7928a
                r10.f7963r0 = r6
                int r7 = r10.f7930b
                r10.f7965s0 = r7
                float r8 = r10.f7932c
                r10.f7967t0 = r8
                r9 = -2147483648(0xffffffff80000000, float:-0.0)
                if (r11 == 0) goto L_0x009a
                int r11 = r10.f7962r
                if (r11 == r2) goto L_0x0049
                r10.f7953m0 = r11
            L_0x0047:
                r3 = r4
                goto L_0x0050
            L_0x0049:
                int r11 = r10.f7964s
                if (r11 == r2) goto L_0x0050
                r10.f7955n0 = r11
                goto L_0x0047
            L_0x0050:
                int r11 = r10.f7966t
                if (r11 == r2) goto L_0x0057
                r10.f7951l0 = r11
                r3 = r4
            L_0x0057:
                int r11 = r10.f7968u
                if (r11 == r2) goto L_0x005e
                r10.f7949k0 = r11
                r3 = r4
            L_0x005e:
                int r11 = r10.f7975z
                if (r11 == r9) goto L_0x0064
                r10.f7959p0 = r11
            L_0x0064:
                int r11 = r10.A
                if (r11 == r9) goto L_0x006a
                r10.f7957o0 = r11
            L_0x006a:
                r11 = 1065353216(0x3f800000, float:1.0)
                if (r3 == 0) goto L_0x0072
                float r3 = r11 - r5
                r10.f7961q0 = r3
            L_0x0072:
                boolean r3 = r10.f7941g0
                if (r3 == 0) goto L_0x00be
                int r3 = r10.Y
                if (r3 != r4) goto L_0x00be
                r3 = -1082130432(0xffffffffbf800000, float:-1.0)
                int r4 = (r8 > r3 ? 1 : (r8 == r3 ? 0 : -1))
                if (r4 == 0) goto L_0x0088
                float r11 = r11 - r8
                r10.f7967t0 = r11
                r10.f7963r0 = r2
                r10.f7965s0 = r2
                goto L_0x00be
            L_0x0088:
                if (r6 == r2) goto L_0x0091
                r10.f7965s0 = r6
                r10.f7963r0 = r2
                r10.f7967t0 = r3
                goto L_0x00be
            L_0x0091:
                if (r7 == r2) goto L_0x00be
                r10.f7963r0 = r7
                r10.f7965s0 = r2
                r10.f7967t0 = r3
                goto L_0x00be
            L_0x009a:
                int r11 = r10.f7962r
                if (r11 == r2) goto L_0x00a0
                r10.f7951l0 = r11
            L_0x00a0:
                int r11 = r10.f7964s
                if (r11 == r2) goto L_0x00a6
                r10.f7949k0 = r11
            L_0x00a6:
                int r11 = r10.f7966t
                if (r11 == r2) goto L_0x00ac
                r10.f7953m0 = r11
            L_0x00ac:
                int r11 = r10.f7968u
                if (r11 == r2) goto L_0x00b2
                r10.f7955n0 = r11
            L_0x00b2:
                int r11 = r10.f7975z
                if (r11 == r9) goto L_0x00b8
                r10.f7957o0 = r11
            L_0x00b8:
                int r11 = r10.A
                if (r11 == r9) goto L_0x00be
                r10.f7959p0 = r11
            L_0x00be:
                int r11 = r10.f7966t
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f7968u
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f7964s
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f7962r
                if (r11 != r2) goto L_0x0108
                int r11 = r10.f7938f
                if (r11 == r2) goto L_0x00dd
                r10.f7953m0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00eb
                if (r1 <= 0) goto L_0x00eb
                r10.rightMargin = r1
                goto L_0x00eb
            L_0x00dd:
                int r11 = r10.f7940g
                if (r11 == r2) goto L_0x00eb
                r10.f7955n0 = r11
                int r11 = r10.rightMargin
                if (r11 > 0) goto L_0x00eb
                if (r1 <= 0) goto L_0x00eb
                r10.rightMargin = r1
            L_0x00eb:
                int r11 = r10.f7934d
                if (r11 == r2) goto L_0x00fa
                r10.f7949k0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
                r10.leftMargin = r0
                goto L_0x0108
            L_0x00fa:
                int r11 = r10.f7936e
                if (r11 == r2) goto L_0x0108
                r10.f7951l0 = r11
                int r11 = r10.leftMargin
                if (r11 > 0) goto L_0x0108
                if (r0 <= 0) goto L_0x0108
                r10.leftMargin = r0
            L_0x0108:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.constraintlayout.widget.ConstraintLayout.LayoutParams.resolveLayoutDirection(int):void");
        }

        public LayoutParams(int i11, int i12) {
            super(i11, i12);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }
    }
}
