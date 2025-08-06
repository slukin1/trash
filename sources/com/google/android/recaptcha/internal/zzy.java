package com.google.android.recaptcha.internal;

import android.content.Context;
import d10.l;
import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.collections.CharIterator;
import kotlin.jvm.internal.x;
import kotlin.ranges.c;

public final class zzy implements zzh {
    private final Context zza;
    private final String zzb = "rce_";
    private final zzad zzc;

    public zzy(Context context) {
        this.zza = context;
        this.zzc = new zzad(context);
    }

    public final String zza(String str) {
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str)));
        if (file.exists()) {
            return new String(zzad.zza(file), StandardCharsets.UTF_8);
        }
        return null;
    }

    public final void zzb() {
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            if (listFiles != null) {
                ArrayList<File> arrayList = new ArrayList<>();
                for (File file : listFiles) {
                    if (StringsKt__StringsJVMKt.M(file.getName(), this.zzb, false, 2, (Object) null)) {
                        arrayList.add(file);
                    }
                }
                for (File delete : arrayList) {
                    delete.delete();
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void zzc(String str, String str2) {
        c cVar = new c('A', 'z');
        ArrayList arrayList = new ArrayList(CollectionsKt__IterablesKt.u(cVar, 10));
        Iterator it2 = cVar.iterator();
        while (it2.hasNext()) {
            arrayList.add(Character.valueOf(((CharIterator) it2).a()));
        }
        String k02 = CollectionsKt___CollectionsKt.k0(CollectionsKt__CollectionsJVMKt.f(arrayList).subList(0, 8), "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (l) null, 62, (Object) null);
        File file = new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(k02)));
        zzad.zzb(file, String.valueOf(str2).getBytes(StandardCharsets.UTF_8));
        file.renameTo(new File(this.zza.getCacheDir(), this.zzb.concat(String.valueOf(str))));
    }

    public final boolean zzd(String str) {
        try {
            File[] listFiles = this.zza.getCacheDir().listFiles();
            File file = null;
            if (listFiles != null) {
                int length = listFiles.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        break;
                    }
                    File file2 = listFiles[i11];
                    if (x.b(file2.getName(), this.zzb + str)) {
                        file = file2;
                        break;
                    }
                    i11++;
                }
            }
            return file != null;
        } catch (Exception unused) {
            return false;
        }
    }
}
