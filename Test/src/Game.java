import java.util.Random;
import java.util.Scanner;

public class Game {

    private static final int MAZE_SIZE = 15; // 미로의 크기 (가로, 세로 동일)
    private static final char WALL = '■';    // 벽
    private static final char EMPTY = ' ';   // 빈 공간
    private static final char COIN = 'C';
    private static final char PLAYER = 'P';  // 플레이어 표시
    private static final char EXIT = 'E';    // 탈출구 표시

    private static char[][] maze = {
            {'■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■'},
            {'■', ' ', ' ', ' ', ' ', '■', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '■'},
            {'■', '■', '■', '■', ' ', '■', ' ', '■', '■', '■', '■', '■', '■', ' ', '■'},
            {'■', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '■', ' ', '■'},
            {'■', '■', '■', '■', '■', '■', '■', '■', '■', ' ', '■', '■', '■', ' ', '■'},
            {'■', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '■', ' ', ' ', ' ', '■', ' ', '■'},
            {'■', '■', '■', '■', '■', '■', '■', ' ', '■', ' ', '■', ' ', '■', ' ', '■'},
            {'■', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '■', ' ', '■', ' ', '■'},
            {'■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', ' ', '■', ' ', '■'},
            {'■', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '■', ' ', ' ', ' ', '■', ' ', '■'},
            {'■', ' ', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', ' ', '■'},
            {'■', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '■'},
            {'■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', ' ', '■'},
            {'■', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', '■'},
            {'■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■', '■'}
    };

    private static int playerX;
    private static int playerY;
    private static int coinCount;

    private static Scanner scanner = new Scanner(System.in);
    private static Random random = new Random();

    public static void main(String[] args) {
        initializeGame();
        coinCount = 0;

        while (true) {
            drawBoard();
            System.out.println("현재 코인 개수: " + coinCount);
            System.out.print("이동을 입력하세요 (w: 위, s: 아래, a: 왼쪽, d: 오른쪽) : ");
            char move = scanner.next().charAt(0);
            processMove(move);

            if (checkGameOver()) {
                System.out.println("벽에 부딪혔습니다. 게임 오버!");
                break;
            }

            if (checkGameWin()) {
                System.out.println("축하합니다! 미로를 탈출했습니다!");
                break;
            }
        }

        scanner.close();
    }

    private static void initializeGame() {
        // 시작 위치와 탈출구 초기화
        playerX = 1;
        playerY = 1;
        maze[MAZE_SIZE - 2][MAZE_SIZE - 14] = EXIT;
        
        // 코인 배치
        placeCoins();
    }

    private static void placeCoins() {
        // 코인을 랜덤하게 배치 (최소 5개)
        int coinsToPlace = 5 + random.nextInt(5); // 5개 이상 9개 이하의 코인 배치
        int coinsPlaced = 0;
        
        while (coinsPlaced < coinsToPlace) {
            int x = random.nextInt(MAZE_SIZE);
            int y = random.nextInt(MAZE_SIZE);
            
            if (maze[y][x] == EMPTY && !(x == 1 && y == 1) && !(x == MAZE_SIZE - 2 && y == MAZE_SIZE - 2)) {
                maze[y][x] = COIN;
                coinsPlaced++;
            }
        }
    }

    private static void drawBoard() {
        for (int y = 0; y < MAZE_SIZE; y++) {
            for (int x = 0; x < MAZE_SIZE; x++) {
                if (x == playerX && y == playerY) {
                    System.out.print(PLAYER + " ");
                } else {
                    System.out.print(maze[y][x] + " ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }

    private static void processMove(char move) {
        int newPlayerX = playerX;
        int newPlayerY = playerY;

        switch (move) {
            case 'w':
                newPlayerY--;
                break;
            case 's':
                newPlayerY++;
                break;
            case 'a':
                newPlayerX--;
                break;
            case 'd':
                newPlayerX++;
                break;
            default:
                System.out.println("유효하지 않은 입력입니다. 다시 입력하세요.");
                return;
        }

        // 이동할 위치가 벽이 아니고 미로 내부에 있을 경우에만 이동
        if (maze[newPlayerY][newPlayerX] != WALL &&
                newPlayerX >= 0 && newPlayerX < MAZE_SIZE &&
                newPlayerY >= 0 && newPlayerY < MAZE_SIZE) {
            playerX = newPlayerX;
            playerY = newPlayerY;

            // 코인을 먹었는지 확인
            if (eatCoin()) {
                coinCount++;
            }
        } else {
            // 벽에 부딪혔을 때 처리 (게임 종료)
            System.out.println("벽에 부딪혔습니다. 게임 오버!");
            System.exit(0); // 게임 종료
        }
    }

    private static boolean checkGameOver() {
        // 벽에 부딪히면 게임 오버
        return maze[playerY][playerX] == WALL;
    }

    private static boolean checkGameWin() {
        // 탈출구에 도착하면 게임 승리
        return maze[playerY][playerX] == EXIT;
    }
    
    private static boolean eatCoin() {
        // 플레이어가 코인을 먹었는지 확인
        if (maze[playerY][playerX] == COIN) {
            maze[playerY][playerX] = EMPTY; // 코인 제거
            return true;
        }
        return false;
    }
}
