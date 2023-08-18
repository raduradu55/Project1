package characters;

import java.io.Serializable;

import javax.swing.JLabel;
import skills.Skill;

public class TestEnemy extends Enemy implements Serializable{
    //enemy stats
    private String name = "test enemy";
    private int maxHealth;
    private int health;

    //actions
    private boolean isDefending = false;
    private boolean isAttacking = false;
    private boolean isWaiting = false;

    private Player player;
     
    //--
    private JLabel enemyActionLabel;

    public TestEnemy () {
        maxHealth = 100;
        health = maxHealth;
    }

    //--
    public void getHit (Skill attack) {
        health -= attack.getDamage();
    }
    

    //actions
    public void startActions (Player player) {
        this.player = player;

        while (health > 0) {

            action1(player);
        }
    }

    private void attack (int damage) {
        
        if (!player.isBlocking() && !player.isDodging()) {
            player.getHit(damage);
            enemyActionLabel.setText("attack");

        } else if (player.isBlocking()) {
            player.getHit(damage / 2);
            enemyActionLabel.setText("player blocked");

        } else if (player.isDodging()) {

            enemyActionLabel.setText("player dodged");
        }
    }

    private void action1 (Player player) {
        int duration = 5;
        long startTime;
        long endTime;

        for (int i=duration; i>=0; i--) {
            startTime = System.nanoTime();
            //--

            enemyActionLabel.setText(Integer.toString(i));

            if (i == 0) {
                attack(10);
            }

            //--
            endTime = System.nanoTime();
            try {
                Thread.sleep((1000000000 - (endTime-startTime)) / 1000000);
            } catch (Exception e) { }
        }
    }

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
    public boolean getIsDefending () {
        return isDefending;
    }
    public boolean getIsAttacking () {
        return isAttacking;
    }
    public boolean getIsWaiting () {
        return isWaiting;
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
