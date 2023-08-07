package arrays;

public class WorkerOne {
    public static void main(String[] args) {
        final var squad = new SquadArray(15);

        squad.insertItem(23);
        squad.insertItem(515);
        squad.insertItem(11);
        squad.insertItem(223);
        squad.insertItem(55);
        squad.insertItem(62);
        squad.insertItem(264);
        squad.insertItem(118);

        squad.display();

        System.out.println("11 found at index: " + squad.searchKey(11));

        System.out.println("113 found at index: " + squad.searchKey(113));

        System.out.println("Deletion of 223 -->");

        squad.delete(223);
        squad.display();

        System.out.println("Insertion of 555 -->");
        squad.insertItem(555);
        squad.display();



    }
}
