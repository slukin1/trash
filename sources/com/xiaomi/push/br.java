package com.xiaomi.push;

import android.content.Context;
import android.text.TextUtils;
import com.xiaomi.channel.commonutils.logger.b;

public class br extends bt {
    public br(String str, String str2, String[] strArr, String str3) {
        super(str, str2, strArr, str3);
    }

    public static br a(Context context, String str, int i11) {
        b.b("delete  messages when db size is too bigger");
        String a11 = bx.a(context).a(str);
        if (TextUtils.isEmpty(a11)) {
            return null;
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append("rowDataId in (select ");
        sb2.append("rowDataId from " + a11);
        sb2.append(" order by createTimeStamp asc");
        sb2.append(" limit ?)");
        return new br(str, sb2.toString(), new String[]{String.valueOf(i11)}, "a job build to delete history message");
    }

    private void a(long j11) {
        String[] strArr = this.f2587a;
        if (strArr != null && strArr.length > 0) {
            strArr[0] = String.valueOf(j11);
        }
    }

    public void a(Context context, Object obj) {
        if (obj instanceof Long) {
            long longValue = ((Long) obj).longValue();
            long a11 = cb.a(a());
            long j11 = bp.f2569a;
            if (a11 > j11) {
                long j12 = (long) (((((double) (a11 - j11)) * 1.2d) / ((double) j11)) * ((double) longValue));
                a(j12);
                bo a12 = bo.a(context);
                a12.a("begin delete " + j12 + "noUpload messages , because db size is " + a11 + "B");
                super.a(context, obj);
                return;
            }
            b.b("db size is suitable");
        }
    }
}
