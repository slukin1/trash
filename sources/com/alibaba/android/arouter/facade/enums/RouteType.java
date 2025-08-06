package com.alibaba.android.arouter.facade.enums;

public enum RouteType {
    ACTIVITY(0, "android.app.Activity"),
    SERVICE(1, "android.app.Service"),
    PROVIDER(2, "com.alibaba.android.arouter.facade.template.IProvider"),
    CONTENT_PROVIDER(-1, "android.app.ContentProvider"),
    BOARDCAST(-1, ""),
    METHOD(-1, ""),
    FRAGMENT(-1, "android.app.Fragment"),
    UNKNOWN(-1, "Unknown route type");
    
    public String className;

    /* renamed from: id  reason: collision with root package name */
    public int f14069id;

    private RouteType(int i11, String str) {
        this.f14069id = i11;
        this.className = str;
    }

    public static RouteType parse(String str) {
        for (RouteType routeType : values()) {
            if (routeType.getClassName().equals(str)) {
                return routeType;
            }
        }
        return UNKNOWN;
    }

    public String getClassName() {
        return this.className;
    }

    public int getId() {
        return this.f14069id;
    }

    public RouteType setClassName(String str) {
        this.className = str;
        return this;
    }

    public RouteType setId(int i11) {
        this.f14069id = i11;
        return this;
    }
}
