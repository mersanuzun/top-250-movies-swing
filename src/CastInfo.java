import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.MatteBorder;
import javax.swing.table.DefaultTableModel;

import model.Movie;
import model.Person;

public class CastInfo extends JPanel{
	private Poster castPhoto;
	private JLabel lblBirthDate;
	private JLabel lblBirthPlace;
	private JLabel lblHeight;
	private JTable tableMovies;
	private DefaultTableModel modelTable;
	private JEditorPane txtpnBiography;
	private JButton btnExit;
	private JLabel lblCastName;
	private JLabel lblCastRole;
	private String selectedMovieTitle;
	private JButton btnLookMovie;
	

	public CastInfo(){

		setLayout(new BorderLayout(0, 0));
		JPanel panelPoster = new JPanel();
		setVisible(false);
		add(panelPoster, BorderLayout.WEST);
		panelPoster.setPreferredSize(new Dimension(204, 1));
		panelPoster.setLayout(null);
		panelPoster.setBackground(Color.white);

		castPhoto = new Poster();
		castPhoto.setBounds(12, 12, 180, 258);
		panelPoster.add(castPhoto);
		
		JLabel lblStaticBirthDate = new JLabel("Date of Birth :");
		lblStaticBirthDate.setBounds(12, 292, 104, 15);
		panelPoster.add(lblStaticBirthDate);
		
		JLabel label = new JLabel("________________");
		label.setBounds(12, 292, 109, 15);
		panelPoster.add(label);
		
		lblBirthDate = new JLabel();
		lblBirthDate.setBounds(12, 319, 130, 15);
		panelPoster.add(lblBirthDate);
		
		JLabel lblStaticBirthPlace = new JLabel("Place of Birth :");
		lblStaticBirthPlace.setBounds(12, 350, 142, 15);
		panelPoster.add(lblStaticBirthPlace);
		
		lblBirthPlace = new JLabel();
		lblBirthPlace.setBounds(12, 377, 180, 22);
		panelPoster.add(lblBirthPlace);
		
		JLabel label_1 = new JLabel("_________________");
		label_1.setBounds(12, 350, 109, 15);
		panelPoster.add(label_1);
		
		JLabel lblStaticHeight = new JLabel("Height : ");
		lblStaticHeight.setBounds(12, 412, 70, 15);
		panelPoster.add(lblStaticHeight);
		
		JLabel label_4 = new JLabel("_________");
		label_4.setBounds(12, 413, 109, 15);
		panelPoster.add(label_4);
		
		lblHeight = new JLabel();
		lblHeight.setBounds(12, 439, 70, 15);
		panelPoster.add(lblHeight);

		JPanel panelCenter = new JPanel();
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setLayout(null);
		panelCenter.setBackground(new Color(229, 210, 149));
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(12, 244, 312, 150);
		panelCenter.add(scrollPane);
		
		tableMovies = new JTable();
		tableMovies.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		scrollPane.setViewportView(tableMovies);
		String[] columnNames = {"Movie", "Year","Imdb Point"};
		tableMovies.setBackground(Color.white);
		
		modelTable = new DefaultTableModel();
		for(String columnName : columnNames){
			modelTable.addColumn(columnName);
		}
		tableMovies.setModel(modelTable);
	
		tableMovies.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				selectedMovieTitle = tableMovies.getModel().getValueAt(tableMovies.getSelectedRow(), 0).toString();
				btnLookMovie.setText("Look " + selectedMovieTitle );
			}
		});
		
		
		JScrollPane scrollPaneBio = new JScrollPane();
		scrollPaneBio.setVerticalScrollBarPolicy(
				   ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED); 
		scrollPaneBio.setBounds(12, 45, 312, 155);
		panelCenter.add(scrollPaneBio);
		scrollPaneBio.setBackground(new Color(204, 204, 153));
		scrollPaneBio.setBackground(Color.red);
		
		txtpnBiography = new JEditorPane();
		txtpnBiography.setEditable(false);
		txtpnBiography.setPreferredSize(new Dimension(312,155));
		txtpnBiography.setMinimumSize(new Dimension(10, 10));
		scrollPaneBio.setViewportView(txtpnBiography);
		txtpnBiography.setBackground(Color.white);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_1.setBounds(12, 210, 312, 29);
		panelCenter.add(panel_1);
		panel_1.setBackground(Color.white);

		
		
		JLabel lblFilmography = new JLabel("Filmography");
		lblFilmography.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_1.add(lblFilmography);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(0, 0, 0)));
		panel_2.setBounds(12, 12, 312, 29);
		panelCenter.add(panel_2);
		
		JLabel labelBio = new JLabel("Biography");
		labelBio.setFont(new Font("Dialog", Font.BOLD, 16));
		panel_2.add(labelBio);
		panel_2.setBackground(Color.white);
		
		
		JPanel panelNorth = new JPanel();
		panelNorth.setPreferredSize(new Dimension(550, 40));
		panelNorth.setBackground(Color.GREEN);
		add(panelNorth, BorderLayout.NORTH);
		
		lblCastName = new JLabel();
		lblCastName.setFont(new Font("Dialog", Font.BOLD, 22));
		panelNorth.add(lblCastName);
		
		JLabel label_2 = new JLabel("(");
		panelNorth.add(label_2);
		
		lblCastRole = new JLabel();
		lblCastRole.setFont(new Font("Dialog", Font.BOLD, 15));
		panelNorth.add(lblCastRole);
		
		JLabel label_3 = new JLabel(")");
		panelNorth.add(label_3);
		panelNorth.setBackground(new Color(186,131,3));

		JPanel panelSouth = new JPanel();
		add(panelSouth, BorderLayout.SOUTH);
		panelSouth.setBackground(new Color(102, 102, 51));
		panelSouth.setPreferredSize(new Dimension(155, 40));
		panelSouth.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		btnLookMovie = new JButton("Look Movie");
		btnLookMovie.setBackground(new Color(57,70,65));
		btnLookMovie.setForeground(Color.white);


		btnLookMovie.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int row = tableMovies.getSelectedRow();
				System.out.println(tableMovies.getModel().getValueAt(row, 0));
			}
		});
		
		btnLookMovie.setBounds(12, 409, 312, 42);
		panelCenter.add(btnLookMovie);
		
		btnExit = new JButton("Exit");
		btnExit.setPreferredSize(new Dimension(200, 30));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 12));
		btnExit.setForeground(Color.WHITE);
		panelSouth.add(btnExit);
		panelSouth.setBackground(new Color(186,131,3));
		btnExit.setBackground(new Color(165, 42, 42));
	}
	
	public void setPerson(Person person){
		this.setLblCastName(person.getName());
		this.setLblCastRole(person.getRole());
		this.setLblBirthPlace(person.getbirthPlace());
		this.setLblBirthDate(person.getBirthDay());
		this.setLblHeight(Integer.toString(person.getHeight()) + " cm");
		this.setTxtpnBiography(person.getBiography());

		if (modelTable.getRowCount() > 0){
			for(int i = 0; i < modelTable.getRowCount(); i++){
				System.out.println("sildi");
				modelTable.removeRow(i);
				
			}
		}
		
		for(Movie m : person.getOwnMovies()){
			modelTable.addRow(new String[]{m.getTitle(), m.getReleasedDate(), Double.toString(m.getImdbRating())});
		}
		castPhoto.setPosterLink(person.getPosterLink());
	}

	public JLabel getLblCastRole() {
		return lblCastRole;
	}

	public void setLblCastRole(String castRole) {
		this.lblCastRole.setText(castRole);
	}

	public JLabel getLblCastName() {
		return lblCastName;
	}

	public void setLblCastName(String castName) {
		this.lblCastName.setText(castName);
	}

	public JPanel getCastPhoto() {
		return castPhoto;
	}

	public JLabel getLblBirthDate() {
		return lblBirthDate;
	}

	public void setLblBirthDate(String lblBirthDate) {
		this.lblBirthDate.setText(lblBirthDate);
	}

	public JLabel getLblBirthPlace() {
		return lblBirthPlace;
	}

	public void setLblBirthPlace(String lblBirthPlace) {
		this.lblBirthPlace.setText(lblBirthPlace);
	}

	public JLabel getLblHeight() {
		return lblHeight;
	}

	public void setLblHeight(String lblHeight) {
		this.lblHeight.setText(lblHeight);
	}

	public DefaultTableModel getModel() {
		return modelTable;
	}

	public void setMovies(ArrayList<Movie> movies) {
		this.modelTable = modelTable;
	}

	public JEditorPane getTxtpnBiography() {
		return txtpnBiography;
	}

	public void setTxtpnBiography(String txtpnBiography) {
		this.txtpnBiography.setText(txtpnBiography);
	}
	
	public JButton getBtnExit(){
		return this.btnExit;
	}
	
	public JButton getBtnLookMovie() {
		return btnLookMovie;
	}
	
	public String getSelectedTitleName(){
		return this.selectedMovieTitle;
	}
	
}
