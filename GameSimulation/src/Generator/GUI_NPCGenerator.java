package Generator;

import java.awt.EventQueue;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.BorderFactory;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.image.BufferedImage;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.text.NumberFormatter;
import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.text.NumberFormat;


public class GUI_NPCGenerator extends JFrame{
	
	private static final String[] portraits = {"star.png"/*To ADD*/};
	
	private int hp, maxhp, initiative;
	
	public GUI_NPCGenerator(){
		initGUI();
	}
	
	private final void initGUI()
	{
		String[] gender = {"Male", "Female", "Unknown"};
		String[] classS = {"Warrior", "Archer", "Mage"};
		String[] race = {"Human", "Dwarve", "Elf"};
		String[] prof = {"Blacksmith", "Tailor"};
		String[] character = {"Lawful Good", "Neutral Good",
				"Chaotic Good", "Lawful Neutral", "Neutral", "Chaotic Neutral",
				"Lawful Evil", "Nautral Evil", "Chaotic Evil"};
		String[] Statistic = {"Strenght", "Agility", "Endurance", "Technomancy", "Insight", "Luck"};
		String[] Power = {"0","1","2","3","4","5","6","7","8","9","10"};
		
		
		int pointPool = 20;
		JMenuBar menubar = new JMenuBar();
		
		JMenu fileMenu = new JMenu("File");

		JMenuItem expMenu = new JMenuItem("Export");

        JMenuItem newMi = new JMenuItem("New");
        JMenuItem saveMi = new JMenuItem("Save");

        JMenuItem exitMi = new JMenuItem("Exit");
        exitMi.setToolTipText("Exit application");

        exitMi.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {
                System.exit(0);
            }

			
        });

        fileMenu.add(newMi);
        fileMenu.add(saveMi);
        fileMenu.addSeparator();
        fileMenu.add(expMenu);
        fileMenu.addSeparator();
        fileMenu.add(exitMi);

        menubar.add(fileMenu);

        setJMenuBar(menubar);        
		
		setLayout(new GridBagLayout());
		GridBagConstraints gc = new GridBagConstraints();
		gc.fill = GridBagConstraints.HORIZONTAL;
		
		//mainPanel.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
		
		
//		JPanel portraitPanel = new JPanel();
//		
//
//		gc.weightx = 1;
//		gc.weighty = 1;
//		gc.gridx = 0;
//		gc.gridy = 0;
//		gc.gridheight = 2;
//		//portraitPanel.setLayout(new GridLayout(1,1,5,5));
//		
//		BufferedImage buttonIcon = null;
//		try {
//			 buttonIcon = ImageIO.read(new File(portraits[0]));
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		
//		
//	
//		
//	    
//	   
//		
//		JButton portraitButton = new JButton(new ImageIcon(buttonIcon));
//		//portraitButton.setBorder(BorderFactory.createEmptyBorder());
//		portraitButton.setContentAreaFilled(false);
//	//	portraitButton.setSize(10, 10);
//	    portraitPanel.add( portraitButton);
//	    
//	    add(portraitPanel, gc);
	    
JPanel namePanel = new JPanel();
namePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
gc.gridheight = 1;
gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 0;
		gc.weightx = 1;
		gc.weighty = 0;
	    namePanel.setLayout(new GridLayout(1,2));
	    
	    JLabel nameLabel = new JLabel("Name");
	    nameLabel.setHorizontalAlignment(JLabel.CENTER);
	    JTextField nameField = new JTextField();
	    
	    
	    namePanel.add(nameLabel);
	    namePanel.add(nameField);
	    
	    add(namePanel,gc);
	    
JPanel agePanel = new JPanel();
agePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));
gc.gridwidth = 1;
	   
		gc.gridx = 0;
		gc.gridy = 1;
		
	    agePanel.setLayout(new GridLayout(1,2));
	    
	    JLabel ageLabel = new JLabel("Age");
	    ageLabel.setHorizontalAlignment(JLabel.CENTER);
	    NumberFormat longFormat = NumberFormat.getIntegerInstance();

	    NumberFormatter numberFormatter = new NumberFormatter(longFormat);
	    numberFormatter.setValueClass(Long.class); //optional, ensures you will always get a long value
	    numberFormatter.setAllowsInvalid(false); //this is the key!!
	    numberFormatter.setMinimum(0l); //Optional
	    numberFormatter.setMaximum(999l);

	    JFormattedTextField ageField = new JFormattedTextField(numberFormatter);
	    
	    ageField.setText("1");
	    
	    
	    agePanel.add(ageLabel);
	    agePanel.add(ageField);
	    
	    add(agePanel, gc);
	    
JPanel genderPanel = new JPanel();
genderPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	   
	    
		gc.gridx = 1;
		gc.gridy = 1;
		
	    genderPanel.setLayout(new GridLayout(1,2));
	    JLabel genderLabel = new JLabel("Gender");
	    JComboBox<String> genderBox =  new JComboBox<String>(gender);
	    genderLabel.setHorizontalAlignment(JLabel.CENTER);
	    genderPanel.add(genderLabel);
	    genderPanel.add(genderBox);
	    
	    add(genderPanel,gc);
	    
JPanel racePanel = new JPanel();
racePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	   
		gc.gridx = 0;
		gc.gridy = 2;
	    
		
	    
	    racePanel.setLayout(new GridLayout(1,2));
	    JLabel raceLabel = new JLabel("Race");
	    JComboBox<String> raceBox =  new JComboBox<String>(race);
	    raceLabel.setHorizontalAlignment(JLabel.CENTER);
	    racePanel.add(raceLabel);
	    racePanel.add(raceBox);
	    
	    add(racePanel,gc);
	    
	    JPanel classPanel = new JPanel();
	    classPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	   
		gc.gridx = 1;
		gc.gridy = 2;
	    
	    classPanel.setLayout(new GridLayout(1,2));
	    JLabel classLabel = new JLabel("Class");
	    classLabel.setHorizontalAlignment(JLabel.CENTER);
	    JComboBox<String> classBox =  new JComboBox<String>(classS);
	    classPanel.add(classLabel);
	    classPanel.add(classBox);
	  
	    add(classPanel,gc);
	    
	    JPanel hpPanel = new JPanel();
	    hpPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    gc.gridx = 0;
		gc.gridy = 3;
		
		maxhp = 100;
		hp = maxhp;
		
		JLabel hpLabel = new JLabel("HP: " + hp + "/" + maxhp);
		
		hpPanel.add(hpLabel);
		
		add(hpPanel, gc);
		
		JPanel initiativePanel = new JPanel();
		initiativePanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    gc.gridx = 1;
		gc.gridy = 3;
		
		initiative = 5;
		
		JLabel initiativeLabel = new JLabel("Initiative: " + initiative);
		
		initiativePanel.add(initiativeLabel);
		
		add(initiativePanel, gc);
	    
//	    JPanel profPanel = new JPanel();
//	    
//	   
//		gc.gridx = 1;
//		gc.gridy = 2;
//	    
//	    profPanel.setLayout(new GridLayout(2,1));
//	    JLabel profLabel = new JLabel("Race");
//	    JComboBox<String> profBox =  new JComboBox<String>(prof);
//	    profLabel.setHorizontalAlignment(JLabel.CENTER);
//	    profPanel.add(profLabel);
//	    profPanel.add(profBox);
//	    
//	    add(profPanel,gc);
	    
	    
	    
	    JPanel characterPanel = new JPanel();
	    characterPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    gc.gridwidth = 2;
		gc.gridx = 0;
		gc.gridy = 4;
	    
	    characterPanel.setLayout(new GridLayout(1,2));
	    JLabel characterLabel = new JLabel("Character");
	    JComboBox<String> characterBox =  new JComboBox<String>(character);
	    characterLabel.setHorizontalAlignment(JLabel.CENTER);
	    characterPanel.add(characterLabel);
	    characterPanel.add(characterBox);
	    
	   
	    add(characterPanel,gc);
	    
	    gc.gridwidth = 1;
	    
	    JPanel motivationPanel = new JPanel();
	    motivationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    motivationPanel.setLayout(new GridLayout(1,2));
	    
	    gc.gridwidth = 2;
	    gc.gridheight = 1;
	    
		gc.gridx = 0;
		gc.gridy = 5;
		
		motivationPanel.add(new JLabel("Motivation"));
		
		    JTextArea motivationField = new JTextArea();
		    motivationField.setPreferredSize(new Dimension(120,400));
		    
		    motivationPanel.add(motivationField);
		    add(motivationPanel, gc);
		
		    JPanel ancestryPanel= new JPanel();
		    ancestryPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

		    ancestryPanel.setLayout(new GridLayout(1,2));
		    
		    gc.gridwidth = 2;
		    gc.gridheight = 1;
		    
			gc.gridx = 0;
			gc.gridy = 6;
			
			ancestryPanel.add(new JLabel("Ancestry"));
			
			JTextArea ancestryField = new JTextArea();
			    ancestryField.setBounds(new Rectangle(new Dimension(120,120)));
			    
			    ancestryPanel.add(ancestryField);
			    add(ancestryPanel, gc);
			    
		    
	    JPanel pointPoolPanel = new JPanel();
	    pointPoolPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    
	    gc.gridwidth = 1;
	    gc.gridheight = 1;
	    gc.gridx = 0;
		gc.gridy = 7;
	    pointPoolPanel.setLayout(new GridLayout(1,2));
	    
	    pointPoolPanel.add(new JLabel("Points: "));
	    pointPoolPanel.add(new JLabel(Integer.toString(pointPool)));
	    
	    add(pointPoolPanel, gc);
	    
	    JPanel statisticPanel = new JPanel();
	    statisticPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    gc.gridwidth = 2;
	    gc.gridx = 0;
	    gc.gridy = 8;
	  //  gc.gridheight = 6;
	    
	    statisticPanel.setLayout(new GridLayout(6,2));
	    
	    
	    for(int i = 0; i < 6; i++)
	    {
	    	statisticPanel.add(new JLabel(Statistic[i]));
	    	statisticPanel.add(new JComboBox<String>(Power));
	    }
	    
	    add(statisticPanel, gc);
	    
	    
	    JPanel educationPanel = new JPanel();
	    educationPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    educationPanel.setLayout(new GridLayout(1,2));
	    
	    gc.gridheight = 6;
	    gc.gridwidth = 2;
	    gc.gridx = 2;
	    gc.gridy = 0;
	    
	    JLabel educationLabel = new JLabel("Education: ");
	    
	    educationPanel.add(educationLabel);
	    
	    JTable educationTable = new JTable();
	    educationTable.setGridColor(Color.BLACK);
	    
	    educationPanel.add(educationTable);
	    
	    add(educationPanel, gc);
	    
	    JPanel perksPanel = new JPanel();
	    perksPanel.setBorder(BorderFactory.createLineBorder(Color.BLACK));

	    perksPanel.setLayout(new GridLayout(1,2));
	    
	    gc.gridheight = 6;
	    gc.gridwidth = 2;
	    gc.gridx = 2;
	    gc.gridy = 6;
	    
	    JLabel perksLable = new JLabel("Perks: ");
	    
	    perksPanel.add(perksLable);
	    
	    JTable perksTable = new JTable();
	    perksTable.setGridColor(Color.BLACK);
	    
	    perksPanel.add(perksTable);
	    
	    add(perksPanel, gc);
	    	    
	    setTitle("NPC_Creator_Tool");
		setSize(600, 380);
		setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
		
	}

	
	
	  public static void main(String[] args) {

	        EventQueue.invokeLater(new Runnable() {
	            @Override
	            public void run() {
	                GUI_NPCGenerator ex = new GUI_NPCGenerator();
	                ex.setVisible(true);
	            }
	        });
	    }

}
