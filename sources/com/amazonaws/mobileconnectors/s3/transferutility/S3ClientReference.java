package com.amazonaws.mobileconnectors.s3.transferutility;

import com.amazonaws.services.s3.AmazonS3;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class S3ClientReference {

    /* renamed from: a  reason: collision with root package name */
    public static Map<Integer, AmazonS3> f14957a = new ConcurrentHashMap();

    public static AmazonS3 a(Integer num) {
        return f14957a.get(num);
    }

    public static void b(Integer num) {
        f14957a.remove(num);
    }
}
