public class RunWay implements Trials{
    private int lenght;

    public RunWay(int lenght) {
        this.lenght = lenght;
    }

    @Override
    public void doThis(Participants participants) {
        participants.run(lenght);
    }
}
