package kotlin.jvm.internal;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Objects;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    public static final Object[] f56795a = new Object[0];

    public static final Object[] a(Collection<?> collection) {
        int size = collection.size();
        if (size != 0) {
            Iterator<?> it2 = collection.iterator();
            if (it2.hasNext()) {
                Object[] objArr = new Object[size];
                int i11 = 0;
                while (true) {
                    int i12 = i11 + 1;
                    objArr[i11] = it2.next();
                    if (i12 >= objArr.length) {
                        if (!it2.hasNext()) {
                            return objArr;
                        }
                        int i13 = ((i12 * 3) + 1) >>> 1;
                        if (i13 <= i12) {
                            if (i12 < 2147483645) {
                                i13 = 2147483645;
                            } else {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr = Arrays.copyOf(objArr, i13);
                    } else if (!it2.hasNext()) {
                        return Arrays.copyOf(objArr, i12);
                    }
                    i11 = i12;
                }
            }
        }
        return f56795a;
    }

    public static final Object[] b(Collection<?> collection, Object[] objArr) {
        Objects.requireNonNull(objArr);
        int size = collection.size();
        int i11 = 0;
        if (size != 0) {
            Iterator<?> it2 = collection.iterator();
            if (it2.hasNext()) {
                Object[] objArr2 = size <= objArr.length ? objArr : (Object[]) Array.newInstance(objArr.getClass().getComponentType(), size);
                while (true) {
                    int i12 = i11 + 1;
                    objArr2[i11] = it2.next();
                    if (i12 >= objArr2.length) {
                        if (!it2.hasNext()) {
                            return objArr2;
                        }
                        int i13 = ((i12 * 3) + 1) >>> 1;
                        if (i13 <= i12) {
                            if (i12 < 2147483645) {
                                i13 = 2147483645;
                            } else {
                                throw new OutOfMemoryError();
                            }
                        }
                        objArr2 = Arrays.copyOf(objArr2, i13);
                    } else if (!it2.hasNext()) {
                        if (objArr2 != objArr) {
                            return Arrays.copyOf(objArr2, i12);
                        }
                        objArr[i12] = null;
                        return objArr;
                    }
                    i11 = i12;
                }
            } else if (objArr.length <= 0) {
                return objArr;
            } else {
                objArr[0] = null;
                return objArr;
            }
        } else if (objArr.length <= 0) {
            return objArr;
        } else {
            objArr[0] = null;
            return objArr;
        }
    }
}
