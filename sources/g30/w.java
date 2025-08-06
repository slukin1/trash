package g30;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.z;
import com.zendesk.logger.Logger;
import java.util.concurrent.atomic.AtomicBoolean;

public class w<T> extends MutableLiveData<T> {

    /* renamed from: a  reason: collision with root package name */
    public final AtomicBoolean f60315a = new AtomicBoolean(false);

    public class a implements z<T> {

        /* renamed from: b  reason: collision with root package name */
        public final /* synthetic */ z f60316b;

        public a(z zVar) {
            this.f60316b = zVar;
        }

        public void onChanged(T t11) {
            if (w.this.f60315a.compareAndSet(true, false)) {
                this.f60316b.onChanged(t11);
            }
        }
    }

    public void observe(LifecycleOwner lifecycleOwner, z<? super T> zVar) {
        if (hasActiveObservers()) {
            Logger.l("SingleLiveEvent", "Multiple observers registered but only one will be notified of changes.", new Object[0]);
        }
        super.observe(lifecycleOwner, new a(zVar));
    }

    public void setValue(T t11) {
        this.f60315a.set(true);
        super.setValue(t11);
    }
}
