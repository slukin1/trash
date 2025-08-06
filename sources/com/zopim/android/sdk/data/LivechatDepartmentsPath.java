package com.zopim.android.sdk.data;

import com.google.gson.reflect.TypeToken;
import com.zendesk.logger.Logger;
import com.zopim.android.sdk.model.Department;
import java.util.LinkedHashMap;
import java.util.Map;

public class LivechatDepartmentsPath extends Path<LinkedHashMap<String, Department>> {
    private static final LivechatDepartmentsPath INSTANCE = new LivechatDepartmentsPath();
    private static final String LOG_TAG = "LivechatDepartmentsPath";
    private final Object lock = new Object();

    private LivechatDepartmentsPath() {
        this.data = new LinkedHashMap();
    }

    public static LivechatDepartmentsPath getInstance() {
        return INSTANCE;
    }

    private void updateInternal(LinkedHashMap<String, Department> linkedHashMap) {
        if (linkedHashMap == null) {
            Logger.g(LOG_TAG, "Passed parameter must not be null. Aborting update.", new Object[0]);
            return;
        }
        synchronized (this.lock) {
            for (Map.Entry next : linkedHashMap.entrySet()) {
                String str = (String) next.getKey();
                Department department = (Department) next.getValue();
                if (((LinkedHashMap) this.data).containsKey(str)) {
                    if (department == null) {
                        ((LinkedHashMap) this.data).remove(str);
                    } else {
                        Department department2 = (Department) ((LinkedHashMap) this.data).get(str);
                        if (department2 == null) {
                            ((LinkedHashMap) this.data).remove(str);
                        } else {
                            ((LinkedHashMap) this.data).put(str, (Department) ChatGson.performUpdate(department2, department, Department.class));
                        }
                    }
                } else if (department != null) {
                    ((LinkedHashMap) this.data).put(str, department);
                }
            }
            broadcast(getData());
        }
    }

    public void clear() {
        T t11 = this.data;
        if (t11 != null) {
            ((LinkedHashMap) t11).clear();
        }
    }

    public void update(String str) {
        if (isClearRequired(str)) {
            clear();
        } else if (str != null && !str.isEmpty()) {
            updateInternal((LinkedHashMap) ChatGson.get().fromJson(str, new TypeToken<LinkedHashMap<String, Department>>() {
            }.getType()));
        }
    }

    public LinkedHashMap<String, Department> getData() {
        if (this.data != null) {
            return new LinkedHashMap<>((Map) this.data);
        }
        return new LinkedHashMap<>();
    }
}
