package com.sumsub.sns.internal.log.logger;

import com.sumsub.log.logger.Logger;
import com.sumsub.sns.internal.log.LoggerType;
import java.util.List;

public interface b extends Logger {
    String a();

    void a(List<? extends LoggerType> list);

    List<LoggerType> b();

    void clear();

    void flush();
}
