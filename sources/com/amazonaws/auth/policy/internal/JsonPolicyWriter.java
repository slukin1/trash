package com.amazonaws.auth.policy.internal;

import com.amazonaws.logging.Log;
import com.amazonaws.logging.LogFactory;
import com.amazonaws.util.json.AwsJsonWriter;
import com.amazonaws.util.json.JsonUtils;
import java.io.StringWriter;
import java.io.Writer;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JsonPolicyWriter {

    /* renamed from: c  reason: collision with root package name */
    public static final Log f14857c = LogFactory.c("com.amazonaws.auth.policy");

    /* renamed from: a  reason: collision with root package name */
    public AwsJsonWriter f14858a = null;

    /* renamed from: b  reason: collision with root package name */
    public final Writer f14859b;

    public static class ConditionsByKey {

        /* renamed from: a  reason: collision with root package name */
        public Map<String, List<String>> f14860a = new HashMap();
    }

    public JsonPolicyWriter() {
        StringWriter stringWriter = new StringWriter();
        this.f14859b = stringWriter;
        this.f14858a = JsonUtils.b(stringWriter);
    }
}
