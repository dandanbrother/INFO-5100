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

    public int getStrength() {
        return strength;
    }

    public class Rock extends Tool {

        public Rock(int strength) {
            super(strength, 'r');
        }

        public boolean fight(Tool tool) {
            if (tool instanceof Paper)
                return (this.strength+1)/2 > tool.strength;
            else if (tool instanceof Scissors)
                return this.strength*2 > tool.strength;
            return false;
        }
    }

    public class Paper extends Tool {

        public Paper(int strength) {
            super(strength, 'p');
        }

        public boolean fight(Tool tool) {
            if (tool instanceof Rock)
                return this.strength*2 > tool.strength;
            else if (tool instanceof Scissors)
                return (this.strength+1)/2 > tool.strength;
            return false;
        }
    }

    public class Scissors extends Tool {

        public Scissors(int strength) {
            super(strength, 's');
        }

        public boolean fight(Tool tool) {
            if (tool instanceof Paper)
                return this.strength*2 > tool.strength;
            else if (tool instanceof Rock)
                return (this.strength+1)/2 > tool.strength;
            return false;
        }
    }
}

class RockPaperScissorsGame{
    public static void main(String args[]){
        Tool t = new Tool(0,'*');
        Tool.Scissors s = t.new Scissors(5);
        Tool.Paper p = t.new Paper(7);
        Tool.Rock r = t.new Rock(15);
        System.out.println(s.fight(p) + " , "+ p.fight(s) );
        System.out.println(p.fight(r) + " , "+ r.fight(p) );
        System.out.println(r.fight(s) + " , "+ s.fight(r) );
    }
}