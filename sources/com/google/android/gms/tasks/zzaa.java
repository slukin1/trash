package com.google.android.gms.tasks;

import java.util.ArrayList;
import java.util.Collection;

final class zzaa implements Continuation {
    public final /* synthetic */ Collection zza;

    public zzaa(Collection collection) {
        this.zza = collection;
    }

    public final /* bridge */ /* synthetic */ Object then(Task task) throws Exception {
        ArrayList arrayList = new ArrayList();
        for (Task result : this.zza) {
            arrayList.add(result.getResult());
        }
        return arrayList;
    }
}
