program factorial_demo
  implicit none
  integer :: n
  print *, "Enter non-negative integer n:"
  read *, n
  if (n < 0) then
     print *, "n must be non-negative"
     stop 1
  end if
  print *, "Factorial:", fact(n)
contains
  recursive function fact(k) result(res)
    integer, intent(in) :: k
    integer :: res
    if (k <= 1) then
      res = 1
    else
      res = k * fact(k-1)
    end if
  end function fact
end program factorial_demo