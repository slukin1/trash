package zendesk.core;

import android.content.Context;
import dagger.internal.b;
import dagger.internal.d;
import q00.a;

public final class ZendeskApplicationModule_ProvideDeviceInfoFactory implements b<DeviceInfo> {
    private final a<Context> contextProvider;

    public ZendeskApplicationModule_ProvideDeviceInfoFactory(a<Context> aVar) {
        this.contextProvider = aVar;
    }

    public static ZendeskApplicationModule_ProvideDeviceInfoFactory create(a<Context> aVar) {
        return new ZendeskApplicationModule_ProvideDeviceInfoFactory(aVar);
    }

    public static DeviceInfo provideDeviceInfo(Context context) {
        return (DeviceInfo) d.f(ZendeskApplicationModule.provideDeviceInfo(context));
    }

    public DeviceInfo get() {
        return provideDeviceInfo(this.contextProvider.get());
    }
}
