

import java.awt.Font;
import java.awt.Image;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;

public class ResultList extends SnippetInfo {
	public static JPanel resultPanel = new JPanel();
	JLabel label;
	JLabel titleLabel;
	ImageIcon icon;
	JLabel imageLabel;
	JLabel keywordsLabel;
	JScrollBar scrollBar;
	public static JScrollPane scrollPane;
	
	
	public ResultList() {
		resultPanel.setLayout(new BoxLayout(resultPanel, BoxLayout.PAGE_AXIS));
		
		//Scroll Bar
		scrollPane = new JScrollPane(resultPanel);
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		scrollPane.setEnabled(true);
		scrollPane.setVisible(true);
		
		//Top Label:
		label = new JLabel("Best Results: ");
		label.setFont(new Font("Courier", Font.BOLD, 18));
		resultPanel.add(label);
		
		int i = 1;
		
		ArrayList<SnippetInfo> snippets = SnippetInfo.SnippetInit();
		
		for(SnippetInfo snippet : snippets) {
			
			//Title
			String title = snippet.title;
			titleLabel = new JLabel(i + ". " + title);
			titleLabel.setFont(new Font("Courier", Font.BOLD, 18));
			resultPanel.add(titleLabel);
			
			//Image
			Image img = snippet.img;
			icon = new ImageIcon(img.getScaledInstance(200, 200, snippet.img.SCALE_REPLICATE));
			imageLabel = new JLabel(icon);
			resultPanel.add(imageLabel);
			
			//Keywords
			String listKeywords = String.join(", ", snippet.keywords);
			keywordsLabel = new JLabel("Keywords: " + listKeywords);
			keywordsLabel.setFont(new Font("Courier", Font.BOLD + Font.ITALIC, 14));
			resultPanel.add(keywordsLabel);
			
			i++;
		}
		
		resultPanel.setVisible(false);
	}
}