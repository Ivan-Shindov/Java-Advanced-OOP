package robotService.models.procedures.interfaces.procedures;

import robotService.models.robots.interfaces.Robot;

import static robotService.common.ExceptionMessages.ALREADY_REPAIRED;

public class Repair extends BaseProcedure {

    @Override
    public void doService(Robot robot, int procedureTime) {
        super.doService(robot, procedureTime);
        if (robot.isRepaired()) {
            throw new IllegalArgumentException(
                    String.format(ALREADY_REPAIRED,robot.getName()));
        } else {
            robot.setHappiness(robot.getHappiness() - 5);
            robot.setRepaired(true);
        }
    }
}
