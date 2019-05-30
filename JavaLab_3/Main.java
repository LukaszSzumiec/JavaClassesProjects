import javax.swing.*;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                kappa CaLCULATOR = new kappa();
                new funList(CaLCULATOR.getFunctionsList(),CaLCULATOR.getFormulaInput());
                CaLCULATOR.getFormulaInput().requestFocusInWindow();
            }
        });
    }
}
