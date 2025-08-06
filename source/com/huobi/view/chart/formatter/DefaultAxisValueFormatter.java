package com.huobi.view.chart.formatter;

import com.amazonaws.services.s3.model.InstructionFileId;
import java.text.DecimalFormat;

public class DefaultAxisValueFormatter extends ValueFormatter {
    public int digits;
    public DecimalFormat mFormat;

    public DefaultAxisValueFormatter(int i11) {
        this.digits = i11;
        StringBuffer stringBuffer = new StringBuffer();
        for (int i12 = 0; i12 < i11; i12++) {
            if (i12 == 0) {
                stringBuffer.append(InstructionFileId.DOT);
            }
            stringBuffer.append("0");
        }
        this.mFormat = new DecimalFormat("###,###,###,##0" + stringBuffer.toString());
    }

    public int getDecimalDigits() {
        return this.digits;
    }

    public String getFormattedValue(float f11) {
        return this.mFormat.format((double) f11);
    }
}
