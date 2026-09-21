import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class HangManApp {
    public static void main(String[] args) {
        String sentence, revelingSentence, letter;
        Boolean isFinished = false, correctGuess;
        HangMan myHm = new HangMan();

        //ask for input
        sentence = JOptionPane.showInputDialog(null, "Enter the word: ");
        myHm.setSentence(sentence);
        myHm.startGame();

        while(!isFinished){
            //show input


           //get the guess
           letter = JOptionPane.showInputDialog(null, "Enter a letter: ");
           myHm.setLetter(letter);

           //compute guess letter
            myHm.guessLetter();

            correctGuess = myHm.isCorrectGuess();//check if user got a word
            if(correctGuess){
                revelingSentence = myHm.getRevelingSentence();
                JOptionPane.showMessageDialog(null, "You got it! \nCurrent word: " + revelingSentence);
            }


            revelingSentence = myHm.getRevelingSentence();
            JOptionPane.showMessageDialog(null, revelingSentence);
        }


        //sendit for the other page
    }
}