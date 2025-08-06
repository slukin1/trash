package zendesk.core;

import com.zendesk.service.ZendeskCallback;

public interface SettingsProvider {
    void getCoreSettings(ZendeskCallback<CoreSettings> zendeskCallback);

    <E extends Settings> void getSettingsForSdk(String str, Class<E> cls, ZendeskCallback<SettingsPack<E>> zendeskCallback);
}
