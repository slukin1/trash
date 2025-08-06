package com.bumptech.glide.load.model;

import com.bumptech.glide.load.model.LazyHeaders;
import java.util.Collections;
import java.util.Map;

public interface b {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final b f63986a = new a();

    /* renamed from: b  reason: collision with root package name */
    public static final b f63987b = new LazyHeaders.Builder().a();

    public class a implements b {
        public Map<String, String> getHeaders() {
            return Collections.emptyMap();
        }
    }

    Map<String, String> getHeaders();
}
