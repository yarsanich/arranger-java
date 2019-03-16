import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayUI {
    private JButton saveYourArrayButton;
    private JButton sortASCButton;
    private JButton sortDSCButton;
    private JTextField insertElementTextField;
    private JButton insertElementButton;
    private JTextField toPositionTextField;
    private JTextField fromPositionTextField;
    private JButton deleteElementFromPositionButton;
    private JPanel contentPane;
    private JFormattedTextField mainArrayField;
    private Arranger mainArray;

    private List<Integer> getListFromMainArrayField() {
        String [] numString = mainArrayField.getText().trim().split(",");
        ArrayList<Integer> parsedList = new ArrayList<Integer>();
        for (String element: numString) {
            parsedList.add(Integer.parseInt(element));
        }

        return parsedList;
    };

    private static Integer getIntValueFromField(JTextField field) {
        return Integer.parseInt(field.getText());
    }

    private void setListToMainArrayField(List<Integer> listToField){
        mainArrayField.setText(
            listToField.toString()
                .replace("[", "")  //remove the right bracket
                .replace("]", "")
                .replace(" ", "")
        );
    };

    public ArrayUI() {
        mainArray = new Arranger(new ArrayList<>());
        saveYourArrayButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainArray.setMainArray(getListFromMainArrayField());
            }
        });
        sortASCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainArray.sortArray(Arranger.sortParams.ASC);
                System.out.println(mainArray.getMainArray());
                setListToMainArrayField(mainArray.getMainArray()); // XXX TODO Remove duplication
            }
        });
        sortDSCButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                mainArray.sortArray(Arranger.sortParams.DSC);
                setListToMainArrayField(mainArray.getMainArray()); // XXX TODO Remove duplication
            }
        });
        insertElementButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer elementToInsert = getIntValueFromField(insertElementTextField);
                Integer positionToInsert = getIntValueFromField(toPositionTextField);

                mainArray.insertElementToPosition(elementToInsert, positionToInsert);
                setListToMainArrayField(mainArray.getMainArray()); // XXX TODO Remove duplication
            }
        });
        deleteElementFromPositionButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Integer fromPosition = getIntValueFromField(fromPositionTextField);
                mainArray.deleteElementFromPosition(fromPosition);
                setListToMainArrayField(mainArray.getMainArray()); // XXX TODO Remove duplication
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("ArrayUI");
        frame.setContentPane(new ArrayUI().contentPane);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
