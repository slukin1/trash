package zendesk.support;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import mz.a;

public class EndUserComment {
    @SerializedName("uploads")
    private List<String> attachments;
    private String value;

    public List<String> getAttachments() {
        return a.c(this.attachments);
    }

    public void setAttachments(List<String> list) {
        this.attachments = list;
    }

    public void setValue(String str) {
        this.value = str;
    }
}
