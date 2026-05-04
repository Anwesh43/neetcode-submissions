import "slices"
type NumIndex struct {
    num int 
    index int 
}
type Stack struct {
    elements []NumIndex 
}

func (s *Stack) push(element NumIndex) {
    s.elements = append(s.elements, element)
}

func (s *Stack) pop() *NumIndex {
    if len(s.elements) == 0 {
        return nil 
    }
    index := len(s.elements) - 1
    element := s.elements[index]
    s.elements = slices.Delete(s.elements, index, index + 1)
    return &element
}

func (s *Stack) peek() *NumIndex {
    if len(s.elements) == 0 {
        return nil 
    }
    index := len(s.elements) - 1
    element := s.elements[index]
    return &element
}

func (s *Stack) empty() bool {
    return len(s.elements) == 0
}

func dailyTemperatures(temperatures []int) []int {
  elements := make([]NumIndex, 0)
  s := Stack {
    elements : elements,
  }
  result := make([]int, len(temperatures))
  for i, temp := range temperatures {
    //fmt.Println("TEMP", temp, i)
    for !s.empty() {
        numIndex := s.peek()
        //fmt.Println(numIndex.num, numIndex.index)
        if temp > numIndex.num {
            result[numIndex.index] = i - numIndex.index 
            //fmt.Println("RESULT", result[numIndex.index])
            //fmt.Println("BEFORE POP",len(s.elements))
            s.pop()
            //fmt.Println("AFTER POP",len(s.elements))
            //continue
        } else {
             break
        }
    }
    s.push(NumIndex{
        num : temp,
        index : i, 
    })
  }
  return result
}

// [30, 38, 30, 36, 35, 40, 28]
// 1, _ , 1, 
// 38, 1  -> 4

// 36 , 3 -> 2

// 35, 4, -> 1

// 40, 5

// 28, 5