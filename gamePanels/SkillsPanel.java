package gamePanels;

import javax.swing.*;
import characters.Player;
import skills.Skill;
import java.awt.*;


public class SkillsPanel extends JPanel {

    private Player player;

    private JLabel[][] skillSlots;
    private int rows = 5;
    private int columns = 3;

    //skill details section
    private JLabel skillNameLabel;
    private JLabel skillImgLabel;
    private JLabel skillDamageLabel;
    private JLabel skillCooldownLabel;

    //equipped skills
    private JLabel[] equippedSkillsSlots;

    public SkillsPanel (Player player, Font gameFont) {
        this.player = player;
        
        //--
        setLayout(null);
        setPreferredSize(new Dimension(600,600));
        setBackground(Color.black);
        
        //Components
        skillSlots = new JLabel[rows][columns];

        int startX = 20;
        int startY = 110; 
        int width = 110;
        int height = 90;
        int ySpace = 5;
        int xSpace = 5;

        for (int column = 1; column <= columns; column++) {            
            for (int row = 1; row <= rows; row ++) {
                skillSlots[row-1][column-1] = new JLabel();
                skillSlots[row-1][column-1].setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
                skillSlots[row-1][column-1].setForeground(Color.white);

                //idk how to explaing, basiclly inserts all the labels
                if (row == 1 && column == 1) {
                    skillSlots[row-1][column-1].setBounds(startX, startY, width, height);
                } else if (row == 1) {
                    skillSlots[row-1][column-1].setBounds(startX, startY, width, height);
                } else if (column == 1) {
                    skillSlots[row-1][column-1].setBounds(startX, skillSlots[row-2][column-1].getY() + height + ySpace, width, height);
                } else {
                    skillSlots[row-1][column-1].setBounds(skillSlots[row-2][column-2].getX() + width + xSpace, skillSlots[row-2][column-2].getY() + height + ySpace, width, height);
                }

                add(skillSlots[row-1][column-1]);
            }
            
            startX += width + xSpace;
        }

        setSkillsInSlots();

        // -- skill details section
        skillNameLabel = new JLabel();
        skillNameLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        skillNameLabel.setForeground(Color.white);
        skillNameLabel.setFont(gameFont);
        skillNameLabel.setHorizontalAlignment(JLabel.CENTER);
        skillNameLabel.setBounds(375, startY, 210, 100);

        skillImgLabel = new JLabel("image");
        skillImgLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        skillImgLabel.setForeground(Color.white);
        skillImgLabel.setHorizontalAlignment(JLabel.CENTER);
        skillImgLabel.setBounds(415, skillNameLabel.getY() + skillNameLabel.getHeight() + ySpace, 127, 104);

        skillDamageLabel = new JLabel();
        skillDamageLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        skillDamageLabel.setForeground(Color.white);
        skillDamageLabel.setFont(gameFont);
        skillDamageLabel.setHorizontalAlignment(JLabel.CENTER);
        skillDamageLabel.setBounds(375, skillImgLabel.getY() + skillImgLabel.getHeight() + ySpace, 210, 50);

        skillCooldownLabel = new JLabel();
        skillCooldownLabel.setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
        skillCooldownLabel.setForeground(Color.white);
        skillCooldownLabel.setFont(gameFont);
        skillCooldownLabel.setHorizontalAlignment(JLabel.CENTER);
        skillCooldownLabel.setBounds(375, skillDamageLabel.getY() + skillDamageLabel.getHeight() +ySpace, 210, 50);

        //add components
        add(skillNameLabel);
        add(skillImgLabel);
        add(skillDamageLabel);
        add(skillCooldownLabel);

        // -- equipped skills
        equippedSkillsSlots = new JLabel[4];

        int equippedStartX = 70;
        int equippedStartY = 10;

        for (int slot = 0; slot < 4; slot++) {

            equippedSkillsSlots[slot] = new JLabel();
            equippedSkillsSlots[slot].setBorder(BorderFactory.createLineBorder(Color.darkGray,3));
            equippedSkillsSlots[slot].setForeground(Color.white);

            if (slot == 0) {
                equippedSkillsSlots[slot].setBounds(equippedStartX, equippedStartY, width, height);
            } else {
                equippedSkillsSlots[slot].setBounds(equippedStartX + ((width + xSpace) * slot), equippedStartY, width, height);
            }

            add(equippedSkillsSlots[slot]);
        }

        updateEquippedSkills();
    }

    //--
    public void updateEquippedSkills () {

        Skill[] equippedSkills = player.getEquippedSkills();

        for (JLabel equippedSkillSlot : equippedSkillsSlots) {
            equippedSkillSlot.setText("");
        }

        try {
            equippedSkillsSlots[0].setText(equippedSkills[0].toString());
            equippedSkillsSlots[1].setText(equippedSkills[1].toString());
            equippedSkillsSlots[2].setText(equippedSkills[2].toString());
            equippedSkillsSlots[3].setText(equippedSkills[3].toString());
        } catch (Exception e) { }
    }

    private void setSkillsInSlots () {
        
        Skill[] playerSkills = player.getAllSkills();
        int counter = 0;

        for (JLabel[] skillRow : skillSlots) {

            for (JLabel skillBox : skillRow) {
                //checks if the player has more skills
                if (playerSkills[counter] != null) {
                    skillBox.setText(playerSkills[counter].toString());
                    counter ++;
                }
            }
        }
    }

    public Skill getSkill (int column, int row) {
        int skillNumber = 0;

        if (row == 0) {
            skillNumber = column;
        } else {
            skillNumber = columns * row + column;
        }

        Skill[] playerSkills = player.getAllSkills();

        return playerSkills[skillNumber];
    }


    public void seeSkillDetails (int column, int row) {
        try {
            updateLabelsWithSkill(getSkill(column, row));
        } catch (Exception e) { }
    }

    private void updateLabelsWithSkill (Skill skill) {
        if (skill == null) {
            skillNameLabel.setText("");
            skillDamageLabel.setText("damage: ");
            skillCooldownLabel.setText("cooldown: ");
        } else {
            skillNameLabel.setText(skill.toString());
            skillDamageLabel.setText("damage: " + skill.getDamage());
            skillCooldownLabel.setText("cooldown: " + skill.getCooldown());
        }
    }

    //gets
    public int getGridRows () {
        return rows;
    }
    public int getGridColumns () {
        return columns;
    }
    public JLabel[][] getSkillSlots () {
        return skillSlots;
    }
    public JLabel[] getEquippedSkillSlots () {
        return equippedSkillsSlots;
    }

    
}
