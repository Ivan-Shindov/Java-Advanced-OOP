package CollectionHierarchy;

import CollectionHierarchy.interfaces.AddRemovable;

public class AddRemoveCollection extends Collection
        implements AddRemovable {

    public AddRemoveCollection() {
        super();
    }

    @Override
    public String remove() {
        if (super.getItems().size() > 0) {
            int lastIndex = super.getItems().size() - 1;
            String lastElement = super.getItems().remove(lastIndex);
            return lastElement;
        }
        throw new IllegalStateException("Collection size is or less than zero");
    }

    @Override
    public int add(String item) {
        super.getItems().add(0, item);
        return 0;
    }
}
