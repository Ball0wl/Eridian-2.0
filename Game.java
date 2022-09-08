package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Game extends JFrame {

    Container con;
    JPanel titleNamePnl, startBtnPnl, mainTextPnl, choiceBtnPnl, playerPnl;
    JLabel titleNameLabel, hpLbl, hpLblNum, weaponLabel, weaponLabelName, manaLbl, manaLblNum;
    JButton btnStart,choice1,choice2,choice3,choice4;
    JTextArea mainTextArea;
    int playerHp, playerMana, visitedForest, gegnerHp, gegnerAngriff, playerAngriff;
    String weapon, position;
    boolean mask, brokenHilt;

    ActionTitleScreenHandler stAction = new ActionTitleScreenHandler();
    ChoiceHandler choiceHandler = new ChoiceHandler();

    Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    Font textFont = new Font("Times New Roman", Font.PLAIN,26);
    Font statusFont = new Font("Times New Roman", Font.PLAIN, 22);
    Font btnFont = new Font("Times New Roman", Font.PLAIN, 16);

    public static void main(String[] args) {

/*
        String fonts[]
                = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
        for (int i = 0; i < fonts.length; i++) {
            System.out.println(fonts[i]);
        } //getting all available fonts*/


        new Game();
    }
    public Game(){

        con = this.getContentPane();
        titleNamePnl = new JPanel();


        startBtnPnl = new JPanel();
        startBtnPnl.setBounds(300,300,200,100);
        startBtnPnl.setBackground(Color.darkGray);


        btnStart = new JButton();
        btnStart.setText("Start");
        btnStart.setFocusPainted(false);
        btnStart.setBorder(BorderFactory.createEmptyBorder());
        btnStart.setBackground(Color.darkGray);
        btnStart.setForeground(Color.white);
        btnStart.setFont(textFont);
        btnStart.addActionListener(stAction);


        titleNamePnl.setBounds(100,100,600,150);
        titleNamePnl.setBackground(Color.darkGray);


        titleNameLabel = new JLabel("ERIDIAN");
        titleNameLabel.setForeground(new Color(255,246,143));
        titleNameLabel.setFont(titleFont);


        titleNamePnl.add(titleNameLabel);
        startBtnPnl.add(btnStart);

        con.add(titleNamePnl);
        con.add(startBtnPnl);

        this.setSize(800,700);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.getContentPane().setBackground(Color.darkGray);
        this.setResizable(false);
        this.setLayout(null);
        this.setVisible(true);
    }

    public void createGameScreen() {

        titleNamePnl.setVisible(false);
        startBtnPnl.setVisible(false);

        mainTextPnl = new JPanel();
        mainTextPnl.setBounds(100,100,600,250);
        mainTextPnl.setBackground(Color.darkGray);
        con.add(mainTextPnl);

        mainTextArea = new JTextArea();
        mainTextArea.setText("Hier könnte Ihre Werbung stehen blablablalab");
        mainTextArea.setBounds(100,100,600,250);
        mainTextArea.setBackground(Color.darkGray);
        mainTextArea.setForeground(Color.white);
        mainTextArea.setFont(textFont);
        mainTextArea.setLineWrap(true); //wenn text zu lang - automatisch mit absatz
        mainTextPnl.add(mainTextArea);

        choiceBtnPnl = new JPanel();
        choiceBtnPnl.setBounds(250,350,300,250);
        choiceBtnPnl.setBackground(Color.darkGray);
        choiceBtnPnl.setLayout(new GridLayout(6,1));
        con.add(choiceBtnPnl);


        choice1 = new JButton("Choice 1");
        choice1.setFocusPainted(false);
        choice1.setBackground(Color.darkGray);
        choice1.setForeground(Color.white);
        choice1.setFont(btnFont);
        choice1.addActionListener(choiceHandler);
        choiceBtnPnl.add(choice1);

        choice2 = new JButton("Choice 2");
        choice2.setFocusPainted(false);
        choice2.setBackground(Color.darkGray);
        choice2.setForeground(Color.white);
        choice2.setFont(btnFont);
        choice2.addActionListener(choiceHandler);
        choiceBtnPnl.add(choice2);

        choice3 = new JButton("Choice 3");
        choice3.setFocusPainted(false);
        choice3.setBackground(Color.darkGray);
        choice3.setForeground(Color.white);
        choice3.setFont(btnFont);
        choice3.addActionListener(choiceHandler);
        choiceBtnPnl.add(choice3);

        choice4 = new JButton("Choice 4");
        choice4.setFocusPainted(false);
        choice4.setBackground(Color.darkGray);
        choice4.setForeground(Color.white);
        choice4.setFont(btnFont);
        choice4.addActionListener(choiceHandler);
        choiceBtnPnl.add(choice4);

        playerPnl = new JPanel();
        playerPnl.setLayout(new GridLayout(1,6));
        playerPnl.setBounds(100,15,600,30);
        playerPnl.setBackground(Color.darkGray);
        con.add(playerPnl);

        hpLbl = new JLabel("HP:");
        hpLbl.setFont(statusFont);
        hpLbl.setForeground(Color.white);
        playerPnl.add(hpLbl);

        hpLblNum = new JLabel();
        hpLblNum.setFont(statusFont);
        hpLblNum.setForeground(Color.white);
        playerPnl.add(hpLblNum);

        manaLbl = new JLabel("Mana:");
        manaLbl.setFont(statusFont);
        manaLbl.setForeground(Color.white);
        playerPnl.add(manaLbl);

        manaLblNum = new JLabel();
        manaLblNum.setFont(statusFont);
        manaLblNum.setForeground(Color.white);
        playerPnl.add(manaLblNum);

        weaponLabel = new JLabel("Weapon:");
        weaponLabel.setFont(statusFont);
        weaponLabel.setForeground(Color.white);
        playerPnl.add(weaponLabel);

        weaponLabelName = new JLabel();
        weaponLabelName.setFont(statusFont);
        weaponLabelName.setForeground(Color.white);
        playerPnl.add(weaponLabelName);
        playerSetup();
    }

    public void playerSetup() {
        playerHp = 20;
        playerMana = 10;
        weapon = "None";

        hpLblNum.setText(""+ playerHp);
        manaLblNum.setText(""+playerMana);
        weaponLabelName.setText(weapon);
        inForest();
    }

    public void inForest() {
        position = "inForest";
        if(visitedForest<1) {
            mainTextArea.setText("You are in a forest leaning against a \ntree. The air is in a yellowish fog. \nBy looking around u notice strange \nmushrooms growing along the path. They \nseem to strech deeper into the forest away from the path. \n What do you do?");
        }else{mainTextArea.setText("You are in the middle of the Forest the gigantic shrooms seem even more dangerous right now. \n the air is thicker than the last time and you heard weird screaming \n  What are you doing?");
        }
        choice1.setText("Investigate surroundings");
        choice2.setText("Go deeper inside of the forest");
        choice3.setText("Follow the path out of the forest");
        choice4.setText("Pick a shroom and eat it");
    }

    public void deeperForest() {
        position ="deeperForest";
        if(weapon.equals("None")) {
            mainTextArea.setText("You follow the shrooms deeper in the forest. the air is becoming significantly warmer which makes breathing hard. you cant see your own hand infront of you the spores are basicaly everywhere and the air is thick you have to turn around.");
        } else{
            mainTextArea.setText("You follow the shrooms deeper inside the forest. When suddenly a small green creature is charging on you \n Goblin: Ahhh! get out of here this forest is the masters habit !!\n a wild goblin appeared");
        }
        choice1.setVisible(false);
        choice2.setText(">");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void investigateSur() {
        position = "investigateSur";
        mainTextArea.setText("You notice that the tree you've been \nleaning against is a gigantic Mushroom.\nThis Forest is full of Mushrooms! You can \nsee barely any tree's which aren't \ninfected by the spores already. You also \nhear the sound of running water by \nchecking it out u notice the water is muddy" );
        choice2.setText(">");
        choice1.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }


    public void wayOutOfForest() {
        position = "wayOutOfForest";
        if(weapon.equals("None")&&!brokenHilt&&visitedForest<1) {
            visitedForest++;
            mainTextArea.setText("U decided that it's too dangerous beeing unarmed in this forest so u are following the lightened up path out of the forest. While walking back u notice something shiny in a bush. What do you do?");
            choice1.setText("Ignore it and follow the Path");
            choice2.setText("Investigate the bush");
            choice3.setText("Go in the Forest");
            choice4.setVisible(false);

        }else {
            mainTextArea.setText("You are in between the Crossroad and the Forest right where the bush was");
            choice1.setText("Investigate the bush");
            choice2.setText("Go to the Crossroad");
            choice3.setText("Go in the Forest");
            choice4.setVisible(false);
        }

    }
    public void eatShroom() {
        position="eatShroom";
        mainTextArea.setText("Fear means nothing to you. The only thing about fear u've ever heard of is that u ARE being feared. \n so u take a big chunk of that mushroom! The mushroom burns your throat\n(You receive 20 damage)");
        playerHp = playerHp-20;
        hpLblNum.setText(""+playerHp);
        choice2.setText(">");
        choice1.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void investigateBush() {
        position ="investigateBush";
        mainTextArea.setText("While investigating the bush u find a battered hilt with a lionshead and a broken blade beneath it. \n What do you do?");
        choice1.setText("Take the broken blade");
        choice2.setText("Take the battered hilt");
        choice3.setText("Take both");
        choice4.setText("Ignore it");
    }

    public void takeBrokenBlade() {
        position="takeBrokenBlade";
        mainTextArea.setText("You carefuly try to put the broken blade in your inventory but its shards are cutting your hand. You receive 3 damage");
        playerHp=playerHp-3;
        hpLblNum.setText(""+playerHp);
        choice2.setText(">");
        choice1.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void takeBatteredHilt() {
        position="takeBatteredHilt";
        mainTextArea.setText("You carefuly put the battered hilt in your inventory and continue your way out of the forest when u finally step out of the forest u can see a crossroads which is visited by alot of people");
        choice2.setText(">");
        choice1.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void takeBoth() {
        position="takeBoth";
        mainTextArea.setText("You carefuly put the parts of the broken sword in your inventory. You received the battered Hilt! the broken blade though cuts ur hand . You receive 3 damage");
        playerHp=playerHp-3;
        hpLblNum.setText(""+playerHp);
        brokenHilt=true;
        choice2.setText(">");
        choice1.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void ignoreIt() {
        position="ignoreIt";
        mainTextArea.setText("Afraid of beeing tricked into a trap u ignore the shiny thing in the bush and continue your way out of the forest.");
        choice2.setText(">");
        choice1.setVisible(false);
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void inCrossroads() {
        position = "inCrossroads";
        choice1.setVisible(true);
        choice3.setVisible(true);
        choice4.setVisible(true);

        if(brokenHilt) {
            mainTextArea.setText("You come to a Crossroad which is \nfilled with merchants and peasants. A few of the people are noticing you and whispering to each other. \n Merchant: Hey you! what is that you are carrying with you?\n Merchant: This...this cant be this is Alfgards hilt. what happened?!");
            choice3.setText("Tell him the truth");
            choice2.setText("Ask if it's repairable");
            choice1.setVisible(false);
            choice4.setVisible(false);

        }else if(!brokenHilt){
            mainTextArea.setText("Angry peason: You stop there stranger! we are missing our guard he went into the forest but didnt come back yet. Damn. that asshole is supposed to guarantee safety to our traveling route through the forest. Well! and because we cant leave this place you wont pass this place. Got it? \n ");
            choice3.setText("Attack the Peasons");
            choice2.setText("Go back in the Forest");
            choice4.setVisible(false);
            choice1.setVisible(false);
        }else{
            //dire straits money for nothing, sultans of swing
        }
    }

    public void goBackForest(){
        choice1.setVisible(true);
        wayOutOfForest();
    }


    public void tellTruth() {
        position ="tellTruth";
        mainTextArea.setText("You tell the Merchant where you found the hilt.\n Merchant: Ha..Hahaha listen stranger. u look familiar with bloody stuff. how about u clear the forestpath for me? If you accept ill give u a weapon and once u are finished u may pass the crossroad. Sounds good doesnt it?");
        choice1.setVisible(false);
        choice2.setText("Accept");
        choice3.setText("Decline");
        choice4.setVisible(false);
    }

    public void askRepair() {
        position="askRepair";
        mainTextArea.setText("Merchant: Repair? Are u blind? Stranger..this is a damn hilt theres no blade. No its not repairable but how about ill give you a sword and in exchange u clear the forestpath for me and the other merchants?");
        choice1.setVisible(false);
        choice2.setText("Accept");
        choice3.setText("Decline");
        choice4.setVisible(false);
    }

    public void accept(){
        position="accept";
        mainTextArea.setText("Merchant: Thank you Stranger! Take this Sword and end this nightmare once and for all! I will let the others know which favor u are doing for us. How about u stay with us tonight so u can recover\n Mission: Avenge Alfgard and find out whats going on in the forest");
        weapon="Sword";
        weaponLabelName.setText(weapon);
        choice1.setVisible(false);
        choice2.setText(">");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void decline(){
        position="decline";
        mainTextArea.setText("Merchant: Well then u wont pass the Crossroad. Maybe u should consider helping us out. If you do we will do so aswell.");
        choice1.setVisible(false);
        choice2.setText(">");
        choice3.setVisible(false);
        choice4.setVisible(false);
    }

    public void goblinFight() {
        gegnerHp=15;
        playerAngriff=(int)(Math.random()*6)+1;
        gegnerAngriff=(int)(Math.random()*4)+1;
        position="goblinfight";
        choice1.setVisible(false);
        choice4.setVisible(false);

        mainTextArea.setText("Goblin appears \n HP: "+gegnerHp);
        mainTextArea.setText("What are you doing?");
        choice2.setText("Attack");
        choice3.setText("Flee");


    }

    public class ActionTitleScreenHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {
            createGameScreen();
        }
    }

    public class ChoiceHandler implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent actionEvent) {


            String yourChoice = actionEvent.getActionCommand(); //wenn choice 1 angeklickt text wird übergeben. programm weiss hier welcher button
            System.out.println(yourChoice);
            switch(position) {
                case "inForest":
                    switch (yourChoice) {
                        case "Investigate surroundings":
                            investigateSur();
                            break;
                        case "Go deeper inside of the forest":
                            deeperForest();
                            break;
                        case "Follow the path out of the forest":
                            wayOutOfForest();
                            break;
                        case "Pick a shroom and eat it":
                            eatShroom();
                            break;
                    }
                    break;

                case "investigateSur":
                    switch (yourChoice) {
                        case ">":
                            inForest();
                            choice1.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                            break;
                    }
                    break;

                case "wayOutOfForest":
                    int rnd=(int)(Math.random()*100)+1;  //für zufallsevents..
                    System.out.println(rnd);
                    if (weapon.equals("None")) {
                        switch (yourChoice) {
                            case "Ignore it and follow the Path":
                                System.out.println("wegignorieren");
                                ignoreIt();
                                break;
                            case "Investigate the bush":
                                choice3.setVisible(true);
                                choice4.setVisible(true);
                                investigateBush();
                                break;
                            case "Go in the Forest":
                                inForest();
                                choice4.setVisible(true);
                                break;
                            case "Go to the Crossroad":
                                inCrossroads();
                                choice4.setVisible(false);
                                break;
                        }

                    } else {
                        switch (yourChoice) {


                        }
                    }
                    break;

                case "eatShroom":
                    System.out.println(position);
                    switch(yourChoice){
                        case ">": inForest();
                            if(playerHp<=0){
                                playerHp=0;
                                mainTextArea.setText("You died.");
                                choice1.setVisible(false);
                                choice2.setVisible(false);
                                choice3.setVisible(false);
                                choice4.setVisible(false);
                            }else {
                                choice1.setVisible(true);
                                choice3.setVisible(true);
                                choice4.setVisible(true);
                                break;
                            }
                    }
                    break;

                case "investigateBush":
                    switch (yourChoice){
                        case "Take the broken blade":
                            takeBrokenBlade();
                            break;
                        case "Take the battered hilt":
                            brokenHilt=true;
                            takeBatteredHilt();
                            break;
                        case "Take both":
                            brokenHilt=true;
                            takeBoth();
                            break;
                        case "Ignore it and follow the Path":
                            choice1.setVisible(false);
                            choice4.setVisible(false);
                            ignoreIt();
                            break;

                        case"Go to the Crossroad":
                            inCrossroads();
                            choice1.setVisible(true);
                            choice4.setVisible(true);
                            break;
                    }
                    break;

                case "takeBatteredHilt":
                    System.out.println(position);
                    switch (yourChoice){
                        case ">": inCrossroads();
                            break;
                    }
                    break;

                case "takeBrokenBlade":
                    System.out.println(position);
                    switch (yourChoice){
                        case ">": investigateBush();
                            choice1.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                    }
                    break;

                case "takeBoth":
                    System.out.println(position);
                    switch (yourChoice){
                        case ">": inCrossroads();
                    }
                    break;

                case "ignoreIt":
                    switch (yourChoice){
                        case ">": inCrossroads();
                            choice2.setVisible(true);
                            choice3.setVisible(true);
                            choice1.setVisible(false);
                            choice4.setVisible(false);
                    }
                    break;

                case "deeperForest":
                    switch (yourChoice) {

                        case ">":
                            if(weapon.equals("None")){
                                inForest();
                                choice1.setVisible(true);
                                choice3.setVisible(true);
                                choice4.setVisible(true);
                            }else{
                                choice1.setVisible(false);
                                choice3.setVisible(true);
                                choice4.setVisible(false);
                                goblinFight();
                            }



                    }
                    break;

                case "inCrossroads":
                    switch (yourChoice){
                        case"Tell him the truth":
                            tellTruth();
                            break;
                        case"Ask if it's repairable":
                            askRepair();
                            break;
                        case"Go back in the Forest":
                            goBackForest();
                            break;
                    }
                    break;

                case "tellTruth":
                    switch(yourChoice){
                        case"Accept":
                            accept();
                            break;
                        case"Decline":
                            choice1.setVisible(false);
                            choice4.setVisible(false);
                            decline();
                            break;
                    }
                    break;

                case "askRepair":
                    switch(yourChoice){
                        case"Accept":
                            accept();
                            break;
                        case"Decline":
                            choice1.setVisible(false);
                            choice4.setVisible(false);
                            decline();
                    }
                    break;

                case "accept":
                    switch(yourChoice){
                        case ">": inForest();
                            choice1.setVisible(true);
                            choice3.setVisible(true);
                            choice4.setVisible(true);
                    }
                    break;

                case "decline":
                    switch(yourChoice){
                        case ">": inCrossroads();
                            choice1.setVisible(false);
                            choice3.setVisible(true);
                            choice4.setVisible(false);
                            break;
                    }
                    break;

                case "goblinfight":
                    switch (yourChoice){
                        case"Attack":

                                if(gegnerHp!=0||playerHp!=0){
                                    playerAngriff = (int) (Math.random() * 6) + 1;
                                    gegnerAngriff = (int) (Math.random() * 5) + 1;

                                    gegnerHp = gegnerHp - playerAngriff;
                                    playerHp = playerHp - gegnerAngriff;
                                    mainTextArea.setText("You hit the Enemy and dealt " + playerAngriff + "damage.\n The enemy has " + gegnerHp + "left!\n The enemy hit u in return for " + gegnerAngriff);
                                    hpLblNum.setText("" + playerHp);
                                    if(gegnerHp<=0) {
                                        mainTextArea.setText("Goblin fainted");
                                    }else if(playerHp<=0){
                                        mainTextArea.setText("You died");
                                    }
                    }
            }
        }
 }
        }
}
