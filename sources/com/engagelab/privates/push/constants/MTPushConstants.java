package com.engagelab.privates.push.constants;

public interface MTPushConstants {

    public interface Analysis {
        public static final String KEY_JSON = "json";
    }

    public interface Geofence {
        public static final String KEY_COUNT = "count";
        public static final String KEY_ID = "id";
        public static final String KEY_INTERVAL = "interval";
        public static final String KEY_LATITUDE = "latitude";
        public static final String KEY_LONGITUDE = "longitude";
    }

    public interface MainWhat {
        public static final int ALIAS_CLEAR = 3019;
        public static final int ALIAS_GET = 3018;
        public static final int ALIAS_SET = 3017;
        public static final int CLEAR_PLATFORM_NOTIFICATION = 3104;
        public static final int COLLECT_START_CRASH = 3301;
        public static final int COLLECT_STOP_CRASH = 3302;
        public static final int INIT_PLATFORM = 3101;
        public static final int ON_CUSTOM_ARRIVED = 3001;
        public static final int ON_MOBILE_NUMBER = 3023;
        public static final int ON_NOTIFICATION_ARRIVED = 3002;
        public static final int ON_NOTIFICATION_CLICKED = 3003;
        public static final int ON_NOTIFICATION_DELETED = 3004;
        public static final int ON_NOTIFICATION_OPENED = 3005;
        public static final int ON_NOTIFICATION_STATE = 3006;
        public static final int ON_PLATFORM_NODE = 3022;
        public static final int ON_PLATFORM_TOKEN = 3021;
        public static final int REPORT_MESSAGE_STATE = 3201;
        public static final int REPORT_PLATFORM_MESSAGE_STATE = 3202;
        public static final int TAG_ADD = 3011;
        public static final int TAG_DELETE = 3012;
        public static final int TAG_DELETE_ALL = 3015;
        public static final int TAG_QUERY = 3014;
        public static final int TAG_QUERY_ALL = 3016;
        public static final int TAG_UPDATE = 3013;
        public static final int TURN_OFF_PLATFORM_PUSH = 3103;
        public static final int TURN_ON_PLATFORM_PUSH = 3102;
    }

    public interface Manufacturer {
        public static final String BLACKSHARK = "blackshark";
        public static final String HONOR = "honor";
        public static final String HUAWEI = "huawei";
        public static final String MEIZU = "meizu";
        public static final String ONEPLUS = "oneplus";
        public static final String OPPO = "oppo";
        public static final String REALME = "realme";
        public static final String VIVO = "vivo";
        public static final String XIAOMI = "xiaomi";
    }

    public interface Message {
        public static final int CODE_MESSAGE_ARRIVED = 1018;
        public static final int CODE_MESSAGE_CLICKED = 1000;
        public static final int CODE_MESSAGE_DELETED = 1038;
        public static final int CODE_MESSAGE_OPENED = 1028;
        public static final int CODE_MESSAGE_REVOKE = 1068;
        public static final int CODE_REVOKE_PLATFORM_MESSAGE = 1069;
        public static final String KEY_MESSAGE = "message";
        public static final String KEY_MESSAGE_LIMIT = "message_limit";
        public static final String KEY_NOTIFICATION_ID = "notification_id";
        public static final String TYPE_MESSAGE_STATE = "msg_status";
        public static final String TYPE_PLATFORM_MESSAGE_STATE = "third_msg_status";
    }

    public interface Notification {
        public static final String KEY_NOTIFY_ID = "notify_id";
    }

    public interface NotificationBadge {
        public static final String KEY_BADGE = "notification_badge";
    }

    public interface NotificationCount {
        public static final int DEFAULT_COUNT = 5;
        public static final String KEY_COUNT = "notification_count";
    }

    public interface NotificationLayout {
        public static final String KEY_CONTENT_VIEW_ID = "content_view_id";
        public static final String KEY_ICON_RESOURCE_ID = "icon_resource_id";
        public static final String KEY_ICON_VIEW_ID = "icon_view_id";
        public static final String KEY_ID = "id";
        public static final String KEY_LAYOUT_ID = "layout_id";
        public static final String KEY_NOTIFICATION_LAYOUT = "notification_layout";
        public static final String KEY_TIME_VIEW_ID = "time_view_id";
        public static final String KEY_TITLE_VIEW_ID = "title_view_id";
    }

    public interface NotificationState {
        public static final String KEY_STATE = "notification_state";
        public static final int SCENE_ON_CONNECT = 2;
        public static final int SCENE_ON_FOREGROUND = 1;
        public static final int SCENE_ON_HEARTBEAT = 0;
        public static final int SCENE_ON_NOTIFICATION = 3;
    }

    public interface NotificationTime {
        public static final String KEY_BEGIN_HOUR = "begin_hour";
        public static final String KEY_BEGIN_MINUTE = "begin_minute";
        public static final String KEY_DAYS = "day";
        public static final String KEY_END_HOUR = "end_hour";
        public static final String KEY_END_MINUTE = "end_minute";
    }

    public interface Operation {
        public static final String KEY_ALIAS = "alias";
        public static final String KEY_MOBILE_NUMBER = "mobileNumber";
        public static final String KEY_SEQUENCE = "sequence";
        public static final String KEY_TAG = "tag";
    }

    public interface PlatformNode {
        public static final int CODE_All_TOKEN_FAILED = 3005;
        public static final int CODE_CALLBACK_TOKEN_FAILED = 3004;
        public static final int CODE_GET_TOKEN_FAILED = 3003;
        public static final int CODE_GET_TOKEN_SUCCESS = 3008;
        public static final int CODE_NOT_INTEGRATED_AAR = 3001;
        public static final int CODE_NOT_SUPPORT_PLATFORM = 3002;
        public static final int CODE_TURN_OFF_PUSH = 3102;
        public static final int CODE_TURN_ON_PUSH = 3101;
        public static final int CODE_UPLOAD_TOKEN_FAILED = 3006;
        public static final int CODE_UPLOAD_TOKEN_SUCCESS = 3007;
        public static final int FLAG_CALLBACK_TOKEN = 2;
        public static final int FLAG_GET_TOKEN = 1;
        public static final int FLAG_OTHER = 0;
        public static final String KEY_CODE = "code";
        public static final String KEY_EVENT_TYPE = "type";
        public static final int KEY_EVENT_TYPE_TOKEN_FAILED = 3900;
        public static final int KEY_EVENT_TYPE_TOKEN_SUCCESS = 3901;
        public static final int KEY_EVENT_TYPE_TURN_OFF_PUSH = 3903;
        public static final int KEY_EVENT_TYPE_TURN_ON_PUSH = 3902;
        public static final String KEY_FROM = "from";
        public static final String KEY_M_CODE = "mCode";
        public static final String KEY_PLATFORM = "platform";
    }

    public interface RemoteWhat {
        public static final int ADD_GEOFENCE = 3881;
        public static final int ALIAS_CLEAR = 3981;
        public static final int ALIAS_GET = 3982;
        public static final int ALIAS_SET = 3983;
        public static final int CLEAR_NOTIFICATION = 3894;
        public static final int DELETE_GEOFENCE = 3880;
        public static final int ON_CUSTOM_ARRIVED = 3999;
        public static final int ON_CUSTOM_MESSAGE = 3897;
        public static final int ON_GEOFENCE = 3879;
        public static final int ON_GEOFENCE_LOCATION = 3878;
        public static final int ON_GEOFENCE_LOCATION_TIMEOUT = 3877;
        public static final int ON_MOBILE_NUMBER = 3978;
        public static final int ON_NOTIFICATION_ARRIVED = 3998;
        public static final int ON_NOTIFICATION_CLICKED = 3997;
        public static final int ON_NOTIFICATION_DELETED = 3996;
        public static final int ON_NOTIFICATION_MESSAGE = 3896;
        public static final int ON_NOTIFICATION_OPENED = 3995;
        public static final int ON_NOTIFICATION_STATE = 3994;
        public static final int ON_PLATFORM_TOKEN = 3979;
        public static final int REPORT_NOTIFICATION_STATE = 3799;
        public static final int RESET_NOTIFICATION_BADGE = 3884;
        public static final int RESET_NOTIFICATION_COUNT = 3886;
        public static final int RESET_NOTIFICATION_LAYOUT = 3888;
        public static final int RESET_NOTIFICATION_SHOW_TIME = 3892;
        public static final int RESET_NOTIFICATION_SILENCE_TIME = 3890;
        public static final int SET_GEOFENCE_COUNT = 3883;
        public static final int SET_GEOFENCE_INTERVAL = 3882;
        public static final int SET_NOTIFICATION_BADGE = 3885;
        public static final int SET_NOTIFICATION_COUNT = 3887;
        public static final int SET_NOTIFICATION_LAYOUT = 3889;
        public static final int SET_NOTIFICATION_SHOW_TIME = 3893;
        public static final int SET_NOTIFICATION_SILENCE_TIME = 3891;
        public static final int SHOW_NOTIFICATION = 3895;
        public static final int TAG_ADD = 3989;
        public static final int TAG_DELETE = 3988;
        public static final int TAG_DELETE_ALL = 3985;
        public static final int TAG_QUERY = 3986;
        public static final int TAG_QUERY_ALL = 3984;
        public static final int TAG_UPDATE = 3987;
        public static final int TURN_OFF_GEOFENCESWITCH = 3797;
        public static final int TURN_OFF_PUSH = 3898;
        public static final int TURN_ON_GEOFENCESWITCH = 3798;
        public static final int TURN_ON_PUSH = 3899;
    }
}
