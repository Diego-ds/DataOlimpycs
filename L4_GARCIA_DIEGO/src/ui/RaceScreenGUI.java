package ui;



import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import model.Olympics;
import model.Timer;
import threads.ArrayListThread;
import threads.BinaryTreeThread;
import threads.LinkedListThread;
import threads.TimerThread;

public class RaceScreenGUI {
	
	private Timer timer;
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
    
    public RaceScreenGUI() {
    	olympics=new Olympics();
    	timer = new Timer();
    }
 
    @FXML
    void startRace(ActionEvent event) {
    	timer.setRunTime(true);
    	TimerThread time = new  TimerThread(this,timer);
    	Long seed =System.currentTimeMillis();
    	int num= Integer.parseInt(numberField.getText());
    	if(iterativeBut.isSelected() ) {
    		if(addBut.isSelected()) {
    			ArrayListThread a = new ArrayListThread(olympics,seed,0,0,num,this);
        		BinaryTreeThread b = new BinaryTreeThread(olympics,seed,0,0,num,this);
        		LinkedListThread l = new LinkedListThread(olympics,seed,0,0,num,this);
        		
        		time.start();
        		a.start();
        		b.start();
        		l.start();  
        		
    		}else if(deleteBut.isSelected()) {
    			ArrayListThread a = new ArrayListThread(olympics,seed,1,0,num,this);
        		BinaryTreeThread b = new BinaryTreeThread(olympics,seed,1,0,num,this);
        		LinkedListThread l = new LinkedListThread(olympics,seed,1,0,num,this);
        		//change the seed
        		seed=System.currentTimeMillis();
        		
        		ArrayListThread add1 = new ArrayListThread(olympics,seed,0,0,num,this);
        		BinaryTreeThread add2 = new BinaryTreeThread(olympics,seed,0,0,num,this);
        		LinkedListThread add3 = new LinkedListThread(olympics,seed,0,0,num,this);
        		//start the add threads
        		add1.start();
        		add2.start();
        		add3.start();
        		//wait for them to start deleting
        		try {
					add1.join();
					add2.join();
					add3.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
        				
        		time.start();
        		a.start();
        		b.start();
        		l.start();
        		
        		try {
					a.join();
					b.join();
					l.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}else if(searchBut.isSelected()) {
    			ArrayListThread a = new ArrayListThread(olympics,seed,2,0,num,this);
        		BinaryTreeThread b = new BinaryTreeThread(olympics,seed,2,0,num,this);
        		LinkedListThread l = new LinkedListThread(olympics,seed,2,0,num,this);
        		//change the seed
        		seed=System.currentTimeMillis();
        		ArrayListThread add1 = new ArrayListThread(olympics,seed,0,0,num,this);
        		BinaryTreeThread add2 = new BinaryTreeThread(olympics,seed,0,0,num,this);
        		LinkedListThread add3 = new LinkedListThread(olympics,seed,0,0,num,this);
        		//start the add threads
        		add1.start();
        		add2.start();
        		add3.start();
        		//wait for them to start searching
        		try {
					add1.join();
					add2.join();
					add3.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
        		
        		time.start();
        		a.start();
        		b.start();
        		l.start();
        		
        		try {
					a.join();
					b.join();
					l.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
    		
    	}else if(recursiveBut.isSelected()) {
    		if(addBut.isSelected()) {
    			ArrayListThread a = new ArrayListThread(olympics,seed,0,1,num,this);
        		BinaryTreeThread b = new BinaryTreeThread(olympics,seed,0,1,num,this);
        		LinkedListThread l = new LinkedListThread(olympics,seed,0,1,num,this);
        		time.start();
        		a.start();
        		b.start();
        		l.start();
        		
        		try {
					a.join();
					b.join();
					l.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}else if(deleteBut.isSelected()) {
    			ArrayListThread a = new ArrayListThread(olympics,seed,1,1,num,this);
        		BinaryTreeThread b = new BinaryTreeThread(olympics,seed,1,1,num,this);
        		LinkedListThread l = new LinkedListThread(olympics,seed,1,1,num,this);
        		//change the seed
        		seed=System.currentTimeMillis();
        		
        		ArrayListThread add1 = new ArrayListThread(olympics,seed,0,0,num,this);
        		BinaryTreeThread add2 = new BinaryTreeThread(olympics,seed,0,0,num,this);
        		LinkedListThread add3 = new LinkedListThread(olympics,seed,0,0,num,this);
        		//start the add threads
        		add1.start();
        		add2.start();
        		add3.start();
        		//wait for them to start deleting
        		try {
					add1.join();
					add2.join();
					add3.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
        		
        		time.start();
        		a.start();
        		b.start();
        		l.start();
        		
        		try {
					a.join();
					b.join();
					l.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}else if(searchBut.isSelected()) {
    			ArrayListThread a = new ArrayListThread(olympics,seed,2,1,num,this);
        		BinaryTreeThread b = new BinaryTreeThread(olympics,seed,2,1,num,this);
        		LinkedListThread l = new LinkedListThread(olympics,seed,2,1,num,this);
        		//change the seed
        		seed=System.currentTimeMillis();
        		
        		ArrayListThread add1 = new ArrayListThread(olympics,seed,0,0,num,this);
        		BinaryTreeThread add2 = new BinaryTreeThread(olympics,seed,0,0,num,this);
        		LinkedListThread add3 = new LinkedListThread(olympics,seed,0,0,num,this);
        		//start the add threads
        		add1.start();
        		add2.start();
        		add3.start();
        		//wait for them to start deleting
        		try {
					add1.join();
					add2.join();
					add3.join();
				} catch (InterruptedException e1) {
					e1.printStackTrace();
				}
        		time.start();
        		a.start();
        		b.start();
        		l.start();
        		
        		try {
					a.join();
					b.join();
					l.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
    		}
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
}

