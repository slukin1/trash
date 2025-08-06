package com.google.android.gms.common.internal;

import android.content.Context;
import android.os.IBinder;
import android.os.IInterface;
import android.view.View;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.dynamic.RemoteCreator;

public final class zaz extends RemoteCreator<zam> {
    private static final zaz zaa = new zaz();

    private zaz() {
        super("com.google.android.gms.common.ui.SignInButtonCreatorImpl");
    }

    public static View zaa(Context context, int i11, int i12) throws RemoteCreator.RemoteCreatorException {
        zaz zaz = zaa;
        try {
            zax zax = new zax(1, i11, i12, (Scope[]) null);
            return (View) ObjectWrapper.unwrap(((zam) zaz.getRemoteCreatorInstance(context)).zae(ObjectWrapper.wrap(context), zax));
        } catch (Exception e11) {
            StringBuilder sb2 = new StringBuilder(64);
            sb2.append("Could not get button with size ");
            sb2.append(i11);
            sb2.append(" and color ");
            sb2.append(i12);
            throw new RemoteCreator.RemoteCreatorException(sb2.toString(), e11);
        }
    }

    public final /* synthetic */ Object getRemoteCreator(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.common.internal.ISignInButtonCreator");
        return queryLocalInterface instanceof zam ? (zam) queryLocalInterface : new zam(iBinder);
    }
}
