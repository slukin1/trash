package zendesk.support.guide;

import dagger.internal.b;
import dagger.internal.d;
import zendesk.configurations.ConfigurationHelper;

public final class GuideSdkModule_ConfigurationHelperFactory implements b<ConfigurationHelper> {
    private final GuideSdkModule module;

    public GuideSdkModule_ConfigurationHelperFactory(GuideSdkModule guideSdkModule) {
        this.module = guideSdkModule;
    }

    public static ConfigurationHelper configurationHelper(GuideSdkModule guideSdkModule) {
        return (ConfigurationHelper) d.f(guideSdkModule.configurationHelper());
    }

    public static GuideSdkModule_ConfigurationHelperFactory create(GuideSdkModule guideSdkModule) {
        return new GuideSdkModule_ConfigurationHelperFactory(guideSdkModule);
    }

    public ConfigurationHelper get() {
        return configurationHelper(this.module);
    }
}
