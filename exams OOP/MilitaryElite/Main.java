package MilitaryElite;

import MilitaryElite.Enums.Corps;
import MilitaryElite.Enums.State;
import MilitaryElite.Utility.Interfaces.Mission;
import MilitaryElite.Utility.Interfaces.Repair;
import MilitaryElite.Utility.MissionImpl;
import MilitaryElite.Utility.RepairImpl;
import MilitaryElite.Interfaces.*;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<Integer, Private> soldiers = new LinkedHashMap<>();
        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] tokens = input.split("\\s+");
            String unitType = tokens[0];
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];

            switch (unitType) {
                case "Private":
                    double salary = Double.parseDouble(tokens[4]);
                    Private soldier = new PrivateImpl(id, firstName, lastName, salary);
                    soldiers.put(id, soldier);
                    System.out.println(soldier.toString());
                    break;
                case "LeutenantGeneral":
                    //•	LieutenantGeneral: "LieutenantGeneral <id> <firstName> <lastName> <salary> <private1Id> <private2Id> … <privateNId>"
                    // where privateXId will always be an Id of a private already received through the input
                    salary = Double.parseDouble(tokens[4]);

                    List<Integer> ids = new ArrayList<>();
                    if (tokens.length > 5) {
                        for (int i = 5; i < tokens.length; i++) {
                            ids.add(Integer.parseInt(tokens[i]));
                        }
                    }

                    LieutenantGeneral lieutenantGeneral = new LieutenantGeneralImpl(id, firstName, lastName, salary);

                    if (!soldiers.isEmpty()) {
                        for (Integer singleId : ids) {
                            if (soldiers.containsKey(singleId)) {
                                lieutenantGeneral.addPrivate(soldiers.get(singleId));
                            }
                        }
                    }

                    System.out.println(lieutenantGeneral);
                    break;
                case "Engineer":
                    //•	Engineer: "Engineer <id> <firstName> <lastName> <salary> <corps> <repair1Part> <repair1Hours> … <repairNPart> <repairNHours>"
                    // where repairXPart is the name of a repaired part and repairXHours the
                    salary = Double.parseDouble(tokens[4]);
                    String corpsAsString = tokens[5].toUpperCase();
                    if (!corpsAsString.equals("AIRFORCES") && !corpsAsString.equals("MARINES")) {
                        break;
                    }

                    Corps corps = Corps.valueOf(corpsAsString);
                    Engineer engineer = new EngineerImpl(id, firstName, lastName, salary, corps);
                    if (tokens.length > 6) {
                        for (int i = 6; i < tokens.length - 1; i += 2) {
                            String part = tokens[i];
                            int hoursWorked = Integer.parseInt(tokens[i + 1]);
                            Repair repair = new RepairImpl(part, hoursWorked);
                            engineer.addRepair(repair);
                        }
                    }

                    System.out.println(engineer.toString());
                    break;
                case "Commando":
                    //•	Commando: "Commando <id> <firstName> <lastName> <salary> <corps> <mission1CodeName>  <mission1state> … <missionNCodeName> <missionNstate>"
                    // a missions code name, description and state will always come together
                    salary = Double.parseDouble(tokens[4]);
                    corpsAsString = tokens[5].toUpperCase();
                    if (!corpsAsString.equals("AIRFORCES") && !corpsAsString.equals("MARINES")) {
                        break;
                    }

                    corps = Corps.valueOf(corpsAsString);
                    Commando commando = new CommandoImpl(id, firstName, lastName, salary, corps);
                    if (tokens.length > 6) {
                        for (int i = 6; i < tokens.length - 1; i += 2) {
                            String codeName = tokens[i];
                            String missionState = tokens[i + 1];
                            if (!missionState.equals("inProgress") && !missionState.equals("Finished")) {
                                continue;
                            }

                            Mission mission = new MissionImpl(codeName, State.valueOf(missionState.toUpperCase()));
                            commando.addMission(mission);
                        }
                    }

                    System.out.println(commando.toString());
                    break;
                case "Spy":
                    //"Spy <id> <firstName> <lastName> <codeNumber>"
                    String codeNumber = tokens[4];
                    Spy spy = new SpyImpl(id, firstName, lastName, codeNumber);
                    System.out.println(spy.toString());
                    break;
                default:
                    break;
            }

            input = scanner.nextLine();
        }
    }
}