package zendesk.core;

import com.zendesk.service.ZendeskCallback;

public interface PushRegistrationProvider {
    boolean isRegisteredForPush();

    void registerWithDeviceIdentifier(String str, ZendeskCallback<String> zendeskCallback);

    void registerWithUAChannelId(String str, ZendeskCallback<String> zendeskCallback);

    void unregisterDevice(ZendeskCallback<Void> zendeskCallback);
}
