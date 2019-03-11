package com.vijyant.exercise.calculator;


import java.util.Stack;

/**
 * @author vijyant
 *
 * @since Mar 10, 2019
 *
 */
public class Calculator {
	
	
	/**
	 * @param input
	 * @return string result of calculation
	 *  only implements binary operators +, -, * and /
	 * it uses two stack one for operand and other for operator
	 * first it parses the string to create operand and operator stack
	 * the method evaluates in left to right fashion
	 * 
	 */
	public String eval(String input) {
		
		Stack<String> operands = new Stack<>();
		Stack<Character> operators = new Stack<>();
		char[] chars =  input.toCharArray();
		
		Character prev =null;
		//filling stack from the end to evaluate from left to right
		for (int i = chars.length-1; i>=0; i--) {
			char c = chars[i];
			int val = (int)c;
			if(val >= 48 && val <=57) { // numerals
				if(prev!=null) {
					String op = Character.toString(c)+operands.pop();
					operands.push(op);
				}else {
					operands.push(Character.toString(c));
				}
				prev=c; // for numbers with more than 1 digit
			}else {
				prev =  null;
			}
			if(val == 42 || val == 43 || val==45 || val ==47) { // operators 
				operators.push(c);
			}
		}
		return evaluate(operands, operators);
	}
	
	/**
	 * only implements binary operators
	 * 
	 * @param operands
	 * @param operators
	 * @return
	 */
	private  String evaluate(Stack<String> operands, Stack<Character> operators) {
		char opr = 0;
		Double partial = null;
		while(!operators.isEmpty()) {
			opr = operators.pop();
			String opn1 = operands.pop();
			String opn2 = operands.isEmpty()?null:operands.pop();
			
			char nextOpChar = operators.isEmpty()?0:operators.peek() ;
			int nextOp = (int)nextOpChar ;
			
			switch(opr) {
				case '*':
					if(opn2 != null) {
						partial = Double.parseDouble(opn1) * Double.parseDouble(opn2);						
						operands.push(partial.toString());
					}else {
						operands.push(opn1);
					}
					break;
				case  '+':
					// if the next operator is multiply/divide , then pop the next operand multiple and
					// push to stack the partial result of the multiply then also push the 
					// + operator and operand, incase there is another multiply or divide 
					// eg 3*4*5 + 6
					if(nextOp == 42) {
						operators.pop();
						partial = Double.parseDouble(opn2) * Double.parseDouble(operands.pop());
						operands.push(partial.toString());
						operands.push(opn1);
						operators.push(opr);
						
					}else if (nextOp == 47) {
						operators.pop();
						partial = Double.parseDouble(opn2) / Double.parseDouble(operands.pop());
						operands.push(partial.toString());
						operands.push(opn1);
						operators.push(opr);
						
					}else {
						partial = Double.parseDouble(opn1) + Double.parseDouble(opn2);	
						operands.push(partial.toString());
						
					}
					break;
				case '-':	
					// if the next operator is multiply/divide , then pop the next operand multiple and
					// push to stack the partial result of the multiply then also push the 
					// + operator and operand, incase there is another multiply or divide 
					// eg 3*4*5 + 6
					if(nextOp == 42) {
						operators.pop();
						partial = Double.parseDouble(opn2) * Double.parseDouble(operands.pop());
						operands.push(partial.toString());
						operands.push(opn1);
						operators.push(opr);				
					}else if (nextOp == 47) {
						operators.pop();
						partial = Double.parseDouble(opn2) / Double.parseDouble(operands.pop());
						operands.push(partial.toString());
						operands.push(opn1);
						operators.push(opr);
					}else {
						partial = Double.parseDouble(opn1) - Double.parseDouble(opn2);	
						operands.push(partial.toString());
					}
					break;
				case '/':
					if(opn2 != null) {
						partial = Double.parseDouble(opn1) / Double.parseDouble(opn2);						
						operands.push(partial.toString());
					}else {
						operands.push(opn1);
					}
					break;
			}
			
		}
		
		return operands.pop();
	}
	

}
