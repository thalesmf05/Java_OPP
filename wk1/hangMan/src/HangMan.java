import java.util.ArrayList;

public class HangMan {
    private String sentence, revelingSentence, letter, errorHandling;
    private int numWord, numLetters, countCorrectGuess;
    private char lt;
    private StringBuilder sb = new StringBuilder();
    private boolean correctGuess = false, isValid;
    private ArrayList<String> guessedLt = new ArrayList<String>();
    //constructor
    public HangMan() {
        sentence = "";
        revelingSentence= "";
        letter = "";
        numWord = 0;
        numLetters = 0;
        countCorrectGuess = 0;
        isValid = false;
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

    public boolean isValid() {
        return isValid;
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
        correctGuess = false;
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
        guessedLt.add(letter);

    }


    //VALIDATION LETTER AND SENTENCE
    public void validateLetterInput(){
        isValid = false;
        if(letter.length() != 1){ //check if user only input one character
            errorHandling = "Please insert one letter";
        }else if(Character.isLetter(letter.charAt(0))){ //check if its a letter
            if (!guessedLt.contains(letter)) { //check if user already guesses this letter before
                isValid = true; //if it wasn't guessed before then letter is valid
            }else {
                errorHandling = "Letter already used";
            }
        }else{ //handle if the character is not a letter
            errorHandling = "Only letters are accepted";
        }
    }

    public void validateSentenceInput(){
        isValid = true;
        if(sentence.length() > 1) {
            for (int i = 0; i < sentence.length(); i++) {
                lt = sentence.charAt(i);
                if (!Character.isLetter(lt) && lt != ' ') {
                    isValid = false;
                    errorHandling = "Only letters allowed";
                    break;
                }
            }

        }else {
            isValid = false;
            errorHandling = "You must insert a word";
        }
    }



}
