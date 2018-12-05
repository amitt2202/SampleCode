package us..view.util;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

import java.util.ArrayList;
import java.util.List;

public class CAPTCHAUtil {
    public CAPTCHAUtil() {
        super();
    }
    private static String[] alphabet = { "A", "B", "C", "D", "E", "F", "G",
                            "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T",
                            "U", "V", "W", "X", "Y", "Z" };
            private static String[] positionNames = { "1st", "2nd", "3rd", "4th",
                            "5th", "6th" };
            private static String[] words = { "RED", "HORSE", "CAT", "BLUE", "ORANGE" };

            public static void main(String[] args) throws NoSuchAlgorithmException {

                    List<String> myCAPTCHA = CAPTCHAUtil.getQuestionAndAnswer();

                    //System.out.println("CAPTCHAUtil:Q: " + myCAPTCHA.toArray()[0]);
                    //System.out.println("CAPTCHAUtil:A: " + myCAPTCHA.toArray()[1]);

                    myCAPTCHA = CAPTCHAUtil.getQuestionAndAnswer();

                    //System.out.println("CAPTCHAUtil:Q: " + myCAPTCHA.toArray()[0]);
                    //System.out.println("CAPTCHAUtil:A: " + myCAPTCHA.toArray()[1]);

                    myCAPTCHA = CAPTCHAUtil.getQuestionAndAnswer();

                    //System.out.println("CAPTCHAUtil:Q: " + myCAPTCHA.toArray()[0]);
                   // System.out.println("CAPTCHAUtil:A: " + myCAPTCHA.toArray()[1]);

                    myCAPTCHA = CAPTCHAUtil.getQuestionAndAnswer();

                    //System.out.println("CAPTCHAUtil:Q: " + myCAPTCHA.toArray()[0]);
                    //System.out.println("CAPTCHAUtil:A: " + myCAPTCHA.toArray()[1]);

                    myCAPTCHA = CAPTCHAUtil.getQuestionAndAnswer();

                   // System.out.println("CAPTCHAUtil:Q: " + myCAPTCHA.toArray()[0]);
                   // System.out.println("CAPTCHAUtil:A: " + myCAPTCHA.toArray()[1]);

            }

            /**
             * Return a randomly selected question and answer
             * 
             * @return a List with the question and answer
             */
            public static List<String> getQuestionAndAnswer() {

                    SecureRandom randomGenerator;

                    try {
                            randomGenerator = SecureRandom.getInstance("SHA1PRNG");

                            Integer i = randomGenerator.nextInt(5);

                            switch (i) {
                            case 0:
                                    return numberAfter();
                            case 1:
                                    return numberBefore();
                            case 2:
                                    return letterAfter();
                            case 3:
                                    return letterBefore();
                            case 4:
                                    return letterPosition();
                            case 5:
                                    return wordLength();
                            }

                    } catch (NoSuchAlgorithmException e) {
                            // don't do anything because SHA1PRNG is always valid
                    }
                    return (null);
            }

            private static List<String> numberAfter() throws NoSuchAlgorithmException {
                    SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");
                    Integer i = randomGenerator.nextInt(18) + 1;
                    List<String> r = new ArrayList<String>();

                    r.add("What number comes after " + i + "?");
                    r.add("" + (i + 1));

                    return (r);
            }

            private static List<String> numberBefore() throws NoSuchAlgorithmException {
                    SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");
                    Integer i = randomGenerator.nextInt(18) + 1;
                    List<String> r = new ArrayList<String>();

                    r.add("What number comes before " + (i + 1) + "?");
                    r.add("" + i);

                    return (r);
            }

            private static List<String> letterAfter() throws NoSuchAlgorithmException {
                    SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");
                    Integer i = randomGenerator.nextInt(24) + 1;
                    List<String> r = new ArrayList<String>();

                    r.add("What letter comes after " + alphabet[i] + " in the alphabet?");
                    r.add(alphabet[i + 1]);

                    return (r);
            }

            private static List<String> letterBefore() throws NoSuchAlgorithmException {
                    SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");
                    Integer i = randomGenerator.nextInt(24) + 1;
                    List<String> r = new ArrayList<String>();

                    r.add("What letter comes before " + alphabet[(i + 1)]
                                    + " in the alphabet?");
                    r.add(alphabet[i]);

                    return (r);
            }

            private static List<String> letterPosition()
                            throws NoSuchAlgorithmException {
                    SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");
                    Integer w = randomGenerator.nextInt(5);
                    Integer p = randomGenerator.nextInt(words[w].length());
                    List<String> r = new ArrayList<String>();

                    r.add("What is the " + positionNames[p] + " letter in the word "
                                    + words[w] + "?");
                    r.add("" + words[w].substring(p, p + 1));

                    return (r);
            }

            private static List<String> wordLength() throws NoSuchAlgorithmException {
                    SecureRandom randomGenerator = SecureRandom.getInstance("SHA1PRNG");
                    Integer i = randomGenerator.nextInt(5);
                    List<String> r = new ArrayList<String>();

                    r.add("How many letters are in the word " + words[i] + "?");
                    r.add("" + words[i].length());

                    return (r);
            }

}
