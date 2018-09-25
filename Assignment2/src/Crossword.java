
//12345
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import java.awt.event.ActionEvent;

import javax.swing.*;

public class Crossword {

    private JFrame f;
    private static char[][] charSet;
    

    /**
     * Launch the application.
     */
    
    
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Crossword window = new Crossword();
                    window.f.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                /*
                 * charSet = new char[20][20]; for (int i=0;i<20;i++) { for (int j = 0;
                 * j<20;j++) { charSet[i][j]= } }
                 */
            }
        });
    }

    /**
     * Create the application.
     */
    public Crossword() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        f = new JFrame();
        f.setBounds(100, 100, 800, 800);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.getContentPane().setLayout(new BorderLayout());

        JPanel container = new JPanel(new FlowLayout());
        final CrosswordPanel panel = new CrosswordPanel();
        container.add(panel);
        f.getContentPane().add(container, BorderLayout.CENTER);

        generate(panel);

        JPanel InputContainer = new JPanel(new FlowLayout());
        InputContainer.add(new JLabel("Please enter:"));
        InputContainer.add(new JLabel("x:"));

        // JTextField xTextfield = new JTextField();
        // xTextfield.setColumns(1);
        // InputContainer.add(xTextfield);

        Integer[] indexData = new Integer[20];
        for (int i = 0; i < 20; i++) {
            indexData[i] = i + 1;
        }
        JComboBox<Integer> xComboBox = new JComboBox<>(indexData);
        InputContainer.add(xComboBox);

        InputContainer.add(new JLabel("y:"));
        // JTextField yTextfield = new JTextField();
        // yTextfield.setColumns(1);
        // InputContainer.add(yTextfield);
        JComboBox<Integer> yComboBox = new JComboBox<>(indexData);
        InputContainer.add(yComboBox);

        InputContainer.add(new JLabel("Letter:"));
        // JTextField xTextfield = new JTextField();
        // xTextfield.setColumns(1);
        // InputContainer.add(xTextfield);
        
        Character[] list = new Character[26];
        for (int i = 0; i < 26; i++) {
            list[i]=(char) (65 + i);
        }
        JComboBox<Character> letterComboBox = new JComboBox<>(list);
        InputContainer.add(letterComboBox);
        
        JButton submitButton = new JButton("Submit");
        submitButton.addMouseListener(new MouseAdapter(){
        	@Override
    		public void mouseClicked(MouseEvent e) {
    			int x = xComboBox.getSelectedIndex();
    			int y = yComboBox.getSelectedIndex();
    			char l =  (char) (65+letterComboBox.getSelectedIndex());
    			if ((CrosswordPanel.textFields[x][y].getText().equals(String.valueOf("\u0020")))) {
    				CrosswordPanel.textFields[x][y].setText(Character.toString(l));}
    			else    				
    				submitButton.setText(CrosswordPanel.textFields[x][y].getText());

    				;
    		}
    		
    	});
    	
    
        InputContainer.add(submitButton);
        f.getContentPane().add(InputContainer, BorderLayout.SOUTH);

        f.setSize(1500, 1000);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

    }
    
    
    
    
    private static void generate(CrosswordPanel panel) {
        int w = 20;
        int h = 20;
        char crossword[][] = new char[w][h];
        for (int y = 0; y < h; y++) {
            for (int x = 0; x < w; x++) {
                crossword[x][y] = '\u0020'; // null character

            }
        }
       
        panel.setCrossword(crossword);
    }

   
    
    
    class InputPanel extends JPanel {
    	
    	
    	
    }

    static class CrosswordPanel extends JPanel {
        public static JButton textFields[][];
        private JLabel label[][];

        void setCrossword(char array[][]) {
            removeAll();
            int w = array.length;
            int h = array[0].length;
            setLayout(new GridLayout(w + 1, h + 1));
            textFields = new JButton[w][h];
            label = new JLabel[w + 1][h + 1];
            for (int x = -1; x < w; x++) {
                // label[x][y] = new JLabel(String.valueOf(x+1));
                add(new JLabel(String.valueOf(x + 1)));
            }
            for (int y = 0; y < h; y++) {
                for (int x = 0; x < w; x++) {
                    char c = array[x][y];
                    if (x == 0) {
                        add(new JLabel(String.valueOf(y + 1)));
                    }
                    if (c != 0) {
                        textFields[x][y] = new JButton(String.valueOf(c));
                        //textFields[x][y].setFont(textFields[x][y].getFont().deriveFont(20.0f));
                        textFields[x][y].setPreferredSize(new Dimension(60, 30)); // the widths of the textfileds

                        add(textFields[x][y]);
                    } else {
                        add(new JLabel());
                    }
                }
            }
            getParent().validate();
            repaint();
        }

       public char[][] getCrossword() {
            int w = textFields.length;
            int h = textFields[0].length;
            char crossword[][] = new char[w][h];

            return crossword;
        }

    }
}