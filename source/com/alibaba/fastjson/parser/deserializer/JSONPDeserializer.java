package com.alibaba.fastjson.parser.deserializer;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONPObject;
import com.amazonaws.services.s3.model.InstructionFileId;
import f2.a;
import f2.c;
import g2.l;
import java.lang.reflect.Type;

public class JSONPDeserializer implements l {

    /* renamed from: a  reason: collision with root package name */
    public static final JSONPDeserializer f14195a = new JSONPDeserializer();

    public int b() {
        return 0;
    }

    public <T> T e(a aVar, Type type, Object obj) {
        int J;
        c cVar = (c) aVar.t();
        String C = cVar.C(aVar.w());
        cVar.nextToken();
        int J2 = cVar.J();
        if (J2 == 25) {
            String str = C + InstructionFileId.DOT;
            C = str + cVar.C(aVar.w());
            cVar.nextToken();
            J2 = cVar.J();
        }
        T jSONPObject = new JSONPObject(C);
        if (J2 == 10) {
            cVar.nextToken();
            while (true) {
                jSONPObject.b(aVar.z());
                J = cVar.J();
                if (J != 16) {
                    break;
                }
                cVar.nextToken();
            }
            if (J == 11) {
                cVar.nextToken();
                if (cVar.J() == 24) {
                    cVar.nextToken();
                }
                return jSONPObject;
            }
            throw new JSONException("illegal jsonp : " + cVar.t());
        }
        throw new JSONException("illegal jsonp : " + cVar.t());
    }
}
