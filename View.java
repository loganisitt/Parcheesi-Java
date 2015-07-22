/**
 * 
 * @author Logan Isitt
 *
 */

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.util.Arrays;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

@SuppressWarnings("serial")
public class View extends JFrame {

	private JPanel myMainPanel;
	private JPanel[] myBasePanels;
	private ArrayList<ArrayList<JLabel>> myLanePanels;
		
	final static Integer[] GAME_SPACES = {8, 27, 46, 65, 84, 103, 122, 141, 159, 
		158, 157, 156, 155, 154, 153, 152, 171, 190, 191, 192, 193, 194, 195, 
		196, 197, 217, 236, 255, 274, 293, 312, 331, 350, 351, 352, 333, 314, 
		295, 276, 257, 238, 219, 201, 202, 203, 204, 205, 206, 207, 208, 189, 
		170, 169, 168, 167, 166, 165, 164, 163, 143, 124, 105, 86, 67, 48, 29, 
		10, 9};
	
	public View() {
		
		Border border = BorderFactory.createLineBorder(Color.black);

		myMainPanel = new JPanel(new GridBagLayout());
		myMainPanel.setBackground(Color.BLACK);
		
		myBasePanels = new JPanel[4];
		myLanePanels = new ArrayList<ArrayList<JLabel>>(4);
		
		for (int i = 0; i < 4; i++) 
			myLanePanels.add(new ArrayList<JLabel>());
		
		for (int i = 0; i < myBasePanels.length; i++) {
			
			myBasePanels[i] = new JPanel();
			myBasePanels[i].setBorder(border);

			GridBagConstraints c = new GridBagConstraints();
			
			switch (i) {
			case 0: c.gridx = 0;  c.gridy = 0;  myBasePanels[i].setBackground(Color.GREEN);  break;
			case 1: c.gridx = 0;  c.gridy = 11; myBasePanels[i].setBackground(Color.YELLOW); break;
			case 2: c.gridx = 11; c.gridy = 0;  myBasePanels[i].setBackground(Color.RED);    break;
			case 3: c.gridx = 11; c.gridy =11;  myBasePanels[i].setBackground(Color.BLUE);   break;
			default: break;
			}

			c.weightx = 1;
			c.weighty = 1;
			c.gridwidth = 8;
			c.gridheight = 8;
			c.fill = GridBagConstraints.BOTH;
			
			myMainPanel.add(myBasePanels[i], c);
		}
				
		for (int i = 0; i < 19; i++){
			for (int j = 0; j < 19; j++) {
				
				// Skip bases
				if ((i < 8 && j < 8) || (i > 10 && j > 10) || 
						(i < 8 && j > 10) || (i > 10 && j < 8)) 
					continue; 
				
				// Skip Home
				if (i >= 8 && i <= 10 && j >= 8 && j <= 10) 
					continue; 

				JLabel jp = new JLabel("[" + panelSpotNum(i, j) + "]" );
//				JLabel jp = new JLabel("(" + i + ", " + j + ")");

				jp.setBorder(border);
				jp.setOpaque(true);
				jp.setBackground(Color.WHITE);
				GridBagConstraints c = new GridBagConstraints();
				
				c.gridx = i;
				c.gridy = j;
				c.weightx = 1;
				c.weighty = 1;
				c.fill = GridBagConstraints.BOTH;
				
				// Style center lanes
				if (i > 0 && i < 8 && j == 9) { 
					jp.setBackground(Color.YELLOW);
					myLanePanels.get(0).add(jp);
				}
				if (i > 10 && i < 18 && j == 9) { 
					jp.setBackground(Color.RED);
					myLanePanels.get(1).add(0, jp);
				}
				if (j > 0 && j < 8 && i == 9) { 
					jp.setBackground(Color.GREEN);
					myLanePanels.get(2).add(jp);
					
				}
				if (j > 10 && j < 18 && i == 9) { 
					jp.setBackground(Color.BLUE);
					myLanePanels.get(3).add(0, jp);
					
				}
				myMainPanel.add(jp, c);
			}
		}
		
		for (ArrayList<JLabel> jlList: myLanePanels) {
			for (int i = 0; i < jlList.size(); i++) {
				
				JLabel jl = jlList.get(i);
				jl.setText("" + (i + 1));
			}
		}
		
		this.getContentPane().add(myMainPanel);
		
		this.setBackground(Color.WHITE);
		this.setPreferredSize(new Dimension(700, 700));
		this.setVisible(true);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.pack();
	}
	
	public int panelSpotNum(int x, int y) {
		
		int space = x + (y * 19);
		
		Integer[] spaces = {8, 27, 46, 65, 84, 103, 122, 141, 159, 158, 
                157, 156, 155, 154, 153, 152, 171, 190, 191, 
                192, 193, 194, 195, 196, 197, 217, 236, 255,
                274, 293, 312, 331, 350, 351, 352, 333, 314,
                295, 276, 257, 238, 219, 201, 202, 203, 204,
                205, 206, 207, 208, 189, 170, 169, 168, 167,
                166, 165, 164, 163, 143, 124, 105, 86, 67, 48,
                29, 10, 9};
		
		return Arrays.asList(spaces).indexOf(space);
	}
}