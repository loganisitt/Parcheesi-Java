/**
 * 
 * @author Logan Isitt
 *
 */

public class Parcheesi {

	public Parcheesi() {
		
		Model model = new Model();
		View view = new View();
		
		Controller controller = new Controller(model ,view);
	}
}
