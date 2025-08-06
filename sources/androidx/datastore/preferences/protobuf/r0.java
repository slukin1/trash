package androidx.datastore.preferences.protobuf;

public final class r0 implements d0 {

    /* renamed from: a  reason: collision with root package name */
    public final f0 f9205a;

    /* renamed from: b  reason: collision with root package name */
    public final String f9206b;

    /* renamed from: c  reason: collision with root package name */
    public final Object[] f9207c;

    /* renamed from: d  reason: collision with root package name */
    public final int f9208d;

    public r0(f0 f0Var, String str, Object[] objArr) {
        this.f9205a = f0Var;
        this.f9206b = str;
        this.f9207c = objArr;
        char charAt = str.charAt(0);
        if (charAt < 55296) {
            this.f9208d = charAt;
            return;
        }
        char c11 = charAt & 8191;
        int i11 = 13;
        int i12 = 1;
        while (true) {
            int i13 = i12 + 1;
            char charAt2 = str.charAt(i12);
            if (charAt2 >= 55296) {
                c11 |= (charAt2 & 8191) << i11;
                i11 += 13;
                i12 = i13;
            } else {
                this.f9208d = c11 | (charAt2 << i11);
                return;
            }
        }
    }

    public Object[] a() {
        return this.f9207c;
    }

    public String b() {
        return this.f9206b;
    }

    public f0 getDefaultInstance() {
        return this.f9205a;
    }

    public ProtoSyntax getSyntax() {
        return (this.f9208d & 1) == 1 ? ProtoSyntax.PROTO2 : ProtoSyntax.PROTO3;
    }

    public boolean isMessageSetWireFormat() {
        return (this.f9208d & 2) == 2;
    }
}
