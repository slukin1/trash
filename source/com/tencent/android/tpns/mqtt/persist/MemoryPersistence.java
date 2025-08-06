package com.tencent.android.tpns.mqtt.persist;

import com.tencent.android.tpns.mqtt.MqttClientPersistence;
import com.tencent.android.tpns.mqtt.MqttPersistable;
import com.tencent.android.tpns.mqtt.MqttPersistenceException;
import java.util.Enumeration;
import java.util.Hashtable;

public class MemoryPersistence implements MqttClientPersistence {
    private Hashtable data;

    public void clear() throws MqttPersistenceException {
        this.data.clear();
    }

    public void close() throws MqttPersistenceException {
        this.data.clear();
    }

    public boolean containsKey(String str) throws MqttPersistenceException {
        return this.data.containsKey(str);
    }

    public MqttPersistable get(String str) throws MqttPersistenceException {
        return (MqttPersistable) this.data.get(str);
    }

    public Enumeration keys() throws MqttPersistenceException {
        return this.data.keys();
    }

    public void open(String str, String str2) throws MqttPersistenceException {
        this.data = new Hashtable();
    }

    public void put(String str, MqttPersistable mqttPersistable) throws MqttPersistenceException {
        this.data.put(str, mqttPersistable);
    }

    public void remove(String str) throws MqttPersistenceException {
        this.data.remove(str);
    }
}
