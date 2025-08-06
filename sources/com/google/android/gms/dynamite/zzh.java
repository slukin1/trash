package com.google.android.gms.dynamite;

import android.content.Context;
import com.google.android.gms.dynamite.DynamiteModule;

final class zzh implements DynamiteModule.VersionPolicy {
    public final DynamiteModule.VersionPolicy.SelectionResult selectModule(Context context, String str, DynamiteModule.VersionPolicy.IVersions iVersions) throws DynamiteModule.LoadingException {
        DynamiteModule.VersionPolicy.SelectionResult selectionResult = new DynamiteModule.VersionPolicy.SelectionResult();
        int i11 = 0;
        int zzb = iVersions.zzb(context, str, false);
        selectionResult.remoteVersion = zzb;
        if (zzb != 0) {
            i11 = 1;
        }
        selectionResult.selection = i11;
        return selectionResult;
    }
}
