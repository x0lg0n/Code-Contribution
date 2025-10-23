       PROGRAM PROJEC
************************************************************************
* This program calculates the velocity and height of a projectile      *
* given its initial height, initial velocity, and constant             *
* acceleration.  Variables used are:                                   *
*    HGHT0   :  initial height                                         *
*    HGHT    :  height at any time                                     *
*    VELOC0  :  initial vertical velocity                              *
*    VELOC   :  vertical velocity at any time                          *
*    ACCEL   :  vertical acceleration                                  *
*    TIME    :  time elapsed since projectile was launched             *
*                                                                      *
* Input:   none                                                        *
* Output:  VELOC, HGHT                                                 *
************************************************************************

       REAL HGHT0, HGHT, VELOC0, VELOC, ACCEL, TIME

       ACCEL = -9.807
       HGHT0 = 100.0
       VELOC0 = 90.0
       TIME = 4.3
       HGHT = 0.5 * ACCEL * TIME ** 2  +  VELOC0 * TIME  +  HGHT0
       VELOC = ACCEL * TIME + VELOC0
       PRINT *, 'AT TIME ', TIME, ' THE VERTICAL VELOCITY IS ', VELOC
       PRINT *, 'AND THE HEIGHT IS ', HGHT
       END