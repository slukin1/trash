package zendesk.core;

import com.google.gson.annotations.SerializedName;
import java.util.Date;

public class CoreSettings implements Settings {
    private AuthenticationType authentication;
    @SerializedName("brand_id")
    private String brandId;
    private String identifier;
    @SerializedName("updated_at")
    private Date updatedAt;

    public CoreSettings(Date date, AuthenticationType authenticationType) {
        this.updatedAt = date;
        this.authentication = authenticationType;
    }

    public AuthenticationType getAuthentication() {
        return this.authentication;
    }

    public Date getUpdatedAt() {
        if (this.updatedAt != null) {
            return new Date(this.updatedAt.getTime());
        }
        return new Date(0);
    }
}
