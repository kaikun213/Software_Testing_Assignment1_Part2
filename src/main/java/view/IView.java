package main.java.view;


import static main.java.controller.GameController.Event;

public interface IView {
	
	public void showMenu();
	public Event getUserEvent();

}
