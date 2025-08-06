package org.apache.commons.io;

import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class FileCleaningTracker {

    /* renamed from: a  reason: collision with root package name */
    public ReferenceQueue<Object> f58921a = new ReferenceQueue<>();

    /* renamed from: b  reason: collision with root package name */
    public final Collection<Object> f58922b = Collections.synchronizedSet(new HashSet());

    /* renamed from: c  reason: collision with root package name */
    public final List<String> f58923c = Collections.synchronizedList(new ArrayList());

    /* renamed from: d  reason: collision with root package name */
    public volatile boolean f58924d = false;
}
