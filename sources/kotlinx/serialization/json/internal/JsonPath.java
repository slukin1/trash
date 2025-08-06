package kotlinx.serialization.json.internal;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.util.Arrays;
import kotlin.jvm.internal.x;
import kotlinx.serialization.descriptors.f;
import kotlinx.serialization.descriptors.i;

public final class JsonPath {

    /* renamed from: a  reason: collision with root package name */
    public Object[] f57874a = new Object[8];

    /* renamed from: b  reason: collision with root package name */
    public int[] f57875b;

    /* renamed from: c  reason: collision with root package name */
    public int f57876c;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public static final a f57877a = new a();
    }

    public JsonPath() {
        int[] iArr = new int[8];
        for (int i11 = 0; i11 < 8; i11++) {
            iArr[i11] = -1;
        }
        this.f57875b = iArr;
        this.f57876c = -1;
    }

    public final String a() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("$");
        int i11 = this.f57876c + 1;
        for (int i12 = 0; i12 < i11; i12++) {
            Object obj = this.f57874a[i12];
            if (obj instanceof f) {
                f fVar = (f) obj;
                if (!x.b(fVar.getKind(), i.b.f57648a)) {
                    int i13 = this.f57875b[i12];
                    if (i13 >= 0) {
                        sb2.append(InstructionFileId.DOT);
                        sb2.append(fVar.f(i13));
                    }
                } else if (this.f57875b[i12] != -1) {
                    sb2.append("[");
                    sb2.append(this.f57875b[i12]);
                    sb2.append("]");
                }
            } else if (obj != a.f57877a) {
                sb2.append("[");
                sb2.append("'");
                sb2.append(obj);
                sb2.append("'");
                sb2.append("]");
            }
        }
        return sb2.toString();
    }

    public final void b() {
        int i11 = this.f57876c;
        int[] iArr = this.f57875b;
        if (iArr[i11] == -2) {
            iArr[i11] = -1;
            this.f57876c = i11 - 1;
        }
        int i12 = this.f57876c;
        if (i12 != -1) {
            this.f57876c = i12 - 1;
        }
    }

    public final void c(f fVar) {
        int i11 = this.f57876c + 1;
        this.f57876c = i11;
        if (i11 == this.f57874a.length) {
            e();
        }
        this.f57874a[i11] = fVar;
    }

    public final void d() {
        int[] iArr = this.f57875b;
        int i11 = this.f57876c;
        if (iArr[i11] == -2) {
            this.f57874a[i11] = a.f57877a;
        }
    }

    public final void e() {
        int i11 = this.f57876c * 2;
        this.f57874a = Arrays.copyOf(this.f57874a, i11);
        this.f57875b = Arrays.copyOf(this.f57875b, i11);
    }

    public final void f(Object obj) {
        int[] iArr = this.f57875b;
        int i11 = this.f57876c;
        if (iArr[i11] != -2) {
            int i12 = i11 + 1;
            this.f57876c = i12;
            if (i12 == this.f57874a.length) {
                e();
            }
        }
        Object[] objArr = this.f57874a;
        int i13 = this.f57876c;
        objArr[i13] = obj;
        this.f57875b[i13] = -2;
    }

    public final void g(int i11) {
        this.f57875b[this.f57876c] = i11;
    }

    public String toString() {
        return a();
    }
}
