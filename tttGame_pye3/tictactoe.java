/* Puhua Ye
 * 31827249
 * Project 03
 * I did not collaborate with anyone on this assignment.
 */
import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class tictactoe implements ActionListener, MouseListener{
	Random random = new Random();
	JFrame gameFrame = new JFrame();
	JPanel statPanel = new JPanel();
	JPanel gamePanel = new JPanel();
	JLabel textField = new JLabel("Tic-Tac-Toe");
	JLabel statField1 = new JLabel();
	JLabel statField2 = new JLabel();
	JLabel statField3 = new JLabel();
	JButton newGame = new JButton("New Game");
	JLabel[] labels = new JLabel[9];
	int player1Stat = 0;
	int player2Stat = 0;
	int drawStat = 0;
	boolean player1Turn;
	boolean check = true;
	
//constructor
	tictactoe(){
		 gameFrame.setSize(800,580);
		 gameFrame.setTitle("TicTacToe");
		 gameFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		 gameFrame.setVisible(true);
		 
		 statPanel.setLayout(null);
		 statPanel.setBounds(0,0,800,100);
		 gamePanel.setLayout(new GridLayout(3,3,-1,-1));
		 gamePanel.setBorder(BorderFactory.createEmptyBorder(2,2,2,2));
		 gamePanel.setBounds(0,100,800,480);
		 
		 
		
		 statField1.setBounds(632,10,100,27);
		 statField1.setText("   player1: " + player1Stat + "   ");
		  
		 statField2.setBounds(632,37,100,27);
		 statField2.setText("   player2: " + player2Stat + "   ");

		 statField3.setBounds(632,64,100,27);
		 statField3.setText("   Draws: " + drawStat);
		 		 
		 for(int i = 0; i < 9; ++i) {
			 labels[i] = new JLabel();
			 gamePanel.add(labels[i]);
			 labels[i].setBorder(BorderFactory.createLineBorder(Color.BLACK)); 
			 labels[i].addMouseListener(this);
			 labels[i].setFont(new Font(null,Font.BOLD,50));
			 labels[i].setOpaque(true);
			 labels[i].setHorizontalAlignment(JLabel.CENTER); 
		 }
		 
		 textField.setBounds(360,10,220,80);
		 textField.setText("   Tic-Tac-Toe   ");
		 
		 newGame.addActionListener(this);
		 newGame.setFont(new Font(null,Font.BOLD,12));
		 newGame.setBounds(90,10,100,80);
		 
		 statPanel.add(newGame);
		 statPanel.add(textField);
		 statPanel.add(statField1);
		 statPanel.add(statField2);
		 statPanel.add(statField3);
		 gameFrame.add(gamePanel);
		 gameFrame.add(statPanel);
		 
		 whoFirst();
	}

//actionlistener for button:"New Game"
	@Override
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == newGame) {
			for(int i = 0; i < 9; ++i) {
				labels[i].setText("");
				labels[i].setBackground(null);
			}
			check = true;
			whoFirst();
		}
		}
	
//method to decide who go first	
	public void whoFirst() {
		if(random.nextInt(2) == 0) {
			player1Turn = true;
			textField.setText("player1 Turn");
		}
		else {
			player1Turn = false;
			textField.setText("player2 Turn");
		}
	}

//method to determine whether someone has won	
	public void check() {
		String[] topRow = new String[3];
		String[] middleRow = new String[3];
		String[] bottomRow = new String[3];
		String[] leftColumn = new String[3];
		String[] middleColumn = new String[3];
		String[] rightColumn = new String[3];
		String[] leadingDiagnoal = new String[3];
		String[] minorDiagnoal = new String[3];
		
		for(int i = 0; i < 3; ++i) {
			topRow[i] = labels[i].getText();
		}
		for(int i = 0; i < 3; ++i) {
			middleRow[i] = labels[i + 3].getText();
		}
		for(int i = 0; i < 3; ++i) {
			bottomRow[i] = labels[i + 6].getText();
		}
		for(int i = 0; i < 3; ++i) {
			leftColumn[i] = labels[i * 3].getText();
		}
		for(int i = 0; i < 3; ++i) {
			middleColumn[i] = labels[(i * 3) + 1].getText();
		}
		for(int i = 0; i < 3; ++i) {
			rightColumn[i] = labels[(i * 3) + 2].getText();
		}
		for(int i = 0; i < 3; ++i) {
			leadingDiagnoal[i] = labels[i * 4].getText();
		}
		for(int i = 0; i < 3; ++i) {
			minorDiagnoal[i] = labels[2 * (i + 1)].getText();
		}
		

		if(topRow[0] == topRow[1] && topRow[1] == topRow[2] && topRow[0] == "X") {
			textField.setText("Player1 Win for topRow");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(topRow[0] == topRow[1] && topRow[1] == topRow[2] && topRow[0] == "O") {
			textField.setText("Player2 Win for topRow");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i].setBackground(Color.PINK);
			}
			check = false;
		}
		if(middleRow[0] == middleRow[1] && middleRow[1] == middleRow[2] && middleRow[0] == "X") {
			textField.setText("Player1 Win for middleRow");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i + 3].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(middleRow[0] == middleRow[1] && middleRow[1] == middleRow[2] && middleRow[0] == "O") {
			textField.setText("Player2 Win for middleRow");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i + 3].setBackground(Color.PINK);
			}
			check = false;
		}
		if(bottomRow[0] == bottomRow[1] && bottomRow[1] == bottomRow[2] && bottomRow[0] == "X") {
			textField.setText("Player1 Win for bottomRow");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i + 6].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(bottomRow[0] == bottomRow[1] && bottomRow[1] == bottomRow[2] && bottomRow[0] == "O") {
			textField.setText("Player2 Win for bottomRow");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i + 6].setBackground(Color.PINK);
			}
			check = false;
		}
		if(leftColumn[0] == leftColumn[1] && leftColumn[1] == leftColumn[2] && leftColumn[0] == "X") {
			textField.setText("Player1 Win for leftColumn");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i * 3].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(leftColumn[0] == leftColumn[1] && leftColumn[1] == leftColumn[2] && leftColumn[0] == "O") {
			textField.setText("Player2 Win for leftColumn");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i * 3].setBackground(Color.PINK);
			}
			check = false;
		}
		if(middleColumn[0] == middleColumn[1] && middleColumn[1] == middleColumn[2] && middleColumn[0] == "X") {
			textField.setText("Player1 Win for middleColumn ");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[(i * 3) + 1].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(middleColumn[0] == middleColumn[1] && middleColumn[1] == middleColumn[2] && middleColumn[0] == "O") {
			textField.setText("Player2 Win for middleColumn");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[(i * 3) + 1].setBackground(Color.PINK);
			}
			check = false;
		}
		if(rightColumn[0] == rightColumn[1] && rightColumn[1] == rightColumn[2] && rightColumn[0] == "X") {
			textField.setText("Player1 Win for rightColumn");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[(i * 3) + 2].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(rightColumn[0] == rightColumn[1] && rightColumn[1] == rightColumn[2] && rightColumn[0] == "O") {
			textField.setText("Player2 Win for rightColumn");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[(i * 3) + 2].setBackground(Color.PINK);
			}
			check = false;
		}
		if(leadingDiagnoal[0] == leadingDiagnoal[1] && leadingDiagnoal[1] == leadingDiagnoal[2] && leadingDiagnoal[0] == "X") {
			textField.setText("Player1 Win for leadingDiagnoal");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i * 4].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(leadingDiagnoal[0] == leadingDiagnoal[1] && leadingDiagnoal[1] == leadingDiagnoal[2] && leadingDiagnoal[0] == "O") {
			textField.setText("Player2 Win for leadingDiagnoal");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[i * 4].setBackground(Color.PINK);
			}
			check = false;
		}
		if(minorDiagnoal[0] == minorDiagnoal[1] && minorDiagnoal[1] == minorDiagnoal[2] && minorDiagnoal[0] == "X") {
			textField.setText("Player1 Win for minorDiagnoal");
			++player1Stat;
			statField1.setText("   player1: " + player1Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[2 * (i + 1)].setBackground(Color.CYAN);
			}
			check = false;
		}
		if(minorDiagnoal[0] == minorDiagnoal[1] && minorDiagnoal[1] == minorDiagnoal[2] && minorDiagnoal[0] == "O") {
			textField.setText("Player2 Win for minorDiagnoal");
			++player2Stat;
			statField2.setText("   player2: " + player2Stat + "   ");
			for(int i = 0; i < 3; ++i) {
				labels[2 * (i + 1)].setBackground(Color.PINK);
			}
			check = false;
		}
		if(labels[0].getText() != "" &&
		   labels[1].getText() != "" &&
		   labels[2].getText() != "" &&
		   labels[3].getText() != "" &&
		   labels[4].getText() != "" &&
		   labels[5].getText() != "" &&
		   labels[6].getText() != "" &&
		   labels[7].getText() != "" &&
		   labels[8].getText() != "" &&
		   check) {
			textField.setText("DRAW");
			drawStat++;
			statField3.setText("   Draws: " + drawStat);
		}
	}
	
//mouseListener for labels to resonse for mouseclick
	@Override
	public void mouseClicked(MouseEvent e) {
		for(int i = 0; i < 9; ++i) {
			if(check) {
			if(e.getSource() == labels[i]) {
				if(player1Turn) {
					if(labels[i].getText() == "") {
						labels[i].setText("X");
						player1Turn = false;
						textField.setText("player2 Turn");
						check();
					}
				}
				else {
					if(labels[i].getText() =="") {
						labels[i].setText("O");
						player1Turn = true;
						textField.setText("player1 Turn");
						check();
					}
				}
			}
		}
		}
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	
	public static void main(String[] args) {
		tictactoe t = new tictactoe();
	}
	
}
	
