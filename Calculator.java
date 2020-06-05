import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator extends JFrame {

    //переменные для арифметической логики
    private double symbolNumber1;
    private double symbolNumber2;
    private String symbolArithmetic = "";
    private double result;

    public Calculator () {
        setTitle ("Calculator");
        setDefaultCloseOperation (WindowConstants.EXIT_ON_CLOSE);
        setBounds (300 , 300 , 255 , 329);
        setResizable(false);

        setLayout(null);

        JTextField textField = new JTextField();
        textField.setBounds(0,0,250,100);
        add (textField);

        //цифры
        String[][] numSymbols = {{"7","8","9"},{"4","5","6"},{"1","2","3"}};

        JButton[][] numButtons = new JButton[3][3];

        //начальные координаты кнопки
        int x = 0;
        int y = 0 + textField.getHeight();

        for(int i = 0; i < numButtons.length; i++) {
            x = 0;
            for (int j = 0; j < numButtons.length; j++) {
                numButtons[i][j] = new JButton(numSymbols[i][j]);
                numButtons[i][j].setBounds(x, y,50,50);
                numButtons[i][j].setBackground(new Color(0, 222, 255, 255));
                add(numButtons[i][j]);
                int finalI = i;
                int finalJ = j;
                numButtons[i][j].addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        textField.setText(numButtons[finalI][finalJ].getText());

                        if(symbolArithmetic.isEmpty()) symbolNumber1 = Integer.parseInt(numSymbols[finalI][finalJ]);
                        else symbolNumber2 = Integer.parseInt(numSymbols[finalI][finalJ]);
                    }
                });
                x += 50;
            }
            y += 50;
        }

        y = textField.getHeight();

        //кнопка 0
        JButton button_0 = new JButton("0");
        button_0.setBounds(0,250,150,50);
        button_0.setBackground(new Color(0, 222, 255, 255));
        add(button_0);
        button_0.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textField.setText(button_0.getText());

                if(symbolArithmetic.isEmpty()) symbolNumber1 = 0;
                else symbolNumber2 = 0;
            }
        });

        //кнопки арифметических операций
        String[] arithmeticSymbols = {"/", "*", "-", "+"};
        JButton[] arithmeticButtons = new JButton[4];

        for (int i = 0; i < arithmeticButtons.length; i++){
            arithmeticButtons[i] = new JButton(arithmeticSymbols[i]);
            arithmeticButtons[i].setBounds(x,y,50,50);
            arithmeticButtons[i].setBackground(new Color(253, 170, 237, 255));
            add(arithmeticButtons[i]);
            y += 50;
            int finalI = i;
            arithmeticButtons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    textField.setText(arithmeticButtons[finalI].getText());
                    symbolArithmetic = arithmeticSymbols[finalI];
                }
            });
        }

        x += 50;
        y = textField.getHeight();

        //кнопка =
        JButton button_equal = new JButton("=");
        button_equal.setBounds(x,y,50,200);
        button_equal.setBackground(new Color(248, 235, 160, 255));
        add(button_equal);
        button_equal.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                doCalcLogic();
                textField.setText(String.valueOf(result));

                symbolNumber2 = 0;
                symbolArithmetic = "";
                result = 0;
            }
        });

        setVisible (true);
    }

    private void doCalcLogic(){
        switch (symbolArithmetic){
            case "/":
                result = (double) symbolNumber1 / symbolNumber2;
                symbolNumber1 = result;
                break;

            case "*":
                result = symbolNumber1 * symbolNumber2;
                symbolNumber1 = result;
                break;

            case "-":
                result = symbolNumber1 - symbolNumber2;
                symbolNumber1 = result;
                break;

            case "+":
                result = symbolNumber1 + symbolNumber2;
                symbolNumber1 = result;
                break;

            case "":
                result = symbolNumber1;
        }

/*              //та же логика, но через if-else. рабочая

                if(symbolArithmetic.equals("/")) {
                    result = (double) symbolNumber1 / symbolNumber2;
                    symbolNumber1 = result;
                }
                else if (symbolArithmetic.equals("*")) {
                    result = symbolNumber1 * symbolNumber2;
                    symbolNumber1 = result;
                }
                else if (symbolArithmetic.equals("-")) {
                    result = symbolNumber1 - symbolNumber2;
                    symbolNumber1 = result;
                }
                else if (symbolArithmetic.equals("+")) {
                    result = symbolNumber1 + symbolNumber2;
                    symbolNumber1 = result;
                }
                else if (symbolArithmetic.isEmpty()) {
                    result = symbolNumber1;
                }
*/
    }

}
