package ui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.shape.Circle;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.CircleManage;
import model.Olympics;
import model.Timer;
import threads.ArrayListThread;
import threads.BinaryTreeThread;
import threads.CirclesThread;
import threads.LinkedListThread;
import threads.TimerThread;

public class RaceScreenGUI {
	private ArrayListThread arrayThread;
	private BinaryTreeThread treeThread;
	private LinkedListThread listThread;
	private Timer timer;
	private CircleManage circleManager;
	private Olympics olympics;
    @FXML
    private TextField numberField;

    @FXML
    private RadioButton addBut;

    @FXML
    private ToggleGroup G1;

    @FXML
    private RadioButton searchBut;

    @FXML
    private RadioButton deleteBut;

    @FXML
    private RadioButton iterativeBut;

    @FXML
    private ToggleGroup G2;

    @FXML
    private RadioButton recursiveBut;

    @FXML
    private Label mainTime;

    @FXML
    private Label ArrayTime;

    @FXML
    private Label listTime;

    @FXML
    private Label treeTime;

    @FXML
    private Circle circle2;

    @FXML
    private Circle circle1;
    
    
    public RaceScreenGUI() {
    	olympics=new Olympics();
    	timer = new Timer();
    	circleManager = new CircleManage();
    	
		
    }
    
    @FXML
    public void initialize() {
    	circleManager.addCircle(circle1.getRadius());
    	circleManager.addCircle(circle2.getRadius());
    }
	@FXML
	public void startRace(ActionEvent event) {
		//reset all before the race
		clearTimers();
		timer.clearClock();
		olympics.restartStructures();
		//
		circleManager.setMovement(true);
		timer.setRunTime(true);
		//time and circles thread
		TimerThread time = new TimerThread(this, timer);
		CirclesThread circles = new CirclesThread(this,circleManager);
		Long seed = System.currentTimeMillis();
		int num=0;;
		try{
			 num = Integer.parseInt(numberField.getText());
		}catch(NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Error");
			alert.setHeaderText("You have entered wrong data");
			alert.setContentText("Please enter a number");
			alert.showAndWait();
		}
		if (iterativeBut.isSelected()) {
			if (addBut.isSelected()) {
				 arrayThread = new ArrayListThread(olympics, seed, 0, 0, num, this);
				 treeThread = new BinaryTreeThread(olympics, seed, 0, 0, num, this);
				 listThread = new LinkedListThread(olympics, seed, 0, 0, num, this);
				
				circles.start();
				time.start();
				arrayThread.start();
				treeThread.start();
				listThread.start();
				
				
			} else if (deleteBut.isSelected()) {
				arrayThread = new ArrayListThread(olympics, seed, 1, 0, num, this);
				treeThread = new BinaryTreeThread(olympics, seed, 1, 0, num, this);
				listThread = new LinkedListThread(olympics, seed, 1, 0, num, this);
				// change the seed
				seed = System.currentTimeMillis();

				ArrayListThread add1 = new ArrayListThread(olympics, seed, 0, 0, num, this);
				BinaryTreeThread add2 = new BinaryTreeThread(olympics, seed, 0, 0, num, this);
				LinkedListThread add3 = new LinkedListThread(olympics, seed, 0, 0, num, this);
				// start the add threads
				add1.start();
				add2.start();
				add3.start();
				// wait for them to start deleting
				try {
					add1.join();
					add2.join();
					add3.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				circles.start();
				time.start();
				arrayThread.start();
				treeThread.start();
				listThread.start();
				

			
			} else if (searchBut.isSelected()) {
				arrayThread = new ArrayListThread(olympics, seed, 2, 0, num, this);
				treeThread = new BinaryTreeThread(olympics, seed, 2, 0, num, this);
				listThread = new LinkedListThread(olympics, seed, 2, 0, num, this);
				// change the seed
				seed = System.currentTimeMillis();
				ArrayListThread add1 = new ArrayListThread(olympics, seed, 0, 0, num, this);
				BinaryTreeThread add2 = new BinaryTreeThread(olympics, seed, 0, 0, num, this);
				LinkedListThread add3 = new LinkedListThread(olympics, seed, 0, 0, num, this);
				// start the add threads
				add1.start();
				add2.start();
				add3.start();
				// wait for them to start searching
				try {
					add1.join();
					add2.join();
					add3.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
				
				circles.start();
				time.start();
				arrayThread.start();
				treeThread.start();
				listThread.start();
				

				}else if(!searchBut.isSelected() && !deleteBut.isSelected() && !addBut.isSelected()){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error");
					alert.setHeaderText("There are unselected options");
					alert.setContentText("Please select all the fields");
					alert.showAndWait();
				}
			} else if (recursiveBut.isSelected()) {
				if (addBut.isSelected()) {
					arrayThread = new ArrayListThread(olympics, seed, 0, 1, num, this);
					treeThread = new BinaryTreeThread(olympics, seed, 0, 1, num, this);
					listThread= new LinkedListThread(olympics, seed, 0, 1, num, this);
					time.start();
					arrayThread.start();
					treeThread.start();
					listThread.start();
				} else if (deleteBut.isSelected()) {
					arrayThread = new ArrayListThread(olympics, seed, 1, 1, num, this);
					treeThread = new BinaryTreeThread(olympics, seed, 1, 1, num, this);
					listThread  = new LinkedListThread(olympics, seed, 1, 1, num, this);
					// change the seed
					seed = System.currentTimeMillis();

					ArrayListThread add1 = new ArrayListThread(olympics, seed, 0, 0, num, this);
					BinaryTreeThread add2 = new BinaryTreeThread(olympics, seed, 0, 0, num, this);
					LinkedListThread add3 = new LinkedListThread(olympics, seed, 0, 0, num, this);
					// start the add threads
					add1.start();
					add2.start();
					add3.start();
					// wait for them to start deleting
					try {
						add1.join();
						add2.join();
						add3.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					circles.start();
					time.start();
					arrayThread.start();
					treeThread.start();
					listThread.start();
					
	

				} else if (searchBut.isSelected()) {
					arrayThread = new ArrayListThread(olympics, seed, 2, 1, num, this);
					treeThread = new BinaryTreeThread(olympics, seed, 2, 1, num, this);
					listThread = new LinkedListThread(olympics, seed, 2, 1, num, this);
					// change the seed
					seed = System.currentTimeMillis();

					ArrayListThread add1 = new ArrayListThread(olympics, seed, 0, 0, num, this);
					BinaryTreeThread add2 = new BinaryTreeThread(olympics, seed, 0, 0, num, this);
					LinkedListThread add3 = new LinkedListThread(olympics, seed, 0, 0, num, this);
					// start the add threads
					add1.start();
					add2.start();
					add3.start();
					// wait for them to start deleting
					try {
						add1.join();
						add2.join();
						add3.join();
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}
					
					circles.start();
					time.start();
					arrayThread.start();
					treeThread.start();
					listThread.start();
					
				}else if (!searchBut.isSelected() && !deleteBut.isSelected() && !addBut.isSelected()){
					Alert alert = new Alert(AlertType.WARNING);
					alert.setTitle("Error");
					alert.setHeaderText("There are unselected options");
					alert.setContentText("Please select all the fields");
					alert.showAndWait();
				}
			}else if(!recursiveBut.isSelected() && !iterativeBut.isSelected()) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Error");
				alert.setHeaderText("There are unselected options");
				alert.setContentText("Please select all the fields");
				alert.showAndWait();
			}
	}

    @FXML
    public String updateTime() {
    	String time = timer.advanceTime();
    	return time;
    }
    
    @FXML
    public void setLabel(String time) {
    	mainTime.setText(time);
    }
    
    @FXML
    public void setLinkListTime() {
    	String time = mainTime.getText();
    	listTime.setText(time);
    }
    @FXML
    public void setBinaryTreeTime() {
    	String time = mainTime.getText();
    	treeTime.setText(time);
    }
    @FXML
    public void setArrayListTime() {
    	String time = mainTime.getText();
    	ArrayTime.setText(time);
    }
    @FXML
    public void clearTimers() {
    	ArrayTime.setText("00:00:000");
    	listTime.setText("00:00:000");
    	treeTime.setText("00:00:000");
    }
    public void updateCircles() {
    	circle1.setRadius(circleManager.getCircles().get(0).getRadius());
    	circle2.setRadius(circleManager.getCircles().get(1).getRadius());
    }
    public void moveCircles() {
    	circleManager.increaseCircle();
    }

	public ArrayListThread getArrayThread() {
		return arrayThread;
	}

	public BinaryTreeThread getTreeThread() {
		return treeThread;
	}

	public LinkedListThread getListThread() {
		return listThread;
	}
    
    
}

