package characters;

import javax.swing.JLabel;
import skills.Skill;

public class Enemy {
    //enemy stats
    private String name = "Enemy";
    private int maxHealth;
    private int health;
    private int xp;

    //actions
    private boolean isDefending = false;
    private boolean isAttacking = false;
    private boolean isWaiting = false;
     
    //--
    private JLabel enemyActionLabel;
    
    private Skill rewardSkill;
    //--
    public void getHit (Skill attack) { }
    
    //actions
    public void startActions (Player player) { }

    //gets
    public String getName () {
        return name;
    }
    public int getMaxHealth () {
        return maxHealth;
    }
    public int getHealth () {
        return health;
    }
    public int getXp () {
        return xp;
    }
    public boolean getIsDefending () {
        return isDefending;
    }
    public boolean getIsAttacking () {
        return isAttacking;
    }
    public boolean getIsWaiting () {
        return isWaiting;
    }
    public JLabel getEnemyActionLabel () {
        return enemyActionLabel;
    }
    public Skill getRewardSkill () {
        return rewardSkill;
    }
    //sets
    public void setIsDefending (boolean isDefending) {
        this.isDefending = isDefending;
    }
    public void setIsAttacking (boolean isAttacking) {
        this.isAttacking = isAttacking;
    }
    public void setIsWaiting (boolean isWaiting) {
        this.isWaiting = isWaiting;
    }
    public void setFightPanel (JLabel enemyActionLabel) {
        this.enemyActionLabel = enemyActionLabel;
    }

    //--
    public String toString () {
        return name;
    }
}
