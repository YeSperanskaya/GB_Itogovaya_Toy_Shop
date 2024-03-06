import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;

public class ToyStore {

    /**
     * Готовая функция вызова работы программы
     */
    public static void start() {
        /**
         * Тут хранятся игрушки
         */

        PriorityQueue<Toy> toysQueue = new PriorityQueue<>((t1, t2) -> t2.getFrequency() - t1.getFrequency());

        // Добавляю игрушки в очередь
        addToy(toysQueue, "1 2 пингвин");
        addToy(toysQueue, "2 2 котенок");
        addToy(toysQueue, "3 6 кукольный набор");

        // Вызываем метод Get 10 раз и записываем результат в файл
        try {
            FileWriter writer = new FileWriter("output.txt");
            for (int i = 0; i < 10; i++) {
                int toyId = getToy(toysQueue);
                writer.write(Integer.toString(toyId) + "\n");
            }
            writer.close();
            System.out.println("Результаты вы можете посмотреть в файле output.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Метод для добавления игрушки в очередь
      */

    private static void addToy(PriorityQueue<Toy> toysQueue, String toyString) {
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
    private static int getToy(PriorityQueue<Toy> toysQueue) {
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
}
