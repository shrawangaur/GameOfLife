GameOfLife
==========

PTC Assignment
--------
Implement Convoy's game of life -

Rules
The universe of the Game of Life is an infinite two-dimensional orthogonal grid of square cells, 
each of which is in one of two possible states, alive or dead. Every cell interacts with its eight neighbours,
which are the cells that are horizontally, vertically, or diagonally adjacent. At each step in time, the following 
transitions occur:

Any live cell with fewer than two live neighbours dies, as if caused by under-population.
Any live cell with two or three live neighbours lives on to the next generation.
Any live cell with more than three live neighbours dies, as if by overcrowding.
Any dead cell with exactly three live neighbours becomes a live cell, as if by reproduction.

The initial pattern constitutes the seed of the system.
The first generation is created by applying the above rules simultaneously to every cell in the seed—births and 
deaths occur simultaneously, and the discrete moment at which this happens is sometimes called a tick
(in other words, each generation is a pure function of the preceding one). 
The rules continue to be applied repeatedly to create further generations.

For more information refer :- 

http://en.wikipedia.org/wiki/Conway's_Game_of_Life

About Implementation :-

As it is a zero player game, and requires a GRID and CELL to play it, There are two classes for them and corresponding tests 
There are two Boundary Conditions -
1. If cell start at NEGATIVE Coordinate. It is NOT PERMISSIBLE.
2. After several ticks if cell crosses the GRID Boundary, it will throw OUTOFBOUNDARY exception.

Literals are placed in Interface GameLiterals.
Naming Convention is followed both in code and tests so that methods are self explanatory.
Design is kept simple and scalable.

Happy Coding !!
Shrawan
