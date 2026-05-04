func twoSum(nums []int, target int) []int {
    twoSumMap := make(map[int]int)
    result := []int{-1, -1}
    for i, num := range nums {
        if existingIndex,exists := twoSumMap[target - num]; exists {
            result[0] = existingIndex 
            result[1] = i 
        } else {
            twoSumMap[num] = i 
        }
    }
    return result;
}
