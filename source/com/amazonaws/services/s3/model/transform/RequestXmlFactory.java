package com.amazonaws.services.s3.model.transform;

import com.amazonaws.services.s3.internal.XmlWriter;
import com.amazonaws.services.s3.model.PartETag;
import com.google.common.net.HttpHeaders;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class RequestXmlFactory {
    public static byte[] a(List<PartETag> list) {
        XmlWriter xmlWriter = new XmlWriter();
        xmlWriter.d("CompleteMultipartUpload");
        if (list != null) {
            Collections.sort(list, new Comparator<PartETag>() {
                /* renamed from: a */
                public int compare(PartETag partETag, PartETag partETag2) {
                    if (partETag.b() < partETag2.b()) {
                        return -1;
                    }
                    return partETag.b() > partETag2.b() ? 1 : 0;
                }
            });
            for (PartETag next : list) {
                xmlWriter.d("Part");
                xmlWriter.d("PartNumber").e(Integer.toString(next.b())).b();
                xmlWriter.d(HttpHeaders.ETAG).e(next.a()).b();
                xmlWriter.b();
            }
        }
        xmlWriter.b();
        return xmlWriter.c();
    }
}
