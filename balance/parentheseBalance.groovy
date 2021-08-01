def result = isBalanced(args[0])

println result

def boolean isBalanced(String inputString) {
    Stack<Character> testStack = new Stack<Character>();
    for(def i = 0; i < inputString.size(); i++) {
        if (inputString[i] == '(') {
            testStack.push(inputString[i]);
        } else if(inputString[i] == ')') {
            if(testStack.isEmpty() || testStack.pop() != '(')
                    return false;
        }
    }
    return testStack.isEmpty();
}