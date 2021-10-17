package CollectionHierarchy;

import CollectionHierarchy.interfaces.MyList;

public class MyListImpl extends Collection
        implements MyList {

    @Override
    public int getUsed() {
        return super.getItems().size();
    }

    @Override
    public String remove() {
        if (!super.getItems().isEmpty()) {
            String firstItem = super.getItems().remove(0);
            return firstItem;
        }
        throw new IllegalStateException("Collection is empty!");
    }

    @Override
    public int add(String item) {
        super.getItems().add(0,item);
        return 0;
    }
}
