package com.alibaba.android.arouter.facade.model;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.facade.enums.RouteType;
import java.util.Map;
import javax.lang.model.element.Element;

public class RouteMeta {
    private Class<?> destination;
    private int extra;
    private String group;
    private Map<String, Autowired> injectConfig;
    private String name;
    private Map<String, Integer> paramsType;
    private String path;
    private int priority;
    private Element rawType;
    private RouteType type;

    public RouteMeta() {
        this.priority = -1;
    }

    public static RouteMeta build(RouteType routeType, Class<?> cls, String str, String str2, int i11, int i12) {
        return new RouteMeta(routeType, (Element) null, cls, (String) null, str, str2, (Map<String, Integer>) null, i11, i12);
    }

    public Class<?> getDestination() {
        return this.destination;
    }

    public int getExtra() {
        return this.extra;
    }

    public String getGroup() {
        return this.group;
    }

    public Map<String, Autowired> getInjectConfig() {
        return this.injectConfig;
    }

    public String getName() {
        return this.name;
    }

    public Map<String, Integer> getParamsType() {
        return this.paramsType;
    }

    public String getPath() {
        return this.path;
    }

    public int getPriority() {
        return this.priority;
    }

    public Element getRawType() {
        return this.rawType;
    }

    public RouteType getType() {
        return this.type;
    }

    public RouteMeta setDestination(Class<?> cls) {
        this.destination = cls;
        return this;
    }

    public RouteMeta setExtra(int i11) {
        this.extra = i11;
        return this;
    }

    public RouteMeta setGroup(String str) {
        this.group = str;
        return this;
    }

    public void setInjectConfig(Map<String, Autowired> map) {
        this.injectConfig = map;
    }

    public void setName(String str) {
        this.name = str;
    }

    public RouteMeta setParamsType(Map<String, Integer> map) {
        this.paramsType = map;
        return this;
    }

    public RouteMeta setPath(String str) {
        this.path = str;
        return this;
    }

    public RouteMeta setPriority(int i11) {
        this.priority = i11;
        return this;
    }

    public RouteMeta setRawType(Element element) {
        this.rawType = element;
        return this;
    }

    public RouteMeta setType(RouteType routeType) {
        this.type = routeType;
        return this;
    }

    public String toString() {
        return "RouteMeta{type=" + this.type + ", rawType=" + this.rawType + ", destination=" + this.destination + ", path='" + this.path + '\'' + ", group='" + this.group + '\'' + ", priority=" + this.priority + ", extra=" + this.extra + ", paramsType=" + this.paramsType + ", name='" + this.name + '\'' + '}';
    }

    public static RouteMeta build(RouteType routeType, Class<?> cls, String str, String str2, Map<String, Integer> map, int i11, int i12) {
        return new RouteMeta(routeType, (Element) null, cls, (String) null, str, str2, map, i11, i12);
    }

    public RouteMeta(Route route, Class<?> cls, RouteType routeType) {
        this(routeType, (Element) null, cls, route.name(), route.path(), route.group(), (Map<String, Integer>) null, route.priority(), route.extras());
    }

    public RouteMeta(Route route, Element element, RouteType routeType, Map<String, Integer> map) {
        this(routeType, element, (Class<?>) null, route.name(), route.path(), route.group(), map, route.priority(), route.extras());
    }

    public RouteMeta(RouteType routeType, Element element, Class<?> cls, String str, String str2, String str3, Map<String, Integer> map, int i11, int i12) {
        this.priority = -1;
        this.type = routeType;
        this.name = str;
        this.destination = cls;
        this.rawType = element;
        this.path = str2;
        this.group = str3;
        this.paramsType = map;
        this.priority = i11;
        this.extra = i12;
    }
}
