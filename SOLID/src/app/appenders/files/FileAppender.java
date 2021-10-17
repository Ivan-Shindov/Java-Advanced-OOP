package app.appenders.files;

import app.appenders.BaseAppender;
import app.enums.ReportLevel;
import app.layouts.Layout;

public class FileAppender extends BaseAppender {
    private File file;

    public FileAppender(Layout layout) {
        super(layout);
    }

    @Override
    public void append(String dateTime, ReportLevel reportLevel, String message) {
        if (!super.checkIfReportLevelIsValid(reportLevel)) {
            String format = super.getLayout().format(dateTime, reportLevel, message);
            this.file.write(format);
        }
    }
    public void setFile(File file) {
        this.file = file;
    }
}
