package com.huobi.edgeengine.node.trace.error;

public class TraceValueError extends Exception {
    public static final String OBJECT_KEY_NOT_STRING = "从 Object 中访问的下标不是一个 String 而是对象";
    public static final String TRACE_MAP_GET_KEY_IS_EMPTY = "从 Object 中访问的下标是空字符串";
    public static final String TRACE_MAP_GET_VALUE_BUT_DEEP_KEY_IS_NOT_MAP = "从 Object 中取值的深度路径 %s 中有不是对象导致无法取值";
    public static final String TRACE_MAP_GET_VALUE_BUT_DEEP_KEY_NOT_MAP = "从 Object 中取值的深度路径 %s 中有不是对象导致无法取值";
    public static final String TRACE_MAP_LISTENER_ARRAY_BUT_PREVIOUS_IS_NOT_ARRAY = "监听一个 keyPath 为 %s 数组，但是上次这个 keyPath 被Listener个 Array";
    public static final String TRACE_MAP_LISTEN_ARRAY_BUT_PREVIOUS_IS_NOT_ARRAY = "监听一个 keyPath 为 %s 数组，但是上次这个 keyPath 被对象监听过或者值不是个 Array";
    public static final String TRACE_MAP_LISTEN_DEEP_MAP_NOT_EQUAL = "监听的深度监听表的引用和下游节点的监听表不是同一个";
    public static final String TRACE_MAP_LISTEN_SET_ARRAY_BUT_PREVIOUS_IS_OBJECT = "设置一个数组，但是上次是一个监听的对象";
    public static final String TRACE_MAP_SET_VALUE_OTHER_TYPE_BUT_PREVIOUS_IS_OBJECT = "对 Object 中设置路径 %s 为值 %s，但是这个原来的值是一个 Object 并且它已经被监听了，无法完成设置";
    public static final String TRACE_MAP_SET_VALUE_TYPE_NOT_ALLOWED = "对 Object 中设置类型是不被允许的";

    public TraceValueError() {
    }

    public TraceValueError(String str) {
        super(str);
    }
}
