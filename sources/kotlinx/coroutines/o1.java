package kotlinx.coroutines;

public class o1 extends JobSupport implements w {

    /* renamed from: d  reason: collision with root package name */
    public final boolean f57386d = b1();

    public o1(n1 n1Var) {
        super(true);
        v0(n1Var);
    }

    public final boolean b1() {
        JobSupport r11;
        q r02 = r0();
        r rVar = r02 instanceof r ? (r) r02 : null;
        if (!(rVar == null || (r11 = rVar.r()) == null)) {
            while (!r11.o0()) {
                q r03 = r11.r0();
                r rVar2 = r03 instanceof r ? (r) r03 : null;
                if (rVar2 != null) {
                    r11 = rVar2.r();
                    if (r11 == null) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    public boolean o0() {
        return this.f57386d;
    }

    public boolean p0() {
        return true;
    }
}
