import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class InputWindow extends JFrame {

	private JPanel contentPane;
    public static ArrayList<JButton> characterList;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputWindow frame = new InputWindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public InputWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
        Character[][] list = new Character[13][2];
        characterList = new ArrayList <JButton>();

		  for (int x = 0; x < 13; x++) {
              for (int y = 0; y < 2; y++) {
                  list[x][y]=(char) (65 + x+y);
                  	JButton newButton = new JButton(String.valueOf(list[x][y]));
                      //textFields[x][y].setFont(textFields[x][y].getFont().deriveFont(20.0f));
                      //newButton.setPreferredSize(new Dimension(60, 30)); // the widths of the textfileds
                      newButton.addMouseListener(new MouseAdapter(){
                      	@Override
                  		public void mouseClicked(MouseEvent e) {
                      		
                     		

                      	                  		
                  	}});

                      characterList.add(newButton);
                      add(newButton);
                  }                   
              }
          }
	}


