package com.amazonaws.services.s3.internal;

import com.amazonaws.Request;
import com.amazonaws.util.StringUtils;
import com.facebook.places.model.PlaceFields;
import com.huawei.hms.framework.common.ContainerUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.tencent.android.tpush.common.MessageKey;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class RestUtils {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f15179a = Arrays.asList(new String[]{"acl", "torrent", "logging", "location", "policy", "requestPayment", "versioning", "versions", "versionId", RemoteMessageConst.NOTIFICATION, "uploadId", "uploads", "partNumber", PlaceFields.WEBSITE, "delete", "lifecycle", "tagging", "cors", "restore", "replication", "accelerate", "inventory", "analytics", "metrics", "response-cache-control", "response-content-disposition", "response-content-encoding", "response-content-language", "response-content-type", "response-expires"});

    public static <T> String a(String str, String str2, Request<T> request, String str3, Collection<String> collection) {
        StringBuilder sb2 = new StringBuilder();
        sb2.append(str + "\n");
        Map<String, String> headers = request.getHeaders();
        TreeMap treeMap = new TreeMap();
        if (headers != null && headers.size() > 0) {
            for (Map.Entry next : headers.entrySet()) {
                String str4 = (String) next.getKey();
                String str5 = (String) next.getValue();
                if (str4 != null) {
                    String b11 = StringUtils.b(str4);
                    if ("content-type".equals(b11) || "content-md5".equals(b11) || MessageKey.MSG_DATE.equals(b11) || b11.startsWith("x-amz-")) {
                        treeMap.put(b11, str5);
                    }
                }
            }
        }
        if (treeMap.containsKey("x-amz-date")) {
            treeMap.put(MessageKey.MSG_DATE, "");
        }
        if (str3 != null) {
            treeMap.put(MessageKey.MSG_DATE, str3);
        }
        if (!treeMap.containsKey("content-type")) {
            treeMap.put("content-type", "");
        }
        if (!treeMap.containsKey("content-md5")) {
            treeMap.put("content-md5", "");
        }
        for (Map.Entry next2 : request.getParameters().entrySet()) {
            if (((String) next2.getKey()).startsWith("x-amz-")) {
                treeMap.put(next2.getKey(), next2.getValue());
            }
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            String str6 = (String) entry.getKey();
            String str7 = (String) entry.getValue();
            if (str6.startsWith("x-amz-")) {
                sb2.append(str6);
                sb2.append(':');
                if (str7 != null) {
                    sb2.append(str7);
                }
            } else if (str7 != null) {
                sb2.append(str7);
            }
            sb2.append("\n");
        }
        sb2.append(str2);
        String[] strArr = (String[]) request.getParameters().keySet().toArray(new String[request.getParameters().size()]);
        Arrays.sort(strArr);
        char c11 = '?';
        for (String str8 : strArr) {
            if (f15179a.contains(str8) || (collection != null && collection.contains(str8))) {
                if (sb2.length() == 0) {
                    sb2.append(c11);
                }
                sb2.append(str8);
                String str9 = request.getParameters().get(str8);
                if (str9 != null) {
                    sb2.append(ContainerUtils.KEY_VALUE_DELIMITER);
                    sb2.append(str9);
                }
                c11 = '&';
            }
        }
        return sb2.toString();
    }
}
