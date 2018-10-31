package com.info;

public class Tool {
    protected int strength;
    protected char type;

    public Tool(int strength, char type) {
        this.strength = strength;
        this.type = type;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }
}

class Rock extends Tool {

    public Rock(int strength) {
        super(strength, 'r');
    }

    public boolean fight(Tool tool) {
        if (tool instanceof Paper)
            return this.strength/2 > tool.strength;
        else if (tool instanceof Scissors)
            return this.strength*2 > tool.strength;
        return false;
    }
}

class Paper extends Tool {

    public Paper(int strength) {
        super(strength, 'p');
    }

    public boolean fight(Tool tool) {
        if (tool instanceof Rock)
            return this.strength*2 > tool.strength;
        else if (tool instanceof Scissors)
            return this.strength/2 > tool.strength;
        return false;
    }
}

class Scissors extends Tool {

    public Scissors(int strength) {
        super(strength, 's');
    }

    public boolean fight(Tool tool) {
        if (tool instanceof Paper)
            return this.strength*2 > tool.strength;
        else if (tool instanceof Rock)
            return this.strength/2 > tool.strength;
        return false;
    }
}

class RockPaperScissorsGame{
    public static void main(String args[]){
        Scissors s = new Scissors(5);
        Paper p = new Paper(7);
        Rock r = new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}