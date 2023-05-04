package View;

import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.plaf.basic.BasicInternalFrameUI;
import javax.swing.JDesktopPane;

public class ControlFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private JDesktopPane desktopPane;

	/**
	 * Create the frame.
	 */
	public ControlFrame() {
        setBounds(0, 0, 1920, 1080);
        desktopPane = new JDesktopPane();
        desktopPane.setBorder(null);
        setUndecorated(true);
        desktopPane.setLayout(null);
        setLocationRelativeTo(null);
        setContentPane(desktopPane);
	}
	
	public void setDesktopPane(JInternalFrame frame){
		BasicInternalFrameUI bi = (BasicInternalFrameUI)frame.getUI();
		bi.setNorthPane(null);
		desktopPane.add(frame);
		desktopPane.repaint();
		frame.setVisible(true);
	}
	
	public JDesktopPane getDesktopPane(){
		return desktopPane;
	}
}
