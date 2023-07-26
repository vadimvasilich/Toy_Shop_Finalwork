

import Global.Writer;

import Model.Toy;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static Global.Vars.allToys;
import static Global.Vars.winsToys;

public class Main {

    public static void main(String[] args) {
        //Сначала создаем произвольные игрушки
        Toy cat = new Toy(1, "cat", 10, 20);
        Toy dog = new Toy(2, "dog", 3, 5);
        Toy bird = new Toy(3, "bird", 4, 10);
        Toy fish = new Toy(4, "fish", 10, 30);
        Toy spiderman = new Toy(5, "spiderman", 6, 20);
        Toy superman = new Toy(6, "superman", 5, 8);

        //добавляем созданные игрушки в список (в обычный непризовой) с новым весом
        addToListWithNewWeight(cat, 5);
        addToListWithNewWeight(dog, 10);
        addToListWithNewWeight(bird, 21);
        addToListWithNewWeight(fish, 7);
        addToListWithNewWeight(spiderman, 45);
        addToListWithNewWeight(superman, 67);

        //показываем что у нас в общем списке игрушек
        System.out.println("all toys: ");
        showNewList(allToys);

        //формируем список призовых игрушек (пусть это будут с весом от 20)
        List<Toy> addedWinners = selectToyByMinWeight(allToys, 20);
        winsToys.addAll(addedWinners);

        //отображаем призовые игрушки
        System.out.println("winners list: ");
        showNewList(winsToys);

        //выбираем призовую игрушку на выдачу из призового списка (пусть случайным образом)
        Toy givedWinner = selectRandomToy(winsToys);
        //удаляем выданную игрушку из списка к выдаче
        winsToys.remove(givedWinner);

        //отображаем инфо о призовой игрушке на выдачу
        System.out.println("winner for giving: " + givedWinner.info());

        //пишем инфо в текстовый файл
        Writer.writeToy(givedWinner);

    }

    private static List<Toy> selectToyByMinWeight(ArrayList<Toy> allToys, int minWeight) {
        List<Toy> result = new ArrayList<>();
        for (Toy currentToy : allToys) {
            if (currentToy.getWeight() <= minWeight) {
                result.add(currentToy);
            }
        }
        return result;
    }

    private static Toy selectRandomToy(ArrayList<Toy> winsToys) {
        Random rand = new Random();
        int winnerElement = rand.nextInt(winsToys.size());
        return winsToys.get(winnerElement);
    }

    private static void addToListWithNewWeight(Toy newToy, int newWeight) {
        newToy.setWeight(newWeight);
        allToys.add(newToy);
    }

    private static void showNewList(ArrayList<Toy> myList) {
        int winListSize = myList.size();
        for (int i = 0; i < winListSize; i++) {
            System.out.print("toy [" + i + "]: " + myList.get(i).getName() + ", ");
        }
        System.out.println("");
    }
}