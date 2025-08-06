package androidx.lifecycle;

import androidx.lifecycle.viewmodel.CreationExtras;

public final class p0 {
    public static final CreationExtras a(q0 q0Var) {
        if (q0Var instanceof o) {
            return ((o) q0Var).getDefaultViewModelCreationExtras();
        }
        return CreationExtras.a.f10040b;
    }
}
