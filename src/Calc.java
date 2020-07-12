import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calc extends JFrame {
    private JTextField resultField;
    private JButton button1;
    private JButton button2;
    private JButton button3;
    private JButton button4;
    private JButton button5;
    private JButton button6;
    private JButton button7;
    private JButton button8;
    private JButton button9;
    private JButton button0;
    private JButton buttonMult;
    private JButton buttonPlus;
    private JButton buttonDiv;
    private JButton buttonMinus;
    private JButton buttonClear;
    private JButton buttonResult;

    public Calc() {
        //main window
        setTitle("Calc Demo");
        setBounds(600, 100, 300, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setResizable(false);

        //top line
        JPanel topPanel = new JPanel();
        topPanel.setLayout(new BoxLayout(topPanel, BoxLayout.X_AXIS));
        add(topPanel, BorderLayout.PAGE_START);

        resultField = new JTextField();
        resultField.setEditable(false);
        Font font = new Font("Default", Font.BOLD, 24);
        resultField.setFont(font);
        topPanel.add(resultField);


        //operation buttons
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new GridLayout(4,4));
        add(bottomPanel, BorderLayout.CENTER);

        ActionListener btListener = new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JButton curButton = (JButton) e.getSource();
                addOperator(curButton.getText());
            }
        };

        button1 = new JButton("1");
        button1.addActionListener(btListener);
        bottomPanel.add(button1);

        button2 = new JButton("2");
        button2.addActionListener(btListener);
        bottomPanel.add(button2);

        button3 = new JButton("3");
        button3.addActionListener(btListener);
        bottomPanel.add(button3);

        buttonPlus = new JButton("+");
        buttonPlus.addActionListener(btListener);
        bottomPanel.add(buttonPlus);

        button4 = new JButton("4");
        button4.addActionListener(btListener);
        bottomPanel.add(button4);

        button5 = new JButton("5");
        button5.addActionListener(btListener);
        bottomPanel.add(button5);

        button6 = new JButton("6");
        button6.addActionListener(btListener);
        bottomPanel.add(button6);

        buttonMinus = new JButton("-");
        buttonMinus.addActionListener(btListener);
        bottomPanel.add(buttonMinus);

        button7 = new JButton("7");
        button7.addActionListener(btListener);
        bottomPanel.add(button7);

        button8 = new JButton("8");
        button8.addActionListener(btListener);
        bottomPanel.add(button8);

        button9 = new JButton("9");
        button9.addActionListener(btListener);
        bottomPanel.add(button9);

        buttonMult = new JButton("*");
        buttonMult.addActionListener(btListener);
        bottomPanel.add(buttonMult);

        buttonClear = new JButton("C");
        buttonClear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resultField.setText("");
            }
        });
        bottomPanel.add(buttonClear);

        button0 = new JButton("0");
        button0.addActionListener(btListener);
        bottomPanel.add(button0);

        buttonResult = new JButton("=");
        buttonResult.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    calculateResult();
                } catch (ScriptException scriptException) {
                    scriptException.printStackTrace();
                }
            }
        });
        bottomPanel.add(buttonResult);

        buttonDiv = new JButton("/");
        buttonDiv.addActionListener(btListener);
        bottomPanel.add(buttonDiv);

        setVisible(true);
    }

    private void addOperator(String op) {
        if (op.length() > 0){
            boolean addFlag = false;
            String txtValue = resultField.getText();

            char currentChar = op.charAt(0);
            //0 + - * / можно поставить, если последний символ цифра
            if (currentChar == '0' || currentChar == '+' || currentChar == '-' || currentChar == '/' || currentChar == '*') {
                if (txtValue.length() > 0) {
                    char lastChar = txtValue.charAt(txtValue.length()-1);
                    if (!(lastChar == '+' || lastChar == '-' || lastChar == '/' || lastChar == '*')) {
                        addFlag = true;
                        if (currentChar == '+' || currentChar == '-' || currentChar == '/' || currentChar == '*') {
                            try {
                                calculateResult();
                            } catch (ScriptException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            } else {
                addFlag = true;
            }

            if (addFlag) {
                StringBuilder stringBuilder = new StringBuilder(resultField.getText());
                stringBuilder.append(op);
                resultField.setText(stringBuilder.toString());
                stringBuilder.setLength(0);
            }
        }
    }

    private void calculateResult() throws ScriptException {
        String script = resultField.getText();

        if (!script.isBlank()) {
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("JavaScript");

            Object result = engine.eval(script);
            resultField.setText(result.toString());
        }
    }
}
