package sample;

import javafx.concurrent.Task;
import javafx.embed.swing.SwingFXUtils;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class AsyncTaskv2 extends Task {


    private static final double MIN = -8;
    private static final double MAX = 8;
    static boolean separator = false;
    private GraphicsContext gc;
    private int numberOfPoints;
    private long yellowPoints = 0;
    private long greyPoints = 0;


    AsyncTaskv2(GraphicsContext graphicsContext, int numberOfPoints){

        this.gc = graphicsContext;
        this.numberOfPoints = numberOfPoints;

    }

    @Override
    protected Object call() throws Exception {

        draw2();
        return null;

    }

    private void draw2 () {

        BufferedImage bi = new BufferedImage(1280, 720, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < numberOfPoints; i++) {
            if(separator)
                break;
            Random random = new Random();
            double x = MIN + (MAX - MIN) * random.nextDouble();
            double y = MIN + (MAX - MIN) * random.nextDouble();
            int m = (int) (1280 * (x +8) / 16);
            int n = (int) (720 * (y + 8) / 16);
            if(Equation.calc(x,-y)) {
                bi.setRGB(m, n, Color.YELLOW.getRGB());
                yellowPoints++;
            }
            else {
                bi.setRGB(m, n, Color.GRAY.getRGB());
                greyPoints++;
            }
            if(i%1000 == 0)
                gc.drawImage(SwingFXUtils.toFXImage(bi, null), 0, 0);
            updateProgress(i+1,numberOfPoints);

        }

        double result = (double)yellowPoints/(double)greyPoints;
        result *= 256;
        Form.result = result;

    }
}