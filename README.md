# iCarros

Questão 1 - Fizzing 'n buzzing
Write a program that prints the numbers from 1 to 100. But for multiples of three
print "Fizz" instead of the number and for multiples of five print "Buzz". For
numbers which are multiples of both three and five print "FizzBuzz".

Questão 2 - Angry Marvin Birds
Marvin is addicted to 'Angry Birds’, which became huge in the vicinities of
Betelgeuse. The game has multiple stages, and for each stage the player can
gain between 0 and 3 stars, inclusive. You are given a String[] result, containing
Marvin's results. For each stage, result[i] contains an element that specifies
Marvin's result in that stage. For example, if he got 0 stars in stage i, result[i]
would be “---”. For 1 star, result[i] would be “*--”, and so on. Return the total
number of stars Marvin has at the moment.

Questão 3 - Creepy hours
Suppose that we're given a moment of time written as HH:MM, where HH is the
hour and MM is the minutes, and a clock that beeps every time a creepy
moment happens. Let's say that a moment is considered creepy if it is
formatted as AB:AB, AA:BB, AB:BA or AA:AA. You are given a String[]
moments, where each element represents a single moment of time. Return how
many times the clock beeped. For example, for an input
{"11:00","13:13","10:00"}, the result would be 2.

Questão 4 - We are the champions, my friend
In soccer leagues, the winner of a match is awarded with 3 points and the loser
0 points. In case of a tie, both teams are awarded with 1 point each. Given int[]
wins and int[] ties, and knowing that the i'th elements of wins and ties
correspond to the number of wins and ties respectively for team i; return the
number of points the champion team achieved in this league. For inputs wins =
{1,0,3} and ties = {2, 2, 0}, the result would be 9 (the team at i=2 would win this
championship).

Questão 5 - Venting the costs
After the death of the Death Star, the Empire is reviewing all the component
buying orders. As the DBA of a company that is specialized in building exhaust
vents, you are required to send to Lord Vader himself a list of all orders that
were made and how much they did cost. To do so, you need to create a SQL
query that returns the total value of each order made by CustomerName
"DeathStar", showing the OrderID and TotalPrice (one order per row).

Questão 6 – MarsRover
An implementation of the MarsRover coding challenge
A squad of robotic rovers are to be landed by NASA on a plateau on Mars. This
plateau, which is curiously rectangular, must be navigated by the rovers so that
their on-board cameras can get a complete view of the surrounding terrain to
send back to Earth.
A rover’s position and location is represented by a combination of x and y coordinates
and a letter representing one of the four cardinal compass points. The
plateau is divided up into a grid to simplify navigation. An example position
might be 0, 0, N, which means the rover is in the bottom left corner and facing
North.
In order to control a rover, NASA sends a simple string of letters. The possible
letters are ‘L’, ‘R’ and ‘M’. ‘L’ and ‘R’ makes the rover spin 90 degrees left or
right respectively, without moving from its current spot. ‘M’ means move
forward one grid point, and maintain the same heading.
Assume that the square directly North from (x, y) is (x, y+1).
INPUT: The first line of input is the upper-right coordinates of the plateau, the
lower-left coordinates are assumed to be 0,0.
The rest of the input is information pertaining to the rovers that have been
deployed. Each rover has two lines of input. The first line gives the rover’s
position, and the second line is a series of instructions telling the rover how to
explore the plateau.
The position is made up of two integers and a letter separated by spaces,
corresponding to the x and y co-ordinates and the rover’s orientation.
Each rover will be finished sequentially, which means that the second rover
won’t start to move until the first one has finished moving.

OUTPUT The output for each rover should be its final co-ordinates and
heading.
INPUT AND OUTPUT
Test Input: 5 5
1 2 N
LMLMLMLMM
3 3 E
MMRMMRMRRM
Expected Output:
1 3 N
5 1 E
