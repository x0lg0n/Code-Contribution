program matmul_demo
  implicit none
  integer :: n, i, j, k
  print *, "Matrix size n (creates n x n matrices):"
  read *, n
  integer, allocatable :: A(:,:), B(:,:), C(:,:)
  allocate(A(n,n), B(n,n), C(n,n))

  ! Initialize A and B
  do i = 1, n
    do j = 1, n
      A(i,j) = i + j
      B(i,j) = i - j
      C(i,j) = 0
    end do
  end do

  ! Multiply C = A * B
  do i = 1, n
    do j = 1, n
      do k = 1, n
        C(i,j) = C(i,j) + A(i,k) * B(k,j)
      end do
    end do
  end do

  print *, "Result C(1:n,1:n):"
  do i = 1, n
    write(*,'(100(I6))') (C(i,j), j=1,n)
  end do

  deallocate(A,B,C)
end program matmul_demo