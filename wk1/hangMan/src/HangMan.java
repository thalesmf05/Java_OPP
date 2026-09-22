import java.util.Objects;

public class HangMan {
    private String sentence, revelingSentence, letter, errorHandling;
    private int numWord, numLetters, countCorrectGuess;
    private char lt;
    private StringBuilder sb = new StringBuilder();
    private boolean correctGuess = false, isletterValid;
    //constructor
    public HangMan() {
        sentence = "";
        revelingSentence= "";
        letter = "";
        numWord = 0;
        numLetters = 0;
        countCorrectGuess = 0;
        isletterValid = false;
    }

    //getters and setters
    public boolean isCorrectGuess() {
        return correctGuess;
    }

    public void setSentence(String sentence) {
        this.sentence = sentence;
    }

    public String getRevelingSentence() {
        return revelingSentence;
    }

    public int getNumWord() {
        return numWord;
    }

    public int getNumLetters() {
        return numLetters;
    }

    public void setLetter(String letter) {
        this.letter = letter;
    }

    public int getCountCorrectGuess() {
        return countCorrectGuess;
    }

    public boolean isIsletterValid() {
        return isletterValid;
    }

    public String getErrorHandling() {
        return errorHandling;
    }

    //compute main
    public void startGame(){
        numWord = sentence.strip().split("\\s+").length; //count words
        for(int i = 0; i < sentence.length(); i++){
            if(Character.isLetter(sentence.charAt(i))){
                numLetters++; //count letter
                //create revelingSentence
                revelingSentence = revelingSentence + "_";
            } else{
                revelingSentence = revelingSentence + " ";
            }
        }
    }

    //compute guess letter
    public void guessLetter(){
        sb.append(revelingSentence); //add the reveling sentence to the string builder before start editing
        for(int i = 0; i < sentence.length(); i++){
            if(letter.equals(Character.toString(sentence.charAt(i)))){
                sb.replace(i, i + 1, letter);
                correctGuess = true;
                countCorrectGuess++; //count the number of correct guessed letters
            }
        }
        if(correctGuess){
            revelingSentence = sb.toString();
        }
        sb.setLength(0); //clen the string builder for the next word
    }


    //VALIDATION LETTER AND SENTENCE
    public void validadeLetterInput(){
        if(letter.length() != 1){
            errorHandling = "Only one letter at the time";
        }else if(Character.isLetter(letter.charAt(0))){
            isletterValid = true;
        }else{
            errorHandling = "Only letters are accepted";
        }
    }



}
