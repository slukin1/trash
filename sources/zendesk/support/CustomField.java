package zendesk.support;

import com.zendesk.logger.Logger;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import mz.a;

public class CustomField implements Serializable {
    private static final String LOG_TAG = "CustomField";

    /* renamed from: id  reason: collision with root package name */
    private Long f62944id;
    private Object value;

    public CustomField(Long l11, Object obj) {
        this.f62944id = l11;
        this.value = obj;
    }

    public Long getId() {
        return this.f62944id;
    }

    @Deprecated
    public String getValue() {
        Object obj = this.value;
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof Boolean) {
            return String.valueOf(obj);
        }
        Logger.l(LOG_TAG, "Custom Field Value is of a type other than String or Boolean. Is this a multi-select field?", new Object[0]);
        return null;
    }

    public Boolean getValueBoolean() {
        Object obj = this.value;
        if (obj == null) {
            return null;
        }
        if (obj instanceof Boolean) {
            return (Boolean) obj;
        }
        Logger.l(LOG_TAG, "Custom field value is not a boolean", new Object[0]);
        return null;
    }

    public List<String> getValueList() {
        Object obj = this.value;
        if (obj == null) {
            return null;
        }
        if (obj instanceof List) {
            List<Object> list = (List) obj;
            if (a.i(list)) {
                ArrayList arrayList = new ArrayList(list.size());
                for (Object valueOf : list) {
                    arrayList.add(String.valueOf(valueOf));
                }
                return arrayList;
            }
        }
        Logger.l(LOG_TAG, "Custom field value is not a list.", new Object[0]);
        return null;
    }

    public Object getValueObject() {
        return this.value;
    }

    public String getValueString() {
        Object obj = this.value;
        if (obj == null) {
            return null;
        }
        if (obj instanceof String) {
            return (String) obj;
        }
        Logger.l(LOG_TAG, "Custom field value is not a string", new Object[0]);
        return null;
    }
}
