import controller.Controller1;
import view.MainFrame;
import model.Model;


public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Model model=new Model();
		MainFrame frame=new MainFrame("MVC",model);
		frame.showFrame();
		Controller1 controller=new Controller1(model,frame);
	}

}
