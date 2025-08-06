package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzj implements DynamiteModule.VersionPolicy {
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        int i11;
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int zza = iVersions.zza(context, str);
        selectionResult.localVersion = zza;
        int i12 = 1;
        int i13 = 0;
        if (zza != 0) {
            i11 = iVersions.zzb(context, str, false);
            selectionResult.remoteVersion = i11;
        } else {
            i11 = iVersions.zzb(context, str, true);
            selectionResult.remoteVersion = i11;
        }
        int i14 = selectionResult.localVersion;
        if (i14 != 0) {
            i13 = i14;
        } else if (i11 == 0) {
            i12 = 0;
            selectionResult.selection = i12;
            return selectionResult;
        }
        if (i13 >= i11) {
            i12 = -1;
        }
        selectionResult.selection = i12;
        return selectionResult;
    }
}
