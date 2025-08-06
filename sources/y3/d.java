package y3;

import w3.b;

public class d extends b<c> {
    public d(c cVar) {
        super(cVar);
    }

    public Class<c> a() {
        return c.class;
    }

    public int getSize() {
        return ((c) this.f66659b).i();
    }

    public void initialize() {
        ((c) this.f66659b).e().prepareToDraw();
    }

    public void recycle() {
        ((c) this.f66659b).stop();
        ((c) this.f66659b).k();
    }
}
