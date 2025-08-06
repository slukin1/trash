package org.joda.time.chrono;

import java.util.concurrent.ConcurrentHashMap;
import org.joda.time.Chronology;
import org.joda.time.DateTime;
import org.joda.time.DateTimeField;
import org.joda.time.DateTimeFieldType;
import org.joda.time.DateTimeZone;
import org.joda.time.DurationFieldType;
import org.joda.time.chrono.AssembledChronology;
import org.joda.time.field.DelegatedDateTimeField;
import org.joda.time.field.SkipUndoDateTimeField;
import org.joda.time.field.UnsupportedDurationField;
import org.joda.time.field.d;
import org.joda.time.field.f;
import org.joda.time.field.i;

public final class BuddhistChronology extends AssembledChronology {
    public static final int BE = 1;
    private static final int BUDDHIST_OFFSET = 543;
    private static final DateTimeField ERA_FIELD = new d("BE");
    private static final BuddhistChronology INSTANCE_UTC = getInstance(DateTimeZone.UTC);
    private static final ConcurrentHashMap<DateTimeZone, BuddhistChronology> cCache = new ConcurrentHashMap<>();
    private static final long serialVersionUID = -3474595157769370126L;

    private BuddhistChronology(Chronology chronology, Object obj) {
        super(chronology, obj);
    }

    public static BuddhistChronology getInstance() {
        return getInstance(DateTimeZone.getDefault());
    }

    public static BuddhistChronology getInstanceUTC() {
        return INSTANCE_UTC;
    }

    private Object readResolve() {
        Chronology base = getBase();
        return base == null ? getInstanceUTC() : getInstance(base.getZone());
    }

    public void assemble(AssembledChronology.a aVar) {
        if (getParam() == null) {
            aVar.f23044l = UnsupportedDurationField.getInstance(DurationFieldType.eras());
            f fVar = new f(new SkipUndoDateTimeField(this, aVar.E), BUDDHIST_OFFSET);
            aVar.E = fVar;
            aVar.F = new DelegatedDateTimeField(fVar, aVar.f23044l, DateTimeFieldType.yearOfEra());
            aVar.B = new f(new SkipUndoDateTimeField(this, aVar.B), BUDDHIST_OFFSET);
            d dVar = new d(new f(aVar.F, 99), aVar.f23044l, DateTimeFieldType.centuryOfEra(), 100);
            aVar.H = dVar;
            aVar.f23043k = dVar.getDurationField();
            aVar.G = new f(new i((d) aVar.H), DateTimeFieldType.yearOfCentury(), 1);
            aVar.C = new f(new i(aVar.B, aVar.f23043k, DateTimeFieldType.weekyearOfCentury(), 100), DateTimeFieldType.weekyearOfCentury(), 1);
            aVar.I = ERA_FIELD;
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof BuddhistChronology) {
            return getZone().equals(((BuddhistChronology) obj).getZone());
        }
        return false;
    }

    public int hashCode() {
        return 499287079 + getZone().hashCode();
    }

    public String toString() {
        DateTimeZone zone = getZone();
        if (zone == null) {
            return "BuddhistChronology";
        }
        return "BuddhistChronology" + '[' + zone.getID() + ']';
    }

    public Chronology withUTC() {
        return INSTANCE_UTC;
    }

    public Chronology withZone(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        if (dateTimeZone == getZone()) {
            return this;
        }
        return getInstance(dateTimeZone);
    }

    public static BuddhistChronology getInstance(DateTimeZone dateTimeZone) {
        if (dateTimeZone == null) {
            dateTimeZone = DateTimeZone.getDefault();
        }
        ConcurrentHashMap<DateTimeZone, BuddhistChronology> concurrentHashMap = cCache;
        BuddhistChronology buddhistChronology = concurrentHashMap.get(dateTimeZone);
        if (buddhistChronology != null) {
            return buddhistChronology;
        }
        BuddhistChronology buddhistChronology2 = new BuddhistChronology(GJChronology.getInstance(dateTimeZone, (org.joda.time.f) null), (Object) null);
        BuddhistChronology buddhistChronology3 = new BuddhistChronology(LimitChronology.getInstance(buddhistChronology2, new DateTime(1, 1, 1, 0, 0, 0, 0, (Chronology) buddhistChronology2), (org.joda.time.d) null), "");
        BuddhistChronology putIfAbsent = concurrentHashMap.putIfAbsent(dateTimeZone, buddhistChronology3);
        return putIfAbsent != null ? putIfAbsent : buddhistChronology3;
    }
}
