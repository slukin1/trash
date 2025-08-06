package kotlin.text;

import d10.l;

class StringsKt__AppendableKt {
    public static <T> void a(Appendable appendable, T t11, l<? super T, ? extends CharSequence> lVar) {
        boolean z11;
        if (lVar != null) {
            appendable.append((CharSequence) lVar.invoke(t11));
            return;
        }
        if (t11 == null) {
            z11 = true;
        } else {
            z11 = t11 instanceof CharSequence;
        }
        if (z11) {
            appendable.append((CharSequence) t11);
        } else if (t11 instanceof Character) {
            appendable.append(((Character) t11).charValue());
        } else {
            appendable.append(String.valueOf(t11));
        }
    }
}
