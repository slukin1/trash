package com.yanzhenjie.recyclerview.swipe.touch;

import androidx.recyclerview.widget.g;
import ez.a;
import ez.b;
import ez.c;

public class DefaultItemTouchHelper extends g {
    public DefaultItemTouchHelperCallback E;

    public DefaultItemTouchHelper() {
        this(new DefaultItemTouchHelperCallback());
    }

    public void C(boolean z11) {
        this.E.a(z11);
    }

    public void D(boolean z11) {
        this.E.b(z11);
    }

    public void E(a aVar) {
        this.E.c(aVar);
    }

    public void F(b bVar) {
        this.E.d(bVar);
    }

    public void G(c cVar) {
        this.E.e(cVar);
    }

    public DefaultItemTouchHelper(DefaultItemTouchHelperCallback defaultItemTouchHelperCallback) {
        super(defaultItemTouchHelperCallback);
        this.E = (DefaultItemTouchHelperCallback) B();
    }
}
