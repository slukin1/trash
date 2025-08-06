package androidx.camera.core.impl;

import androidx.camera.core.impl.Config;
import androidx.camera.core.impl.utils.ResolutionSelectorUtil;
import androidx.camera.core.resolutionselector.ResolutionSelector;
import java.util.Objects;

public final /* synthetic */ class o {
    public static boolean a(Config.OptionPriority optionPriority, Config.OptionPriority optionPriority2) {
        Config.OptionPriority optionPriority3 = Config.OptionPriority.ALWAYS_OVERRIDE;
        if (optionPriority == optionPriority3 && optionPriority2 == optionPriority3) {
            return true;
        }
        Config.OptionPriority optionPriority4 = Config.OptionPriority.REQUIRED;
        if (optionPriority == optionPriority4 && optionPriority2 == optionPriority4) {
            return true;
        }
        return false;
    }

    public static Config b(Config config, Config config2) {
        MutableOptionsBundle mutableOptionsBundle;
        if (config == null && config2 == null) {
            return OptionsBundle.emptyBundle();
        }
        if (config2 != null) {
            mutableOptionsBundle = MutableOptionsBundle.from(config2);
        } else {
            mutableOptionsBundle = MutableOptionsBundle.create();
        }
        if (config != null) {
            for (Config.Option<?> c11 : config.listOptions()) {
                c(mutableOptionsBundle, config2, config, c11);
            }
        }
        return OptionsBundle.from(mutableOptionsBundle);
    }

    public static void c(MutableOptionsBundle mutableOptionsBundle, Config config, Config config2, Config.Option<?> option) {
        if (Objects.equals(option, ImageOutputConfig.OPTION_RESOLUTION_SELECTOR)) {
            mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), ResolutionSelectorUtil.overrideResolutionSelectors((ResolutionSelector) config.retrieveOption(option, null), (ResolutionSelector) config2.retrieveOption(option, null)));
            return;
        }
        mutableOptionsBundle.insertOption(option, config2.getOptionPriority(option), config2.retrieveOption(option));
    }
}
