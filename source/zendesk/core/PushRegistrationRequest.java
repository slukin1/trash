package zendesk.core;

class PushRegistrationRequest {
    private final String deviceType = "android";
    private String identifier;
    private String locale;
    private String sdkGuid;
    private String tokenType;

    public String getIdentifier() {
        return this.identifier;
    }

    public String getLocale() {
        return this.locale;
    }

    public String getSdkGuid() {
        return this.sdkGuid;
    }

    public String getTokenType() {
        return this.tokenType;
    }

    public void setIdentifier(String str) {
        this.identifier = str;
    }

    public void setLocale(String str) {
        this.locale = str;
    }

    public void setSdkGuid(String str) {
        this.sdkGuid = str;
    }

    public void setTokenType(String str) {
        this.tokenType = str;
    }
}
