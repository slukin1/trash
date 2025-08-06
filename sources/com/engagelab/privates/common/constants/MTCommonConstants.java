package com.engagelab.privates.common.constants;

public interface MTCommonConstants {
    public static final String AURORA = "ENGAGELAB-PRIVATES-";
    public static final String UTF_8 = "UTF-8";

    public interface Encrypt {
        public static final int TYPE_AES_CBC = 1;
        public static final int TYPE_AES_ECB = 0;
        public static final int TYPE_SM4_CBC = 2;
    }

    public interface Handler {
        public static final int TYPE_DELAY = 1;
        public static final int TYPE_NORMAL = 0;
    }

    public interface Lifecycle {
        public static final String KEY_ACTIVITY = "activity";
        public static final String KEY_STATE = "state";
    }

    public interface MainWhat {
        public static final int INIT = 1000;
        public static final int ON_ACTIVITY_CREATED = 1011;
        public static final int ON_ACTIVITY_DESTROYED = 1016;
        public static final int ON_ACTIVITY_PAUSED = 1014;
        public static final int ON_ACTIVITY_RESUMED = 1013;
        public static final int ON_ACTIVITY_STARTED = 1012;
        public static final int ON_ACTIVITY_STOPPED = 1015;
        public static final int ON_LIFECYCLE_CHANGED = 1008;
        public static final int ON_NETWORK_CHANGED = 1007;
        public static final int ON_NETWORK_CONNECTED = 1003;
        public static final int ON_NETWORK_DISCONNECTED = 1004;
        public static final int ON_SERVICE_CONNECTED = 1001;
        public static final int ON_SERVICE_DISCONNECTED = 1002;
        public static final int TO_BACKGROUND = 1006;
        public static final int TO_FOREGROUND = 1005;
    }

    public interface Network {
        public static final String KEY_NAME = "name";
        public static final String KEY_RADIO = "radio";
        public static final String KEY_STATE = "state";
        public static final String KEY_TYPE = "type";
        public static final String NAME_2G = "2g";
        public static final String NAME_3G = "3g";
        public static final String NAME_4G = "4g";
        public static final String NAME_5G = "5g";
        public static final String NAME_UNKNOWN = "unknown";
        public static final String NAME_WIFI = "wifi";
        public static final String RADIO_2G = "cdma";
        public static final String RADIO_3G = "gsm";
        public static final String RADIO_4G = "lte";
        public static final String RADIO_5G = "nr";
        public static final String RADIO_UNKNOWN = "unknown";
        public static final String RADIO_WIFI = "wifi";
        public static final int TYPE_2G = 2;
        public static final int TYPE_3G = 3;
        public static final int TYPE_4G = 4;
        public static final int TYPE_5G = 5;
        public static final int TYPE_UNKNOWN = 0;
        public static final int TYPE_WIFI = 1;
    }

    public interface Observer {
        public static final String KEY_OBSERVER_NAME = "observer_name";
    }

    public interface RemoteWhat {
        public static final int ON_NETWORK_CONNECTED = 1997;
        public static final int ON_NETWORK_DISCONNECTED = 1996;
        public static final int ON_SERVICE_CONNECTED = 1999;
        public static final int ON_SERVICE_DISCONNECTED = 1998;
        public static final int TO_BACKGROUND = 1994;
        public static final int TO_FOREGROUND = 1995;
    }
}
