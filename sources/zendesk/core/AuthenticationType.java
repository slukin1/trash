package zendesk.core;

import com.tencent.qcloud.tuicore.TUIConstants;

public enum AuthenticationType {
    JWT("jwt"),
    ANONYMOUS(TUIConstants.TUIPoll.PLUGIN_POLL_ANONYMOUS);
    
    private final String authenticationType;

    private AuthenticationType(String str) {
        this.authenticationType = str;
    }

    public static AuthenticationType getAuthType(String str) {
        AuthenticationType authenticationType2 = JWT;
        if (authenticationType2.authenticationType.equals(str)) {
            return authenticationType2;
        }
        AuthenticationType authenticationType3 = ANONYMOUS;
        if (authenticationType3.authenticationType.equals(str)) {
            return authenticationType3;
        }
        return null;
    }

    public String getAuthenticationType() {
        return this.authenticationType;
    }
}
