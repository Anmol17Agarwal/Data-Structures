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
        System.out.println("=======================");
        System.out.println(tries.search("anmol"));

        System.out.println(tries.search("anmo"));
        tries.delete("ama");
        tries.display();

        System.out.println("=======================");
        tries.delete("sea");
        tries.display();

        System.out.println("=======================");
        tries.delete("seafood");
        tries.display();

        System.out.println("=======================");
    }
}
