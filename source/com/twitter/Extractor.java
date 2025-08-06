package com.twitter;

import com.xiaomi.mipush.sdk.Constants;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;

public class Extractor {

    /* renamed from: a  reason: collision with root package name */
    public boolean f51151a = true;

    public List<Entity> a(String str) {
        if (!(str == null || str.length() == 0)) {
            if (str.indexOf(this.f51151a ? 46 : 58) != -1) {
                ArrayList arrayList = new ArrayList();
                Matcher matcher = Regex.f51171l.matcher(str);
                while (matcher.find()) {
                    if (matcher.group(4) != null || (this.f51151a && !Regex.f51173n.matcher(matcher.group(2)).matches())) {
                        String group = matcher.group(3);
                        int start = matcher.start(3);
                        int end = matcher.end(3);
                        Matcher matcher2 = Regex.f51172m.matcher(group);
                        if (matcher2.find()) {
                            group = matcher2.group();
                            end = group.length() + start;
                        }
                        arrayList.add(new Entity(start, end, group, Entity.Type.URL));
                    }
                }
                return arrayList;
            }
        }
        return Collections.emptyList();
    }

    public void b(boolean z11) {
        this.f51151a = z11;
    }

    public static class Entity {

        /* renamed from: a  reason: collision with root package name */
        public int f51152a;

        /* renamed from: b  reason: collision with root package name */
        public int f51153b;

        /* renamed from: c  reason: collision with root package name */
        public final String f51154c;

        /* renamed from: d  reason: collision with root package name */
        public final String f51155d;

        /* renamed from: e  reason: collision with root package name */
        public final Type f51156e;

        /* renamed from: f  reason: collision with root package name */
        public String f51157f;

        /* renamed from: g  reason: collision with root package name */
        public String f51158g;

        public enum Type {
            URL,
            HASHTAG,
            MENTION,
            CASHTAG
        }

        public Entity(int i11, int i12, String str, String str2, Type type) {
            this.f51157f = null;
            this.f51158g = null;
            this.f51152a = i11;
            this.f51153b = i12;
            this.f51154c = str;
            this.f51155d = str2;
            this.f51156e = type;
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (!(obj instanceof Entity)) {
                return false;
            }
            Entity entity = (Entity) obj;
            if (!this.f51156e.equals(entity.f51156e) || this.f51152a != entity.f51152a || this.f51153b != entity.f51153b || !this.f51154c.equals(entity.f51154c)) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return this.f51156e.hashCode() + this.f51154c.hashCode() + this.f51152a + this.f51153b;
        }

        public String toString() {
            return this.f51154c + "(" + this.f51156e + ") [" + this.f51152a + Constants.ACCEPT_TIME_SEPARATOR_SP + this.f51153b + "]";
        }

        public Entity(int i11, int i12, String str, Type type) {
            this(i11, i12, str, (String) null, type);
        }
    }
}
