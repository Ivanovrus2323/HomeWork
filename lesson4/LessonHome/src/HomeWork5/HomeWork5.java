package HomeWork5;

public class HomeWork5 {

      public static void main(String[] args) {

        String tempWinEvent = "это получилось";
        String tempLossEvent = "Это не получилось";
        String eventName;
        String eventResult;

        Cat cat = new Cat("пушок", 100, 100, 13f);
        Dog dog = new Dog("Рекс", 0.5f, 250, 10f);
        Horse horse = new Horse("лошадко", 1.5f, 1400, 10f);
        Bird bird = new Bird("Сова", 1.5f, 20, 1f);


        Animal[] arr = {cat, dog, horse, bird};
        float jumpLength = 2.5f;
        float runLength = 250;
        float swimLength = 8;

        for (int i = 0; i < arr.length; i++) {
          String nameString = arr[i].getType() + " " + arr[i].getName() + " может ";


          eventName = "прыгнуть на" + arr[i].getMaxJump() + " Пытается прыгнуть на ";
          eventResult = (arr[i].jump(jumpLength)) ? tempWinEvent : tempLossEvent;
          result(nameString, eventName, jumpLength, eventResult);

          eventName = "пробежать на" + arr[i].getMaxRun() + " Пытается пробежать на ";
          eventResult = (arr[i].run(runLength)) ? tempWinEvent : tempLossEvent;
          result(nameString, eventName, runLength, eventResult);


          int swimResult = arr[i].swim(swimLength);
          eventName = " проплыть на " + arr[i].getMaxSwim() + " попытка проплыть на ";
          eventResult = (swimResult == Animal.SWIM_OK) ? tempWinEvent : tempLossEvent;

          if(swimResult == Animal.SWIM_NONE)
            eventResult = " это не получилось, потому что не умеет плавать ";
          result(nameString, eventName, swimLength, eventResult);

        }

      }
private static void result(String nameAnimal, String event, float eventLength, String resultEvent) {
        System.out.println(nameAnimal + event + eventLength + "м  и" + resultEvent);
}


}
