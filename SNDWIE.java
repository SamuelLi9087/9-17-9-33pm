import java.awt.Font;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class SNDWIE {
	//when it won
	// if it won
	//bingoboard
	
	private int days;
	private boolean winQuestion;
	private int id;
	private int[][] board;
	private int[][] markedBoard;
	private BufferedImage bingoImages;
	public static int [][] displayCard;
	
	public SNDWIE(int id, int[][] newBoard, int[][] markedBoard) {
		this.id = id;
		board = newBoard;
		this.markedBoard = markedBoard;
		
	}
	public void setWin(int days, boolean winQuestion) {
		this.days = days;
		this.winQuestion = winQuestion;
	}
	
	public int[][] getBoard(){
		return board;
		
	}
	
	public void checkBall(int k) {
		for(int i=0;i<5;i++) {
			for(int j=0;j<5;j++) {
				if(board[i][j]==k) {
					markedBoard[i][j]=0;
				}
			}
		}
		}
	
	public void paintImage() {
		Graphics g = bingoImages.getGraphics();
		g.drawImage(cardPic,0,0,800,800,null);
		g.drawImage(cardPic,800,0,800,800,null);
		g.drawImage(cardPic,0,800,800,800,null);
		g.drawImage(cardPic,800,800,800,800,null);
		//height is 100
				//width is 32
				//heihgt 130
				//width 142
			int x = 32;
			int y = 100;
			int width = 130;
			int height = 142;
			for(int i=0;i<5;i++) {
				for(int j=0;j<5;j++) {
					if(i == 2 && j == 2) {
							
						Rectangle rect = new Rectangle(x, y, width, height);
						Font font = new Font("SANS_SERIF", Font.BOLD, 80);
						g.setFont(font);
						drawCenteredString(g, " ", rect, font);
						y+=height;
					}
						
					else 
					{
						Rectangle rect = new Rectangle(x, y, width, height);
						Font font = new Font("SANS_SERIF", Font.BOLD, 150);
						g.setFont(font);
						drawCenteredString(g, Integer.toString(displayCard[j][i]), rect, font);
						y+=height;
					}
						
						
				}
				y=132;
				x+=width;
			}
		
		
		try {
			//"C:\\Users\\slhscs218\\Downloads\\card"
			
			//String home = System.getProperty("user.home");
			//ImageIO.write(bingoImages, "png", new File(home+"/Downloads/card"));
			
			String home = System.getProperty("user.home");
			ImageIO.write(bingoImages, "PNG", new File(home+"/Downloads/card"));
		} catch(IOException e) {
			e.printStackTrace();
		}	
	}
	
	
	
	}
	

