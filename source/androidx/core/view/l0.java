package androidx.core.view;

import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.ViewParent;

public final class l0 {

    public static class a {
        public static boolean a(ViewParent viewParent, View view, float f11, float f12, boolean z11) {
            return viewParent.onNestedFling(view, f11, f12, z11);
        }

        public static boolean b(ViewParent viewParent, View view, float f11, float f12) {
            return viewParent.onNestedPreFling(view, f11, f12);
        }

        public static void c(ViewParent viewParent, View view, int i11, int i12, int[] iArr) {
            viewParent.onNestedPreScroll(view, i11, i12, iArr);
        }

        public static void d(ViewParent viewParent, View view, int i11, int i12, int i13, int i14) {
            viewParent.onNestedScroll(view, i11, i12, i13, i14);
        }

        public static void e(ViewParent viewParent, View view, View view2, int i11) {
            viewParent.onNestedScrollAccepted(view, view2, i11);
        }

        public static boolean f(ViewParent viewParent, View view, View view2, int i11) {
            return viewParent.onStartNestedScroll(view, view2, i11);
        }

        public static void g(ViewParent viewParent, View view) {
            viewParent.onStopNestedScroll(view);
        }
    }

    public static boolean a(ViewParent viewParent, View view, float f11, float f12, boolean z11) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return a.a(viewParent, view, f11, f12, z11);
            } catch (AbstractMethodError e11) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedFling", e11);
                return false;
            }
        } else if (viewParent instanceof t) {
            return ((t) viewParent).onNestedFling(view, f11, f12, z11);
        } else {
            return false;
        }
    }

    public static boolean b(ViewParent viewParent, View view, float f11, float f12) {
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return a.b(viewParent, view, f11, f12);
            } catch (AbstractMethodError e11) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreFling", e11);
                return false;
            }
        } else if (viewParent instanceof t) {
            return ((t) viewParent).onNestedPreFling(view, f11, f12);
        } else {
            return false;
        }
    }

    public static void c(ViewParent viewParent, View view, int i11, int i12, int[] iArr, int i13) {
        if (viewParent instanceof r) {
            ((r) viewParent).onNestedPreScroll(view, i11, i12, iArr, i13);
        } else if (i13 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    a.c(viewParent, view, i11, i12, iArr);
                } catch (AbstractMethodError e11) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedPreScroll", e11);
                }
            } else if (viewParent instanceof t) {
                ((t) viewParent).onNestedPreScroll(view, i11, i12, iArr);
            }
        }
    }

    public static void d(ViewParent viewParent, View view, int i11, int i12, int i13, int i14, int i15, int[] iArr) {
        ViewParent viewParent2 = viewParent;
        if (viewParent2 instanceof s) {
            ((s) viewParent2).onNestedScroll(view, i11, i12, i13, i14, i15, iArr);
            return;
        }
        iArr[0] = iArr[0] + i13;
        iArr[1] = iArr[1] + i14;
        if (viewParent2 instanceof r) {
            ((r) viewParent2).onNestedScroll(view, i11, i12, i13, i14, i15);
        } else if (i15 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    a.d(viewParent, view, i11, i12, i13, i14);
                } catch (AbstractMethodError e11) {
                    AbstractMethodError abstractMethodError = e11;
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScroll", abstractMethodError);
                }
            } else if (viewParent2 instanceof t) {
                ((t) viewParent2).onNestedScroll(view, i11, i12, i13, i14);
            }
        }
    }

    public static void e(ViewParent viewParent, View view, View view2, int i11, int i12) {
        if (viewParent instanceof r) {
            ((r) viewParent).onNestedScrollAccepted(view, view2, i11, i12);
        } else if (i12 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    a.e(viewParent, view, view2, i11);
                } catch (AbstractMethodError e11) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onNestedScrollAccepted", e11);
                }
            } else if (viewParent instanceof t) {
                ((t) viewParent).onNestedScrollAccepted(view, view2, i11);
            }
        }
    }

    public static boolean f(ViewParent viewParent, View view, View view2, int i11, int i12) {
        if (viewParent instanceof r) {
            return ((r) viewParent).onStartNestedScroll(view, view2, i11, i12);
        }
        if (i12 != 0) {
            return false;
        }
        if (Build.VERSION.SDK_INT >= 21) {
            try {
                return a.f(viewParent, view, view2, i11);
            } catch (AbstractMethodError e11) {
                Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStartNestedScroll", e11);
                return false;
            }
        } else if (viewParent instanceof t) {
            return ((t) viewParent).onStartNestedScroll(view, view2, i11);
        } else {
            return false;
        }
    }

    public static void g(ViewParent viewParent, View view, int i11) {
        if (viewParent instanceof r) {
            ((r) viewParent).onStopNestedScroll(view, i11);
        } else if (i11 != 0) {
        } else {
            if (Build.VERSION.SDK_INT >= 21) {
                try {
                    a.g(viewParent, view);
                } catch (AbstractMethodError e11) {
                    Log.e("ViewParentCompat", "ViewParent " + viewParent + " does not implement interface method onStopNestedScroll", e11);
                }
            } else if (viewParent instanceof t) {
                ((t) viewParent).onStopNestedScroll(view);
            }
        }
    }
}
