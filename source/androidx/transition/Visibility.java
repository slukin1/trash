package androidx.transition;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import androidx.transition.Transition;
import androidx.transition.a;
import s0.i;
import v1.l;
import v1.q;
import v1.u;

public abstract class Visibility extends Transition {
    public static final int MODE_IN = 1;
    public static final int MODE_OUT = 2;
    private static final String PROPNAME_PARENT = "android:visibility:parent";
    private static final String PROPNAME_SCREEN_LOCATION = "android:visibility:screenLocation";
    public static final String PROPNAME_VISIBILITY = "android:visibility:visibility";
    private static final String[] sTransitionProperties = {PROPNAME_VISIBILITY, PROPNAME_PARENT};
    private int mMode = 3;

    public class a extends TransitionListenerAdapter {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ ViewGroup f11875b;

        /* renamed from: c  reason: collision with root package name */
        public final /* synthetic */ View f11876c;

        /* renamed from: d  reason: collision with root package name */
        public final /* synthetic */ View f11877d;

        public a(ViewGroup viewGroup, View view, View view2) {
            this.f11875b = viewGroup;
            this.f11876c = view;
            this.f11877d = view2;
        }

        public void onTransitionEnd(Transition transition) {
            this.f11877d.setTag(R$id.save_overlay_view, (Object) null);
            q.b(this.f11875b).remove(this.f11876c);
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            q.b(this.f11875b).remove(this.f11876c);
        }

        public void onTransitionResume(Transition transition) {
            if (this.f11876c.getParent() == null) {
                q.b(this.f11875b).add(this.f11876c);
            } else {
                Visibility.this.cancel();
            }
        }
    }

    public static class b extends AnimatorListenerAdapter implements Transition.f, a.C0059a {

        /* renamed from: b  reason: collision with root package name */
        public final View f11879b;

        /* renamed from: c  reason: collision with root package name */
        public final int f11880c;

        /* renamed from: d  reason: collision with root package name */
        public final ViewGroup f11881d;

        /* renamed from: e  reason: collision with root package name */
        public final boolean f11882e;

        /* renamed from: f  reason: collision with root package name */
        public boolean f11883f;

        /* renamed from: g  reason: collision with root package name */
        public boolean f11884g = false;

        public b(View view, int i11, boolean z11) {
            this.f11879b = view;
            this.f11880c = i11;
            this.f11881d = (ViewGroup) view.getParent();
            this.f11882e = z11;
            b(true);
        }

        public final void a() {
            if (!this.f11884g) {
                u.i(this.f11879b, this.f11880c);
                ViewGroup viewGroup = this.f11881d;
                if (viewGroup != null) {
                    viewGroup.invalidate();
                }
            }
            b(false);
        }

        public final void b(boolean z11) {
            ViewGroup viewGroup;
            if (this.f11882e && this.f11883f != z11 && (viewGroup = this.f11881d) != null) {
                this.f11883f = z11;
                q.d(viewGroup, z11);
            }
        }

        public void onAnimationCancel(Animator animator) {
            this.f11884g = true;
        }

        public void onAnimationEnd(Animator animator) {
            a();
        }

        public void onAnimationPause(Animator animator) {
            if (!this.f11884g) {
                u.i(this.f11879b, this.f11880c);
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationResume(Animator animator) {
            if (!this.f11884g) {
                u.i(this.f11879b, 0);
            }
        }

        public void onAnimationStart(Animator animator) {
        }

        public void onTransitionCancel(Transition transition) {
        }

        public void onTransitionEnd(Transition transition) {
            a();
            transition.removeListener(this);
        }

        public void onTransitionPause(Transition transition) {
            b(false);
        }

        public void onTransitionResume(Transition transition) {
            b(true);
        }

        public void onTransitionStart(Transition transition) {
        }
    }

    public static class c {

        /* renamed from: a  reason: collision with root package name */
        public boolean f11885a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f11886b;

        /* renamed from: c  reason: collision with root package name */
        public int f11887c;

        /* renamed from: d  reason: collision with root package name */
        public int f11888d;

        /* renamed from: e  reason: collision with root package name */
        public ViewGroup f11889e;

        /* renamed from: f  reason: collision with root package name */
        public ViewGroup f11890f;
    }

    public Visibility() {
    }

    private void captureValues(TransitionValues transitionValues) {
        transitionValues.f11865a.put(PROPNAME_VISIBILITY, Integer.valueOf(transitionValues.f11866b.getVisibility()));
        transitionValues.f11865a.put(PROPNAME_PARENT, transitionValues.f11866b.getParent());
        int[] iArr = new int[2];
        transitionValues.f11866b.getLocationOnScreen(iArr);
        transitionValues.f11865a.put(PROPNAME_SCREEN_LOCATION, iArr);
    }

    private c getVisibilityChangeInfo(TransitionValues transitionValues, TransitionValues transitionValues2) {
        c cVar = new c();
        cVar.f11885a = false;
        cVar.f11886b = false;
        if (transitionValues == null || !transitionValues.f11865a.containsKey(PROPNAME_VISIBILITY)) {
            cVar.f11887c = -1;
            cVar.f11889e = null;
        } else {
            cVar.f11887c = ((Integer) transitionValues.f11865a.get(PROPNAME_VISIBILITY)).intValue();
            cVar.f11889e = (ViewGroup) transitionValues.f11865a.get(PROPNAME_PARENT);
        }
        if (transitionValues2 == null || !transitionValues2.f11865a.containsKey(PROPNAME_VISIBILITY)) {
            cVar.f11888d = -1;
            cVar.f11890f = null;
        } else {
            cVar.f11888d = ((Integer) transitionValues2.f11865a.get(PROPNAME_VISIBILITY)).intValue();
            cVar.f11890f = (ViewGroup) transitionValues2.f11865a.get(PROPNAME_PARENT);
        }
        if (transitionValues != null && transitionValues2 != null) {
            int i11 = cVar.f11887c;
            int i12 = cVar.f11888d;
            if (i11 == i12 && cVar.f11889e == cVar.f11890f) {
                return cVar;
            }
            if (i11 != i12) {
                if (i11 == 0) {
                    cVar.f11886b = false;
                    cVar.f11885a = true;
                } else if (i12 == 0) {
                    cVar.f11886b = true;
                    cVar.f11885a = true;
                }
            } else if (cVar.f11890f == null) {
                cVar.f11886b = false;
                cVar.f11885a = true;
            } else if (cVar.f11889e == null) {
                cVar.f11886b = true;
                cVar.f11885a = true;
            }
        } else if (transitionValues == null && cVar.f11888d == 0) {
            cVar.f11886b = true;
            cVar.f11885a = true;
        } else if (transitionValues2 == null && cVar.f11887c == 0) {
            cVar.f11886b = false;
            cVar.f11885a = true;
        }
        return cVar;
    }

    public void captureEndValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public void captureStartValues(TransitionValues transitionValues) {
        captureValues(transitionValues);
    }

    public Animator createAnimator(ViewGroup viewGroup, TransitionValues transitionValues, TransitionValues transitionValues2) {
        c visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f11885a) {
            return null;
        }
        if (visibilityChangeInfo.f11889e == null && visibilityChangeInfo.f11890f == null) {
            return null;
        }
        if (visibilityChangeInfo.f11886b) {
            return onAppear(viewGroup, transitionValues, visibilityChangeInfo.f11887c, transitionValues2, visibilityChangeInfo.f11888d);
        }
        return onDisappear(viewGroup, transitionValues, visibilityChangeInfo.f11887c, transitionValues2, visibilityChangeInfo.f11888d);
    }

    public int getMode() {
        return this.mMode;
    }

    public String[] getTransitionProperties() {
        return sTransitionProperties;
    }

    public boolean isTransitionRequired(TransitionValues transitionValues, TransitionValues transitionValues2) {
        if (transitionValues == null && transitionValues2 == null) {
            return false;
        }
        if (transitionValues != null && transitionValues2 != null && transitionValues2.f11865a.containsKey(PROPNAME_VISIBILITY) != transitionValues.f11865a.containsKey(PROPNAME_VISIBILITY)) {
            return false;
        }
        c visibilityChangeInfo = getVisibilityChangeInfo(transitionValues, transitionValues2);
        if (!visibilityChangeInfo.f11885a) {
            return false;
        }
        if (visibilityChangeInfo.f11887c == 0 || visibilityChangeInfo.f11888d == 0) {
            return true;
        }
        return false;
    }

    public boolean isVisible(TransitionValues transitionValues) {
        if (transitionValues == null) {
            return false;
        }
        int intValue = ((Integer) transitionValues.f11865a.get(PROPNAME_VISIBILITY)).intValue();
        View view = (View) transitionValues.f11865a.get(PROPNAME_PARENT);
        if (intValue != 0 || view == null) {
            return false;
        }
        return true;
    }

    public Animator onAppear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    public Animator onAppear(ViewGroup viewGroup, TransitionValues transitionValues, int i11, TransitionValues transitionValues2, int i12) {
        if ((this.mMode & 1) != 1 || transitionValues2 == null) {
            return null;
        }
        if (transitionValues == null) {
            View view = (View) transitionValues2.f11866b.getParent();
            if (getVisibilityChangeInfo(getMatchedTransitionValues(view, false), getTransitionValues(view, false)).f11885a) {
                return null;
            }
        }
        return onAppear(viewGroup, transitionValues2.f11866b, transitionValues, transitionValues2);
    }

    public Animator onDisappear(ViewGroup viewGroup, View view, TransitionValues transitionValues, TransitionValues transitionValues2) {
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:37:0x0089, code lost:
        if (r0.mCanRemoveViews != false) goto L_0x008b;
     */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x004a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.animation.Animator onDisappear(android.view.ViewGroup r18, androidx.transition.TransitionValues r19, int r20, androidx.transition.TransitionValues r21, int r22) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            r2 = r19
            r3 = r21
            r4 = r22
            int r5 = r0.mMode
            r6 = 2
            r5 = r5 & r6
            r7 = 0
            if (r5 == r6) goto L_0x0012
            return r7
        L_0x0012:
            if (r2 != 0) goto L_0x0015
            return r7
        L_0x0015:
            android.view.View r5 = r2.f11866b
            if (r3 == 0) goto L_0x001c
            android.view.View r8 = r3.f11866b
            goto L_0x001d
        L_0x001c:
            r8 = r7
        L_0x001d:
            int r9 = androidx.transition.R$id.save_overlay_view
            java.lang.Object r10 = r5.getTag(r9)
            android.view.View r10 = (android.view.View) r10
            r11 = 0
            r12 = 1
            if (r10 == 0) goto L_0x002d
            r8 = r7
            r13 = r12
            goto L_0x0095
        L_0x002d:
            if (r8 == 0) goto L_0x0040
            android.view.ViewParent r10 = r8.getParent()
            if (r10 != 0) goto L_0x0036
            goto L_0x0040
        L_0x0036:
            r10 = 4
            if (r4 != r10) goto L_0x003a
            goto L_0x003c
        L_0x003a:
            if (r5 != r8) goto L_0x0045
        L_0x003c:
            r10 = r8
            r13 = r11
            r8 = r7
            goto L_0x0048
        L_0x0040:
            if (r8 == 0) goto L_0x0045
            r10 = r7
            r13 = r11
            goto L_0x0048
        L_0x0045:
            r8 = r7
            r10 = r8
            r13 = r12
        L_0x0048:
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            if (r13 != 0) goto L_0x0051
            goto L_0x008b
        L_0x0051:
            android.view.ViewParent r13 = r5.getParent()
            boolean r13 = r13 instanceof android.view.View
            if (r13 == 0) goto L_0x008f
            android.view.ViewParent r13 = r5.getParent()
            android.view.View r13 = (android.view.View) r13
            androidx.transition.TransitionValues r14 = r0.getTransitionValues(r13, r12)
            androidx.transition.TransitionValues r15 = r0.getMatchedTransitionValues(r13, r12)
            androidx.transition.Visibility$c r14 = r0.getVisibilityChangeInfo(r14, r15)
            boolean r14 = r14.f11885a
            if (r14 != 0) goto L_0x0074
            android.view.View r8 = androidx.transition.c.a(r1, r5, r13)
            goto L_0x008f
        L_0x0074:
            int r14 = r13.getId()
            android.view.ViewParent r13 = r13.getParent()
            if (r13 != 0) goto L_0x008f
            r13 = -1
            if (r14 == r13) goto L_0x008f
            android.view.View r13 = r1.findViewById(r14)
            if (r13 == 0) goto L_0x008f
            boolean r13 = r0.mCanRemoveViews
            if (r13 == 0) goto L_0x008f
        L_0x008b:
            r8 = r10
            r13 = r11
            r10 = r5
            goto L_0x0095
        L_0x008f:
            r13 = r11
            r16 = r10
            r10 = r8
            r8 = r16
        L_0x0095:
            if (r10 == 0) goto L_0x00e5
            if (r13 != 0) goto L_0x00c9
            java.util.Map<java.lang.String, java.lang.Object> r4 = r2.f11865a
            java.lang.String r7 = "android:visibility:screenLocation"
            java.lang.Object r4 = r4.get(r7)
            int[] r4 = (int[]) r4
            r7 = r4[r11]
            r4 = r4[r12]
            int[] r6 = new int[r6]
            r1.getLocationOnScreen(r6)
            r8 = r6[r11]
            int r7 = r7 - r8
            int r8 = r10.getLeft()
            int r7 = r7 - r8
            r10.offsetLeftAndRight(r7)
            r6 = r6[r12]
            int r4 = r4 - r6
            int r6 = r10.getTop()
            int r4 = r4 - r6
            r10.offsetTopAndBottom(r4)
            v1.p r4 = v1.q.b(r18)
            r4.add(r10)
        L_0x00c9:
            android.animation.Animator r2 = r0.onDisappear(r1, r10, r2, r3)
            if (r13 != 0) goto L_0x00e4
            if (r2 != 0) goto L_0x00d9
            v1.p r1 = v1.q.b(r18)
            r1.remove(r10)
            goto L_0x00e4
        L_0x00d9:
            r5.setTag(r9, r10)
            androidx.transition.Visibility$a r3 = new androidx.transition.Visibility$a
            r3.<init>(r1, r10, r5)
            r0.addListener(r3)
        L_0x00e4:
            return r2
        L_0x00e5:
            if (r8 == 0) goto L_0x0107
            int r5 = r8.getVisibility()
            v1.u.i(r8, r11)
            android.animation.Animator r1 = r0.onDisappear(r1, r8, r2, r3)
            if (r1 == 0) goto L_0x0103
            androidx.transition.Visibility$b r2 = new androidx.transition.Visibility$b
            r2.<init>(r8, r4, r12)
            r1.addListener(r2)
            androidx.transition.a.a(r1, r2)
            r0.addListener(r2)
            goto L_0x0106
        L_0x0103:
            v1.u.i(r8, r5)
        L_0x0106:
            return r1
        L_0x0107:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.transition.Visibility.onDisappear(android.view.ViewGroup, androidx.transition.TransitionValues, int, androidx.transition.TransitionValues, int):android.animation.Animator");
    }

    public void setMode(int i11) {
        if ((i11 & -4) == 0) {
            this.mMode = i11;
            return;
        }
        throw new IllegalArgumentException("Only MODE_IN and MODE_OUT flags are allowed");
    }

    @SuppressLint({"RestrictedApi"})
    public Visibility(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, l.f16666e);
        int g11 = i.g(obtainStyledAttributes, (XmlResourceParser) attributeSet, "transitionVisibilityMode", 0, 0);
        obtainStyledAttributes.recycle();
        if (g11 != 0) {
            setMode(g11);
        }
    }
}
