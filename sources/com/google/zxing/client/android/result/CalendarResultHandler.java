package com.google.zxing.client.android.result;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.util.Log;
import androidx.fragment.app.FragmentActivity;
import com.google.zxing.client.result.CalendarParsedResult;
import com.google.zxing.client.result.ParsedResult;
import com.hbg.lib.network.pro.core.util.Period;
import java.text.DateFormat;
import pro.huobi.R;

public final class CalendarResultHandler extends ResultHandler {
    private static final String TAG = "CalendarResultHandler";
    private static final int[] buttons = {R.string.button_add_calendar};

    public CalendarResultHandler(FragmentActivity fragmentActivity, ParsedResult parsedResult) {
        super(fragmentActivity, parsedResult);
    }

    private void addCalendarEvent(String str, long j11, boolean z11, long j12, String str2, String str3, String[] strArr) {
        Intent intent = new Intent("android.intent.action.INSERT");
        intent.setType("vnd.android.cursor.item/event");
        intent.putExtra("beginTime", j11);
        if (z11) {
            intent.putExtra("allDay", true);
        }
        if (j12 >= 0) {
            j11 = j12;
        } else if (z11) {
            j11 += Period.DAY_MILLS;
        }
        intent.putExtra("endTime", j11);
        intent.putExtra("title", str);
        intent.putExtra("eventLocation", str2);
        intent.putExtra("description", str3);
        if (strArr != null) {
            intent.putExtra("android.intent.extra.EMAIL", strArr);
        }
        try {
            rawLaunchIntent(intent);
        } catch (ActivityNotFoundException unused) {
            Log.w(TAG, "No calendar app available that responds to android.intent.action.INSERT");
            intent.setAction("android.intent.action.EDIT");
            launchIntent(intent);
        }
    }

    private static String format(boolean z11, long j11) {
        DateFormat dateFormat;
        if (j11 < 0) {
            return null;
        }
        if (z11) {
            dateFormat = DateFormat.getDateInstance(2);
        } else {
            dateFormat = DateFormat.getDateTimeInstance(2, 2);
        }
        return dateFormat.format(Long.valueOf(j11));
    }

    public int getButtonCount() {
        return buttons.length;
    }

    public int getButtonText(int i11) {
        return buttons[i11];
    }

    public CharSequence getDisplayContents() {
        CalendarParsedResult calendarParsedResult = (CalendarParsedResult) getResult();
        StringBuilder sb2 = new StringBuilder(100);
        ParsedResult.maybeAppend(calendarParsedResult.getSummary(), sb2);
        long startTimestamp = calendarParsedResult.getStartTimestamp();
        ParsedResult.maybeAppend(format(calendarParsedResult.isStartAllDay(), startTimestamp), sb2);
        long endTimestamp = calendarParsedResult.getEndTimestamp();
        if (endTimestamp >= 0) {
            if (calendarParsedResult.isEndAllDay() && startTimestamp != endTimestamp) {
                endTimestamp -= Period.DAY_MILLS;
            }
            ParsedResult.maybeAppend(format(calendarParsedResult.isEndAllDay(), endTimestamp), sb2);
        }
        ParsedResult.maybeAppend(calendarParsedResult.getLocation(), sb2);
        ParsedResult.maybeAppend(calendarParsedResult.getOrganizer(), sb2);
        ParsedResult.maybeAppend(calendarParsedResult.getAttendees(), sb2);
        ParsedResult.maybeAppend(calendarParsedResult.getDescription(), sb2);
        return sb2.toString();
    }

    public int getDisplayTitle() {
        return R.string.result_calendar;
    }

    public void handleButtonPress(int i11) {
        String str;
        if (i11 == 0) {
            CalendarParsedResult calendarParsedResult = (CalendarParsedResult) getResult();
            String description = calendarParsedResult.getDescription();
            String organizer = calendarParsedResult.getOrganizer();
            if (organizer != null) {
                if (description == null) {
                    str = organizer;
                    addCalendarEvent(calendarParsedResult.getSummary(), calendarParsedResult.getStartTimestamp(), calendarParsedResult.isStartAllDay(), calendarParsedResult.getEndTimestamp(), calendarParsedResult.getLocation(), str, calendarParsedResult.getAttendees());
                }
                description = description + 10 + organizer;
            }
            str = description;
            addCalendarEvent(calendarParsedResult.getSummary(), calendarParsedResult.getStartTimestamp(), calendarParsedResult.isStartAllDay(), calendarParsedResult.getEndTimestamp(), calendarParsedResult.getLocation(), str, calendarParsedResult.getAttendees());
        }
    }
}
