package model;

public class Toy {
    /**
     * Напишите класс-конструктор у которого принимает минимум 3 строки,
     *  * содержащие три поля id игрушки, текстовое название и частоту выпадения
     *  * игрушки
     */
   private int id;

    private String name;

    private double weigth;

    public Toy(int id, String name, double weigth) {
        this.id = id;
        this.name = name;
        this.weigth = weigth;
    }

    @Override
    public String toString() {
        return "Toys{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", weigth=" + weigth +
                '}';
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getWeigth() {
        return weigth;
    }
}
