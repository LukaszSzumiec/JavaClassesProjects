import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;



public class funList extends JList {
    public funList(final JList<function> functionsList, final JTextField formulaInput) {
        function sinus = new function("sinus","sin()");
        function cosine = new function("cosine","cos()");
        function tangent = new function("tangent","tg()");

        function logarithm = new function("logarithm","log()");
        function modulo= new function("modulo","mod()");
        function binomialCoefficient= new function("Binomial coefficient function", "C()");

        function pi= new function("PI","pi");
        function e= new function("e","e");
        function goldenRatio= new function("Golden ratio", "[phi]");
        //function BernsteinConstant=new function("Bernstein's constant","B");
        function lastResult = new function("Last Result","lastResult");

        final DefaultListModel<function> model = new DefaultListModel<>();

        model.addElement(sinus);
        model.addElement(cosine);
        model.addElement(tangent);

        model.addElement(logarithm);
        model.addElement(modulo);
        model.addElement(binomialCoefficient);

        model.addElement(pi);
        model.addElement(e);
        model.addElement(goldenRatio);

        model.addElement(lastResult);

        functionsList.setModel(model);

        functionsList.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int Index=functionsList.getSelectedIndex();

                super.mouseClicked(e);

                if(e.getClickCount()==2){
                    if(Index<5) {
                        formulaInput.setText(formulaInput.getText() + functionsList.getModel().getElementAt(Index).getShortcut());
                        formulaInput.requestFocusInWindow();
                        formulaInput.setCaretPosition(formulaInput.getText().length());
                    }
                    else if(Index>=5 && Index<9){
                        formulaInput.setText(formulaInput.getText()+functionsList.getModel().getElementAt(Index).getShortcut());
                        formulaInput.requestFocusInWindow();
                        formulaInput.setCaretPosition(formulaInput.getText().length());
                    }
                    else if(Index == 9){
                        formulaInput.setText(String.valueOf(kappa.getV()));
                    }
                    else {
                        formulaInput.setText(String.valueOf(0));
                    }
                }
            }
        });
    }
}
