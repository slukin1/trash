package kotlin.collections.builders;

import java.io.Externalizable;
import java.io.InvalidObjectException;
import java.io.ObjectInput;
import java.io.ObjectOutput;
import java.util.Collection;
import java.util.List;
import java.util.Set;
import kotlin.jvm.internal.r;

public final class SerializedCollection implements Externalizable {
    public static final a Companion = new a((r) null);
    private static final long serialVersionUID = 0;
    public static final int tagList = 0;
    public static final int tagSet = 1;
    private Collection<?> collection;
    private final int tag;

    public static final class a {
        public a() {
        }

        public /* synthetic */ a(r rVar) {
            this();
        }
    }

    public SerializedCollection(Collection<?> collection2, int i11) {
        this.collection = collection2;
        this.tag = i11;
    }

    private final Object readResolve() {
        return this.collection;
    }

    public void readExternal(ObjectInput objectInput) {
        Collection<?> collection2;
        byte readByte = objectInput.readByte();
        byte b11 = readByte & 1;
        if ((readByte & -2) == 0) {
            int readInt = objectInput.readInt();
            if (readInt >= 0) {
                int i11 = 0;
                if (b11 == 0) {
                    List d11 = CollectionsKt__CollectionsJVMKt.d(readInt);
                    while (i11 < readInt) {
                        d11.add(objectInput.readObject());
                        i11++;
                    }
                    collection2 = CollectionsKt__CollectionsJVMKt.a(d11);
                } else if (b11 == 1) {
                    Set b12 = SetsKt__SetsJVMKt.b(readInt);
                    while (i11 < readInt) {
                        b12.add(objectInput.readObject());
                        i11++;
                    }
                    collection2 = SetsKt__SetsJVMKt.a(b12);
                } else {
                    throw new InvalidObjectException("Unsupported collection type tag: " + b11 + '.');
                }
                this.collection = collection2;
                return;
            }
            throw new InvalidObjectException("Illegal size value: " + readInt + '.');
        }
        throw new InvalidObjectException("Unsupported flags value: " + readByte + '.');
    }

    public void writeExternal(ObjectOutput objectOutput) {
        objectOutput.writeByte(this.tag);
        objectOutput.writeInt(this.collection.size());
        for (Object writeObject : this.collection) {
            objectOutput.writeObject(writeObject);
        }
    }

    public SerializedCollection() {
        this(CollectionsKt__CollectionsKt.k(), 0);
    }
}
