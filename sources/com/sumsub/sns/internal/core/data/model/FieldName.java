package com.sumsub.sns.internal.core.data.model;

import com.facebook.appevents.UserDataStore;
import com.facebook.places.model.PlaceFields;
import kotlin.Metadata;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import kotlinx.serialization.b;
import kotlinx.serialization.descriptors.SerialDescriptorsKt;
import kotlinx.serialization.descriptors.e;
import kotlinx.serialization.encoding.c;
import kotlinx.serialization.encoding.d;
import kotlinx.serialization.f;

@f(with = a.C0331a.class)
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\u000e\n\u0002\b)\b\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\fB\u0011\b\u0002\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\t\u0010\nR\"\u0010\u0003\u001a\u00020\u00028\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011j\u0002\b\u0012j\u0002\b\u0013j\u0002\b\u0014j\u0002\b\u0015j\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001bj\u0002\b\u001cj\u0002\b\u001dj\u0002\b\u001ej\u0002\b\u001fj\u0002\b j\u0002\b!j\u0002\b\"j\u0002\b#j\u0002\b$j\u0002\b%j\u0002\b&j\u0002\b'j\u0002\b(j\u0002\b)j\u0002\b*¨\u0006+"}, d2 = {"Lcom/sumsub/sns/internal/core/data/model/FieldName;", "", "", "value", "Ljava/lang/String;", "getValue", "()Ljava/lang/String;", "setValue", "(Ljava/lang/String;)V", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "Companion", "a", "firstName", "lastName", "middleName", "email", "phone", "countryOfBirth", "stateOfBirth", "dob", "placeOfBirth", "legalName", "gender", "nationality", "country", "taxResidenceCountry", "street", "subStreet", "buildingNumber", "flatNumber", "town", "state", "postCode", "transactionAmount", "incomeSourceType", "investmentKnowledgeLevel", "annualIncome", "netWorth", "tin", "number", "issuedDate", "other", "idensic-mobile-sdk-aar_release"}, k = 1, mv = {1, 7, 1})
public enum FieldName {
    firstName("firstName"),
    lastName("lastName"),
    middleName("middleName"),
    email("email"),
    phone(PlaceFields.PHONE),
    countryOfBirth("countryOfBirth"),
    stateOfBirth("stateOfBirth"),
    dob("dob"),
    placeOfBirth("placeOfBirth"),
    legalName("legalName"),
    gender("gender"),
    nationality("nationality"),
    country(UserDataStore.COUNTRY),
    taxResidenceCountry("taxResidenceCountry"),
    street("street"),
    subStreet("subStreet"),
    buildingNumber("buildingNumber"),
    flatNumber("flatNumber"),
    town("town"),
    state("state"),
    postCode("postCode"),
    transactionAmount("transactionAmount"),
    incomeSourceType("incomeSourceType"),
    investmentKnowledgeLevel("investmentKnowledgeLevel"),
    annualIncome("annualIncome"),
    netWorth("netWorth"),
    tin("tin"),
    number("number"),
    issuedDate("issuedDate"),
    other("");
    
    public static final a Companion = null;
    private String value;

    public static final class a {

        /* renamed from: com.sumsub.sns.internal.core.data.model.FieldName$a$a  reason: collision with other inner class name */
        public static final class C0331a implements b<FieldName> {

            /* renamed from: a  reason: collision with root package name */
            public static final C0331a f32361a = null;

            /* renamed from: b  reason: collision with root package name */
            public static final kotlinx.serialization.descriptors.f f32362b = null;

            static {
                f32361a = new C0331a();
                f32362b = SerialDescriptorsKt.a("FieldName", e.i.f57638a);
            }

            /* renamed from: a */
            public void serialize(d dVar, FieldName fieldName) {
                dVar.v(fieldName.getValue());
            }

            public kotlinx.serialization.descriptors.f getDescriptor() {
                return f32362b;
            }

            /* renamed from: a */
            public FieldName deserialize(c cVar) {
                FieldName fieldName;
                String q11 = cVar.q();
                FieldName[] values = FieldName.values();
                int length = values.length;
                int i11 = 0;
                while (true) {
                    if (i11 >= length) {
                        fieldName = null;
                        break;
                    }
                    fieldName = values[i11];
                    if (x.b(fieldName.getValue(), q11)) {
                        break;
                    }
                    i11++;
                }
                if (fieldName != null) {
                    return fieldName;
                }
                FieldName fieldName2 = FieldName.other;
                fieldName2.setValue(q11);
                return fieldName2;
            }
        }

        public /* synthetic */ a(r rVar) {
            this();
        }

        public final FieldName a(String str) {
            FieldName fieldName;
            FieldName[] values = FieldName.values();
            int length = values.length;
            int i11 = 0;
            while (true) {
                if (i11 >= length) {
                    fieldName = null;
                    break;
                }
                fieldName = values[i11];
                if (x.b(fieldName.getValue(), str)) {
                    break;
                }
                i11++;
            }
            if (fieldName == null) {
                fieldName = FieldName.other;
                if (str == null) {
                    str = "";
                }
                fieldName.setValue(str);
            }
            return fieldName;
        }

        public final b<FieldName> serializer() {
            return C0331a.f32361a;
        }

        public a() {
        }
    }

    /* access modifiers changed from: public */
    static {
        Companion = new a((r) null);
    }

    private FieldName(String str) {
        this.value = str;
    }

    public final String getValue() {
        return this.value;
    }

    public final void setValue(String str) {
        this.value = str;
    }
}
