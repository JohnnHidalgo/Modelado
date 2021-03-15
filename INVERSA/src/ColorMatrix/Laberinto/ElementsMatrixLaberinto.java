package ColorMatrix.Laberinto;

import java.awt.*;

public class ElementsMatrixLaberinto {
    private int number;
    private Color color;
    private int usedInFigure;

    public ElementsMatrixLaberinto(int number, Color color,int usedInFigure) {
        this.number = number;
        this.color = color;
        this.usedInFigure=usedInFigure;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getUsedInFigure() {
        return usedInFigure;
    }

    public void setUsedInFigure(int usedInFigure) {
        this.usedInFigure = usedInFigure;
    }
}
