package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzk implements DynamiteModule.VersionPolicy {
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        selectionResult.localVersion = iVersions.zza(context, str);
        int i11 = 1;
        int zzb = iVersions.zzb(context, str, true);
        selectionResult.remoteVersion = zzb;
        int i12 = selectionResult.localVersion;
        if (i12 == 0) {
            if (zzb == 0) {
                i11 = 0;
                selectionResult.selection = i11;
                return selectionResult;
            }
            i12 = 0;
        }
        if (zzb < i12) {
            i11 = -1;
        }
        selectionResult.selection = i11;
        return selectionResult;
    }
}
