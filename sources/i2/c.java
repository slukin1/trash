package i2;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Arrays;

public class c implements ParameterizedType {

    /* renamed from: b  reason: collision with root package name */
    public final Type[] f15996b;

    /* renamed from: c  reason: collision with root package name */
    public final Type f15997c;

    /* renamed from: d  reason: collision with root package name */
    public final Type f15998d;

    public c(Type[] typeArr, Type type, Type type2) {
        this.f15996b = typeArr;
        this.f15997c = type;
        this.f15998d = type2;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        c cVar = (c) obj;
        if (!Arrays.equals(this.f15996b, cVar.f15996b)) {
            return false;
        }
        Type type = this.f15997c;
        if (type == null ? cVar.f15997c != null : !type.equals(cVar.f15997c)) {
            return false;
        }
        Type type2 = this.f15998d;
        Type type3 = cVar.f15998d;
        if (type2 != null) {
            return type2.equals(type3);
        }
        if (type3 == null) {
            return true;
        }
        return false;
    }

    public Type[] getActualTypeArguments() {
        return this.f15996b;
    }

    public Type getOwnerType() {
        return this.f15997c;
    }

    public Type getRawType() {
        return this.f15998d;
    }

    public int hashCode() {
        Type[] typeArr = this.f15996b;
        int i11 = 0;
        int hashCode = (typeArr != null ? Arrays.hashCode(typeArr) : 0) * 31;
        Type type = this.f15997c;
        int hashCode2 = (hashCode + (type != null ? type.hashCode() : 0)) * 31;
        Type type2 = this.f15998d;
        if (type2 != null) {
            i11 = type2.hashCode();
        }
        return hashCode2 + i11;
    }
}
