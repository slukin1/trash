package com.sensorsdata.analytics.android.sdk.data.persistent;

import android.annotation.SuppressLint;
import com.sensorsdata.analytics.android.sdk.SALog;
import com.sensorsdata.analytics.android.sdk.plugin.encrypt.SAStoreManager;

@SuppressLint({"CommitPrefEdits"})
public abstract class PersistentIdentity<T> {
    private static final String TAG = "SA.PersistentIdentity";
    private T item;
    private final String persistentKey;
    private final SAStoreManager saStoreManager = SAStoreManager.getInstance();
    private final PersistentSerializer serializer;

    public interface PersistentSerializer<T> {
        T create();

        T load(String str);

        String save(T t11);
    }

    public PersistentIdentity(String str, PersistentSerializer<T> persistentSerializer) {
        this.serializer = persistentSerializer;
        this.persistentKey = str;
    }

    public void commit(T t11) {
        if (!AbstractSensorsDataAPI.getConfigOptions().isDisableSDK()) {
            this.item = t11;
            synchronized (this.saStoreManager) {
                if (this.item == null) {
                    this.item = this.serializer.create();
                }
                this.saStoreManager.setString(this.persistentKey, this.serializer.save(this.item));
            }
        }
    }

    public T get() {
        if (this.item == null) {
            synchronized (this.saStoreManager) {
                String string = this.saStoreManager.getString(this.persistentKey, (String) null);
                if (string == null) {
                    T create = this.serializer.create();
                    this.item = create;
                    commit(create);
                } else {
                    this.item = this.serializer.load(string);
                }
            }
        }
        return this.item;
    }

    public boolean isExists() {
        try {
            return this.saStoreManager.isExists(this.persistentKey);
        } catch (Exception e11) {
            SALog.printStackTrace(e11);
            return false;
        }
    }

    public void remove() {
        synchronized (this.saStoreManager) {
            this.saStoreManager.remove(this.persistentKey);
        }
    }
}
