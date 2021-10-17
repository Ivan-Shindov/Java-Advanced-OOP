package barracksWars.core.commands;

import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

public class Add extends Command {
    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String unitType = getData()[1];
        Unit unitToAdd = null;
        try {
            unitToAdd = getUnitFactory().createUnit(unitType);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        getRepository().addUnit(unitToAdd);
        return unitType + " added!";
    }
}
