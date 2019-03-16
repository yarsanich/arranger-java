import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Arranger mainArray = new Arranger(new ArrayList());

        mainArray.insertElementToPosition(0, 0); // insert
        mainArray.insertElementToPosition(0, 1); // insert
        mainArray.deleteElementFromPosition(1);
        mainArray.insertElementToPosition(100, 0);
        mainArray.sortArray(Arranger.sortParams.DSC);

        System.out.println(mainArray.getMainArray());
    }
}
