package com.huawei.hms.core.aidl;

import android.os.Bundle;
import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class MessageCodecV2 extends MessageCodec {
    public List<Object> readList(Type type, Bundle bundle) throws InstantiationException, IllegalAccessException {
        int i11 = bundle.getInt("_list_size_");
        ArrayList arrayList = new ArrayList(i11);
        for (int i12 = 0; i12 < i11; i12++) {
            Object obj = bundle.get("_list_item_" + i12);
            if (obj.getClass().isPrimitive() || (obj instanceof String) || (obj instanceof Serializable)) {
                arrayList.add(obj);
            } else if (!(obj instanceof Bundle)) {
                continue;
            } else {
                Bundle bundle2 = (Bundle) obj;
                int i13 = bundle2.getInt("_val_type_", -1);
                if (i13 == 1) {
                    throw new InstantiationException("Nested List can not be supported");
                } else if (i13 == 0) {
                    arrayList.add(decode(bundle2, (IMessageEntity) ((Class) ((ParameterizedType) type).getActualTypeArguments()[0]).newInstance()));
                } else {
                    throw new InstantiationException("Unknown type can not be supported");
                }
            }
        }
        return arrayList;
    }

    public void writeList(String str, List list, Bundle bundle) {
        Bundle bundle2 = new Bundle();
        bundle2.putInt("_val_type_", 1);
        bundle2.putInt("_list_size_", list.size());
        for (int i11 = 0; i11 < list.size(); i11++) {
            writeValue("_list_item_" + i11, list.get(i11), bundle2);
        }
        bundle.putBundle(str, bundle2);
    }
}
