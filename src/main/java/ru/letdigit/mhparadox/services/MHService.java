package ru.letdigit.mhparadox.services;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Service
public class MHService {
    private final Map<Integer, Boolean> results = new HashMap<>();

    /**
     * Выполнение заданного количества итераций, результаты заносятся
     * в HashMap
     * @param numbersOfIterations Количество игр
     * @param changeOfChoice Изменяет ли игрок свое решение
     *                       после открытия двери с козой
     */
    public void solve(Integer numbersOfIterations, Boolean changeOfChoice) {
        int NUMBER_OF_DOORS = 3;
        Random rnd = new Random();
        for (int i = 1; i <= numbersOfIterations; i++) {
            int carDoor = rnd.nextInt(3);
            int playerSelectedDoor = rnd.nextInt(3);
            int doorWithGoat;
            do {
                doorWithGoat = rnd.nextInt(3);
            } while (doorWithGoat == playerSelectedDoor || doorWithGoat == carDoor);
            if (changeOfChoice) {
                playerSelectedDoor = NUMBER_OF_DOORS - playerSelectedDoor - doorWithGoat;
            }
            results.put(i, playerSelectedDoor == carDoor);
        }
    }

    /**
     * Вычисление результатов
     * @return Количество выигрышей
     */
    public Integer getResults() {
        return Math.toIntExact(results.entrySet().stream().filter(Map.Entry::getValue).count());
    }
}
