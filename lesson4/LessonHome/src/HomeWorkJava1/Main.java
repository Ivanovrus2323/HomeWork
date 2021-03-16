package HomeWorkJava1;

public class Main {
    public static void main(String[] args) {
        JumpRun[] members = {
                new Human(1,1,"Боря"),
                new Cat(2,2,"Пушок"),
                new Robot(3,4,123),
        };

        Obstaclable[] obstacles = {
                new RunningTrack(1),
                new RunningTrack(4),
                new Wall(1),
                new Wall(3)
        };

        for (JumpRun member : members) {
            System.out.println("К прохождению препятствий приступает " + member);
            boolean winner = true;
            for (Obstaclable obstacle : obstacles) {
                System.out.println(member + " пробует пройти " + obstacle);
                if (obstacle.toJump(member.getMaxHeight()) ||
                        obstacle.toRun(member.getMaxLength())) {
                    System.out.println(" у него получилось");
                } else {
                    winner = false;
                    System.out.println("у него не получилось");
                    break;
                }
            }

            if(winner) {
                System.out.println(member + " победил");
            } else {
                System.out.println(member + " проиграл");
            }
            System.out.println();
        }
    }
}
