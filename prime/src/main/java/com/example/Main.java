package prime.src.main.java.com.example;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        
        int given=0;

        File myObj = new File("test.txt");
        try (Scanner scanner = new Scanner(myObj)) 
        {
            while (scanner.hasNextLine()) {
                given = Integer.parseInt(scanner.nextLine());   
            }

            scanner.close();
        }

        System.out.println("Prime Numbers: " + getPrimeNumbers(given));
        System.out.println("Factors: " + getFactors(getPrimeNumbers(given), given));
    }

    public static List<Integer> getPrimeNumbers(int given){

        List<Integer> primeNumbers = new ArrayList<Integer>();
        Set<Integer> notPrimeNumbers = new HashSet<Integer>();

        for(int n = 2; n<given; n++){
            primeNumbers.add(n);
        }

        for(int i=4; i<given; i++){
            for(int j=2; j<i; j++){
                if(i%j == 0){
                    notPrimeNumbers.add(i);
                    break;
                }
            }
        }

        primeNumbers.removeAll(notPrimeNumbers);
        return primeNumbers;
    }

    public static Set<Set<Integer>> getFactors(List<Integer> primeNumbers, int given){
        
        Set<Integer> factor = new HashSet<>();
        Set<Set<Integer>> factors = new HashSet<>();

        for (int i = 0; i < primeNumbers.size(); i++) {
            for (int j = 0; j < primeNumbers.size(); j++) {
                if(primeNumbers.get(i) * primeNumbers.get(j) == given){
                    factor.add(primeNumbers.get(i));
                    factor.add(primeNumbers.get(j));

                    factors.add(factor);
                }
            }
        }

        return factors;
    }
}