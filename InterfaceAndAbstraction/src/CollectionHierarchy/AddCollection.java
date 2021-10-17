package CollectionHierarchy;

import CollectionHierarchy.interfaces.Addable;

public class AddCollection extends Collection implements Addable {

    @Override
    public int add(String item) {
        if (super.getItems().size() + 1 > this.getMaxSize()) {
            throw new IllegalStateException("Size bigger than 100");
        }
        super.getItems().add(item);
        return super.getItems().size() - 1;
    }
}
