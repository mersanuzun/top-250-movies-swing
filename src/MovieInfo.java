import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.ButtonGroup;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ListModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import model.DBService;
import model.Genre;
import model.Movie;
import model.Person;

public class MovieInfo extends JPanel{
	private JLabel lblMovieTitle;
	private JButton btnExit;
	private JButton btnGoTrailer;
	private JLabel lblImdbRating;
	private JLabel lblImdbVotes;
	private JEditorPane textAreaPlot;
	private JButton btnLookInfo;
	private JLabel lblReleasedDate;
	private JLabel lblRuntime;
	private JLabel lblGenres;
	private JList<String> listActors;
	private JList<String> listDirectors;
	private JList<String> listWriters;
	private JPanel panelWest;
	private Poster poster;
	private DefaultListModel<String> actorsModel = new DefaultListModel<String>();
	private DefaultListModel<String> writersModel = new DefaultListModel<String>();
	private DefaultListModel<String> directorsModel = new DefaultListModel<String>();
	private JLabel lblError;
	private String selectedCastName;
	
	public MovieInfo(){
		setVisible(false);
		setBackground(Color.LIGHT_GRAY);
		setLayout(new BorderLayout(0, 0));
		JPanel panelTitle = new JPanel();
		panelTitle.setBackground(new Color(102, 102, 51));
		panelTitle.setPreferredSize(new Dimension(550, 40));
		add(panelTitle, BorderLayout.NORTH);
		panelTitle.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		lblMovieTitle = new JLabel("The Prestige");
		lblMovieTitle.setForeground(new Color(255, 204, 255));
		lblMovieTitle.setFont(new Font("Dialog", Font.BOLD, 21));
		panelTitle.add(lblMovieTitle);
		panelTitle.setBackground(new Color(186,131,3));
		
		
		lblMovieTitle.setText("werasad");
		lblMovieTitle.setForeground(Color.BLACK);
		
		panelWest = new JPanel();
		add(panelWest, BorderLayout.WEST);
		panelWest.setBackground(Color.white);
		panelWest.setPreferredSize(new Dimension(160, 100));
		panelWest.setLayout(null);
		
		//poster
		poster = new Poster();
		poster.setBounds(0, 1, 159, 243);
		panelWest.add(poster);
		
		JPanel panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(new Color(102, 102, 51));
		panelSouth.setPreferredSize(new Dimension(155, 40));
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		panelSouth.setBackground(new Color(186,131,3));
		
		btnExit = new JButton("Exit");
		btnExit.setPreferredSize(new Dimension(200,30));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setForeground(Color.WHITE);
		panelSouth.add(btnExit);
		btnExit.setBackground(new Color(165, 42, 42));
		
		
		btnGoTrailer = new JButton("Watch Trailer");
		btnGoTrailer.setBackground(new Color(57,70,65));

		btnGoTrailer.setBounds(0, 250, 159, 32);
		panelWest.add(btnGoTrailer);
		panelTitle.setBackground(new Color(186,131,3));
		btnGoTrailer.setBackground(new Color(57,70,65));
		btnGoTrailer.setForeground(Color.white);
		

		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBackground(new Color(229, 210, 149));
		panelCenter.setLayout(null);
		
		JLabel lblStaticStar = new JLabel("");
		lblStaticStar.setIcon(new ImageIcon("images/star.png"));
		lblStaticStar.setBounds(13, 45, 60, 55);
		panelCenter.add(lblStaticStar);
		
		lblImdbRating = new JLabel("8.0");
		lblImdbRating.setFont(new Font("Dialog", Font.BOLD, 25));
		lblImdbRating.setBounds(85, 60, 48, 20);
		panelCenter.add(lblImdbRating);
		
		JLabel lblRatingFromUsers = new JLabel("Rating from users");
		lblRatingFromUsers.setBounds(4, 112, 134, 16);
		panelCenter.add(lblRatingFromUsers);
		
		lblImdbVotes = new JLabel("9,999,999");
		lblImdbVotes.setBounds(147, 112, 121, 16);
		panelCenter.add(lblImdbVotes);
		
		JLabel label_4 = new JLabel("_____________________________________________________");
		label_4.setBounds(10, 158, 380, 14);
		panelCenter.add(label_4);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(4, 140, 373, 86);
		panelCenter.add(scrollPane);
		scrollPane.setBackground(new Color(204, 204, 153));
		
		textAreaPlot = new JEditorPane();
		textAreaPlot.setEditable(false);
		scrollPane.setViewportView(textAreaPlot);
		textAreaPlot.setBackground(Color.white);
		
		btnLookInfo = new JButton("Look");
		btnLookInfo.setBounds(4, 370, 373, 40);
		panelCenter.add(btnLookInfo);
		btnLookInfo.setBackground(new Color(57,70,65));
		btnLookInfo.setForeground(Color.white);
		
		
		lblError = new JLabel();
		lblError.setForeground(new Color(165, 42, 42));
		lblError.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblError.setBounds(4, 370, 373, 103);
		panelCenter.add(lblError);
		
		JPanel panel = new JPanel();
		panel.setBounds(4, 238, 373, 20);
		panelCenter.add(panel);
		panel.setLayout(null);
		
		JLabel labelActors = new JLabel("Actors");
		labelActors.setBounds(40, 3, 60, 14);
		panel.add(labelActors);
		labelActors.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelActors.setBackground(new Color(186,131,3));
		
		JLabel labelDriectors = new JLabel("Directors");
		labelDriectors.setBounds(152, 3, 76, 14);
		panel.add(labelDriectors);
		labelDriectors.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelDriectors.setBackground(Color.white);
		
		
		JLabel labelWriters = new JLabel("Writers");
		labelWriters.setBounds(282, 3, 60, 14);
		panel.add(labelWriters);
		labelWriters.setFont(new Font("Tahoma", Font.BOLD, 12));
		labelWriters.setBackground(new Color(186,131,3));
		
		JLabel label_2 = new JLabel("|");
		label_2.setBounds(122, 3, 4, 15);
		panel.add(label_2);
		
		JLabel label_5 = new JLabel("|");
		label_5.setBounds(247, 3, 4, 15);
		panel.add(label_5);
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(new FlowLayout(FlowLayout.LEFT));
		panel_1.setBounds(4, 12, 373, 21);
		panelCenter.add(panel_1);
		
		lblReleasedDate = new JLabel("10 Dec 2009");
		panel_1.add(lblReleasedDate);
		
		JLabel label = new JLabel("|");
		panel_1.add(label);
		
		lblRuntime = new JLabel("120 Min");
		panel_1.add(lblRuntime);
		
		JLabel label_1 = new JLabel("|");
		panel_1.add(label_1);
		
		lblGenres = new JLabel("Dram, Action, Comedy");
		panel_1.add(lblGenres);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(4, 262, 373, 100);
		panelCenter.add(panel_2);
		panel_2.setLayout(null);
		
		JScrollPane scrollPaneActors = new JScrollPane();
		scrollPaneActors.setBounds(1, 0, 124, 100);
		panel_2.add(scrollPaneActors);
		
		
		listActors = new JList<String>();
		scrollPaneActors.setViewportView(listActors);
		//listActors.setForeground(new Color(204, 204, 153));
		listActors.setBackground(Color.white);
		listActors.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()){
					setLblError("");
					listWriters.clearSelection();
					listDirectors.clearSelection();
					btnLookInfo.setText("Look " + listActors.getSelectedValue());
					setselectedCastName(getListActors().getSelectedValue());
				}
			}
		});
		
		JScrollPane scrollPaneDirectors = new JScrollPane();
		scrollPaneDirectors.setBounds(125, 0, 124, 100);
		panel_2.add(scrollPaneDirectors);
		
		listDirectors = new JList<String>();
		scrollPaneDirectors.setViewportView(listDirectors);
		listDirectors.setBackground(Color.white);
		listDirectors.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()){
					setLblError("");
					listWriters.clearSelection();
					listActors.clearSelection();
					getBtnLookInfo().setText("Look " + getListDirectors().getSelectedValue());
					setselectedCastName(getListDirectors().getSelectedValue());
				}
			}
		});
		
		
		JScrollPane scrollPaneWriters = new JScrollPane();
		scrollPaneWriters.setBounds(249, 0, 124, 100);
		panel_2.add(scrollPaneWriters);
		
		listWriters = new JList();
		scrollPaneWriters.setViewportView(listWriters);
		listWriters.setBackground(Color.white);
		listWriters.addListSelectionListener(new ListSelectionListener() {
			
			@Override
			public void valueChanged(ListSelectionEvent e) {
				if (e.getValueIsAdjusting()){
					setLblError("");
					listDirectors.clearSelection();
					listActors.clearSelection();
					getBtnLookInfo().setText("Look " + getListWriters().getSelectedValue());
					setselectedCastName(getListWriters().getSelectedValue());
				}
			}
		});
		
	}
	
	public void setMovie(Movie movie){
		this.setLblError("");
		this.setLblMovieTitle(movie.getTitle());
		this.setLblRuntime(Integer.toString(movie.getRuntime()));
		this.setLblImdbRating(Double.toString(movie.getImdbRating()));
		this.setLblImdbVotes(Integer.toString(movie.getImdbVotes()));
		this.setLblReleasedDate(movie.getReleasedDate());
		ArrayList<String> genres = new ArrayList<String>();
		for(Genre g : movie.getGenres()){
			genres.add(g.getName());
		}
		this.setLblGenres(genres);
		this.setTextAreaPlot(movie.getPlot());
		this.setPoster(movie.getPosterLink());
		ArrayList<Person> actors = new ArrayList<Person>();
		ArrayList<Person> writers = new ArrayList<Person>();
		ArrayList<Person> directors = new ArrayList<Person>();
		for(Person p: movie.getCast()) {
			if (p.getRole().equalsIgnoreCase("Actor")){
				actors.add(p);
			}else if (p.getRole().equalsIgnoreCase("Writer")){
				writers.add(p);
			}else{
				directors.add(p);
			}
						
		}
		this.setListActors(actors);
		this.setListDirectors(directors);
		this.setListWriters(writers);
	}
	
	
	public void setPoster(String posterLink){
		poster.setPosterLink(posterLink);
		
	}
	public JLabel getLblMovieTitle() {
		return lblMovieTitle;
	}


	public void setLblMovieTitle(String lblMovieTitle) {
		this.lblMovieTitle.setText(lblMovieTitle);
	}


	public void setLblError(String error){
		this.lblError.setText(error);
	}
	
	public JButton getBtnExit() {
		return btnExit;
	}


	public JButton getBtnGoTrailer() {
		return btnGoTrailer;
	}

	public JLabel getLblImdbRating() {
		return lblImdbRating;
	}


	public void setLblImdbRating(String imdbRating) {
		this.lblImdbRating.setText(imdbRating);
	}


	public JLabel getLblImdbVotes() {
		return lblImdbVotes;
	}


	public void setLblImdbVotes(String imdbVotes) {
		this.lblImdbVotes.setText(imdbVotes);
	}


	public JEditorPane getTextAreaPlot() {
		return textAreaPlot;
	}


	public void setTextAreaPlot(String plot) {
		this.textAreaPlot.setText(plot);
	}


	public JButton getBtnLookInfo() {
		return btnLookInfo;
	}

	public JLabel getLblReleasedDate() {
		return lblReleasedDate;
	}


	public void setLblReleasedDate(String releasedDate) {
		this.lblReleasedDate.setText(releasedDate);
	}


	public JLabel getLblRuntime() {
		return lblRuntime;
	}


	public void setLblRuntime(String runtime) {
		this.lblRuntime.setText(runtime);
	}


	public JLabel getLblGenres() {
		return lblGenres;
	}


	
	public void setLblGenres(ArrayList<String> genres) {
		lblGenres.setText(String.join(", ", genres));
	}


	public JList<String> getListActors() {
		return listActors;
	}


	public void setListActors(ArrayList<Person> actors) {
		actorsModel.clear();
		for(Person a: actors) {
			actorsModel.addElement(a.getName());
		}
		listActors.setModel(actorsModel);
	}


	public JList<String> getListDirectors() {
		return listDirectors;
	}

	public void setListDirectors(ArrayList<Person> directors) {
		directorsModel.clear();
		for (Person d : directors){
			directorsModel.addElement(d.getName());
		}
		listDirectors.setModel(directorsModel);
	}
	
	public JList<String> getListWriters() {
		return listWriters;
	}

	public void setListWriters(ArrayList<Person> writers) {
		writersModel.clear();
		for(Person w : writers){
			writersModel.addElement(w.getName());
		}
		listWriters.setModel(writersModel);
	}


	public String getselectedCastName() {
		return selectedCastName;
	}


	public void setselectedCastName(String selectedCastName) {
		this.selectedCastName = selectedCastName;
	}

}
