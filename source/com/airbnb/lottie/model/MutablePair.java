package com.airbnb.lottie.model;

import androidx.core.util.c;

public class MutablePair<T> {
    public T first;
    public T second;

    private static boolean objectsEqual(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof c)) {
            return false;
        }
        c cVar = (c) obj;
        if (!objectsEqual(cVar.f8468a, this.first) || !objectsEqual(cVar.f8469b, this.second)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        T t11 = this.first;
        int i11 = 0;
        int hashCode = t11 == null ? 0 : t11.hashCode();
        T t12 = this.second;
        if (t12 != null) {
            i11 = t12.hashCode();
        }
        return hashCode ^ i11;
    }

    public void set(T t11, T t12) {
        this.first = t11;
        this.second = t12;
    }

    public String toString() {
        return "Pair{" + this.first + " " + this.second + "}";
    }
}
