package MilitaryElite;
import MilitaryElite.Enums.Corps;
import MilitaryElite.Enums.State;
import MilitaryElite.interfaces.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;


public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        String input = buff.readLine();

        Map<Integer,Private> mapIds = new HashMap<>();

        while (!input.equals("End")) {

            String[] tokens = input.split("\\s+");
            int id = Integer.parseInt(tokens[1]);
            String firstName = tokens[2];
            String lastName = tokens[3];
            double salary;
            switch (tokens[0]) {
                case "Private":
                    salary = Double.parseDouble(tokens[4]);
                    Private priv = new PrivateImpl(id,firstName,lastName,salary);

                    System.out.println(priv.toString());
                    mapIds.put(id,priv);
                    break;

                case "LeutenantGeneral":
                    salary = Double.parseDouble(tokens[4]);

                    LieutenantGeneral lieutenantGeneral =
                            new LieutenantGeneralImpl(id,firstName,lastName,salary);

//                    List<Integer> ids = new ArrayList<>();
                    if (tokens.length > 5) {
                        for (int i = 5; i < tokens.length; i++) {
                             int currId = Integer.parseInt(tokens[i]);
                             if (mapIds.containsKey(currId)) {
                                 Private aPrivate = mapIds.get(currId);
                                 lieutenantGeneral.addPrivate(aPrivate);
                             }
                        }
                    }
//
//                   if (!mapIds.isEmpty()) {
//                       for (Integer currId : ids) {
//                           if (mapIds.containsKey(currId)) {
//                               lieutenantGeneral.addPrivate(mapIds.get(currId));
//                           }
//                       }
//                   }

                    System.out.println(lieutenantGeneral.toString());

                    break;
                case "Engineer":
                    salary = Double.parseDouble(tokens[4]);
                    String corpAsString = tokens[5].toUpperCase();
                    if (!corpAsString.equals("AIRFORCES") &&
                            !(corpAsString.equals("MARINES"))) {
                        break;
                    }
                    Corps corps = Corps.valueOf(corpAsString);
                    Engineer engineer =
                            new EngineerImpl(id,firstName,lastName,salary,
                                    corps);
                    if (tokens.length > 6) {
                        for (int i = 6; i < tokens.length - 1; i += 2) {
                            String partName = tokens[i];
                            int hoursWorked = Integer.parseInt(tokens[i + 1]);
                            Repair repair = new RepairImpl(partName, hoursWorked);
                            engineer.addRepair(repair);
                        }
                    }

                    System.out.println(engineer.toString());
                    break;
                case "Commando":
                    salary = Double.parseDouble(tokens[4]);
                    corps = Corps.valueOf(tokens[5].toUpperCase());
                    corpAsString = corps.getType();

                    if (!corpAsString.equals("Airforces") &&
                            !(corpAsString.equals("Marines"))) {
                        break;
                    }

                    Commando commando = new CommandoImpl(id,firstName,
                            lastName,salary,Corps.valueOf(tokens[5].toUpperCase()));
                    if (tokens.length > 6) {
                        for (int i = 6; i < tokens.length - 1; i += 2) {
                            String codeName = tokens[i];
                            String missionState = tokens[i + 1];
                            if (!missionState.equals("inProgress") &&
                                    !missionState.equals("Finished")) {
                                continue;
                            }
                            Mission mission = new MissionImpl(codeName, State.valueOf(missionState.toUpperCase()));
//                            if (mission.getState().getType().equals("Finished")) {
//                                continue;
//                            }
                            commando.addMission(mission);
                        }
                    }

                    System.out.println(commando.toString());
                    break;
                case "Spy":
                    String codeNumber = tokens[4];
                    Spy spy = new SpyImpl(id,firstName,lastName,codeNumber);

                    System.out.println(spy.toString());
                    break;
            }

            input = buff.readLine();
        }
    }
}
