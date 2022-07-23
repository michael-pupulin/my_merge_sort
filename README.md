# my_merge_sort
A super simple addition to the MergeSort algorithm presented in the book "Hands on Scala". Works on arrays of type Any. I've altered the function to take an array of class Any and then perform the algorithm, whereas in the book it was hardcoded to only take arrays of Ints. With this modification we can sort arrays of all numeric types as well as strings -- provided of course the strings contain numbers.

The addition required the ability to compare two array elements that are of class any, as the less than operator is not a member of class Any. So in the pattern matching step,

case (true, true) => sortedLeft(leftIdx) < sortedRight(rightIdx),

I changed this line to 

case (true, true) => sortedLeft(leftIdx).toString.toDouble < sortedRight(rightIdx).toString.toDouble. Then I made the appropriate modifications to the function argument type and return type.

I am not sure if going from Any -> String -> Double is a good idea for all input types.

To return an array of type double, assuming our result is an array named "result", I would then do 

result.map(i => i.toString.toDouble) 



