public class Wall implements Trials{
    private int height;

    public Wall(int height) {
        this.height = height;
    }

    @Override
    public void doThis(Participants participants) {
        participants.jump(height);
    }
}
