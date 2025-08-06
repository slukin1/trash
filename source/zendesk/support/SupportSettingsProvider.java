package zendesk.support;

import com.zendesk.service.ZendeskCallback;

public interface SupportSettingsProvider {
    void getSettings(ZendeskCallback<SupportSdkSettings> zendeskCallback);
}
