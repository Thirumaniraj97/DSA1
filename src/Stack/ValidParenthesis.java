package Stack;

import java.util.Stack;

public class ValidParenthesis {
	public boolean isValid(String s) {
		java.util.Stack<Character> stack = new Stack<>();
		for (char ch : s.toCharArray()) {
			if (ch == '(' || ch == '{' || ch == '[') {
				stack.push(ch);
			} else {
				if (stack.isEmpty()) {
					return false;
				} else {
					char top = stack.peek();
					if ((top == '(' && ch == ')') || (top == '{' && ch == '}') || (top == '[' && ch == ']')) {
						stack.pop();
					} else {
						return false;
					}
				}

			}
		}
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		ValidParenthesis vp = new ValidParenthesis();
		System.out.println(vp.isValid("()"));
		System.out.println(vp.isValid("(){"));
		System.out.println(vp.isValid("()[]"));
	}
}
