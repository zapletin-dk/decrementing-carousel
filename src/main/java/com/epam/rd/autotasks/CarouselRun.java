package com.epam.rd.autotasks;

public class CarouselRun {
    int count = 0;
    int[] array = DecrementingCarousel.elements;

    public int next() {
        //System.out.println(Arrays.toString(array));
        if (array.length == 0) {
            return -1;
        }

        if (count == array.length) {
            count = 0;
        }

        while (array[count] == 0) {
            count++;

            if (count > array.length - 1) {
                count = 0;
            }

            if (isFinished()) {
                return -1;
            }
        }

        for (int i = 1; i < array.length; i++) {
            if (array[i] == -1) {
                break;
            }
        }

        count++;
        action(count - 1);
        return array[count - 1] + 1;
    }

    public boolean isFinished() {
        int sum = 0;
        for (int element : array) {
            sum += element;
        }

        return sum == 0;
    }

    public void action(int index) {
        array[index]--;
    }
}