package zendesk.support;

import com.zendesk.service.ZendeskCallback;

public interface HelpCenterSettingsProvider {
    void getSettings(ZendeskCallback<HelpCenterSettings> zendeskCallback);
}
