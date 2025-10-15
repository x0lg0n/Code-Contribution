/**
 * @file hello-world.c
 * @brief Classic "Hello World" program in C
 * 
 * This is the traditional first program written when learning C programming.
 * It demonstrates the basic structure of a C program and the use of the
 * standard I/O library for printing to the console.
 * 
 * @author Code-Contribution Community
 * @version 1.0
 * @date 2025-10-15
 * 
 * @copyright MIT License
 * 
 * @details
 * The program consists of:
 * - Including the standard I/O header (stdio.h)
 * - Defining the main function (program entry point)
 * - Using printf() to output text
 * - Returning 0 to indicate successful execution
 */

#include <stdio.h>

/**
 * @brief Main entry point of the program
 * 
 * The main function is where program execution begins.
 * In C, the main function can be declared as:
 * - int main(void) - takes no arguments
 * - int main(int argc, char *argv[]) - accepts command-line arguments
 * 
 * @param void No parameters
 * @return int Exit status (0 indicates success)
 * 
 * @note The return value is passed to the operating system.
 *       By convention, 0 means success, non-zero indicates an error.
 * 
 * @code
 * // Compile and run:
 * gcc hello-world.c -o hello-world
 * ./hello-world
 * @endcode
 * 
 * @par Expected Output:
 * @code
 * Hello World!
 * @endcode
 */
int main(void) {
    // Print greeting to standard output
    printf("Hello World!");
    
    // Return success status to OS
    return 0;
}

