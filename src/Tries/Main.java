package Tries;

public class Main {

    public static void main(String[] args) {
        Tries tries = new Tries();
        tries.addWord("anmol");
        tries.addWord("aman");
        tries.addWord("amit");
        tries.addWord("sea");
        tries.addWord("seafood");
        tries.addWord("seenBefore");
        tries.display();
    }
}
