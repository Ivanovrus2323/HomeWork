package HomeWorkJava1;

public class Robot implements JumpRun{
    int maxHeight;
    int maxLength;
    int serialNumber;

    public Robot(int maxHeight, int maxLength, int serialNumber) {
        this.maxHeight = maxHeight;
        this.maxLength = maxLength;
        this.serialNumber = serialNumber;
    }

    @Override
    public int getMaxHeight() {
        return maxHeight;
    }

    @Override
    public void jump() {
        System.out.println("Robot jump");
    }

    @Override
    public int getMaxLength() {
        return maxLength;
    }

    @Override
    public void run() {
        System.out.println("Robot run");
    }

    @Override
    public String toString() {
        return "Робот с номером " + serialNumber;
    }
}