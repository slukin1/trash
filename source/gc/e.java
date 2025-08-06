package gc;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.q0;

public final class e {

    /* renamed from: a  reason: collision with root package name */
    public static final e f19132a = new e();

    public final <T extends ViewModel> T a(q0 q0Var, Class<T> cls) {
        return new ViewModelProvider(q0Var, (ViewModelProvider.Factory) new ViewModelProvider.NewInstanceFactory()).a(cls);
    }
}
