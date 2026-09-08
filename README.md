Write a Java application class that implements the following search algorithms.
a) linearSearch() – accepts an array of floating point numbers and a floating
point number, then returns index of the specified floating point number
when the number is present in the array, otherwise it should return -1.
b) binarySearch() - accepts an array of integer numbers, an integer search
key, start position and an end position, then returns index of the search key
when the specified key is present in the array, otherwise it should return
-1.
Test the above methods as follows:
- Create 2 arrays, each to hold 50 values.
- Use a for-loop and the Math.random method to generate 50 floating point
values between 0 and 80, and store them in the first array.
- Use a while loop to store the first 50 positive even int values in the second
array.
- Repeatedly prompt user to choose an algorithm to search with, execute the
appropriate algorithm based on the user’s selection and display the outcome
with an explanatory message. Your program should terminate when user
does not select l (or L) and b (or B).
- Use array 1 for testing linear search and array 2 for testing binary search.
