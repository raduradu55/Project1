package skills;

import characters.Enemy;

public class Skill {
    
    private String name = "Skill par";
    private int damage;
    
    //gets
    public int getDamage () {
        return damage;
    }

    //--
    public String toString () {
        return name;
    }
}
