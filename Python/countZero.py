"""
countZero.py

Count the number of zeros in an integer array.

Input format (stdin):
 - First line: an integer n = number of elements
 - Second line: n integers separated by spaces (or multiple lines allowed)

Output:
 - Prints the count of elements equal to 0.

If run with no/invalid input, a small self-test runs instead.
"""

from typing import Iterable
import sys


def count_zeros(iterable: Iterable[int]) -> int:
	"""Return the number of zeros in the given iterable of integers.

	Args:
		iterable: An iterable of integers.

	Returns:
		The count of values equal to 0.
	"""
	c = 0
	for x in iterable:
		if x == 0:
			c += 1
	return c


def parse_input(stream) -> list:
	"""Parse input from a stream and return a list of integers.

	Expected: first token may be n (ignored if present), remaining tokens are treated as numbers.
	"""
	data = stream.read().strip().split()
	if not data:
		return []
	# If first token looks like the count and matches remaining length, skip it
	try:
		nums = [int(tok) for tok in data]
	except ValueError:
		raise

	if len(nums) >= 2 and nums[0] == len(nums) - 1:
		return nums[1:]
	# Otherwise return all tokens
	return nums


def main() -> int:
	try:
		arr = parse_input(sys.stdin)
	except Exception:
		print("Error: failed to parse input. Expected integers.")
		return 1

	if not arr:
		# self-test / demo
		demo = [0, 1, 0, 2, 0, 3]
		print("No input detected — running demo array:", demo)
		print("Zero count:", count_zeros(demo))
		return 0

	print(count_zeros(arr))
	return 0


if __name__ == '__main__':
	raise SystemExit(main())
