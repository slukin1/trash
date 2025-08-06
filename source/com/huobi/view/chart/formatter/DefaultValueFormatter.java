package com.huobi.view.chart.formatter;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.text.DecimalFormat;

public class DefaultValueFormatter extends ValueFormatter {
    public int mDecimalDigits;
    public DecimalFormat mFormat;

    public DefaultValueFormatter(int i11) {
        setup(i11);
    }

    public int getDecimalDigits() {
        return this.mDecimalDigits;
    }

    public String getFormattedValue(float f11) {
        return this.mFormat.format((double) f11);
    }

    public void setup(int i11) {
        this.mDecimalDigits = i11;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 == 0) {
                stringBuffer.append(InstructionFileId.DOT);
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }
}
