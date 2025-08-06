package zendesk.core;

import com.google.gson.annotations.SerializedName;

class PushRegistrationResponseWrapper {
    @SerializedName("push_notification_device")
    private PushRegistrationResponse registrationResponse;

    public PushRegistrationResponse getRegistrationResponse() {
        return this.registrationResponse;
    }
}
