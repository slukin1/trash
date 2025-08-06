package kotlin.sequences;

import d10.l;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

class SequencesKt___SequencesKt extends SequencesKt___SequencesJvmKt {

    public static final class a implements Iterable<T>, e10.a {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ g f56868b;

        public a(g gVar) {
            this.f56868b = gVar;
        }

        public Iterator<T> iterator() {
            return this.f56868b.iterator();
        }
    }

    public static <T> Iterable<T> h(g<? extends T> gVar) {
        return new a(gVar);
    }

    public static <T> int i(g<? extends T> gVar) {
        Iterator<? extends T> it2 = gVar.iterator();
        int i11 = 0;
        while (it2.hasNext()) {
            it2.next();
            i11++;
            if (i11 < 0) {
                CollectionsKt__CollectionsKt.s();
            }
        }
        return i11;
    }

    public static <T> g<T> j(g<? extends T> gVar, int i11) {
        if (!(i11 >= 0)) {
            throw new IllegalArgumentException(("Requested element count " + i11 + " is less than zero.").toString());
        } else if (i11 == 0) {
            return gVar;
        } else {
            if (gVar instanceof c) {
                return ((c) gVar).a(i11);
            }
            return new b(gVar, i11);
        }
    }

    public static <T> g<T> k(g<? extends T> gVar, l<? super T, Boolean> lVar) {
        return new e(gVar, true, lVar);
    }

    public static final <T> g<T> l(g<? extends T> gVar, l<? super T, Boolean> lVar) {
        return new e(gVar, false, lVar);
    }

    public static <T> g<T> m(g<? extends T> gVar) {
        return l(gVar, SequencesKt___SequencesKt$filterNotNull$1.INSTANCE);
    }

    public static <T> T n(g<? extends T> gVar) {
        Iterator<? extends T> it2 = gVar.iterator();
        if (!it2.hasNext()) {
            return null;
        }
        return it2.next();
    }

    public static final <T, A extends Appendable> A o(g<? extends T> gVar, A a11, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) {
        a11.append(charSequence2);
        int i12 = 0;
        for (Object next : gVar) {
            i12++;
            if (i12 > 1) {
                a11.append(charSequence);
            }
            if (i11 >= 0 && i12 > i11) {
                break;
            }
            StringsKt__AppendableKt.a(a11, next, lVar);
        }
        if (i11 >= 0 && i12 > i11) {
            a11.append(charSequence4);
        }
        a11.append(charSequence3);
        return a11;
    }

    public static final <T> String p(g<? extends T> gVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, l<? super T, ? extends CharSequence> lVar) {
        return ((StringBuilder) o(gVar, new StringBuilder(), charSequence, charSequence2, charSequence3, i11, charSequence4, lVar)).toString();
    }

    public static /* synthetic */ String q(g gVar, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, int i11, CharSequence charSequence4, l lVar, int i12, Object obj) {
        if ((i12 & 1) != 0) {
            charSequence = ", ";
        }
        CharSequence charSequence5 = "";
        CharSequence charSequence6 = (i12 & 2) != 0 ? charSequence5 : charSequence2;
        if ((i12 & 4) == 0) {
            charSequence5 = charSequence3;
        }
        if ((i12 & 8) != 0) {
            i11 = -1;
        }
        int i13 = i11;
        if ((i12 & 16) != 0) {
            charSequence4 = "...";
        }
        CharSequence charSequence7 = charSequence4;
        if ((i12 & 32) != 0) {
            lVar = null;
        }
        return p(gVar, charSequence, charSequence6, charSequence5, i13, charSequence7, lVar);
    }

    public static <T> T r(g<? extends T> gVar) {
        Iterator<? extends T> it2 = gVar.iterator();
        if (it2.hasNext()) {
            T next = it2.next();
            while (it2.hasNext()) {
                next = it2.next();
            }
            return next;
        }
        throw new NoSuchElementException("Sequence is empty.");
    }

    public static <T, R> g<R> s(g<? extends T> gVar, l<? super T, ? extends R> lVar) {
        return new j(gVar, lVar);
    }

    public static <T, R> g<R> t(g<? extends T> gVar, l<? super T, ? extends R> lVar) {
        return m(new j(gVar, lVar));
    }

    public static <T> g<T> u(g<? extends T> gVar, l<? super T, Boolean> lVar) {
        return new i(gVar, lVar);
    }

    public static final <T, C extends Collection<? super T>> C v(g<? extends T> gVar, C c11) {
        for (Object add : gVar) {
            c11.add(add);
        }
        return c11;
    }

    public static <T> List<T> w(g<? extends T> gVar) {
        return CollectionsKt__CollectionsKt.q(x(gVar));
    }

    public static <T> List<T> x(g<? extends T> gVar) {
        return (List) v(gVar, new ArrayList());
    }
}
