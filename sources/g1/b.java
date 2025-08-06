package g1;

import android.graphics.Rect;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class b {

    public interface a<T> {
        void a(T t11, Rect rect);
    }

    /* renamed from: g1.b$b  reason: collision with other inner class name */
    public interface C0080b<T, V> {
        V a(T t11, int i11);

        int b(T t11);
    }

    public static class c<T> implements Comparator<T> {

        /* renamed from: b  reason: collision with root package name */
        public final Rect f15786b = new Rect();

        /* renamed from: c  reason: collision with root package name */
        public final Rect f15787c = new Rect();

        /* renamed from: d  reason: collision with root package name */
        public final boolean f15788d;

        /* renamed from: e  reason: collision with root package name */
        public final a<T> f15789e;

        public c(boolean z11, a<T> aVar) {
            this.f15788d = z11;
            this.f15789e = aVar;
        }

        public int compare(T t11, T t12) {
            Rect rect = this.f15786b;
            Rect rect2 = this.f15787c;
            this.f15789e.a(t11, rect);
            this.f15789e.a(t12, rect2);
            int i11 = rect.top;
            int i12 = rect2.top;
            if (i11 < i12) {
                return -1;
            }
            if (i11 > i12) {
                return 1;
            }
            int i13 = rect.left;
            int i14 = rect2.left;
            if (i13 < i14) {
                if (this.f15788d) {
                    return 1;
                }
                return -1;
            } else if (i13 <= i14) {
                int i15 = rect.bottom;
                int i16 = rect2.bottom;
                if (i15 < i16) {
                    return -1;
                }
                if (i15 > i16) {
                    return 1;
                }
                int i17 = rect.right;
                int i18 = rect2.right;
                if (i17 < i18) {
                    if (this.f15788d) {
                        return 1;
                    }
                    return -1;
                } else if (i17 <= i18) {
                    return 0;
                } else {
                    if (this.f15788d) {
                        return -1;
                    }
                    return 1;
                }
            } else if (this.f15788d) {
                return -1;
            } else {
                return 1;
            }
        }
    }

    public static boolean a(int i11, Rect rect, Rect rect2, Rect rect3) {
        boolean b11 = b(i11, rect, rect2);
        if (b(i11, rect, rect3) || !b11) {
            return false;
        }
        if (!j(i11, rect, rect3) || i11 == 17 || i11 == 66) {
            return true;
        }
        if (k(i11, rect, rect2) < m(i11, rect, rect3)) {
            return true;
        }
        return false;
    }

    public static boolean b(int i11, Rect rect, Rect rect2) {
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            if (rect2.right < rect.left || rect2.left > rect.right) {
                return false;
            }
            return true;
        }
        if (rect2.bottom < rect.top || rect2.top > rect.bottom) {
            return false;
        }
        return true;
    }

    public static <L, T> T c(L l11, C0080b<L, T> bVar, a<T> aVar, T t11, Rect rect, int i11) {
        Rect rect2 = new Rect(rect);
        if (i11 == 17) {
            rect2.offset(rect.width() + 1, 0);
        } else if (i11 == 33) {
            rect2.offset(0, rect.height() + 1);
        } else if (i11 == 66) {
            rect2.offset(-(rect.width() + 1), 0);
        } else if (i11 == 130) {
            rect2.offset(0, -(rect.height() + 1));
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        T t12 = null;
        int b11 = bVar.b(l11);
        Rect rect3 = new Rect();
        for (int i12 = 0; i12 < b11; i12++) {
            T a11 = bVar.a(l11, i12);
            if (a11 != t11) {
                aVar.a(a11, rect3);
                if (h(i11, rect, rect3, rect2)) {
                    rect2.set(rect3);
                    t12 = a11;
                }
            }
        }
        return t12;
    }

    public static <L, T> T d(L l11, C0080b<L, T> bVar, a<T> aVar, T t11, int i11, boolean z11, boolean z12) {
        int b11 = bVar.b(l11);
        ArrayList arrayList = new ArrayList(b11);
        for (int i12 = 0; i12 < b11; i12++) {
            arrayList.add(bVar.a(l11, i12));
        }
        Collections.sort(arrayList, new c(z11, aVar));
        if (i11 == 1) {
            return f(t11, arrayList, z12);
        }
        if (i11 == 2) {
            return e(t11, arrayList, z12);
        }
        throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD}.");
    }

    public static <T> T e(T t11, ArrayList<T> arrayList, boolean z11) {
        int i11;
        int size = arrayList.size();
        if (t11 == null) {
            i11 = -1;
        } else {
            i11 = arrayList.lastIndexOf(t11);
        }
        int i12 = i11 + 1;
        if (i12 < size) {
            return arrayList.get(i12);
        }
        if (!z11 || size <= 0) {
            return null;
        }
        return arrayList.get(0);
    }

    public static <T> T f(T t11, ArrayList<T> arrayList, boolean z11) {
        int i11;
        int size = arrayList.size();
        if (t11 == null) {
            i11 = size;
        } else {
            i11 = arrayList.indexOf(t11);
        }
        int i12 = i11 - 1;
        if (i12 >= 0) {
            return arrayList.get(i12);
        }
        if (!z11 || size <= 0) {
            return null;
        }
        return arrayList.get(size - 1);
    }

    public static int g(int i11, int i12) {
        return (i11 * 13 * i11) + (i12 * i12);
    }

    public static boolean h(int i11, Rect rect, Rect rect2, Rect rect3) {
        if (!i(rect, rect2, i11)) {
            return false;
        }
        if (!i(rect, rect3, i11) || a(i11, rect, rect2, rect3)) {
            return true;
        }
        if (!a(i11, rect, rect3, rect2) && g(k(i11, rect, rect2), o(i11, rect, rect2)) < g(k(i11, rect, rect3), o(i11, rect, rect3))) {
            return true;
        }
        return false;
    }

    public static boolean i(Rect rect, Rect rect2, int i11) {
        if (i11 == 17) {
            int i12 = rect.right;
            int i13 = rect2.right;
            if ((i12 > i13 || rect.left >= i13) && rect.left > rect2.left) {
                return true;
            }
            return false;
        } else if (i11 == 33) {
            int i14 = rect.bottom;
            int i15 = rect2.bottom;
            if ((i14 > i15 || rect.top >= i15) && rect.top > rect2.top) {
                return true;
            }
            return false;
        } else if (i11 == 66) {
            int i16 = rect.left;
            int i17 = rect2.left;
            if ((i16 < i17 || rect.right <= i17) && rect.right < rect2.right) {
                return true;
            }
            return false;
        } else if (i11 == 130) {
            int i18 = rect.top;
            int i19 = rect2.top;
            return (i18 < i19 || rect.bottom <= i19) && rect.bottom < rect2.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
    }

    public static boolean j(int i11, Rect rect, Rect rect2) {
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 == 130) {
                        return rect.bottom <= rect2.top;
                    }
                    throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                } else if (rect.right <= rect2.left) {
                    return true;
                } else {
                    return false;
                }
            } else if (rect.top >= rect2.bottom) {
                return true;
            } else {
                return false;
            }
        } else if (rect.left >= rect2.right) {
            return true;
        } else {
            return false;
        }
    }

    public static int k(int i11, Rect rect, Rect rect2) {
        return Math.max(0, l(i11, rect, rect2));
    }

    public static int l(int i11, Rect rect, Rect rect2) {
        int i12;
        int i13;
        if (i11 == 17) {
            i12 = rect.left;
            i13 = rect2.right;
        } else if (i11 == 33) {
            i12 = rect.top;
            i13 = rect2.bottom;
        } else if (i11 == 66) {
            i12 = rect2.left;
            i13 = rect.right;
        } else if (i11 == 130) {
            i12 = rect2.top;
            i13 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i12 - i13;
    }

    public static int m(int i11, Rect rect, Rect rect2) {
        return Math.max(1, n(i11, rect, rect2));
    }

    public static int n(int i11, Rect rect, Rect rect2) {
        int i12;
        int i13;
        if (i11 == 17) {
            i12 = rect.left;
            i13 = rect2.left;
        } else if (i11 == 33) {
            i12 = rect.top;
            i13 = rect2.top;
        } else if (i11 == 66) {
            i12 = rect2.right;
            i13 = rect.right;
        } else if (i11 == 130) {
            i12 = rect2.bottom;
            i13 = rect.bottom;
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return i12 - i13;
    }

    public static int o(int i11, Rect rect, Rect rect2) {
        if (i11 != 17) {
            if (i11 != 33) {
                if (i11 != 66) {
                    if (i11 != 130) {
                        throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
                    }
                }
            }
            return Math.abs((rect.left + (rect.width() / 2)) - (rect2.left + (rect2.width() / 2)));
        }
        return Math.abs((rect.top + (rect.height() / 2)) - (rect2.top + (rect2.height() / 2)));
    }
}
