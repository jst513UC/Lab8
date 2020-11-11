import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener
{
  
JTextField field; 
JButton guess;
JButton playAgain;
JLabel jlabPrompt, jlabContents1, jlabContents2;
int randomNum;

GuessingGame()
{

Random r = new Random();
randomNum = r.nextInt(101)+1;

JFrame frame = new JFrame ("Guessing Game");
frame.setLayout(new FlowLayout());
frame.setSize(240, 120);

field = new JTextField(10);
field.setActionCommand("myTF");
field.addActionListener(this);

guess = new JButton("Guess");
playAgain = new JButton("Play Again");
guess.addActionListener(this);
playAgain.addActionListener(this);

jlabPrompt = new JLabel("Enter your guess:");
jlabContents1 = new JLabel("");
jlabContents2 = new JLabel("");

frame.add(jlabPrompt);
frame.add(field);
frame.add(guess);
frame.add(jlabContents1);
frame.add(jlabContents2);
frame.add(playAgain);

frame.setVisible(true);
  
}


public void actionPerformed(ActionEvent ae) 
  { 
    
    if(ae.getActionCommand().equals("Guess")) 
    { 
      int user_guess = Integer.parseInt(field.getText());
      jlabContents2.setText("Your last guess was " + user_guess);
      
      if (user_guess > randomNum)
      {
          jlabContents1.setText("Oof das too high.");
      }
      else if (user_guess < randomNum) 
      {
        jlabContents1.setText("Oof das too low.");
      }

      else {
         jlabContents1.setText("Ayyye you got it!");
      }
      }

     else if (ae.getActionCommand().equals("Play Again"))
     {
       Random r = new Random();
       randomNum = r.nextInt(100)+1;
       jlabContents1.setText("Let's play again");
       jlabContents2.setText("");
     }

     else
     {
        jlabContents1.setText("You pressed Enter. Please press the Guess button");
     }
  } 


} 

