package nqueens;

import java.util.List;

import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 * 
 * @author LlinksRechts
 * Represents a window that shows a solution to the n-queens-problem
 */
public class ResultWindow extends Stage {
	
	private List<Chessboard> otherBoards;

	public ResultWindow(List<Chessboard> otherBoards) {
		this.otherBoards = otherBoards;
	}

	public ResultWindow(StageStyle arg0) {
		super(arg0);
	}

}
