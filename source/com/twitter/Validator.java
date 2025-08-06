package com.twitter;

import com.huochat.community.network.domain.DomainTool;
import com.twitter.Extractor;
import java.text.Normalizer;

public class Validator {

    /* renamed from: a  reason: collision with root package name */
    public int f51178a = 23;

    /* renamed from: b  reason: collision with root package name */
    public int f51179b = 23;

    /* renamed from: c  reason: collision with root package name */
    public Extractor f51180c = new Extractor();

    public int a(String str) {
        String normalize = Normalizer.normalize(str, Normalizer.Form.NFC);
        int codePointCount = normalize.codePointCount(0, normalize.length());
        for (Extractor.Entity next : this.f51180c.a(normalize)) {
            codePointCount = codePointCount + (next.f51152a - next.f51153b) + (next.f51154c.toLowerCase().startsWith(DomainTool.DOMAIN_PREFIX) ? this.f51179b : this.f51178a);
        }
        return codePointCount;
    }
}
