public class Tank {

    private int x;
    private int y;
    private int fuel;
    private int turn;

    public Tank() {
        this(0, 0, 100);
    }

    public Tank(int x, int y) {
        this(x, y, 100);
    }

    public Tank(int x, int y, int fuel) {
        this.x = x;
        this.y = y;
        this.fuel = fuel;
    }

    public void goForward(int i) {
        if (i < 0 && -i > fuel) {
            i = -fuel;
        } else if (i > fuel) {
            i = fuel;
        }
        if (turn == 0) {
            x += i;
        } else if (turn == 180) {
            x -= i;
        } else if (turn == 90) {
            y += i;
        } else {
            y -= i;
        }
        fuel -= Math.abs(i);
    }

    public void printPosition() {
        System.out.println("The Tank is at " + x + ", " + y + " now.");
    }


    public void goBackward(int i) {
        goForward(-i);
    }

    public void turnRight() {
        if (turn == 270) {
            turn = 0;
        } else {
            turn += 90;
        }
    }

    public void turnLeft() {
        if (turn == 0) {
            turn = 270;
        } else {
            turn -= 90;
        }
    }
}
