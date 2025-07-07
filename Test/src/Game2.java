import java.util.Random;
import java.util.Scanner;

public class Game2 {

    private static final String[] FRUITS = {"바나나", "사과", "수박", "딸기", "포도"};
    private static final String[][] HINTS = {
            {"이 과일은 열대과일입니다.", "이 과일은 껍질을 까야 먹을 수 있습니다", "이 과일은 빙그레의 대표적인 우유맛입니다", "이 과일은 원숭이와 연관이 있습니다"},
            {"이 과일은 주스로 아침에 자주 먹습니다", "이 과일은 경상북도 청송의 대표적인 과일입니다", "이 과일은 달콤하고 상큼합니다", "이 과일은 주로 빨간색이지만 녹색이나 황색일 경우도있습니다"},
            {"이 과일은 땅에서 자라는 과일입니다", "이 과일은 신선도를 확인하기위해 손으로 두드려보는 사람들이 많습니다", "이 과일은 동물에 비교하면 얼룩말과 비슷하게 생겼습니다", "이 과일은 시원하게 먹기위해 물에 담궈놓기도 합니다"},
            {"이 과일에는 씨가 사람의 블랙헤드처럼 겉면에 붙어있습니다", "주로 봄에서 여름 사이에서 수확되는 과일입니다", "이 과일은 소화를 촉진하고 혈당 조절에 도움이 됩니다", "이 과일은 잼으로도 유명합니다"},
            {"이 과일은 발효시켜 술로만들수있는데 작성자가 진짜 좋아합니다", "이 과일은 먹을 때 씨가 거슬릴 수 있습니다", "이 과일은 크기가 다양하지만 씨가 없는 것도 있습니다", "이 과일과 비슷한 모양의 과일 중 초록색도 있습니다"}
    };
    private static final int MAX_TRIES = 4;

    private static Random random = new Random();
    private static Scanner stdIn = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("=== 과일 맞추기 게임을 시작합니다 ===");
        playGame();
        stdIn.close();
    }

    private static void playGame() {
        String fruitToGuess = getRandomFruit();
        int fruitIndex = getFruitIndex(fruitToGuess);
        String[] hints = HINTS[fruitIndex];
        int numTries = 1;

        System.out.println(numTries + "번째 힌트: " + hints[numTries - 1]);

        while (numTries <= MAX_TRIES) {
            System.out.print("과일 이름을 추측하세요: ");
            String guess = stdIn.nextLine();

            if (guess.equals(fruitToGuess)) {
                System.out.println(numTries + "번 째 만에 맞추셨습니다! 과일은 " + fruitToGuess + "입니다.");
                return;
            } else {
                numTries++;
                if (numTries <= MAX_TRIES) {
                    System.out.println("틀렸습니다. 다시 추측해 보세요. \n" + numTries + "번째 힌트: " + hints[numTries - 1]);
                } else {
                    System.out.println("아쉽지만 시도 횟수를 초과했습니다.");
                }
            }
        }

        System.out.println("정답은 " + fruitToGuess + "입니다.");
    }

    private static String getRandomFruit() {
        int randomIndex = random.nextInt(FRUITS.length);
        return FRUITS[randomIndex];
    }

    private static int getFruitIndex(String fruit) {
        for (int i = 0; i < FRUITS.length; i++) {
            if (FRUITS[i].equals(fruit)) {
                return i;
            }
        }
        return -1;
    }
}
