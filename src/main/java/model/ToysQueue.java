package model;

import java.io.FileWriter;
import java.io.IOException;
import java.util.PriorityQueue;


public class ToysQueue {
    private PriorityQueue<Toy> queue;
    //private String[] toys = new String[3];

    public ToysQueue(Toy toy1, Toy toy2, Toy toy3) {
        queue = new PriorityQueue((t1, t2) -> Double.compare(toy1.getWeigth(), toy2.getWeigth()));
        queue.add(toy1);

        queue.add(toy2);
        queue.add(toy3);

//        String[] toys = toy1.split(" ");
//        queue.add(new Toy(Integer.parseInt(toys[0]), toys[1], Double.parseDouble(toys[2])));
//
//        toys = toy2.split(" ");
//        queue.add(new Toy(Integer.parseInt(toys[0]), toys[1], Double.parseDouble(toys[2])));
//
//        toys = toy3.split(" ");
//        queue.add(new Toy(Integer.parseInt(toys[0]), toys[1], Double.parseDouble(toys[2])));
    }


//    public ToysQueue() {
//    }
//
//    public ToysQueue(int id, String name, double weigth) {
//        queue.add(new Toy(id, name, weigth));
//    }

    public void addToQueue(Toy toy) {
        queue.add(toy);

    }

    public void getAndWriteToFile(int times, String path) {
        try (FileWriter writer = new FileWriter(path)) {
            for (int i = 0; i < times; i++) {
                double random = Math.random();
                if (random <= 0.2) {
                    writer.write(queue.peek().getId() + "\n");
                } else if (random <= 0.4) {
                    Toy[] toy = queue.toArray(new Toy[1]);
                    writer.write(queue.peek().getId() + "\n");
                } else {
                    Toy[] toy = queue.toArray(new Toy[2]);
                    writer.write(queue.peek().getId() + "\n");
                }
            }

        } catch (IOException ex) {
            System.out.println("Error writing to file: " + ex.getMessage());
        }
    }

    @Override
    public String toString() {
        return "ToysQueue{" +
                "queue=" + queue +
                '}';
    }

    public PriorityQueue<Toy> getQueue() {
        return queue;
    }
}
