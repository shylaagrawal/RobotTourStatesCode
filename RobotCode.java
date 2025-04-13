import java.util.*;

public class RobotCode {

    // Global variables for movement times (milliseconds)
    public static int forwardTime = 2565;
    public static int backwardTime = 2528;
    public static int rightTime = 1333;
    public static int leftTime = 1395;
    public static int doubleForwardTime = 3581;
    public static int doubleBackwardTime = 3617;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println();
        System.out.println("-------------------------------------------------------");

        System.out.print("Enter your sequence: ");
        String sequence = sc.nextLine();

        System.out.print("Do you want the code? (y/n): ");
        if (sc.nextLine().equals("y")) {
            generateCode(sequence);
        }

        System.out.println("-------------------------------------------------------");
    }

    public static void calculateTime(String sequence, int targetSeconds) {
        int totalTime = 0;
        for (int i = 0; i < sequence.length(); i++) {
            char move = sequence.charAt(i);
            totalTime += getMoveTime(move);
        }
        System.out.println("Total Time: " + totalTime/1000 + "ms");
    }

    public static int getMoveTime(char move) {
        switch (move) {
            case 'f':
                return forwardTime;
            case 'b':
                return backwardTime;
            case 'r':
                return rightTime;
            case 'l':
                return leftTime;
            case 'F':
                return doubleForwardTime;
            case 'B':
                return doubleBackwardTime;
            default:
                return 0;
        }
    }

    public static void generateCode(String sequence) {
        System.out.println();
        int count = 1;
        System.out.println("finch.startFinch()\nfinch.setBeak(255, 0, 30)\nstart = input.runningTime()\nfinch.setMove(MoveDir.Forward, 28, 75)");
        for (int i = 0; i < sequence.length(); i++) {
            if (sequence.charAt(i) == 'f') {
                System.out.print("finch.setMove(MoveDir.Forward, 50, speed)");
            } else if (sequence.charAt(i) == 'F') {
                System.out.print("finch.setMove(MoveDir.Forward, 100, speed)");
            } else if (sequence.charAt(i) == 'B') {
                System.out.print("finch.setMove(MoveDir.Backward, 100, speed)");
            } else if (sequence.charAt(i) == 'b') {
                System.out.print("finch.setMove(MoveDir.Backward, 50, speed)");
            } else if (sequence.charAt(i) == 'r') {
                System.out.print("finch.setTurn(RLDir.Right, 90, speed)");
            } else if (sequence.charAt(i) == 'l') {
                System.out.print("finch.setTurn(RLDir.Left, 90, speed)");
            }
            System.out.println("     ///" + count);
            count++;
        }

        System.out.println("elapsed = input.runningTime() - start");
        System.out.println("let targetTime = 19");
        System.out.println("if (elapsed/1000 + 2.717 < targetTime) {");
        System.out.println("    let remainingTime = targetTime - (elapsed/1000)");
        System.out.println("    let forwardTime = 2.717");
        System.out.println("    let forwardSpeed = 50/forwardTime");
        System.out.println("    let forwardSpeedConversionFactor = 90/forwardSpeed");
        System.out.println("    let newSlowSpeed = (50/remainingTime) * forwardSpeedConversionFactor");
        System.out.println("    newSlowSpeed /= 2;");
        System.out.println("    if (newSlowSpeed < 5) {");
        System.out.println("        newSlowSpeed = 5");
        System.out.println("    }");
        System.out.println("    finch.setMove(MoveDir.Forward, 50, newSlowSpeed-1)");
        System.out.println("} else{");
        System.out.println("    finch.setMove(MoveDir.Forward, 50, 90)");
        System.out.println("}");
        System.out.println("let totalTime = input.runningTime() - start");
        System.out.println("basic.showNumber(totalTime)");
        System.out.println("basic.showString(\"!\")");        
        System.out.println("basic.showNumber(totalTime)");
        System.out.println("basic.showString(\"!\")");        
        System.out.println("basic.showNumber(totalTime)");
        System.out.println("basic.showString(\"!\")");
        System.out.println("finch.stop()");
        System.out.println("/*\n*/");
    }
}