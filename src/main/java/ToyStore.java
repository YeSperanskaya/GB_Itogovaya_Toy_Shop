import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {

    /**
     * Тут хранятся игрушки
     */
    PriorityQueue<Toy> toysQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());
    public ToyStore() {
    }
    /**
     * Метод для добавления игрушки в очередь
      */

    public void addToy(PriorityQueue<Toy> toysQueue, String toyString) {
        String[] parts = toyString.split(" ");
        int id = Integer.parseInt(parts[0]);
        int frequency = Integer.parseInt(parts[1]);
        String name = parts[2];
        Toy toy = new Toy(id, name, frequency);
        toysQueue.add(toy);
    }

    /**
     * Метод для получения случайной игрушки в соответствии с её весом
     * @param toysQueue список игрушек
     * @return Id итгрушки
     */
    public int getToy(PriorityQueue<Toy> toysQueue) {
        int totalFrequency = toysQueue.stream().mapToInt(Toy::getFrequency).sum();
        int randomNumber = (int) (Math.random() * totalFrequency) + 1;
        int sum = 0;
        for (Toy toy : toysQueue) {
            sum += toy.getFrequency();
            if (randomNumber <= sum) {
                return toy.getId();
            }
        }
        return -1; // Вернуть -1 в случае ошибки
    }

    public PriorityQueue<Toy> getToysQueue() {
        return toysQueue;
    }
}
