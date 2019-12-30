# Round1PQ
PriorityQueue

Main class will ask for the options.
There are four options:
for each option ,It will ask for the operation.
If the appropriate Number is not given ,it will ask for again the options


Implementation :
Used hashMap and ArrayList.
HashMap stores key as Priority value and value as elements.
Add method is overrided for ArrayList, while adding elements itself priority will be sorted.

Insert element with priority : This adds priority in ArrayList(O(Log(n)) and stores data in hashmap.
Delete element with Highest Priority : Take the max number from sorted List(0(1)) and get the element from the map.
