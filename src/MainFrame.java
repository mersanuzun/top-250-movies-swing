import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.ComponentOrientation;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowStateListener;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JSlider;
import javax.swing.JTextArea;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.UIManager;
import javax.swing.border.LineBorder;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import javax.swing.text.Style;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyleContext;
import javax.swing.text.StyledDocument;

import model.Country;
import model.DBService;
import model.Genre;
import model.Language;
import model.Movie;
import model.Person;

import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.Button;
import javax.swing.ImageIcon;
import javax.swing.JTable;
import javax.swing.border.MatteBorder;
import javax.swing.JTextPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.ListSelectionModel;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private final ButtonGroup buttonGroupImbdRating = new ButtonGroup();
	private final ButtonGroup buttonGroupYear = new ButtonGroup();
	private JTextField textFieldMovieTitle;
	private DefaultListModel<String> modelGenres = new DefaultListModel<String>();
	public static final int MOVIE_PANEL_WIDTH = 125;
	public static final int MOVIE_PANEL_HEIGHT = 200;
	public static final int MOVIE_TOP_PANEL_HEIGHT = 25;
	public static final Color MOVIE_TOP_PANEL_COLOR = Color.CYAN;
	public static final int MOVIE_BOTTOMandTOP_PANEL_WIDTH = 125;
	public static final int MOVIE_BOTTOM_PANEL_HEIGHT = 40;
	public static final Color MOVIE_BOTTOM_PANEL_COLOR = Color.LIGHT_GRAY;
	public static final int ADVANCED_SEARCH_PANEL_WIDTH = 250;
	public MovieInfo panelMovieInfo;
	public JPanel leftPanel;
	private CastInfo panelCastInfo;
	public DBService dbService;
	public ArrayList<Movie> movies = new ArrayList<Movie>();
	private JPanel moviesPanel;

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		// defining dbService
		dbService = new DBService();

		// getting all movies
		movies = dbService.getMovies();

		// setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setExtendedState(JFrame.MAXIMIZED_BOTH);
		// setResizable(false);
		setTitle("IMDB TOP 250");
		setBounds(100, 100, 509, 767);
		contentPane = new JPanel(new BorderLayout());
		contentPane.setBorder(null);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		//setMinimumSize(new Dimension(1000, 750));
		setExtendedState(this.getExtendedState() | JFrame.MAXIMIZED_BOTH);

		// top panel
		JPanel topPanel = new JPanel();
		topPanel.setBorder(UIManager.getBorder("RootPane.frameBorder"));
		topPanel.setPreferredSize(new Dimension(500, 75));
		
		topPanel.setBackground(new Color(160,82,45));
		getContentPane().add(topPanel, BorderLayout.NORTH);
		topPanel.setLayout(null);

		JLabel lblStaticTitle = new JLabel("Title");
		lblStaticTitle.setFont(new Font("Dialog", Font.BOLD, 18));
		lblStaticTitle.setBounds(12, 27, 103, 15);
		topPanel.add(lblStaticTitle);

		textFieldMovieTitle = new JTextField();
		textFieldMovieTitle.setBounds(72, 21, 205, 30);
		topPanel.add(textFieldMovieTitle);
		textFieldMovieTitle.setColumns(10);

		JButton btnTitleSearch = new JButton("Search");
		btnTitleSearch.setBounds(290, 20, 117, 30);
		btnTitleSearch.setBackground(new Color(205,133,63));


		btnTitleSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movies.clear();
				System.out.println(textFieldMovieTitle.getText());
				System.out.println(dbService.getMovieByTitle(textFieldMovieTitle.getText()));
				if (dbService.getMovieByTitle(textFieldMovieTitle.getText()) != null){
					movies.add(dbService.getMovieByTitle(textFieldMovieTitle.getText()));
				}
				generateMovies();
			}
		});
		topPanel.add(btnTitleSearch);
		
		JButton btnAllMovies = new JButton("All Movies");
		btnAllMovies.setBounds(1122, 12, 232, 51);
		btnAllMovies.setBackground(Color.white);
		topPanel.add(btnAllMovies);
		btnAllMovies.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				movies = dbService.getMovies();
				generateMovies();
				
			}
		});

		// advanced search panel
		JPanel advancedSearchPanel = new JPanel();
		advancedSearchPanel.setBorder(UIManager.getBorder("RootPane.frameBorder"));
		// advancedSearchPanel.setBackground(Color.BLUE);
		advancedSearchPanel.setPreferredSize(new Dimension(ADVANCED_SEARCH_PANEL_WIDTH, 100));
		getContentPane().add(advancedSearchPanel, BorderLayout.EAST);
		advancedSearchPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		advancedSearchPanel.setBackground(new Color(229,210,149));

		JPanel panelGenres = new JPanel();
		panelGenres.setBackground(new Color(229,210,149));
		advancedSearchPanel.add(panelGenres);
		panelGenres.setPreferredSize(new Dimension(ADVANCED_SEARCH_PANEL_WIDTH - 10, 125));
		panelGenres.setLayout(null);

		JPanel panelGenresTop = new JPanel();
		panelGenresTop.setBackground(UIManager.getColor("CheckBoxMenuItem.disabledForeground"));
		panelGenresTop.setBounds(0, 0, 240, 20);
		panelGenres.add(panelGenresTop);
		panelGenresTop.setLayout(null);

		JLabel lblStaticGenres = new JLabel("GENRES");
		lblStaticGenres.setBounds(105, 4, 75, 15);
		panelGenresTop.add(lblStaticGenres);
		panelGenresTop.setBackground(new Color(172,135,12));
		

		JCheckBox checkBoxGenres = new JCheckBox("");
		checkBoxGenres.setBackground(UIManager.getColor("CheckBoxMenuItem.disabledForeground"));
		checkBoxGenres.setBounds(85, 0, 21, 23);
		panelGenresTop.add(checkBoxGenres);
		checkBoxGenres.setBackground(new Color(172,135,12));

		JScrollPane scrollPaneGenres = new JScrollPane();
		scrollPaneGenres.setBounds(12, 30, 216, 90);
		panelGenres.add(scrollPaneGenres);

		JList listGenres = new JList();
		DefaultListModel<String> modelGenres = new DefaultListModel<String>();
		for (Genre g : dbService.getGenres()){
			modelGenres.addElement(g.getName());
		}
		listGenres.setModel(modelGenres);
		listGenres.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()){
					if (!checkBoxGenres.isSelected())
						checkBoxGenres.setSelected(true);
				}
				
			}
		});
		scrollPaneGenres.setViewportView(listGenres);

		JPanel panelRating = new JPanel();
		panelRating.setBackground(Color.DARK_GRAY);
		advancedSearchPanel.add(panelRating);
		panelRating.setPreferredSize(new Dimension(ADVANCED_SEARCH_PANEL_WIDTH - 10, 82));
		panelRating.setLayout(null);
		panelRating.setBackground(new Color(229,210,149));
		advancedSearchPanel.setBackground(new Color(229,210,149));

		JPanel panelImdbRatingCenter = new JPanel();
		panelImdbRatingCenter.setBounds(12, 30, 216, 20);
		panelRating.add(panelImdbRatingCenter);
		panelImdbRatingCenter.setLayout(null);
		panelImdbRatingCenter.setBackground(new Color(172,135,12));

		JLabel lblSearchImdbRating = new JLabel("0");
		lblSearchImdbRating.setBackground(UIManager.getColor("MenuBar.borderColor"));
		lblSearchImdbRating.setFont(new Font("Droid Sans Fallback", Font.BOLD, 15));
		lblSearchImdbRating.setBounds(195, -2, 21, 20);
		panelImdbRatingCenter.add(lblSearchImdbRating);
		
		JSlider sliderImdbRating = new JSlider(0, 10);
		sliderImdbRating.setBackground(Color.WHITE);
		
		
		sliderImdbRating.addChangeListener(new ChangeListener() {
			
			@Override
			public void stateChanged(ChangeEvent e) {
				lblSearchImdbRating.setText(Integer.toString(sliderImdbRating.getValue()));
			}
		});
		sliderImdbRating.setValue(0);
		sliderImdbRating.setBounds(8, 2, 185, 16);

		panelImdbRatingCenter.add(sliderImdbRating);


		JPanel panelImdbRatingBottom = new JPanel();
		panelImdbRatingBottom.setBounds(12, 51, 216, 26);
		panelRating.add(panelImdbRatingBottom);
		panelImdbRatingBottom.setLayout(null);

		JRadioButton rdbtnImdbRatingGreater = new JRadioButton("Greater");
		buttonGroupImbdRating.add(rdbtnImdbRatingGreater);
		rdbtnImdbRatingGreater.setBounds(138, 0, 80, 23);
		panelImdbRatingBottom.add(rdbtnImdbRatingGreater);
		rdbtnImdbRatingGreater.setBackground(Color.WHITE);
		

		JRadioButton rdbtnImdbRatingSmaller = new JRadioButton("Smaller");
		buttonGroupImbdRating.add(rdbtnImdbRatingSmaller);
		rdbtnImdbRatingSmaller.setBounds(0, 0, 78, 23);
		panelImdbRatingBottom.add(rdbtnImdbRatingSmaller);
		rdbtnImdbRatingSmaller.setBackground(Color.WHITE);

		JRadioButton rdbtnImdbRatingSame = new JRadioButton("Same");
		buttonGroupImbdRating.add(rdbtnImdbRatingSame);
		rdbtnImdbRatingSame.setBounds(76, 0, 64, 23);
		panelImdbRatingBottom.add(rdbtnImdbRatingSame);
		rdbtnImdbRatingSame.setBackground(Color.WHITE);
		

		JPanel panelImdbRatinTop = new JPanel();
		panelImdbRatinTop.setLayout(null);
		panelImdbRatinTop.setBackground(UIManager.getColor("Button.disabledText"));
		panelImdbRatinTop.setBounds(0, 0, 240, 20);
		panelRating.add(panelImdbRatinTop);

		JLabel lblStaticImdbRating = new JLabel("IMDB RATING");
		lblStaticImdbRating.setBounds(105, 4, 118, 15);
		panelImdbRatinTop.add(lblStaticImdbRating);

		JCheckBox checkBoxImdbRating = new JCheckBox("");
		checkBoxImdbRating.setBackground(UIManager.getColor("Button.disabledText"));
		checkBoxImdbRating.setBounds(85, 0, 21, 23);
		checkBoxImdbRating.setBackground(new Color(172,135,12));
		
		panelImdbRatinTop.add(checkBoxImdbRating);
		panelImdbRatinTop.setBackground(new Color(172,135,12));

		JPanel panelYear = new JPanel();
		panelYear.setBackground(new Color(229,210,149));
		advancedSearchPanel.add(panelYear);
		panelYear.setPreferredSize(new Dimension(ADVANCED_SEARCH_PANEL_WIDTH - 10, 96));
		panelYear.setLayout(null);

		JPanel panelYearTop = new JPanel();
		panelYearTop.setLayout(null);
		panelYearTop.setBackground(UIManager.getColor("Button.disabledText"));
		panelYearTop.setBounds(0, 0, 240, 20);
		panelYear.add(panelYearTop);

		JLabel lblStaticYear = new JLabel("YEAR");
		lblStaticYear.setBounds(105, 4, 75, 15);
		panelYearTop.add(lblStaticYear);

		JCheckBox checkBoxYear = new JCheckBox("");
		checkBoxYear.setBackground(UIManager.getColor("Button.disabledText"));
		checkBoxYear.setBounds(85, 0, 21, 23);
		checkBoxYear.setBackground(new Color(172,135,12));
		panelYearTop.add(checkBoxYear);
		panelYearTop.setBackground(new Color(172,135,12));

		JPanel panelYearCenter = new JPanel();
		panelYearCenter.setBounds(12, 30, 216, 35);
		panelYear.add(panelYearCenter);
		panelYearCenter.setLayout(null);
		panelYearCenter.setBackground(new Color(229,210,149));
		panelYear.setBackground(new Color(229,210,149));


		JComboBox comboBoxYear = new JComboBox();
		comboBoxYear.setBounds(5, 5, 204, 24);
		comboBoxYear.setBackground(Color.white);
		DefaultComboBoxModel<String> modelYear = new DefaultComboBoxModel<String>();
		for(int i = 1900; i <= 2015; i++){
			modelYear.addElement(Integer.toString(i));
		}		
		
		comboBoxYear.setModel(modelYear);
		comboBoxYear.setSelectedIndex(modelYear.getSize() - 1);
		panelYearCenter.add(comboBoxYear);

		JPanel panelYearBottom = new JPanel();
		panelYearBottom.setLayout(null);
		panelYearBottom.setBounds(12, 66, 216, 26);
		panelYear.add(panelYearBottom);

		JRadioButton radioButton = new JRadioButton("Greater");
		buttonGroupYear.add(radioButton);
		radioButton.setBounds(138, 0, 80, 23);
		panelYearBottom.add(radioButton);
		radioButton.setBackground(Color.WHITE);

		JRadioButton radioButton_1 = new JRadioButton("Smaller");
		buttonGroupYear.add(radioButton_1);
		radioButton_1.setBounds(0, 0, 78, 23);
		panelYearBottom.add(radioButton_1);
		radioButton_1.setBackground(Color.WHITE);

		JRadioButton radioButton_2 = new JRadioButton("Same");
		buttonGroupYear.add(radioButton_2);
		radioButton_2.setBounds(76, 0, 64, 23);
		panelYearBottom.add(radioButton_2);
		radioButton_2.setBackground(Color.WHITE);
		

		JPanel panelCountry = new JPanel();
		panelCountry.setBackground(new Color(229,210,149));
		advancedSearchPanel.add(panelCountry);
		panelCountry.setPreferredSize(new Dimension(ADVANCED_SEARCH_PANEL_WIDTH - 10, 125));
		panelCountry.setLayout(null);

		JPanel panelCountryTop = new JPanel();
		panelCountryTop.setLayout(null);
		panelCountryTop.setBackground(UIManager.getColor("Button.disabledText"));
		panelCountryTop.setBounds(0, 0, 240, 20);
		panelCountry.add(panelCountryTop);

		JLabel lblStaticCountries = new JLabel("COUNTRIES");
		lblStaticCountries.setBounds(105, 4, 102, 15);
		panelCountryTop.add(lblStaticCountries);
		panelCountryTop.setBackground(new Color(172,135,12));

		JCheckBox checkBoxCountries = new JCheckBox("");
		checkBoxCountries.setBackground(UIManager.getColor("Button.disabledText"));
		checkBoxCountries.setBounds(85, 0, 21, 23);
		panelCountryTop.add(checkBoxCountries);
		checkBoxCountries.setBackground(new Color(172,135,12));

		JScrollPane scrollPaneCountries = new JScrollPane();
		scrollPaneCountries.setBounds(12, 30, 216, 90);
		panelCountry.add(scrollPaneCountries);

		JList listCountries = new JList();
		DefaultListModel<String> modelCountries = new DefaultListModel<String>();
		for (Country country : dbService.getCountries()){
			modelCountries.addElement(country.getName());
			
		}
		listCountries.setModel(modelCountries);
		scrollPaneCountries.setViewportView(listCountries);

		JPanel panelLanguage = new JPanel();
		panelLanguage.setBackground(new Color(229,210,149));
		advancedSearchPanel.add(panelLanguage);
		panelLanguage.setPreferredSize(new Dimension(ADVANCED_SEARCH_PANEL_WIDTH - 10, 125));
		panelLanguage.setLayout(null);

		JPanel panelLanguageTop = new JPanel();
		panelLanguageTop.setLayout(null);
		panelLanguageTop.setBackground(UIManager.getColor("Button.disabledText"));
		panelLanguageTop.setBounds(0, 0, 240, 20);
		panelLanguage.add(panelLanguageTop);
		panelLanguageTop.setBackground(new Color(172,135,12));

		JLabel lblStaticLanguages = new JLabel("LANGUAGES");
		lblStaticLanguages.setBounds(105, 4, 103, 15);
		panelLanguageTop.add(lblStaticLanguages);

		JCheckBox checkBoxLanguage = new JCheckBox("");
		checkBoxLanguage.setBackground(UIManager.getColor("Button.disabledText"));
		checkBoxLanguage.setBounds(85, 0, 21, 23);
		panelLanguageTop.add(checkBoxLanguage);
		checkBoxLanguage.setBackground(new Color(172,135,12));

		JScrollPane scrollPaneLanguage = new JScrollPane();
		scrollPaneLanguage.setBounds(10, 28, 216, 90);
		panelLanguage.add(scrollPaneLanguage);

		JList listLanguages = new JList();
		scrollPaneLanguage.setViewportView(listLanguages);
		DefaultListModel<String> modelLanguages = new DefaultListModel<String>();
		
		for (Language language : dbService.getLanguages()){
			modelLanguages.addElement(language.getName());
			
		}
		listLanguages.setModel(modelLanguages);
		

		JButton btnAdvancedSearch = new JButton("ADVANCED SEARCH");
		btnAdvancedSearch.setPreferredSize(new Dimension(225, 45));
		btnAdvancedSearch.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if (checkBoxGenres.isSelected()){
					dbService.findMoviesByGenre(listGenres.getSelectedValues());
				}
			}
		});
		advancedSearchPanel.add(btnAdvancedSearch);
		btnAdvancedSearch.setBackground(Color.darkGray);
		btnAdvancedSearch.setForeground(Color.white);

		// center movies scorllPane
		JScrollPane scrollPaneMovies = new JScrollPane();
		contentPane.add(scrollPaneMovies, BorderLayout.CENTER);

		leftPanel = new JPanel();
		getContentPane().add(leftPanel, BorderLayout.WEST);
		leftPanel.setLayout(new BorderLayout());
		leftPanel.setBorder(UIManager.getBorder("RootPane.frameBorder"));
		leftPanel.setVisible(false);
		//leftPanel.setPreferredSize(new Dimension(550, 0));

		// panelCastInfo cast info with new thread
		panelCastInfo = new CastInfo();
		leftPanel.add(panelCastInfo, BorderLayout.WEST);
		panelCastInfo.getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideLeftPanel();
			}

		});
		
		panelCastInfo.getBtnLookMovie().addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				panelMovieInfo.setMovie(dbService.getMovieByTitle(panelCastInfo.getSelectedTitleName()));
				panelCastInfo.setVisible(false);
				panelMovieInfo.setVisible(true);
			}
		});
		
		// initial MovieInfo
		panelMovieInfo = new MovieInfo();
		leftPanel.add(panelMovieInfo, BorderLayout.CENTER);
		panelMovieInfo.getBtnExit().addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				hideLeftPanel();
			}

		});
		panelMovieInfo.getBtnLookInfo().addActionListener(new ActionListener(){

			@Override
			public void actionPerformed(ActionEvent e) {
				if (panelMovieInfo.getListActors().isSelectionEmpty() && panelMovieInfo.getListDirectors().isSelectionEmpty() && panelMovieInfo.getListWriters().isSelectionEmpty()){
					panelMovieInfo.setLblError("Please, Select a person from the cast.");
				}else{
					panelMovieInfo.setLblError("");
					panelMovieInfo.setVisible(false);
					panelCastInfo.setVisible(true);
					panelCastInfo.setPerson(dbService.getPerson(panelMovieInfo.getselectedCastName()));
					
				}
			}
			
		});
		
		// center movies panel
		moviesPanel = new JPanel();
		moviesPanel.setBackground(Color.white);
		moviesPanel.setLayout(new FlowLayout());	
		scrollPaneMovies.setViewportView(moviesPanel);
		moviesPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		moviesPanel.setPreferredSize(new Dimension(100, 50));

		
		// generate all movies panel
		generateMovies();
		
	}

	public void generateMovies(){
		moviesPanel.removeAll();
		moviesPanel.repaint();
		for (Movie m : movies) {
			JPanel moviePanel = new JPanel();
			moviePanel.setLayout(new BorderLayout());

			JPanel movieTopPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
			movieTopPanel.setPreferredSize(new Dimension(MOVIE_BOTTOMandTOP_PANEL_WIDTH, MOVIE_TOP_PANEL_HEIGHT));
			movieTopPanel.setBackground(new Color(205,133,63));

			JLabel lblImdbRating = new JLabel(Double.toString(m.getImdbRating()));
			movieTopPanel.add(lblImdbRating);
			moviePanel.add(movieTopPanel, BorderLayout.NORTH);

			
			ImageButton poster = new ImageButton(m.getImdbID(), m.getPosterLink());
			poster.addActionListener(new ActionListener(){

				@Override
				public void actionPerformed(ActionEvent e) {
					showLeftPanel();
					panelMovieInfo.setVisible(true);
					panelMovieInfo.getBtnLookInfo().setText("Look");
					panelCastInfo.setVisible(false);
					ImageButton b = (ImageButton) e.getSource();
					String selectedImdbID = b.getImdbID();
					panelMovieInfo.setMovie((dbService.getMovie(selectedImdbID)));
				}
				
			});
			
			poster.setPreferredSize(new Dimension(75, 200));
			poster.setAlignmentX(Component.CENTER_ALIGNMENT);
			moviePanel.add(poster, BorderLayout.CENTER);
			moviePanel.setBackground(new Color(245,225,193));
			moviePanel.setPreferredSize(new Dimension(130, 235));

			JPanel movieBottomPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
			movieBottomPanel.setPreferredSize(new Dimension(MOVIE_BOTTOMandTOP_PANEL_WIDTH, MOVIE_BOTTOM_PANEL_HEIGHT));
			movieBottomPanel.setBackground(MOVIE_BOTTOM_PANEL_COLOR);

			StyleContext context = new StyleContext();
			StyledDocument document = new DefaultStyledDocument(context);
			Style style = context.getStyle(StyleContext.DEFAULT_STYLE);
			StyleConstants.setAlignment(style, StyleConstants.ALIGN_CENTER);
			try {
				document.insertString(document.getLength(), m.getTitle(), style);
			} catch (BadLocationException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			JTextPane txtTitle = new JTextPane(document);
			txtTitle.setEditable(false);
			txtTitle.setPreferredSize(new Dimension(125, 40));
			movieBottomPanel.add(txtTitle);
			//txtTitle.setBackground(new Color(198,107,62));
			txtTitle.setBackground(new Color(205,133,63));

			moviePanel.add(movieBottomPanel, BorderLayout.SOUTH);
			moviesPanel.add(moviePanel);
		}
	}
	
	public void showLeftPanel() {
		leftPanel.setVisible(true);
	}

	public void hideLeftPanel() {
		leftPanel.setVisible(false);
	}
}