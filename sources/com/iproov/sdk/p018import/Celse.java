package com.iproov.sdk.p018import;

import android.opengl.GLES20;
import com.iproov.sdk.p029super.Cdo;
import com.iproov.sdk.p029super.Cfor;
import java.util.ArrayList;
import java.util.Iterator;

/* renamed from: com.iproov.sdk.import.else  reason: invalid class name and invalid package */
public class Celse extends Cdo {

    /* renamed from: default  reason: not valid java name */
    private Cfor f967default;

    /* renamed from: static  reason: not valid java name */
    private Cconst f968static;

    /* renamed from: switch  reason: not valid java name */
    private Cconst f969switch;

    /* renamed from: throws  reason: not valid java name */
    private Cfor f970throws;

    public Celse(float[] fArr) {
        super(fArr);
    }

    /* renamed from: if  reason: not valid java name */
    private void m1076if(Cdo doVar, int i11, int i12, int i13, int i14, Cfor forR) {
        m1864do(doVar.m1069do(), new int[]{i11, i12}, new int[]{i13, i14}, new int[][]{new int[]{i11, i12}, new int[]{i11, i12}});
        doVar.m1071for();
        forR.m1872do();
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        forR.m1871case();
        GLES20.glClear(16384);
    }

    /* renamed from: new  reason: not valid java name */
    private void m1077new(int i11, int i12) {
        Cfor forR = this.f970throws;
        if (!(forR != null && forR.m1873for() == i12 && this.f970throws.m1876try() == i11)) {
            this.f970throws = new Cfor(i11, i12, 33988);
        }
        Cfor forR2 = this.f967default;
        if (forR2 == null || forR2.m1873for() != i12 || this.f967default.m1876try() != i11) {
            this.f967default = new Cfor(i11, i12, 33989);
        }
    }

    /* renamed from: this  reason: not valid java name */
    private synchronized Cconst m1078this() {
        Cconst constR = this.f969switch;
        if (constR != null) {
            this.f968static = constR;
            this.f969switch = null;
        }
        return this.f968static;
    }

    /* renamed from: do  reason: not valid java name */
    public synchronized void m1080do(Cconst constR) {
        this.f969switch = constR;
    }

    /* renamed from: do  reason: not valid java name */
    public void m1079do(int i11, int i12, int i13) {
        int i14;
        Cfor forR;
        int i15 = i12;
        int i16 = i13;
        ArrayList<Cdo> arrayList = m1078this().f965do;
        m1077new(i15, i16);
        int size = arrayList.size();
        Iterator<Cdo> it2 = arrayList.iterator();
        Cfor forR2 = null;
        int i17 = 0;
        while (it2.hasNext()) {
            Cdo next = it2.next();
            int i18 = i17 + 1;
            if (i18 == 1) {
                i14 = i11;
                forR = this.f970throws;
            } else {
                Cfor forR3 = this.f970throws;
                if (forR2 == forR3) {
                    forR = this.f967default;
                    i14 = forR3.m1875new();
                } else {
                    i14 = this.f967default.m1875new();
                    forR = forR3;
                }
            }
            if (i18 == size) {
                if (size == 1) {
                    m1074do(next, i12, i13, i14, i11, forR);
                }
                m1073do(next, i15, i16, i14);
                return;
            }
            m1074do(next, i12, i13, i14, i11, forR);
            i17 = i18;
            forR2 = forR;
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m1074do(Cdo doVar, int i11, int i12, int i13, int i14, Cfor forR) {
        if (!doVar.m1072if()) {
            m1075do(doVar, i11, i12, i13, forR);
        } else {
            m1076if(doVar, i11, i12, i13, i14, forR);
        }
    }

    /* renamed from: do  reason: not valid java name */
    private void m1075do(Cdo doVar, int i11, int i12, int i13, Cfor forR) {
        m1864do(doVar.m1069do(), new int[]{i11, i12}, new int[]{i13}, new int[][]{new int[]{i11, i12}, new int[]{i11, i12}});
        doVar.m1071for();
        forR.m1872do();
        GLES20.glClear(16384);
        GLES20.glDrawArrays(5, 0, 4);
        forR.m1871case();
        GLES20.glClear(16384);
    }

    /* renamed from: do  reason: not valid java name */
    private void m1073do(Cdo doVar, int i11, int i12, int i13) {
        m1864do(doVar.m1069do(), new int[]{i11, i12}, new int[]{i13}, new int[][]{new int[]{i11, i12}, new int[]{i11, i12}});
        doVar.m1071for();
        GLES20.glDrawArrays(5, 0, 4);
    }
}
