package com.huobi.index.bean;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.ArrayList;

public class IndexContract implements Serializable {
    @SerializedName("elems")
    private ArrayList<ElemsDTO> elems;

    public static class ElemsDTO {
        @SerializedName("elem")

        /* renamed from: a  reason: collision with root package name */
        public String f73178a;
        @SerializedName("recom_base_info")

        /* renamed from: b  reason: collision with root package name */
        public String f73179b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f73180c = false;

        public static class RecomBaseInfoDTO {
        }

        public String a() {
            return this.f73178a;
        }

        public String b() {
            return this.f73179b;
        }
    }

    public ArrayList<ElemsDTO> getElems() {
        return this.elems;
    }

    public void setElems(ArrayList<ElemsDTO> arrayList) {
        this.elems = arrayList;
    }
}
