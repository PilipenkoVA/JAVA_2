public class Human implements Participants{
    public String name;
    public int heightLimit;
    public int lengthLimit;
    private boolean onDistance;

    public Human(String name, int heightLimit, int lengthLimit) {
        this.name = name;
        this.heightLimit = heightLimit;
        this.lengthLimit = lengthLimit;
        this.onDistance = true;
    }

    @Override
    public void run(int length) {
        if (length<=lengthLimit){
            System.out.println(name+ " - пробежал всю дистанцию.");
        }else {
            System.out.println(name+ " - не побежал,т.к. растояние очень большое.");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height<=heightLimit){
            System.out.println(name+ " - перепрыгнул припятствие.");
        }else {
            System.out.println(name+ " - не перепрыгнул припятствие, т.к. не умеет так высоко прыгать.");
            onDistance = false;
        }
    }

    @Override
    public boolean onDistance() {
        return onDistance;
    }
}
