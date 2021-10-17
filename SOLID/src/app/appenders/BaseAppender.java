package app.appenders;

import app.enums.ReportLevel;
import app.layouts.Layout;

public abstract class BaseAppender implements Appender {
    private Layout layout;
    private ReportLevel reportLevel;

    public BaseAppender(Layout layout) {
        this.layout = layout;
    }

    public Layout getLayout() {
        return layout;
    }

    @Override
    public void setReportLevel(ReportLevel reportLevel) {
        this.reportLevel = reportLevel;
    }

    public ReportLevel getReportLevel() {
        return reportLevel;
    }

    protected boolean checkIfReportLevelIsValid(ReportLevel reportLevel) {
        return this.getReportLevel().ordinal() > reportLevel.ordinal();
    }
}