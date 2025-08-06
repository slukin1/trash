package androidx.lifecycle;

import kotlinx.coroutines.e2;
import kotlinx.coroutines.h0;
import kotlinx.coroutines.n1;
import kotlinx.coroutines.v0;

public final class m0 {
    public static final h0 a(ViewModel viewModel) {
        h0 h0Var = (h0) viewModel.getTag("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY");
        if (h0Var != null) {
            return h0Var;
        }
        return (h0) viewModel.setTagIfAbsent("androidx.lifecycle.ViewModelCoroutineScope.JOB_KEY", new d(e2.b((n1) null, 1, (Object) null).plus(v0.c().G())));
    }
}
