import java.util.*;


public class pgm_42583_tinajeong {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 1;
        int currentWeight = 0;
        int currentTruck = 0;
        boolean end = false;
        Queue<Truck> queue = new LinkedList<>();
        Queue<Truck> passedQueue = new LinkedList<>();
        while (true) {
            if (passedQueue.size() == truck_weights.length && queue.isEmpty())
                break;
            answer++;

            if (truck_weights.length == 1 && queue.isEmpty()) {
                currentWeight = truck_weights[0];
                queue.add(new Truck(0, truck_weights[0]));
            } else if (queue.size() < bridge_length && weight >= currentWeight + truck_weights[currentTruck]) {
                currentWeight += truck_weights[currentTruck];
                if (currentTruck == truck_weights.length - 1) {
                    queue.add(new Truck(0, truck_weights[currentTruck]));
                    end = true;
                } else {
                    queue.add(new Truck(0, truck_weights[currentTruck + 1]));
                }
                currentTruck++;
            }

            if (!queue.isEmpty()) {
                for (Truck truck : queue) {
                    truck.addProgress();
                }

                if (queue.peek().progress >= bridge_length) {
                    currentWeight -= queue.peek().weight;
                    passedQueue.add(queue.remove());
                }
            }
        }

        return answer;
    }

    private static class Truck {
        int progress;
        int weight;

        Truck(int progress, int weight) {
            this.progress = progress;
            this.weight = weight;
        }

        void addProgress() {
            this.progress++;
        }
    }
}
