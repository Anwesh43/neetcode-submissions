func productExceptSelf(nums []int) []int {
    product := 1
    zeros := 0
    for _, num := range nums {
        if num != 0 {
            product = product * num 
        } else {
            zeros++
            if zeros == 2 {
                product = 0 
            }
        }
    }
    productArr := make([]int, len(nums))
    for i, num := range nums {
        if num == 0 {
            productArr[i] = product 
        } else if (zeros > 0){
            productArr[i] = 0 
        } else {
            productArr[i] = product / num 
        }
    }
    return productArr 
}
