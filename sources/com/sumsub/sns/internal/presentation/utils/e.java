package com.sumsub.sns.internal.presentation.utils;

import com.sumsub.sns.internal.core.data.model.FieldName;
import com.sumsub.sns.internal.core.data.model.g;
import java.util.List;
import java.util.Map;

public final class e {

    public /* synthetic */ class a {

        /* renamed from: a  reason: collision with root package name */
        public static final /* synthetic */ int[] f36442a;

        static {
            int[] iArr = new int[FieldName.values().length];
            iArr[FieldName.firstName.ordinal()] = 1;
            iArr[FieldName.lastName.ordinal()] = 2;
            iArr[FieldName.middleName.ordinal()] = 3;
            iArr[FieldName.tin.ordinal()] = 4;
            iArr[FieldName.phone.ordinal()] = 5;
            iArr[FieldName.countryOfBirth.ordinal()] = 6;
            iArr[FieldName.stateOfBirth.ordinal()] = 7;
            iArr[FieldName.placeOfBirth.ordinal()] = 8;
            iArr[FieldName.legalName.ordinal()] = 9;
            iArr[FieldName.gender.ordinal()] = 10;
            iArr[FieldName.nationality.ordinal()] = 11;
            iArr[FieldName.dob.ordinal()] = 12;
            iArr[FieldName.email.ordinal()] = 13;
            iArr[FieldName.buildingNumber.ordinal()] = 14;
            iArr[FieldName.flatNumber.ordinal()] = 15;
            iArr[FieldName.postCode.ordinal()] = 16;
            iArr[FieldName.state.ordinal()] = 17;
            iArr[FieldName.street.ordinal()] = 18;
            iArr[FieldName.subStreet.ordinal()] = 19;
            iArr[FieldName.town.ordinal()] = 20;
            f36442a = iArr;
        }
    }

    public static final String a(g gVar, FieldName fieldName) {
        List<Map<String, String>> n11;
        Map map;
        switch (fieldName == null ? -1 : a.f36442a[fieldName.ordinal()]) {
            case 1:
                g.a C = gVar.C();
                if (C != null) {
                    return C.r();
                }
                break;
            case 2:
                g.a C2 = gVar.C();
                if (C2 != null) {
                    return C2.t();
                }
                break;
            case 3:
                g.a C3 = gVar.C();
                if (C3 != null) {
                    return C3.v();
                }
                break;
            case 4:
                g.a C4 = gVar.C();
                if (C4 != null) {
                    return C4.z();
                }
                break;
            case 5:
                return gVar.G();
            case 6:
                g.a C5 = gVar.C();
                if (C5 != null) {
                    return C5.p();
                }
                break;
            case 7:
                g.a C6 = gVar.C();
                if (C6 != null) {
                    return C6.y();
                }
                break;
            case 8:
                g.a C7 = gVar.C();
                if (C7 != null) {
                    return C7.x();
                }
                break;
            case 9:
                g.a C8 = gVar.C();
                if (C8 != null) {
                    return C8.u();
                }
                break;
            case 10:
                g.a C9 = gVar.C();
                if (C9 != null) {
                    return C9.s();
                }
                break;
            case 11:
                g.a C10 = gVar.C();
                if (C10 != null) {
                    return C10.w();
                }
                break;
            case 12:
                g.a C11 = gVar.C();
                if (C11 != null) {
                    return C11.q();
                }
                break;
            case 13:
                return gVar.x();
            case 14:
            case 15:
            case 16:
            case 17:
            case 18:
            case 19:
            case 20:
                g.a C12 = gVar.C();
                if (!(C12 == null || (n11 = C12.n()) == null || (map = (Map) CollectionsKt___CollectionsKt.c0(n11)) == null)) {
                    return (String) map.get(fieldName.getValue());
                }
        }
        return null;
    }
}
