package zendesk.support;

import dagger.internal.b;
import dagger.internal.d;
import zendesk.configurations.ConfigurationHelper;

public final class SupportSdkModule_ConfigurationHelperFactory implements b<ConfigurationHelper> {
    private final SupportSdkModule module;

    public SupportSdkModule_ConfigurationHelperFactory(SupportSdkModule supportSdkModule) {
        this.module = supportSdkModule;
    }

    public static ConfigurationHelper configurationHelper(SupportSdkModule supportSdkModule) {
        return (ConfigurationHelper) d.f(supportSdkModule.configurationHelper());
    }

    public static SupportSdkModule_ConfigurationHelperFactory create(SupportSdkModule supportSdkModule) {
        return new SupportSdkModule_ConfigurationHelperFactory(supportSdkModule);
    }

    public ConfigurationHelper get() {
        return configurationHelper(this.module);
    }
}
