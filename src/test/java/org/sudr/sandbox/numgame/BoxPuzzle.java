package org.sudr.sandbox.numgame;

import java.awt.Component;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class BoxPuzzle extends JFrame {
	private static final long serialVersionUID = 1L;

	private static final int SIZE = 5;
	JPanel[][] panelArray = new JPanel[SIZE][SIZE];
	private boolean dialogShown = false;

	public BoxPuzzle() {
		this.setTitle(SIZE * SIZE - 1 + " square puzzle");
		this.add(getGamePanel(SIZE));
		this.setSize(SIZE * 75, SIZE * 75);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		for (int i = 0; i < SIZE * 100; i++)
			// RANDOMIZE MOVES
			handleKeyPress((int) (Math.random() * 4) + 37);
		processKeys();
		this.setVisible(true);
	}

	private void processKeys() {
		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getID() == KeyEvent.KEY_PRESSED) {
					handleKeyPress(e.getKeyCode());
					if (areThingsInPlace() && !dialogShown) {
						dialogShown = true;
						JOptionPane.showMessageDialog(null, "Congratulations!!! YOU WIN!!");
						System.exit(1);
					}
				}
				return false;
			}
		});
	}

	private void handleKeyPress(int keyCode) {
		int emptyIndex = findEmptyIndex();
		int x = emptyIndex / SIZE;
		int y = emptyIndex % SIZE;

		switch (keyCode) {
		case 37:// LEFT KEY
			if (y == SIZE - 1)
				return;
			doSwap(x, y, x, y + 1);
			break;
		case 38:// UP KEY
			if (x == SIZE - 1)
				return;
			doSwap(x, y, x + 1, y);
			break;
		case 39:// RIGHT KEY
			if (y == 0)
				return;
			doSwap(x, y, x, y - 1);
			break;
		case 40:// DOWN KEY
			if (x == 0)
				return;
			doSwap(x, y, x - 1, y);
			break;
		}
	}

	private void doSwap(int x, int y, int x1, int y1) {
		Component temp1, temp2;
		temp1 = panelArray[x][y].getComponent(0);
		temp2 = panelArray[x1][y1].getComponent(0);
		panelArray[x][y].remove(0);
		panelArray[x1][y1].remove(0);
		panelArray[x1][y1].add(temp1);
		panelArray[x][y].add(temp2);
		temp2.requestFocus();
		this.repaint();
	}

	private int findEmptyIndex() {
		for (int i = 0; i < SIZE; i++)
			for (int j = 0; j < SIZE; j++)
				if (!(panelArray[i][j].getComponent(0) instanceof JButton))
					return i * SIZE + j;
		return 0;
	}

	private boolean areThingsInPlace() {
		for (int i = 0; i < SIZE * SIZE - 1; i++)
			if (!((panelArray[i / SIZE][i % SIZE].getComponent(0)).getName().equals("" + i)))
				return false;
		return true;
	}

	public static void main(String args[]) {
		new BoxPuzzle();
	}

	private JPanel getGamePanel(int difficulty) {
		JPanel pnlGame = new JPanel();
		GridLayout matrixLayout = new GridLayout(difficulty, difficulty);
		pnlGame.setLayout(matrixLayout);

		List<JComponent> componentsList = getRandomizedList(difficulty);
		int index = 0;
		for (int i = 0; i < difficulty; i++) {
			panelArray[i] = new JPanel[difficulty];
			for (int j = 0; j < difficulty; j++) {
				panelArray[i][j] = new JPanel();
				panelArray[i][j].setLayout(new GridLayout(1, 1));
				panelArray[i][j].add(componentsList.get(index++));
				pnlGame.add(panelArray[i][j]);
			}
		}
		return pnlGame;
	}

	private List<JComponent> getRandomizedList(int difficulty) {
		List<JComponent> componentSet = new ArrayList<JComponent>();
		for (int i = 0; i < difficulty * difficulty - 1; i++) {
			JButton button = new JButton("" + (i + 1));
			button.setName("" + i);
			componentSet.add(button);
		}
		componentSet.add(new JPanel());
		return componentSet;
	}
}