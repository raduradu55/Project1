package gamePanels;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import characters.Enemy;
import java.awt.*;

public class RewardsPanel extends JPanel {

    private Enemy enemy;

    private JLabel youKilled;
    private JLabel enemyName;
    private JLabel graySquare;
    private JLabel xpGained;
    private JLabel enterKey;

    public RewardsPanel (Font gameFont, Enemy enemy) {
        this.enemy = enemy;

        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.BLACK);

        //components
        youKilled = new JLabel("you killed");
        youKilled.setFont(gameFont.deriveFont(65f));
        youKilled.setHorizontalAlignment(JLabel.CENTER);
        youKilled.setForeground(Color.white);
        youKilled.setBounds(50, 50, 500, 130);

        enemyName = new JLabel();
        enemyName.setForeground(Color.white);
        enemyName.setHorizontalAlignment(JLabel.CENTER);
        enemyName.setBounds(youKilled.getX(), youKilled.getY() + +40, 500, 170);
        enemyName.setFont(gameFont.deriveFont(50f));

        graySquare = new JLabel();
        graySquare.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        graySquare.setBounds(50, 50, 500, 200);

        xpGained = new JLabel();
        xpGained.setBorder(BorderFactory.createLineBorder(Color.darkGray, 3));
        xpGained.setFont(gameFont);
        xpGained.setHorizontalAlignment(JLabel.CENTER);
        xpGained.setBounds(150, 260, 300, 50);
        xpGained.setForeground(Color.white);

        enterKey = new JLabel("press [enter] to continue");
        enterKey.setForeground(Color.white);
        enterKey.setHorizontalAlignment(JLabel.CENTER);
        enterKey.setBounds(100, 500, 400, 50);
        enterKey.setFont(gameFont.deriveFont(20f));

        //add comps
        add(youKilled);
        add(enemyName);
        add(graySquare);
        add(xpGained);
        add(enterKey);

        updateEnemyName();

    }

    private void updateEnemyName () {
        enemyName.setText(enemy.getName());
        xpGained.setText("+ " + enemy.getXp() + " xp");
    }
}