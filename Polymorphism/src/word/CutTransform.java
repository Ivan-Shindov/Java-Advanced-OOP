package word;

public class CutTransform implements TextTransform {

    private StringBuilder lastCut = new StringBuilder();

    @Override
    public void invokeOn(StringBuilder text, int startIndex, int endIndex) {
        this.lastCut = new StringBuilder(text.substring(startIndex,endIndex));
        text.delete(startIndex, endIndex);
    }

    public StringBuilder getLastCut() {
        return lastCut;
    }
}
