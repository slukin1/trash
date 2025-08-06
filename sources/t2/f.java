package t2;

public class f<T> extends g<T> {

    /* renamed from: d  reason: collision with root package name */
    public a f16552d;

    public interface a {
        void a(c cVar, Throwable th2);

        void b(c cVar);

        void c(c cVar, Object obj);
    }

    public f(b<T> bVar, a aVar) {
        super(bVar);
        this.f16552d = aVar;
    }

    public T a() {
        try {
            a aVar = this.f16552d;
            if (aVar != null) {
                aVar.b(c());
            }
        } catch (Exception e11) {
            e11.printStackTrace();
        } catch (Throwable th2) {
            a aVar2 = this.f16552d;
            if (aVar2 != null) {
                try {
                    aVar2.a(c(), th2);
                } catch (Exception e12) {
                    e12.printStackTrace();
                }
            }
            throw th2;
        }
        T a11 = super.a();
        a aVar3 = this.f16552d;
        if (aVar3 != null) {
            try {
                aVar3.c(c(), a11);
            } catch (Exception e13) {
                e13.printStackTrace();
            }
        }
        return a11;
    }
}
