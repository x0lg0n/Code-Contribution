/**
 * @file hello-world.c++
 * @brief Classic "Hello World" program in C++
 * 
 * This program demonstrates the basic structure of a C++ application
 * using the iostream library for console output. It's the traditional
 * first program when learning C++ programming.
 * 
 * @author Code-Contribution Community
 * @version 1.0
 * @date 2025-10-15
 * 
 * @copyright MIT License
 * 
 * @details
 * The program demonstrates:
 * - Including the iostream header for I/O operations
 * - Using the std::cout stream for output
 * - The std:: namespace qualifier
 * - Returning exit status from main()
 * 
 * @see https://en.cppreference.com/w/cpp/io/cout
 */

#include <iostream>

/**
 * @brief Main entry point of the C++ program
 * 
 * The main function is where program execution begins in C++.
 * Unlike C, C++ main() doesn't require explicit void parameter.
 * 
 * @return int Exit status code
 * @retval 0 Successful program execution
 * @retval non-zero Error occurred during execution
 * 
 * @note In C++, std::cout is the standard output stream object
 *       from the iostream library. The << operator is the
 *       stream insertion operator.
 * 
 * @code{.cpp}
 * // Compile and run:
 * g++ hello-world.c++ -o hello-world
 * ./hello-world
 * @endcode
 * 
 * @par Expected Output:
 * @verbatim
 * Hello, world!
 * @endverbatim
 * 
 * @par Alternative using namespace:
 * @code{.cpp}
 * #include <iostream>
 * using namespace std;  // Avoid in large projects
 * 
 * int main() {
 *     cout << "Hello, world!\n";
 *     return 0;
 * }
 * @endcode
 */
int main() {
    // Output greeting to console using cout stream
    std::cout << "Hello, world!\n";
    
    // Return success status
    return 0;
}

