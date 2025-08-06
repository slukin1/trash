package zendesk.core;

import java.io.Serializable;
import java.util.Date;

class SdkSettings implements Serializable {
    private String authentication;
    private Date updatedAt;

    public AuthenticationType getAuthentication() {
        return AuthenticationType.getAuthType(this.authentication);
    }

    public Date getUpdatedAt() {
        if (this.updatedAt == null) {
            return null;
        }
        return new Date(this.updatedAt.getTime());
    }
}
