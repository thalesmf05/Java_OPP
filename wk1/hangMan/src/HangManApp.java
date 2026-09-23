import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//TODO display after winning, display incorrect guess, count the lost points

public class HangManApp {
    public static void main(String[] args) {
        String sentence, revelingSentence, letter, errorHandling;
        Boolean correctGuess, isValid;
        int countWord, countLetter, countCorrectGuess = 0;
        HangMan myHm = new HangMan();
        //INPUT
        while(true) {
            sentence = JOptionPane.showInputDialog(null, "Enter the word: ");
            myHm.setSentence(sentence);

            //verify sentence
            myHm.validateSentenceInput();
            if (!myHm.isValid()) {
                errorHandling = myHm.getErrorHandling();
                JOptionPane.showMessageDialog(null, errorHandling);
                continue;
            }
            myHm.startGame(); //START THE GAME

            //Get relevant info to display for the second user
            countWord = myHm.getNumWord();
            countLetter = myHm.getNumLetters();
            revelingSentence = myHm.getRevelingSentence();

            JOptionPane.showMessageDialog(null, "Words: " + countWord + "\nLetters: " + countLetter
                    + "\n" +
                    "Hint: " + revelingSentence);
            break;
        }

        while(countCorrectGuess < countLetter){
           //get the guess
           letter = JOptionPane.showInputDialog(null, "Enter a letter: ");

           //validate letter input
            myHm.setLetter(letter);
            myHm.validateLetterInput();

            if (!myHm.isValid()){ //if not valid show error message and restart
                errorHandling = myHm.getErrorHandling();
                JOptionPane.showMessageDialog(null, errorHandling);
                continue;
            }

            //play the round
            myHm.guessLetter();
            correctGuess = myHm.isCorrectGuess();//check if user got a word
            countCorrectGuess = myHm.getCountCorrectGuess();

            if(correctGuess && countCorrectGuess < countLetter){
                revelingSentence = myHm.getRevelingSentence();
                JOptionPane.showMessageDialog(null, "You got it! \nCurrent word: \n" + revelingSentence);
            }
        }

        //won the game
        JOptionPane.showMessageDialog(null, "won");
    }
}