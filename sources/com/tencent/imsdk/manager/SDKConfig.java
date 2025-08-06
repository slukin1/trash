package com.tencent.imsdk.manager;

import com.tencent.imsdk.common.SystemUtil;

public class SDKConfig {
    public DatabaseEncryptInfo databaseEncryptInfo = new DatabaseEncryptInfo();
    public DeviceInfo deviceInfo = new DeviceInfo();
    public boolean forceUseQuicChannel = false;
    public boolean isIPv6Prior = false;
    public boolean isTestEnvironment = false;
    public LogSetting logSetting = new LogSetting();
    public NetworkInfo networkInfo = new NetworkInfo();
    public int numberUIPlatform = 0;
    public PacketRetryInfo packetRetryInfo = new PacketRetryInfo();
    public ProxyInfo proxyInfo = new ProxyInfo();
    public long sdkAppId = 0;
    public String sdkInitPath = "";
    public long sdkInstanceType = 0;
    public String stringUIPlatform = "";

    public static class DatabaseEncryptInfo {
        public String encryptKey = "";
        public int encryptType = 0;

        public void clean() {
            this.encryptType = 0;
            this.encryptKey = "";
        }
    }

    public static class DeviceInfo {
        public long deviceBrand = 0;
        public String deviceId = "";
        public String deviceType = "";
        public String systemVersion = "";

        public static float onGetAppCpuUsage() {
            return 0.0f;
        }

        public static int onGetAppMemUsage() {
            return 0;
        }

        public static float onGetSysCpuUsage() {
            return 0.0f;
        }
    }

    public static class LogSetting {
        public boolean enableConsoleLog = true;
        public String logFilePath = "";
        public int logLevel = 0;
    }

    public static class NetworkInfo {
        public long initializeCostTime = 0;
        public int ipType = 1;
        public boolean networkConnected = false;
        public String networkId = "";
        public int networkType = 0;
        public long wifiNetworkHandle = 0;
        public long xgNetworkHandle = 0;

        public void clean() {
            this.networkType = 0;
            this.ipType = 1;
            this.networkId = "";
            this.wifiNetworkHandle = 0;
            this.xgNetworkHandle = 0;
            this.initializeCostTime = 0;
            this.networkConnected = false;
        }
    }

    public static class PacketRetryInfo {
        public int maxRetryCount = 0;
        public int packetRequestTimeout = 0;

        public void clean() {
            this.maxRetryCount = 0;
            this.maxRetryCount = 0;
        }
    }

    public static class ProxyInfo {
        public String proxyHost = "";
        public String proxyPassword = "";
        public int proxyPort = 0;
        public int proxyType = 0;
        public String proxyUsername = "";

        public void clean() {
            this.proxyType = 0;
            this.proxyHost = "";
            this.proxyPort = 0;
            this.proxyUsername = "";
            this.proxyPassword = "";
        }
    }

    public static float getAppCpuUsage() {
        return SystemUtil.getAppCpuUsage();
    }

    public static float getAppMemoryUsage() {
        return SystemUtil.getAppMemory();
    }

    public static float getSysCpuUsage() {
        return SystemUtil.getSysCpuUsage();
    }
}
