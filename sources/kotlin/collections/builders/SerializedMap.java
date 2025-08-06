package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Map;
import kotlin.jvm.internal.r;

final class SerializedMap implements Externalizable {
    public static final a Companion = new a((r) null);
    private static final long serialVersionUID = 0;
    private Map<?, ?> map;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public SerializedMap(Map<?, ?> map2) {
        this.map = map2;
    }

    private final Object readResolve() {
        return this.map;
    }

    public void readExternal(ObjectInput objectInput) {
        byte readByte = objectInput.readByte();
        if (readByte == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                Map c11 = MapsKt__MapsJVMKt.c(readInt);
                for (int i11 = 0; i11 < readInt; i11++) {
                    c11.put(objectInput.readObject(), objectInput.readObject());
                }
                this.map = MapsKt__MapsJVMKt.b(c11);
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte);
    }

    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeByte(0);
        objectOutput.writeInt(this.map.size());
        for (Map.Entry next : this.map.entrySet()) {
            objectOutput.writeObject(next.getKey());
            objectOutput.writeObject(next.getValue());
        }
    }

    public SerializedMap() {
        this(MapsKt__MapsKt.h());
    }
}
