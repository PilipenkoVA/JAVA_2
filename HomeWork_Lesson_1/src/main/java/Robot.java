public class Robot implements Participants{
    public String name;
    public int heightLimit;
    public int lengthLimit;
    private boolean onDistance;

    public Robot(String name, int heightLimit, int lengthLimit) {
        this.name = name;
        this.heightLimit = heightLimit;
        this.lengthLimit = lengthLimit;
        this.onDistance = true;
    }

    @Override
    public void run(int length) {
        if (length <= lengthLimit){
            System.out.println(name+ " - проехал всю дистанцию.");
        }else {
            System.out.println(name+ " - не поехал, растояние, т.к. привышает лимит заряда.");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height <= heightLimit){
            System.out.println(name+ " - перепрыгнул преграду.");
        }else {
            System.out.println(name+ " - не перепрыгнул припятствие.");
            onDistance = false;
        }
    }

    @Override
    public boolean onDistance() {
        return onDistance;
    }
}
