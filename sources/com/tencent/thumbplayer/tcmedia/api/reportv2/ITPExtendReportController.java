package com.tencent.thumbplayer.tcmedia.api.reportv2;

public interface ITPExtendReportController {
    void addReportChannelListener(ITPReportChannelListener iTPReportChannelListener);

    void setReportInfoGetter(ITPReportInfoGetter iTPReportInfoGetter);
}
