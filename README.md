# UnoSChallenge

EXERCISE 

There are bunch of mines in a mine field, and you are tasked with
exploding as many of them as you can.  The only caveat is you can
only explode one manually.  The mine you manually explode will set
off a chain reaction.  For any mine that explodes, all mines within
the blast radius of that mine will be triggered to explode in one
second.  The mine you manually explode blows up at time 0.

Your Task: Write a program which will read in a mines file and
output the maximum number of mines you can explode.  Also output
which mine you need to manually set off to explode this maximum
number.  Since there may be multiple mines that blow up a maximal
number of mines you should output all the mines that do that.

We'll provide you with:
Mines File (space separated) with values:
(x, y, r) - where x is x coordinate, y is y coordinate and r is blast radius

Example:
  1   2  53\n
-32  40 100\n
 10  15  25\n
-15 -15 200\n
