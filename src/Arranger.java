import java.util.Collections;
import java.util.List;

public class Arranger {

    private List<Integer> targetArray;

    public enum sortParams {
        ASC,
        DSC,
    };

    public Arranger(List<Integer> inputArray) {
        targetArray = inputArray;
    }

    private void logPositionError(int position) {
        System.out.println("Position is not correct " + position + " because array size is " + targetArray.size());
    }

    public void clearArray() {
        targetArray.clear();
    }

    public void insertElementToPosition(int numberToInsert, int position) {
        try {
            targetArray.add(position, numberToInsert);
        }
        catch (IndexOutOfBoundsException e) {
            // find out how to format strings
            logPositionError(position);
        }
    }

    public void deleteElementFromPosition(int positionToDelete) {
        try {
            targetArray.remove(positionToDelete);
        }
        catch (IndexOutOfBoundsException e) {
            logPositionError(positionToDelete);
        }
    }

    public void sortArray(sortParams param) {

        System.out.println(param);

        switch (param) {
            case ASC:
                Collections.sort(targetArray);
                break;
            case DSC:
                Collections.sort(targetArray, Collections.reverseOrder());
                break;
            default:
                System.out.println("Wrong sort param");
                break;
        }
    }

    public List<Integer> getMainArray() {
        return targetArray;
    }
    public void setMainArray(List<Integer> arrayToSet) { targetArray = arrayToSet; }
}
