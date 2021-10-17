package CounterStriker.models.field;

import CounterStriker.models.players.Player;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import static CounterStriker.common.OutputMessages.*;

public class FieldImpl implements Field {

    @Override
    public String start(Collection<Player> players) {
        List<Player> terrorists = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("Terrorist"))
                .collect(Collectors.toList());

        List<Player> counterTerrorists = players.stream()
                .filter(p -> p.getClass().getSimpleName().equals("CounterTerrorist"))
                .collect(Collectors.toList());

        while (terrorists.stream().anyMatch(Player::isAlive) &&
                counterTerrorists.stream().anyMatch(Player::isAlive)) {

            for (int i = 0; i < terrorists.size(); i++) {
                Player terrorist = terrorists.get(i);
                for (int j = 0; j < counterTerrorists.size(); j++) {
                    Player counterTerrorist = counterTerrorists.get(j);
                    counterTerrorist.takeDamage(terrorist.getGun().fire());
                }
            }
            counterTerrorists = counterTerrorists.stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toList());

            for (int i = 0; i < counterTerrorists.size(); i++) {
                Player counterTerrorist = counterTerrorists.get(i);
                for (int j = 0; j < terrorists.size(); j++) {
                    Player terrorist = terrorists.get(j);
                    terrorist.takeDamage(counterTerrorist.getGun().fire());
                }
            }

            terrorists = terrorists.stream()
                    .filter(Player::isAlive)
                    .collect(Collectors.toList());
        }


        return terrorists.size() != 0 ? TERRORIST_WINS : COUNTER_TERRORIST_WINS;
    }
}
