import javax.swing.*;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
//TODO fix bug with spaces, verification class (first input), display after winning, count the lost points

public class HangManApp {
    public static void main(String[] args) {
        String sentence, revelingSentence, letter, errorHandling;
        Boolean isFinished = false, correctGuess, isLetterValid = false;
        int countWord, countLetter, countCorrectGuess = 0;
        HangMan myHm = new HangMan();

        //INPUT
        sentence = JOptionPane.showInputDialog(null, "Enter the word: ");
        myHm.setSentence(sentence);

        myHm.startGame(); //START THE GAME

        //Get relevant info to display for the second user
        countWord = myHm.getNumWord();
        countLetter = myHm.getNumLetters();
        revelingSentence = myHm.getRevelingSentence();

        JOptionPane.showMessageDialog(null, "Words: " + countWord + "\nLetters: " + countLetter
                + "\n" +
                "Hint: " + revelingSentence);

        while(countCorrectGuess < countLetter){
           //get the guess
           letter = JOptionPane.showInputDialog(null, "Enter a letter: ");

           //validate letter input
            myHm.setLetter(letter);
            myHm.validadeLetterInput();

            if (!myHm.isIsletterValid()){ //if not valid show error message and restart
                errorHandling = myHm.getErrorHandling();
                JOptionPane.showMessageDialog(null, errorHandling);
                continue;
            }

            //play the round
            myHm.guessLetter();

            correctGuess = myHm.isCorrectGuess();//check if user got a word
            if(correctGuess){
                revelingSentence = myHm.getRevelingSentence();
                JOptionPane.showMessageDialog(null, "You got it! \nCurrent word: \n" + revelingSentence);
                countCorrectGuess = myHm.getCountCorrectGuess();
            }
        }

        //won the game
        JOptionPane.showMessageDialog(null, "won");
    }
}