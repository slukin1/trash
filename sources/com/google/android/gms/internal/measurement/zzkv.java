package com.google.android.gms.internal.measurement;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ServiceConfigurationError;
import java.util.ServiceLoader;
import java.util.logging.Level;
import java.util.logging.Logger;

abstract class zzkv {
    private static final Logger zza = Logger.getLogger(zzki.class.getName());
    private static final String zzb = "com.google.protobuf.BlazeGeneratedExtensionRegistryLiteLoader";

    public static zzkn zzb(Class cls) {
        String str;
        Class<zzkv> cls2 = zzkv.class;
        ClassLoader classLoader = cls2.getClassLoader();
        if (cls.equals(zzkn.class)) {
            str = zzb;
        } else if (cls.getPackage().equals(cls2.getPackage())) {
            str = String.format("%s.BlazeGenerated%sLoader", new Object[]{cls.getPackage().getName(), cls.getSimpleName()});
        } else {
            throw new IllegalArgumentException(cls.getName());
        }
        try {
            return (zzkn) cls.cast(((zzkv) Class.forName(str, true, classLoader).getConstructor(new Class[0]).newInstance(new Object[0])).zza());
        } catch (NoSuchMethodException e11) {
            throw new IllegalStateException(e11);
        } catch (InstantiationException e12) {
            throw new IllegalStateException(e12);
        } catch (IllegalAccessException e13) {
            throw new IllegalStateException(e13);
        } catch (InvocationTargetException e14) {
            throw new IllegalStateException(e14);
        } catch (ClassNotFoundException unused) {
            Iterator<S> it2 = ServiceLoader.load(cls2, classLoader).iterator();
            ArrayList arrayList = new ArrayList();
            while (it2.hasNext()) {
                try {
                    arrayList.add((zzkn) cls.cast(((zzkv) it2.next()).zza()));
                } catch (ServiceConfigurationError e15) {
                    zza.logp(Level.SEVERE, "com.google.protobuf.GeneratedExtensionRegistryLoader", "load", "Unable to load ".concat(cls.getSimpleName()), e15);
                }
            }
            if (arrayList.size() == 1) {
                return (zzkn) arrayList.get(0);
            }
            if (arrayList.size() == 0) {
                return null;
            }
            try {
                return (zzkn) cls.getMethod("combine", new Class[]{Collection.class}).invoke((Object) null, new Object[]{arrayList});
            } catch (NoSuchMethodException e16) {
                throw new IllegalStateException(e16);
            } catch (IllegalAccessException e17) {
                throw new IllegalStateException(e17);
            } catch (InvocationTargetException e18) {
                throw new IllegalStateException(e18);
            }
        }
    }

    public abstract zzkn zza();
}
