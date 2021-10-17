package Exercise;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader buff = new BufferedReader(new InputStreamReader(System.in));

        TrafficLights[] lights = Arrays.stream(buff.readLine().split("\\s+"))
                .map(TrafficLights::valueOf)
                .toArray(TrafficLights[]::new);
        
        int n = Integer.parseInt(buff.readLine());

        TrafficLights[] trafficLights = TrafficLights.values();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < lights.length; j++) {
                TrafficLights light = lights[j];
                int nextIndex = light.ordinal() + 1;
                TrafficLights value = trafficLights[nextIndex % trafficLights.length];
                lights[j] = value;
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}
