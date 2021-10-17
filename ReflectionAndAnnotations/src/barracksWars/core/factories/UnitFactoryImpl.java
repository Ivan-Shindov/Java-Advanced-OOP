package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) {
		Unit unit;
		try {
			Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);
			clazz.getDeclaredConstructor();
			unit = (Unit) clazz.getDeclaredConstructor().newInstance();
		} catch (InstantiationException | IllegalAccessException |
				InvocationTargetException | NoSuchMethodException |
				ClassNotFoundException e) {
			throw new IllegalArgumentException(e);
		}

		return unit;
	}
}
