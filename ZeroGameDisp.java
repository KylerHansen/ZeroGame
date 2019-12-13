import javax.swing.*;
import java.awt.event.*;

public class ZeroGameDisplay extends JPanel{
   private JFrame window = new JFrame("Zero Game");
	private ZeroGame game = new ZeroGame();
	private JLabel lblDisplay = new JLabel("Values: ");
	private JButton btnRight = new JButton(">>");
	private JButton btnLeft = new JButton("<<");
	private JButton btnFlip = new JButton("Flip It");

	public ZeroGameDisplay(){
		setLayout(null);
		lblDisplay.setBounds(20, 70, 200, 20);
		btnLeft.setBounds(20,120, 100, 20);
		btnFlip.setBounds(140, 120, 100, 20);
		btnRight.setBounds(260, 120, 100, 20);
		
		add(btnRight);
		add(btnLeft);
		add(btnFlip);
		add(lblDisplay);
      
      window.add(this);
      window.setSize(500, 300);
		window.setVisible(true);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
		btnLeft.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            game.moveLeft();
            updateGame();
         }
      });
		btnFlip.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            game.flip();
            updateGame();
         }
      });
		btnRight.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e){
            game.moveRight();
            updateGame();
         }
      });
      
      game = new ZeroGame();
      lblDisplay.setText(game.toString());
	}
	
	public void updateGame(){
		lblDisplay.setText(game.toString());
		
		if(game.inOrder()){
			btnRight.setEnabled(false);
			btnLeft.setEnabled(false);
			btnFlip.setEnabled(false);
			JOptionPane.showMessageDialog(null, "You Win");
		}
	}
   
   public static void main(String[] args) {
		new ZeroGameDisplay();
	}
}