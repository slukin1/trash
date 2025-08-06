package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.z;
import java.util.Map;

public class b0 implements a0 {
    public static <K, V> int a(int i11, Object obj, Object obj2) {
        MapFieldLite mapFieldLite = (MapFieldLite) obj;
        z zVar = (z) obj2;
        int i12 = 0;
        if (mapFieldLite.isEmpty()) {
            return 0;
        }
        for (Map.Entry entry : mapFieldLite.entrySet()) {
            i12 += zVar.a(i11, entry.getKey(), entry.getValue());
        }
        return i12;
    }

    public static <K, V> MapFieldLite<K, V> b(Object obj, Object obj2) {
        MapFieldLite<K, V> mapFieldLite = (MapFieldLite) obj;
        MapFieldLite mapFieldLite2 = (MapFieldLite) obj2;
        if (!mapFieldLite2.isEmpty()) {
            if (!mapFieldLite.isMutable()) {
                mapFieldLite = mapFieldLite.mutableCopy();
            }
            mapFieldLite.mergeFrom(mapFieldLite2);
        }
        return mapFieldLite;
    }

    public Map<?, ?> forMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    public z.a<?, ?> forMapMetadata(Object obj) {
        return ((z) obj).c();
    }

    public Map<?, ?> forMutableMapData(Object obj) {
        return (MapFieldLite) obj;
    }

    public int getSerializedSize(int i11, Object obj, Object obj2) {
        return a(i11, obj, obj2);
    }

    public boolean isImmutable(Object obj) {
        return !((MapFieldLite) obj).isMutable();
    }

    public Object mergeFrom(Object obj, Object obj2) {
        return b(obj, obj2);
    }

    public Object newMapField(Object obj) {
        return MapFieldLite.emptyMapField().mutableCopy();
    }

    public Object toImmutable(Object obj) {
        ((MapFieldLite) obj).makeImmutable();
        return obj;
    }
}
