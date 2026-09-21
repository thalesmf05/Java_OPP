import java.util.Objects;

public class HangMan {
    private String sentence, revelingSentence, letter;
    private int numWord, numLetters;
    private String [] words;
    private char lt;
    private StringBuilder sb = new StringBuilder();
    private boolean correctGuess = false;
    //constructor
    public HangMan() {
        sentence = "";
        revelingSentence= "";
        numWord = 0;
        numLetters = 0;
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

    //compute main
    public void startGame(){
        numWord = sentence.strip().split("\\s+").length; //count words
        for(int i = 0; i < sentence.length(); i++){
            if(Character.isLetter(sentence.charAt(i))){
                numLetters++; //count letter

                //create revelingSentence
                revelingSentence = revelingSentence + "_";
            } else if (lt == ' ') {
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
            }
        }
        if(correctGuess){
            revelingSentence = sb.toString();
        }
        sb.setLength(0); //clen the string builder for the next word

    }


}
