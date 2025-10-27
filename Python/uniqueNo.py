
"""
uniqueNo.py

Find the unique number in an array where every other element appears exactly twice.

Input (stdin):
 - First line: optional integer n (number of elements)
 - Remaining tokens: integers (either n integers, or a list of integers)

Output:
 - Prints the unique integer (the one that appears once) to stdout.

If no input is provided, a small demo runs.
"""

import sys
from typing import Iterable


def unique_number(arr: Iterable[int]) -> int:
	"""Return the unique number when every other number appears exactly twice.

	This uses XOR properties: x ^ x = 0 and x ^ 0 = x, so XORing all numbers
	leaves the unique value.
	"""
	res = 0
	for x in arr:
		res ^= x
	return res


def parse_input(stream) -> list:
	data = stream.read().strip().split()
	if not data:
		return []
	try:
		nums = [int(tok) for tok in data]
	except ValueError:
		raise

	# If first token is count and matches remaining length, skip it
	if len(nums) >= 2 and nums[0] == len(nums) - 1:
		return nums[1:]
	return nums


def main() -> int:
	try:
		arr = parse_input(sys.stdin)
	except Exception:
		print("Error: failed to parse input. Expected integers.")
		return 1

	if not arr:
		demo = [2, 3, 5, 4, 5, 3, 4]
		print("No input detected — running demo array:", demo)
		print("Unique number:", unique_number(demo))
		return 0

	print(unique_number(arr))
	return 0


if __name__ == '__main__':
	raise SystemExit(main())
