package app.appenders.console;

import app.appenders.BaseAppender;
import app.enums.ReportLevel;
import app.layouts.Layout;

public class ConsoleAppender extends BaseAppender {

    public ConsoleAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (!super.checkIfReportLevelIsValid(reportLevel)) {
            System.out.println(super.getLayout().format(dateTime, reportLevel, message));
        }
    }
}
