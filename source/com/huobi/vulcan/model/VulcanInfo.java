package com.huobi.vulcan.model;

import com.huobi.kalle.simple.JsonFormat;
import org.json.JSONObject;

public class VulcanInfo implements JsonFormat {
    public static final String AID = "aid";
    public static final String ANDR_ID = "andr_id";
    public static final String APPLIST = "applist";
    public static final String APP_PATH = "app_path";
    public static final String APP_V = "app_v";
    public static final String ARP_INFO = "arp_info";
    public static final String BA_CAPACITY = "ba_capacity";
    public static final String BA_STATUS = "ba_status";
    public static final String BOARD = "board";
    public static final String BOOTLOADER = "bootloader";
    public static final String BRAND = "brand";
    public static final String BSSID = "bssid";
    public static final String B_TIME = "b_time";
    public static final String CPUINFO = "cpuinfo";
    public static final String CPU_ABI = "cpu_abi";
    public static final String CPU_V = "cpu_v";
    public static final String DENSITY = "density";
    public static final String DISKINFO = "diskinfo";
    public static final String DISPLAY = "display";
    public static final String DISPLAY_RESOLUTION = "display_resolution";
    public static final String DPI = "dpi";
    public static final String FP = "fp";
    public static final String FREE_MEMORY = "free_memory";
    public static final String HARDWARE = "hardware";
    public static final String HOST = "host";
    public static final String IMEI = "imei";
    public static final String IMSI = "imsi";
    public static final String INCREMENTAL = "incremental";
    public static final String IP = "ip";
    public static final String JAILBREAK = "jailbreak";
    public static final String LAT = "lat";
    public static final String LNG = "lng";
    public static final String MAC = "mac";
    public static final String MEMINFO = "meminfo";
    public static final String NETWORK_TYPE = "network_type";
    public static final String PARAM_HWID = "hwid";
    public static final String PARAM_RELATE_VTOKEN = "relate_vtoken";
    public static final String PARAM_RISKINFO = "riskinfo";
    public static final String PARAM_UUID = "uuidstr";
    public static final String PARAM_VTENC = "vtenc";
    public static final String PARAM_WVID = "wvid";
    public static final String PARAM_WVLEVEL = "wvlevel";
    public static final String PLATFORM_TYPE = "platform_type";
    public static final String PRODUCT_TYPE = "product_type";
    public static final String P_TYPE = "p_type";
    public static final String SDK_V = "sdk_v";
    public static final String SERIAL = "serial";
    public static final String SIM_COUNTRY = "sim_country";
    public static final String SIM_ID = "sim_id";
    public static final String SIM_OPERATOR = "sim_operator";
    public static final String SSID = "ssid";
    public static final String SYS = "sys";
    public static final String SYS_VER = "sys_ver";
    public static final String S_ACCE_VALUE = "s_acce_value";
    public static final String S_GRAD_VALUE = "s_grad_value";
    public static final String S_GRAV_VALUE = "s_grav_value";
    public static final String S_GYRO_VALUE = "s_gyro_value";
    public static final String S_LIGHT_VALUE = "s_light_value";
    public static final String S_MAGN_VALUE = "s_magn_value";
    public static final String S_ORIE_VALUE = "s_orie_value";
    public static final String S_PRESS_VALUE = "s_press_value";
    public static final String S_TEMP_VALUE = "s_temp_value";
    public static final String TIME_ZONE = "time_zone";
    public static final String TOTAL_MEMORY = "total_memory";
    public static final String UPTIME = "uptime";
    public static final String VTOKEN = "vtoken";
    public static final String V_HASH = "vHash";
    public static final String WIFI_LIST = "wifi_list";
    public static final String WM = "wm";
    public static final String XDPI = "xdpi";
    public static final String YDPI = "ydpi";
    private String aid;
    private String andr_id;
    private String app_path;
    private String app_v;
    private String applist;
    private String arp_info;
    private String b_time;
    private String ba_capacity;
    private String ba_status;
    private String board;
    private String bootloader;
    private String brand;
    private String bssid;
    private String cpu_abi;
    private String cpu_v;
    private String cpuinfo;
    private String density;
    private String diskinfo;
    private String display;
    private String display_resolution;
    private String dpi;

    /* renamed from: fp  reason: collision with root package name */
    private String f20605fp;
    private String free_memory;
    private String hardware;
    private String host;
    private String imei;
    private String imsi;
    private String incremental;

    /* renamed from: ip  reason: collision with root package name */
    private String f20606ip;
    private String jailbreak;
    private String lat;
    private String lng;
    private String mac;
    private String meminfo;
    private String network_type;
    private String p_type;
    private String s_acce_value;
    private String s_grad_value;
    private String s_grav_value;
    private String s_gyro_value;
    private String s_light_value;
    private String s_magn_value;
    private String s_orie_value;
    private String s_press_value;
    private String s_temp_value;
    private String sdk_v;
    private String serial;
    private String sim_country;
    private String sim_id;
    private String sim_operator;
    private String ssid;
    private String sys;
    private String sys_ver;
    private String time_zone;
    private String total_memory;
    private String uptime;
    private String vtoken;
    private String wifi_list;
    private String xdpi;
    private String ydpi;

    public void fromJson(JSONObject jSONObject) {
    }

    public String getAid() {
        return this.aid;
    }

    public String getAndr_id() {
        return this.andr_id;
    }

    public String getApp_path() {
        return this.app_path;
    }

    public String getApp_v() {
        return this.app_v;
    }

    public String getApplist() {
        return this.applist;
    }

    public String getArp_info() {
        return this.arp_info;
    }

    public String getB_time() {
        return this.b_time;
    }

    public String getBa_capacity() {
        return this.ba_capacity;
    }

    public String getBa_status() {
        return this.ba_status;
    }

    public String getBoard() {
        return this.board;
    }

    public String getBootloader() {
        return this.bootloader;
    }

    public String getBrand() {
        return this.brand;
    }

    public String getBssid() {
        return this.bssid;
    }

    public String getCpu_abi() {
        return this.cpu_abi;
    }

    public String getCpu_v() {
        return this.cpu_v;
    }

    public String getCpuinfo() {
        return this.cpuinfo;
    }

    public String getDensity() {
        return this.density;
    }

    public String getDiskinfo() {
        return this.diskinfo;
    }

    public String getDisplay() {
        return this.display;
    }

    public String getDisplay_resolution() {
        return this.display_resolution;
    }

    public String getDpi() {
        return this.dpi;
    }

    public String getFp() {
        return this.f20605fp;
    }

    public String getFree_memory() {
        return this.free_memory;
    }

    public String getHardware() {
        return this.hardware;
    }

    public String getHost() {
        return this.host;
    }

    public String getImei() {
        return this.imei;
    }

    public String getImsi() {
        return this.imsi;
    }

    public String getIncremental() {
        return this.incremental;
    }

    public String getIp() {
        return this.f20606ip;
    }

    public String getJailbreak() {
        return this.jailbreak;
    }

    public String getLat() {
        return this.lat;
    }

    public String getLng() {
        return this.lng;
    }

    public String getMac() {
        return this.mac;
    }

    public String getMeminfo() {
        return this.meminfo;
    }

    public String getNetwork_type() {
        return this.network_type;
    }

    public String getP_type() {
        return this.p_type;
    }

    public String getS_acce_value() {
        return this.s_acce_value;
    }

    public String getS_grad_value() {
        return this.s_grad_value;
    }

    public String getS_grav_value() {
        return this.s_grav_value;
    }

    public String getS_gyro_value() {
        return this.s_gyro_value;
    }

    public String getS_light_value() {
        return this.s_light_value;
    }

    public String getS_magn_value() {
        return this.s_magn_value;
    }

    public String getS_orie_value() {
        return this.s_orie_value;
    }

    public String getS_press_value() {
        return this.s_press_value;
    }

    public String getS_temp_value() {
        return this.s_temp_value;
    }

    public String getSdk_v() {
        return this.sdk_v;
    }

    public String getSerial() {
        return this.serial;
    }

    public String getSim_country() {
        return this.sim_country;
    }

    public String getSim_id() {
        return this.sim_id;
    }

    public String getSim_operator() {
        return this.sim_operator;
    }

    public String getSsid() {
        return this.ssid;
    }

    public String getSys() {
        return this.sys;
    }

    public String getSyst_ver() {
        return this.sys_ver;
    }

    public String getTime_zone() {
        return this.time_zone;
    }

    public String getTotal_memory() {
        return this.total_memory;
    }

    public String getUptime() {
        return this.uptime;
    }

    public String getVtoken() {
        return this.vtoken;
    }

    public String getWifi_list() {
        return this.wifi_list;
    }

    public String getXdpi() {
        return this.xdpi;
    }

    public String getYdpi() {
        return this.ydpi;
    }

    public void setAid(String str) {
        this.aid = str;
    }

    public void setAndr_id(String str) {
        this.andr_id = str;
    }

    public void setApp_path(String str) {
        this.app_path = str;
    }

    public void setApp_v(String str) {
        this.app_v = str;
    }

    public void setApplist(String str) {
        this.applist = str;
    }

    public void setArp_info(String str) {
        this.arp_info = str;
    }

    public void setB_time(String str) {
        this.b_time = str;
    }

    public void setBa_capacity(String str) {
        this.ba_capacity = str;
    }

    public void setBa_status(String str) {
        this.ba_status = str;
    }

    public void setBoard(String str) {
        this.board = str;
    }

    public void setBootloader(String str) {
        this.bootloader = str;
    }

    public void setBrand(String str) {
        this.brand = str;
    }

    public void setBssid(String str) {
        this.bssid = str;
    }

    public void setCpu_abi(String str) {
        this.cpu_abi = str;
    }

    public void setCpu_v(String str) {
        this.cpu_v = str;
    }

    public void setCpuinfo(String str) {
        this.cpuinfo = str;
    }

    public void setDensity(String str) {
        this.density = str;
    }

    public void setDiskinfo(String str) {
        this.diskinfo = str;
    }

    public void setDisplay(String str) {
        this.display = str;
    }

    public void setDisplay_resolution(String str) {
        this.display_resolution = str;
    }

    public void setDpi(String str) {
        this.dpi = str;
    }

    public void setFp(String str) {
        this.f20605fp = str;
    }

    public void setFree_memory(String str) {
        this.free_memory = str;
    }

    public void setHardware(String str) {
        this.hardware = str;
    }

    public void setHost(String str) {
        this.host = str;
    }

    public void setImei(String str) {
        this.imei = str;
    }

    public void setImsi(String str) {
        this.imsi = str;
    }

    public void setIncremental(String str) {
        this.incremental = str;
    }

    public void setIp(String str) {
        this.f20606ip = str;
    }

    public void setJailbreak(String str) {
        this.jailbreak = str;
    }

    public void setLat(String str) {
        this.lat = str;
    }

    public void setLng(String str) {
        this.lng = str;
    }

    public void setMac(String str) {
        this.mac = str;
    }

    public void setMeminfo(String str) {
        this.meminfo = str;
    }

    public void setNetwork_type(String str) {
        this.network_type = str;
    }

    public void setP_type(String str) {
        this.p_type = str;
    }

    public void setS_acce_value(String str) {
        this.s_acce_value = str;
    }

    public void setS_grad_value(String str) {
        this.s_grad_value = str;
    }

    public void setS_grav_value(String str) {
        this.s_grav_value = str;
    }

    public void setS_gyro_value(String str) {
        this.s_gyro_value = str;
    }

    public void setS_light_value(String str) {
        this.s_light_value = str;
    }

    public void setS_magn_value(String str) {
        this.s_magn_value = str;
    }

    public void setS_orie_value(String str) {
        this.s_orie_value = str;
    }

    public void setS_press_value(String str) {
        this.s_press_value = str;
    }

    public void setS_temp_value(String str) {
        this.s_temp_value = str;
    }

    public void setSdk_v(String str) {
        this.sdk_v = str;
    }

    public void setSerial(String str) {
        this.serial = str;
    }

    public void setSim_country(String str) {
        this.sim_country = str;
    }

    public void setSim_id(String str) {
        this.sim_id = str;
    }

    public void setSim_operator(String str) {
        this.sim_operator = str;
    }

    public void setSsid(String str) {
        this.ssid = str;
    }

    public void setSys(String str) {
        this.sys = str;
    }

    public void setSys_ver(String str) {
        this.sys_ver = str;
    }

    public void setTime_zone(String str) {
        this.time_zone = str;
    }

    public void setTotal_memory(String str) {
        this.total_memory = str;
    }

    public void setUptime(String str) {
        this.uptime = str;
    }

    public void setVtoken(String str) {
        this.vtoken = str;
    }

    public void setWifi_list(String str) {
        this.wifi_list = str;
    }

    public void setXdpi(String str) {
        this.xdpi = str;
    }

    public void setYdpi(String str) {
        this.ydpi = str;
    }

    public JSONObject toJson() {
        return null;
    }

    public String toString() {
        return "VulcanInfo: {\nsys: \"" + this.sys + "\",\nsys_ver: \"" + this.sys_ver + "\",\nbrand: \"" + this.brand + "\",\np_type: \"" + this.p_type + "\",\nserial: \"" + this.serial + "\",\napp_v: \"" + this.app_v + "\",\nsdk_v: \"" + this.sdk_v + "\",\nvtoken: \"" + this.vtoken + "\",\nnetwork_type: \"" + this.network_type + "\",\ndisplay_resolution: \"" + this.display_resolution + "\",\njailbreak: \"" + this.jailbreak + "\",\nimei: \"" + this.imei + "\",\nmac: \"" + this.mac + "\",\nandr_id: \"" + this.andr_id + "\",\nsim_id: \"" + this.sim_id + "\",\nimsi: \"" + this.imsi + "\",\nsim_country: \"" + this.sim_country + "\",\nsim_operator: \"" + this.sim_operator + "\",\nssid: \"" + this.ssid + "\",\nbssid: \"" + this.bssid + "\",\nip: \"" + this.f20606ip + "\",\nboard: \"" + this.board + "\",\nbootloader: \"" + this.bootloader + "\",\ncpu_abi: \"" + this.cpu_abi + "\",\nba_status: \"" + this.ba_status + "\",\nba_capacity: \"" + this.ba_capacity + "\",\ndensity: \"" + this.density + "\",\ndpi: \"" + this.dpi + "\",\nxdpi: \"" + this.xdpi + "\",\nydpi: \"" + this.ydpi + "\",\ntotal_memory: \"" + this.total_memory + "\",\nfree_memory: \"" + this.free_memory + "\",\ncpu_v: \"" + this.cpu_v + "\",\ndisplay: \"" + this.display + "\",\nfp: \"" + this.f20605fp + "\",\nhost: \"" + this.host + "\",\nhardware: \"" + this.hardware + "\",\nb_time: \"" + this.b_time + "\",\nincremental: \"" + this.incremental + "\",\naid: \"" + this.aid + "\",\napplist: \"" + this.applist + "\",\ncpuinfo: \"" + this.cpuinfo + "\",\nmeminfo: \"" + this.meminfo + "\",\ndiskinfo: \"" + this.diskinfo + "\",\nuptime: \"" + this.uptime + "\",\nwifi_list: \"" + this.wifi_list + "\",\narp_info: \"" + this.arp_info + "\",\napp_path: \"" + this.app_path + "\",\ntime_zone: \"" + this.time_zone + "\",\ns_acce_value: \"" + this.s_acce_value + "\",\ns_gyro_value: \"" + this.s_gyro_value + "\",\ns_grad_value: \"" + this.s_grad_value + "\",\ns_magn_value: \"" + this.s_magn_value + "\",\ns_orie_value: \"" + this.s_orie_value + "\",\ns_light_value: \"" + this.s_light_value + "\",\ns_press_value: \"" + this.s_press_value + "\",\ns_temp_value: \"" + this.s_temp_value + "\",\ns_grav_value: \"" + this.s_grav_value + "\",\nlat: \"" + this.lat + "\",\nlng: \"" + this.lng + "\",\n" + '}';
    }
}
