package com.alibaba.fastjson.util;

import java.lang.ref.SoftReference;
import java.nio.charset.CharsetDecoder;

public class ThreadLocalCache {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadLocal<SoftReference<char[]>> f14425a = new ThreadLocal<>();

    /* renamed from: b  reason: collision with root package name */
    public static final ThreadLocal<CharsetDecoder> f14426b = new ThreadLocal<>();

    /* renamed from: c  reason: collision with root package name */
    public static final ThreadLocal<SoftReference<byte[]>> f14427c = new ThreadLocal<>();
}
