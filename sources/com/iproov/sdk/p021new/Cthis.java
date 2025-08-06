package com.iproov.sdk.p021new;

import android.hardware.camera2.CaptureResult;
import android.hardware.camera2.TotalCaptureResult;
import com.iproov.sdk.p017implements.Cimport;
import m1.a;

/* renamed from: com.iproov.sdk.new.this  reason: invalid class name and invalid package */
public class Cthis {

    /* renamed from: break  reason: not valid java name */
    private final Double f1063break;

    /* renamed from: case  reason: not valid java name */
    private final Double f1064case;

    /* renamed from: catch  reason: not valid java name */
    private final Double f1065catch;

    /* renamed from: class  reason: not valid java name */
    private final Double f1066class;

    /* renamed from: const  reason: not valid java name */
    private final Double f1067const;

    /* renamed from: do  reason: not valid java name */
    private final Double f1068do;

    /* renamed from: else  reason: not valid java name */
    private final Double f1069else;

    /* renamed from: final  reason: not valid java name */
    private final Double f1070final;

    /* renamed from: for  reason: not valid java name */
    private final Double f1071for;

    /* renamed from: goto  reason: not valid java name */
    private final Double f1072goto;

    /* renamed from: if  reason: not valid java name */
    private final Double f1073if;

    /* renamed from: import  reason: not valid java name */
    private final Double f1074import;

    /* renamed from: native  reason: not valid java name */
    private final Double f1075native;

    /* renamed from: new  reason: not valid java name */
    private final Double f1076new;

    /* renamed from: public  reason: not valid java name */
    private final Double f1077public;

    /* renamed from: super  reason: not valid java name */
    private final Double f1078super;

    /* renamed from: this  reason: not valid java name */
    private final Double f1079this;

    /* renamed from: throw  reason: not valid java name */
    private final Double f1080throw;

    /* renamed from: try  reason: not valid java name */
    private final Double f1081try;

    /* renamed from: while  reason: not valid java name */
    private final Double f1082while;

    public Cthis(TotalCaptureResult totalCaptureResult) {
        Double d11 = Celse.m1190do((Float) totalCaptureResult.get(CaptureResult.LENS_APERTURE));
        this.f1068do = d11;
        this.f1076new = d11;
        Integer num = (Integer) totalCaptureResult.get(CaptureResult.SENSOR_SENSITIVITY);
        this.f1071for = (num == null || num.intValue() == 0) ? null : Celse.m1191do(num);
        Long l11 = (Long) totalCaptureResult.get(CaptureResult.SENSOR_EXPOSURE_TIME);
        this.f1073if = (l11 == null || l11.longValue() == 0) ? null : Double.valueOf(((double) l11.longValue()) / 1.0E9d);
        this.f1081try = Celse.m1190do((Float) totalCaptureResult.get(CaptureResult.LENS_FOCAL_LENGTH));
        this.f1064case = null;
        this.f1069else = Celse.m1190do((Float) totalCaptureResult.get(CaptureResult.LENS_FOCUS_DISTANCE));
        this.f1072goto = Celse.m1191do((Integer) totalCaptureResult.get(CaptureResult.CONTROL_AE_EXPOSURE_COMPENSATION));
        this.f1079this = null;
        this.f1063break = null;
        this.f1065catch = null;
        this.f1066class = null;
        this.f1067const = null;
        this.f1070final = null;
        this.f1078super = null;
        this.f1080throw = null;
        this.f1082while = null;
        this.f1074import = null;
        this.f1075native = null;
        this.f1077public = null;
    }

    /* renamed from: break  reason: not valid java name */
    public Double m1208break() {
        return this.f1071for;
    }

    /* renamed from: case  reason: not valid java name */
    public Double m1209case() {
        return this.f1072goto;
    }

    /* renamed from: catch  reason: not valid java name */
    public Double m1210catch() {
        return this.f1075native;
    }

    /* renamed from: class  reason: not valid java name */
    public Double m1211class() {
        return this.f1063break;
    }

    /* renamed from: const  reason: not valid java name */
    public Double m1212const() {
        return this.f1070final;
    }

    /* renamed from: do  reason: not valid java name */
    public Double m1213do() {
        return this.f1068do;
    }

    /* renamed from: else  reason: not valid java name */
    public Double m1214else() {
        return this.f1073if;
    }

    /* renamed from: final  reason: not valid java name */
    public Double m1215final() {
        return this.f1066class;
    }

    /* renamed from: for  reason: not valid java name */
    public Double m1216for() {
        return this.f1065catch;
    }

    /* renamed from: goto  reason: not valid java name */
    public Double m1217goto() {
        return this.f1081try;
    }

    /* renamed from: if  reason: not valid java name */
    public Double m1218if() {
        return this.f1064case;
    }

    /* renamed from: import  reason: not valid java name */
    public Double m1219import() {
        return this.f1074import;
    }

    /* renamed from: native  reason: not valid java name */
    public Double m1220native() {
        return this.f1082while;
    }

    /* renamed from: new  reason: not valid java name */
    public Double m1221new() {
        return this.f1067const;
    }

    /* renamed from: public  reason: not valid java name */
    public Double m1222public() {
        return this.f1076new;
    }

    /* renamed from: super  reason: not valid java name */
    public Double m1223super() {
        return this.f1077public;
    }

    /* renamed from: this  reason: not valid java name */
    public Double m1224this() {
        return this.f1080throw;
    }

    /* renamed from: throw  reason: not valid java name */
    public Double m1225throw() {
        return this.f1079this;
    }

    public String toString() {
        return "EXIFData{aperture=" + this.f1068do + ", exposureTime=" + this.f1073if + ", iso=" + this.f1071for + ", fNumber=" + this.f1076new + ", focalLength=" + this.f1081try + ", brightness=" + this.f1064case + ", subjectDistance=" + this.f1069else + ", exposureBias=" + this.f1072goto + ", subjectArea=" + this.f1079this + ", meteringMode=" + this.f1063break + ", colorSpace=" + this.f1065catch + ", sensingMethod=" + this.f1066class + ", componentsConfiguration=" + this.f1067const + ", saturation=" + this.f1070final + ", contrast=" + this.f1078super + ", gainControl=" + this.f1080throw + ", whiteBalance=" + this.f1082while + ", subjectDistanceRange=" + this.f1074import + ", maxApertureValue=" + this.f1075native + ", spatialFrequencyResponse=" + this.f1077public + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public Double m1226try() {
        return this.f1078super;
    }

    /* renamed from: while  reason: not valid java name */
    public Double m1227while() {
        return this.f1069else;
    }

    public Cthis(a aVar) {
        a aVar2 = aVar;
        String g11 = aVar2.g("ApertureValue");
        String g12 = aVar2.g("FNumber");
        String g13 = aVar2.g("ExposureTime");
        String g14 = aVar2.g("ISOSpeedRatings");
        String g15 = aVar2.g("BrightnessValue");
        String g16 = aVar2.g("FocalLength");
        String g17 = aVar2.g("SubjectDistance");
        String g18 = aVar2.g("ExposureBiasValue");
        String g19 = aVar2.g("SubjectArea");
        String g21 = aVar2.g("MeteringMode");
        String g22 = aVar2.g("ColorSpace");
        String g23 = aVar2.g("SensingMethod");
        String g24 = aVar2.g("ComponentsConfiguration");
        String g25 = aVar2.g("Saturation");
        String g26 = aVar2.g("Contrast");
        String g27 = aVar2.g("GainControl");
        String g28 = aVar2.g("WhiteBalance");
        String g29 = aVar2.g("SubjectDistanceRange");
        String g31 = aVar2.g("MaxApertureValue");
        String g32 = aVar2.g("SpatialFrequencyResponse");
        Double d11 = Celse.m1192do(g11);
        Double d12 = Celse.m1192do(g12);
        this.f1068do = (Double) Cimport.m1015do(d11, d12);
        this.f1073if = Celse.m1192do(g13);
        this.f1071for = Celse.m1192do(g14);
        this.f1076new = (Double) Cimport.m1015do(d12, d11);
        this.f1064case = Celse.m1192do(g15);
        this.f1081try = Celse.m1192do(g16);
        this.f1069else = Celse.m1192do(g17);
        this.f1072goto = Celse.m1192do(g18);
        this.f1079this = Celse.m1192do(g19);
        this.f1063break = Celse.m1192do(g21);
        this.f1065catch = Celse.m1192do(g22);
        this.f1066class = Celse.m1192do(g23);
        this.f1067const = Celse.m1192do(g24);
        this.f1070final = Celse.m1192do(g25);
        this.f1078super = Celse.m1192do(g26);
        this.f1080throw = Celse.m1192do(g27);
        this.f1082while = Celse.m1192do(g28);
        this.f1074import = Celse.m1192do(g29);
        this.f1075native = Celse.m1192do(g31);
        this.f1077public = Celse.m1192do(g32);
    }
}
