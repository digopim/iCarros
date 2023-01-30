package org.example;

import java.util.Objects;

public class Position {
    private int row;
    private int col;
    private Orientation orientation;
    Position(int row, int col, String ori){
        this.row = row;
        this.col = col;
        this.orientation = Orientation.valueOf(ori);
    }
    int getRow(){
        return row;
    }

    int getCol(){
        return col;
    }
    public Orientation getOrientation() {
        return orientation;
    }
    public void setOrientation(Orientation orientation) {
        this.orientation = orientation;
    }
    public void setCol(int col) {
        this.col = col;
    }
    public void setRow(int row) {
        this.row = row;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return row == position.row && col == position.col;
    }

    @Override
    public int hashCode() {
        return Objects.hash(row, col);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        return sb.append(getRow()).append(" ").append(getCol()).append(" ").append(getOrientation().name()).toString();
    }
}
