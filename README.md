# my_merge_sort
A simple addition to the MergeSort algorithm presented in the book "Hands on Scala". I've altered the function in the book to take an array of class Any and then perform the algorithm, where it was previously hardcoded to only take arrays of Ints. With this modification we can sort arrays of all numeric types as well as strings -- provided of course the strings contain numbers.

The addition required the ability to compare two array elements that are of class any, which cannot be done directly as the less than operator is not a member of class Any. So in the pattern matching step,

case (true, true) => sortedLeft(leftIdx) < sortedRight(rightIdx),

I changed this line to 

case (true, true) => sortedLeft(leftIdx).toString.toDouble < sortedRight(rightIdx).toString.toDouble. Then I made the appropriate modifications to the function argument type and return type.

I am not sure if going from Any -> String -> Double is a good idea for all input types.

Basic use case:

mysort(Array("3", -6, 8.0, BigInt(1234567890), BigDecimal(123456.789)))
  > res1: Array[Any] = Array(-6, 3, 8.0, 123456.789, 1234567890)



