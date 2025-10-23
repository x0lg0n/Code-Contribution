program fibonacci
  implicit none
  integer :: n, i
  print *, "How many Fibonacci numbers?"
  read *, n
  if (n <= 0) then
    print *, "n must be positive"
    stop
  end if

  integer, allocatable :: a(:)
  allocate(a(n))
  a(1) = 1
  if (n > 1) a(2) = 1
  do i = 3, n
    a(i) = a(i-1) + a(i-2)
  end do

  print *, "Fibonacci sequence:"
  do i = 1, n
    print '(I0,2X,I0)', i, a(i)
  end do

  deallocate(a)
end program fibonacci