package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.collection.ArrayMap;
import androidx.collection.LongSparseArray;
import androidx.collection.SimpleArrayMap;
import androidx.core.view.h0;
import com.luck.picture.lib.loader.IBridgeMediaLoader;
import com.sumsub.sns.internal.fingerprint.infoproviders.l;
import com.tencent.qcloud.tuikit.tuichat.classicui.widget.input.TIMMentionEditText;
import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;
import s0.i;
import v1.d0;
import v1.n;
import v1.u;

public abstract class Transition implements Cloneable {
    public static final boolean DBG = false;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private static final PathMotion STRAIGHT_PATH_MOTION = new a();
    private static ThreadLocal<ArrayMap<Animator, d>> sRunningAnimators = new ThreadLocal<>();
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    public boolean mCanRemoveViews = false;
    public ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    public long mDuration = -1;
    private n mEndValues = new n();
    private ArrayList<TransitionValues> mEndValuesList;
    private boolean mEnded = false;
    private EpicenterCallback mEpicenterCallback;
    private TimeInterpolator mInterpolator = null;
    private ArrayList<f> mListeners = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private String mName = getClass().getName();
    private ArrayMap<String, String> mNameOverrides;
    private int mNumInstances = 0;
    public TransitionSet mParent = null;
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;
    private boolean mPaused = false;
    public TransitionPropagation mPropagation;
    private ViewGroup mSceneRoot = null;
    private long mStartDelay = -1;
    private n mStartValues = new n();
    private ArrayList<TransitionValues> mStartValuesList;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    public ArrayList<Integer> mTargetIds = new ArrayList<>();
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    public ArrayList<View> mTargets = new ArrayList<>();

    public static abstract class EpicenterCallback {
        public abstract Rect a(Transition transition);
    }

    public static class a extends PathMotion {
        public Path getPath(float f11, float f12, float f13, float f14) {
            Path path = new Path();
            path.moveTo(f11, f12);
            path.lineTo(f13, f14);
            return path;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ArrayMap f11840b;

        public b(ArrayMap arrayMap) {
            this.f11840b = arrayMap;
        }

        public void onAnimationEnd(Animator animator) {
            this.f11840b.remove(animator);
            Transition.this.mCurrentAnimators.remove(animator);
        }

        public void onAnimationStart(Animator animator) {
            Transition.this.mCurrentAnimators.add(animator);
        }
    }

    public class c extends AnimatorListenerAdapter {
        public c() {
        }

        public void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    public static class d {

        /* renamed from: a  reason: collision with root package name */
        public View f11843a;

        /* renamed from: b  reason: collision with root package name */
        public String f11844b;

        /* renamed from: c  reason: collision with root package name */
        public TransitionValues f11845c;

        /* renamed from: d  reason: collision with root package name */
        public d0 f11846d;

        /* renamed from: e  reason: collision with root package name */
        public Transition f11847e;

        public d(View view, String str, Transition transition, d0 d0Var, TransitionValues transitionValues) {
            this.f11843a = view;
            this.f11844b = str;
            this.f11845c = transitionValues;
            this.f11846d = d0Var;
            this.f11847e = transition;
        }
    }

    public static class e {
        public static <T> ArrayList<T> a(ArrayList<T> arrayList, T t11) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t11)) {
                arrayList.add(t11);
            }
            return arrayList;
        }

        public static <T> ArrayList<T> b(ArrayList<T> arrayList, T t11) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t11);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public interface f {
        void onTransitionCancel(Transition transition);

        void onTransitionEnd(Transition transition);

        void onTransitionPause(Transition transition);

        void onTransitionResume(Transition transition);

        void onTransitionStart(Transition transition);
    }

    public Transition() {
    }

    private void addUnmatched(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        for (int i11 = 0; i11 < arrayMap.size(); i11++) {
            TransitionValues p11 = arrayMap.p(i11);
            if (isValidTarget(p11.f11866b)) {
                this.mStartValuesList.add(p11);
                this.mEndValuesList.add((Object) null);
            }
        }
        for (int i12 = 0; i12 < arrayMap2.size(); i12++) {
            TransitionValues p12 = arrayMap2.p(i12);
            if (isValidTarget(p12.f11866b)) {
                this.mEndValuesList.add(p12);
                this.mStartValuesList.add((Object) null);
            }
        }
    }

    private static void addViewValues(n nVar, View view, TransitionValues transitionValues) {
        nVar.f16676a.put(view, transitionValues);
        int id2 = view.getId();
        if (id2 >= 0) {
            if (nVar.f16677b.indexOfKey(id2) >= 0) {
                nVar.f16677b.put(id2, (Object) null);
            } else {
                nVar.f16677b.put(id2, view);
            }
        }
        String P = h0.P(view);
        if (P != null) {
            if (nVar.f16679d.containsKey(P)) {
                nVar.f16679d.put(P, null);
            } else {
                nVar.f16679d.put(P, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (nVar.f16678c.i(itemIdAtPosition) >= 0) {
                    View g11 = nVar.f16678c.g(itemIdAtPosition);
                    if (g11 != null) {
                        h0.H0(g11, false);
                        nVar.f16678c.l(itemIdAtPosition, null);
                        return;
                    }
                    return;
                }
                h0.H0(view, true);
                nVar.f16678c.l(itemIdAtPosition, view);
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i11) {
        int i12 = iArr[i11];
        for (int i13 = 0; i13 < i11; i13++) {
            if (iArr[i13] == i12) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z11) {
        if (view != null) {
            int id2 = view.getId();
            ArrayList<Integer> arrayList = this.mTargetIdExcludes;
            if (arrayList == null || !arrayList.contains(Integer.valueOf(id2))) {
                ArrayList<View> arrayList2 = this.mTargetExcludes;
                if (arrayList2 == null || !arrayList2.contains(view)) {
                    ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                    if (arrayList3 != null) {
                        int size = arrayList3.size();
                        int i11 = 0;
                        while (i11 < size) {
                            if (!this.mTargetTypeExcludes.get(i11).isInstance(view)) {
                                i11++;
                            } else {
                                return;
                            }
                        }
                    }
                    if (view.getParent() instanceof ViewGroup) {
                        TransitionValues transitionValues = new TransitionValues(view);
                        if (z11) {
                            captureStartValues(transitionValues);
                        } else {
                            captureEndValues(transitionValues);
                        }
                        transitionValues.f11867c.add(this);
                        capturePropagationValues(transitionValues);
                        if (z11) {
                            addViewValues(this.mStartValues, view, transitionValues);
                        } else {
                            addViewValues(this.mEndValues, view, transitionValues);
                        }
                    }
                    if (view instanceof ViewGroup) {
                        ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                        if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id2))) {
                            ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                            if (arrayList5 == null || !arrayList5.contains(view)) {
                                ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                                if (arrayList6 != null) {
                                    int size2 = arrayList6.size();
                                    int i12 = 0;
                                    while (i12 < size2) {
                                        if (!this.mTargetTypeChildExcludes.get(i12).isInstance(view)) {
                                            i12++;
                                        } else {
                                            return;
                                        }
                                    }
                                }
                                ViewGroup viewGroup = (ViewGroup) view;
                                for (int i13 = 0; i13 < viewGroup.getChildCount(); i13++) {
                                    captureHierarchy(viewGroup.getChildAt(i13), z11);
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i11, boolean z11) {
        if (i11 <= 0) {
            return arrayList;
        }
        if (z11) {
            return e.a(arrayList, Integer.valueOf(i11));
        }
        return e.b(arrayList, Integer.valueOf(i11));
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t11, boolean z11) {
        if (t11 == null) {
            return arrayList;
        }
        if (z11) {
            return e.a(arrayList, t11);
        }
        return e.b(arrayList, t11);
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z11) {
        if (cls == null) {
            return arrayList;
        }
        if (z11) {
            return e.a(arrayList, cls);
        }
        return e.b(arrayList, cls);
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z11) {
        if (view == null) {
            return arrayList;
        }
        if (z11) {
            return e.a(arrayList, view);
        }
        return e.b(arrayList, view);
    }

    private static ArrayMap<Animator, d> getRunningAnimators() {
        ArrayMap<Animator, d> arrayMap = sRunningAnimators.get();
        if (arrayMap != null) {
            return arrayMap;
        }
        ArrayMap<Animator, d> arrayMap2 = new ArrayMap<>();
        sRunningAnimators.set(arrayMap2);
        return arrayMap2;
    }

    private static boolean isValidMatch(int i11) {
        return i11 >= 1 && i11 <= 4;
    }

    private static boolean isValueChanged(TransitionValues transitionValues, TransitionValues transitionValues2, String str) {
        Object obj = transitionValues.f11865a.get(str);
        Object obj2 = transitionValues2.f11865a.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void matchIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i11 = 0; i11 < size; i11++) {
            View valueAt = sparseArray.valueAt(i11);
            if (valueAt != null && isValidTarget(valueAt) && (view = sparseArray2.get(sparseArray.keyAt(i11))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(valueAt);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(valueAt);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchInstances(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2) {
        TransitionValues remove;
        for (int size = arrayMap.size() - 1; size >= 0; size--) {
            View l11 = arrayMap.l(size);
            if (l11 != null && isValidTarget(l11) && (remove = arrayMap2.remove(l11)) != null && isValidTarget(remove.f11866b)) {
                this.mStartValuesList.add(arrayMap.n(size));
                this.mEndValuesList.add(remove);
            }
        }
    }

    private void matchItemIds(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, LongSparseArray<View> longSparseArray, LongSparseArray<View> longSparseArray2) {
        View g11;
        int o11 = longSparseArray.o();
        for (int i11 = 0; i11 < o11; i11++) {
            View p11 = longSparseArray.p(i11);
            if (p11 != null && isValidTarget(p11) && (g11 = longSparseArray2.g(longSparseArray.k(i11))) != null && isValidTarget(g11)) {
                TransitionValues transitionValues = arrayMap.get(p11);
                TransitionValues transitionValues2 = arrayMap2.get(g11);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(p11);
                    arrayMap2.remove(g11);
                }
            }
        }
    }

    private void matchNames(ArrayMap<View, TransitionValues> arrayMap, ArrayMap<View, TransitionValues> arrayMap2, ArrayMap<String, View> arrayMap3, ArrayMap<String, View> arrayMap4) {
        View view;
        int size = arrayMap3.size();
        for (int i11 = 0; i11 < size; i11++) {
            View p11 = arrayMap3.p(i11);
            if (p11 != null && isValidTarget(p11) && (view = arrayMap4.get(arrayMap3.l(i11))) != null && isValidTarget(view)) {
                TransitionValues transitionValues = arrayMap.get(p11);
                TransitionValues transitionValues2 = arrayMap2.get(view);
                if (!(transitionValues == null || transitionValues2 == null)) {
                    this.mStartValuesList.add(transitionValues);
                    this.mEndValuesList.add(transitionValues2);
                    arrayMap.remove(p11);
                    arrayMap2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(n nVar, n nVar2) {
        ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) nVar.f16676a);
        ArrayMap arrayMap2 = new ArrayMap((SimpleArrayMap) nVar2.f16676a);
        int i11 = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i11 < iArr.length) {
                int i12 = iArr[i11];
                if (i12 == 1) {
                    matchInstances(arrayMap, arrayMap2);
                } else if (i12 == 2) {
                    matchNames(arrayMap, arrayMap2, nVar.f16679d, nVar2.f16679d);
                } else if (i12 == 3) {
                    matchIds(arrayMap, arrayMap2, nVar.f16677b, nVar2.f16677b);
                } else if (i12 == 4) {
                    matchItemIds(arrayMap, arrayMap2, nVar.f16678c, nVar2.f16678c);
                }
                i11++;
            } else {
                addUnmatched(arrayMap, arrayMap2);
                return;
            }
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, Constants.ACCEPT_TIME_SEPARATOR_SP);
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i11 = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String trim = stringTokenizer.nextToken().trim();
            if ("id".equalsIgnoreCase(trim)) {
                iArr[i11] = 3;
            } else if ("instance".equalsIgnoreCase(trim)) {
                iArr[i11] = 1;
            } else if ("name".equalsIgnoreCase(trim)) {
                iArr[i11] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(trim)) {
                iArr[i11] = 4;
            } else if (trim.isEmpty()) {
                int[] iArr2 = new int[(iArr.length - 1)];
                System.arraycopy(iArr, 0, iArr2, 0, i11);
                i11--;
                iArr = iArr2;
            } else {
                throw new InflateException("Unknown match type in matchOrder: '" + trim + "'");
            }
            i11++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, ArrayMap<Animator, d> arrayMap) {
        if (animator != null) {
            animator.addListener(new b(arrayMap));
            animate(animator);
        }
    }

    public Transition addListener(f fVar) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(fVar);
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new c());
        animator.start();
    }

    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<f> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i11 = 0; i11 < size2; i11++) {
                ((f) arrayList2.get(i11)).onTransitionCancel(this);
            }
        }
    }

    public abstract void captureEndValues(TransitionValues transitionValues);

    public void capturePropagationValues(TransitionValues transitionValues) {
        String[] b11;
        if (this.mPropagation != null && !transitionValues.f11865a.isEmpty() && (b11 = this.mPropagation.b()) != null) {
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= b11.length) {
                    z11 = true;
                    break;
                } else if (!transitionValues.f11865a.containsKey(b11[i11])) {
                    break;
                } else {
                    i11++;
                }
            }
            if (!z11) {
                this.mPropagation.a(transitionValues);
            }
        }
    }

    public abstract void captureStartValues(TransitionValues transitionValues);

    public void captureValues(ViewGroup viewGroup, boolean z11) {
        ArrayMap<String, String> arrayMap;
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        clearValues(z11);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i11 = 0; i11 < this.mTargetIds.size(); i11++) {
                View findViewById = viewGroup.findViewById(this.mTargetIds.get(i11).intValue());
                if (findViewById != null) {
                    TransitionValues transitionValues = new TransitionValues(findViewById);
                    if (z11) {
                        captureStartValues(transitionValues);
                    } else {
                        captureEndValues(transitionValues);
                    }
                    transitionValues.f11867c.add(this);
                    capturePropagationValues(transitionValues);
                    if (z11) {
                        addViewValues(this.mStartValues, findViewById, transitionValues);
                    } else {
                        addViewValues(this.mEndValues, findViewById, transitionValues);
                    }
                }
            }
            for (int i12 = 0; i12 < this.mTargets.size(); i12++) {
                View view = this.mTargets.get(i12);
                TransitionValues transitionValues2 = new TransitionValues(view);
                if (z11) {
                    captureStartValues(transitionValues2);
                } else {
                    captureEndValues(transitionValues2);
                }
                transitionValues2.f11867c.add(this);
                capturePropagationValues(transitionValues2);
                if (z11) {
                    addViewValues(this.mStartValues, view, transitionValues2);
                } else {
                    addViewValues(this.mEndValues, view, transitionValues2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z11);
        }
        if (!z11 && (arrayMap = this.mNameOverrides) != null) {
            int size = arrayMap.size();
            ArrayList arrayList3 = new ArrayList(size);
            for (int i13 = 0; i13 < size; i13++) {
                arrayList3.add(this.mStartValues.f16679d.remove(this.mNameOverrides.l(i13)));
            }
            for (int i14 = 0; i14 < size; i14++) {
                View view2 = (View) arrayList3.get(i14);
                if (view2 != null) {
                    this.mStartValues.f16679d.put(this.mNameOverrides.p(i14), view2);
                }
            }
        }
    }

    public void clearValues(boolean z11) {
        if (z11) {
            this.mStartValues.f16676a.clear();
            this.mStartValues.f16677b.clear();
            this.mStartValues.f16678c.c();
            return;
        }
        this.mEndValues.f16676a.clear();
        this.mEndValues.f16677b.clear();
        this.mEndValues.f16678c.c();
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public void createAnimators(ViewGroup viewGroup, n nVar, n nVar2, ArrayList<TransitionValues> arrayList, ArrayList<TransitionValues> arrayList2) {
        int i11;
        int i12;
        Animator createAnimator;
        View view;
        Animator animator;
        TransitionValues transitionValues;
        TransitionValues transitionValues2;
        Animator animator2;
        ViewGroup viewGroup2 = viewGroup;
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long j11 = Long.MAX_VALUE;
        int i13 = 0;
        while (i13 < size) {
            TransitionValues transitionValues3 = arrayList.get(i13);
            TransitionValues transitionValues4 = arrayList2.get(i13);
            if (transitionValues3 != null && !transitionValues3.f11867c.contains(this)) {
                transitionValues3 = null;
            }
            if (transitionValues4 != null && !transitionValues4.f11867c.contains(this)) {
                transitionValues4 = null;
            }
            if (!(transitionValues3 == null && transitionValues4 == null)) {
                if ((transitionValues3 == null || transitionValues4 == null || isTransitionRequired(transitionValues3, transitionValues4)) && (createAnimator = createAnimator(viewGroup2, transitionValues3, transitionValues4)) != null) {
                    if (transitionValues4 != null) {
                        view = transitionValues4.f11866b;
                        String[] transitionProperties = getTransitionProperties();
                        if (transitionProperties != null && transitionProperties.length > 0) {
                            transitionValues2 = new TransitionValues(view);
                            Animator animator3 = createAnimator;
                            i12 = size;
                            TransitionValues transitionValues5 = nVar2.f16676a.get(view);
                            if (transitionValues5 != null) {
                                int i14 = 0;
                                while (i14 < transitionProperties.length) {
                                    transitionValues2.f11865a.put(transitionProperties[i14], transitionValues5.f11865a.get(transitionProperties[i14]));
                                    i14++;
                                    ArrayList<TransitionValues> arrayList3 = arrayList2;
                                    i13 = i13;
                                    transitionValues5 = transitionValues5;
                                }
                            }
                            i11 = i13;
                            int size2 = runningAnimators.size();
                            int i15 = 0;
                            while (true) {
                                if (i15 >= size2) {
                                    animator2 = animator3;
                                    break;
                                }
                                d dVar = runningAnimators.get(runningAnimators.l(i15));
                                if (dVar.f11845c != null && dVar.f11843a == view && dVar.f11844b.equals(getName()) && dVar.f11845c.equals(transitionValues2)) {
                                    animator2 = null;
                                    break;
                                }
                                i15++;
                            }
                        } else {
                            i12 = size;
                            i11 = i13;
                            animator2 = createAnimator;
                            transitionValues2 = null;
                        }
                        animator = animator2;
                        transitionValues = transitionValues2;
                    } else {
                        i12 = size;
                        i11 = i13;
                        view = transitionValues3.f11866b;
                        animator = createAnimator;
                        transitionValues = null;
                    }
                    if (animator != null) {
                        TransitionPropagation transitionPropagation = this.mPropagation;
                        if (transitionPropagation != null) {
                            long c11 = transitionPropagation.c(viewGroup2, this, transitionValues3, transitionValues4);
                            sparseIntArray.put(this.mAnimators.size(), (int) c11);
                            j11 = Math.min(c11, j11);
                        }
                        runningAnimators.put(animator, new d(view, getName(), this, u.d(viewGroup), transitionValues));
                        this.mAnimators.add(animator);
                        j11 = j11;
                    }
                    i13 = i11 + 1;
                    size = i12;
                }
            }
            i12 = size;
            i11 = i13;
            i13 = i11 + 1;
            size = i12;
        }
        if (sparseIntArray.size() != 0) {
            for (int i16 = 0; i16 < sparseIntArray.size(); i16++) {
                Animator animator4 = this.mAnimators.get(sparseIntArray.keyAt(i16));
                animator4.setStartDelay((((long) sparseIntArray.valueAt(i16)) - j11) + animator4.getStartDelay());
            }
        }
    }

    public void end() {
        int i11 = this.mNumInstances - 1;
        this.mNumInstances = i11;
        if (i11 == 0) {
            ArrayList<f> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i12 = 0; i12 < size; i12++) {
                    ((f) arrayList2.get(i12)).onTransitionEnd(this);
                }
            }
            for (int i13 = 0; i13 < this.mStartValues.f16678c.o(); i13++) {
                View p11 = this.mStartValues.f16678c.p(i13);
                if (p11 != null) {
                    h0.H0(p11, false);
                }
            }
            for (int i14 = 0; i14 < this.mEndValues.f16678c.o(); i14++) {
                View p12 = this.mEndValues.f16678c.p(i14);
                if (p12 != null) {
                    h0.H0(p12, false);
                }
            }
            this.mEnded = true;
        }
    }

    public Transition excludeChildren(View view, boolean z11) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z11);
        return this;
    }

    public Transition excludeTarget(View view, boolean z11) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z11);
        return this;
    }

    public void forceToEnd(ViewGroup viewGroup) {
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup != null && size != 0) {
            d0 d11 = u.d(viewGroup);
            ArrayMap arrayMap = new ArrayMap((SimpleArrayMap) runningAnimators);
            runningAnimators.clear();
            for (int i11 = size - 1; i11 >= 0; i11--) {
                d dVar = (d) arrayMap.p(i11);
                if (!(dVar.f11843a == null || d11 == null || !d11.equals(dVar.f11846d))) {
                    ((Animator) arrayMap.l(i11)).end();
                }
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        EpicenterCallback epicenterCallback = this.mEpicenterCallback;
        if (epicenterCallback == null) {
            return null;
        }
        return epicenterCallback.a(this);
    }

    public EpicenterCallback getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public TransitionValues getMatchedTransitionValues(View view, boolean z11) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z11);
        }
        ArrayList<TransitionValues> arrayList = z11 ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i11 = -1;
        int i12 = 0;
        while (true) {
            if (i12 >= size) {
                break;
            }
            TransitionValues transitionValues = arrayList.get(i12);
            if (transitionValues == null) {
                return null;
            }
            if (transitionValues.f11866b == view) {
                i11 = i12;
                break;
            }
            i12++;
        }
        if (i11 < 0) {
            return null;
        }
        return (z11 ? this.mEndValuesList : this.mStartValuesList).get(i11);
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public TransitionPropagation getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public TransitionValues getTransitionValues(View view, boolean z11) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z11);
        }
        return (z11 ? this.mStartValues : this.mEndValues).f16676a.get(view);
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null || transitionValues2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties != null) {
            int length = transitionProperties.length;
            int i11 = 0;
            while (i11 < length) {
                if (!isValueChanged(transitionValues, transitionValues2, transitionProperties[i11])) {
                    i11++;
                }
            }
            return false;
        }
        for (String isValueChanged : transitionValues.f11865a.keySet()) {
            if (isValueChanged(transitionValues, transitionValues2, isValueChanged)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id2 = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id2))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i11 = 0; i11 < size; i11++) {
                if (this.mTargetTypeExcludes.get(i11).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && h0.P(view) != null && this.mTargetNameExcludes.contains(h0.P(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id2)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(h0.P(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i12 = 0; i12 < this.mTargetTypes.size(); i12++) {
                if (this.mTargetTypes.get(i12).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pause(View view) {
        if (!this.mEnded) {
            ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
            int size = runningAnimators.size();
            d0 d11 = u.d(view);
            for (int i11 = size - 1; i11 >= 0; i11--) {
                d p11 = runningAnimators.p(i11);
                if (p11.f11843a != null && d11.equals(p11.f11846d)) {
                    a.b(runningAnimators.l(i11));
                }
            }
            ArrayList<f> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size2 = arrayList2.size();
                for (int i12 = 0; i12 < size2; i12++) {
                    ((f) arrayList2.get(i12)).onTransitionPause(this);
                }
            }
            this.mPaused = true;
        }
    }

    public void playTransition(ViewGroup viewGroup) {
        d dVar;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        d0 d11 = u.d(viewGroup);
        for (int i11 = size - 1; i11 >= 0; i11--) {
            Animator l11 = runningAnimators.l(i11);
            if (!(l11 == null || (dVar = runningAnimators.get(l11)) == null || dVar.f11843a == null || !d11.equals(dVar.f11846d))) {
                TransitionValues transitionValues = dVar.f11845c;
                View view = dVar.f11843a;
                TransitionValues transitionValues2 = getTransitionValues(view, true);
                TransitionValues matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues2 == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f16676a.get(view);
                }
                if (!(transitionValues2 == null && matchedTransitionValues == null) && dVar.f11847e.isTransitionRequired(transitionValues, matchedTransitionValues)) {
                    if (l11.isRunning() || l11.isStarted()) {
                        l11.cancel();
                    } else {
                        runningAnimators.remove(l11);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public Transition removeListener(f fVar) {
        ArrayList<f> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(fVar);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                d0 d11 = u.d(view);
                for (int i11 = size - 1; i11 >= 0; i11--) {
                    d p11 = runningAnimators.p(i11);
                    if (p11.f11843a != null && d11.equals(p11.f11846d)) {
                        a.c(runningAnimators.l(i11));
                    }
                }
                ArrayList<f> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i12 = 0; i12 < size2; i12++) {
                        ((f) arrayList2.get(i12)).onTransitionResume(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        ArrayMap<Animator, d> runningAnimators = getRunningAnimators();
        Iterator<Animator> it2 = this.mAnimators.iterator();
        while (it2.hasNext()) {
            Animator next = it2.next();
            if (runningAnimators.containsKey(next)) {
                start();
                runAnimator(next, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z11) {
        this.mCanRemoveViews = z11;
    }

    public Transition setDuration(long j11) {
        this.mDuration = j11;
        return this;
    }

    public void setEpicenterCallback(EpicenterCallback epicenterCallback) {
        this.mEpicenterCallback = epicenterCallback;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        int i11 = 0;
        while (i11 < iArr.length) {
            if (!isValidMatch(iArr[i11])) {
                throw new IllegalArgumentException("matches contains invalid value");
            } else if (!alreadyContains(iArr, i11)) {
                i11++;
            } else {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(TransitionPropagation transitionPropagation) {
        this.mPropagation = transitionPropagation;
    }

    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public Transition setStartDelay(long j11) {
        this.mStartDelay = j11;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<f> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i11 = 0; i11 < size; i11++) {
                    ((f) arrayList2.get(i11)).onTransitionStart(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString("");
    }

    public Transition addTarget(int i11) {
        if (i11 != 0) {
            this.mTargetIds.add(Integer.valueOf(i11));
        }
        return this;
    }

    public Transition clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new n();
            transition.mEndValues = new n();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Transition excludeChildren(int i11, boolean z11) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i11, z11);
        return this;
    }

    public Transition excludeTarget(int i11, boolean z11) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i11, z11);
        return this;
    }

    public Transition removeTarget(int i11) {
        if (i11 != 0) {
            this.mTargetIds.remove(Integer.valueOf(i11));
        }
        return this;
    }

    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + TIMMentionEditText.TIM_MENTION_TAG + Integer.toHexString(hashCode()) + l.f34627b;
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i11 = 0; i11 < this.mTargetIds.size(); i11++) {
                if (i11 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i11);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i12 = 0; i12 < this.mTargets.size(); i12++) {
                if (i12 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i12);
            }
        }
        return str3 + ")";
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z11) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z11);
        return this;
    }

    public Transition excludeTarget(String str, boolean z11) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z11);
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition excludeTarget(Class<?> cls, boolean z11) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z11);
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, v1.l.f16664c);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long g11 = (long) i.g(obtainStyledAttributes, xmlResourceParser, IBridgeMediaLoader.COLUMN_DURATION, 1, -1);
        if (g11 >= 0) {
            setDuration(g11);
        }
        long g12 = (long) i.g(obtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (g12 > 0) {
            setStartDelay(g12);
        }
        int h11 = i.h(obtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (h11 > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, h11));
        }
        String i11 = i.i(obtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (i11 != null) {
            setMatchOrder(parseMatchOrder(i11));
        }
        obtainStyledAttributes.recycle();
    }
}
