package dialogControls;

import javafx.stage.Stage;
import javafx.stage.WindowEvent;
/**
 *It is the dialogForm abstract class 
 * @author pradeep
 *
 */
public abstract class dialogForm {
	
	 private Stage dialogStage;
	
	public void setDialogStage(Stage thisStage) {
	this.dialogStage = thisStage;
	}
	
	public abstract void save();
	public abstract void reset();

	void cancel() {
		close();
	}
	
	public void close() {
		dialogStage.fireEvent(new WindowEvent(dialogStage,WindowEvent.WINDOW_CLOSE_REQUEST));
		
	}

}
