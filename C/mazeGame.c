/*================================================================================
                            MAZE GAME - PLAYER GUIDE
================================================================================
    Navigate through the maze, collect all 3 keys (@), and reach the exit (E)
    to win the game.

    w  → Move UP
    a  → Move LEFT
    s  → Move DOWN
    d  → Move RIGHT

GAME ELEMENTS:
    #  → Wall (blocks your path)
    P  → Your current position
    @  → Key to collect (you need all 3)
    E  → Exit door (only opens after collecting all keys)
    0  → Empty path (safe to walk on)
================================================================================
*/
#include <stdio.h>

int main()
{

    char maze[8][8] = {
        {'#', '#', '#', '#', '#', '#', '#', '#'},
        {'#', 'P', '0', '0', '#', '0', '@', '#'},
        {'#', '0', '#', '0', '#', '0', '0', '#'},
        {'#', '0', '#', '0', '@', '0', '#', '#'},
        {'#', '0', '#', '#', '#', '0', '0', '#'},
        {'#', '0', '@', '0', '#', '#', '0', '#'},
        {'#', '0', '0', '0', '0', 'E', '0', '#'},
        {'#', '#', '#', '#', '#', '#', '#', '#'}};

    // find player position

    // Print the maze
    int px = 1;
    int py = 1;

    int keys = 3;
    int reachedExit = 0;

    // find player position
    for (int i = 0; i < 8; i++)
    {
        for (int j = 0; j < 8; j++)
        {

            if (maze[i][j] == 'P')
            {
                px = i;
                py = j;
            }
        }
    }
    do
    {
        for (int i = 0; i < 8; i++)
        {
            for (int j = 0; j < 8; j++)
            {
                printf("%c ", maze[i][j]);
            }
            printf("\n");
        }
        printf("keys remaining %d \n", keys);
        printf("enter a direction w,a,s,d: ");
        char dir;

        scanf(" %c", &dir);
        int xnext = px;
        int ynext = py;

        switch (dir)
        {
        case 'w':
            xnext = px - 1;

            break;
        case 's':
            xnext = px + 1;

            break;
        case 'a':

            ynext = py - 1;
            break;
        case 'd':
            ynext = py + 1;
            break;
        default:
            printf("invalid direction, use 'w,s,a,d'\n");
            continue; // ignore the rest of the code and move to the next iteration
        }

        if (maze[xnext][ynext] == '#')
        {
            printf("you will hit a wall, try another direction\n");
            continue;
        }

        switch (maze[xnext][ynext])
        {
        case '0':
            maze[px][py] = '0';
            maze[xnext][ynext] = 'P';
            px = xnext;
            py = ynext;
            printf("\n");
            break;
        case '@':
            maze[px][py] = '0';
            maze[xnext][ynext] = 'P';
            keys--;
            printf("Key collected! %d remaining.\n\n", keys);
            px = xnext;
            py = ynext;
            break;
        case 'E':
            if (keys == 0)
            {
                maze[px][py] = '0';
                maze[xnext][ynext] = 'P';
                px = xnext;
                py = ynext;
                printf("\n========================================\n");
                printf("Congratulations! You collected all keys and reached the exit!\n");
                printf("========================================\n");

                reachedExit = 1;
            }
            else
            {
                printf("\ncollect the all keys(@) first\n");
            }
            break;
        }

    } while (!reachedExit);
    return 0;
}
