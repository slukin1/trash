package zendesk.core;

import com.google.gson.annotations.SerializedName;

class PushRegistrationRequestWrapper {
    @SerializedName("push_notification_device")
    private PushRegistrationRequest pushRegistrationRequest;

    public PushRegistrationRequestWrapper(PushRegistrationRequest pushRegistrationRequest2) {
        this.pushRegistrationRequest = pushRegistrationRequest2;
    }

    public PushRegistrationRequest getPushRegistrationRequest() {
        return this.pushRegistrationRequest;
    }
}
