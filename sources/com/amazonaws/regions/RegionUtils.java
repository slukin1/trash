package com.amazonaws.regions;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.huochat.community.network.domain.DomainTool;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;

public class RegionUtils {

    /* renamed from: a  reason: collision with root package name */
    public static List<Region> f15068a;

    /* renamed from: b  reason: collision with root package name */
    public static final Log f15069b = LogFactory.c("com.amazonaws.request");

    public static Region a(String str) {
        for (Region next : c()) {
            if (next.d().equals(str)) {
                return next;
            }
        }
        return null;
    }

    public static Region b(String str) {
        String host = d(str).getHost();
        for (Region next : c()) {
            Iterator<String> it2 = next.h().values().iterator();
            while (true) {
                if (it2.hasNext()) {
                    if (d(it2.next()).getHost().equals(host)) {
                        return next;
                    }
                }
            }
        }
        throw new IllegalArgumentException("No region found with any service for endpoint " + str);
    }

    public static synchronized List<Region> c() {
        List<Region> list;
        synchronized (RegionUtils.class) {
            if (f15068a == null) {
                e();
            }
            list = f15068a;
        }
        return list;
    }

    public static URI d(String str) {
        try {
            URI uri = new URI(str);
            if (uri.getHost() != null) {
                return uri;
            }
            return new URI(DomainTool.DOMAIN_PREFIX_HTTP + str);
        } catch (URISyntaxException e11) {
            throw new RuntimeException("Unable to parse service endpoint: " + e11.getMessage());
        }
    }

    public static synchronized void e() {
        synchronized (RegionUtils.class) {
            if (System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride") != null) {
                try {
                    h();
                } catch (FileNotFoundException e11) {
                    throw new RuntimeException("Couldn't find regions override file specified", e11);
                }
            }
            if (f15068a == null) {
                g();
            }
            if (f15068a == null) {
                throw new RuntimeException("Failed to initialize the regions.");
            }
        }
    }

    public static void f(InputStream inputStream) {
        try {
            f15068a = new RegionMetadataParser().e(inputStream);
        } catch (Exception e11) {
            f15069b.f("Failed to parse regional endpoints", e11);
        }
    }

    public static void g() {
        Log log = f15069b;
        if (log.i()) {
            log.h("Initializing the regions with default regions");
        }
        f15068a = RegionDefaults.a();
    }

    public static void h() throws FileNotFoundException {
        String property = System.getProperty("com.amazonaws.regions.RegionUtils.fileOverride");
        Log log = f15069b;
        if (log.i()) {
            log.h("Using local override of the regions file (" + property + ") to initiate regions data...");
        }
        f(new FileInputStream(new File(property)));
    }
}
