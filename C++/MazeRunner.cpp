#include <iostream>
#include <vector>
#include <cstdlib>
#include <ctime>

// Maze dimensions
const int WIDTH = 10;
const int HEIGHT = 10;

// Symbols
const char PLAYER = 'P';
const char WALL = '#';
const char EMPTY = ' ';
const char KEY = 'K';
const char EXIT = 'E';
const char TRAP = 'T';
const char ENEMY = 'M';

// Structure to represent a point in the maze
struct Point {
    int x, y;
};

// Function prototypes
void initializeMaze(std::vector<std::vector<char>>& maze, Point& playerPos, Point& exitPos);
void printMaze(const std::vector<std::vector<char>>& maze);
bool movePlayer(Point& playerPos, const std::string& direction, std::vector<std::vector<char>>& maze);
bool checkWinCondition(const Point& playerPos, const Point& exitPos, int keysCollected);

int main() {
    srand(static_cast<unsigned int>(time(0))); // Seed for random number generation

    std::vector<std::vector<char>> maze(HEIGHT, std::vector<char>(WIDTH, EMPTY));
    Point playerPos;
    Point exitPos;
    int keysCollected = 0;
    int totalKeys = 3; // Total keys to collect to unlock the exit

    initializeMaze(maze, playerPos, exitPos);
    
    std::string command;
    bool gameRunning = true;

    while (gameRunning) {
        printMaze(maze);
        std::cout << "Keys collected: " << keysCollected << "/" << totalKeys << "\n";
        std::cout << "Enter command (e.g., 'move up', 'move down', etc.): ";
        std::getline(std::cin, command);

        // Extract direction from the command
        std::string direction;
        if (command.find("move ") == 0) {
            direction = command.substr(5); // Get the part after "move "
        } else {
            std::cout << "Invalid command format!\n";
            continue;
        }

        if (movePlayer(playerPos, direction, maze)) {
            // Check for keys
            if (maze[playerPos.y][playerPos.x] == KEY) {
                keysCollected++;
                maze[playerPos.y][playerPos.x] = EMPTY;
                std::cout << "You collected a key!\n";
            }

            // Check for traps
            if (maze[playerPos.y][playerPos.x] == TRAP) {
                std::cout << "You stepped on a trap and lost the game!\n";
                gameRunning = false;
                continue;
            }

            // Check if player reached the exit
            if (checkWinCondition(playerPos, exitPos, keysCollected)) {
                std::cout << "You collected all keys and reached the exit! You win!\n";
                gameRunning = false;
            }
        } else {
            std::cout << "Invalid move!\n";
        }
    }

    return 0;
}

void initializeMaze(std::vector<std::vector<char>>& maze, Point& playerPos, Point& exitPos) {
    // Place walls around the maze
    for (int i = 0; i < HEIGHT; ++i) {
        for (int j = 0; j < WIDTH; ++j) {
            if (i == 0 || i == HEIGHT - 1 || j == 0 || j == WIDTH - 1) {
                maze[i][j] = WALL;
            }
        }
    }

    // Randomly place the player
    playerPos = {1, 1};
    maze[playerPos.y][playerPos.x] = PLAYER;

    // Place the exit
    exitPos = {WIDTH - 2, HEIGHT - 2};
    maze[exitPos.y][exitPos.x] = EXIT;

    // Randomly place keys, ensuring they are not on the player's position or the exit
    for (int i = 0; i < 3; ++i) {
        int x, y;
        do {
            x = rand() % (WIDTH - 2) + 1;
            y = rand() % (HEIGHT - 2) + 1;
        } while ((x == playerPos.x && y == playerPos.y) || (x == exitPos.x && y == exitPos.y));
        maze[y][x] = KEY;
    }

    // Randomly place traps, ensuring they are not on the player's position or the exit
    for (int i = 0; i < 3; ++i) {
        int x, y;
        do {
            x = rand() % (WIDTH - 2) + 1;
            y = rand() % (HEIGHT - 2) + 1;
        } while (maze[y][x] != EMPTY);
        maze[y][x] = TRAP;
    }
}

void printMaze(const std::vector<std::vector<char>>& maze) {
    for (int i = 0; i < HEIGHT; ++i) {
        for (int j = 0; j < WIDTH; ++j) {
            std::cout << maze[i][j] << ' ';
        }
        std::cout << '\n';
    }
}

bool movePlayer(Point& playerPos, const std::string& direction, std::vector<std::vector<char>>& maze) {
    int dx = 0, dy = 0;
    if (direction == "up") dy = -1;
    else if (direction == "down") dy = 1;
    else if (direction == "left") dx = -1;
    else if (direction == "right") dx = 1;
    else return false;

    int newX = playerPos.x + dx;
    int newY = playerPos.y + dy;

    if (maze[newY][newX] != WALL) {
        maze[playerPos.y][playerPos.x] = EMPTY;
        playerPos.x = newX;
        playerPos.y = newY;
        maze[newY][newX] = PLAYER;
        return true;
    }
    return false;
}

bool checkWinCondition(const Point& playerPos, const Point& exitPos, int keysCollected) {
    return playerPos.x == exitPos.x && playerPos.y == exitPos.y && keysCollected >= 3;
}
