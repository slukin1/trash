package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzjj;
import com.google.android.gms.internal.measurement.zzjk;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public abstract class zzjk<MessageType extends zzjk<MessageType, BuilderType>, BuilderType extends zzjj<MessageType, BuilderType>> implements zzmi {
    public int zzb = 0;

    public static void zzbw(Iterable iterable, List list) {
        byte[] bArr = zzlj.zzd;
        Objects.requireNonNull(iterable);
        if (iterable instanceof zzlq) {
            List zzh = ((zzlq) iterable).zzh();
            zzlq zzlq = (zzlq) list;
            int size = list.size();
            for (Object next : zzh) {
                if (next == null) {
                    String str = "Element at index " + (zzlq.size() - size) + " is null.";
                    int size2 = zzlq.size();
                    while (true) {
                        size2--;
                        if (size2 >= size) {
                            zzlq.remove(size2);
                        } else {
                            throw new NullPointerException(str);
                        }
                    }
                } else if (next instanceof zzka) {
                    zzlq.zzi((zzka) next);
                } else {
                    zzlq.add((String) next);
                }
            }
        } else if (!(iterable instanceof zzmp)) {
            if ((list instanceof ArrayList) && (iterable instanceof Collection)) {
                ((ArrayList) list).ensureCapacity(list.size() + ((Collection) iterable).size());
            }
            int size3 = list.size();
            for (Object next2 : iterable) {
                if (next2 == null) {
                    String str2 = "Element at index " + (list.size() - size3) + " is null.";
                    int size4 = list.size();
                    while (true) {
                        size4--;
                        if (size4 >= size3) {
                            list.remove(size4);
                        } else {
                            throw new NullPointerException(str2);
                        }
                    }
                } else {
                    list.add(next2);
                }
            }
        } else {
            list.addAll((Collection) iterable);
        }
    }

    public int zzbu(zzmt zzmt) {
        throw null;
    }

    public final zzka zzbv() {
        try {
            int zzbz = zzbz();
            zzka zzka = zzka.zzb;
            byte[] bArr = new byte[zzbz];
            zzki zzz = zzki.zzz(bArr, 0, zzbz);
            zzbQ(zzz);
            zzz.zzA();
            return new zzjx(bArr);
        } catch (IOException e11) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a ByteString threw an IOException (should never happen).", e11);
        }
    }

    public final byte[] zzbx() {
        try {
            int zzbz = zzbz();
            byte[] bArr = new byte[zzbz];
            zzki zzz = zzki.zzz(bArr, 0, zzbz);
            zzbQ(zzz);
            zzz.zzA();
            return bArr;
        } catch (IOException e11) {
            String name = getClass().getName();
            throw new RuntimeException("Serializing " + name + " to a byte array threw an IOException (should never happen).", e11);
        }
    }
}
