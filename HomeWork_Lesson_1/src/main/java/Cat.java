public class Cat implements Participants{
    public String name;
    public int heightLimit;
    public int lengthLimit;
    private boolean onDistance;

    public Cat(String name, int heightLimit, int lengthLimit) {
        this.name = name;
        this.heightLimit = heightLimit;
        this.lengthLimit = lengthLimit;
        this.onDistance = true;
    }

    @Override
    public void run(int length) {
        if (length<=lengthLimit){
            System.out.println(name+ " - пробежал все дистанцию.");
        }else {
            System.out.println(name+ " - не пробежал дистанцию, т.к. очень ленив.");
            onDistance = false;
        }
    }

    @Override
    public void jump(int height) {
        if (height<=heightLimit){
            System.out.println(name+ " - перепрыгнул припятствие легко (он же кошка).");
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
