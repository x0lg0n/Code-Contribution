// check-palindrome.scala
object CheckPalindrome {
    private def normalize(s: String): String =
        s.filter(_.isLetterOrDigit).toLowerCase

    private def isPalindrome(s: String): Boolean = {
        val n = normalize(s)
        n.nonEmpty && n == n.reverse
    }

    def main(args: Array[String]): Unit = {
        val input =
            if (args.nonEmpty) args.mkString(" ")
            else {
                print("Enter text or number: ")
                scala.io.StdIn.readLine()
            }

        if (input == null || input.trim.isEmpty) {
            println("No input provided.")
            return
        }

        if (isPalindrome(input)) println(s"'$input' is a palindrome.")
        else println(s"'$input' is not a palindrome.")
    }
}