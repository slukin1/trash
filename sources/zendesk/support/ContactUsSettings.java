package zendesk.support;

import java.util.Collections;
import java.util.List;
import mz.a;

class ContactUsSettings {
    private static ContactUsSettings DEFAULT = new ContactUsSettings(Collections.emptyList());
    private List<String> tags;

    public ContactUsSettings(List<String> list) {
        this.tags = list;
    }

    public static ContactUsSettings defaultSettings() {
        return DEFAULT;
    }

    public List<String> getTags() {
        return a.c(this.tags);
    }

    public ContactUsSettings() {
    }
}
