package com.google.firebase.components;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.os.Bundle;
import android.util.Log;
import com.google.firebase.inject.Provider;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public final class ComponentDiscovery<T> {
    private static final String COMPONENT_KEY_PREFIX = "com.google.firebase.components:";
    private static final String COMPONENT_SENTINEL_VALUE = "com.google.firebase.components.ComponentRegistrar";
    public static final String TAG = "ComponentDiscovery";
    private final T context;
    private final RegistrarNameRetriever<T> retriever;

    public static class MetadataRegistrarNameRetriever implements RegistrarNameRetriever<Context> {
        private final Class<? extends Service> discoveryService;

        private Bundle getMetadata(Context context) {
            try {
                PackageManager packageManager = context.getPackageManager();
                if (packageManager == null) {
                    Log.w(ComponentDiscovery.TAG, "Context has no PackageManager.");
                    return null;
                }
                ServiceInfo serviceInfo = packageManager.getServiceInfo(new ComponentName(context, this.discoveryService), 128);
                if (serviceInfo != null) {
                    return serviceInfo.metaData;
                }
                Log.w(ComponentDiscovery.TAG, this.discoveryService + " has no service info.");
                return null;
            } catch (PackageManager.NameNotFoundException unused) {
                Log.w(ComponentDiscovery.TAG, "Application info not found.");
                return null;
            }
        }

        private MetadataRegistrarNameRetriever(Class<? extends Service> cls) {
            this.discoveryService = cls;
        }

        public List<String> retrieve(Context context) {
            Bundle metadata = getMetadata(context);
            if (metadata == null) {
                Log.w(ComponentDiscovery.TAG, "Could not retrieve metadata, returning empty list of registrars.");
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (String str : metadata.keySet()) {
                if (ComponentDiscovery.COMPONENT_SENTINEL_VALUE.equals(metadata.get(str)) && str.startsWith(ComponentDiscovery.COMPONENT_KEY_PREFIX)) {
                    arrayList.add(str.substring(31));
                }
            }
            return arrayList;
        }
    }

    public interface RegistrarNameRetriever<T> {
        List<String> retrieve(T t11);
    }

    public ComponentDiscovery(T t11, RegistrarNameRetriever<T> registrarNameRetriever) {
        this.context = t11;
        this.retriever = registrarNameRetriever;
    }

    public static ComponentDiscovery<Context> forContext(Context context2, Class<? extends Service> cls) {
        return new ComponentDiscovery<>(context2, new MetadataRegistrarNameRetriever(cls));
    }

    /* access modifiers changed from: private */
    public static ComponentRegistrar instantiate(String str) {
        try {
            Class<?> cls = Class.forName(str);
            if (ComponentRegistrar.class.isAssignableFrom(cls)) {
                return (ComponentRegistrar) cls.getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
            }
            throw new InvalidRegistrarException(String.format("Class %s is not an instance of %s", new Object[]{str, COMPONENT_SENTINEL_VALUE}));
        } catch (ClassNotFoundException unused) {
            Log.w(TAG, String.format("Class %s is not an found.", new Object[]{str}));
            return null;
        } catch (IllegalAccessException e11) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e11);
        } catch (InstantiationException e12) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s.", new Object[]{str}), e12);
        } catch (NoSuchMethodException e13) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e13);
        } catch (InvocationTargetException e14) {
            throw new InvalidRegistrarException(String.format("Could not instantiate %s", new Object[]{str}), e14);
        }
    }

    @Deprecated
    public List<ComponentRegistrar> discover() {
        ArrayList arrayList = new ArrayList();
        for (String instantiate : this.retriever.retrieve(this.context)) {
            try {
                ComponentRegistrar instantiate2 = instantiate(instantiate);
                if (instantiate2 != null) {
                    arrayList.add(instantiate2);
                }
            } catch (InvalidRegistrarException e11) {
                Log.w(TAG, "Invalid component registrar.", e11);
            }
        }
        return arrayList;
    }

    public List<Provider<ComponentRegistrar>> discoverLazy() {
        ArrayList arrayList = new ArrayList();
        for (String gVar : this.retriever.retrieve(this.context)) {
            arrayList.add(new g(gVar));
        }
        return arrayList;
    }
}
