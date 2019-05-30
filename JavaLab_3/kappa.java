import org.mariuszgromada.math.mxparser.Expression;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.text.MessageFormat;


public class kappa {
    private  JPanel mainPanel;
    private JTextArea historyTextArea;
    protected JList functionsList;
    private JButton evalButton;
    protected JTextField formulaInput;
    private JScrollPane scrollContainerPane;
    private javax.swing.JPanel JPanel;
    public String last_input;

    private static double v =0;

    public static double getV() {
        return v;
    }

    public JList getFunctionsList() {
        return functionsList;
    }

    public kappa(){
        this.createUIComponents();
        evalButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String field = formulaInput.getText();
                addText(formulaInput.getText());
                last_input = formulaInput.getText();
                formulaInput.setText("");
            }
        });
        historyTextArea.setEditable(false);

        formulaInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                super.keyPressed(e);
                if(e.getKeyCode()==KeyEvent.VK_UP){
                    formulaInput.setText(last_input);
                }
                else if(e.getKeyCode()==KeyEvent.VK_ENTER){
                    addText(formulaInput.getText());
                    formulaInput.setText("");
                }
            }
        });
    }

    private void addText(String expression) {

        Expression e = new Expression(expression);
        if (e.checkSyntax()) {
            v = e.calculate();
            historyTextArea.setText(historyTextArea.getText() +
                    MessageFormat.format("{0}={1,number}\n", expression, v));
        }
        else {
            JOptionPane.showMessageDialog(null, "Error", "Error",JOptionPane.ERROR_MESSAGE);

        }
    }

    public String getLastResult(){return this.last_input;}

    private void setLastInput(){
        formulaInput.setText(last_input);
    }

    private void createUIComponents() {
        JMenuBar menuBar = new JMenuBar();
        JMenu options = new JMenu("Options");
        JMenuItem reset = new JMenuItem("Reset");
        JMenuItem exit = new JMenuItem("Exit");
        exit.addActionListener(this::eActionListener);
        options.add(reset);
        options.add(exit);
        menuBar.add(options);

        JFrame frame = new JFrame("kappa");
        frame.setContentPane(this.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setJMenuBar(menuBar);



        frame.setSize(800,600);
        frame.setVisible(true);

    }

    public JTextArea getHistoryTextArea() {
        return historyTextArea;
    }

    public JTextField getFormulaInput() {
        return formulaInput;
    }

    private void eActionListener(ActionEvent e) {
        System.exit(0);
    }
}
