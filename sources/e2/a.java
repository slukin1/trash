package e2;

import com.alibaba.fastjson.asm.ByteVector;
import com.alibaba.fastjson.asm.ClassWriter;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public a f15640a;

    /* renamed from: b  reason: collision with root package name */
    public final int f15641b;

    /* renamed from: c  reason: collision with root package name */
    public final int f15642c;

    /* renamed from: d  reason: collision with root package name */
    public final int f15643d;

    public a(ClassWriter classWriter, int i11, String str, String str2) {
        if (classWriter.f14164o == null) {
            classWriter.f14164o = this;
        } else {
            classWriter.f14165p.f15640a = this;
        }
        classWriter.f14165p = this;
        this.f15641b = i11;
        this.f15642c = classWriter.h(str);
        this.f15643d = classWriter.h(str2);
    }

    public int a() {
        return 8;
    }

    public void b(ByteVector byteVector) {
        byteVector.g(this.f15641b & -393217).g(this.f15642c).g(this.f15643d);
        byteVector.g(0);
    }

    public void c() {
    }
}
