import java.util.ArrayList;

public class Day5Task1 {
    static Character[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};

    public static void main(String[] args) {
        String text = "Hello My FriendzA";
        String encoded = encoder(text);
        System.out.println(encoded);
        System.out.println(decoder(encoded));
    }

    public static String encoder(String text) {
        ArrayList<Character> list = new ArrayList<>();
        for (int l = 0; l < text.length(); l++) {
            for (int i = 0; i < alphabet.length; i++) {
                Character originalTextCharacter = text.charAt(l);
                Character originalTextCharacterLowerCase = Character.toLowerCase(originalTextCharacter);
                Character ch = alphabet[i];
                if (originalTextCharacter.equals(' ')){
                    list.add(l, originalTextCharacter);
                }
                else if ((ch.equals(originalTextCharacterLowerCase))) {
                    int x = i + 1;

                    if (originalTextCharacterLowerCase.equals(alphabet[alphabet.length-1])) {
                        x = 0;
                    }
                    
                    if (Character.isLowerCase(originalTextCharacter)) {
                        list.add(l, Character.toUpperCase(alphabet[x]));
                    } else {
                        list.add(l, Character.toLowerCase(alphabet[x]));
                    }
                    break;
                }
            }
        }
        return stringBuilder(list);
    }

    public static String decoder(String text) {
        ArrayList<Character> list = new ArrayList<>();
        for (int l = 0; l < text.length(); l++) {
            for (int i = 0; i < alphabet.length; i++) {
                Character originalTextCharacter = text.charAt(l);
                Character originalTextCharacterLowerCase = Character.toLowerCase(originalTextCharacter);
                Character ch = alphabet[i];
                if (originalTextCharacter.equals(' ')){
                    list.add(l, originalTextCharacter);
                }
                else if ((ch.equals(originalTextCharacterLowerCase))) {
                    int x = i - 1;

                    if (originalTextCharacterLowerCase.equals(alphabet[0])) {
                        x = alphabet.length-1;
                    }
                    if (Character.isLowerCase(originalTextCharacter)) {
                        list.add(l, Character.toUpperCase(alphabet[x]));
                    } else {
                        list.add(l, Character.toLowerCase(alphabet[x]));
                    }
                    break;
                }
            }
        }
        return stringBuilder(list);
    }


    public static String stringBuilder(ArrayList<Character> list) {
        StringBuilder sb = new StringBuilder();
        for (char ch : list) {
            sb.append(ch);
        }
        String string = sb.toString();
        return string;
    }

}
