package com.alibaba.fastjson.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Collections;
import java.util.Enumeration;
import java.util.HashSet;
import java.util.Set;

public class ServiceLoader {

    /* renamed from: a  reason: collision with root package name */
    public static final Set<String> f14424a = new HashSet();

    public static <T> Set<T> a(Class<T> cls, ClassLoader classLoader) {
        if (classLoader == null) {
            return Collections.emptySet();
        }
        HashSet hashSet = new HashSet();
        String str = "META-INF/services/" + cls.getName();
        HashSet<String> hashSet2 = new HashSet<>();
        try {
            Enumeration<URL> resources = classLoader.getResources(str);
            while (resources.hasMoreElements()) {
                URL nextElement = resources.nextElement();
                Set<String> set = f14424a;
                if (!set.contains(nextElement.toString())) {
                    b(nextElement, hashSet2);
                    set.add(nextElement.toString());
                }
            }
        } catch (IOException unused) {
        }
        for (String loadClass : hashSet2) {
            try {
                hashSet.add(classLoader.loadClass(loadClass).newInstance());
            } catch (Exception unused2) {
            }
        }
        return hashSet;
    }

    public static void b(URL url, Set<String> set) throws IOException {
        InputStream inputStream;
        BufferedReader bufferedReader = null;
        try {
            inputStream = url.openStream();
            try {
                BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream, "utf-8"));
                while (true) {
                    try {
                        String readLine = bufferedReader2.readLine();
                        if (readLine == null) {
                            IOUtils.a(bufferedReader2);
                            IOUtils.a(inputStream);
                            return;
                        }
                        int indexOf = readLine.indexOf(35);
                        if (indexOf >= 0) {
                            readLine = readLine.substring(0, indexOf);
                        }
                        String trim = readLine.trim();
                        if (trim.length() != 0) {
                            set.add(trim);
                        }
                    } catch (Throwable th2) {
                        th = th2;
                        bufferedReader = bufferedReader2;
                        IOUtils.a(bufferedReader);
                        IOUtils.a(inputStream);
                        throw th;
                    }
                }
            } catch (Throwable th3) {
                th = th3;
                IOUtils.a(bufferedReader);
                IOUtils.a(inputStream);
                throw th;
            }
        } catch (Throwable th4) {
            th = th4;
            inputStream = null;
            IOUtils.a(bufferedReader);
            IOUtils.a(inputStream);
            throw th;
        }
    }
}
