package com.jumio.core.models;

import cn.sharesdk.framework.InnerShareParams;
import com.facebook.appevents.UserDataStore;
import com.jumio.commons.PersistWith;
import com.jumio.core.data.country.Country;
import com.jumio.core.enums.JumioGender;
import com.jumio.core.model.StaticModel;
import com.jumio.sdk.document.JumioDocumentType;
import com.jumio.sdk.result.JumioImageData;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.jvm.internal.r;
import kotlin.jvm.internal.x;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@PersistWith("DocumentDataModel")
public class DocumentDataModel implements StaticModel {

    /* renamed from: a  reason: collision with root package name */
    public String f39283a;

    /* renamed from: b  reason: collision with root package name */
    public JumioDocumentType f39284b;

    /* renamed from: c  reason: collision with root package name */
    public String f39285c;

    /* renamed from: d  reason: collision with root package name */
    public String f39286d;

    /* renamed from: e  reason: collision with root package name */
    public Date f39287e;

    /* renamed from: f  reason: collision with root package name */
    public Date f39288f;

    /* renamed from: g  reason: collision with root package name */
    public String f39289g;

    /* renamed from: h  reason: collision with root package name */
    public String f39290h;

    /* renamed from: i  reason: collision with root package name */
    public String f39291i;

    /* renamed from: j  reason: collision with root package name */
    public String f39292j;

    /* renamed from: k  reason: collision with root package name */
    public Date f39293k;

    /* renamed from: l  reason: collision with root package name */
    public JumioGender f39294l;

    /* renamed from: m  reason: collision with root package name */
    public String f39295m;

    /* renamed from: n  reason: collision with root package name */
    public String f39296n;

    /* renamed from: o  reason: collision with root package name */
    public String f39297o;

    /* renamed from: p  reason: collision with root package name */
    public String f39298p;

    /* renamed from: q  reason: collision with root package name */
    public String f39299q;

    /* renamed from: r  reason: collision with root package name */
    public String f39300r;

    /* renamed from: s  reason: collision with root package name */
    public String f39301s;

    /* renamed from: t  reason: collision with root package name */
    public String f39302t;

    /* renamed from: u  reason: collision with root package name */
    public JumioImageData f39303u;

    public final void appendValue(JSONObject jSONObject, String str, String str2) throws JSONException {
        if (!(str2 == null || str2.length() == 0)) {
            jSONObject.put(str, str2);
        }
    }

    public boolean checkCountryCode(String str) {
        if (str != null) {
            if (!(str.length() == 0)) {
                return !StringsKt__StringsJVMKt.w(new Country(str, false, 2, (r) null).getName(), str, true);
            }
        }
        return false;
    }

    public void fillRequest(JSONObject jSONObject, ScanPartModel scanPartModel) throws JSONException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        simpleDateFormat.setTimeZone(TimeZone.getTimeZone(UtcDates.UTC));
        appendValue(jSONObject, "firstName", this.f39291i);
        appendValue(jSONObject, "lastName", getLastName());
        appendValue(jSONObject, "personalNumber", this.f39286d);
        appendValue(jSONObject, "number", this.f39285c);
        Date date = this.f39287e;
        String str = null;
        appendValue(jSONObject, "issuingDate", date == null ? null : simpleDateFormat.format(date));
        Date date2 = this.f39293k;
        appendValue(jSONObject, "dob", date2 == null ? null : simpleDateFormat.format(date2));
        Date date3 = this.f39288f;
        appendValue(jSONObject, "expiry", date3 == null ? null : simpleDateFormat.format(date3));
        appendValue(jSONObject, UserDataStore.COUNTRY, this.f39295m);
        appendValue(jSONObject, "optionalData1", this.f39300r);
        appendValue(jSONObject, "optionalData2", this.f39301s);
        appendValue(jSONObject, "extractionSide", scanPartModel.getCredentialPart().name());
        JSONObject jSONObject2 = new JSONObject();
        appendValue(jSONObject2, "city", this.f39297o);
        appendValue(jSONObject2, "subdivision", this.f39298p);
        String str2 = this.f39296n;
        if (str2 != null) {
            int length = str2.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str2.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str = str2.subSequence(i11, length + 1).toString();
            if (str.length() > 100) {
                str = str.substring(0, 100);
            }
        }
        appendValue(jSONObject2, "addressLine", str);
        appendValue(jSONObject2, "postCode", this.f39299q);
        jSONObject.put(InnerShareParams.ADDRESS, jSONObject2);
    }

    public String fixGermanCountryCode(String str) {
        return (x.b("D", str) || x.b("D<<", str)) ? "DEU" : str;
    }

    public final String getAddressLine() {
        return this.f39296n;
    }

    public final String getCity() {
        return this.f39297o;
    }

    public final Date getDob() {
        return this.f39293k;
    }

    public final Date getExpiryDate() {
        return this.f39288f;
    }

    public final String getFirstName() {
        return this.f39291i;
    }

    public final JumioGender getGender() {
        return this.f39294l;
    }

    public final String getIdNumber() {
        return this.f39285c;
    }

    public final JumioImageData getImageData() {
        return this.f39303u;
    }

    public final String getIssuingCountry() {
        return this.f39289g;
    }

    public final Date getIssuingDate() {
        return this.f39287e;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String getLastName() {
        /*
            r6 = this;
            java.lang.String r0 = r6.f39292j
            if (r0 == 0) goto L_0x003e
            int r1 = r0.length()
            r2 = 1
            r3 = 0
            if (r1 <= 0) goto L_0x000e
            r1 = r2
            goto L_0x000f
        L_0x000e:
            r1 = r3
        L_0x000f:
            if (r1 == 0) goto L_0x003a
            java.lang.String r1 = r6.f39290h
            if (r1 == 0) goto L_0x001e
            r4 = 2
            r5 = 0
            boolean r0 = kotlin.text.StringsKt__StringsJVMKt.v(r1, r0, r3, r4, r5)
            if (r0 != 0) goto L_0x001e
            goto L_0x001f
        L_0x001e:
            r2 = r3
        L_0x001f:
            if (r2 == 0) goto L_0x003a
            java.lang.String r0 = r6.f39290h
            java.lang.String r1 = r6.f39292j
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            r2.append(r0)
            java.lang.String r0 = " "
            r2.append(r0)
            r2.append(r1)
            java.lang.String r0 = r2.toString()
            goto L_0x003c
        L_0x003a:
            java.lang.String r0 = r6.f39290h
        L_0x003c:
            if (r0 != 0) goto L_0x0040
        L_0x003e:
            java.lang.String r0 = r6.f39290h
        L_0x0040:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DocumentDataModel.getLastName():java.lang.String");
    }

    public final String getNameSuffix() {
        return this.f39292j;
    }

    public final String getOptData1() {
        return this.f39300r;
    }

    public final String getOptData2() {
        return this.f39301s;
    }

    public String getOptionalData1() {
        return this.f39300r;
    }

    public String getOptionalData2() {
        return this.f39301s;
    }

    public final String getOriginatingCountry() {
        return this.f39295m;
    }

    public final String getPersonalNumber() {
        return this.f39286d;
    }

    public final String getPlaceOfBirth() {
        return this.f39302t;
    }

    public final String getPostCode() {
        return this.f39299q;
    }

    public final String getSelectedCountry() {
        return this.f39283a;
    }

    public final JumioDocumentType getSelectedDocumentType() {
        return this.f39284b;
    }

    public final String getSubdivision() {
        return this.f39298p;
    }

    public final void setAddressLine(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 255) {
                str2 = str2.substring(0, 255);
            }
        }
        this.f39296n = str2;
    }

    public final void setCity(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 64) {
                str2 = str2.substring(0, 64);
            }
        }
        this.f39297o = str2;
    }

    public final void setDob(Date date) {
        this.f39293k = date;
    }

    public final void setExpiryDate(Date date) {
        this.f39288f = date;
    }

    public final void setFirstName(String str) {
        this.f39291i = str;
    }

    public void setFirstNames(String... strArr) {
        String str;
        StringBuilder sb2 = new StringBuilder();
        for (String str2 : strArr) {
            if (str2 != null) {
                sb2.append(str2);
                sb2.append(" ");
            }
        }
        String sb3 = sb2.toString();
        if (sb3 == null) {
            str = null;
        } else {
            int length = sb3.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(sb3.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str = sb3.subSequence(i11, length + 1).toString();
            if (str.length() > 100) {
                str = str.substring(0, 100);
            }
        }
        this.f39291i = str;
    }

    public final void setGender(JumioGender jumioGender) {
        this.f39294l = jumioGender;
    }

    public final void setIdNumber(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 100) {
                str2 = str2.substring(0, 100);
            }
        }
        this.f39285c = str2;
    }

    public final void setImageData(JumioImageData jumioImageData) {
        this.f39303u = jumioImageData;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (java.util.regex.Pattern.compile("[A-Z]{3}").matcher(r9).matches() == false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setIssuingCountry(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r9 = r8.fixGermanCountryCode(r9)
            r8.f39289g = r9
            r0 = 0
            if (r9 != 0) goto L_0x000a
            goto L_0x005c
        L_0x000a:
            int r1 = r9.length()
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0013:
            if (r4 > r1) goto L_0x0038
            if (r5 != 0) goto L_0x0019
            r6 = r4
            goto L_0x001a
        L_0x0019:
            r6 = r1
        L_0x001a:
            char r6 = r9.charAt(r6)
            r7 = 32
            int r6 = kotlin.jvm.internal.x.c(r6, r7)
            if (r6 > 0) goto L_0x0028
            r6 = r2
            goto L_0x0029
        L_0x0028:
            r6 = r3
        L_0x0029:
            if (r5 != 0) goto L_0x0032
            if (r6 != 0) goto L_0x002f
            r5 = r2
            goto L_0x0013
        L_0x002f:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0032:
            if (r6 != 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            int r1 = r1 + -1
            goto L_0x0013
        L_0x0038:
            int r1 = r1 + r2
            java.lang.CharSequence r9 = r9.subSequence(r4, r1)
            java.lang.String r9 = r9.toString()
            int r1 = r9.length()
            r2 = 3
            if (r1 <= r2) goto L_0x004c
            java.lang.String r9 = r9.substring(r3, r2)
        L_0x004c:
            java.lang.String r1 = "[A-Z]{3}"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x005d
        L_0x005c:
            r9 = r0
        L_0x005d:
            r8.f39289g = r9
            boolean r9 = r8.checkCountryCode(r9)
            if (r9 != 0) goto L_0x0067
            r8.f39289g = r0
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DocumentDataModel.setIssuingCountry(java.lang.String):void");
    }

    public final void setIssuingDate(Date date) {
        this.f39287e = date;
    }

    public final void setLastName(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 100) {
                str2 = str2.substring(0, 100);
            }
        }
        this.f39290h = str2;
    }

    public final void setNameSuffix(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 100) {
                str2 = str2.substring(0, 100);
            }
        }
        this.f39292j = str2;
    }

    public final void setOptData1(String str) {
        this.f39300r = str;
    }

    public final void setOptData2(String str) {
        this.f39301s = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (java.util.regex.Pattern.compile("^[A-Z0-9]*$").matcher(r8).matches() == false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOptionalData1(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            goto L_0x0056
        L_0x0003:
            int r0 = r8.length()
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
            r4 = r3
        L_0x000c:
            if (r3 > r0) goto L_0x0031
            if (r4 != 0) goto L_0x0012
            r5 = r3
            goto L_0x0013
        L_0x0012:
            r5 = r0
        L_0x0013:
            char r5 = r8.charAt(r5)
            r6 = 32
            int r5 = kotlin.jvm.internal.x.c(r5, r6)
            if (r5 > 0) goto L_0x0021
            r5 = r1
            goto L_0x0022
        L_0x0021:
            r5 = r2
        L_0x0022:
            if (r4 != 0) goto L_0x002b
            if (r5 != 0) goto L_0x0028
            r4 = r1
            goto L_0x000c
        L_0x0028:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x002b:
            if (r5 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            int r0 = r0 + -1
            goto L_0x000c
        L_0x0031:
            int r0 = r0 + r1
            java.lang.CharSequence r8 = r8.subSequence(r3, r0)
            java.lang.String r8 = r8.toString()
            int r0 = r8.length()
            r1 = 50
            if (r0 <= r1) goto L_0x0046
            java.lang.String r8 = r8.substring(r2, r1)
        L_0x0046:
            java.lang.String r0 = "^[A-Z0-9]*$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r8)
            boolean r0 = r0.matches()
            if (r0 != 0) goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            r7.f39300r = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DocumentDataModel.setOptionalData1(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (java.util.regex.Pattern.compile("^[A-Z0-9]*$").matcher(r8).matches() == false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setOptionalData2(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            goto L_0x0056
        L_0x0003:
            int r0 = r8.length()
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
            r4 = r3
        L_0x000c:
            if (r3 > r0) goto L_0x0031
            if (r4 != 0) goto L_0x0012
            r5 = r3
            goto L_0x0013
        L_0x0012:
            r5 = r0
        L_0x0013:
            char r5 = r8.charAt(r5)
            r6 = 32
            int r5 = kotlin.jvm.internal.x.c(r5, r6)
            if (r5 > 0) goto L_0x0021
            r5 = r1
            goto L_0x0022
        L_0x0021:
            r5 = r2
        L_0x0022:
            if (r4 != 0) goto L_0x002b
            if (r5 != 0) goto L_0x0028
            r4 = r1
            goto L_0x000c
        L_0x0028:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x002b:
            if (r5 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            int r0 = r0 + -1
            goto L_0x000c
        L_0x0031:
            int r0 = r0 + r1
            java.lang.CharSequence r8 = r8.subSequence(r3, r0)
            java.lang.String r8 = r8.toString()
            int r0 = r8.length()
            r1 = 50
            if (r0 <= r1) goto L_0x0046
            java.lang.String r8 = r8.substring(r2, r1)
        L_0x0046:
            java.lang.String r0 = "^[A-Z0-9]*$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r8)
            boolean r0 = r0.matches()
            if (r0 != 0) goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            r7.f39301s = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DocumentDataModel.setOptionalData2(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x005a, code lost:
        if (java.util.regex.Pattern.compile("[A-Z]{3}").matcher(r9).matches() == false) goto L_0x005c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setOriginatingCountry(java.lang.String r9) {
        /*
            r8 = this;
            java.lang.String r9 = r8.fixGermanCountryCode(r9)
            r8.f39295m = r9
            r0 = 0
            if (r9 != 0) goto L_0x000a
            goto L_0x005c
        L_0x000a:
            int r1 = r9.length()
            r2 = 1
            int r1 = r1 - r2
            r3 = 0
            r4 = r3
            r5 = r4
        L_0x0013:
            if (r4 > r1) goto L_0x0038
            if (r5 != 0) goto L_0x0019
            r6 = r4
            goto L_0x001a
        L_0x0019:
            r6 = r1
        L_0x001a:
            char r6 = r9.charAt(r6)
            r7 = 32
            int r6 = kotlin.jvm.internal.x.c(r6, r7)
            if (r6 > 0) goto L_0x0028
            r6 = r2
            goto L_0x0029
        L_0x0028:
            r6 = r3
        L_0x0029:
            if (r5 != 0) goto L_0x0032
            if (r6 != 0) goto L_0x002f
            r5 = r2
            goto L_0x0013
        L_0x002f:
            int r4 = r4 + 1
            goto L_0x0013
        L_0x0032:
            if (r6 != 0) goto L_0x0035
            goto L_0x0038
        L_0x0035:
            int r1 = r1 + -1
            goto L_0x0013
        L_0x0038:
            int r1 = r1 + r2
            java.lang.CharSequence r9 = r9.subSequence(r4, r1)
            java.lang.String r9 = r9.toString()
            int r1 = r9.length()
            r2 = 3
            if (r1 <= r2) goto L_0x004c
            java.lang.String r9 = r9.substring(r3, r2)
        L_0x004c:
            java.lang.String r1 = "[A-Z]{3}"
            java.util.regex.Pattern r1 = java.util.regex.Pattern.compile(r1)
            java.util.regex.Matcher r1 = r1.matcher(r9)
            boolean r1 = r1.matches()
            if (r1 != 0) goto L_0x005d
        L_0x005c:
            r9 = r0
        L_0x005d:
            r8.f39295m = r9
            boolean r9 = r8.checkCountryCode(r9)
            if (r9 != 0) goto L_0x0067
            r8.f39295m = r0
        L_0x0067:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DocumentDataModel.setOriginatingCountry(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0054, code lost:
        if (java.util.regex.Pattern.compile("^[A-Z0-9]*$").matcher(r8).matches() == false) goto L_0x0056;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setPersonalNumber(java.lang.String r8) {
        /*
            r7 = this;
            if (r8 != 0) goto L_0x0003
            goto L_0x0056
        L_0x0003:
            int r0 = r8.length()
            r1 = 1
            int r0 = r0 - r1
            r2 = 0
            r3 = r2
            r4 = r3
        L_0x000c:
            if (r3 > r0) goto L_0x0031
            if (r4 != 0) goto L_0x0012
            r5 = r3
            goto L_0x0013
        L_0x0012:
            r5 = r0
        L_0x0013:
            char r5 = r8.charAt(r5)
            r6 = 32
            int r5 = kotlin.jvm.internal.x.c(r5, r6)
            if (r5 > 0) goto L_0x0021
            r5 = r1
            goto L_0x0022
        L_0x0021:
            r5 = r2
        L_0x0022:
            if (r4 != 0) goto L_0x002b
            if (r5 != 0) goto L_0x0028
            r4 = r1
            goto L_0x000c
        L_0x0028:
            int r3 = r3 + 1
            goto L_0x000c
        L_0x002b:
            if (r5 != 0) goto L_0x002e
            goto L_0x0031
        L_0x002e:
            int r0 = r0 + -1
            goto L_0x000c
        L_0x0031:
            int r0 = r0 + r1
            java.lang.CharSequence r8 = r8.subSequence(r3, r0)
            java.lang.String r8 = r8.toString()
            int r0 = r8.length()
            r1 = 14
            if (r0 <= r1) goto L_0x0046
            java.lang.String r8 = r8.substring(r2, r1)
        L_0x0046:
            java.lang.String r0 = "^[A-Z0-9]*$"
            java.util.regex.Pattern r0 = java.util.regex.Pattern.compile(r0)
            java.util.regex.Matcher r0 = r0.matcher(r8)
            boolean r0 = r0.matches()
            if (r0 != 0) goto L_0x0057
        L_0x0056:
            r8 = 0
        L_0x0057:
            r7.f39286d = r8
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.jumio.core.models.DocumentDataModel.setPersonalNumber(java.lang.String):void");
    }

    public final void setPlaceOfBirth(String str) {
        this.f39302t = str;
    }

    public final void setPostCode(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 15) {
                str2 = str2.substring(0, 15);
            }
        }
        this.f39299q = str2;
    }

    public final void setSelectedCountry(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 3) {
                str2 = str2.substring(0, 3);
            }
        }
        this.f39283a = str2;
    }

    public final void setSelectedDocumentType(JumioDocumentType jumioDocumentType) {
        this.f39284b = jumioDocumentType;
    }

    public final void setSubdivision(String str) {
        String str2;
        if (str == null) {
            str2 = null;
        } else {
            int length = str.length() - 1;
            int i11 = 0;
            boolean z11 = false;
            while (i11 <= length) {
                boolean z12 = x.c(str.charAt(!z11 ? i11 : length), 32) <= 0;
                if (!z11) {
                    if (!z12) {
                        z11 = true;
                    } else {
                        i11++;
                    }
                } else if (!z12) {
                    break;
                } else {
                    length--;
                }
            }
            str2 = str.subSequence(i11, length + 1).toString();
            if (str2.length() > 64) {
                str2 = str2.substring(0, 64);
            }
        }
        this.f39298p = str2;
    }

    public final void appendValue(JSONObject jSONObject, String str, JSONArray jSONArray) throws JSONException {
        if (jSONArray != null && jSONArray.length() != 0) {
            jSONObject.put(str, jSONArray);
        }
    }
}
