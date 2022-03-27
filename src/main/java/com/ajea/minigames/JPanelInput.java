package com.ajea.minigames;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class JPanelInput extends JFrame implements ActionListener {
    private JFrame frame = new JFrame();
    private JPanel panel = new JPanel();
    private JLabel prompt;
    private JTextField userText = new JTextField(20);
    private JButton buttonSubmit = new JButton("Submit");

    public JPanelInput(String gameName, String prompt){
        super(gameName);
        this.prompt = new JLabel(prompt);

        buttonSubmit.addActionListener(this);
        buttonSubmit.setLayout(null);
        buttonSubmit.setBounds(200, 170, 100, 20);

        userText.addActionListener(this);
        userText.setLayout(null);
        userText.setBounds(140,100, 200,30);

        this.prompt = new JLabel(prompt);
        this.prompt.setLayout(null);
        this.prompt.setBounds(10,20, 700,50);

        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        panel.add(this.prompt);
        panel.add(userText);
        panel.add(buttonSubmit);

        frame.add(panel, BorderLayout.CENTER);
        frame.setSize(500,250);
        frame.setLocation(400,300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle(gameName);
        frame.setVisible(true);

    }

    public void actionPerformed(ActionEvent e) {
        if(e.getSource()== buttonSubmit){
            System.out.println("test");
            System.out.println(userText.getText());

        }
    }

}
