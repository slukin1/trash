package com.iproov.sdk.core;

import com.iproov.sdk.p017implements.Cnative;
import com.iproov.sdk.p019interface.Cif;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.iproov.sdk.core.else  reason: invalid class name */
public class Celse {

    /* renamed from: while  reason: not valid java name */
    public static final double[] f284while = {1.0d, 1.0d, 1.3d};

    /* renamed from: break  reason: not valid java name */
    private final int f285break;

    /* renamed from: case  reason: not valid java name */
    private final double f286case;

    /* renamed from: catch  reason: not valid java name */
    private final double f287catch;

    /* renamed from: class  reason: not valid java name */
    private final double f288class;

    /* renamed from: const  reason: not valid java name */
    private final double f289const;

    /* renamed from: do  reason: not valid java name */
    private final double f290do;

    /* renamed from: else  reason: not valid java name */
    private final double f291else;

    /* renamed from: final  reason: not valid java name */
    private final double f292final;

    /* renamed from: for  reason: not valid java name */
    private final double f293for;

    /* renamed from: goto  reason: not valid java name */
    private final double f294goto;

    /* renamed from: if  reason: not valid java name */
    private final int f295if;

    /* renamed from: new  reason: not valid java name */
    private final double f296new;

    /* renamed from: super  reason: not valid java name */
    private final boolean f297super;

    /* renamed from: this  reason: not valid java name */
    private final int f298this;

    /* renamed from: throw  reason: not valid java name */
    private final int f299throw;

    /* renamed from: try  reason: not valid java name */
    private final double[] f300try;

    public Celse(double d11, int i11, double d12, double d13, double[] dArr, double d14, double d15, double d16, int i12, int i13, double d17, double d18, double d19, double d21, boolean z11, int i14) {
        this.f290do = d11;
        this.f295if = i11;
        this.f293for = d12;
        this.f296new = d13;
        this.f300try = dArr;
        this.f286case = d14;
        this.f291else = d15;
        this.f294goto = d16;
        this.f298this = i12;
        this.f285break = i13;
        this.f287catch = d17;
        this.f288class = d18;
        this.f289const = d19;
        this.f292final = d21;
        this.f297super = z11;
        this.f299throw = i14;
    }

    /* renamed from: do  reason: not valid java name */
    public static Celse m365do(Celse elseR, Cif ifVar) {
        Cif ifVar2 = ifVar;
        return new Celse((double) ifVar2.m1117goto(elseR.m366break()), ifVar2.m1120if(elseR.m372else()), (double) ifVar2.m1102case((float) elseR.m377new()), (double) ifVar2.m1114for((float) elseR.m367case()), ifVar2.m1111do(elseR.f300try), (double) ifVar2.m1100break((float) elseR.m373final()), (double) ifVar2.m1125this((float) elseR.m381try()), (double) ifVar2.m1122new((float) elseR.m379this()), ifVar2.m1115for(elseR.m375goto()), ifVar2.m1128try(elseR.m369class()), (double) ifVar2.m1119if((float) elseR.m374for()), (double) ifVar2.m1112else((float) elseR.m370const()), (double) ifVar2.m1127try((float) elseR.m368catch()), (double) ifVar2.m1108do((float) elseR.m371do()), ifVar2.m1110do(elseR.m380throw()), ifVar2.m1109do(elseR.m376if()));
    }

    /* renamed from: break  reason: not valid java name */
    public float m366break() {
        return (float) this.f290do;
    }

    /* renamed from: case  reason: not valid java name */
    public double m367case() {
        return this.f296new;
    }

    /* renamed from: catch  reason: not valid java name */
    public double m368catch() {
        return this.f289const;
    }

    /* renamed from: class  reason: not valid java name */
    public int m369class() {
        return this.f285break;
    }

    /* renamed from: const  reason: not valid java name */
    public double m370const() {
        return this.f288class;
    }

    /* renamed from: else  reason: not valid java name */
    public int m372else() {
        return this.f295if;
    }

    /* renamed from: final  reason: not valid java name */
    public double m373final() {
        return this.f286case;
    }

    /* renamed from: for  reason: not valid java name */
    public double m374for() {
        return this.f287catch;
    }

    /* renamed from: goto  reason: not valid java name */
    public int m375goto() {
        return this.f298this;
    }

    /* renamed from: if  reason: not valid java name */
    public int m376if() {
        return this.f299throw;
    }

    /* renamed from: new  reason: not valid java name */
    public double m377new() {
        return this.f293for;
    }

    /* renamed from: super  reason: not valid java name */
    public Cnative m378super() {
        return new Cnative(this.f300try);
    }

    /* renamed from: this  reason: not valid java name */
    public double m379this() {
        return this.f294goto;
    }

    /* renamed from: throw  reason: not valid java name */
    public boolean m380throw() {
        return this.f297super;
    }

    public String toString() {
        return "LivenessParameters{locoUpdateInterval=" + this.f290do + ", frameCount=" + this.f295if + ", finalDistanceFromTarget=" + this.f293for + ", finalSizeRatio=" + this.f296new + ", weightsVector=" + Arrays.toString(this.f300try) + ", vectorProgressScale=" + this.f286case + ", finalSizeErrorFromTarget=" + this.f291else + ", largeFaceThreshold=" + this.f294goto + ", frameSelectionWindow=" + this.f298this + ", maximumMotionUpdatesPerCheckpoint=" + this.f285break + ", faceOffset=" + this.f287catch + ", minLargerTarget=" + this.f288class + ", maxSmallerTarget=" + this.f289const + ", cropRectScale=" + this.f292final + ", enableLongerLAPause=" + this.f297super + ", durationOfPause=" + this.f299throw + '}';
    }

    /* renamed from: try  reason: not valid java name */
    public double m381try() {
        return this.f291else;
    }

    public Celse(JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = jSONObject;
        if (jSONObject2 == null) {
            this.f290do = 0.05d;
            this.f295if = 10;
            this.f293for = 0.1d;
            this.f296new = 1.25d;
            this.f300try = f284while;
            this.f286case = 0.8d;
            this.f291else = 0.15d;
            this.f294goto = 0.77d;
            this.f298this = 5;
            this.f285break = 50;
            this.f287catch = 0.2d;
            this.f288class = 0.6d;
            this.f289const = 0.9d;
            this.f292final = 0.9d;
            this.f297super = false;
            this.f299throw = 1000;
            return;
        }
        this.f290do = jSONObject2.optDouble("lui", 0.05d);
        this.f295if = jSONObject2.optInt("frc", 10);
        this.f293for = jSONObject2.optDouble("fdt", 0.1d);
        this.f296new = jSONObject2.optDouble("fsr", 1.25d);
        JSONArray optJSONArray = jSONObject2.optJSONArray("wgv");
        if (optJSONArray == null) {
            this.f300try = f284while;
        } else {
            this.f300try = new double[]{optJSONArray.getDouble(0), optJSONArray.getDouble(1), optJSONArray.getDouble(2)};
        }
        this.f286case = jSONObject2.optDouble("vps", 0.8d);
        this.f291else = jSONObject2.optDouble("set", 0.15d);
        this.f294goto = jSONObject2.optDouble("lft", 0.77d);
        this.f298this = jSONObject2.optInt("frw", 5);
        this.f285break = jSONObject2.optInt("mmx", 50);
        this.f287catch = (double) ((float) jSONObject2.optDouble("fof", 0.2d));
        this.f288class = jSONObject2.optDouble("mlt", 0.6d);
        this.f289const = jSONObject2.optDouble("mst", 0.9d);
        this.f292final = jSONObject2.optDouble("crs", 0.9d);
        this.f297super = jSONObject2.optBoolean("elp", false);
        this.f299throw = jSONObject2.optInt("dop", 1000);
    }

    /* renamed from: do  reason: not valid java name */
    public double m371do() {
        return this.f292final;
    }
}
