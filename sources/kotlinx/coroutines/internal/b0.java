package kotlinx.coroutines.internal;

import _COROUTINE.ArtificialStackFrames;
import _COROUTINE.a;
import java.util.ArrayDeque;
import java.util.Iterator;
import kotlin.Pair;
import kotlin.Result;
import kotlin.coroutines.jvm.internal.c;
import kotlin.jvm.internal.x;
import kotlin.k;
import kotlin.l;
import kotlinx.coroutines.j0;

public final class b0 {

    /* renamed from: a  reason: collision with root package name */
    public static final StackTraceElement f57298a = new ArtificialStackFrames().a();

    /* renamed from: b  reason: collision with root package name */
    public static final String f57299b;

    /* renamed from: c  reason: collision with root package name */
    public static final String f57300c;

    static {
        Object obj;
        Object obj2;
        try {
            Result.a aVar = Result.Companion;
            obj = Result.m3072constructorimpl(Class.forName("kotlin.coroutines.jvm.internal.BaseContinuationImpl").getCanonicalName());
        } catch (Throwable th2) {
            Result.a aVar2 = Result.Companion;
            obj = Result.m3072constructorimpl(k.a(th2));
        }
        if (Result.m3075exceptionOrNullimpl(obj) != null) {
            obj = "kotlin.coroutines.jvm.internal.BaseContinuationImpl";
        }
        f57299b = (String) obj;
        try {
            Result.a aVar3 = Result.Companion;
            obj2 = Result.m3072constructorimpl(b0.class.getCanonicalName());
        } catch (Throwable th3) {
            Result.a aVar4 = Result.Companion;
            obj2 = Result.m3072constructorimpl(k.a(th3));
        }
        if (Result.m3075exceptionOrNullimpl(obj2) != null) {
            obj2 = "kotlinx.coroutines.internal.StackTraceRecoveryKt";
        }
        f57300c = (String) obj2;
    }

    public static final <E extends Throwable> Pair<E, StackTraceElement[]> b(E e11) {
        boolean z11;
        Throwable cause = e11.getCause();
        if (cause == null || !x.b(cause.getClass(), e11.getClass())) {
            return l.a(e11, new StackTraceElement[0]);
        }
        StackTraceElement[] stackTrace = e11.getStackTrace();
        int length = stackTrace.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                z11 = false;
                break;
            } else if (g(stackTrace[i11])) {
                z11 = true;
                break;
            } else {
                i11++;
            }
        }
        if (z11) {
            return l.a(cause, stackTrace);
        }
        return l.a(e11, new StackTraceElement[0]);
    }

    public static final <E extends Throwable> E c(E e11, E e12, ArrayDeque<StackTraceElement> arrayDeque) {
        arrayDeque.addFirst(f57298a);
        StackTraceElement[] stackTrace = e11.getStackTrace();
        int f11 = f(stackTrace, f57299b);
        int i11 = 0;
        if (f11 == -1) {
            e12.setStackTrace((StackTraceElement[]) arrayDeque.toArray(new StackTraceElement[0]));
            return e12;
        }
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[(arrayDeque.size() + f11)];
        for (int i12 = 0; i12 < f11; i12++) {
            stackTraceElementArr[i12] = stackTrace[i12];
        }
        Iterator<StackTraceElement> it2 = arrayDeque.iterator();
        while (it2.hasNext()) {
            stackTraceElementArr[i11 + f11] = it2.next();
            i11++;
        }
        e12.setStackTrace(stackTraceElementArr);
        return e12;
    }

    public static final ArrayDeque<StackTraceElement> d(c cVar) {
        ArrayDeque<StackTraceElement> arrayDeque = new ArrayDeque<>();
        StackTraceElement stackTraceElement = cVar.getStackTraceElement();
        if (stackTraceElement != null) {
            arrayDeque.add(stackTraceElement);
        }
        while (true) {
            cVar = cVar.getCallerFrame();
            if (cVar == null) {
                return arrayDeque;
            }
            StackTraceElement stackTraceElement2 = cVar.getStackTraceElement();
            if (stackTraceElement2 != null) {
                arrayDeque.add(stackTraceElement2);
            }
        }
    }

    public static final boolean e(StackTraceElement stackTraceElement, StackTraceElement stackTraceElement2) {
        return stackTraceElement.getLineNumber() == stackTraceElement2.getLineNumber() && x.b(stackTraceElement.getMethodName(), stackTraceElement2.getMethodName()) && x.b(stackTraceElement.getFileName(), stackTraceElement2.getFileName()) && x.b(stackTraceElement.getClassName(), stackTraceElement2.getClassName());
    }

    public static final int f(StackTraceElement[] stackTraceElementArr, String str) {
        int length = stackTraceElementArr.length;
        for (int i11 = 0; i11 < length; i11++) {
            if (x.b(str, stackTraceElementArr[i11].getClassName())) {
                return i11;
            }
        }
        return -1;
    }

    public static final boolean g(StackTraceElement stackTraceElement) {
        return StringsKt__StringsJVMKt.M(stackTraceElement.getClassName(), a.c(), false, 2, (Object) null);
    }

    public static final void h(StackTraceElement[] stackTraceElementArr, ArrayDeque<StackTraceElement> arrayDeque) {
        int length = stackTraceElementArr.length;
        int i11 = 0;
        while (true) {
            if (i11 >= length) {
                i11 = -1;
                break;
            } else if (g(stackTraceElementArr[i11])) {
                break;
            } else {
                i11++;
            }
        }
        int i12 = i11 + 1;
        int length2 = stackTraceElementArr.length - 1;
        if (i12 <= length2) {
            while (true) {
                if (e(stackTraceElementArr[length2], arrayDeque.getLast())) {
                    arrayDeque.removeLast();
                }
                arrayDeque.addFirst(stackTraceElementArr[length2]);
                if (length2 != i12) {
                    length2--;
                } else {
                    return;
                }
            }
        }
    }

    public static final <E extends Throwable> E i(E e11, c cVar) {
        Pair b11 = b(e11);
        E e12 = (Throwable) b11.component1();
        StackTraceElement[] stackTraceElementArr = (StackTraceElement[]) b11.component2();
        Throwable g11 = ExceptionsConstructorKt.g(e12);
        if (g11 == null) {
            return e11;
        }
        ArrayDeque d11 = d(cVar);
        if (d11.isEmpty()) {
            return e11;
        }
        if (e12 != e11) {
            h(stackTraceElementArr, d11);
        }
        return c(e12, g11, d11);
    }

    public static final <E extends Throwable> E j(E e11) {
        Throwable g11;
        if (j0.d() && (g11 = ExceptionsConstructorKt.g(e11)) != null) {
            return k(g11);
        }
        return e11;
    }

    public static final <E extends Throwable> E k(E e11) {
        StackTraceElement stackTraceElement;
        StackTraceElement[] stackTrace = e11.getStackTrace();
        int length = stackTrace.length;
        int length2 = stackTrace.length - 1;
        if (length2 >= 0) {
            while (true) {
                int i11 = length2 - 1;
                if (x.b(f57300c, stackTrace[length2].getClassName())) {
                    break;
                } else if (i11 < 0) {
                    break;
                } else {
                    length2 = i11;
                }
            }
        }
        length2 = -1;
        int i12 = length2 + 1;
        int f11 = f(stackTrace, f57299b);
        int i13 = (length - length2) - (f11 == -1 ? 0 : length - f11);
        StackTraceElement[] stackTraceElementArr = new StackTraceElement[i13];
        for (int i14 = 0; i14 < i13; i14++) {
            if (i14 == 0) {
                stackTraceElement = f57298a;
            } else {
                stackTraceElement = stackTrace[(i12 + i14) - 1];
            }
            stackTraceElementArr[i14] = stackTraceElement;
        }
        e11.setStackTrace(stackTraceElementArr);
        return e11;
    }

    public static final <E extends Throwable> E l(E e11) {
        E cause = e11.getCause();
        if (cause != null && x.b(cause.getClass(), e11.getClass())) {
            StackTraceElement[] stackTrace = e11.getStackTrace();
            int length = stackTrace.length;
            boolean z11 = false;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    break;
                } else if (g(stackTrace[i11])) {
                    z11 = true;
                    break;
                } else {
                    i11++;
                }
            }
            if (z11) {
                return cause;
            }
        }
        return e11;
    }
}
