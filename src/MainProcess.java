import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainProcess {
    public static void main(String[] args) {
        String[] myString = new String[]{"поезд","машина","самолет","корабль","вертолет",
                "кактус","хризантема","дерево","тюльпан","смородина",
                "телефон","компьютер","телевизор","микроволновка","клавиатура",};
        int n = (int)Math.floor(Math.random() * myString.length);
        String mainWord = (myString[n]);
        int numOfTry = 10;
        int wordLen = mainWord.length();
        Boolean forTries = true;
        List <Character> allLets = new ArrayList<Character>();
        String experWord = "";

        for(int i = 0; i < wordLen; i++){
            char letOfWord = mainWord.charAt(i);
            allLets.add(letOfWord);
        }

        for(int i = 0; i < wordLen; i++){
            experWord = experWord + "*";
        }

        System.out.println("Привет! Ты попал в игру Gallows)");
        System.out.println("У тебя будет" + " " + numOfTry + " " + "жизней");
        System.out.println("А теперь перейдём к игре)");
        System.out.println("Загаданное слово состоит из" + " " + wordLen);
        System.out.println();
        Scanner in = new Scanner(System.in);
        while(numOfTry != 0){
            forTries = true;
            if(mainWord.equals(experWord)){
                System.out.println("Ты победил и угадал слово" + " " + mainWord);
                return;
            }
            else {
                System.out.println("--------------------------");
                System.out.println("Слово:" + " " + experWord);
                System.out.println("Количество жизней: " + " " + numOfTry);
                System.out.print("Введи букву или слово целиком: ");
                String resultFromUser = in.nextLine();
                resultFromUser = resultFromUser.toLowerCase();
                if (resultFromUser.length() != 1) {
                    if (resultFromUser.equals(mainWord)) {
                        System.out.println("Ты победил");
                        return;
                    } else {
                        System.out.println("Извини, но ты проиграл");
                        return;
                    }
                } else {
                    for (int i = 0; i < wordLen; i++) {
                        char letOfWord = mainWord.charAt(i);
                        String letOfWordToString = String.valueOf(letOfWord);
                        if (resultFromUser.equals(letOfWordToString)) {
                            experWord = experWord.substring(0, i)
                                    + resultFromUser
                                    + experWord.substring(i + 1);
                            System.out.println("Правильно");
                            System.out.println();
                            forTries = false;
                        }
                    }
                 if(forTries == true){
                     numOfTry -= 1;
                     System.out.println("Неверно");
                     System.out.println();
                 }
                }
            }
        }
    }
}
