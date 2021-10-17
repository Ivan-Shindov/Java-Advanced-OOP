package robotService.core;

import robotService.core.interfaces.Controller;
import robotService.models.garages.interfaces.Garage;
import robotService.models.garages.interfaces.garages.GarageImpl;
import robotService.models.procedures.interfaces.Procedure;
import robotService.models.procedures.interfaces.procedures.Charge;
import robotService.models.procedures.interfaces.procedures.Repair;
import robotService.models.procedures.interfaces.procedures.Work;
import robotService.models.robots.interfaces.Robot;
import robotService.models.robots.interfaces.robots.Cleaner;
import robotService.models.robots.interfaces.robots.Housekeeper;

import static robotService.common.ExceptionMessages.*;
import static robotService.common.OutputMessages.*;

public class ControllerImpl implements Controller {

    private Garage garage;
    private Procedure charge;
    private Procedure repair;
    private Procedure work;

    public ControllerImpl() {
        this.garage = new GarageImpl();
        this.charge = new Charge();
        this.repair = new Repair();
        this.work = new Work();
    }

    @Override
    public String manufacture(String robotType, String name, int energy,
                              int happiness, int procedureTime) {

        Robot robot;

        switch (robotType) {
            case "Cleaner":
                robot = new Cleaner(name, energy, happiness, procedureTime);
                break;
            case "Housekeeper":
                robot = new Housekeeper(name, energy, happiness, procedureTime);
                break;
            default:
                throw new IllegalArgumentException(String.format(INVALID_ROBOT_TYPE, robotType));
        }

        this.garage.manufacture(robot);
        return String.format(ROBOT_MANUFACTURED, name);
    }

    @Override
    public String repair(String robotName, int procedureTime) {

        isRobotExistInGarage(robotName);
        Robot robot = this.garage.getRobots().get(robotName);
        this.repair.doService(robot, procedureTime);

        return String.format(REPAIR_PROCEDURE, robotName);
    }

    @Override
    public String work(String robotName, int procedureTime) {
        isRobotExistInGarage(robotName);
        Robot robot = this.garage.getRobots().get(robotName);
        this.work.doService(robot, procedureTime);

        return String.format(WORK_PROCEDURE, robotName, procedureTime);
    }

    @Override
    public String charge(String robotName, int procedureTime) {
        isRobotExistInGarage(robotName);
        Robot robot = this.garage.getRobots().get(robotName);
        this.charge.doService(robot, procedureTime);

        return String.format(CHARGE_PROCEDURE, robotName);
    }

    @Override
    public String sell(String robotName, String ownerName) {
        isRobotExistInGarage(robotName);
        Robot robot = this.garage.getRobots().get(robotName);
        this.garage.sell(robot.getName(), ownerName);

        return String.format(SELL_ROBOT, ownerName, robotName);
    }

    @Override
    public String history(String procedureType) {
        StringBuilder result = new StringBuilder();

        switch (procedureType) {
            case "Charge":

                result.append(this.charge.history());
                break;
            case "Repair":

                result.append(this.repair.history());
                break;
            case "Work":

                result.append(this.work.history());
                break;
        }

        return result.toString().trim();
    }

    private void isRobotExistInGarage(String name) {
        if (!this.garage.getRobots().containsKey(name)) {
            throw new IllegalArgumentException(
                    String.format(NON_EXISTING_ROBOT, name));
        }
    }
}
