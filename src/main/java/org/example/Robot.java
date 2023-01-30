package org.example;

public class Robot {
    final String LEFT = "L";
    final String RIGTH = "R";
    final String MOVE = "M";
    int limitX;
    int limitY;
    private Position position;
    Robot(int limitX, int limitY, Position position){
        this.limitX = limitX;
        this.limitY = limitY;
        this.position = position;
    }

    public Position getPosition(){
        return this.position;
    }

    public void setPosition(Position position){
        this.position = position;
    }

    public String start(String instructions){
        String[] moves = instructions.split("");
        for (String instruction : moves) {
            if(MOVE.equals(instruction)){
                if(canMove()){move();}
            } else {
                rotate(instruction);
            }
        }
        return getPosition().toString();
    }

    private boolean canMove(){
        Position p = getPosition();
        int newRow = p.getRow();
        int newCol = p.getCol();
        switch(p.getOrientation()){
            case N: return (newCol + 1) <= limitY;
            case E: return (newRow + 1) <= limitX;
            case S: return (newCol - 1) >= 0;
            case W: return (newRow - 1) >= 0;
        }
        return false;
    }
    private void move(){
        Position p = getPosition();
        int row = p.getRow();
        int col = p.getCol();
        switch(p.getOrientation()){
            case N: p.setCol(++col); break;
            case E: p.setRow(++row); break;
            case S: p.setCol(--col); break;
            case W: p.setRow(--row);
        }
        setPosition(p);
    }

    private void rotate(String side){
        Orientation or = getPosition().getOrientation();
        if(RIGTH.equals(side)){
            switch (or){
                case N:getPosition().setOrientation(Orientation.E);break;
                case E:getPosition().setOrientation(Orientation.S);break;
                case S:getPosition().setOrientation(Orientation.W);break;
                case W:getPosition().setOrientation(Orientation.N);break;
            }
        } else if(LEFT.equals(side)){
            switch (or){
                case N:getPosition().setOrientation(Orientation.W);break;
                case E:getPosition().setOrientation(Orientation.N);break;
                case S:getPosition().setOrientation(Orientation.E);break;
                case W:getPosition().setOrientation(Orientation.S);break;
            }

        }
    }
}