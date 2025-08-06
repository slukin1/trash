package io.reactivex.rxjava3.internal.functions;

import j00.d;
import java.util.Objects;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final d<Object, Object> f55453a = new C0655a();

    /* renamed from: io.reactivex.rxjava3.internal.functions.a$a  reason: collision with other inner class name */
    public static final class C0655a implements d<Object, Object> {
        public boolean a(Object obj, Object obj2) {
            return Objects.equals(obj, obj2);
        }
    }

    public static int a(int i11, String str) {
        if (i11 > 0) {
            return i11;
        }
        throw new IllegalArgumentException(str + " > 0 required but it was " + i11);
    }
}
