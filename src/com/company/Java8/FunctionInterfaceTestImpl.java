package com.company.Java8;

//Test class to implement above interface
public class FunctionInterfaceTestImpl {
	public static void main(String[] args){
		//Old way using anonymous inner class
		FunctionalInterfaceTest fit = new FunctionalInterfaceTest(){
			public void display(){
				System.out.println("Display from old way");
			}};
		fit.display();//outputs: Display from old way
		//Using lambda expression
		FunctionalInterfaceTest newWay = () -> {System.out.println("Display from new Lambda Expression");};
		newWay.display();//outputs : Display from new Lambda Expression
	}
}
