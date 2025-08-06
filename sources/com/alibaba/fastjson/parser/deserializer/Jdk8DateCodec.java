package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.JSONSerializer;
import com.alibaba.fastjson.serializer.SerializeWriter;
import com.alibaba.fastjson.serializer.SerializerFeature;
import f2.a;
import f2.b;
import h2.c;
import h2.d;
import h2.k;
import java.io.IOException;
import java.lang.reflect.Type;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.OffsetDateTime;
import java.time.OffsetTime;
import java.time.Period;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAccessor;
import java.util.Locale;

public class Jdk8DateCodec extends ContextObjectDeserializer implements k, d {

    /* renamed from: a  reason: collision with root package name */
    public static final Jdk8DateCodec f14197a = new Jdk8DateCodec();

    /* renamed from: b  reason: collision with root package name */
    public static final DateTimeFormatter f14198b = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

    /* renamed from: c  reason: collision with root package name */
    public static final DateTimeFormatter f14199c = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

    /* renamed from: d  reason: collision with root package name */
    public static final DateTimeFormatter f14200d = DateTimeFormatter.ofPattern("yyyy年M月d日 HH:mm:ss");

    /* renamed from: e  reason: collision with root package name */
    public static final DateTimeFormatter f14201e = DateTimeFormatter.ofPattern("yyyy年M月d日 H时m分s秒");

    /* renamed from: f  reason: collision with root package name */
    public static final DateTimeFormatter f14202f = DateTimeFormatter.ofPattern("yyyy년M월d일 HH:mm:ss");

    /* renamed from: g  reason: collision with root package name */
    public static final DateTimeFormatter f14203g = DateTimeFormatter.ofPattern("MM/dd/yyyy HH:mm:ss");

    /* renamed from: h  reason: collision with root package name */
    public static final DateTimeFormatter f14204h = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");

    /* renamed from: i  reason: collision with root package name */
    public static final DateTimeFormatter f14205i = DateTimeFormatter.ofPattern("dd.MM.yyyy HH:mm:ss");

    /* renamed from: j  reason: collision with root package name */
    public static final DateTimeFormatter f14206j = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /* renamed from: k  reason: collision with root package name */
    public static final DateTimeFormatter f14207k = DateTimeFormatter.ofPattern("yyyyMMdd");

    /* renamed from: l  reason: collision with root package name */
    public static final DateTimeFormatter f14208l = DateTimeFormatter.ofPattern("yyyy/MM/dd");

    /* renamed from: m  reason: collision with root package name */
    public static final DateTimeFormatter f14209m = DateTimeFormatter.ofPattern("yyyy年M月d日");

    /* renamed from: n  reason: collision with root package name */
    public static final DateTimeFormatter f14210n = DateTimeFormatter.ofPattern("yyyy년M월d일");

    /* renamed from: o  reason: collision with root package name */
    public static final DateTimeFormatter f14211o = DateTimeFormatter.ofPattern("MM/dd/yyyy");

    /* renamed from: p  reason: collision with root package name */
    public static final DateTimeFormatter f14212p = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    /* renamed from: q  reason: collision with root package name */
    public static final DateTimeFormatter f14213q = DateTimeFormatter.ofPattern("dd.MM.yyyy");

    /* renamed from: r  reason: collision with root package name */
    public static final DateTimeFormatter f14214r = DateTimeFormatter.ofPattern("dd-MM-yyyy");

    /* renamed from: s  reason: collision with root package name */
    public static final DateTimeFormatter f14215s = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss").withZone(ZoneId.systemDefault());

    /* renamed from: t  reason: collision with root package name */
    public static final DateTimeFormatter f14216t = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");

    public int b() {
        return 4;
    }

    public void c(JSONSerializer jSONSerializer, Object obj, Object obj2, Type type, int i11) throws IOException {
        SerializeWriter serializeWriter = jSONSerializer.f14277k;
        if (obj == null) {
            serializeWriter.H();
            return;
        }
        if (type == null) {
            type = obj.getClass();
        }
        if (type == LocalDateTime.class) {
            SerializerFeature serializerFeature = SerializerFeature.UseISO8601DateFormat;
            int mask = serializerFeature.getMask();
            LocalDateTime localDateTime = (LocalDateTime) obj;
            String u11 = jSONSerializer.u();
            if ((u11 == null && (i11 & mask) != 0) || jSONSerializer.y(serializerFeature)) {
                u11 = "yyyy-MM-dd'T'HH:mm:ss";
            }
            if (localDateTime.getNano() == 0 || u11 != null) {
                if (u11 == null) {
                    u11 = JSON.DEFFAULT_DATE_FORMAT;
                }
                j(serializeWriter, localDateTime, u11);
                return;
            }
            serializeWriter.K(obj.toString());
            return;
        }
        serializeWriter.K(obj.toString());
    }

    public void d(JSONSerializer jSONSerializer, Object obj, c cVar) throws IOException {
        j(jSONSerializer.f14277k, (TemporalAccessor) obj, cVar.b());
    }

    public <T> T f(a aVar, Type type, Object obj, String str, int i11) {
        DateTimeFormatter dateTimeFormatter;
        b bVar = aVar.f15701g;
        if (bVar.J() == 8) {
            bVar.nextToken();
            return null;
        } else if (bVar.J() == 4) {
            String H = bVar.H();
            bVar.nextToken();
            if (str != null) {
                dateTimeFormatter = "yyyy-MM-dd HH:mm:ss".equals(str) ? f14198b : DateTimeFormatter.ofPattern(str);
            } else {
                dateTimeFormatter = null;
            }
            if ("".equals(H)) {
                return null;
            }
            if (type == LocalDateTime.class) {
                if (H.length() == 10 || H.length() == 8) {
                    return LocalDateTime.of(h(H, str, dateTimeFormatter), LocalTime.MIN);
                }
                return g(H, dateTimeFormatter);
            } else if (type == LocalDate.class) {
                if (H.length() != 23) {
                    return h(H, str, dateTimeFormatter);
                }
                LocalDateTime parse = LocalDateTime.parse(H);
                return LocalDate.of(parse.getYear(), parse.getMonthValue(), parse.getDayOfMonth());
            } else if (type == LocalTime.class) {
                if (H.length() != 23) {
                    return LocalTime.parse(H);
                }
                LocalDateTime parse2 = LocalDateTime.parse(H);
                return LocalTime.of(parse2.getHour(), parse2.getMinute(), parse2.getSecond(), parse2.getNano());
            } else if (type == ZonedDateTime.class) {
                if (dateTimeFormatter == f14198b) {
                    dateTimeFormatter = f14215s;
                }
                return i(H, dateTimeFormatter);
            } else if (type == OffsetDateTime.class) {
                return OffsetDateTime.parse(H);
            } else {
                if (type == OffsetTime.class) {
                    return OffsetTime.parse(H);
                }
                if (type == ZoneId.class) {
                    return ZoneId.of(H);
                }
                if (type == Period.class) {
                    return Period.parse(H);
                }
                if (type == Duration.class) {
                    return Duration.parse(H);
                }
                if (type == Instant.class) {
                    return Instant.parse(H);
                }
                return null;
            }
        } else {
            throw new UnsupportedOperationException();
        }
    }

    public LocalDateTime g(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = f14198b;
                        }
                    } else if (charAt == '-' && charAt2 == '-') {
                        dateTimeFormatter = f14198b;
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = f14199c;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i11 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = f14204h;
                            } else if (i11 > 12) {
                                dateTimeFormatter = f14203g;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f14203g;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f14204h;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = f14205i;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = f14206j;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter = f14201e;
                    } else {
                        dateTimeFormatter = f14200d;
                    }
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = f14202f;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDateTime.parse(str);
        }
        return LocalDateTime.parse(str, dateTimeFormatter);
    }

    public LocalDate h(String str, String str2, DateTimeFormatter dateTimeFormatter) {
        DateTimeFormatter dateTimeFormatter2;
        if (dateTimeFormatter == null) {
            if (str.length() == 8) {
                dateTimeFormatter = f14207k;
            }
            if (str.length() == 10) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                if (charAt == '/' && charAt2 == '/') {
                    dateTimeFormatter = f14208l;
                }
                char charAt3 = str.charAt(0);
                char charAt4 = str.charAt(1);
                char charAt5 = str.charAt(2);
                char charAt6 = str.charAt(3);
                char charAt7 = str.charAt(5);
                if (charAt5 == '/' && charAt7 == '/') {
                    int i11 = ((charAt6 - '0') * 10) + (charAt - '0');
                    if (((charAt3 - '0') * 10) + (charAt4 - '0') > 12) {
                        dateTimeFormatter = f14212p;
                    } else if (i11 > 12) {
                        dateTimeFormatter = f14211o;
                    } else {
                        String country = Locale.getDefault().getCountry();
                        if (country.equals("US")) {
                            dateTimeFormatter = f14211o;
                        } else if (country.equals("BR") || country.equals("AU")) {
                            dateTimeFormatter = f14212p;
                        }
                    }
                } else {
                    if (charAt5 == '.' && charAt7 == '.') {
                        dateTimeFormatter2 = f14213q;
                    } else if (charAt5 == '-' && charAt7 == '-') {
                        dateTimeFormatter2 = f14214r;
                    }
                    dateTimeFormatter = dateTimeFormatter2;
                }
            }
            if (str.length() >= 9) {
                char charAt8 = str.charAt(4);
                if (charAt8 == 24180) {
                    dateTimeFormatter = f14209m;
                } else if (charAt8 == 45380) {
                    dateTimeFormatter = f14210n;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return LocalDate.parse(str);
        }
        return LocalDate.parse(str, dateTimeFormatter);
    }

    public ZonedDateTime i(String str, DateTimeFormatter dateTimeFormatter) {
        if (dateTimeFormatter == null) {
            if (str.length() == 19) {
                char charAt = str.charAt(4);
                char charAt2 = str.charAt(7);
                char charAt3 = str.charAt(10);
                char charAt4 = str.charAt(13);
                char charAt5 = str.charAt(16);
                if (charAt4 == ':' && charAt5 == ':') {
                    if (charAt == '-' && charAt2 == '-') {
                        if (charAt3 == 'T') {
                            dateTimeFormatter = DateTimeFormatter.ISO_LOCAL_DATE_TIME;
                        } else if (charAt3 == ' ') {
                            dateTimeFormatter = f14198b;
                        }
                    } else if (charAt == '-' && charAt2 == '-') {
                        dateTimeFormatter = f14198b;
                    } else if (charAt == '/' && charAt2 == '/') {
                        dateTimeFormatter = f14199c;
                    } else {
                        char charAt6 = str.charAt(0);
                        char charAt7 = str.charAt(1);
                        char charAt8 = str.charAt(2);
                        char charAt9 = str.charAt(3);
                        char charAt10 = str.charAt(5);
                        if (charAt8 == '/' && charAt10 == '/') {
                            int i11 = ((charAt9 - '0') * 10) + (charAt - '0');
                            if (((charAt6 - '0') * 10) + (charAt7 - '0') > 12) {
                                dateTimeFormatter = f14204h;
                            } else if (i11 > 12) {
                                dateTimeFormatter = f14203g;
                            } else {
                                String country = Locale.getDefault().getCountry();
                                if (country.equals("US")) {
                                    dateTimeFormatter = f14203g;
                                } else if (country.equals("BR") || country.equals("AU")) {
                                    dateTimeFormatter = f14204h;
                                }
                            }
                        } else if (charAt8 == '.' && charAt10 == '.') {
                            dateTimeFormatter = f14205i;
                        } else if (charAt8 == '-' && charAt10 == '-') {
                            dateTimeFormatter = f14206j;
                        }
                    }
                }
            }
            if (str.length() >= 17) {
                char charAt11 = str.charAt(4);
                if (charAt11 == 24180) {
                    if (str.charAt(str.length() - 1) == 31186) {
                        dateTimeFormatter = f14201e;
                    } else {
                        dateTimeFormatter = f14200d;
                    }
                } else if (charAt11 == 45380) {
                    dateTimeFormatter = f14202f;
                }
            }
        }
        if (dateTimeFormatter == null) {
            return ZonedDateTime.parse(str);
        }
        return ZonedDateTime.parse(str, dateTimeFormatter);
    }

    public final void j(SerializeWriter serializeWriter, TemporalAccessor temporalAccessor, String str) {
        DateTimeFormatter dateTimeFormatter;
        if (str == "yyyy-MM-dd'T'HH:mm:ss") {
            dateTimeFormatter = f14216t;
        } else {
            dateTimeFormatter = DateTimeFormatter.ofPattern(str);
        }
        serializeWriter.K(dateTimeFormatter.format(temporalAccessor));
    }
}
