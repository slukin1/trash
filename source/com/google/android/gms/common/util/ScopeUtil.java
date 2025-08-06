package com.google.android.gms.common.util;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.Preconditions;
import java.util.Set;

@KeepForSdk
public final class ScopeUtil {
    private ScopeUtil() {
    }

    @KeepForSdk
    public static String[] toScopeString(Set<Scope> set) {
        Preconditions.checkNotNull(set, "scopes can't be null.");
        Scope[] scopeArr = (Scope[]) set.toArray(new Scope[set.size()]);
        Preconditions.checkNotNull(scopeArr, "scopes can't be null.");
        String[] strArr = new String[scopeArr.length];
        for (int i11 = 0; i11 < scopeArr.length; i11++) {
            strArr[i11] = scopeArr[i11].getScopeUri();
        }
        return strArr;
    }
}
