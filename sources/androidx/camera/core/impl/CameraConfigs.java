package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import java.util.Set;

public class CameraConfigs {
    private static final CameraConfig EMPTY_CONFIG = new EmptyCameraConfig();

    public static final class EmptyCameraConfig implements CameraConfig {
        private final Identifier mIdentifier = Identifier.create(new Object());

        public /* synthetic */ boolean containsOption(Config.Option option) {
            return g0.a(this, option);
        }

        public /* synthetic */ void findOptions(String str, Config.OptionMatcher optionMatcher) {
            g0.b(this, str, optionMatcher);
        }

        public Identifier getCompatibilityId() {
            return this.mIdentifier;
        }

        public Config getConfig() {
            return OptionsBundle.emptyBundle();
        }

        public /* synthetic */ Config.OptionPriority getOptionPriority(Config.Option option) {
            return g0.c(this, option);
        }

        public /* synthetic */ Set getPriorities(Config.Option option) {
            return g0.d(this, option);
        }

        public /* synthetic */ SessionProcessor getSessionProcessor() {
            return b.a(this);
        }

        public /* synthetic */ SessionProcessor getSessionProcessor(SessionProcessor sessionProcessor) {
            return b.b(this, sessionProcessor);
        }

        public /* synthetic */ int getUseCaseCombinationRequiredRule() {
            return b.c(this);
        }

        public /* synthetic */ UseCaseConfigFactory getUseCaseConfigFactory() {
            return b.d(this);
        }

        public /* synthetic */ Set listOptions() {
            return g0.e(this);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option) {
            return g0.f(this, option);
        }

        public /* synthetic */ Object retrieveOption(Config.Option option, Object obj) {
            return g0.g(this, option, obj);
        }

        public /* synthetic */ Object retrieveOptionWithPriority(Config.Option option, Config.OptionPriority optionPriority) {
            return g0.h(this, option, optionPriority);
        }
    }

    private CameraConfigs() {
    }

    public static CameraConfig emptyConfig() {
        return EMPTY_CONFIG;
    }
}
