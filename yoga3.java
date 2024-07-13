import java.util.*;

public class yoga3{
    
    private static final String[] questions = {
      
        "What is the capital of India?",
        "Who develop you?",
        "When india won first T20 world cup?",
        "What is the capital of Andhra pradesh?",
        "How many pages have in india constitution?",


    };

    private static final String[][] options = {
        {"1. New Delhi", "2. Bengaluru", "3. Hyderabad", "4. Ranchi"},
        {"1. All", "2.School student", "3. AI", "4.  Btech Student  "},
        {"1. 2024", "2. 2016", "3. 2007", "4. 2011"},
        {"1. Tirupati", "2. Amaravati", "3. Ongole", "4. Vijyawada"},
        {"1. 472", "2. 111", "3. 564", "4. 289"}
    };

    private static final int[] answers = {1, 4, 3, 2, 1};

    private static int c = 0;
    private static int y = 5;
    private static Timer n;
    private static Scanner s = new Scanner(System.in);

    public static void main(String[] args) {
        n = new Timer();
        n.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                if (y> 0) {
                    System.out.println(y-- + " seconds");
                } else {
                    System.out.println("Time up!");
                    nextQuestion();
                }
            }
        }, 0, 1000);

        loadQuestion();
    }

    private static void loadQuestion() {
        if (c < questions.length) {
            System.out.println(questions[c]);
            for (String option : options[c]) {
                System.out.println(option);
            }
            y = 5;
            System.out.print("Your answer: ");
            int answer = s.nextInt();
            if (answer == answers[c]) {
                System.out.println("Correct!");
            } else {
                System.out.println("Wrong!");
            }
            nextQuestion();
        } else {
            endQuiz();
        }
    }

    private static void nextQuestion() {
        c++;
        loadQuestion();
    }

    private static void endQuiz() {
        n.cancel();
        System.out.println("Quiz Over!");
        System.exit(0);
    }
}