package h2;

import com.amazonaws.services.s3.model.InstructionFileId;

public class n {

    /* renamed from: a  reason: collision with root package name */
    public final n f15923a;

    /* renamed from: b  reason: collision with root package name */
    public final Object f15924b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f15925c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15926d;

    public n(n nVar, Object obj, Object obj2, int i11, int i12) {
        this.f15923a = nVar;
        this.f15924b = obj;
        this.f15925c = obj2;
        this.f15926d = i11;
    }

    public String toString() {
        if (this.f15923a == null) {
            return "$";
        }
        if (this.f15925c instanceof Integer) {
            return this.f15923a.toString() + "[" + this.f15925c + "]";
        }
        return this.f15923a.toString() + InstructionFileId.DOT + this.f15925c;
    }
}
