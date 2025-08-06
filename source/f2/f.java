package f2;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.lang.reflect.Type;

public class f {

    /* renamed from: a  reason: collision with root package name */
    public Object f15739a;

    /* renamed from: b  reason: collision with root package name */
    public final f f15740b;

    /* renamed from: c  reason: collision with root package name */
    public final Object f15741c;

    /* renamed from: d  reason: collision with root package name */
    public Type f15742d;

    /* renamed from: e  reason: collision with root package name */
    public transient String f15743e;

    public f(f fVar, Object obj, Object obj2) {
        this.f15740b = fVar;
        this.f15739a = obj;
        this.f15741c = obj2;
    }

    public String toString() {
        if (this.f15743e == null) {
            if (this.f15740b == null) {
                this.f15743e = "$";
            } else if (this.f15741c instanceof Integer) {
                this.f15743e = this.f15740b.toString() + "[" + this.f15741c + "]";
            } else {
                this.f15743e = this.f15740b.toString() + InstructionFileId.DOT + this.f15741c;
            }
        }
        return this.f15743e;
    }
}
