package ColorMatrix.Laberinto;

public class RoadTaked {
    int isLeft;
    int isRight;
    int isLow;
    int isTop;

    public RoadTaked(int isLeft, int isRight, int isLow, int isTop) {
        this.isLeft = isLeft;
        this.isRight = isRight;
        this.isLow = isLow;
        this.isTop = isTop;
    }

    public int getIsLeft() {
        return isLeft;
    }

    public void setIsLeft(int isLeft) {
        this.isLeft = isLeft;
    }

    public int getIsRight() {
        return isRight;
    }

    public void setIsRight(int isRight) {
        this.isRight = isRight;
    }

    public int getIsLow() {
        return isLow;
    }

    public void setIsLow(int isLow) {
        this.isLow = isLow;
    }

    public int getIsTop() {
        return isTop;
    }

    public void setIsTop(int isTop) {
        this.isTop = isTop;
    }
}
