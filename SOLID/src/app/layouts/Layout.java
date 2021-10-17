package app.layouts;

import app.enums.ReportLevel;

public interface Layout {
    String format(String dateTime, ReportLevel reportLevel, String message);

}
