package zendesk.core;

import zendesk.core.Settings;

public class SettingsPack<E extends Settings> {
    private CoreSettings coreSettings;
    private E settings;

    public SettingsPack(CoreSettings coreSettings2, E e11) {
        this.coreSettings = coreSettings2;
        this.settings = e11;
    }

    public CoreSettings getCoreSettings() {
        return this.coreSettings;
    }

    public E getSettings() {
        return this.settings;
    }
}
