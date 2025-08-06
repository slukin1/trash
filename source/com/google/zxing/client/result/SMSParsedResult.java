package com.google.zxing.client.result;

public final class SMSParsedResult extends ParsedResult {
    private final String body;
    private final String[] numbers;
    private final String subject;
    private final String[] vias;

    public SMSParsedResult(String str, String str2, String str3, String str4) {
        super(ParsedResultType.SMS);
        this.numbers = new String[]{str};
        this.vias = new String[]{str2};
        this.subject = str3;
        this.body = str4;
    }

    public String getBody() {
        return this.body;
    }

    public String getDisplayResult() {
        StringBuilder sb2 = new StringBuilder(100);
        ParsedResult.maybeAppend(this.numbers, sb2);
        ParsedResult.maybeAppend(this.subject, sb2);
        ParsedResult.maybeAppend(this.body, sb2);
        return sb2.toString();
    }

    public String[] getNumbers() {
        return this.numbers;
    }

    public String getSMSURI() {
        StringBuilder sb2 = new StringBuilder();
        sb2.append("sms:");
        boolean z11 = false;
        boolean z12 = true;
        for (int i11 = 0; i11 < this.numbers.length; i11++) {
            if (z12) {
                z12 = false;
            } else {
                sb2.append(',');
            }
            sb2.append(this.numbers[i11]);
            String[] strArr = this.vias;
            if (!(strArr == null || strArr[i11] == null)) {
                sb2.append(";via=");
                sb2.append(this.vias[i11]);
            }
        }
        boolean z13 = this.body != null;
        if (this.subject != null) {
            z11 = true;
        }
        if (z13 || z11) {
            sb2.append('?');
            if (z13) {
                sb2.append("body=");
                sb2.append(this.body);
            }
            if (z11) {
                if (z13) {
                    sb2.append('&');
                }
                sb2.append("subject=");
                sb2.append(this.subject);
            }
        }
        return sb2.toString();
    }

    public String getSubject() {
        return this.subject;
    }

    public String[] getVias() {
        return this.vias;
    }

    public SMSParsedResult(String[] strArr, String[] strArr2, String str, String str2) {
        super(ParsedResultType.SMS);
        this.numbers = strArr;
        this.vias = strArr2;
        this.subject = str;
        this.body = str2;
    }
}
