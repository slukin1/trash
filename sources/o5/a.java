package o5;

import com.google.firebase.components.Component;
import com.google.firebase.components.ComponentContainer;
import com.google.firebase.components.ComponentFactory;
import com.google.firebase.tracing.ComponentMonitor;

public final /* synthetic */ class a implements ComponentFactory {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f58797a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ Component f58798b;

    public /* synthetic */ a(String str, Component component) {
        this.f58797a = str;
        this.f58798b = component;
    }

    public final Object create(ComponentContainer componentContainer) {
        return ComponentMonitor.lambda$processRegistrar$0(this.f58797a, this.f58798b, componentContainer);
    }
}
