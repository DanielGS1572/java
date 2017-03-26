package Inheritance;

public class TestShapes {

	public static void main(String[] args) {
		GameShape player = new PlayerPiece();
		TilePiece tile = new TilePiece();
		doShapes(player);
		doShapes(tile);
	}

	public static void doShapes(GameShape shape) {
		shape.displayShape();
	}
}
