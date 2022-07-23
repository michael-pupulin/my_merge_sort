def mysort(items: Array[Any]): Array[Any] = {
    if (items.length <= 1) items // return input if length is one -- already sorted
    else {
      val (left, right) = items.splitAt(items.length / 2) // split array in half (or close if length is odd)
      val (sortedLeft, sortedRight) = (mysort(left), mysort(right)) // define two new arrays based on the split, still of type any
      //map(i => i.toString.toDouble)
      var (leftIdx, rightIdx) = (0, 0) // Indexes for putting arrays back together
      val output = Array.newBuilder[Any] // create output builder
      while (leftIdx < sortedLeft.length || rightIdx < sortedRight.length) {
        // Pattern matching while loop to sort and combine.
        // This loop goes until we the indexes have moved through both the left and right arrays.
        val takeLeft = (leftIdx < sortedLeft.length, rightIdx < sortedRight.length) match {
          case (true, false) => true
          case (false, true) => false
          case (true, true) => sortedLeft(leftIdx).toString.toDouble < sortedRight(rightIdx).toString.toDouble
        }
        if (takeLeft) {
          output += sortedLeft(leftIdx)
          leftIdx += 1
        } else {
          output += sortedRight(rightIdx)
          rightIdx += 1
        }
        // If the left array at the left index is less than the right array at the right index, then
        // things are in order already and we add this value to our output array. Otherwise, these elements are NOT
        // in order and we add the element from the right to the output array so that it comes before the left element.
      }
      output.result()
    }

  }